package com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces;


import com.hamitmizrak.techcareer_2025_backend_1.business.services.ICrudService;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.IModelMapperService;

public interface IOrderService<D,E>
        extends IModelMapperService<D,E>,
        ICrudService<D,E> {

    // Special Address
}
