package com.hamitmizrak.techcareer_2025_backend_1.controller.api;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

// D: Dto
public interface ISortingPagingApi<D> {

    // PAGINATION
    public ResponseEntity<Page<?>>  objectServicePagination(int currentPage, int pageSize);

    // SORTING
    // Database içinde herhangi bir kolona göre yazsın
    public ResponseEntity<List<D>> objectServiceListSortedBy(String sortedBy);

    // SORTING ASC
    // Database içindeki seçtiğimiz kolona göre küçükten büyüğe doğru sıralansın
    public ResponseEntity<List<D>>  objectServiceListSortedByAsc();

    // SORTING DESC
    // Database içindeki seçtiğimiz kolona göre büyükten küçüğe doğru sıralansın
    public ResponseEntity<List<D>>   objectServiceListSortedByDesc();
}
