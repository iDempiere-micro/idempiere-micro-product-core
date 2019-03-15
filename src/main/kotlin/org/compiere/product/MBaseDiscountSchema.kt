package org.compiere.product

import software.hsharp.core.util.DB
import software.hsharp.core.util.queryOf
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.Properties
import java.util.logging.Level

/**
 * Get Breaks
 *
 */
fun getBreaks(ctx: Properties, discountSchemaId: Int): Array<MDiscountSchemaBreak> {
    val sql = "SELECT * FROM M_DiscountSchemaBreak WHERE M_DiscountSchema_ID=? ORDER BY SeqNo"

    val query = queryOf(sql, listOf(discountSchemaId)).map { row -> MDiscountSchemaBreak(ctx, row) }.asList
    return DB.current.run(query).toTypedArray()
} //	getBreaks

/**
 * Get Lines
 *
 */
fun getLines(ctx: Properties, discountSchemaId: Int): Array<MDiscountSchemaLine> {
    val sql = "SELECT * FROM M_DiscountSchemaLine WHERE M_DiscountSchema_ID=? ORDER BY SeqNo"

    val query = queryOf(sql, listOf(discountSchemaId)).map { row -> MDiscountSchemaLine(ctx, row) }.asList
    return DB.current.run(query).toTypedArray()
}