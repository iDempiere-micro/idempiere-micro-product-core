package org.compiere.product.test

import org.compiere.model.I_M_Product
import org.compiere.orm.DefaultModelFactory
import org.compiere.orm.IModelFactory
import org.compiere.product.MProduct
import org.compiere.product.MUOM
import org.idempiere.common.util.Env
import org.idempiere.icommon.model.IPO
import software.hsharp.core.orm.DummyEventManager
import software.hsharp.core.util.HikariCPI
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

internal val sessionUrl = System.getenv("SESSION_URL") ?: "jdbc:postgresql://localhost:5433/idempiere"

abstract class BaseProductTest {
    init {
        HikariCPI.default(sessionUrl, "adempiere", "adempiere")
        DummyEventManager()
    }

    protected val someProductId = 136

    fun <T : IPO> getById(id: Int, tableName: String): T {
        val modelFactory: IModelFactory = DefaultModelFactory()
        val result = modelFactory.getPO(tableName, id, null)
        println(result)
        assertNotNull(result)
        val obj = result as T
        assertNotNull(obj)
        assertEquals(id, obj.id)
        return obj
    }

    protected fun getProductById(product_id: Int): I_M_Product {
        val modelFactory: IModelFactory = DefaultModelFactory()
        val result = modelFactory.getPO(I_M_Product.Table_Name, product_id, null)
        println(result)
        assertNotNull(result)
        val product = result as I_M_Product
        assertNotNull(product)
        assertEquals(product_id, product.id)
        return product
    }

    fun createAProduct(name: String, productType: String): I_M_Product {
        val standardProduct = getProductById(someProductId)
        val ctx = Env.getCtx()
        val product = MProduct(ctx, 0, null)
        product.name = name
        product.value = name
        product.c_UOM_ID = MUOM.getDefault_UOM_ID(ctx)
        product.m_Product_Category_ID = standardProduct.m_Product_Category_ID
        product.c_TaxCategory_ID = 107 // standard category
        product.productType = productType // I_M_Product.PRODUCTTYPE_Service
        product.save()
        return getProductById(product.id)
    }
}