//#############################################
//## file: PDL2Parser.java
//## Generated by Byacc/j
//#############################################
package net.nmedit.nmlibs.jpdl2.format;

/**
 * BYACC/J Semantic Value for parser: PDL2Parser
 * This class provides some of the functionality
 * of the yacc/C 'union' directive
 */
public class PDL2ParserVal
{
/**
 * integer value of this 'union'
 */
public int ival;

/**
 * double value of this 'union'
 */
public double dval;

/**
 * string value of this 'union'
 */
public String sval;

/**
 * object value of this 'union'
 */
public Object obj;

//#############################################
//## C O N S T R U C T O R S
//#############################################
/**
 * Initialize me without a value
 */
public PDL2ParserVal()
{
}
/**
 * Initialize me as an int
 */
public PDL2ParserVal(int val)
{
  ival=val;
}

/**
 * Initialize me as a double
 */
public PDL2ParserVal(double val)
{
  dval=val;
}

/**
 * Initialize me as a string
 */
public PDL2ParserVal(String val)
{
  sval=val;
}

/**
 * Initialize me as an Object
 */
public PDL2ParserVal(Object val)
{
  obj=val;
}
}//end class

//#############################################
//## E N D    O F    F I L E
//#############################################
