package com.hamitmizrak.techcareer_2025_backend_1.business.services.impl;

import com.hamitmizrak.techcareer_2025_backend_1.business.dto.AddressDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.IAddressService;
import com.hamitmizrak.techcareer_2025_backend_1.data.entity.AddressEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public class AddresServiceImpl implements IAddressService<AddressDto, AddressEntity> {
    @Override
    public AddressDto objectServiceCreate(AddressDto addressDto) {
        return null;
    }

    @Override
    public List<AddressDto> objectServiceList() {
        return List.of();
    }

    @Override
    public AddressDto objectServiceFindById(Long id) {
        return null;
    }

    @Override
    public AddressDto objectServiceUpdate(Long id, AddressDto addressDto) {
        return null;
    }

    @Override
    public AddressDto objectServiceDelete(Long id) {
        return null;
    }

    @Override
    public AddressDto entityToDto(AddressEntity addressEntity) {
        return null;
    }

    @Override
    public AddressEntity dtoToEntity(AddressDto addressDto) {
        return null;
    }

    @Override
    public Page<AddressDto> objectServicePagination(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public List<AddressDto> objectServiceListSortedBy(String sortedBy) {
        return List.of();
    }

    @Override
    public List<AddressDto> objectServiceListSortedByAsc() {
        return List.of();
    }

    @Override
    public List<AddressDto> objectServiceListSortedByDesc() {
        return List.of();
    }
}
