/* Generated By:JJTree: Do not edit this line. ONotInCondition.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import com.orientechnologies.orient.core.command.OCommandContext;
import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.sql.executor.OResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ONotInCondition extends OBooleanExpression {

  protected OExpression            left;
  protected OBinaryCompareOperator operator;
  protected OSelectStatement       rightStatement;

  protected Object                 right;
  protected OInputParameter        rightParam;
  protected OMathExpression        rightMathExpression;

  private static final Object      UNSET           = new Object();
  private Object                   inputFinalValue = UNSET;

  public ONotInCondition(int id) {
    super(id);
  }

  public ONotInCondition(OrientSql p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  @Override
  public boolean evaluate(OIdentifiable currentRecord, OCommandContext ctx) {
    throw new UnsupportedOperationException("TODO Implement NOT IN!!!");//TODO
  }

  @Override
  public boolean evaluate(OResult currentRecord, OCommandContext ctx) {
    throw new UnsupportedOperationException("TODO Implement NOT IN!!!");//TODO
  }

  public void toString(Map<Object, Object> params, StringBuilder builder) {

    left.toString(params, builder);
    builder.append(" NOT IN ");
    if (rightStatement != null) {
      builder.append("(");
      rightStatement.toString(params, builder);
      builder.append(")");
    } else if (right != null) {
      builder.append(convertToString(right));
    } else if (rightParam != null) {
      rightParam.toString(params, builder);
    } else if (rightMathExpression != null) {
      rightMathExpression.toString(params, builder);
    }
  }

  private String convertToString(Object o) {
    if (o instanceof String) {
      return "\"" + ((String) o).replaceAll("\"", "\\\"") + "\"";
    }
    return o.toString();
  }


  @Override
  public boolean supportsBasicCalculation() {

    if (operator != null && !operator.supportsBasicCalculation()) {
      return false;
    }
    if (left != null && !left.supportsBasicCalculation()) {
      return false;
    }
    if (rightMathExpression != null && !rightMathExpression.supportsBasicCalculation()) {
      return false;
    }
    return true;

  }

  @Override
  protected int getNumberOfExternalCalculations() {
    int total = 0;
    if (operator != null && !operator.supportsBasicCalculation()) {
      total++;
    }
    if (left != null && !left.supportsBasicCalculation()) {
      total++;
    }
    if (rightMathExpression != null && !rightMathExpression.supportsBasicCalculation()) {
      total++;
    }
    return total;
  }

  @Override
  protected List<Object> getExternalCalculationConditions() {
    List<Object> result = new ArrayList<Object>();
    if (operator != null && !operator.supportsBasicCalculation()) {
      result.add(this);
    }
    if (rightMathExpression != null && !rightMathExpression.supportsBasicCalculation()) {
      result.add(rightMathExpression);
    }
    return result;
  }

  @Override public boolean needsAliases(Set<String> aliases) {
    if(left.needsAliases(aliases)){
      return true;
    }

    if(rightMathExpression!=null && rightMathExpression.needsAliases(aliases)){
      return true;
    }
    return false;
  }

  @Override public ONotInCondition copy() {
    ONotInCondition result = new ONotInCondition(-1);
    result.operator = operator == null ? null : (OBinaryCompareOperator) operator.copy();
    result.left = left == null ? null : left.copy();
    result.rightMathExpression = rightMathExpression == null ? null : rightMathExpression.copy();
    result.rightStatement = rightStatement == null ? null : rightStatement.copy();
    result.rightParam = rightParam == null ? null : rightParam.copy();
    result.right = right == null ? null : right;
    return result;
  }

}
/* JavaCC - OriginalChecksum=8fb82bf72cc7d9cbdf2f9e2323ca8ee1 (do not edit this line) */
