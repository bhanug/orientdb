/* Generated By:JJTree: Do not edit this line. OLuceneOperator.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

public class OLuceneOperator extends SimpleNode implements OBinaryCompareOperator {
  public OLuceneOperator(int id) {
    super(id);
  }

  public OLuceneOperator(OrientSql p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  @Override
  public boolean execute(Object left, Object right) {
    throw new UnsupportedOperationException(toString() + " operator cannot be evaluated in this context");
  }

  @Override
  public String toString() {
    return "LUCENE";
  }

  @Override public boolean supportsBasicCalculation() {
    return true;
  }

  @Override public OLuceneOperator copy() {
    return new OLuceneOperator(-1);
  }
}
/* JavaCC - OriginalChecksum=bda1e010e6ba48c815829b22ce458b9d (do not edit this line) */
