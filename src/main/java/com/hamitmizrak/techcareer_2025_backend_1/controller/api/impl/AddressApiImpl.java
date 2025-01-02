package com.hamitmizrak.techcareer_2025_backend_1.controller.api.impl;

import com.hamitmizrak.techcareer_2025_backend_1.business.dto.AddressDto;
import com.hamitmizrak.techcareer_2025_backend_1.controller.api.interfaces.IAddressApi;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AddressApiImpl implements IAddressApi<AddressDto> {

    @Override
    public ResponseEntity<?> objectApiCreate(AddressDto addressDto) {
        return null;
    }

    @Override
    public ResponseEntity<List<AddressDto>> objectApiList() {
        return null;
    }

    @Override
    public ResponseEntity<?> objectApiFindById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> objectApiUpdate(Long id, AddressDto addressDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> objectApiDelete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<?>> objectServicePagination(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public ResponseEntity<List<AddressDto>> objectServiceListSortedBy(String sortedBy) {
        return null;
    }

    @Override
    public ResponseEntity<List<AddressDto>> objectServiceListSortedByAsc() {
        return null;
    }

    @Override
    public ResponseEntity<List<AddressDto>> objectServiceListSortedByDesc() {
        return null;
    }
}
