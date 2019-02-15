package org.compiere.product;

import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;
import org.compiere.orm.PO;
import org.idempiere.common.util.CLogger;
import org.idempiere.icommon.model.IPO;

/**
 * Asset Addition Model
 *
 * @author Teo Sarca, SC ARHIPAC SERVICE SRL
 */
public class MAssetChange extends X_A_Asset_Change {
  /** */
  private static final long serialVersionUID = 4083373951793617528L;

  /** Static Logger */
  private static CLogger s_log = CLogger.getCLogger(MAssetChange.class);

  /**
   * Default Constructor
   *
   * @param ctx context
   * @param M_InventoryLine_ID line
   */
  public MAssetChange(Properties ctx, int A_Asset_Change_ID) {
    super(ctx, A_Asset_Change_ID);
  } //	MAssetChange

  /**
   * Load Constructor
   *
   * @param ctx context
   * @param rs result set
   */
  public MAssetChange(Properties ctx, ResultSet rs) {
    super(ctx, rs);
  } //	MInventoryLine

    /**
   * TODO
   *
   * @param ctx
   * @param changeType
   * @param pos
   * @param trxName
   * @return
   */
  public static MAssetChange createAndSave(
      Properties ctx, String changeType, IPO[] pos) {
    return null;
    // ~ return create(ctx, changeType, pos, true);
  }

    public void addChanges(PO po) {
    if (log.isLoggable(Level.FINE)) log.fine("Entering: po=" + po);
    if (po == null) {
      return;
    }
    /* arhipac: teo_sarca: TODO need to integrate
    for(int idx = 0; idx < po.get_ColumnCount_P(); idx++) {
    	//~ if(!po.is_ValueChanged(idx)) {
    		//~ continue;
    	//~ }
    	String colName = po.get_ColumnName_P(idx);
    	int idx2 = get_ColumnIndex(colName);
    	if(idx2 < 0) {
    		if(CLogMgt.isLevelFine()) log.fine("Setting " + colName + ": SKIP (idx2 < 0)");
    		continue;
    	}

    	Object value = po.get_Value(idx2);
    	set_Value(colName, value);
    	if(CLogMgt.isLevelFine()) log.fine("Setting " + colName + "=" + value + " (from " + po.getClass() + ", idx=" + idx + ", idx2=" + idx2 + ")");
    }
    */
    //
    if (log.isLoggable(Level.FINE)) log.fine("Leaving: po=" + po);
  }
  /** ARHIPAC: TEO: END ------------------------------------------------------------------ */
} //	MAssetChange
