/* Generated By:JJTree: Do not edit this line. OMatchesCondition.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import com.orientechnologies.orient.core.command.OCommandContext;
import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.sql.executor.OResult;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OMatchesCondition extends OBooleanExpression {
  protected OExpression     expression;
  protected String          right;
  protected OInputParameter rightParam;

  public OMatchesCondition(int id) {
    super(id);
  }

  public OMatchesCondition(OrientSql p, int id) {
    super(p, id);
  }

  /**
   * Accept the visitor.
   **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  @Override public boolean evaluate(OIdentifiable currentRecord, OCommandContext ctx) {
    throw new UnsupportedOperationException("TODO Implement MATCHES!!!");//TODO
  }

  @Override public boolean evaluate(OResult currentRecord, OCommandContext ctx) {
    throw new UnsupportedOperationException("TODO Implement MATCHES!!!");//TODO
  }

  public void toString(Map<Object, Object> params, StringBuilder builder) {
    expression.toString(params, builder);
    builder.append(" MATCHES ");
    if (right != null) {
      builder.append(right);
    } else {
      rightParam.toString(params, builder);
    }
  }

  @Override public boolean supportsBasicCalculation() {
    return expression.supportsBasicCalculation();
  }

  @Override protected int getNumberOfExternalCalculations() {
    if (expression != null && !expression.supportsBasicCalculation()) {
      return 1;
    }
    return 0;
  }

  @Override protected List<Object> getExternalCalculationConditions() {
    if (expression != null && !expression.supportsBasicCalculation()) {
      return (List) Collections.singletonList(expression);
    }
    return Collections.EMPTY_LIST;
  }

  @Override public boolean needsAliases(Set<String> aliases) {
    if (expression.needsAliases(aliases)) {
      return true;
    }
    return false;
  }

  @Override public OMatchesCondition copy() {
    OMatchesCondition result = new OMatchesCondition(-1);
    result.expression = expression == null ? null : expression.copy();
    result.right = right;
    result.rightParam = rightParam == null ? null : rightParam.copy();
    return result;
  }

}
/* JavaCC - OriginalChecksum=68712f476e2e633c2bbfc34cb6c39356 (do not edit this line) */
