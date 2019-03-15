import org.compiere.model.I_M_Product
import org.compiere.product.test.BaseProductTest
import org.junit.Test
import software.hsharp.core.util.DB
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