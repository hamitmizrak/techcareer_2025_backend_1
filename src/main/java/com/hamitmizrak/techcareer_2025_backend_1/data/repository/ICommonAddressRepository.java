package com.hamitmizrak.techcareer_2025_backend_1.data.repository;

import com.hamitmizrak.techcareer_2025_backend_1.data.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// CrudRepository<AddressEntity,Long>
// PagingAndSortingRepository<AddressEntity,Long>
// JpaRepository<AddressEntity,Long>

@Repository
public interface ICommonAddressRepository extends JpaRepository<AddressEntity,Long> {

    /*
    Dikkat: IRepository Delivered Query için `detailsEmbeddable.address` şeklinde yazalır.
    @Embedded
    private AddressEntityDetailsEmbeddable detailsEmbeddable;
    */

    // Delivered Query
    // Embbedable ile çalıştığımızda underscore(_) eklenir.
   Optional<AddressEntity> findAddressEntitiesByDetailsEmbeddableAddressQrCode (String qrCode);

    // JPQL
    // Native Query
    // Native SQL

}
