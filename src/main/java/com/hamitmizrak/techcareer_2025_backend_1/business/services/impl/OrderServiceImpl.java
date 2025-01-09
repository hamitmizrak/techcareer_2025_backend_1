package com.hamitmizrak.techcareer_2025_backend_1.business.services.impl;


import com.hamitmizrak.techcareer_2025_backend_1.bean.ModelMapperBean;
import com.hamitmizrak.techcareer_2025_backend_1.business.dto.OrderDto;
import com.hamitmizrak.techcareer_2025_backend_1.business.services.interfaces.IOrderService;
import com.hamitmizrak.techcareer_2025_backend_1.data.entity.OrderEntity;
import com.hamitmizrak.techcareer_2025_backend_1.data.mapper.OrderMapper;
import com.hamitmizrak.techcareer_2025_backend_1.data.repository.IOrderRepository;
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
public class OrderServiceImpl implements IOrderService<OrderDto, OrderEntity> {

    // INJECTION
    private final IOrderRepository iOrderRepository;
    private final ModelMapperBean modelMapperBean;

    // Model Mapper
    @Override
    public OrderDto entityToDto(OrderEntity orderEntity) {
        // 1.YOL (ModelMapper)
        /*return modelMapperBean.getModelMapperBeanMethod().map(orderEntity, OrderDto.class);*/

        // 2.YOL (Mapper Special)
        return OrderMapper.OrderEntityToOrderDto(orderEntity);
    }

    @Override
    public OrderEntity dtoToEntity(OrderDto orderDto) {
        // 1.YOL (ModelMapper)
        // return modelMapperBean.getModelMapperBeanMethod().map(orderDto, OrderEntity.class);

        // 2.YOL (Mapper Special)
        return OrderMapper.OrderDtoToOrderEntity(orderDto);
    }

    ////////////////////////////////////////////////////////////////
    // CRUD

    // CREATE (Order)
    // org.springframework.transaction
    @Transactional //(propagation = ) // () // create, delete, update yani manipulation işlemlerin
    @Override
    public OrderDto objectServiceCreate(OrderDto orderDto) {
        OrderEntity orderEntityCreate =dtoToEntity(orderDto);
        // Not: Kayıt veya güncellemede ID içini set eder
        orderEntityCreate= iOrderRepository.save(orderEntityCreate);
        return entityToDto(orderEntityCreate);
    }

    // LIST (Order)
    @Override
    public List<OrderDto> objectServiceList() {
        List<OrderEntity> orderEntities = iOrderRepository.findAll();
        return orderEntities.stream()
                //.sorted(Comparator.comparing((temp)-> temp.getName))
                //.map((temp)->OrderMapper.OrderEntityToOrderDto(temp)) // 1.YOL (Lambda Expression)
                .map(OrderMapper::OrderEntityToOrderDto)                // 2.YOL (Method Referances)
                .collect(Collectors.toList());
    }

    // FIND BY ID (Order)
    @Override
    public OrderDto objectServiceFindById(Long id) {
        return iOrderRepository.findById(id)
                .map(OrderMapper::OrderEntityToOrderDto)
                .orElseThrow(()-> new _404_NotFoundException(id+" nolu veri yoktur"));
    }

    // UPDATE
    @Transactional // create, delete, update yani manipulation işlemlerin
    @Override
    public OrderDto objectServiceUpdate(Long id, OrderDto orderDto) {
        // Öncelikle ilgili Adresi bulalım
        OrderEntity orderEntityFindByUpdate= dtoToEntity(objectServiceFindById(id));

        orderEntityFindByUpdate.setName(orderDto.getName());
        orderEntityFindByUpdate.setPrice(orderDto.getPrice());
        orderEntityFindByUpdate.setNotes(orderDto.getNotes());

        //return entityToDto(iOrderRepository.save(orderEntityFindByUpdate));         // 1.YOL
        return entityToDto(iOrderRepository.saveAndFlush(orderEntityFindByUpdate));   // 2.YOL
    }

    // DELETE
    @Transactional // create, delete, update yani manipulation işlemlerin
    @Override
    public OrderDto objectServiceDelete(Long id) {
        // Öncelikle ilgili Adresi bulalım
        OrderEntity orderEntityFindByDelete= dtoToEntity(objectServiceFindById(id));
        iOrderRepository.delete(orderEntityFindByDelete);
        return entityToDto(orderEntityFindByDelete);
    }
} //end OrdererviceImpl
