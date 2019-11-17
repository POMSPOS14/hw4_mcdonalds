package ru.rosbank.javaschool.repository.orders;

import ru.rosbank.javaschool.repository.product.ProductRepositoryImpl;

import java.util.Optional;

public interface OrdersRepository {
    Optional<Purchase> getById(int id);
    Purchase create(ProductRepositoryImpl repository, int... product);
    Purchase update(int id, ProductRepositoryImpl repository, int... product);
    boolean deleteById(int id);
    int getNextId();

}
