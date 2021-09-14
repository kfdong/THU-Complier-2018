//### This file created by BYACC 1.8(/Java extension  1.13)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//###           14 Sep 06  -- Keltin Leung-- ReduceListener support, eliminate underflow report in error recovery
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 11 "Parser.y"
package decaf.frontend;

import decaf.tree.Tree;
import decaf.tree.Tree.*;
import decaf.error.*;
import java.util.*;
//#line 25 "Parser.java"
interface ReduceListener {
  public boolean onReduce(String rule);
}




public class Parser
             extends BaseParser
             implements ReduceListener
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

ReduceListener reduceListener = null;
void yyclearin ()       {yychar = (-1);}
void yyerrok ()         {yyerrflag=0;}
void addReduceListener(ReduceListener l) {
  reduceListener = l;}


//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//## **user defined:SemValue
String   yytext;//user variable to return contextual strings
SemValue yyval; //used to return semantic vals from action routines
SemValue yylval;//the 'lval' (result) I got from yylex()
SemValue valstk[] = new SemValue[YYSTACKSIZE];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
final void val_init()
{
  yyval=new SemValue();
  yylval=new SemValue();
  valptr=-1;
}
final void val_push(SemValue val)
{
  try {
    valptr++;
    valstk[valptr]=val;
  }
  catch (ArrayIndexOutOfBoundsException e) {
    int oldsize = valstk.length;
    int newsize = oldsize*2;
    SemValue[] newstack = new SemValue[newsize];
    System.arraycopy(valstk,0,newstack,0,oldsize);
    valstk = newstack;
    valstk[valptr]=val;
  }
}
final SemValue val_pop()
{
  return valstk[valptr--];
}
final void val_drop(int cnt)
{
  valptr -= cnt;
}
final SemValue val_peek(int relative)
{
  return valstk[valptr-relative];
}
//#### end semantic value section ####
public final static short VOID=257;
public final static short BOOL=258;
public final static short INT=259;
public final static short STRING=260;
public final static short CLASS=261;
public final static short NULL=262;
public final static short EXTENDS=263;
public final static short THIS=264;
public final static short WHILE=265;
public final static short FOR=266;
public final static short IF=267;
public final static short ELSE=268;
public final static short RETURN=269;
public final static short BREAK=270;
public final static short NEW=271;
public final static short SCOPY=272;
public final static short SEALED=273;
public final static short TRIPIPE=274;
public final static short VAR=275;
public final static short REPEAT=276;
public final static short CONCAT=277;
public final static short IN=278;
public final static short DEFAULT=279;
public final static short FOREACH=280;
public final static short PRINT=281;
public final static short READ_INTEGER=282;
public final static short READ_LINE=283;
public final static short LITERAL=284;
public final static short IDENTIFIER=285;
public final static short AND=286;
public final static short OR=287;
public final static short STATIC=288;
public final static short INSTANCEOF=289;
public final static short LESS_EQUAL=290;
public final static short GREATER_EQUAL=291;
public final static short EQUAL=292;
public final static short NOT_EQUAL=293;
public final static short UMINUS=294;
public final static short EMPTY=295;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    3,    4,    5,    5,    5,    5,    5,
    5,    2,    2,    6,    6,    7,    7,    7,    9,    9,
   10,   10,    8,    8,   11,   12,   12,   13,   13,   13,
   13,   13,   13,   13,   13,   13,   13,   13,   13,   22,
   22,   23,   26,   26,   28,   28,   24,   24,   29,   25,
   21,   14,   14,   14,   32,   32,   30,   30,   30,   31,
   27,   27,   27,   27,   27,   27,   27,   27,   27,   27,
   27,   27,   27,   27,   27,   27,   27,   27,   27,   27,
   27,   27,   27,   27,   27,   27,   27,   27,   35,   35,
   34,   34,   33,   33,   36,   36,   16,   17,   20,   15,
   37,   37,   18,   18,   19,
};
final static short yylen[] = {                            2,
    1,    2,    1,    2,    2,    1,    1,    1,    1,    2,
    3,    6,    7,    2,    0,    2,    2,    0,    1,    0,
    3,    1,    7,    6,    3,    2,    0,    1,    2,    1,
    1,    1,    2,    2,    2,    1,    2,    1,    1,    5,
    3,    8,    2,    2,    2,    0,    2,    0,    2,    3,
    6,    3,    1,    0,    2,    0,    2,    2,    4,    5,
    1,    1,    1,    3,    3,    3,    3,    3,    3,    3,
    3,    3,    3,    3,    3,    3,    3,    2,    2,    3,
    3,    1,    4,    5,    6,    5,    3,    6,    2,    0,
    1,    1,    1,    0,    3,    1,    5,    9,    1,    6,
    2,    0,    2,    1,    4,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    3,    0,    0,    2,    0,    0,
    0,   14,   18,    0,    0,   18,    7,    8,    6,    9,
    0,    0,   12,   16,    0,    0,   17,    0,   10,    0,
    4,    0,    0,   13,    0,    0,   11,    0,   22,    0,
    0,    0,    0,    5,    0,    0,    0,   27,   24,   21,
   23,    0,   92,   82,    0,    0,    0,    0,   99,    0,
    0,    0,    0,    0,    0,    0,   91,    0,    0,    0,
    0,   25,   28,   36,   26,    0,   30,   31,   32,    0,
    0,    0,    0,   38,   39,    0,    0,    0,    0,   63,
    0,    0,    0,    0,    0,   61,   62,    0,    0,    0,
   58,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   29,   33,   34,   35,   37,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   55,
    0,    0,    0,    0,    0,    0,   41,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   80,   81,    0,    0,
   77,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   47,   83,    0,    0,   43,   44,    0,
    0,  105,    0,    0,    0,    0,    0,   97,    0,    0,
   49,   40,    0,   84,    0,    0,    0,    0,   86,    0,
   60,    0,    0,  100,   50,   51,    0,    0,   85,    0,
    0,  101,    0,    0,    0,   42,   98,
};
final static short yydgoto[] = {                          3,
    4,    5,   73,   25,   40,   10,   15,   27,   41,   42,
   74,   52,   75,   76,   77,   78,   79,   80,   81,   82,
   83,   84,   85,  138,  172,  144,   86,  208,  174,   96,
   97,   89,  186,   90,    0,  146,  204,
};
final static short yysindex[] = {                      -203,
 -260, -234,    0, -203,    0, -223, -256,    0, -243,  -68,
 -223,    0,    0,  -63,  -82,    0,    0,    0,    0,    0,
 -219,  -43,    0,    0,   13,  -85,    0,  265,    0,  -83,
    0,   38,   -5,    0,   49,  -43,    0,  -43,    0,  -74,
   53,   59,   63,    0,  -16,  -43,  -16,    0,    0,    0,
    0,    1,    0,    0,   68,   69,  -37,  893,    0,  287,
   70, -167,   81,   82,   83,   85,    0,   88,  893,  893,
  556,    0,    0,    0,    0,   71,    0,    0,    0,   80,
   87,   94,   96,    0,    0,  813,   95,    0, -156,    0,
  893,  893,  893,   37,  813,    0,    0,  119,   73,  893,
    0, -117,  893,  120,  125,  893,  -28,  -28, -125,  440,
    0,    0,    0,    0,    0,  893,  893,  893,  893,  893,
  893,  893,  893,  893,  893,  893,  893,  893,  893,    0,
  893,  893,  132,  452,  115,  474,    0,  893,  139,  665,
  138,  -96,  -72,  -88,  813,   12,    0,    0,  495,  155,
    0,    2,  860,  752,  -32,  -32,  946,  946,   15,   15,
  -28,  -28,  -28,  -32,  -32,  598,  813,  893,   34,  893,
   34, -109,  624,    0,    0,  710,  893,    0,    0,  893,
  893,    0,  -87,  893,  -80,  160,  159,    0,  731,  -61,
    0,    0,   34,    0,  763,  787,  813,  163,    0,  893,
    0,  893,   34,    0,    0,    0,  893,  164,    0,  -28,
  179,    0,  813,   34,   34,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,  221,    0,   99,    0,    0,    0,    0,
   99,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  181,    0,    0,    0,  182,    0,  182,    0,    0,
    0,  212,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -55,    0,    0,    0,    0,    0,  -50,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  -31,  -31,
  -31,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  834,  416,    0,    0,
  -31,  -55,  -31,  696,  196,    0,    0,    0,    0,  -31,
    0,    0,  -31,    0,    0,  -31,  126,  150,    0,    0,
    0,    0,    0,    0,    0,  -31,  -31,  -31,  -31,  -31,
  -31,  -31,  -31,  -31,  -31,  -31,  -31,  -31,  -31,    0,
  -31,  -31,   54,    0,    0,    0,    0,  -31,    0,  -31,
  834,    0,    0,    0,   36,    0,    0,    0,    0,    0,
    0,  954,   -8,   61,  676, 1073,   24,  410, 1023, 1053,
  291,  327,  363, 1103, 1115,    0,  -21,  -40,  -55,  -31,
  -55,    0,    0,    0,    0,    0,  -31,    0,    0,  -31,
  -31,    0,    0,  -31,   90,    0,  223,    0,    0,  -33,
    0,    0,  -55,    0,    0,  228,   43,    0,    0,  -31,
    0,  -39,  -55,    0,    0,    0,  -31,    0,    0,  387,
    0,    0,   53,  -55,  -55,    0,    0,
};
final static short yygindex[] = {                         0,
    0,  270,    7,   35,    9,  264,  261,    0,  242,    0,
  -24,    0, -139,  -64,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0, 1300,    0,    0,  392,
  750,    0,    0,    0,    0,  118,    0,
};
final static int YYTABLESIZE=1507;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        102,
   94,   54,   93,   54,  127,   33,  102,   33,  104,  125,
  123,  102,  124,  130,  126,  192,   33,  130,   33,   52,
   49,   24,   51,   26,    6,  102,    7,  135,   11,  188,
   30,  190,   75,   70,   24,   75,   26,   52,  127,    9,
   71,   12,   23,  125,  123,   69,  124,  130,  126,   75,
   75,  127,  182,  205,   13,  181,  125,    1,  131,   16,
  130,  126,  131,  212,   69,   29,   70,   69,   99,    2,
   39,   31,   39,   71,  216,  217,   96,   36,   69,   96,
   50,   69,   69,   95,   75,   94,   95,   37,   38,  102,
   57,  102,  131,   45,   57,   57,   57,   57,   57,   57,
   57,   76,   46,   47,   76,  131,   48,   91,   92,  100,
  143,   57,   57,   57,   57,   57,   69,  101,   76,   76,
  102,  103,  104,   48,  105,   72,   59,  106,  133,  111,
   59,   59,   59,   59,   59,   59,   59,  211,  112,   17,
   18,   19,   20,   21,   57,  113,   57,   59,   59,   59,
   59,   59,  114,   76,  115,  132,   48,  142,  139,  150,
  147,  137,   78,  140,  191,  148,   78,   78,   78,   78,
   78,  168,   78,  170,   17,   18,   19,   20,   21,  175,
   59,  177,   59,   78,   78,   78,   79,   78,  178,  180,
   79,   79,   79,   79,   79,  184,   79,  198,  200,   32,
  201,   35,  181,  209,  214,   22,  203,   79,   79,   79,
   44,   79,  179,   17,   18,   19,   20,   21,   78,  215,
    1,   15,   20,  102,  102,  102,  102,  102,  102,   56,
  102,  102,  102,  102,   56,  102,  102,  102,  102,    5,
  102,  102,   79,  116,   56,   56,  102,  102,  102,  102,
  102,  102,   19,   56,  103,  102,   75,   17,   18,   19,
   20,   21,   53,   93,   54,   55,   56,   57,   46,   58,
   59,   60,   61,    8,   14,   62,   28,   75,   75,   43,
   63,   64,   65,   66,   67,  187,    0,    0,   69,   68,
   17,   18,   19,   20,   21,   53,    0,   54,   55,   56,
   57,    0,   58,   59,   60,   61,    0,    0,   62,   69,
   69,    0,    0,   63,   64,   65,   66,   67,   57,    0,
    0,    0,   68,    0,    0,   76,    0,   66,    0,   57,
    0,   66,   66,   66,   66,   66,    0,   66,    0,   57,
   57,    0,    0,   57,   57,   57,   57,   76,   66,   66,
   66,    0,   66,    0,   59,    0,    0,    0,    0,    0,
    0,    0,    0,   67,    0,   59,    0,   67,   67,   67,
   67,   67,    0,   67,    0,   59,   59,    0,    0,   59,
   59,   59,   59,   66,   67,   67,   67,    0,   67,   34,
   78,    0,    0,    0,    0,    0,    0,    0,    0,   68,
    0,   78,    0,   68,   68,   68,   68,   68,    0,   68,
    0,   78,   78,    0,   79,   78,   78,   78,   78,   67,
   68,   68,   68,   88,   68,   79,    0,   88,   88,   88,
   88,   88,    0,   88,    0,   79,   79,    0,    0,   79,
   79,   79,   79,   87,   88,   88,   88,    0,   88,    0,
   70,    0,   62,   70,    0,   68,   53,   62,   62,    0,
   62,   62,   62,    0,    0,    0,    0,   70,   70,    0,
    0,    0,    0,    0,   53,   62,  127,   62,    0,   88,
  151,  125,  123,   87,  124,  130,  126,    0,  127,    0,
    0,  141,  169,  125,  123,    0,  124,  130,  126,  129,
    0,  128,   70,    0,    0,    0,   62,    0,    0,    0,
  127,  129,    0,  128,  171,  125,  123,    0,  124,  130,
  126,   17,   18,   19,   20,   21,    0,    0,    0,    0,
  131,  127,    0,  129,    0,  128,  125,  123,  183,  124,
  130,  126,  131,   17,   18,   19,   20,   21,    0,    0,
    0,    0,   22,    0,  129,   66,  128,    0,    0,    0,
   87,    0,   87,    0,  131,    0,   66,    0,    0,    0,
    0,   98,    0,    0,    0,    0,   66,   66,    0,    0,
   66,   66,   66,   66,   87,  131,    0,    0,   70,    0,
    0,   67,    0,   87,   87,   71,    0,    0,    0,    0,
   69,    0,   67,    0,    0,   87,   87,    0,    0,    0,
    0,    0,   67,   67,    0,    0,   67,   67,   67,   67,
    0,    0,    0,    0,    0,    0,    0,   68,    0,    0,
    0,    0,    0,    0,  127,    0,    0,    0,   68,  125,
  123,    0,  124,  130,  126,    0,    0,    0,   68,   68,
    0,   88,   68,   68,   68,   68,    0,  129,    0,  128,
  127,    0,   88,    0,    0,  125,  123,    0,  124,  130,
  126,    0,   88,   88,   70,    0,   88,   88,   88,   88,
    0,  193,    0,  129,    0,  128,    0,    0,  131,    0,
  185,   62,    0,    0,    0,   70,   70,   70,    0,    0,
    0,   62,   62,    0,   71,   62,   62,   62,   62,   69,
    0,    0,    0,    0,  131,  116,   73,    0,    0,   73,
    0,    0,    0,    0,    0,  117,  118,  116,   48,  119,
  120,  121,  122,   73,   73,   48,    0,  117,  118,    0,
   48,  119,  120,  121,  122,    0,  127,    0,    0,  116,
    0,  125,  123,    0,  124,  130,  126,   37,    0,  117,
  118,    0,    0,  119,  120,  121,  122,  127,   73,  129,
  116,  128,  125,  123,    0,  124,  130,  126,    0,    0,
  117,  118,    0,    0,  119,  120,  121,  122,  127,  202,
  129,    0,  128,  125,  123,    0,  124,  130,  126,  127,
  131,   88,  194,  206,  125,  123,    0,  124,  130,  126,
    0,  129,    0,  128,    0,    0,  109,   53,    0,   54,
    0,  131,  129,  127,  128,    0,   60,    0,  125,  123,
   62,  124,  130,  126,    0,    0,    0,   65,   66,   67,
    0,   88,  131,    0,   68,    0,  129,    0,  128,  127,
    0,    0,    0,  131,  125,  123,    0,  124,  130,  126,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   61,    0,  129,  116,  128,   61,   61,  131,   61,   61,
   61,    0,    0,  117,  118,    0,    0,  119,  120,  121,
  122,    0,    0,   61,    0,   61,  127,    0,    0,  116,
    0,  125,  123,  131,  124,  130,  126,    0,    0,  117,
  118,    0,    0,  119,  120,  121,  122,    0,   88,  129,
   88,  128,    0,    0,   61,   70,   53,    0,   54,    0,
    0,    0,   71,    0,    0,   60,    0,   69,    0,   62,
   73,    0,   88,    0,    0,    0,   65,   66,   67,    0,
  131,   88,   88,   68,    0,    0,    0,   48,    0,   48,
    0,   73,   73,   88,   88,    0,   48,   73,   73,    0,
   48,    0,    0,    0,    0,    0,    0,   48,   48,   48,
   48,    0,  127,    0,   48,  116,    0,  125,  123,    0,
  124,  130,  126,    0,   87,  117,  118,   87,    0,  119,
  120,  121,  122,    0,    0,  129,  116,  128,    0,    0,
    0,   87,   87,   87,    0,   87,  117,  118,    0,    0,
  119,  120,  121,  122,    0,    0,    0,  116,    0,    0,
    0,    0,    0,    0,    0,    0,  131,  117,  116,    0,
    0,  119,  120,  121,  122,    0,   87,    0,  117,  118,
    0,  207,  119,  120,  121,  122,    0,    0,    0,    0,
    0,    0,  116,   64,    0,   64,   64,   64,    0,    0,
    0,    0,  117,  118,    0,    0,  119,  120,  121,  122,
   64,   64,   64,    0,   64,    0,    0,    0,  116,    0,
    0,    0,    0,   65,    0,   65,   65,   65,  117,  118,
    0,    0,  119,  120,  121,  122,    0,    0,    0,   61,
   65,   65,   65,   74,   65,   64,   74,    0,    0,   61,
   61,    0,    0,   61,   61,   61,   61,    0,    0,    0,
   74,   74,    0,    0,    0,  116,    0,    0,    0,    0,
    0,    0,    0,   72,    0,   65,   72,    0,    0,  119,
  120,  121,  122,    0,   53,   71,   54,    0,   71,    0,
   72,   72,    0,   60,    0,   74,    0,   62,    0,    0,
    0,    0,   71,   71,   65,   66,   67,    0,    0,    0,
    0,   68,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   72,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   71,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   87,    0,
    0,  116,    0,    0,    0,    0,    0,    0,    0,   87,
    0,    0,    0,    0,    0,  119,  120,    0,    0,   87,
   87,    0,    0,   87,   87,   87,   87,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   64,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   64,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   64,   64,
    0,    0,   64,   64,   64,   64,    0,   65,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   65,    0,
    0,    0,    0,    0,    0,    0,    0,   74,   65,   65,
    0,    0,   65,   65,   65,   65,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   95,   74,   74,
    0,    0,    0,    0,   74,   74,    0,   72,  107,  108,
  110,    0,    0,    0,    0,    0,    0,    0,    0,   71,
    0,    0,    0,    0,    0,    0,    0,    0,   72,   72,
  134,    0,  136,    0,   72,   72,    0,    0,    0,    0,
   71,   71,  145,    0,    0,  149,   71,   71,    0,    0,
    0,    0,    0,    0,    0,  152,  153,  154,  155,  156,
  157,  158,  159,  160,  161,  162,  163,  164,  165,    0,
  166,  167,    0,    0,    0,    0,    0,  173,    0,  176,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  145,    0,  189,
    0,    0,    0,    0,    0,    0,  195,    0,    0,  196,
  197,    0,    0,  199,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  210,
    0,    0,    0,    0,    0,    0,  213,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         33,
   41,   41,   40,   59,   37,   91,   40,   91,   59,   42,
   43,   45,   45,   46,   47,  125,   91,   46,   91,   41,
   45,   15,   47,   15,  285,   59,  261,   92,  285,  169,
   22,  171,   41,   33,   28,   44,   28,   59,   37,  263,
   40,  285,  125,   42,   43,   45,   45,   46,   47,   58,
   59,   37,   41,  193,  123,   44,   42,  261,   91,  123,
   46,   47,   91,  203,   41,  285,   33,   44,   60,  273,
   36,   59,   38,   40,  214,  215,   41,   40,   45,   44,
   46,   58,   59,   41,   93,  123,   44,   93,   40,  123,
   37,  125,   91,   41,   41,   42,   43,   44,   45,   46,
   47,   41,   44,   41,   44,   91,  123,   40,   40,   40,
  102,   58,   59,   60,   61,   62,   93,  285,   58,   59,
   40,   40,   40,  123,   40,  125,   37,   40,  285,   59,
   41,   42,   43,   44,   45,   46,   47,  202,   59,  257,
  258,  259,  260,  261,   91,   59,   93,   58,   59,   60,
   61,   62,   59,   93,   59,   61,  123,  275,   40,  285,
   41,  125,   37,   91,  274,   41,   41,   42,   43,   44,
   45,   40,   47,   59,  257,  258,  259,  260,  261,   41,
   91,   44,   93,   58,   59,   60,   37,   62,  285,  278,
   41,   42,   43,   44,   45,   41,   47,  285,  279,  285,
   41,  285,   44,   41,   41,  288,  268,   58,   59,   60,
  285,   62,  285,  257,  258,  259,  260,  261,   93,   41,
    0,  123,   41,  257,  258,  259,  260,  261,  262,  285,
  264,  265,  266,  267,  285,  269,  270,  271,  272,   59,
  274,  275,   93,  276,  285,  285,  280,  281,  282,  283,
  284,  285,   41,  285,   59,  289,  265,  257,  258,  259,
  260,  261,  262,   41,  264,  265,  266,  267,   41,  269,
  270,  271,  272,    4,   11,  275,   16,  286,  287,   38,
  280,  281,  282,  283,  284,  168,   -1,   -1,  265,  289,
  257,  258,  259,  260,  261,  262,   -1,  264,  265,  266,
  267,   -1,  269,  270,  271,  272,   -1,   -1,  275,  286,
  287,   -1,   -1,  280,  281,  282,  283,  284,  265,   -1,
   -1,   -1,  289,   -1,   -1,  265,   -1,   37,   -1,  276,
   -1,   41,   42,   43,   44,   45,   -1,   47,   -1,  286,
  287,   -1,   -1,  290,  291,  292,  293,  287,   58,   59,
   60,   -1,   62,   -1,  265,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   37,   -1,  276,   -1,   41,   42,   43,
   44,   45,   -1,   47,   -1,  286,  287,   -1,   -1,  290,
  291,  292,  293,   93,   58,   59,   60,   -1,   62,  125,
  265,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   37,
   -1,  276,   -1,   41,   42,   43,   44,   45,   -1,   47,
   -1,  286,  287,   -1,  265,  290,  291,  292,  293,   93,
   58,   59,   60,   37,   62,  276,   -1,   41,   42,   43,
   44,   45,   -1,   47,   -1,  286,  287,   -1,   -1,  290,
  291,  292,  293,   52,   58,   59,   60,   -1,   62,   -1,
   41,   -1,   37,   44,   -1,   93,   41,   42,   43,   -1,
   45,   46,   47,   -1,   -1,   -1,   -1,   58,   59,   -1,
   -1,   -1,   -1,   -1,   59,   60,   37,   62,   -1,   93,
   41,   42,   43,   92,   45,   46,   47,   -1,   37,   -1,
   -1,  100,   41,   42,   43,   -1,   45,   46,   47,   60,
   -1,   62,   93,   -1,   -1,   -1,   91,   -1,   -1,   -1,
   37,   60,   -1,   62,   41,   42,   43,   -1,   45,   46,
   47,  257,  258,  259,  260,  261,   -1,   -1,   -1,   -1,
   91,   37,   -1,   60,   -1,   62,   42,   43,   44,   45,
   46,   47,   91,  257,  258,  259,  260,  261,   -1,   -1,
   -1,   -1,  288,   -1,   60,  265,   62,   -1,   -1,   -1,
  169,   -1,  171,   -1,   91,   -1,  276,   -1,   -1,   -1,
   -1,  285,   -1,   -1,   -1,   -1,  286,  287,   -1,   -1,
  290,  291,  292,  293,  193,   91,   -1,   -1,   33,   -1,
   -1,  265,   -1,  202,  203,   40,   -1,   -1,   -1,   -1,
   45,   -1,  276,   -1,   -1,  214,  215,   -1,   -1,   -1,
   -1,   -1,  286,  287,   -1,   -1,  290,  291,  292,  293,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,   -1,   -1,
   -1,   -1,   -1,   -1,   37,   -1,   -1,   -1,  276,   42,
   43,   -1,   45,   46,   47,   -1,   -1,   -1,  286,  287,
   -1,  265,  290,  291,  292,  293,   -1,   60,   -1,   62,
   37,   -1,  276,   -1,   -1,   42,   43,   -1,   45,   46,
   47,   -1,  286,  287,  265,   -1,  290,  291,  292,  293,
   -1,   58,   -1,   60,   -1,   62,   -1,   -1,   91,   -1,
   93,  276,   -1,   -1,   -1,  286,  287,   33,   -1,   -1,
   -1,  286,  287,   -1,   40,  290,  291,  292,  293,   45,
   -1,   -1,   -1,   -1,   91,  276,   41,   -1,   -1,   44,
   -1,   -1,   -1,   -1,   -1,  286,  287,  276,   33,  290,
  291,  292,  293,   58,   59,   40,   -1,  286,  287,   -1,
   45,  290,  291,  292,  293,   -1,   37,   -1,   -1,  276,
   -1,   42,   43,   -1,   45,   46,   47,   93,   -1,  286,
  287,   -1,   -1,  290,  291,  292,  293,   37,   93,   60,
  276,   62,   42,   43,   -1,   45,   46,   47,   -1,   -1,
  286,  287,   -1,   -1,  290,  291,  292,  293,   37,   59,
   60,   -1,   62,   42,   43,   -1,   45,   46,   47,   37,
   91,   52,   93,   41,   42,   43,   -1,   45,   46,   47,
   -1,   60,   -1,   62,   -1,   -1,  261,  262,   -1,  264,
   -1,   91,   60,   37,   62,   -1,  271,   -1,   42,   43,
  275,   45,   46,   47,   -1,   -1,   -1,  282,  283,  284,
   -1,   92,   91,   -1,  289,   -1,   60,   -1,   62,   37,
   -1,   -1,   -1,   91,   42,   43,   -1,   45,   46,   47,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   37,   -1,   60,  276,   62,   42,   43,   91,   45,   46,
   47,   -1,   -1,  286,  287,   -1,   -1,  290,  291,  292,
  293,   -1,   -1,   60,   -1,   62,   37,   -1,   -1,  276,
   -1,   42,   43,   91,   45,   46,   47,   -1,   -1,  286,
  287,   -1,   -1,  290,  291,  292,  293,   -1,  169,   60,
  171,   62,   -1,   -1,   91,   33,  262,   -1,  264,   -1,
   -1,   -1,   40,   -1,   -1,  271,   -1,   45,   -1,  275,
  265,   -1,  193,   -1,   -1,   -1,  282,  283,  284,   -1,
   91,  202,  203,  289,   -1,   -1,   -1,  262,   -1,  264,
   -1,  286,  287,  214,  215,   -1,  271,  292,  293,   -1,
  275,   -1,   -1,   -1,   -1,   -1,   -1,  282,  283,  284,
  285,   -1,   37,   -1,  289,  276,   -1,   42,   43,   -1,
   45,   46,   47,   -1,   41,  286,  287,   44,   -1,  290,
  291,  292,  293,   -1,   -1,   60,  276,   62,   -1,   -1,
   -1,   58,   59,   60,   -1,   62,  286,  287,   -1,   -1,
  290,  291,  292,  293,   -1,   -1,   -1,  276,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   91,  286,  276,   -1,
   -1,  290,  291,  292,  293,   -1,   93,   -1,  286,  287,
   -1,  265,  290,  291,  292,  293,   -1,   -1,   -1,   -1,
   -1,   -1,  276,   41,   -1,   43,   44,   45,   -1,   -1,
   -1,   -1,  286,  287,   -1,   -1,  290,  291,  292,  293,
   58,   59,   60,   -1,   62,   -1,   -1,   -1,  276,   -1,
   -1,   -1,   -1,   41,   -1,   43,   44,   45,  286,  287,
   -1,   -1,  290,  291,  292,  293,   -1,   -1,   -1,  276,
   58,   59,   60,   41,   62,   93,   44,   -1,   -1,  286,
  287,   -1,   -1,  290,  291,  292,  293,   -1,   -1,   -1,
   58,   59,   -1,   -1,   -1,  276,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   41,   -1,   93,   44,   -1,   -1,  290,
  291,  292,  293,   -1,  262,   41,  264,   -1,   44,   -1,
   58,   59,   -1,  271,   -1,   93,   -1,  275,   -1,   -1,
   -1,   -1,   58,   59,  282,  283,  284,   -1,   -1,   -1,
   -1,  289,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   93,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   93,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,   -1,
   -1,  276,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  276,
   -1,   -1,   -1,   -1,   -1,  290,  291,   -1,   -1,  286,
  287,   -1,   -1,  290,  291,  292,  293,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  276,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  286,  287,
   -1,   -1,  290,  291,  292,  293,   -1,  265,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  276,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,  286,  287,
   -1,   -1,  290,  291,  292,  293,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   58,  286,  287,
   -1,   -1,   -1,   -1,  292,  293,   -1,  265,   69,   70,
   71,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  286,  287,
   91,   -1,   93,   -1,  292,  293,   -1,   -1,   -1,   -1,
  286,  287,  103,   -1,   -1,  106,  292,  293,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  116,  117,  118,  119,  120,
  121,  122,  123,  124,  125,  126,  127,  128,  129,   -1,
  131,  132,   -1,   -1,   -1,   -1,   -1,  138,   -1,  140,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  168,   -1,  170,
   -1,   -1,   -1,   -1,   -1,   -1,  177,   -1,   -1,  180,
  181,   -1,   -1,  184,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  200,
   -1,   -1,   -1,   -1,   -1,   -1,  207,
};
}
final static short YYFINAL=3;
final static short YYMAXTOKEN=295;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"'!'",null,null,null,"'%'",null,null,"'('","')'","'*'","'+'",
"','","'-'","'.'","'/'",null,null,null,null,null,null,null,null,null,null,"':'",
"';'","'<'","'='","'>'",null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,"'['",null,"']'",null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,"'{'",null,"'}'",null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,"VOID","BOOL","INT","STRING",
"CLASS","NULL","EXTENDS","THIS","WHILE","FOR","IF","ELSE","RETURN","BREAK",
"NEW","SCOPY","SEALED","TRIPIPE","VAR","REPEAT","CONCAT","IN","DEFAULT",
"FOREACH","PRINT","READ_INTEGER","READ_LINE","LITERAL","IDENTIFIER","AND","OR",
"STATIC","INSTANCEOF","LESS_EQUAL","GREATER_EQUAL","EQUAL","NOT_EQUAL","UMINUS",
"EMPTY",
};
final static String yyrule[] = {
"$accept : Program",
"Program : ClassList",
"ClassList : ClassList ClassDef",
"ClassList : ClassDef",
"VariableDef : Variable ';'",
"Variable : Type IDENTIFIER",
"Type : INT",
"Type : VOID",
"Type : BOOL",
"Type : STRING",
"Type : CLASS IDENTIFIER",
"Type : Type '[' ']'",
"ClassDef : CLASS IDENTIFIER ExtendsClause '{' FieldList '}'",
"ClassDef : SEALED CLASS IDENTIFIER ExtendsClause '{' FieldList '}'",
"ExtendsClause : EXTENDS IDENTIFIER",
"ExtendsClause :",
"FieldList : FieldList VariableDef",
"FieldList : FieldList FunctionDef",
"FieldList :",
"Formals : VariableList",
"Formals :",
"VariableList : VariableList ',' Variable",
"VariableList : Variable",
"FunctionDef : STATIC Type IDENTIFIER '(' Formals ')' StmtBlock",
"FunctionDef : Type IDENTIFIER '(' Formals ')' StmtBlock",
"StmtBlock : '{' StmtList '}'",
"StmtList : StmtList Stmt",
"StmtList :",
"Stmt : VariableDef",
"Stmt : SimpleStmt ';'",
"Stmt : IfStmt",
"Stmt : WhileStmt",
"Stmt : ForStmt",
"Stmt : ReturnStmt ';'",
"Stmt : PrintStmt ';'",
"Stmt : BreakStmt ';'",
"Stmt : StmtBlock",
"Stmt : OCStmt ';'",
"Stmt : GuardedStmt",
"Stmt : ForeachStmt",
"GuardedStmt : IF '{' IfBranchStar IfSubStmt '}'",
"GuardedStmt : IF '{' '}'",
"ForeachStmt : FOREACH '(' BoundVariable IN Expr ForeachIf ')' Stmt",
"BoundVariable : VAR IDENTIFIER",
"BoundVariable : Type IDENTIFIER",
"ForeachIf : WHILE Expr",
"ForeachIf :",
"IfBranchStar : IfBranchStar IfBranch",
"IfBranchStar :",
"IfBranch : IfSubStmt TRIPIPE",
"IfSubStmt : Expr ':' Stmt",
"OCStmt : SCOPY '(' LValue ',' Expr ')'",
"SimpleStmt : LValue '=' Expr",
"SimpleStmt : Call",
"SimpleStmt :",
"Receiver : Expr '.'",
"Receiver :",
"LValue : Receiver IDENTIFIER",
"LValue : VAR IDENTIFIER",
"LValue : Expr '[' Expr ']'",
"Call : Receiver IDENTIFIER '(' Actuals ')'",
"Expr : LValue",
"Expr : Call",
"Expr : Constant",
"Expr : Expr '+' Expr",
"Expr : Expr '-' Expr",
"Expr : Expr '*' Expr",
"Expr : Expr '/' Expr",
"Expr : Expr '%' Expr",
"Expr : Expr EQUAL Expr",
"Expr : Expr NOT_EQUAL Expr",
"Expr : Expr '<' Expr",
"Expr : Expr '>' Expr",
"Expr : Expr LESS_EQUAL Expr",
"Expr : Expr GREATER_EQUAL Expr",
"Expr : Expr AND Expr",
"Expr : Expr OR Expr",
"Expr : '(' Expr ')'",
"Expr : '-' Expr",
"Expr : '!' Expr",
"Expr : READ_INTEGER '(' ')'",
"Expr : READ_LINE '(' ')'",
"Expr : THIS",
"Expr : NEW IDENTIFIER '(' ')'",
"Expr : NEW Type '[' Expr ']'",
"Expr : INSTANCEOF '(' Expr ',' IDENTIFIER ')'",
"Expr : '(' CLASS IDENTIFIER ')' Expr",
"Expr : Expr REPEAT Expr",
"Expr : Expr '[' Expr ']' DEFAULT Expr",
"COMPIF : IF Expr",
"COMPIF :",
"Constant : LITERAL",
"Constant : NULL",
"Actuals : ExprList",
"Actuals :",
"ExprList : ExprList ',' Expr",
"ExprList : Expr",
"WhileStmt : WHILE '(' Expr ')' Stmt",
"ForStmt : FOR '(' SimpleStmt ';' Expr ';' SimpleStmt ')' Stmt",
"BreakStmt : BREAK",
"IfStmt : IF '(' Expr ')' Stmt ElseClause",
"ElseClause : ELSE Stmt",
"ElseClause :",
"ReturnStmt : RETURN Expr",
"ReturnStmt : RETURN",
"PrintStmt : PRINT '(' ExprList ')'",
};

//#line 520 "Parser.y"
    
	/**
	 * 打印当前归约所用的语法规则<br>
	 * 请勿修改。
	 */
    public boolean onReduce(String rule) {
		if (rule.startsWith("$$"))
			return false;
		else
			rule = rule.replaceAll(" \\$\\$\\d+", "");

   	    if (rule.endsWith(":"))
    	    System.out.println(rule + " <empty>");
   	    else
			System.out.println(rule);
		return false;
    }
    
    public void diagnose() {
		addReduceListener(this);
		yyparse();
	}
//#line 727 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    //if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      //if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        //if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        //if (yychar < 0)    //it it didn't work/error
        //  {
        //  yychar = 0;      //change it to default string (no -1!)
          //if (yydebug)
          //  yylexdebug(yystate,yychar);
        //  }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        //if (yydebug)
          //debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      //if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0 || valptr<0)   //check for under & overflow here
            {
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            //if (yydebug)
              //debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            //if (yydebug)
              //debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0 || valptr<0)   //check for under & overflow here
              {
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        //if (yydebug)
          //{
          //yys = null;
          //if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          //if (yys == null) yys = "illegal-symbol";
          //debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          //}
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    //if (yydebug)
      //debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    if (reduceListener == null || reduceListener.onReduce(yyrule[yyn])) // if intercepted!
      switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 57 "Parser.y"
{
						tree = new Tree.TopLevel(val_peek(0).clist, val_peek(0).loc);
					}
break;
case 2:
//#line 63 "Parser.y"
{
						yyval.clist.add(val_peek(0).cdef);
					}
break;
case 3:
//#line 67 "Parser.y"
{
                		yyval.clist = new ArrayList<Tree.ClassDef>();
                		yyval.clist.add(val_peek(0).cdef);
                	}
break;
case 5:
//#line 77 "Parser.y"
{
						yyval.vdef = new Tree.VarDef(val_peek(0).ident, val_peek(1).type, val_peek(0).loc);
					}
break;
case 6:
//#line 83 "Parser.y"
{
						yyval.type = new Tree.TypeIdent(Tree.INT, val_peek(0).loc);
					}
break;
case 7:
//#line 87 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.VOID, val_peek(0).loc);
                	}
break;
case 8:
//#line 91 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.BOOL, val_peek(0).loc);
                	}
break;
case 9:
//#line 95 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.STRING, val_peek(0).loc);
                	}
break;
case 10:
//#line 99 "Parser.y"
{
                		yyval.type = new Tree.TypeClass(val_peek(0).ident, val_peek(1).loc);
                	}
break;
case 11:
//#line 103 "Parser.y"
{
                		yyval.type = new Tree.TypeArray(val_peek(2).type, val_peek(2).loc);
                	}
break;
case 12:
//#line 109 "Parser.y"
{
						yyval.cdef = new Tree.ClassDef(val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, false, val_peek(5).loc);
					}
break;
case 13:
//#line 113 "Parser.y"
{
						yyval.cdef = new Tree.ClassDef(val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, true, val_peek(5).loc);
					}
break;
case 14:
//#line 119 "Parser.y"
{
						yyval.ident = val_peek(0).ident;
					}
break;
case 15:
//#line 123 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 16:
//#line 129 "Parser.y"
{
						yyval.flist.add(val_peek(0).vdef);
					}
break;
case 17:
//#line 133 "Parser.y"
{
						yyval.flist.add(val_peek(0).fdef);
					}
break;
case 18:
//#line 137 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.flist = new ArrayList<Tree>();
                	}
break;
case 20:
//#line 145 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.vlist = new ArrayList<Tree.VarDef>(); 
                	}
break;
case 21:
//#line 152 "Parser.y"
{
						yyval.vlist.add(val_peek(0).vdef);
					}
break;
case 22:
//#line 156 "Parser.y"
{
                		yyval.vlist = new ArrayList<Tree.VarDef>();
						yyval.vlist.add(val_peek(0).vdef);
                	}
break;
case 23:
//#line 163 "Parser.y"
{
						yyval.fdef = new MethodDef(true, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 24:
//#line 167 "Parser.y"
{
						yyval.fdef = new MethodDef(false, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 25:
//#line 173 "Parser.y"
{
						yyval.stmt = new Block(val_peek(1).slist, val_peek(2).loc);
					}
break;
case 26:
//#line 179 "Parser.y"
{
						yyval.slist.add(val_peek(0).stmt);
					}
break;
case 27:
//#line 183 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.slist = new ArrayList<Tree>();
                	}
break;
case 28:
//#line 190 "Parser.y"
{
						yyval.stmt = val_peek(0).vdef;
					}
break;
case 29:
//#line 195 "Parser.y"
{
                		if (yyval.stmt == null) {
                			yyval.stmt = new Tree.Skip(val_peek(0).loc);
                		}
                	}
break;
case 40:
//#line 213 "Parser.y"
{
						yyval.stmt = new Tree.Guarded(val_peek(2).elist, val_peek(2).slist, val_peek(1).expr, val_peek(1).stmt, val_peek(4).loc);
			 		}
break;
case 41:
//#line 217 "Parser.y"
{
						yyval.stmt = new Tree.Guarded(val_peek(2).loc);
					}
break;
case 42:
//#line 223 "Parser.y"
{
						yyval.stmt = new Tree.Foreach(val_peek(5).type, val_peek(5).ident, val_peek(3).expr, val_peek(2).expr, val_peek(0).stmt, val_peek(7).loc);
					}
break;
case 43:
//#line 228 "Parser.y"
{
						yyval.type = new Tree.TypeIdent(Tree.VAR, val_peek(1).loc);
						yyval.ident = val_peek(0).ident;
					}
break;
case 44:
//#line 233 "Parser.y"
{
						yyval.ident = val_peek(0).ident;
					}
break;
case 45:
//#line 238 "Parser.y"
{
						yyval.expr = val_peek(0).expr;
					}
break;
case 46:
//#line 242 "Parser.y"
{
						yyval = new SemValue();
					}
break;
case 47:
//#line 247 "Parser.y"
{
						yyval.elist.add(val_peek(0).expr);
						yyval.slist.add(val_peek(0).stmt);
					}
break;
case 48:
//#line 252 "Parser.y"
{
						yyval = new SemValue();
						yyval.elist = new ArrayList<Expr>();
						yyval.slist = new ArrayList<Tree>();
					}
break;
case 49:
//#line 259 "Parser.y"
{
						/* Do nothing. */
					}
break;
case 50:
//#line 264 "Parser.y"
{
						yyval.expr = val_peek(2).expr;
						yyval.stmt = val_peek(0).stmt;
					}
break;
case 51:
//#line 271 "Parser.y"
{
						yyval.stmt = new Tree.Scopy(val_peek(3).lvalue, val_peek(1).expr, val_peek(5).loc);
					}
break;
case 52:
//#line 277 "Parser.y"
{
						yyval.stmt = new Tree.Assign(val_peek(2).lvalue, val_peek(0).expr, val_peek(1).loc);
					}
break;
case 53:
//#line 281 "Parser.y"
{
                		yyval.stmt = new Tree.Exec(val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 54:
//#line 285 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 56:
//#line 292 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 57:
//#line 298 "Parser.y"
{
						yyval.lvalue = new Tree.Ident(val_peek(1).expr, val_peek(0).ident, val_peek(0).loc);
						if (val_peek(1).loc == null) {
							yyval.loc = val_peek(0).loc;
						}
					}
break;
case 58:
//#line 305 "Parser.y"
{
						yyval.lvalue = new Tree.Var(val_peek(0).ident, val_peek(0).loc);
					}
break;
case 59:
//#line 309 "Parser.y"
{
                		yyval.lvalue = new Tree.Indexed(val_peek(3).expr, val_peek(1).expr, val_peek(3).loc);
                	}
break;
case 60:
//#line 315 "Parser.y"
{
						yyval.expr = new Tree.CallExpr(val_peek(4).expr, val_peek(3).ident, val_peek(1).elist, val_peek(3).loc);
						if (val_peek(4).loc == null) {
							yyval.loc = val_peek(3).loc;
						}
					}
break;
case 61:
//#line 324 "Parser.y"
{
						yyval.expr = val_peek(0).lvalue;
					}
break;
case 64:
//#line 330 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.PLUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 65:
//#line 334 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MINUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 66:
//#line 338 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MUL, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 67:
//#line 342 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.DIV, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 68:
//#line 346 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MOD, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 69:
//#line 350 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.EQ, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 70:
//#line 354 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.NE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 71:
//#line 358 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 72:
//#line 362 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 73:
//#line 366 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 74:
//#line 370 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 75:
//#line 374 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.AND, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 76:
//#line 378 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.OR, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 77:
//#line 382 "Parser.y"
{
                		yyval = val_peek(1);
                	}
break;
case 78:
//#line 386 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NEG, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 79:
//#line 390 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NOT, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 80:
//#line 394 "Parser.y"
{
                		yyval.expr = new Tree.ReadIntExpr(val_peek(2).loc);
                	}
break;
case 81:
//#line 398 "Parser.y"
{
                		yyval.expr = new Tree.ReadLineExpr(val_peek(2).loc);
                	}
break;
case 82:
//#line 402 "Parser.y"
{
                		yyval.expr = new Tree.ThisExpr(val_peek(0).loc);
                	}
break;
case 83:
//#line 406 "Parser.y"
{
                		yyval.expr = new Tree.NewClass(val_peek(2).ident, val_peek(3).loc);
                	}
break;
case 84:
//#line 410 "Parser.y"
{
                		yyval.expr = new Tree.NewArray(val_peek(3).type, val_peek(1).expr, val_peek(4).loc);
                	}
break;
case 85:
//#line 414 "Parser.y"
{
                		yyval.expr = new Tree.TypeTest(val_peek(3).expr, val_peek(1).ident, val_peek(5).loc);
                	}
break;
case 86:
//#line 418 "Parser.y"
{
                		yyval.expr = new Tree.TypeCast(val_peek(2).ident, val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 87:
//#line 422 "Parser.y"
{
						yyval.expr = new Tree.ArrayRepeat(val_peek(2).expr, val_peek(0).expr, val_peek(2).loc);
					}
break;
case 88:
//#line 426 "Parser.y"
{
						yyval.expr = new Tree.DefaultAccess(val_peek(5).expr, val_peek(3).expr, val_peek(0).expr, val_peek(1).loc);
					}
break;
case 89:
//#line 432 "Parser.y"
{
						yyval.expr = val_peek(0).expr;
					}
break;
case 90:
//#line 436 "Parser.y"
{
						yyval = new SemValue();
					}
break;
case 91:
//#line 441 "Parser.y"
{
						yyval.expr = new Tree.Literal(val_peek(0).typeTag, val_peek(0).literal, val_peek(0).loc);
					}
break;
case 92:
//#line 445 "Parser.y"
{
						yyval.expr = new Null(val_peek(0).loc);
					}
break;
case 94:
//#line 452 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.elist = new ArrayList<Tree.Expr>();
                	}
break;
case 95:
//#line 459 "Parser.y"
{
						yyval.elist.add(val_peek(0).expr);
					}
break;
case 96:
//#line 463 "Parser.y"
{
                		yyval.elist = new ArrayList<Tree.Expr>();
						yyval.elist.add(val_peek(0).expr);
                	}
break;
case 97:
//#line 470 "Parser.y"
{
						yyval.stmt = new Tree.WhileLoop(val_peek(2).expr, val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 98:
//#line 476 "Parser.y"
{
						yyval.stmt = new Tree.ForLoop(val_peek(6).stmt, val_peek(4).expr, val_peek(2).stmt, val_peek(0).stmt, val_peek(8).loc);
					}
break;
case 99:
//#line 482 "Parser.y"
{
						yyval.stmt = new Tree.Break(val_peek(0).loc);
					}
break;
case 100:
//#line 488 "Parser.y"
{
						yyval.stmt = new Tree.If(val_peek(3).expr, val_peek(1).stmt, val_peek(0).stmt, val_peek(5).loc);
					}
break;
case 101:
//#line 494 "Parser.y"
{
						yyval.stmt = val_peek(0).stmt;
					}
break;
case 102:
//#line 498 "Parser.y"
{
						yyval = new SemValue();
					}
break;
case 103:
//#line 504 "Parser.y"
{
						yyval.stmt = new Tree.Return(val_peek(0).expr, val_peek(1).loc);
					}
break;
case 104:
//#line 508 "Parser.y"
{
                		yyval.stmt = new Tree.Return(null, val_peek(0).loc);
                	}
break;
case 105:
//#line 514 "Parser.y"
{
						yyval.stmt = new Print(val_peek(1).elist, val_peek(3).loc);
					}
break;
//#line 1427 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    //if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      //if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        //if (yychar<0) yychar=0;  //clean, if necessary
        //if (yydebug)
          //yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      //if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
//## The -Jnorun option was used ##
//## end of method run() ########################################



//## Constructors ###############################################
//## The -Jnoconstruct option was used ##
//###############################################################



}
//################### END OF CLASS ##############################
