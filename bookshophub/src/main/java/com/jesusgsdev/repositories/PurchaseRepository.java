package com.jesusgsdev.repositories;

import com.jesusgsdev.entities.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

    Stream<Purchase> findPurchaseByBookId(String bookId);

    Stream<Purchase> findPurchaseByCustomerEmail(String customerEmail);

}
