/* Generated By:JJTree: Do not edit this line. OIfStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OIfStatement extends OStatement {
  protected OBooleanExpression expression;
  protected List<OStatement> statements = new ArrayList<OStatement>();

  public OIfStatement(int id) {
    super(id);
  }

  public OIfStatement(OrientSql p, int id) {
    super(p, id);
  }

  @Override public void toString(Map<Object, Object> params, StringBuilder builder) {
    builder.append("IF(");
    expression.toString(params, builder);
    builder.append("){\n");
    for (OStatement stm : statements) {
      stm.toString(params, builder);
      builder.append(";\n");
    }
    builder.append("}");
  }

  @Override public OIfStatement copy() {
    OIfStatement result = new OIfStatement(-1);
    result.expression = expression == null ? null : expression.copy();
    result.statements = statements == null ? null : statements.stream().map(OStatement::copy).collect(Collectors.toList());
    return result;
  }
}
/* JavaCC - OriginalChecksum=a8cd4fb832a4f3b6e71bb1a12f8d8819 (do not edit this line) */
