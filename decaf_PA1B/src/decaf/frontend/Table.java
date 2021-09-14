/* This is auto-generated source by LL1-Parser-Gen.
 * Specification file: /home/kfdong/Workspace/THU/Compliers/PA/decaf_PA1B/src/decaf/frontend/Parser.spec
 * Options: unstrict mode
 * Generated at: Wed Oct 31 21:47:59 CST 2018
 * Please do NOT modify it!
 *
 * Project repository: https://github.com/paulzfm/LL1-Parser-Gen
 * Version: special version for decaf-PA1-B
 * Author: Zhu Fengmin (Paul)
 */

package decaf.frontend;

import decaf.Location;
import decaf.tree.Tree;
import decaf.tree.Tree.*;
import java.util.*;

public class Table
 {
    public static final int eof = -1;
    public static final int eos = 0;
    
    /* tokens and symbols */
    public static final int VOID = 257; //# line 13
    public static final int BOOL = 258; //# line 13
    public static final int INT = 259; //# line 13
    public static final int STRING = 260; //# line 13
    public static final int CLASS = 261; //# line 13
    public static final int NULL = 262; //# line 14
    public static final int EXTENDS = 263; //# line 14
    public static final int THIS = 264; //# line 14
    public static final int WHILE = 265; //# line 14
    public static final int FOR = 266; //# line 14
    public static final int IF = 267; //# line 15
    public static final int ELSE = 268; //# line 15
    public static final int RETURN = 269; //# line 15
    public static final int BREAK = 270; //# line 15
    public static final int NEW = 271; //# line 15
    public static final int SCOPY = 272; //# line 16
    public static final int SEALED = 273; //# line 16
    public static final int TRIPIPE = 274; //# line 16
    public static final int VAR = 275; //# line 16
    public static final int REPEAT = 276; //# line 16
    public static final int CONCAT = 277; //# line 16
    public static final int IN = 278; //# line 16
    public static final int DEFAULT = 279; //# line 16
    public static final int FOREACH = 280; //# line 16
    public static final int LCOMP = 281; //# line 17
    public static final int RCOMP = 282; //# line 17
    public static final int PRINT = 283; //# line 18
    public static final int READ_INTEGER = 284; //# line 18
    public static final int READ_LINE = 285; //# line 18
    public static final int LITERAL = 286; //# line 19
    public static final int IDENTIFIER = 287; //# line 20
    public static final int AND = 288; //# line 20
    public static final int OR = 289; //# line 20
    public static final int STATIC = 290; //# line 20
    public static final int INSTANCEOF = 291; //# line 20
    public static final int LESS_EQUAL = 292; //# line 21
    public static final int GREATER_EQUAL = 293; //# line 21
    public static final int EQUAL = 294; //# line 21
    public static final int NOT_EQUAL = 295; //# line 21
    
    public static final int VariableDef = 296;
    public static final int ExprT5 = 297;
    public static final int AfterAC = 298;
    public static final int COMPIF = 299;
    public static final int BoundVariable = 300;
    public static final int Oper3 = 301;
    public static final int Oper6 = 302;
    public static final int VariableList = 303;
    public static final int Formals = 304;
    public static final int Oper7 = 305;
    public static final int ForeachIf = 306;
    public static final int IfSubStmt = 307;
    public static final int Expr8 = 308;
    public static final int AfterSimpleTypeExpr = 309;
    public static final int Expr41 = 310;
    public static final int Expr2 = 311;
    public static final int Oper2 = 312;
    public static final int Expr6 = 313;
    public static final int SlcDftBlock = 314;
    public static final int IfBranchStar = 315;
    public static final int BreakStmt = 316;
    public static final int ExprT2 = 317;
    public static final int StmtList = 318;
    public static final int Constant = 319;
    public static final int SubVariableList = 320;
    public static final int PrintStmt = 321;
    public static final int ConstantStar = 322;
    public static final int ForStmt = 323;
    public static final int Expr9 = 324;
    public static final int ExprT42 = 325;
    public static final int Expr1 = 326;
    public static final int ForeachStmt = 327;
    public static final int ArrayConstant = 328;
    public static final int GuardedStmt = 329;
    public static final int Oper1 = 330;
    public static final int ElseClause = 331;
    public static final int ExprT41 = 332;
    public static final int FieldList = 333;
    public static final int IfBranch = 334;
    public static final int SubExprList = 335;
    public static final int AfterParenExpr = 336;
    public static final int ClassDef = 337;
    public static final int ReturnStmt = 338;
    public static final int ExprList = 339;
    public static final int StmtBlock = 340;
    public static final int FunctionField = 341;
    public static final int AfterIdentExpr = 342;
    public static final int Program = 343;
    public static final int Expr = 344;
    public static final int Type = 345;
    public static final int Expr5 = 346;
    public static final int Expr42 = 347;
    public static final int AfterNewExpr = 348;
    public static final int Assignment = 349;
    public static final int ExtendsClause = 350;
    public static final int Oper5 = 351;
    public static final int IfGuardedStmtB1 = 352;
    public static final int DefaultBlock = 353;
    public static final int ArrayType = 354;
    public static final int IfGuardedStmt = 355;
    public static final int Expr3 = 356;
    public static final int Actuals = 357;
    public static final int Variable = 358;
    public static final int ExprT3 = 359;
    public static final int Stmt = 360;
    public static final int SimpleStmt = 361;
    public static final int SimpleType = 362;
    public static final int WhileStmt = 363;
    public static final int ExprT1 = 364;
    public static final int Expr4 = 365;
    public static final int ExprT4 = 366;
    public static final int ReturnExpr = 367;
    public static final int OCStmt = 368;
    public static final int ExprT6 = 369;
    public static final int ExprT8 = 370;
    public static final int Expr7 = 371;
    public static final int ClassList = 372;
    public static final int Oper4 = 373;
    public static final int Field = 374;
    
    /* start symbol */
    public final int start = Program;
    
    /**
      * Judge if a symbol (within valid range) is non-terminal.
      *
      * @param symbol the symbol to be judged.
      * @return true if and only if the symbol is non-terminal.
      */
        
    public boolean isNonTerminal(int symbol) {
        return symbol >= 296;
    }
    
    private final String[] allSymbols = {
        "VOID", "BOOL", "INT", "STRING", "CLASS",
        "NULL", "EXTENDS", "THIS", "WHILE", "FOR",
        "IF", "ELSE", "RETURN", "BREAK", "NEW",
        "SCOPY", "SEALED", "TRIPIPE", "VAR", "REPEAT",
        "CONCAT", "IN", "DEFAULT", "FOREACH", "LCOMP",
        "RCOMP", "PRINT", "READ_INTEGER", "READ_LINE", "LITERAL",
        "IDENTIFIER", "AND", "OR", "STATIC", "INSTANCEOF",
        "LESS_EQUAL", "GREATER_EQUAL", "EQUAL", "NOT_EQUAL", "VariableDef",
        "ExprT5", "AfterAC", "COMPIF", "BoundVariable", "Oper3",
        "Oper6", "VariableList", "Formals", "Oper7", "ForeachIf",
        "IfSubStmt", "Expr8", "AfterSimpleTypeExpr", "Expr41", "Expr2",
        "Oper2", "Expr6", "SlcDftBlock", "IfBranchStar", "BreakStmt",
        "ExprT2", "StmtList", "Constant", "SubVariableList", "PrintStmt",
        "ConstantStar", "ForStmt", "Expr9", "ExprT42", "Expr1",
        "ForeachStmt", "ArrayConstant", "GuardedStmt", "Oper1", "ElseClause",
        "ExprT41", "FieldList", "IfBranch", "SubExprList", "AfterParenExpr",
        "ClassDef", "ReturnStmt", "ExprList", "StmtBlock", "FunctionField",
        "AfterIdentExpr", "Program", "Expr", "Type", "Expr5",
        "Expr42", "AfterNewExpr", "Assignment", "ExtendsClause", "Oper5",
        "IfGuardedStmtB1", "DefaultBlock", "ArrayType", "IfGuardedStmt", "Expr3",
        "Actuals", "Variable", "ExprT3", "Stmt", "SimpleStmt",
        "SimpleType", "WhileStmt", "ExprT1", "Expr4", "ExprT4",
        "ReturnExpr", "OCStmt", "ExprT6", "ExprT8", "Expr7",
        "ClassList", "Oper4", "Field",
    };
    
    /**
      * Debugging function (pretty print).
      * Get string presentation of some token or symbol.
      *
      * @param symbol either terminal or non-terminal.
      * @return its string presentation.
      */
        
    public String name(int symbol) {
        if (symbol == eof) return "<eof>";
        if (symbol == eos) return "<eos>";
        if (symbol > 0 && symbol <= 256) return "'" + (char) symbol + "'";
        return allSymbols[symbol - 257];
    }
    
    /* begin lookahead symbols */
    private ArrayList<Set<Integer>> begin = new ArrayList<Set<Integer>>();
    private final Integer[][] beginRaw = {
        {VOID, CLASS, INT, STRING, BOOL},
        {Integer.valueOf('+'), Integer.valueOf('-'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, REPEAT, AND, IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, Integer.valueOf(']')},
        {IF, RCOMP},
        {VAR, VOID, CLASS, INT, STRING, BOOL},
        {EQUAL, NOT_EQUAL},
        {Integer.valueOf('*'), Integer.valueOf('/'), Integer.valueOf('%')},
        {VOID, CLASS, INT, STRING, BOOL},
        {VOID, CLASS, INT, STRING, BOOL, Integer.valueOf(')')},
        {Integer.valueOf('-'), Integer.valueOf('!')},
        {WHILE, Integer.valueOf(')')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf(']'), Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {AND},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf(']'), Integer.valueOf(':')},
        {TRIPIPE, Integer.valueOf('}')},
        {BREAK},
        {AND, Integer.valueOf(']'), FOR, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, IF, RCOMP, Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, IDENTIFIER, NEW, LCOMP, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{'), Integer.valueOf('}')},
        {LITERAL, NULL, Integer.valueOf('[')},
        {Integer.valueOf(','), Integer.valueOf(')')},
        {PRINT},
        {Integer.valueOf(','), Integer.valueOf(']')},
        {FOR},
        {LITERAL, NULL, Integer.valueOf('['), READ_INTEGER, READ_LINE, THIS, NEW, INSTANCEOF, Integer.valueOf('('), IDENTIFIER, LCOMP},
        {REPEAT, LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, AND, IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {FOREACH},
        {Integer.valueOf('[')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, Integer.valueOf('}')},
        {OR},
        {ELSE, PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, TRIPIPE, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, LCOMP, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {CONCAT, LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {VOID, CLASS, INT, STRING, STATIC, BOOL, Integer.valueOf('}')},
        {TRIPIPE},
        {Integer.valueOf(','), Integer.valueOf(')')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, CLASS},
        {CLASS, SEALED},
        {RETURN},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('{')},
        {Integer.valueOf('('), Integer.valueOf(';')},
        {Integer.valueOf('('), Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {CLASS, SEALED},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {VOID, CLASS, INT, STRING, BOOL},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {IDENTIFIER, VOID, CLASS, INT, STRING, BOOL},
        {Integer.valueOf('='), Integer.valueOf(';'), Integer.valueOf(')')},
        {EXTENDS, Integer.valueOf('{')},
        {Integer.valueOf('+'), Integer.valueOf('-')},
        {Integer.valueOf('('), Integer.valueOf('{')},
        {DEFAULT, Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('['), IDENTIFIER},
        {IF},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, Integer.valueOf(')')},
        {VOID, CLASS, INT, STRING, BOOL},
        {EQUAL, NOT_EQUAL, Integer.valueOf(']'), FOR, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, IF, RCOMP, Integer.valueOf(';')},
        {VOID, CLASS, INT, STRING, BOOL, Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, VAR, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), READ_INTEGER, IF, WHILE, FOR, RETURN, PRINT, BREAK, Integer.valueOf('{'), SCOPY, FOREACH},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, Integer.valueOf(';'), Integer.valueOf(')'), VAR},
        {INT, VOID, BOOL, STRING, CLASS},
        {WHILE},
        {OR, Integer.valueOf(']'), FOR, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), IF, RCOMP, Integer.valueOf(';')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {LESS_EQUAL, GREATER_EQUAL, Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf(']'), FOR, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, IF, RCOMP, Integer.valueOf(';')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER, Integer.valueOf(';')},
        {SCOPY},
        {Integer.valueOf('*'), Integer.valueOf('/'), Integer.valueOf('%'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('['), Integer.valueOf('.'), Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('-'), Integer.valueOf('!'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {CLASS, SEALED, eof, eos},
        {LESS_EQUAL, GREATER_EQUAL, Integer.valueOf('<'), Integer.valueOf('>')},
        {STATIC, VOID, CLASS, INT, STRING, BOOL},
    };
    
    /**
      * Get begin lookahead tokens for `symbol`.
      *
      * @param symbol the non-terminal.
      * @return its begin lookahead tokens.
      */
        
    public Set<Integer> beginSet(int symbol) {
        return begin.get(symbol - 296);
    }
    
    /* follow set */
    private ArrayList<Set<Integer>> follow = new ArrayList<Set<Integer>>();
    private final Integer[][] followRaw = {
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, TRIPIPE, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, LCOMP, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, REPEAT, AND, IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {RCOMP},
        {IN},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf(')')},
        {Integer.valueOf(')')},
        {READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {Integer.valueOf(')')},
        {TRIPIPE, Integer.valueOf('}')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf(']'), FOR, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, IF, RCOMP, Integer.valueOf(';')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('}')},
        {Integer.valueOf(';')},
        {Integer.valueOf(']'), FOR, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, IF, RCOMP, Integer.valueOf(';')},
        {Integer.valueOf('}')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(')')},
        {Integer.valueOf(';')},
        {Integer.valueOf(']')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, TRIPIPE, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, LCOMP, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, AND, IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf(']'), FOR, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), IF, RCOMP, Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, TRIPIPE, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, LCOMP, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('}')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, TRIPIPE, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, LCOMP, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('}')},
        {TRIPIPE, Integer.valueOf('}')},
        {Integer.valueOf(')')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {CLASS, SEALED, eof, eos},
        {Integer.valueOf(';')},
        {Integer.valueOf(')')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, TRIPIPE, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, LCOMP, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, STATIC, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {VOID, CLASS, INT, Integer.valueOf('}'), STRING, STATIC, BOOL},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {eof, eos},
        {Integer.valueOf(']'), FOR, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), IF, RCOMP, Integer.valueOf(';')},
        {IDENTIFIER},
        {LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, REPEAT, AND, IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, AND, IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf(';'), Integer.valueOf(')')},
        {Integer.valueOf('{')},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, TRIPIPE, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, LCOMP, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('.'), Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('['), Integer.valueOf('>'), Integer.valueOf('%')},
        {IDENTIFIER},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, TRIPIPE, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, LCOMP, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(']'), FOR, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, IF, RCOMP, Integer.valueOf(';')},
        {Integer.valueOf(')')},
        {Integer.valueOf(';'), Integer.valueOf(','), Integer.valueOf(')')},
        {Integer.valueOf(']'), FOR, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, IF, RCOMP, Integer.valueOf(';')},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, TRIPIPE, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, LCOMP, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(';'), Integer.valueOf(')')},
        {Integer.valueOf('['), IDENTIFIER},
        {PRINT, VOID, FOR, Integer.valueOf('!'), FOREACH, Integer.valueOf('-'), CLASS, TRIPIPE, READ_LINE, WHILE, RETURN, NULL, INT, SCOPY, Integer.valueOf('}'), IDENTIFIER, NEW, LCOMP, IF, VAR, THIS, INSTANCEOF, STRING, LITERAL, ELSE, Integer.valueOf('('), Integer.valueOf(';'), Integer.valueOf('['), BOOL, BREAK, READ_INTEGER, Integer.valueOf('{')},
        {Integer.valueOf(']'), FOR, Integer.valueOf(':'), Integer.valueOf(')'), Integer.valueOf(','), WHILE, Integer.valueOf('='), IF, RCOMP, Integer.valueOf(';')},
        {Integer.valueOf(']'), FOR, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, IF, RCOMP, Integer.valueOf(';')},
        {Integer.valueOf(']'), FOR, Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, Integer.valueOf('='), OR, AND, IF, RCOMP, Integer.valueOf(';')},
        {Integer.valueOf(';')},
        {Integer.valueOf(';')},
        {LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {Integer.valueOf('/'), LESS_EQUAL, Integer.valueOf(']'), FOR, GREATER_EQUAL, Integer.valueOf('-'), Integer.valueOf(':'), EQUAL, Integer.valueOf(')'), NOT_EQUAL, Integer.valueOf(','), WHILE, CONCAT, Integer.valueOf('='), OR, Integer.valueOf('+'), REPEAT, AND, Integer.valueOf('*'), IF, RCOMP, Integer.valueOf(';'), Integer.valueOf('<'), Integer.valueOf('>'), Integer.valueOf('%')},
        {eof, eos},
        {Integer.valueOf('!'), Integer.valueOf('-'), READ_LINE, NULL, IDENTIFIER, NEW, LCOMP, THIS, INSTANCEOF, LITERAL, Integer.valueOf('('), Integer.valueOf('['), READ_INTEGER},
        {VOID, CLASS, INT, Integer.valueOf('}'), STRING, STATIC, BOOL},
    };
    
    /**
      * Get follow set for `symbol`.
      *
      * @param symbol the non-terminal.
      * @return its follow set.
      */
        
    public Set<Integer> followSet(int symbol) {
        return follow.get(symbol - 296);
    }
    
    public Table() {
        for (int i = 0; i < 79; i++) {
            begin.add(new HashSet<>(Arrays.asList(beginRaw[i])));
            follow.add(new HashSet<>(Arrays.asList(followRaw[i])));
        }
    }
    
    /**
      * Predictive table `M` query function.
      * `query(A, a)` will return the corresponding term `M(A, a)`, i.e., the target production
      * for non-terminal `A` when the lookahead token is `a`.
      *
      * @param nonTerminal   the non-terminal.
      * @param lookahead     the lookahead symbol.
      * @return a pair `<id, right>` where `right` is the right-hand side of the target
      * production `nonTerminal -> right`, and `id` is the corresponding action id. To execute
      * such action, call `act(id, params)`.
      * If the corresponding term is undefined in the table, `null` will be returned.
      */
        
    public Map.Entry<Integer, List<Integer>> query(int nonTerminal, int lookahead) {
        switch (nonTerminal) {
            //# line 50
            case VariableDef: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(0, Arrays.asList(Variable, Integer.valueOf(';')));
                    default: return null;
                }
            }
            //# line 644
            case ExprT5: {
                switch (lookahead) {
                    case '+':
                    case '-':
                        return new AbstractMap.SimpleEntry<>(1, Arrays.asList(Oper5, Expr6, ExprT5));
                    case LESS_EQUAL:
                    case ']':
                    case FOR:
                    case GREATER_EQUAL:
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case CONCAT:
                    case '=':
                    case OR:
                    case REPEAT:
                    case AND:
                    case IF:
                    case RCOMP:
                    case ';':
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 892
            case AfterAC: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(3, Arrays.asList(Expr, ConstantStar, Integer.valueOf(']')));
                    case ']':
                        return new AbstractMap.SimpleEntry<>(4, Arrays.asList(Integer.valueOf(']')));
                    default: return null;
                }
            }
            //# line 825
            case COMPIF: {
                switch (lookahead) {
                    case IF:
                        return new AbstractMap.SimpleEntry<>(5, Arrays.asList(IF, Expr));
                    case RCOMP:
                        return new AbstractMap.SimpleEntry<>(6, Arrays.asList());
                    default: return null;
                }
            }
            //# line 260
            case BoundVariable: {
                switch (lookahead) {
                    case VAR:
                        return new AbstractMap.SimpleEntry<>(7, Arrays.asList(VAR, IDENTIFIER));
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(8, Arrays.asList(Type, IDENTIFIER));
                    default: return null;
                }
            }
            //# line 380
            case Oper3: {
                switch (lookahead) {
                    case EQUAL:
                        return new AbstractMap.SimpleEntry<>(9, Arrays.asList(EQUAL));
                    case NOT_EQUAL:
                        return new AbstractMap.SimpleEntry<>(10, Arrays.asList(NOT_EQUAL));
                    default: return null;
                }
            }
            //# line 426
            case Oper6: {
                switch (lookahead) {
                    case '*':
                        return new AbstractMap.SimpleEntry<>(11, Arrays.asList(Integer.valueOf('*')));
                    case '/':
                        return new AbstractMap.SimpleEntry<>(12, Arrays.asList(Integer.valueOf('/')));
                    case '%':
                        return new AbstractMap.SimpleEntry<>(13, Arrays.asList(Integer.valueOf('%')));
                    default: return null;
                }
            }
            //# line 170
            case VariableList: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(14, Arrays.asList(Variable, SubVariableList));
                    default: return null;
                }
            }
            //# line 160
            case Formals: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(15, Arrays.asList(VariableList));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(16, Arrays.asList());
                    default: return null;
                }
            }
            //# line 443
            case Oper7: {
                switch (lookahead) {
                    case '-':
                        return new AbstractMap.SimpleEntry<>(17, Arrays.asList(Integer.valueOf('-')));
                    case '!':
                        return new AbstractMap.SimpleEntry<>(18, Arrays.asList(Integer.valueOf('!')));
                    default: return null;
                }
            }
            //# line 271
            case ForeachIf: {
                switch (lookahead) {
                    case WHILE:
                        return new AbstractMap.SimpleEntry<>(19, Arrays.asList(WHILE, Expr));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(20, Arrays.asList());
                    default: return null;
                }
            }
            //# line 328
            case IfSubStmt: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(21, Arrays.asList(Expr, Integer.valueOf(':'), Stmt));
                    default: return null;
                }
            }
            //# line 700
            case Expr8: {
                switch (lookahead) {
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(22, Arrays.asList(Expr9, ExprT8));
                    default: return null;
                }
            }
            //# line 849
            case AfterSimpleTypeExpr: {
                switch (lookahead) {
                    case ']':
                        return new AbstractMap.SimpleEntry<>(23, Arrays.asList(Integer.valueOf(']'), Integer.valueOf('['), AfterSimpleTypeExpr));
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(24, Arrays.asList(Expr, Integer.valueOf(']')));
                    default: return null;
                }
            }
            //# line 578
            case Expr41: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(25, Arrays.asList(Expr42, ExprT41));
                    default: return null;
                }
            }
            //# line 491
            case Expr2: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(26, Arrays.asList(Expr3, ExprT2));
                    default: return null;
                }
            }
            //# line 373
            case Oper2: {
                switch (lookahead) {
                    case AND:
                        return new AbstractMap.SimpleEntry<>(27, Arrays.asList(AND));
                    default: return null;
                }
            }
            //# line 661
            case Expr6: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(28, Arrays.asList(Expr7, ExprT6));
                    default: return null;
                }
            }
            //# line 753
            case SlcDftBlock: {
                switch (lookahead) {
                    case ']':
                        return new AbstractMap.SimpleEntry<>(29, Arrays.asList(Integer.valueOf(']'), DefaultBlock));
                    case ':':
                        return new AbstractMap.SimpleEntry<>(30, Arrays.asList(Integer.valueOf(':'), Expr, Integer.valueOf(']')));
                    default: return null;
                }
            }
            //# line 308
            case IfBranchStar: {
                switch (lookahead) {
                    case TRIPIPE:
                        return new AbstractMap.SimpleEntry<>(31, Arrays.asList(IfBranch, IfBranchStar));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(32, Arrays.asList());
                    default: return null;
                }
            }
            //# line 957
            case BreakStmt: {
                switch (lookahead) {
                    case BREAK:
                        return new AbstractMap.SimpleEntry<>(33, Arrays.asList(BREAK));
                    default: return null;
                }
            }
            //# line 503
            case ExprT2: {
                switch (lookahead) {
                    case AND:
                        return new AbstractMap.SimpleEntry<>(34, Arrays.asList(Oper2, Expr3, ExprT2));
                    case ']':
                    case FOR:
                    case ':':
                    case ')':
                    case ',':
                    case WHILE:
                    case '=':
                    case OR:
                    case IF:
                    case RCOMP:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 197
            case StmtList: {
                switch (lookahead) {
                    case PRINT:
                    case VOID:
                    case FOR:
                    case '!':
                    case FOREACH:
                    case '-':
                    case CLASS:
                    case READ_LINE:
                    case WHILE:
                    case RETURN:
                    case NULL:
                    case INT:
                    case SCOPY:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case IF:
                    case VAR:
                    case THIS:
                    case INSTANCEOF:
                    case STRING:
                    case LITERAL:
                    case '(':
                    case ';':
                    case '[':
                    case BOOL:
                    case BREAK:
                    case READ_INTEGER:
                    case '{':
                        return new AbstractMap.SimpleEntry<>(36, Arrays.asList(Stmt, StmtList));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 873
            case Constant: {
                switch (lookahead) {
                    case LITERAL:
                        return new AbstractMap.SimpleEntry<>(38, Arrays.asList(LITERAL));
                    case NULL:
                        return new AbstractMap.SimpleEntry<>(39, Arrays.asList(NULL));
                    case '[':
                        return new AbstractMap.SimpleEntry<>(40, Arrays.asList(ArrayConstant));
                    default: return null;
                }
            }
            //# line 180
            case SubVariableList: {
                switch (lookahead) {
                    case ',':
                        return new AbstractMap.SimpleEntry<>(41, Arrays.asList(Integer.valueOf(','), Variable, SubVariableList));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 985
            case PrintStmt: {
                switch (lookahead) {
                    case PRINT:
                        return new AbstractMap.SimpleEntry<>(43, Arrays.asList(PRINT, Integer.valueOf('('), ExprList, Integer.valueOf(')')));
                    default: return null;
                }
            }
            //# line 904
            case ConstantStar: {
                switch (lookahead) {
                    case ',':
                        return new AbstractMap.SimpleEntry<>(44, Arrays.asList(Integer.valueOf(','), Constant, ConstantStar));
                    case ']':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 951
            case ForStmt: {
                switch (lookahead) {
                    case FOR:
                        return new AbstractMap.SimpleEntry<>(46, Arrays.asList(FOR, Integer.valueOf('('), SimpleStmt, Integer.valueOf(';'), Expr, Integer.valueOf(';'), SimpleStmt, Integer.valueOf(')'), Stmt));
                    default: return null;
                }
            }
            //# line 779
            case Expr9: {
                switch (lookahead) {
                    case LITERAL:
                    case NULL:
                    case '[':
                        return new AbstractMap.SimpleEntry<>(47, Arrays.asList(Constant));
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(48, Arrays.asList(READ_INTEGER, Integer.valueOf('('), Integer.valueOf(')')));
                    case READ_LINE:
                        return new AbstractMap.SimpleEntry<>(49, Arrays.asList(READ_LINE, Integer.valueOf('('), Integer.valueOf(')')));
                    case THIS:
                        return new AbstractMap.SimpleEntry<>(50, Arrays.asList(THIS));
                    case NEW:
                        return new AbstractMap.SimpleEntry<>(51, Arrays.asList(NEW, AfterNewExpr));
                    case INSTANCEOF:
                        return new AbstractMap.SimpleEntry<>(52, Arrays.asList(INSTANCEOF, Integer.valueOf('('), Expr, Integer.valueOf(','), IDENTIFIER, Integer.valueOf(')')));
                    case '(':
                        return new AbstractMap.SimpleEntry<>(53, Arrays.asList(Integer.valueOf('('), AfterParenExpr));
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(54, Arrays.asList(IDENTIFIER, AfterIdentExpr));
                    case LCOMP:
                        return new AbstractMap.SimpleEntry<>(55, Arrays.asList(LCOMP, Expr, FOR, IDENTIFIER, IN, Expr, COMPIF, RCOMP));
                    default: return null;
                }
            }
            //# line 618
            case ExprT42: {
                switch (lookahead) {
                    case REPEAT:
                        return new AbstractMap.SimpleEntry<>(56, Arrays.asList(REPEAT, Expr5, ExprT42));
                    case LESS_EQUAL:
                    case ']':
                    case FOR:
                    case GREATER_EQUAL:
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case CONCAT:
                    case '=':
                    case OR:
                    case AND:
                    case IF:
                    case RCOMP:
                    case ';':
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 462
            case Expr1: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(58, Arrays.asList(Expr2, ExprT1));
                    default: return null;
                }
            }
            //# line 255
            case ForeachStmt: {
                switch (lookahead) {
                    case FOREACH:
                        return new AbstractMap.SimpleEntry<>(59, Arrays.asList(FOREACH, Integer.valueOf('('), BoundVariable, IN, Expr, ForeachIf, Integer.valueOf(')'), Stmt));
                    default: return null;
                }
            }
            //# line 887
            case ArrayConstant: {
                switch (lookahead) {
                    case '[':
                        return new AbstractMap.SimpleEntry<>(60, Arrays.asList(Integer.valueOf('['), AfterAC));
                    default: return null;
                }
            }
            //# line 298
            case GuardedStmt: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(61, Arrays.asList(IfSubStmt, IfBranchStar));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(62, Arrays.asList());
                    default: return null;
                }
            }
            //# line 366
            case Oper1: {
                switch (lookahead) {
                    case OR:
                        return new AbstractMap.SimpleEntry<>(63, Arrays.asList(OR));
                    default: return null;
                }
            }
            //# line 963
            case ElseClause: {
                switch (lookahead) {
                    case ELSE:
                        return new AbstractMap.SimpleEntry<>(64, Arrays.asList(ELSE, Stmt));
                    case PRINT:
                    case VOID:
                    case FOR:
                    case '!':
                    case FOREACH:
                    case '-':
                    case CLASS:
                    case TRIPIPE:
                    case READ_LINE:
                    case WHILE:
                    case RETURN:
                    case NULL:
                    case INT:
                    case SCOPY:
                    case '}':
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case IF:
                    case VAR:
                    case THIS:
                    case INSTANCEOF:
                    case STRING:
                    case LITERAL:
                    case '(':
                    case ';':
                    case '[':
                    case BOOL:
                    case BREAK:
                    case READ_INTEGER:
                    case '{':
                        return new AbstractMap.SimpleEntry<>(65, Arrays.asList());
                    default: return null;
                }
            }
            //# line 593
            case ExprT41: {
                switch (lookahead) {
                    case CONCAT:
                        return new AbstractMap.SimpleEntry<>(66, Arrays.asList(CONCAT, Expr42, ExprT41));
                    case LESS_EQUAL:
                    case ']':
                    case FOR:
                    case GREATER_EQUAL:
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case '=':
                    case OR:
                    case AND:
                    case IF:
                    case RCOMP:
                    case ';':
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 120
            case FieldList: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case STATIC:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(68, Arrays.asList(Field, FieldList));
                    case '}':
                        return new AbstractMap.SimpleEntry<>(69, Arrays.asList());
                    default: return null;
                }
            }
            //# line 322
            case IfBranch: {
                switch (lookahead) {
                    case TRIPIPE:
                        return new AbstractMap.SimpleEntry<>(70, Arrays.asList(TRIPIPE, IfSubStmt));
                    default: return null;
                }
            }
            //# line 932
            case SubExprList: {
                switch (lookahead) {
                    case ',':
                        return new AbstractMap.SimpleEntry<>(71, Arrays.asList(Integer.valueOf(','), Expr, SubExprList));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(72, Arrays.asList());
                    default: return null;
                }
            }
            //# line 861
            case AfterParenExpr: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(73, Arrays.asList(Expr, Integer.valueOf(')')));
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(74, Arrays.asList(CLASS, IDENTIFIER, Integer.valueOf(')'), Expr9));
                    default: return null;
                }
            }
            //# line 103
            case ClassDef: {
                switch (lookahead) {
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(75, Arrays.asList(CLASS, IDENTIFIER, ExtendsClause, Integer.valueOf('{'), FieldList, Integer.valueOf('}')));
                    case SEALED:
                        return new AbstractMap.SimpleEntry<>(76, Arrays.asList(SEALED, CLASS, IDENTIFIER, ExtendsClause, Integer.valueOf('{'), FieldList, Integer.valueOf('}')));
                    default: return null;
                }
            }
            //# line 972
            case ReturnStmt: {
                switch (lookahead) {
                    case RETURN:
                        return new AbstractMap.SimpleEntry<>(77, Arrays.asList(RETURN, ReturnExpr));
                    default: return null;
                }
            }
            //# line 924
            case ExprList: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(78, Arrays.asList(Expr, SubExprList));
                    default: return null;
                }
            }
            //# line 191
            case StmtBlock: {
                switch (lookahead) {
                    case '{':
                        return new AbstractMap.SimpleEntry<>(79, Arrays.asList(Integer.valueOf('{'), StmtList, Integer.valueOf('}')));
                    default: return null;
                }
            }
            //# line 152
            case FunctionField: {
                switch (lookahead) {
                    case '(':
                        return new AbstractMap.SimpleEntry<>(80, Arrays.asList(Integer.valueOf('('), Formals, Integer.valueOf(')'), StmtBlock));
                    case ';':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList(Integer.valueOf(';')));
                    default: return null;
                }
            }
            //# line 772
            case AfterIdentExpr: {
                switch (lookahead) {
                    case '(':
                        return new AbstractMap.SimpleEntry<>(82, Arrays.asList(Integer.valueOf('('), Actuals, Integer.valueOf(')')));
                    case '/':
                    case LESS_EQUAL:
                    case ']':
                    case FOR:
                    case GREATER_EQUAL:
                    case '.':
                    case '-':
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case CONCAT:
                    case '=':
                    case OR:
                    case '+':
                    case REPEAT:
                    case AND:
                    case '*':
                    case IF:
                    case RCOMP:
                    case ';':
                    case '<':
                    case '[':
                    case '>':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 28
            case Program: {
                switch (lookahead) {
                    case CLASS:
                    case SEALED:
                        return new AbstractMap.SimpleEntry<>(84, Arrays.asList(ClassDef, ClassList));
                    default: return null;
                }
            }
            //# line 456
            case Expr: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(85, Arrays.asList(Expr1));
                    default: return null;
                }
            }
            //# line 84
            case Type: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(86, Arrays.asList(SimpleType, ArrayType));
                    default: return null;
                }
            }
            //# line 632
            case Expr5: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(87, Arrays.asList(Expr6, ExprT5));
                    default: return null;
                }
            }
            //# line 607
            case Expr42: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(88, Arrays.asList(Expr5, ExprT42));
                    default: return null;
                }
            }
            //# line 835
            case AfterNewExpr: {
                switch (lookahead) {
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(89, Arrays.asList(IDENTIFIER, Integer.valueOf('('), Integer.valueOf(')')));
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(90, Arrays.asList(SimpleType, Integer.valueOf('['), AfterSimpleTypeExpr));
                    default: return null;
                }
            }
            //# line 357
            case Assignment: {
                switch (lookahead) {
                    case '=':
                        return new AbstractMap.SimpleEntry<>(91, Arrays.asList(Integer.valueOf('='), Expr));
                    case ';':
                    case ')':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 113
            case ExtendsClause: {
                switch (lookahead) {
                    case EXTENDS:
                        return new AbstractMap.SimpleEntry<>(93, Arrays.asList(EXTENDS, IDENTIFIER));
                    case '{':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 414
            case Oper5: {
                switch (lookahead) {
                    case '+':
                        return new AbstractMap.SimpleEntry<>(95, Arrays.asList(Integer.valueOf('+')));
                    case '-':
                        return new AbstractMap.SimpleEntry<>(96, Arrays.asList(Integer.valueOf('-')));
                    default: return null;
                }
            }
            //# line 288
            case IfGuardedStmtB1: {
                switch (lookahead) {
                    case '(':
                        return new AbstractMap.SimpleEntry<>(97, Arrays.asList(Integer.valueOf('('), Expr, Integer.valueOf(')'), Stmt, ElseClause));
                    case '{':
                        return new AbstractMap.SimpleEntry<>(98, Arrays.asList(Integer.valueOf('{'), GuardedStmt, Integer.valueOf('}')));
                    default: return null;
                }
            }
            //# line 762
            case DefaultBlock: {
                switch (lookahead) {
                    case DEFAULT:
                        return new AbstractMap.SimpleEntry<>(99, Arrays.asList(DEFAULT, Expr9));
                    case '/':
                    case LESS_EQUAL:
                    case ']':
                    case FOR:
                    case GREATER_EQUAL:
                    case '.':
                    case '-':
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case CONCAT:
                    case '=':
                    case OR:
                    case '+':
                    case REPEAT:
                    case AND:
                    case '*':
                    case IF:
                    case RCOMP:
                    case ';':
                    case '<':
                    case '[':
                    case '>':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(100, Arrays.asList());
                    default: return null;
                }
            }
            //# line 93
            case ArrayType: {
                switch (lookahead) {
                    case '[':
                        return new AbstractMap.SimpleEntry<>(101, Arrays.asList(Integer.valueOf('['), Integer.valueOf(']'), ArrayType));
                    case IDENTIFIER:
                        return new AbstractMap.SimpleEntry<>(102, Arrays.asList());
                    default: return null;
                }
            }
            //# line 282
            case IfGuardedStmt: {
                switch (lookahead) {
                    case IF:
                        return new AbstractMap.SimpleEntry<>(103, Arrays.asList(IF, IfGuardedStmtB1));
                    default: return null;
                }
            }
            //# line 520
            case Expr3: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(104, Arrays.asList(Expr4, ExprT3));
                    default: return null;
                }
            }
            //# line 914
            case Actuals: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(105, Arrays.asList(ExprList));
                    case ')':
                        return new AbstractMap.SimpleEntry<>(106, Arrays.asList());
                    default: return null;
                }
            }
            //# line 56
            case Variable: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(107, Arrays.asList(Type, IDENTIFIER));
                    default: return null;
                }
            }
            //# line 532
            case ExprT3: {
                switch (lookahead) {
                    case EQUAL:
                    case NOT_EQUAL:
                        return new AbstractMap.SimpleEntry<>(108, Arrays.asList(Oper3, Expr4, ExprT3));
                    case ']':
                    case FOR:
                    case ':':
                    case ')':
                    case ',':
                    case WHILE:
                    case '=':
                    case OR:
                    case AND:
                    case IF:
                    case RCOMP:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 205
            case Stmt: {
                switch (lookahead) {
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(110, Arrays.asList(VariableDef));
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case VAR:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case ';':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(111, Arrays.asList(SimpleStmt, Integer.valueOf(';')));
                    case IF:
                        return new AbstractMap.SimpleEntry<>(112, Arrays.asList(IfGuardedStmt));
                    case WHILE:
                        return new AbstractMap.SimpleEntry<>(113, Arrays.asList(WhileStmt));
                    case FOR:
                        return new AbstractMap.SimpleEntry<>(114, Arrays.asList(ForStmt));
                    case RETURN:
                        return new AbstractMap.SimpleEntry<>(115, Arrays.asList(ReturnStmt, Integer.valueOf(';')));
                    case PRINT:
                        return new AbstractMap.SimpleEntry<>(116, Arrays.asList(PrintStmt, Integer.valueOf(';')));
                    case BREAK:
                        return new AbstractMap.SimpleEntry<>(117, Arrays.asList(BreakStmt, Integer.valueOf(';')));
                    case '{':
                        return new AbstractMap.SimpleEntry<>(118, Arrays.asList(StmtBlock));
                    case SCOPY:
                        return new AbstractMap.SimpleEntry<>(119, Arrays.asList(OCStmt, Integer.valueOf(';')));
                    case FOREACH:
                        return new AbstractMap.SimpleEntry<>(120, Arrays.asList(ForeachStmt));
                    default: return null;
                }
            }
            //# line 341
            case SimpleStmt: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(121, Arrays.asList(Expr, Assignment));
                    case ';':
                    case ')':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    case VAR:
                        return new AbstractMap.SimpleEntry<>(123, Arrays.asList(VAR, IDENTIFIER, Integer.valueOf('='), Expr));
                    default: return null;
                }
            }
            //# line 62
            case SimpleType: {
                switch (lookahead) {
                    case INT:
                        return new AbstractMap.SimpleEntry<>(124, Arrays.asList(INT));
                    case VOID:
                        return new AbstractMap.SimpleEntry<>(125, Arrays.asList(VOID));
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(126, Arrays.asList(BOOL));
                    case STRING:
                        return new AbstractMap.SimpleEntry<>(127, Arrays.asList(STRING));
                    case CLASS:
                        return new AbstractMap.SimpleEntry<>(128, Arrays.asList(CLASS, IDENTIFIER));
                    default: return null;
                }
            }
            //# line 945
            case WhileStmt: {
                switch (lookahead) {
                    case WHILE:
                        return new AbstractMap.SimpleEntry<>(129, Arrays.asList(WHILE, Integer.valueOf('('), Expr, Integer.valueOf(')'), Stmt));
                    default: return null;
                }
            }
            //# line 474
            case ExprT1: {
                switch (lookahead) {
                    case OR:
                        return new AbstractMap.SimpleEntry<>(130, Arrays.asList(Oper1, Expr2, ExprT1));
                    case ']':
                    case FOR:
                    case ':':
                    case ')':
                    case ',':
                    case WHILE:
                    case '=':
                    case IF:
                    case RCOMP:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 549
            case Expr4: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(132, Arrays.asList(Expr41, ExprT4));
                    default: return null;
                }
            }
            //# line 561
            case ExprT4: {
                switch (lookahead) {
                    case LESS_EQUAL:
                    case GREATER_EQUAL:
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(133, Arrays.asList(Oper4, Expr41, ExprT4));
                    case ']':
                    case FOR:
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case '=':
                    case OR:
                    case AND:
                    case IF:
                    case RCOMP:
                    case ';':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 978
            case ReturnExpr: {
                switch (lookahead) {
                    case '!':
                    case '-':
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(135, Arrays.asList(Expr));
                    case ';':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 335
            case OCStmt: {
                switch (lookahead) {
                    case SCOPY:
                        return new AbstractMap.SimpleEntry<>(137, Arrays.asList(SCOPY, Integer.valueOf('('), Expr, Integer.valueOf(','), Expr, Integer.valueOf(')')));
                    default: return null;
                }
            }
            //# line 673
            case ExprT6: {
                switch (lookahead) {
                    case '*':
                    case '/':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(138, Arrays.asList(Oper6, Expr7, ExprT6));
                    case LESS_EQUAL:
                    case ']':
                    case FOR:
                    case GREATER_EQUAL:
                    case '-':
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case CONCAT:
                    case '=':
                    case OR:
                    case '+':
                    case REPEAT:
                    case AND:
                    case IF:
                    case RCOMP:
                    case ';':
                    case '<':
                    case '>':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 726
            case ExprT8: {
                switch (lookahead) {
                    case '[':
                        return new AbstractMap.SimpleEntry<>(140, Arrays.asList(Integer.valueOf('['), Expr, SlcDftBlock, ExprT8));
                    case '.':
                        return new AbstractMap.SimpleEntry<>(141, Arrays.asList(Integer.valueOf('.'), IDENTIFIER, AfterIdentExpr, ExprT8));
                    case '/':
                    case LESS_EQUAL:
                    case ']':
                    case FOR:
                    case GREATER_EQUAL:
                    case '-':
                    case ':':
                    case EQUAL:
                    case ')':
                    case NOT_EQUAL:
                    case ',':
                    case WHILE:
                    case CONCAT:
                    case '=':
                    case OR:
                    case '+':
                    case REPEAT:
                    case AND:
                    case '*':
                    case IF:
                    case RCOMP:
                    case ';':
                    case '<':
                    case '>':
                    case '%':
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 690
            case Expr7: {
                switch (lookahead) {
                    case '-':
                    case '!':
                        return new AbstractMap.SimpleEntry<>(143, Arrays.asList(Oper7, Expr8));
                    case READ_LINE:
                    case NULL:
                    case IDENTIFIER:
                    case NEW:
                    case LCOMP:
                    case THIS:
                    case INSTANCEOF:
                    case LITERAL:
                    case '(':
                    case '[':
                    case READ_INTEGER:
                        return new AbstractMap.SimpleEntry<>(144, Arrays.asList(Expr8));
                    default: return null;
                }
            }
            //# line 39
            case ClassList: {
                switch (lookahead) {
                    case CLASS:
                    case SEALED:
                        return new AbstractMap.SimpleEntry<>(145, Arrays.asList(ClassDef, ClassList));
                    case eof:
                    case eos:
                        return new AbstractMap.SimpleEntry<>(146, Arrays.asList());
                    default: return null;
                }
            }
            //# line 392
            case Oper4: {
                switch (lookahead) {
                    case LESS_EQUAL:
                        return new AbstractMap.SimpleEntry<>(147, Arrays.asList(LESS_EQUAL));
                    case GREATER_EQUAL:
                        return new AbstractMap.SimpleEntry<>(148, Arrays.asList(GREATER_EQUAL));
                    case '<':
                        return new AbstractMap.SimpleEntry<>(149, Arrays.asList(Integer.valueOf('<')));
                    case '>':
                        return new AbstractMap.SimpleEntry<>(150, Arrays.asList(Integer.valueOf('>')));
                    default: return null;
                }
            }
            //# line 136
            case Field: {
                switch (lookahead) {
                    case STATIC:
                        return new AbstractMap.SimpleEntry<>(151, Arrays.asList(STATIC, Type, IDENTIFIER, Integer.valueOf('('), Formals, Integer.valueOf(')'), StmtBlock));
                    case VOID:
                    case CLASS:
                    case INT:
                    case STRING:
                    case BOOL:
                        return new AbstractMap.SimpleEntry<>(152, Arrays.asList(Type, IDENTIFIER, FunctionField));
                    default: return null;
                }
            }
            default: return null;
        }
    }
    
    /**
      * Execute some user-defined semantic action on the specification file.
      * Note that `$$ = params[0], $1 = params[1], ...`. Nothing will be returned, so please
      * do not forget to store the parsed AST result in `params[0]`.
      *
      * @param id      the action id.
      * @param params  parameter array.
      */
        
    public void act(int id, SemValue[] params) {
        switch (id) {
            case 0: {
                //# line 51
                params[0].vdef = params[1].vdef;
                return;
            }
            case 1: {
                //# line 645
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 2: {
                /* no action */
                return;
            }
            case 3: {
                //# line 893
                params[0].elist = new ArrayList<Tree.Expr>();
                params[0].elist.add(params[1].expr);
                if (params[2].elist != null)
                	params[0].elist.addAll(params[2].elist);
                return;
            }
            case 4: {
                //# line 900
                params[0].elist = new ArrayList<Tree.Expr>();
                return;
            }
            case 5: {
                //# line 826
                params[0].expr = params[2].expr;
                return;
            }
            case 6: {
                //# line 830
                params[0] = new SemValue();
                return;
            }
            case 7: {
                //# line 261
                params[0].type = new Tree.TypeIdent(Tree.VAR, params[1].loc);
                params[0].ident = params[2].ident;
                return;
            }
            case 8: {
                //# line 266
                params[0].type = params[1].type;
                params[0].ident = params[2].ident;
                return;
            }
            case 9: {
                //# line 381
                params[0].counter = Tree.EQ;
                params[0].loc = params[1].loc;
                return;
            }
            case 10: {
                //# line 386
                params[0].counter = Tree.NE;
                params[0].loc = params[1].loc;
                return;
            }
            case 11: {
                //# line 427
                params[0].counter = Tree.MUL;
                params[0].loc = params[1].loc;
                return;
            }
            case 12: {
                //# line 432
                params[0].counter = Tree.DIV;
                params[0].loc = params[1].loc;
                return;
            }
            case 13: {
                //# line 437
                params[0].counter = Tree.MOD;
                params[0].loc = params[1].loc;
                return;
            }
            case 14: {
                //# line 171
                params[0].vlist = new ArrayList<VarDef>();
                params[0].vlist.add(params[1].vdef);
                if (params[2].vlist != null) {
                    params[0].vlist.addAll(params[2].vlist);
                }
                return;
            }
            case 15: {
                //# line 161
                params[0].vlist = params[1].vlist;
                return;
            }
            case 16: {
                //# line 165
                params[0].vlist = new ArrayList<VarDef>();
                return;
            }
            case 17: {
                //# line 444
                params[0].counter = Tree.NEG;
                params[0].loc = params[1].loc;
                return;
            }
            case 18: {
                //# line 449
                params[0].counter = Tree.NOT;
                params[0].loc = params[1].loc;
                return;
            }
            case 19: {
                //# line 272
                params[0].expr = params[2].expr;
                return;
            }
            case 20: {
                //# line 276
                params[0] = new SemValue();
                return;
            }
            case 21: {
                //# line 329
                params[0].expr = params[1].expr;
                params[0].stmt = params[3].stmt;
                return;
            }
            case 22: {
                //# line 701
                               params[0].expr = params[1].expr;
                               params[0].loc = params[1].loc;
                               if (params[2].vec != null) {
                                   for (SemValue v : params[2].vec) {
                                       if (v.expr != null) {
                                           if (v.slcr != null) {
                	params[0].expr = new Tree.RangeIndexed(params[0].expr, v.expr, v.slcr, params[0].loc);
                } else if (v.dft != null) {
                	params[0].expr = new Tree.DefaultAccess(params[0].expr, v.expr, v.dft, params[0].loc);
                } else {
                	params[0].expr = new Tree.Indexed(params[0].expr, v.expr, params[0].loc);
                }
                                       } else if (v.elist != null) {
                                           params[0].expr = new Tree.CallExpr(params[0].expr, v.ident, v.elist, v.loc);
                                           params[0].loc = v.loc;
                                       } else {
                                           params[0].expr = new Tree.Ident(params[0].expr, v.ident, v.loc);
                                           params[0].loc = v.loc;
                                       }
                                   }
                               }
                return;
            }
            case 23: {
                //# line 850
                params[0].expr = params[3].expr;
                params[0].counter = 1 + params[3].counter;
                return;
            }
            case 24: {
                //# line 855
                params[0].expr = params[1].expr;
                params[0].counter = 0;
                return;
            }
            case 25: {
                //# line 579
                                  if (params[2].lvec != null) {
                	int sz = params[2].evec.size();
                	params[0].expr = params[2].evec.get(sz - 1);
                                      for (int i = sz - 2; i >= 0; --i) {
                                          params[0].expr = new Tree.ArrayConcat(params[2].evec.get(i),
                                              params[0].expr, params[2].lvec.get(i + 1));
                                      }
                	params[0].expr = new Tree.ArrayConcat(params[1].expr, params[0].expr, params[2].lvec.get(0));
                                  } else {
                	params[0].expr = params[1].expr;
                }
                return;
            }
            case 26: {
                //# line 492
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 27: {
                //# line 374
                params[0].counter = Tree.AND;
                params[0].loc = params[1].loc;
                return;
            }
            case 28: {
                //# line 662
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 29: {
                //# line 754
                params[0].dft = params[2].dft;
                return;
            }
            case 30: {
                //# line 758
                params[0].slcr = params[2].expr;
                return;
            }
            case 31: {
                //# line 309
                params[0].elist = params[2].elist;
                params[0].slist = params[2].slist;
                params[0].elist.add(0, params[1].expr);
                params[0].slist.add(0, params[1].stmt);
                return;
            }
            case 32: {
                //# line 316
                params[0] = new SemValue();
                params[0].elist = new ArrayList<Expr>();
                params[0].slist = new ArrayList<Tree>();
                return;
            }
            case 33: {
                //# line 958
                params[0].stmt = new Tree.Break(params[1].loc);
                return;
            }
            case 34: {
                //# line 504
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 35: {
                /* no action */
                return;
            }
            case 36: {
                //# line 198
                params[0].slist.add(params[1].stmt);
                params[0].slist.addAll(params[2].slist);
                return;
            }
            case 37: {
                /* no action */
                return;
            }
            case 38: {
                //# line 874
                params[0].expr = new Tree.Literal(params[1].typeTag, params[1].literal, params[1].loc);
                return;
            }
            case 39: {
                //# line 878
                params[0].expr = new Null(params[1].loc);
                return;
            }
            case 40: {
                //# line 882
                params[0].expr = new Tree.ArrayConstant(params[1].elist, params[1].loc);
                return;
            }
            case 41: {
                //# line 181
                params[0].vlist = new ArrayList<VarDef>();
                params[0].vlist.add(params[2].vdef);
                if (params[3].vlist != null) {
                    params[0].vlist.addAll(params[3].vlist);
                }
                return;
            }
            case 42: {
                /* no action */
                return;
            }
            case 43: {
                //# line 986
                params[0].stmt = new Tree.Print(params[3].elist, params[1].loc);
                return;
            }
            case 44: {
                //# line 905
                params[0].elist = new ArrayList<Tree.Expr>();
                params[0].elist.add(params[2].expr);
                if (params[3].elist != null)
                	params[0].elist.addAll(params[3].elist);
                return;
            }
            case 45: {
                /* no action */
                return;
            }
            case 46: {
                //# line 952
                params[0].stmt = new Tree.ForLoop(params[3].stmt, params[5].expr, params[7].stmt, params[9].stmt, params[1].loc);
                return;
            }
            case 47: {
                //# line 780
                params[0].expr = params[1].expr;
                return;
            }
            case 48: {
                //# line 784
                params[0].expr = new Tree.ReadIntExpr(params[1].loc);
                return;
            }
            case 49: {
                //# line 788
                params[0].expr = new Tree.ReadLineExpr(params[1].loc);
                return;
            }
            case 50: {
                //# line 792
                params[0].expr = new Tree.ThisExpr(params[1].loc);
                return;
            }
            case 51: {
                //# line 796
                if (params[2].ident != null) {
                    params[0].expr = new Tree.NewClass(params[2].ident, params[1].loc);
                } else {
                    params[0].expr = new Tree.NewArray(params[2].type, params[2].expr, params[1].loc);
                }
                return;
            }
            case 52: {
                //# line 804
                params[0].expr = new Tree.TypeTest(params[3].expr, params[5].ident, params[1].loc);
                return;
            }
            case 53: {
                //# line 808
                params[0].expr = params[2].expr;
                return;
            }
            case 54: {
                //# line 812
                if (params[2].elist != null) {
                    params[0].expr = new Tree.CallExpr(null, params[1].ident, params[2].elist, params[1].loc);
                } else {
                    params[0].expr = new Tree.Ident(null, params[1].ident, params[1].loc);
                }
                return;
            }
            case 55: {
                //# line 820
                params[0].expr = new Tree.Comprehension(params[4].ident, params[6].expr, params[7].expr, params[2].expr, params[1].loc);
                return;
            }
            case 56: {
                //# line 619
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].lvec != null) {
                	params[0].lvec.addAll(params[3].lvec);
                	params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 57: {
                /* no action */
                return;
            }
            case 58: {
                //# line 463
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 59: {
                //# line 256
                params[0].stmt = new Tree.Foreach(params[3].type, params[3].ident, params[5].expr, params[6].expr, params[8].stmt, params[1].loc);
                return;
            }
            case 60: {
                //# line 888
                params[0].elist = params[2].elist;
                return;
            }
            case 61: {
                //# line 299
                params[0].stmt = new Tree.Guarded(params[2].elist, params[2].slist, params[1].expr, params[1].stmt, params[1].loc);
                return;
            }
            case 62: {
                //# line 303
                params[0].stmt = new Tree.Guarded(params[0].loc);
                return;
            }
            case 63: {
                //# line 367
                params[0].counter = Tree.OR;
                params[0].loc = params[1].loc;
                return;
            }
            case 64: {
                //# line 964
                params[0].stmt = params[2].stmt;
                return;
            }
            case 65: {
                //# line 968
                return;
            }
            case 66: {
                //# line 594
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].lvec != null) {
                	params[0].lvec.addAll(params[3].lvec);
                	params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 67: {
                /* no action */
                return;
            }
            case 68: {
                //# line 121
                params[0].flist = new ArrayList<Tree>();
                if (params[1].vdef != null) {
                    params[0].flist.add(params[1].vdef);
                } else {
                    params[0].flist.add(params[1].fdef);
                }
                params[0].flist.addAll(params[2].flist);
                return;
            }
            case 69: {
                //# line 131
                params[0].flist = new ArrayList<Tree>();
                return;
            }
            case 70: {
                //# line 323
                params[0].expr = params[2].expr;
                params[0].stmt = params[2].stmt;
                return;
            }
            case 71: {
                //# line 933
                params[0].elist = new ArrayList<Tree.Expr>();
                params[0].elist.add(params[2].expr);
                params[0].elist.addAll(params[3].elist);
                return;
            }
            case 72: {
                //# line 939
                params[0].elist = new ArrayList<Tree.Expr>();
                return;
            }
            case 73: {
                //# line 862
                params[0].expr = params[1].expr;
                return;
            }
            case 74: {
                //# line 866
                params[0].expr = new Tree.TypeCast(params[2].ident, params[4].expr, params[4].loc);
                return;
            }
            case 75: {
                //# line 104
                params[0].cdef = new Tree.ClassDef(params[2].ident, params[3].ident, params[5].flist, false, params[1].loc);
                return;
            }
            case 76: {
                //# line 108
                params[0].cdef = new Tree.ClassDef(params[3].ident, params[4].ident, params[6].flist, true, params[1].loc);
                return;
            }
            case 77: {
                //# line 973
                params[0].stmt = new Tree.Return(params[2].expr, params[1].loc);
                return;
            }
            case 78: {
                //# line 925
                params[0].elist = new ArrayList<Tree.Expr>();
                params[0].elist.add(params[1].expr);
                params[0].elist.addAll(params[2].elist);
                return;
            }
            case 79: {
                //# line 192
                params[0].stmt = new Tree.Block(params[2].slist, params[1].loc);
                return;
            }
            case 80: {
                //# line 153
                params[0].vlist = params[2].vlist;
                params[0].stmt = params[4].stmt;
                return;
            }
            case 81: {
                /* no action */
                return;
            }
            case 82: {
                //# line 773
                params[0].elist = params[2].elist;
                return;
            }
            case 83: {
                /* no action */
                return;
            }
            case 84: {
                //# line 29
                params[0].clist = new ArrayList<ClassDef>();
                params[0].clist.add(params[1].cdef);
                if (params[2].clist != null) {
                    params[0].clist.addAll(params[2].clist);
                }
                params[0].prog = new Tree.TopLevel(params[0].clist, params[0].loc);
                return;
            }
            case 85: {
                //# line 457
                params[0].expr = params[1].expr;
                return;
            }
            case 86: {
                //# line 85
                params[0].type = params[1].type;
                for (int i = 0; i < params[2].counter; ++i) {
                    params[0].type = new Tree.TypeArray(params[0].type, params[1].loc);
                }
                return;
            }
            case 87: {
                //# line 633
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 88: {
                //# line 608
                params[0].expr = params[1].expr;
                if (params[2].evec != null) {
                	for (int i = 0; i < params[2].evec.size(); ++i) {
                		params[0].expr = new Tree.ArrayRepeat(params[0].expr, 
                			params[2].evec.get(i), params[2].lvec.get(i));
                	}
                }
                return;
            }
            case 89: {
                //# line 836
                params[0].ident = params[1].ident;
                return;
            }
            case 90: {
                //# line 840
                params[0].type = params[1].type;
                for (int i = 0; i < params[3].counter; ++i) {
                    params[0].type = new Tree.TypeArray(params[0].type, params[1].loc);
                }
                params[0].expr = params[3].expr;
                return;
            }
            case 91: {
                //# line 358
                params[0].loc = params[1].loc;
                params[0].expr = params[2].expr;
                return;
            }
            case 92: {
                /* no action */
                return;
            }
            case 93: {
                //# line 114
                params[0].ident = params[2].ident;
                return;
            }
            case 94: {
                /* no action */
                return;
            }
            case 95: {
                //# line 415
                params[0].counter = Tree.PLUS;
                params[0].loc = params[1].loc;
                return;
            }
            case 96: {
                //# line 420
                params[0].counter = Tree.MINUS;
                params[0].loc = params[1].loc;
                return;
            }
            case 97: {
                //# line 289
                params[0].stmt = new Tree.If(params[2].expr, params[4].stmt, params[5].stmt, params[1].loc);
                return;
            }
            case 98: {
                //# line 293
                params[0].stmt = params[2].stmt;
                return;
            }
            case 99: {
                //# line 763
                params[0].dft = params[2].expr;
                return;
            }
            case 100: {
                //# line 767
                params[0] = new SemValue();
                return;
            }
            case 101: {
                //# line 94
                params[0].counter = 1 + params[3].counter;
                return;
            }
            case 102: {
                //# line 98
                params[0].counter = 0;
                return;
            }
            case 103: {
                //# line 283
                params[0].stmt = params[2].stmt;
                return;
            }
            case 104: {
                //# line 521
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 105: {
                //# line 915
                params[0].elist = params[1].elist;
                return;
            }
            case 106: {
                //# line 919
                params[0].elist = new ArrayList<Tree.Expr>();
                return;
            }
            case 107: {
                //# line 57
                params[0].vdef = new Tree.VarDef(params[2].ident, params[1].type, params[2].loc);
                return;
            }
            case 108: {
                //# line 533
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 109: {
                /* no action */
                return;
            }
            case 110: {
                //# line 206
                params[0].stmt = params[1].vdef;
                return;
            }
            case 111: {
                //# line 210
                if (params[1].stmt == null) {
                    params[0].stmt = new Tree.Skip(params[2].loc);
                } else {
                    params[0].stmt = params[1].stmt;
                }
                return;
            }
            case 112: {
                //# line 218
                params[0].stmt = params[1].stmt;
                return;
            }
            case 113: {
                //# line 222
                params[0].stmt = params[1].stmt;
                return;
            }
            case 114: {
                //# line 226
                params[0].stmt = params[1].stmt;
                return;
            }
            case 115: {
                //# line 230
                params[0].stmt = params[1].stmt;
                return;
            }
            case 116: {
                //# line 234
                params[0].stmt = params[1].stmt;
                return;
            }
            case 117: {
                //# line 238
                params[0].stmt = params[1].stmt;
                return;
            }
            case 118: {
                //# line 242
                params[0].stmt = params[1].stmt;
                return;
            }
            case 119: {
                //# line 246
                params[0].stmt = params[1].stmt;
                return;
            }
            case 120: {
                //# line 250
                params[0].stmt = params[1].stmt;
                return;
            }
            case 121: {
                //# line 342
                if (params[2].expr == null) {
                    params[0].stmt = new Tree.Calculate(params[1].expr, params[1].loc);
                } else {
                    params[0].stmt = new Tree.Assign(params[1].expr, params[2].expr, params[2].loc);
                }
                return;
            }
            case 122: {
                /* no action */
                return;
            }
            case 123: {
                //# line 351
                Var lval = new Tree.Var(params[2].ident, params[1].loc);
                params[0].stmt = new Tree.Assign(lval, params[4].expr, params[3].loc);
                return;
            }
            case 124: {
                //# line 63
                params[0].type = new Tree.TypeIdent(Tree.INT, params[1].loc);
                return;
            }
            case 125: {
                //# line 67
                params[0].type = new Tree.TypeIdent(Tree.VOID, params[1].loc);
                return;
            }
            case 126: {
                //# line 71
                params[0].type = new Tree.TypeIdent(Tree.BOOL, params[1].loc);
                return;
            }
            case 127: {
                //# line 75
                params[0].type = new Tree.TypeIdent(Tree.STRING, params[1].loc);
                return;
            }
            case 128: {
                //# line 79
                params[0].type = new Tree.TypeClass(params[2].ident, params[1].loc);
                return;
            }
            case 129: {
                //# line 946
                params[0].stmt = new Tree.WhileLoop(params[3].expr, params[5].stmt, params[1].loc);
                return;
            }
            case 130: {
                //# line 475
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 131: {
                /* no action */
                return;
            }
            case 132: {
                //# line 550
                params[0].expr = params[1].expr;
                if (params[2].svec != null) {
                    for (int i = 0; i < params[2].svec.size(); ++i) {
                        params[0].expr = new Tree.Binary(params[2].svec.get(i), params[0].expr,
                            params[2].evec.get(i), params[2].lvec.get(i));
                    }
                }
                return;
            }
            case 133: {
                //# line 562
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 134: {
                /* no action */
                return;
            }
            case 135: {
                //# line 979
                params[0].expr = params[1].expr;
                return;
            }
            case 136: {
                /* no action */
                return;
            }
            case 137: {
                //# line 336
                params[0].stmt = new Tree.Scopy((Tree.LValue)params[3].expr, params[5].expr, params[1].loc);
                return;
            }
            case 138: {
                //# line 674
                params[0].svec = new Vector<Integer>();
                params[0].lvec = new Vector<Location>();
                params[0].evec = new Vector<Expr>();
                params[0].svec.add(params[1].counter);
                params[0].lvec.add(params[1].loc);
                params[0].evec.add(params[2].expr);
                if (params[3].svec != null) {
                    params[0].svec.addAll(params[3].svec);
                    params[0].lvec.addAll(params[3].lvec);
                    params[0].evec.addAll(params[3].evec);
                }
                return;
            }
            case 139: {
                /* no action */
                return;
            }
            case 140: {
                //# line 727
                                  SemValue sem = new SemValue();
                                  sem.expr = params[2].expr;
                sem.slcr = params[3].slcr;
                sem.dft = params[3].dft;
                                  params[0].vec = new Vector<SemValue>();
                                  params[0].vec.add(sem);
                                  if (params[4].vec != null) {
                                      params[0].vec.addAll(params[4].vec);
                                  }
                return;
            }
            case 141: {
                //# line 739
                SemValue sem = new SemValue();
                sem.ident = params[2].ident;
                sem.loc = params[2].loc;
                sem.elist = params[3].elist;
                params[0].vec = new Vector<SemValue>();
                params[0].vec.add(sem);
                if (params[4].vec != null) {
                    params[0].vec.addAll(params[4].vec);
                }
                return;
            }
            case 142: {
                /* no action */
                return;
            }
            case 143: {
                //# line 691
                params[0].expr = new Tree.Unary(params[1].counter, params[2].expr, params[1].loc);
                return;
            }
            case 144: {
                //# line 695
                params[0].expr = params[1].expr;
                return;
            }
            case 145: {
                //# line 40
                params[0].clist = new ArrayList<ClassDef>();
                params[0].clist.add(params[1].cdef);
                if (params[2].clist != null) {
                    params[0].clist.addAll(params[2].clist);
                }
                return;
            }
            case 146: {
                /* no action */
                return;
            }
            case 147: {
                //# line 393
                params[0].counter = Tree.LE;
                params[0].loc = params[1].loc;
                return;
            }
            case 148: {
                //# line 398
                params[0].counter = Tree.GE;
                params[0].loc = params[1].loc;
                return;
            }
            case 149: {
                //# line 403
                params[0].counter = Tree.LT;
                params[0].loc = params[1].loc;
                return;
            }
            case 150: {
                //# line 408
                params[0].counter = Tree.GT;
                params[0].loc = params[1].loc;
                return;
            }
            case 151: {
                //# line 137
                params[0].fdef = new Tree.MethodDef(true, params[3].ident, params[2].type, params[5].vlist,
                    (Block) params[7].stmt, params[3].loc);
                return;
            }
            case 152: {
                //# line 142
                if (params[3].vlist != null) {
                    params[0].fdef = new Tree.MethodDef(false, params[2].ident, params[1].type, params[3].vlist,
                        (Block) params[3].stmt, params[2].loc);
                } else {
                    params[0].vdef = new Tree.VarDef(params[2].ident, params[1].type, params[2].loc);
                }
                return;
            }
        }
    }
}
/* end of file */
