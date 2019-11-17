package ru.rosbank.javaschool.service;

import ru.rosbank.javaschool.exception.InvalidDataException;
import ru.rosbank.javaschool.model.AbstractProductModel;
import ru.rosbank.javaschool.model.Category;
import ru.rosbank.javaschool.repository.orders.OrdersRepository;
import ru.rosbank.javaschool.repository.orders.OrdersRepositoryImpl;
import ru.rosbank.javaschool.repository.product.ProductRepositoryImpl;

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
    public void sale(int... idProduct) {

        for (int i : idProduct) {
            if (i < 0) {
                throw new InvalidDataException("Id can't be negative");
            }
            if (i >=productRepository.getNextId()) {
                throw new InvalidDataException("Product id does not exist");
            }
        }

        ordersRepository.create(productRepository, idProduct);
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
                .filter(o -> o.getName().toLowerCase().equals(text.toLowerCase()))
                .collect(Collectors.toList());
    }


//    public void
}
