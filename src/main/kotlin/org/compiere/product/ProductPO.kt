package org.compiere.product

import kotliquery.Row
import org.compiere.orm.PO
import software.hsharp.core.util.Environment
import software.hsharp.modules.Module

abstract class ProductPO(row: Row?, id: Int) : PO(row, id), Module by Environment<Module>().module