/* Generated By:JJTree: Do not edit this line. OUpdateStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import com.orientechnologies.orient.core.storage.OStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OUpdateStatement extends OStatement {
  public OFromClause target;

  protected List<OUpdateOperations> operations = new ArrayList<OUpdateOperations>();

  protected boolean upsert = false;

  protected boolean returnBefore = false;
  protected boolean returnAfter  = false;
  protected OProjection returnProjection;

  public OWhereClause whereClause;

  public OStorage.LOCKING_STRATEGY lockRecord = null;

  public OLimit   limit;
  public OTimeout timeout;

  public OUpdateStatement(int id) {
    super(id);
  }

  public OUpdateStatement(OrientSql p, int id) {
    super(p, id);
  }

  public void toString(Map<Object, Object> params, StringBuilder builder) {
    builder.append(getStatementType());
    if (target != null) {
      target.toString(params, builder);
    }

    for (OUpdateOperations ops : this.operations) {
      builder.append(" ");
      ops.toString(params, builder);
    }

    if (upsert) {
      builder.append(" UPSERT");
    }

    if (returnBefore || returnAfter) {
      builder.append(" RETURN");
      if (returnBefore) {
        builder.append(" BEFORE");
      } else {
        builder.append(" AFTER");
      }
      if (returnProjection != null) {
        builder.append(" ");
        returnProjection.toString(params, builder);
      }
    }
    if (whereClause != null) {
      builder.append(" WHERE ");
      whereClause.toString(params, builder);
    }

    if (lockRecord != null) {
      builder.append(" LOCK ");
      switch (lockRecord) {
      case DEFAULT:
        builder.append("DEFAULT");
        break;
      case EXCLUSIVE_LOCK:
        builder.append("RECORD");
        break;
      case SHARED_LOCK:
        builder.append("SHARED");
        break;
      case NONE:
        builder.append("NONE");
        break;
      }
    }
    if (limit != null) {
      limit.toString(params, builder);
    }
    if (timeout != null) {
      timeout.toString(params, builder);
    }
  }

  protected String getStatementType() {
    return "UPDATE ";
  }

  @Override public OUpdateStatement copy() {
    OUpdateStatement result = new OUpdateStatement(-1);
    result.target = target == null ? null : target.copy();
    result.operations = operations == null ? null : operations.stream().map(x -> x.copy()).collect(Collectors.toList());
    result.upsert = upsert;
    result.returnBefore = returnBefore;
    result.returnAfter = returnAfter;
    result.returnProjection = returnProjection == null ? null : returnProjection.copy();
    result.whereClause = whereClause == null ? null : whereClause.copy();
    result.lockRecord = lockRecord;
    result.limit = limit == null ? null : limit.copy();
    result.timeout = timeout == null ? null : timeout.copy();
    return result;
  }
}
/* JavaCC - OriginalChecksum=093091d7273f1073ad49f2a2bf709a53 (do not edit this line) */
