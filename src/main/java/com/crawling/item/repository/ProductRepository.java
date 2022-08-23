package com.crawling.item.repository;

import com.crawling.item.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.no in :itemIds order by p.no")
    public List<Product> findItemsInId(List<Long> itemIds);
}
