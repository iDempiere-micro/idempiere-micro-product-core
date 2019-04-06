package org.compiere.product.test

import org.compiere.model.I_M_Product
import org.compiere.orm.DefaultModelFactory
import org.compiere.orm.IModelFactory
import org.compiere.product.MProduct
import org.compiere.product.MUOM
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
        val result: T = modelFactory.getPO(tableName, id)
        println(result)
        assertNotNull(result)
        assertEquals(id, result.id)
        return result
    }

    protected fun getProductById(product_id: Int): I_M_Product {
        val modelFactory: IModelFactory = DefaultModelFactory()
        val result: I_M_Product = modelFactory.getPO(I_M_Product.Table_Name, product_id)
        println(result)
        assertNotNull(result)
        assertNotNull(result)
        assertEquals(product_id, result.id)
        return result
    }

    fun createAProduct(name: String, productType: String): I_M_Product {
        val standardProduct = getProductById(someProductId)
        val product = MProduct(0)
        product.name = name
        product.searchKey = name
        product.uomId = MUOM.getDefault_UOMId()
        product.productCategoryId = standardProduct.productCategoryId
        product.taxCategoryId = 107 // standard category
        product.productType = productType // I_M_Product.PRODUCTTYPE_Service
        product.save()
        return getProductById(product.id)
    }
}