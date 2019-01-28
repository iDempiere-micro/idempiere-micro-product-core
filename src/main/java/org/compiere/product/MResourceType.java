package org.compiere.product;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;
import org.compiere.model.I_S_ResourceType;
import org.idempiere.common.exceptions.AdempiereException;
import org.idempiere.common.exceptions.FillMandatoryException;
import org.idempiere.common.util.CCache;

/**
 * Resource Type Model
 *
 * @author Jorg Janke
 * @author Teo Sarca, www.arhipac.ro
 *     <li>FR [ 2051056 ] MResource[Type] should be cached
 *     <li>added manufacturing related methods (getDayStart, getDayEnd etc)
 *     <li>BF [ 2431049 ] If Time Slot then Time Slot Start/End should be mandatory
 * @version $Id: MResourceType.java,v 1.2 2006/07/30 00:51:03 jjanke Exp $
 */
public class MResourceType extends X_S_ResourceType {
  /** */
  private static final long serialVersionUID = 6303797933825680667L;
  /** Cache */
  private static CCache<Integer, MResourceType> s_cache =
      new CCache<Integer, MResourceType>(I_S_ResourceType.Table_Name, 20);

  /**
   * Standard Constructor
   *
   * @param ctx context
   * @param S_ResourceType_ID id
   */
  public MResourceType(Properties ctx, int S_ResourceType_ID, String trxName) {
    super(ctx, S_ResourceType_ID, trxName);
  } //	MResourceType

  /**
   * Load Constructor
   *
   * @param ctx context
   * @param rs result set
   */
  public MResourceType(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  } //	MResourceType

  /**
   * Get from Cache
   *
   * @param ctx
   * @param S_ResourceType_ID
   * @return MResourceType
   */
  public static MResourceType get(Properties ctx, int S_ResourceType_ID) {
    if (S_ResourceType_ID <= 0) return null;

    MResourceType type = s_cache.get(S_ResourceType_ID);
    if (type == null) {
      type = new MResourceType(ctx, S_ResourceType_ID, null);
      if (type.getId() == S_ResourceType_ID) {
        s_cache.put(S_ResourceType_ID, type);
      }
    }
    return type;
  }

  @Override
  protected boolean beforeSave(boolean newRecord) {
    if (isTimeSlot()) {
      Timestamp start = getTimeSlotStart();
      if (start == null)
        throw new FillMandatoryException(I_S_ResourceType.COLUMNNAME_TimeSlotStart);
      Timestamp end = getTimeSlotEnd();
      if (end == null) throw new FillMandatoryException(I_S_ResourceType.COLUMNNAME_TimeSlotEnd);
      if (start.compareTo(end) >= 0) {
        throw new AdempiereException("@TimeSlotStart@ > @TimeSlotEnd@");
      }
    }
    return true;
  }

  @Override
  protected boolean afterSave(boolean newRecord, boolean success) {
    if (!success) return false;

    //	Update Products
    if (!newRecord) {
      MProduct[] products =
          MProduct.get(
              getCtx(),
              "S_Resource_ID IN "
                  + "(SELECT S_Resource_ID FROM S_Resource WHERE S_ResourceType_ID="
                  + getS_ResourceType_ID()
                  + ")",
              null);
      for (MProduct product : products) {
        if (product.setResource(this)) {
          product.saveEx(null);
        }
      }
    }

    return success;
  } //	afterSave

    @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("MResourceType[")
        .append(getId())
        .append(",Value=")
        .append(getValue())
        .append(",Name=")
        .append(getName());
    if (isTimeSlot()) {
      SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
      sb.append(",TimeSlot=");
      Timestamp start = getTimeSlotStart();
      Timestamp end = getTimeSlotEnd();
      sb.append(start != null ? df.format(start) : " - ");
      sb.append("-");
      sb.append(end != null ? df.format(end) : " - ");
    }
    if (isDateSlot()) {
      sb.append(",DaySlot=")
          .append(isOnMonday() ? "M" : "-")
          .append(isOnTuesday() ? "T" : "-")
          .append(isOnWednesday() ? "W" : "-")
          .append(isOnThursday() ? "T" : "-")
          .append(isOnFriday() ? "F" : "-")
          .append(isOnSaturday() ? "S" : "-")
          .append(isOnSunday() ? "S" : "-");
    }
    return sb.append("]").toString();
  }
} //	MResourceType
