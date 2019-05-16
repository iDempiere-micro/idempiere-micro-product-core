package org.compiere.product

import kotliquery.Row
import org.compiere.orm.BasePOUser
import software.hsharp.core.util.Environment
import software.hsharp.modules.Module

abstract class ProductPOUser(row: Row?, id: Int) : BasePOUser(row, id), Module by Environment<Module>().module