package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Serial Number Control Model
 *
 * @author Jorg Janke
 * @version $Id: MSerNoCtl.java,v 1.3 2006/07/30 00:51:05 jjanke Exp $
 */
public class MSerNoCtl extends X_M_SerNoCtl {
  /** */
  private static final long serialVersionUID = -6746210722573475011L;

  /**
   * Standard Constructor
   *
   * @param ctx context
   * @param M_SerNoCtl_ID id
   * @param trxName transaction
   */
  public MSerNoCtl(Properties ctx, int M_SerNoCtl_ID, String trxName) {
    super(ctx, M_SerNoCtl_ID, trxName);
    if (M_SerNoCtl_ID == 0) {
      //	setM_SerNoCtl_ID (0);
      setStartNo(1);
      setCurrentNext(1);
      setIncrementNo(1);
      //	setName (null);
    }
  } //	MSerNoCtl

  /**
   * Load Constructor
   *
   * @param ctx context
   * @param rs result set
   * @param trxName transaction
   */
  public MSerNoCtl(Properties ctx, ResultSet rs, String trxName) {
    super(ctx, rs, trxName);
  } //	MSerNoCtl

  /**
   * Create new Lot. Increments Current Next and Commits
   *
   * @return saved Lot
   */
  public String createSerNo() {
    StringBuilder name = new StringBuilder();
    if (getPrefix() != null) name.append(getPrefix());
    int no = getCurrentNext();
    name.append(no);
    if (getSuffix() != null) name.append(getSuffix());
    //
    no += getIncrementNo();
    setCurrentNext(no);
    saveEx();
    return name.toString();
  } //	createSerNo
} //	MSerNoCtl
