package org.compiere.product.test

import org.compiere.model.I_M_Product
import org.compiere.orm.DefaultModelFactory
import org.compiere.orm.IModelFactory
import org.compiere.product.MProduct
import org.compiere.product.MUOM
import org.idempiere.common.util.Env
import org.idempiere.icommon.model.IPO
import software.hsharp.core.util.HikariCPI
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

internal val sessionUrl = System.getenv("SESSION_URL") ?: "jdbc:postgresql://localhost:5433/idempiere"

abstract class BaseProductTest {
    init {
        HikariCPI.default(sessionUrl, "adempiere", "adempiere")
    }

    protected val someProductId = 136

    fun <T : IPO> getById(id: Int, tableName: String): T {
        val modelFactory: IModelFactory = DefaultModelFactory()
        val result = modelFactory.getPO(tableName, id)
        println(result)
        assertNotNull(result)
        @Suppress("UNCHECKED_CAST")
        val obj = result as T
        assertNotNull(obj)
        assertEquals(id, obj.id)
        return obj
    }

    protected fun getProductById(product_id: Int): I_M_Product {
        val modelFactory: IModelFactory = DefaultModelFactory()
        val result = modelFactory.getPO(I_M_Product.Table_Name, product_id)
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
        val product = MProduct(ctx, 0)
        product.name = name
        product.value = name
        product.uomId = MUOM.getDefault_UOMId(ctx)
        product.productCategoryId = standardProduct.productCategoryId
        product.taxCategoryId = 107 // standard category
        product.productType = productType // I_M_Product.PRODUCTTYPE_Service
        product.save()
        return getProductById(product.id)
    }
}