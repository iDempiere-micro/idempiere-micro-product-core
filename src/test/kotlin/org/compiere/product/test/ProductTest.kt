import org.compiere.model.I_M_Product
import org.compiere.orm.DefaultModelFactory
import org.compiere.product.test.BaseProductTest
import org.idempiere.common.util.EnvironmentServiceImpl
import org.junit.Test
import software.hsharp.core.modules.BaseModuleImpl
import software.hsharp.core.util.DB
import software.hsharp.core.util.Environment
import java.util.Random

/**
 * Generate a random string (small letters)
 */
fun randomString(length: Int): String {
    fun ClosedRange<Char>.randomString(length: Int) =
        (1..length)
            .map { (Random().nextInt(endInclusive.toInt() - start.toInt()) + start.toInt()).toChar() }
            .joinToString("")
    return ('a'..'z').randomString(length)
}

internal const val clientId = 11

internal val environmentService = EnvironmentServiceImpl(clientId, 0, 0)
internal val baseModule = BaseModuleImpl(environmentService = environmentService, modelFactory = DefaultModelFactory())

class ProductTest : BaseProductTest() {
    @Test
    fun `getting a product using DefaultModelFactory should work`() {
        Environment.run(baseModule) {
            DB.run {
                getProductById(someProductId)
            }
        }
    }

    @Test
    fun `creating a new service product should work`() {
        Environment.run(baseModule) {
            DB.run {
                createAProduct("S-" + randomString(10), I_M_Product.PRODUCTTYPE_Service)
            }
        }
    }
}