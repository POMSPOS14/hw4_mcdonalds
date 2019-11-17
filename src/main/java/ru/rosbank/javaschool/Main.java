package ru.rosbank.javaschool;

import ru.rosbank.javaschool.model.Category;
import ru.rosbank.javaschool.model.CheesecakeModel;
import ru.rosbank.javaschool.model.ColaModel;
import ru.rosbank.javaschool.repositoryForOrders.OrdersRepositoryImpl;
import ru.rosbank.javaschool.repositoryForProduct.ProductRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        productRepository.create(new ColaModel(0, "ms", 60, Category.DRINKS, 200, 400));
        productRepository.create(new ColaModel(0, "23", 60, Category.DRINKS, 200, 400));
        productRepository.create(new ColaModel(0, "mdefs", 60, Category.DRINKS, 200, 400));
        System.out.println(productRepository.getAll());
        int i = 2;
        System.out.println(productRepository.readById(i).get().getName() + productRepository.readById(i).get().getId());
        OrdersRepositoryImpl ordersRepository = new OrdersRepositoryImpl();
        ordersRepository.create(productRepository,1,1);
        System.out.println(ordersRepository.getAll().stream().findFirst());




//        productRepository.update(new CheesecakeModel(2, "chesss", 210, Category.DESSERTS, 2000));
//        System.out.println(productRepository.readById(1).get().getCategory());

    }
}
