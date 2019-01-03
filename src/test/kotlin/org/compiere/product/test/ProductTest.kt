import company.bigger.test.support.randomString
import org.compiere.model.I_M_Product
import org.compiere.product.test.BaseProductTest
import org.junit.Test
import software.hsharp.core.util.DB

class ProductTest : BaseProductTest() {
    @Test
    fun `getting a product using DefaultModelFactory should work`() {
        DB.run {
            getProductById(someProductId)
        }
    }

    @Test
    fun `creating a new service product should work`() {
        DB.run {
            createAProduct("S-" + randomString(10), I_M_Product.PRODUCTTYPE_Service)
        }
    }
}