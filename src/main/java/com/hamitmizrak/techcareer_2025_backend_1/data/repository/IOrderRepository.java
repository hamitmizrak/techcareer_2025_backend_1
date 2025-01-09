package com.hamitmizrak.techcareer_2025_backend_1.data.repository;

import com.hamitmizrak.techcareer_2025_backend_1.data.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository<OrderEntity,Long>
// CrudRepository<OrderEntity,Long>
// PagingAndSortingRepository<OrderEntity,Long>

@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity,Long> {

    // Delivered Query
    // Named Query
    // JPQL
    // Native Query
}
