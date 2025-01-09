package com.hamitmizrak.techcareer_2025_backend_1.business.services.impl;


import com.hamitmizrak.techcareer_2025_backend_1.bean.ModelMapperBean;
import com.hamitmizrak.techcareer_2025_backend_1.business.dto.ProductDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.IProductService;
import com.hamitmizrak.techcareer_2025_backend_1.data.entity.ProductEntity;
import com.hamitmizrak.techcareer_2025_backend_1.data.mapper.ProductMapper;
import com.hamitmizrak.techcareer_2025_backend_1.data.repository.IProductRepository;
import com.hamitmizrak.techcareer_2025_backend_1.exception._404_NotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
public class ProductServiceImpl implements IProductService<ProductDto, ProductEntity> {

    // INJECTION
    private final IProductRepository iProductRepository;
    private final ModelMapperBean modelMapperBean;

    // Model Mapper
    @Override
    public ProductDto entityToDto(ProductEntity productEntity) {
        // 1.YOL (ModelMapper)
        /*return modelMapperBean.getModelMapperBeanMethod().map(productEntity, ProductDto.class);*/

        // 2.YOL (Mapper Special)
        return ProductMapper.ProductEntityToProductDto(productEntity);
    }

    @Override
    public ProductEntity dtoToEntity(ProductDto productDto) {
        // 1.YOL (ModelMapper)
        // return modelMapperBean.getModelMapperBeanMethod().map(productDto, ProductEntity.class);

        // 2.YOL (Mapper Special)
        return ProductMapper.ProductDtoToProductEntity(productDto);
    }

    ////////////////////////////////////////////////////////////////
    // CRUD

    // CREATE (product)
    // org.springframework.transaction
    @Transactional //(propagation = ) // () // create, delete, update yani manipulation işlemlerin
    @Override
    public ProductDto objectServiceCreate(ProductDto productDto) {
        ProductEntity productEntityCreate =dtoToEntity(productDto);
        // Not: Kayıt veya güncellemede ID içini set eder
        productEntityCreate= iProductRepository.save(productEntityCreate);
        return entityToDto(productEntityCreate);
    }

    // LIST (product)
    @Override
    public List<ProductDto> objectServiceList() {
        List<ProductEntity> productEntities = iProductRepository.findAll();
        return productEntities.stream()
                //.sorted(Comparator.comparing((temp)-> temp.getName))
                //.map((temp)->ProductMapper.ProductEntityToProductDto(temp)) // 1.YOL (Lambda Expression)
                .map(ProductMapper::ProductEntityToProductDto)                // 2.YOL (Method Referances)
                .collect(Collectors.toList());
    }

    // FIND BY ID (product)
    @Override
    public ProductDto objectServiceFindById(Long id) {
        return iProductRepository.findById(id)
                .map(ProductMapper::ProductEntityToProductDto)
                .orElseThrow(()-> new _404_NotFoundException(id+" nolu veri yoktur"));
    }

    // UPDATE
    @Transactional // create, delete, update yani manipulation işlemlerin
    @Override
    public ProductDto objectServiceUpdate(Long id, ProductDto productDto) {
        // Öncelikle ilgili Adresi bulalım
        ProductEntity productEntityFindByUpdate= dtoToEntity(objectServiceFindById(id));

        productEntityFindByUpdate.setName(productDto.getName());
        productEntityFindByUpdate.setTrade(productDto.getTrade());
        productEntityFindByUpdate.setNotes(productDto.getNotes());

        //return entityToDto(iProductRepository.save(productEntityFindByUpdate));         // 1.YOL
        return entityToDto(iProductRepository.saveAndFlush(productEntityFindByUpdate));   // 2.YOL
    }

    // DELETE
    @Transactional // create, delete, update yani manipulation işlemlerin
    @Override
    public ProductDto objectServiceDelete(Long id) {
        // Öncelikle ilgili Adresi bulalım
        ProductEntity productEntityFindByDelete= dtoToEntity(objectServiceFindById(id));
        iProductRepository.delete(productEntityFindByDelete);
        return entityToDto(productEntityFindByDelete);
    }
} //end ProducterviceImpl
