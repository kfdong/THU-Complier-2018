package decaf.translate;

import java.util.Stack;

import decaf.tree.Tree;
import decaf.backend.OffsetCounter;
import decaf.machdesc.Intrinsic;
import decaf.symbol.Variable;
import decaf.symbol.Class;
import decaf.tac.Label;
import decaf.tac.Temp;
import decaf.type.BaseType;
import decaf.type.ClassType;
import decaf.type.Type;

public class TransPass2 extends Tree.Visitor {

	private Translater tr;

	private Temp currentThis;

	private Stack<Label> loopExits;

	public TransPass2(Translater tr) {
		this.tr = tr;
		loopExits = new Stack<Label>();
	}

	@Override
	public void visitClassDef(Tree.ClassDef classDef) {
		for (Tree f : classDef.fields) {
			f.accept(this);
		}
	}

	@Override
	public void visitMethodDef(Tree.MethodDef funcDefn) {
		if (!funcDefn.statik) {
			currentThis = ((Variable) funcDefn.symbol.getAssociatedScope()
					.lookup("this")).getTemp();
		}
		tr.beginFunc(funcDefn.symbol);
		funcDefn.body.accept(this);
		tr.endFunc();
		currentThis = null;
	}

	@Override
	public void visitTopLevel(Tree.TopLevel program) {
		for (Tree.ClassDef cd : program.classes) {
			cd.accept(this);
		}
	}

	@Override
	public void visitVarDef(Tree.VarDef varDef) {
		if (varDef.symbol.isLocalVar()) {
			Temp t = Temp.createTempI4();
			t.sym = varDef.symbol;
			varDef.symbol.setTemp(t);
		}
	}

	@Override
	public void visitBinary(Tree.Binary expr) {
		expr.left.accept(this);
		expr.right.accept(this);
		switch (expr.tag) {
		case Tree.PLUS:
			expr.val = tr.genAdd(expr.left.val, expr.right.val);
			break;
		case Tree.MINUS:
			expr.val = tr.genSub(expr.left.val, expr.right.val);
			break;
		case Tree.MUL:
			expr.val = tr.genMul(expr.left.val, expr.right.val);
			break;
		case Tree.DIV:
			tr.genCheckDiv(expr.right.val);
			expr.val = tr.genDiv(expr.left.val, expr.right.val);
			break;
		case Tree.MOD:
			tr.genCheckDiv(expr.right.val);
			expr.val = tr.genMod(expr.left.val, expr.right.val);
			break;
		case Tree.AND:
			expr.val = tr.genLAnd(expr.left.val, expr.right.val);
			break;
		case Tree.OR:
			expr.val = tr.genLOr(expr.left.val, expr.right.val);
			break;
		case Tree.LT:
			expr.val = tr.genLes(expr.left.val, expr.right.val);
			break;
		case Tree.LE:
			expr.val = tr.genLeq(expr.left.val, expr.right.val);
			break;
		case Tree.GT:
			expr.val = tr.genGtr(expr.left.val, expr.right.val);
			break;
		case Tree.GE:
			expr.val = tr.genGeq(expr.left.val, expr.right.val);
			break;
		case Tree.EQ:
		case Tree.NE:
			genEquNeq(expr);
			break;
		}
	}

	private void genEquNeq(Tree.Binary expr) {
		if (expr.left.type.equal(BaseType.STRING)
				|| expr.right.type.equal(BaseType.STRING)) {
			tr.genParm(expr.left.val);
			tr.genParm(expr.right.val);
			expr.val = tr.genDirectCall(Intrinsic.STRING_EQUAL.label,
					BaseType.BOOL);
			if(expr.tag == Tree.NE){
				expr.val = tr.genLNot(expr.val);
			}
		} else {
			if(expr.tag == Tree.EQ)
				expr.val = tr.genEqu(expr.left.val, expr.right.val);
			else
				expr.val = tr.genNeq(expr.left.val, expr.right.val);
		}
	}

	@Override
	public void visitAssign(Tree.Assign assign) {
		assign.left.accept(this);
		assign.expr.accept(this);
		switch (assign.left.lvKind) {
		case ARRAY_ELEMENT:
			Tree.Indexed arrayRef = (Tree.Indexed) assign.left;
			Temp esz = tr.genLoadImm4(OffsetCounter.WORD_SIZE);
			Temp t = tr.genMul(arrayRef.index.val, esz);
			Temp base = tr.genAdd(arrayRef.array.val, t);
			tr.genStore(assign.expr.val, base, 0);
			break;
		case MEMBER_VAR:
			Tree.Ident varRef = (Tree.Ident) assign.left;
			tr.genStore(assign.expr.val, varRef.owner.val, varRef.symbol
					.getOffset());
			break;
		case PARAM_VAR:
		case LOCAL_VAR:
			tr.genAssign(((Tree.Ident) assign.left).symbol.getTemp(),
					assign.expr.val);
			break;
		case VAR_VAR:
			Temp v = Temp.createTempI4();
			((Tree.Var) assign.left).symbol.setTemp(v);
			tr.genAssign(((Tree.Var) assign.left).symbol.getTemp(), assign.expr.val);
		}
	}

	@Override
	public void visitLiteral(Tree.Literal literal) {
		switch (literal.typeTag) {
		case Tree.INT:
			literal.val = tr.genLoadImm4(((Integer)literal.value).intValue());
			break;
		case Tree.BOOL:
			literal.val = tr.genLoadImm4((Boolean)(literal.value) ? 1 : 0);
			break;
		default:
			literal.val = tr.genLoadStrConst((String)literal.value);
		}
	}

	@Override
	public void visitExec(Tree.Exec exec) {
		exec.expr.accept(this);
	}

	@Override
	public void visitUnary(Tree.Unary expr) {
		expr.expr.accept(this);
		switch (expr.tag){
		case Tree.NEG:
			expr.val = tr.genNeg(expr.expr.val);
			break;
		default:
			expr.val = tr.genLNot(expr.expr.val);
		}
	}

	@Override
	public void visitNull(Tree.Null nullExpr) {
		nullExpr.val = tr.genLoadImm4(0);
	}

	@Override
	public void visitBlock(Tree.Block block) {
		for (Tree s : block.block) {
			s.accept(this);
		}
	}

	@Override
	public void visitThisExpr(Tree.ThisExpr thisExpr) {
		thisExpr.val = currentThis;
	}

	@Override
	public void visitReadIntExpr(Tree.ReadIntExpr readIntExpr) {
		readIntExpr.val = tr.genIntrinsicCall(Intrinsic.READ_INT);
	}

	@Override
	public void visitReadLineExpr(Tree.ReadLineExpr readStringExpr) {
		readStringExpr.val = tr.genIntrinsicCall(Intrinsic.READ_LINE);
	}

	@Override
	public void visitReturn(Tree.Return returnStmt) {
		if (returnStmt.expr != null) {
			returnStmt.expr.accept(this);
			tr.genReturn(returnStmt.expr.val);
		} else {
			tr.genReturn(null);
		}

	}

	@Override
	public void visitPrint(Tree.Print printStmt) {
		for (Tree.Expr r : printStmt.exprs) {
			r.accept(this);
			tr.genParm(r.val);
			if (r.type.equal(BaseType.BOOL)) {
				tr.genIntrinsicCall(Intrinsic.PRINT_BOOL);
			} else if (r.type.equal(BaseType.INT)) {
				tr.genIntrinsicCall(Intrinsic.PRINT_INT);
			} else if (r.type.equal(BaseType.STRING)) {
				tr.genIntrinsicCall(Intrinsic.PRINT_STRING);
			}
		}
	}

	@Override
	public void visitIndexed(Tree.Indexed indexed) {
		indexed.array.accept(this);
		indexed.index.accept(this);
		tr.genCheckArrayIndex(indexed.array.val, indexed.index.val);
		
		Temp esz = tr.genLoadImm4(OffsetCounter.WORD_SIZE);
		Temp t = tr.genMul(indexed.index.val, esz);
		Temp base = tr.genAdd(indexed.array.val, t);
		indexed.val = tr.genLoad(base, 0);
	}

	@Override
	public void visitIdent(Tree.Ident ident) {
		if(ident.lvKind == Tree.LValue.Kind.MEMBER_VAR){
			ident.owner.accept(this);
		}
		
		switch (ident.lvKind) {
		case MEMBER_VAR:
			ident.val = tr.genLoad(ident.owner.val, ident.symbol.getOffset());
			break;
		default:
			ident.val = ident.symbol.getTemp();
			break;
		}
	}
	
	@Override
	public void visitBreak(Tree.Break breakStmt) {
		tr.genBranch(loopExits.peek());
	}

	@Override
	public void visitCallExpr(Tree.CallExpr callExpr) {
		if (callExpr.isArrayLength) {
			callExpr.receiver.accept(this);
			callExpr.val = tr.genLoad(callExpr.receiver.val,
					-OffsetCounter.WORD_SIZE);
		} else {
			if (callExpr.receiver != null) {
				callExpr.receiver.accept(this);
			}
			for (Tree.Expr expr : callExpr.actuals) {
				expr.accept(this);
			}
			if (callExpr.receiver != null) {
				tr.genParm(callExpr.receiver.val);
			}
			for (Tree.Expr expr : callExpr.actuals) {
				tr.genParm(expr.val);
			}
			if (callExpr.receiver == null) {
				callExpr.val = tr.genDirectCall(
						callExpr.symbol.getFuncty().label, callExpr.symbol
								.getReturnType());
			} else {
				Temp vt = tr.genLoad(callExpr.receiver.val, 0);
				Temp func = tr.genLoad(vt, callExpr.symbol.getOffset());
				callExpr.val = tr.genIndirectCall(func, callExpr.symbol
						.getReturnType());
			}
		}

	}

	@Override
	public void visitForLoop(Tree.ForLoop forLoop) {
		if (forLoop.init != null) {
			forLoop.init.accept(this);
		}
		Label cond = Label.createLabel();
		Label loop = Label.createLabel();
		tr.genBranch(cond);
		tr.genMark(loop);
		if (forLoop.update != null) {
			forLoop.update.accept(this);
		}
		tr.genMark(cond);
		forLoop.condition.accept(this);
		Label exit = Label.createLabel();
		tr.genBeqz(forLoop.condition.val, exit);
		loopExits.push(exit);
		if (forLoop.loopBody != null) {
			forLoop.loopBody.accept(this);
		}
		tr.genBranch(loop);
		loopExits.pop();
		tr.genMark(exit);
	}

	@Override
	public void visitIf(Tree.If ifStmt) {
		ifStmt.condition.accept(this);
		if (ifStmt.falseBranch != null) {
			Label falseLabel = Label.createLabel();
			tr.genBeqz(ifStmt.condition.val, falseLabel);
			ifStmt.trueBranch.accept(this);
			Label exit = Label.createLabel();
			tr.genBranch(exit);
			tr.genMark(falseLabel);
			ifStmt.falseBranch.accept(this);
			tr.genMark(exit);
		} else if (ifStmt.trueBranch != null) {
			Label exit = Label.createLabel();
			tr.genBeqz(ifStmt.condition.val, exit);
			if (ifStmt.trueBranch != null) {
				ifStmt.trueBranch.accept(this);
			}
			tr.genMark(exit);
		}
	}

	@Override
	public void visitNewArray(Tree.NewArray newArray) {
		newArray.length.accept(this);
		newArray.val = tr.genNewArray(newArray.length.val, false);
	}

	@Override
	public void visitNewClass(Tree.NewClass newClass) {
		newClass.val = tr.genDirectCall(newClass.symbol.getNewFuncLabel(),
				BaseType.INT);
	}

	@Override
	public void visitWhileLoop(Tree.WhileLoop whileLoop) {
		Label loop = Label.createLabel();
		tr.genMark(loop);
		whileLoop.condition.accept(this);
		Label exit = Label.createLabel();
		tr.genBeqz(whileLoop.condition.val, exit);
		loopExits.push(exit);
		if (whileLoop.loopBody != null) {
			whileLoop.loopBody.accept(this);
		}
		tr.genBranch(loop);
		loopExits.pop();
		tr.genMark(exit);
	}

	@Override
	public void visitTypeTest(Tree.TypeTest typeTest) {
		typeTest.instance.accept(this);
		typeTest.val = tr.genInstanceof(typeTest.instance.val,
				typeTest.symbol);
	}

	@Override
	public void visitTypeCast(Tree.TypeCast typeCast) {
		typeCast.expr.accept(this);
		if (!typeCast.expr.type.compatible(typeCast.symbol.getType())) {
			tr.genClassCast(typeCast.expr.val, typeCast.symbol);
		}
		typeCast.val = typeCast.expr.val;
	}

	@Override
	public void visitGuarded(Tree.Guarded guarded) {
		if (!guarded.empty) {
			int n = guarded.elist.size();
			for (int i = 0; i < n; ++i) {
				Label next = Label.createLabel();
				guarded.elist.get(i).accept(this);
				tr.genBeqz(guarded.elist.get(i).val, next);
				guarded.slist.get(i).accept(this);
				tr.genMark(next);
			}
		}
	}

	Temp genScopy(Class sym, Temp src) {
		Temp val = tr.genDirectCall(sym.getNewFuncLabel(), BaseType.INT);
		int time = sym.getSize() / OffsetCounter.WORD_SIZE;
		Temp size = tr.genLoadImm4(sym.getSize());
		if (time != 0) {
			Temp unit = tr.genLoadImm4(OffsetCounter.WORD_SIZE);
			Label loop = Label.createLabel();
			Label exit = Label.createLabel();
			val = tr.genAdd(val, size);
			tr.genMark(loop);
			tr.genAssign(val, tr.genSub(val, unit));
			tr.genAssign(size, tr.genSub(size, unit));
			tr.genBeqz(size, exit);
			Temp tmp = tr.genLoad(tr.genAdd(src, size), 0);
			tr.genStore(tmp, val, 0);
			tr.genBranch(loop);
			tr.genMark(exit);
		}
		return val;
	}

	@Override
	public void visitScopy(Tree.Scopy scopy) {
		scopy.ident.accept(this);
		scopy.expr.accept(this);
		Class sym = ((ClassType)scopy.ident.symbol.getType()).getSymbol();
		Temp src = scopy.expr.val;
		tr.genAssign(scopy.ident.symbol.getTemp(), genScopy(sym, src));
	}

	@Override 
	public void visitDefaultAccess(Tree.DefaultAccess acc) {
		acc.array.accept(this);
		acc.index.accept(this);
		acc.val = Temp.createTempI4();
		Label bvalid = Label.createLabel();
		Label exit = Label.createLabel();
		Temp length = tr.genLoad(acc.array.val, -OffsetCounter.WORD_SIZE);
		Temp valid = tr.genLAnd(tr.genGeq(acc.index.val, tr.genLoadImm4(0)),
								tr.genLes(acc.index.val, length));
		tr.genBnez(valid, bvalid);
		acc.deflt.accept(this);
		tr.genAssign(acc.val, acc.deflt.val);
		tr.genBranch(exit);
		tr.genMark(bvalid);
		Temp esz = tr.genLoadImm4(OffsetCounter.WORD_SIZE);
		Temp t = tr.genMul(acc.index.val, esz);
		Temp base = tr.genAdd(acc.array.val, t);
		tr.genAssign(acc.val, tr.genLoad(base, 0));
		tr.genMark(exit);
	}

	@Override 
	public void visitArrayRepeat(Tree.ArrayRepeat arr) {
		arr.array.accept(this);
		arr.number.accept(this);
		Temp ret = tr.genNewArray(arr.number.val, true);
		Label loop = Label.createLabel();
		Label exit = Label.createLabel();
		Temp unit = tr.genLoadImm4(OffsetCounter.WORD_SIZE);
		Temp i = Temp.createTempI4();
		tr.genAssign(i, ret);
		Temp end = tr.genAdd(ret, tr.genMul(arr.number.val, unit));
		tr.genMark(loop);
		tr.genBeqz(tr.genLes(i, end), exit);
		if (arr.array.type.isClassType()) {
			Temp obj = genScopy(((ClassType)arr.array.type).getSymbol(), arr.array.val);
			tr.genStore(obj, i, 0);
		} else {
		tr.genStore(arr.array.val, i, 0);
		}
		tr.genAssign(i, tr.genAdd(i, unit));
		tr.genBranch(loop);
		tr.genMark(exit);
		arr.val = ret;
	}

	@Override
	public void visitForeach(Tree.Foreach foreach) {
		Temp t = Temp.createTempI4();
		t.sym = foreach.symbol;
		foreach.symbol.setTemp(t);

		foreach.range.accept(this);
		Temp unit = tr.genLoadImm4(OffsetCounter.WORD_SIZE);
		Temp length = tr.genLoad(foreach.range.val, -OffsetCounter.WORD_SIZE);
		Temp now = Temp.createTempI4();
		tr.genAssign(now, foreach.range.val);
		Temp end = tr.genAdd(foreach.range.val, tr.genMul(length, unit));
		Label loop = Label.createLabel();
		Label exit = Label.createLabel();
		Label next = Label.createLabel();
		tr.genMark(loop);
		Temp cond = tr.genLes(now, end);
		tr.genBeqz(cond, exit);
		tr.genAssign(t, tr.genLoad(now, 0));
		if (foreach.condition != null) {
			foreach.condition.accept(this);
			tr.genBeqz(foreach.condition.val, exit);
		}
		loopExits.push(exit);
		for (Tree s : foreach.block.block) {
			s.accept(this);
		}
		tr.genMark(next);
		tr.genAssign(now, tr.genAdd(now, unit));
		tr.genBranch(loop);
		loopExits.pop();
		tr.genMark(exit);
	}
}
