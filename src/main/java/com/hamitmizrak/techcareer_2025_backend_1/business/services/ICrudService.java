package com.hamitmizrak.techcareer_2025_backend_1.business.services;

import java.util.List;

// D: Dto
// E: Entity
public interface ICrudService<D,E>  {

    // CREATE
    public D objectServiceCreate(D d);

    // LIST
    public List<D> objectServiceList();

    // FIND BY ID
    public D objectServiceFindById(Long id);

    // UPDATE
    public D objectServiceUpdate(Long id, D d);

    // DELETE
    public D objectServiceDelete(Long id);

}
