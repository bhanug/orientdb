/* Generated By:JJTree: Do not edit this line. OSleepStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import java.util.Map;

public class OSleepStatement extends OStatement {

  protected OInteger millis;

  public OSleepStatement(int id) {
    super(id);
  }

  public OSleepStatement(OrientSql p, int id) {
    super(p, id);
  }

  @Override public void toString(Map<Object, Object> params, StringBuilder builder) {
    builder.append("SLEEP ");
    millis.toString(params, builder);
  }

  @Override public OSleepStatement copy() {
    OSleepStatement result = new OSleepStatement(-1);
    result.millis = millis == null ? null : millis.copy();
    return result;
  }
}
/* JavaCC - OriginalChecksum=2ea765ee266d4215414908b0e09c0779 (do not edit this line) */
