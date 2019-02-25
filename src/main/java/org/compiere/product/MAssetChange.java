package org.compiere.product;

import org.compiere.orm.PO;
import org.idempiere.common.util.CLogger;
import org.idempiere.icommon.model.IPO;

import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;

/**
 * Asset Addition Model
 *
 * @author Teo Sarca, SC ARHIPAC SERVICE SRL
 */
public class MAssetChange extends X_A_Asset_Change {
    /**
     *
     */
    private static final long serialVersionUID = 4083373951793617528L;

    /**
     * Default Constructor
     *
     * @param ctx                context
     * @param M_InventoryLine_ID line
     */
    public MAssetChange(Properties ctx, int A_Asset_Change_ID) {
        super(ctx, A_Asset_Change_ID);
    } //	MAssetChange

    /**
     * Load Constructor
     *
     * @param ctx context
     * @param rs  result set
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

    /** ARHIPAC: TEO: END ------------------------------------------------------------------ */
} //	MAssetChange
