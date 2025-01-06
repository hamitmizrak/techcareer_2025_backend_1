package com.hamitmizrak.techcareer_2025_backend_1.business.services.impl;

import com.hamitmizrak.techcareer_2025_backend_1.bean.ModelMapperBean;
import com.hamitmizrak.techcareer_2025_backend_1.business.dto.AddressDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.IAddressService;
import com.hamitmizrak.techcareer_2025_backend_1.data.entity.AddressEntity;
import com.hamitmizrak.techcareer_2025_backend_1.data.mapper.AddressMapper;
import com.hamitmizrak.techcareer_2025_backend_1.data.repository.IAddressRepository;
import com.hamitmizrak.techcareer_2025_backend_1.exception.HamitMizrakException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
@RequiredArgsConstructor //for injection
@Log4j2

//Service:  Asıl İş Yükünü yapan bean
@Service
public class AddresServiceImpl implements IAddressService<AddressDto, AddressEntity> {

    // INJECTION
    private final IAddressRepository iAddressRepository;
    private final ModelMapperBean modelMapperBean;

    //////////////////////////////////////////////////////////////////////////////////////////////////
    // Model Mapper
    @Override
    public AddressDto entityToDto(AddressEntity addressEntity) {
        // 1.YOL (ModelMapper)
        //return modelMapperBean.getModelMapperSingleton().map(addressEntity, AddressDto.class);

        // 2.YOL (Mapper My Special)
        return AddressMapper.AddressEntityToAddressDto(addressEntity);
    }

    @Override
    public AddressEntity dtoToEntity(AddressDto addressDto) {
        // 1.YOL (ModelMapper)
        //return modelMapperBean.getModelMapperSingleton().map(addressDto, AddressEntity.class);

        // 2.YOL (Mapper My Special)
        return AddressMapper.AddressDtoToAddressEntity(addressDto);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    // TRANSACTION
    /*
    Dikkat: Transaction için bunu kullan. => org.springframework.transaction.annotation.Transactional;
    Manipulation for process: Create, Delete, Update

    propagation: İşlem yayılım seviyesini belirler. Varsayılan Propagation.REQUIRED'dır.
    isolation: İşlem izolasyon seviyesini belirler. Varsayılan Isolation.DEFAULT'tır.
    readOnly: İşlemin yalnızca okuma amaçlı olduğunu belirtir. Varsayılan false'dur.
    timeout: İşlemin maksimum süresini (saniye cinsinden) belirtir. Varsayılan -1 (sınırsızdır).
    rollbackFor: Hangi istisnalar için işlemin geri alınacağını belirtir.
    noRollbackFor: Hangi istisnalar için işlemin geri alınmayacağını belirtir.

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

    // CREATE (Address)
    @Override
    // Manipulation for process: Create, Delete, Update
    @Transactional(
            propagation = Propagation.REQUIRED, // Varsayılan yayılım. İşlem varsa mevcut işlem kullanılır.
            isolation = Isolation.READ_COMMITTED, // İzolasyon seviyesi: READ_COMMITTED
            readOnly = false, // Yazma işlemi olduğu için false
            timeout = 30, // Maksimum 30 saniyede işlem tamamlanmalı
            rollbackFor = {Exception.class}, // Tüm istisnalar için rollback yapılır
            noRollbackFor = {IllegalArgumentException.class} // IllegalArgumentException rollback yapmaz
    )
    public AddressDto objectServiceCreate(AddressDto addressDto) {
        AddressDto addressDtoSave = null;
        // AddressDto içinde veri varsa
        if (addressDto != null) {
            // AddressEntity
            AddressEntity addressEntitySave = dtoToEntity(addressDto);
            // Database Hibernate kayıt eklerken ID'li veriyide almak için
            addressDtoSave = entityToDto(iAddressRepository.save(addressEntitySave));
        } else {
            throw new HamitMizrakException("null pointer exception message");
        }
        return addressDtoSave;
    }

    // LIST (Address)
    @Override
    public List<AddressDto> objectServiceList() {
        // List AddressEntity
        List<AddressEntity> addressEntityList = iAddressRepository.findAll();

        // List AddressDto
        List<AddressDto> addressDtoList = new ArrayList<>();

        if (addressEntityList != null) {
            // 1.YOL (List AddressDto)
            /*
            for (AddressEntity addressEntity : addressEntityList) {
                addressDtoList.add(entityToDto(addressEntity));
            }
            */

            // 2.YOL (List AddressDto)
            addressDtoList = addressEntityList.stream()
                    //.sorted(Comparator.comparing((temp)-> temp.getDetailsEmbeddable().getCity())
                    //.map((mapTemp)->AddressMapper.AddressEntityToAddressDto(mapTemp))// 1.YOL (Lambda Expression)
                    .map(AddressMapper::AddressEntityToAddressDto)// 2.YOL (Method Referances)
                    .collect(Collectors.toList());
        } else {
            throw new NotFoundException("null pointer exception message");
        }
        return addressDtoList;
    }

    // FIND (Address)
    @Override
    public AddressDto objectServiceFindById(Long id) {
        return null;
    }

    // UPDATE (Address)
    @Override
    @Transactional // Manipulation for process: Create, Delete, Update
    public AddressDto objectServiceUpdate(Long id, AddressDto addressDto) {
        if (addressDto != null) {

        } else {
            throw new NotFoundException("null pointer exception message");
        }
        return null;
    }

    // DELETE (Address)
    @Override
    @Transactional // Manipulation for process: Create, Delete, Update
    public AddressDto objectServiceDelete(Long id) {
        if (id != null) {

        } else {
            throw new NotFoundException("null pointer exception message");
        }
        return null;
    }


    ////////////////////////////////////////////////////////////////
    // PAGE & SORT
    // PAGINATION (Address)
    @Override
    public Page<AddressDto> objectServicePagination(int currentPage, int pageSize) {
        return null;
    }

    // SORT (Address)
    @Override
    public List<AddressDto> objectServiceListSortedBy(String sortedBy) {
        return List.of();
    }

    // SORT ASC (Address)
    @Override
    public List<AddressDto> objectServiceListSortedByAsc() {
        return List.of();
    }

    // SORT DESC (Address)
    @Override
    public List<AddressDto> objectServiceListSortedByDesc() {
        return List.of();
    }

} //end AddressServiceImpl
