package com.hamitmizrak.techcareer_2025_backend_1.business.services.impl;


import com.hamitmizrak.techcareer_2025_backend_1.bean.ModelMapperBean;
import com.hamitmizrak.techcareer_2025_backend_1.business.dto.CustomerDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.ICustomerService;
import com.hamitmizrak.techcareer_2025_backend_1.data.entity.CustomerEntity;
import com.hamitmizrak.techcareer_2025_backend_1.data.mapper.CustomerMapper;
import com.hamitmizrak.techcareer_2025_backend_1.data.repository.ICustomerRepository;
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
public class CustomerServiceImpl implements ICustomerService<CustomerDto, CustomerEntity> {

    // INJECTION
    private final ICustomerRepository iCustomerRepository;
    private final ModelMapperBean modelMapperBean;

    // Model Mapper
    @Override
    public CustomerDto entityToDto(CustomerEntity customerEntity) {
        // 1.YOL (ModelMapper)
        /*return modelMapperBean.getModelMapperBeanMethod().map(customerEntity, CustomerDto.class);*/

        // 2.YOL (Mapper Special)
        return CustomerMapper.CustomerEntityToCustomerDto(customerEntity);
    }

    @Override
    public CustomerEntity dtoToEntity(CustomerDto customerDto) {
        // 1.YOL (ModelMapper)
        // return modelMapperBean.getModelMapperBeanMethod().map(customerDto, CustomerEntity.class);

        // 2.YOL (Mapper Special)
        return CustomerMapper.CustomerDtoToCustomerEntity(customerDto);
    }

    ////////////////////////////////////////////////////////////////
    // CRUD

    // CREATE (Customer)
    // org.springframework.transaction
    @Transactional //(propagation = ) // () // create, delete, update yani manipulation işlemlerin
    @Override
    public CustomerDto objectServiceCreate(CustomerDto customerDto) {
        CustomerEntity customerEntityCreate =dtoToEntity(customerDto);
        // Not: Kayıt veya güncellemede ID içini set eder
        customerEntityCreate= iCustomerRepository.save(customerEntityCreate);
        return entityToDto(customerEntityCreate);
    }

    // LIST (Customer)
    @Override
    public List<CustomerDto> objectServiceList() {
        List<CustomerEntity> customerEntities = iCustomerRepository.findAll();
        return customerEntities.stream()
                //.sorted(Comparator.comparing((temp)-> temp.getName()))
                //.map((temp)->CustomerMapper.CustomerEntityToCustomerDto(temp)) // 1.YOL (Lambda Expression)
                .map(CustomerMapper::CustomerEntityToCustomerDto)                // 2.YOL (Method Referances)
                .collect(Collectors.toList());
    }

    // FIND BY ID (Customer)
    @Override
    public CustomerDto objectServiceFindById(Long id) {
        return iCustomerRepository.findById(id)
                .map(CustomerMapper::CustomerEntityToCustomerDto)
                .orElseThrow(()-> new _404_NotFoundException(id+" nolu veri yoktur"));
    }

    // UPDATE
    @Transactional // create, delete, update yani manipulation işlemlerin
    @Override
    public CustomerDto objectServiceUpdate(Long id, CustomerDto customerDto) {
        // Öncelikle ilgili Adresi bulalım
        CustomerEntity customerEntityFindByUpdate= dtoToEntity(objectServiceFindById(id));

        customerEntityFindByUpdate.setFistname(customerDto.getFistname());
        customerEntityFindByUpdate.setLastname(customerDto.getLastname());
        customerEntityFindByUpdate.setNotes(customerDto.getNotes());

        //return entityToDto(iCustomerRepository.save(customerEntityFindByUpdate));         // 1.YOL
        return entityToDto(iCustomerRepository.saveAndFlush(customerEntityFindByUpdate));   // 2.YOL
    }

    // DELETE
    @Transactional // create, delete, update yani manipulation işlemlerin
    @Override
    public CustomerDto objectServiceDelete(Long id) {
        // Öncelikle ilgili Adresi bulalım
        CustomerEntity customerEntityFindByDelete= dtoToEntity(objectServiceFindById(id));
        iCustomerRepository.delete(customerEntityFindByDelete);
        return entityToDto(customerEntityFindByDelete);
    }
} //end CustomererviceImpl
