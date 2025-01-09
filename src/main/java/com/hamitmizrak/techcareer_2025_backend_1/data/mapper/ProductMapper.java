package com.hamitmizrak.techcareer_2025_backend_1.data.mapper;

import com.hamitmizrak.techcareer_2025_backend_1.business.dto.ProductDto;
import com.hamitmizrak.techcareer_2025_backend_1.data.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    // 1- OrderEntity'i OrderDto'a çevir
    public static ProductDto ProductEntityToProductDto(ProductEntity productEntity) {
        // Instance(OrderDto)
        ProductDto productDto = new ProductDto();

        // Field
        productDto.setId(productEntity.getId());
        productDto.setName(productEntity.getName());
        productDto.setTrade(productEntity.getTrade());
        productDto.setNotes(productEntity.getNotes());
        return productDto;
    }

    // 2- OrderDto'u OrderEntity'e  çevir
    public static ProductEntity ProductDtoToProductEntity(ProductDto productDto) {
        // Instance(OrderEntity)
        ProductEntity productEntity = new ProductEntity();

        // Field
        productEntity.setId(productDto.getId());
        productEntity.setName(productDto.getName());
        productEntity.setTrade(productDto.getTrade());
        productEntity.setNotes(productDto.getNotes());
        return productEntity;
    }

    // 3- ProductDto nesnesini ProductEntity Listesine çevirmek
    public static List<ProductEntity> ProductDtoListToEntityList(List<ProductDto> productDtoList) {
        return productDtoList.stream().map(ProductMapper::ProductDtoToProductEntity).collect(Collectors.toList());
    }
}
