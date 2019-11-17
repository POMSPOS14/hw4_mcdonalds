package ru.rosbank.javaschool.service;

import ru.rosbank.javaschool.model.AbstractProductModel;
import ru.rosbank.javaschool.model.Category;
import ru.rosbank.javaschool.repositoryForOrders.OrdersRepository;
import ru.rosbank.javaschool.repositoryForOrders.OrdersRepositoryImpl;
import ru.rosbank.javaschool.repositoryForProduct.ProductRepository;
import ru.rosbank.javaschool.repositoryForProduct.ProductRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

public class McdonaldsImplService implements McdonaldsService {

    private ProductRepositoryImpl productRepository;
    private OrdersRepository ordersRepository;

    public McdonaldsImplService(ProductRepositoryImpl productRepository, OrdersRepositoryImpl ordersRepository) {
        this.productRepository = productRepository;
        this.ordersRepository = ordersRepository;
    }


    @Override
    public void sale(int ... IdProduct) {
        ordersRepository.create(productRepository, IdProduct);
    }

    @Override
    public List<AbstractProductModel> getProductForCategory(Category category) {
        return productRepository.getAll()
        .stream()
        .filter(o -> o.getCategory() == category)
        .collect(Collectors.toList());
    }

    @Override
    public List<AbstractProductModel> searchBy(String text) {
        return productRepository.getAll()
                .stream()
                .filter(o -> o.getName().equals(text))
                .collect(Collectors.toList());
    }

}
