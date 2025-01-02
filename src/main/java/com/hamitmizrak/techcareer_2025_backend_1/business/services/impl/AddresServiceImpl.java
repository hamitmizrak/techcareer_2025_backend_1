package com.hamitmizrak.techcareer_2025_backend_1.business.services.impl;

import com.hamitmizrak.techcareer_2025_backend_1.business.dto.AddressDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.IAddressService;
import com.hamitmizrak.techcareer_2025_backend_1.data.entity.AddressEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

// Yapılacaklar
// Service
// Api
// Swagger
// H2DB
// Postman
// Runner
// CustomerDto-----
// Relation (AddressDto -  CustomerDto )


// LOMBOK
@Getter
@Setter
//@ToString
//@EqualsAndHashCode
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@RequiredArgsConstructor
@Log4j2

//Service:  Asıl İş Yükünü yapan bean
@Service
public class AddresServiceImpl implements IAddressService<AddressDto, AddressEntity> {

    // INJECTION

    // Model Mapper
    @Override
    public AddressDto entityToDto(AddressEntity addressEntity) {
        return null;
    }

    @Override
    public AddressEntity dtoToEntity(AddressDto addressDto) {
        return null;
    }


    ////////////////////////////////////////////////////////////////
    // TRANSACTION
    /*
    propagation: İşlem yayılım seviyesini belirler. Varsayılan Propagation.REQUIRED'dır.
    isolation: İşlem izolasyon seviyesini belirler. Varsayılan Isolation.DEFAULT'tır.
    readOnly: İşlemin yalnızca okuma amaçlı olduğunu belirtir. Varsayılan false'dur.
    timeout: İşlemin maksimum süresini (saniye cinsinden) belirtir. Varsayılan -1 (sınırsızdır).
    rollbackFor: Hangi istisnalar için işlemin geri alınacağını belirtir.
    noRollbackFor: Hangi istisnalar için işlemin geri alınmayacağını belirtir.
    */

    /*
    @Transactional Özelliklerinin Açıklamaları
    propagation (İşlem Yayılım Seviyesi):
    REQUIRED (Varsayılan): Mevcut bir işlem varsa kullanır, yoksa yeni bir işlem başlatır.
    REQUIRES_NEW: Her zaman yeni bir işlem başlatır.
    MANDATORY: Mevcut bir işlem yoksa hata verir.
    SUPPORTS: Mevcut bir işlem varsa kullanır, yoksa işlem başlatmaz.
    NOT_SUPPORTED: İşlem başlatmaz, mevcut bir işlem varsa askıya alır.
    NEVER: İşlem olmamalıdır, aksi halde hata verir.
    NESTED: Ana işlemin içinde bir alt işlem oluşturur.

    isolation (İşlem İzolasyon Seviyesi)
    DEFAULT: Varsayılan izolasyon seviyesini kullanır.
    READ_UNCOMMITTED: Kirli okuma yapabilir.
    READ_COMMITTED: Kirli okumayı engeller.
    REPEATABLE_READ: Tekrarlanabilir okuma sağlar.
    SERIALIZABLE: Tam izolasyon sağlar, en yavaş ama en güvenli.

    readOnly:
    true: Veritabanında yalnızca okuma işlemlerine izin verir.
    false: Yazma işlemleri de yapılabilir.

    timeout:
    İşlemin maksimum süresini belirtir. Süre aşılırsa işlem geri alınır.

    rollbackFor ve noRollbackFor:
    Hangi istisnalar için işlem geri alınsın veya alınmasın ayarlanabilir.
     */


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


    ////////////////////////////////////////////////////////////////
    // PAGE & SORT
    // PAGE
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
