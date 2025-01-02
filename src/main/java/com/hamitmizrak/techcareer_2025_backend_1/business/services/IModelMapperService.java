package com.hamitmizrak.techcareer_2025_backend_1.business.services;

// D: Dto
// E: Entity
public interface IModelMapperService<D,E> {

    // Model Mapper
    public D entityToDto(E e);
    public E dtoToEntity(D d);
}
