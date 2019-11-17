package ru.rosbank.javaschool.repositoryForOrders;

import ru.rosbank.javaschool.repositoryForProduct.ProductRepositoryImpl;

import java.util.Optional;

public interface OrdersRepository {
    public Optional<Purchase> getById(int id);
    public Purchase create(ProductRepositoryImpl repository, int... product);
    public Purchase update(int id, ProductRepositoryImpl repository, int... product);
    public boolean deleteById(int id);

}
