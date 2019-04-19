package org.compiere.product;

import kotliquery.Row;
import org.idempiere.icommon.model.PersistentObject;

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
     * @param ctx context
     */
    public MAssetChange(int A_Asset_Change_ID) {
        super(A_Asset_Change_ID);
    } //	MAssetChange

    /**
     * Load Constructor
     *
     * @param ctx context
     */
    public MAssetChange(Row row) {
        super(row);
    } //	MInventoryLine

    /**
     * TODO
     *
     * @param changeType
     * @param pos
     * @return
     */
    public static MAssetChange createAndSave(
            String changeType, PersistentObject[] pos) {
        return null;
        // ~ return create(changeType, pos, true);
    }

    /** ARHIPAC: TEO: END ------------------------------------------------------------------ */
} //	MAssetChange
