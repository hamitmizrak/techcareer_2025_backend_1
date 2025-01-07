package com.hamitmizrak.techcareer_2025_backend_1.business.services.impl;

import com.hamitmizrak.techcareer_2025_backend_1.bean.ModelMapperBean;
import com.hamitmizrak.techcareer_2025_backend_1.business.dto.AddressDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.IAddressService;
import com.hamitmizrak.techcareer_2025_backend_1.data.embedded.AddressEntityDetailsEmbeddable;
import com.hamitmizrak.techcareer_2025_backend_1.data.entity.AddressEntity;
import com.hamitmizrak.techcareer_2025_backend_1.data.mapper.AddressMapper;
import com.hamitmizrak.techcareer_2025_backend_1.data.repository.IAddressRepository;
import com.hamitmizrak.techcareer_2025_backend_1.exception.HamitMizrakException;
import com.hamitmizrak.techcareer_2025_backend_1.exception._404_NotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.webjars.NotFoundException;
import java.util.ArrayList;
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

    // FIND BY ID (Address)
    // REDIS : için aşağıdaki linktten çalışıp çalışmadığını bu linkten anlayabiliriz
    // http://localhost:4444/api/address/v1.0.0/find/1
    @Cacheable(value = "addressFindByIdCache", key = "#id")
    @Override
    public AddressDto objectServiceFindById(Long id) {
        // AddressEntity (1.YOL Optional)
        /*
        Boolean addressEntityBoolean = iAddressRepository.findById(id).isEmpty();
        if(addressEntityBoolean && ) {
            return AddressMapper.AddressEntityToAddressDto(iAddressRepository.findById(id).get());
        }else{
            throw new NotFoundException("null pointer exception message");
        }
        */

        // AddressEntity (2.YOL Optional)
        //return AddressMapper.AddressEntityToAddressDto(iAddressRepository.findById(id).orElse(null));
        // AddressEntity (3.YOL Optional)
        AddressDto addressDtoFind = iAddressRepository
                .findById(id)
                .map(AddressMapper::AddressEntityToAddressDto)
                .orElseThrow(() -> new _404_NotFoundException(id + " nolu veri yoktur."));
        if (addressDtoFind.getIsDeleted()) {
            System.out.println("Aradığınız Veri bulunmamaktadır.");
        }
            return addressDtoFind;
    }

    // UPDATE (Address)
    @Override
    @Transactional // Manipulation for process: Create, Delete, Update
    public AddressDto objectServiceUpdate(Long id, AddressDto addressDto) {

        // Öncelelikle ilgili Adresi ID ile bulalım
        AddressEntity addressEntityUpdate = dtoToEntity(objectServiceFindById(id));

        // Embeddable Set
        AddressEntityDetailsEmbeddable detailsEmbeddable = new AddressEntityDetailsEmbeddable();
        detailsEmbeddable.setState(addressDto.getState());
        detailsEmbeddable.setCity(addressDto.getCity());
        detailsEmbeddable.setCountry(addressDto.getCountry());
        detailsEmbeddable.setStreet(addressDto.getStreet());
        detailsEmbeddable.setDescription(addressDto.getDescription());
        detailsEmbeddable.setZipCode(addressDto.getZipCode());
        detailsEmbeddable.setDoorNumber(addressDto.getDoorNumber());
        detailsEmbeddable.setAvenue(addressDto.getAvenue());
        detailsEmbeddable.setAddressQrCode(addressDto.getAddressQrCode());

        // Embeddable AddressEntity Set et
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(id);
        addressEntity.setDetailsEmbeddable(detailsEmbeddable);

        // Database kaydet
        addressDto = entityToDto(iAddressRepository.save(addressEntity));
        return addressDto;
    }

    // DELETE (Address)
    @Override
    // Manipulation for process: Create, Delete, Update
    @Transactional(
            propagation = Propagation.MANDATORY, // Mutlaka mevcut bir işlem gerektirir
            isolation = Isolation.READ_UNCOMMITTED, // Diğer işlemlerdeki geçici değişiklikler okunabilir
            rollbackFor = {Exception.class} // Tüm istisnalar için rollback
    )
    public AddressDto objectServiceDelete(Long id) {
        // Öncelelikle ilgili Adresi ID ile bulalım
        AddressEntity addressEntityDelete = dtoToEntity(objectServiceFindById(id));

        // isterseniz soft delete(Yani database silme sadece kulalnıcı veriye ulaşmasın) Database sil
        //iAddressRepository.delete(addressEntityDelete);

        // Soft Delete
        //addressEntityDelete.setIsDeleted(false);

        // Silmek
        iAddressRepository.deleteById(id);

        return entityToDto(addressEntityDelete);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // ROOT (Spring MVC)
    // http://localhost:4444/api/address
    // http://localhost:4444/api/address/index
    // Thymeleaf, React veya Angular için gerekli olabiliyor.
    @GetMapping("/index")
    public ResponseEntity<?> getRoot() {
        return ResponseEntity.ok("index");
    }

    ////////////////////////////////////////////////////////////////
    // PAGE & SORT
    // PAGE
    // import org.springframework.cache.annotation.Cacheable;
    // REDIS : key için eğer parametreler varsa ekleyelim.
    @Cacheable(value = "addressPaginationCache", key = "#currentPage + '-' + #pageSize")
    @Override
    public Page<AddressDto> objectServicePagination(int currentPage, int pageSize) {

        System.out.println("Redis Data ");
        // import org.springframework.data.domain.Pageable;
        // Pageable nesnesini oluştur
        Pageable pageable= PageRequest.of(currentPage, pageSize);

        Page<AddressEntity> addressEntityPage = iAddressRepository.findAll(pageable);

        /*Page<AddressDto> addressDtoPage*/
        List<AddressDto> addressDtoPage =  iAddressRepository.findAll(pageable)
                .stream()
                .map(AddressMapper::AddressEntityToAddressDto)
                .collect(Collectors.toList());
        // DTO'ları içeren bir PageImpl oluştur
        // Bu yapı, List türündeki DTO nesnelerini PageImpl kullanarak Page nesnesine dönüştürür.
        // Böylece Spring Data JPA ile uyumlu bir sayfalama yapısı elde edilir.
        // PageImpl, toplam öğe sayısını ve sayfalama bilgilerini koruyarak hem performanslı hem de düzenli bir dönüşüm sağlar.
        return new PageImpl<>(addressDtoPage, pageable, addressEntityPage.getTotalElements());
    }
    /*
    PageImpl Kullanımı
    PageImpl, bir List türündeki veriyi Page nesnesine dönüştürmek için Spring Data JPA tarafından sağlanan bir sınıftır. PageImpl aşağıdaki durumlarda kullanılır:

    Stream veya List'ten Page oluşturmak istediğinizde.
    Orijinal Pageable bilgilerini ve toplam öğe sayısını (totalElements) korumak istediğinizde.
    */

    // SORTING (Herhangi bir kolon)
    // REDIS :
    @Cacheable(value = "addressSortedByCache", key = "#sortedBy")
    @Override
    public List<AddressDto> objectServiceListSortedByDefault(String sortedBy) {
        return iAddressRepository.findAll(Sort.by(Sort.Direction.ASC,sortedBy))
                .stream().map(AddressMapper::AddressEntityToAddressDto)
                .collect(Collectors.toList());
    }

    // SORTING (CITY ASC) Küçükten büyüğe doğru sıralama
    // REDIS :
    // NOT: eğer Embeddable kullanıyorsanız Entity içine yazdığınız nesne adına göre ekleyin yoksa city gibi
    // nesnelere erişim sağlayamazsınız.
    @Cacheable(value = "addressSortedByCityAscCache")
    @Override
    public List<AddressDto> objectServiceListSortedByAsc() {
        // Dikkat: Eğer Embedable olmasaydı `city` yazsak yeterdi ancak `detailsEmbeddable.city` yazmalıyız
        return iAddressRepository.findAll(Sort.by(Sort.Direction.ASC,"detailsEmbeddable.city"))
                .stream()
                .map(AddressMapper::AddressEntityToAddressDto)
                .collect(Collectors.toList());
    }

    // SORTING (CITY DESC) Büyükten küçüğe doğru sıralama
    // REDIS :
    @Cacheable(value = "addressSortedByCityDescCache")
    @Override
    public List<AddressDto> objectServiceListSortedByDesc() {
        // Dikkat: Eğer Embedable olmasaydı `city` yazsak yeterdi ancak `detailsEmbeddable.city` yazmalıyız
        return iAddressRepository.findAll(Sort.by(Sort.Direction.DESC,"detailsEmbeddable.city"))
                .stream()
                .map(AddressMapper::AddressEntityToAddressDto)
                .collect(Collectors.toList());
    }

} //end AddressServiceImpl
