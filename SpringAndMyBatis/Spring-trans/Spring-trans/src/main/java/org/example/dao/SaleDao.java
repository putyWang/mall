package org.example.dao;

import org.example.domain.Sale;

public interface SaleDao {
    int insertOrder(Sale sale);

    int deleteOrder(Sale sale);
}
