package com.hamitmizrak.techcareer_2025_backend_1.business.services;

import org.springframework.data.domain.Page;

import java.util.List;

// D: Dto
// E: Entity
public interface ISortingPagingService<D,E> {

    // PAGINATION
    public Page<D> objectServicePagination(int currentPage, int pageSize);

    // SORTING
    // Database içinde herhangi bir kolona göre yazsın
    public List<D> objectServiceListSortedByDefault(String sortedBy);

    // SORTING ASC
    // Database içindeki seçtiğimiz kolona göre küçükten büyüğe doğru sıralansın
    public List<D> objectServiceListSortedByAsc();

    // SORTING DESC
    // Database içindeki seçtiğimiz kolona göre büyükten küçüğe doğru sıralansın
    public List<D> objectServiceListSortedByDesc();
}
