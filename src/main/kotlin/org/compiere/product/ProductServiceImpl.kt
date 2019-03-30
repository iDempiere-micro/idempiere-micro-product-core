package org.compiere.product

import org.compiere.model.I_M_Product
import software.hsharp.core.models.EnvironmentService
import software.hsharp.core.orm.BaseDataServiceImpl
import software.hsharp.services.ProductService

class ProductServiceImpl(
    environmentService: EnvironmentService
) : BaseDataServiceImpl<I_M_Product>(environmentService, I_M_Product.Table_Name, false), ProductService