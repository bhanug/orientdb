/* Generated By:JJTree: Do not edit this line. OContainsTextCondition.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import com.orientechnologies.orient.core.command.OCommandContext;
import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.sql.executor.OResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OContainsTextCondition extends OBooleanExpression {

  protected OExpression left;
  protected OExpression right;

  public OContainsTextCondition(int id) {
    super(id);
  }

  public OContainsTextCondition(OrientSql p, int id) {
    super(p, id);
  }

  /**
   * Accept the visitor.
   **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  @Override public boolean evaluate(OIdentifiable currentRecord, OCommandContext ctx) {
    throw new UnsupportedOperationException("TODO Implement ContainsText!!!");//TODO
  }

  @Override public boolean evaluate(OResult currentRecord, OCommandContext ctx) {
    throw new UnsupportedOperationException("TODO Implement ContainsText!!!");//TODO
  }

  public void toString(Map<Object, Object> params, StringBuilder builder) {
    left.toString(params, builder);
    builder.append(" CONTAINSTEXT ");
    right.toString(params, builder);
  }

  @Override public boolean supportsBasicCalculation() {
    return true;
  }

  @Override protected int getNumberOfExternalCalculations() {
    int total = 0;
    if (!left.supportsBasicCalculation()) {
      total++;
    }
    if (!right.supportsBasicCalculation()) {
      total++;
    }
    return total;
  }

  @Override protected List<Object> getExternalCalculationConditions() {
    List<Object> result = new ArrayList<Object>();
    if (!left.supportsBasicCalculation()) {
      result.add(left);
    }
    if (!right.supportsBasicCalculation()) {
      result.add(right);
    }
    return result;
  }

  @Override public boolean needsAliases(Set<String> aliases) {
    if (!left.needsAliases(aliases)) {
      return true;
    }
    if (!right.needsAliases(aliases)) {
      return true;
    }
    return false;
  }

  @Override public OContainsTextCondition copy() {
    OContainsTextCondition result = new OContainsTextCondition(-1);
    result.left = left.copy();
    result.right = right.copy();
    return result;
  }
}
/* JavaCC - OriginalChecksum=b588492ba2cbd0f932055f1f64bbbecd (do not edit this line) */
