package com.capgemini.market.domain.repository;

import com.capgemini.market.domain.Purchase;
import com.capgemini.market.domain.PurchaseItem;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String idClient);
    Purchase save(Purchase purchase);

}
