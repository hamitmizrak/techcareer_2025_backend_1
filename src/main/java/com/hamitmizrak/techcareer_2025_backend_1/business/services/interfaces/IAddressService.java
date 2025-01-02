package com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces;


import com.hamitmizrak.techcareer_2025_backend_1.business.services.ICrudService;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.IModelMapperService;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.ISortingPagingService;

public interface IAddressService<D,E>
        extends IModelMapperService<D,E>,
        ICrudService<D,E>,
        ISortingPagingService<D,E> {

    // Special Address
}
