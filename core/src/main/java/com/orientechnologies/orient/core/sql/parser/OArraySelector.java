/* Generated By:JJTree: Do not edit this line. OArraySelector.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import com.orientechnologies.orient.core.command.OCommandContext;
import com.orientechnologies.orient.core.db.record.OIdentifiable;
import com.orientechnologies.orient.core.sql.executor.OResult;

import java.util.Map;
import java.util.Set;

public class OArraySelector extends SimpleNode {

  protected ORid            rid;
  protected OInputParameter inputParam;
  protected OExpression     expression;
  protected OInteger        integer;

  public OArraySelector(int id) {
    super(id);
  }

  public OArraySelector(OrientSql p, int id) {
    super(p, id);
  }

  /**
   * Accept the visitor.
   **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  public void toString(Map<Object, Object> params, StringBuilder builder) {
    if (rid != null) {
      rid.toString(params, builder);
    } else if (inputParam != null) {
      inputParam.toString(params, builder);
    } else if (expression != null) {
      expression.toString(params, builder);
    } else if (integer != null) {
      integer.toString(params, builder);
    }
  }

  public Integer getValue(OIdentifiable iCurrentRecord, Object iResult, OCommandContext ctx) {
    Object result = null;
    if (inputParam != null) {
      result = inputParam.bindFromInputParams(ctx.getInputParameters());
    } else if (expression != null) {
      result = expression.execute(iCurrentRecord, ctx);
    } else if (integer != null) {
      result = integer;
    }

    if (result == null) {
      return null;
    }
    if (result instanceof Number) {
      return ((Number) result).intValue();
    }
    return null;
  }

  public Integer getValue(OResult iCurrentRecord, Object iResult, OCommandContext ctx) {
    Object result = null;
    if (inputParam != null) {
      result = inputParam.bindFromInputParams(ctx.getInputParameters());
    } else if (expression != null) {
      result = expression.execute(iCurrentRecord, ctx);
    } else if (integer != null) {
      result = integer;
    }

    if (result == null) {
      return null;
    }
    if (result instanceof Number) {
      return ((Number) result).intValue();
    }
    return null;
  }

  public boolean needsAliases(Set<String> aliases) {
    if (expression != null) {
      return expression.needsAliases(aliases);
    }
    return false;
  }

  public OArraySelector copy(){
    OArraySelector result = new OArraySelector(-1);

    result.rid = rid==null?null:rid.copy();
    result.inputParam = inputParam==null?null:inputParam.copy();
    result.expression = expression==null?null:expression.copy();
    result.integer = integer==null?null:integer.copy();

    return result;
  }
}
/* JavaCC - OriginalChecksum=f87a5543b1dad0fb5f6828a0663a7c9e (do not edit this line) */
