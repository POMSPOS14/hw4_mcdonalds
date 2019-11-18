package ru.rosbank.javaschool.integration;

import org.junit.jupiter.api.Test;
import ru.rosbank.javaschool.model.*;
import ru.rosbank.javaschool.repository.orders.OrdersRepositoryImpl;
import ru.rosbank.javaschool.repository.orders.Purchase;
import ru.rosbank.javaschool.repository.product.ProductRepositoryImpl;
import ru.rosbank.javaschool.service.McdonaldsImplService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class McdonaldsImplServiceTest {

    @Test
    void saleOneProduct() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        OrdersRepositoryImpl ordersRepository = new OrdersRepositoryImpl();
        McdonaldsImplService mcdonaldsImplService = new McdonaldsImplService(productRepository, ordersRepository);
        productRepository.create(new DessertsModel(1, "American_Cheese", 150, Category.DESSERTS, 2000));
        productRepository.create(new DrinksModel(1, "Cola_Zero", 80, Category.DRINKS, 20, 400));
        productRepository.create(new DrinksModel(1, "Cola", 80, Category.DRINKS, 200, 400));
        mcdonaldsImplService.sale(2);
        int result = ordersRepository.getById(1).get().getIdAllProduct().get(0);
        assertEquals(result, 2);
    }

    @Test
    void saleNotValidProduct() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        OrdersRepositoryImpl ordersRepository = new OrdersRepositoryImpl();
        McdonaldsImplService mcdonaldsImplService = new McdonaldsImplService(productRepository, ordersRepository);
        productRepository.create(new DessertsModel(1, "American_Cheese", 150, Category.DESSERTS, 2000));
        productRepository.create(new DrinksModel(1, "Cola_Zero", 80, Category.DRINKS, 20, 400));
        productRepository.create(new DrinksModel(1, "Cola", 80, Category.DRINKS, 200, 400));
        assertThrows(Exception.class, () -> mcdonaldsImplService.sale(4));
    }

    @Test
    void saleLessThenZeroIdProduct() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        OrdersRepositoryImpl ordersRepository = new OrdersRepositoryImpl();
        McdonaldsImplService mcdonaldsImplService = new McdonaldsImplService(productRepository, ordersRepository);
        productRepository.create(new DessertsModel(1, "American_Cheese", 150, Category.DESSERTS, 2000));
        productRepository.create(new DrinksModel(1, "Cola_Zero", 80, Category.DRINKS, 20, 400));
        productRepository.create(new DrinksModel(1, "Cola", 80, Category.DRINKS, 200, 400));
        assertThrows(Exception.class, () -> mcdonaldsImplService.sale(-1));
    }


    @Test
    void getProductForCategory() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        OrdersRepositoryImpl ordersRepository = new OrdersRepositoryImpl();
        McdonaldsImplService mcdonaldsImplService = new McdonaldsImplService(productRepository, ordersRepository);
        productRepository.create(new DessertsModel(1, "American_Cheese", 150, Category.DESSERTS, 2000));
        productRepository.create(new DrinksModel(1, "Cola_Zero", 80, Category.DRINKS, 20, 400));
        productRepository.create(new PotatoModel(1, "FrenchFries", 50, Category.POTATO, 200));
        List<AbstractProductModel> productForCategory = mcdonaldsImplService.getProductForCategory(Category.DRINKS);
        int result = productForCategory.get(0).getId();
        assertEquals(result, 2);
    }

    @Test
    void searchByText() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        OrdersRepositoryImpl ordersRepository = new OrdersRepositoryImpl();
        McdonaldsImplService mcdonaldsImplService = new McdonaldsImplService(productRepository, ordersRepository);
        productRepository.create(new DessertsModel(1, "American_Cheese", 150, Category.DESSERTS, 2000));
        productRepository.create(new DrinksModel(1, "Cola_Zero", 80, Category.DRINKS, 20, 400));
        productRepository.create(new PotatoModel(1, "FrenchFries", 50, Category.POTATO, 200));
        int result = mcdonaldsImplService.searchBy("FrenchFries").get(0).getId();

        assertEquals(result, 3);

    }

    @Test
    void readByIdInProductRepository() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        productRepository.create(new DessertsModel(1, "American_Cheese", 150, Category.DESSERTS, 2000));
        productRepository.create(new DrinksModel(1, "Cola_Zero", 80, Category.DRINKS, 20, 400));
        productRepository.create(new PotatoModel(1, "FrenchFries", 50, Category.POTATO, 200));
        int price = productRepository.readById(2).get().getPrice();

        assertEquals(price, 80);
    }

    @Test
    void deleteByIdInProductRepository() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        productRepository.create(new DessertsModel(1, "American_Cheese", 150, Category.DESSERTS, 2000));
        productRepository.create(new DrinksModel(1, "Cola_Zero", 80, Category.DRINKS, 20, 400));
        productRepository.create(new PotatoModel(1, "FrenchFries", 50, Category.POTATO, 200));
        boolean result = productRepository.deleteById(2);
        assertEquals(result, false);
    }

    @Test
    void deleteByIdInEmptyProductRepository() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        boolean result = productRepository.deleteById(2);
        assertEquals(result, true);
    }

    @Test
    void updateInProductRepository() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        productRepository.create(new DessertsModel(1, "American_Cheese", 150, Category.DESSERTS, 2000));
        productRepository.create(new DrinksModel(1, "Cola_Zero", 80, Category.DRINKS, 20, 400));
        productRepository.create(new PotatoModel(1, "FrenchFries", 50, Category.POTATO, 200));
        productRepository.update(new DrinksModel(2, "Cola_Zero", 100, Category.DRINKS, 20, 500));
        int price = productRepository.readById(2).get().getPrice();

        assertEquals(price, 100);

    }

    @Test
    void getNextIdInOrdersRepository() {
        OrdersRepositoryImpl ordersRepository = new OrdersRepositoryImpl();
        int nextId = ordersRepository.getNextId();
        assertEquals(nextId, 1);
    }

    @Test
    void updateInOrdersRepository() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        OrdersRepositoryImpl ordersRepository = new OrdersRepositoryImpl();
        McdonaldsImplService mcdonaldsImplService = new McdonaldsImplService(productRepository, ordersRepository);
        productRepository.create(new DessertsModel(1, "American_Cheese", 150, Category.DESSERTS, 2000));
        productRepository.create(new DrinksModel(1, "Cola_Zero", 80, Category.DRINKS, 20, 400));
        mcdonaldsImplService.sale(1, 2);
        int Before = ordersRepository.getById(1).get().getIdAllProduct().size();
        ordersRepository.update(1, productRepository, 2);
        int After = ordersRepository.getById(1).get().getIdAllProduct().size();
        boolean result = After == Before;
        assertEquals(result, false);

    }

    @Test
    void deleteByIdInOrdersRepository() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        OrdersRepositoryImpl ordersRepository = new OrdersRepositoryImpl();
        McdonaldsImplService mcdonaldsImplService = new McdonaldsImplService(productRepository, ordersRepository);
        productRepository.create(new DessertsModel(1, "American_Cheese", 150, Category.DESSERTS, 2000));
        productRepository.create(new DrinksModel(1, "Cola_Zero", 80, Category.DRINKS, 20, 400));
        mcdonaldsImplService.sale(1, 2);
        mcdonaldsImplService.sale(1);
        boolean result = ordersRepository.deleteById(1);
        assertEquals(result, false);
    }

    @Test
    void getAllInOrdersRepository() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        OrdersRepositoryImpl ordersRepository = new OrdersRepositoryImpl();
        McdonaldsImplService mcdonaldsImplService = new McdonaldsImplService(productRepository, ordersRepository);
        productRepository.create(new DessertsModel(1, "American_Cheese", 150, Category.DESSERTS, 2000));
        productRepository.create(new DrinksModel(1, "Cola_Zero", 80, Category.DRINKS, 20, 400));
        mcdonaldsImplService.sale(1, 2);
        int result = ordersRepository.getAll().size();
        assertEquals(result, 1);
    }

    @Test
    void deleteByIdInEmptyOrdersRepository() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        OrdersRepositoryImpl ordersRepository = new OrdersRepositoryImpl();
        McdonaldsImplService mcdonaldsImplService = new McdonaldsImplService(productRepository, ordersRepository);
        productRepository.create(new DessertsModel(1, "American_Cheese", 150, Category.DESSERTS, 2000));
        productRepository.create(new DrinksModel(1, "Cola_Zero", 80, Category.DRINKS, 20, 400));
        boolean result = ordersRepository.deleteById(1);
        assertEquals(result, true);
    }

    @Test
    void getByNotValidIdInOrdersRepository() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        OrdersRepositoryImpl ordersRepository = new OrdersRepositoryImpl();
        McdonaldsImplService mcdonaldsImplService = new McdonaldsImplService(productRepository, ordersRepository);
        productRepository.create(new DessertsModel(1, "American_Cheese", 150, Category.DESSERTS, 2000));
        productRepository.create(new DrinksModel(1, "Cola_Zero", 80, Category.DRINKS, 20, 400));
        mcdonaldsImplService.sale(1, 2);
        mcdonaldsImplService.sale(1, 1);
        mcdonaldsImplService.sale(1);
        Optional<Purchase> fist = ordersRepository.getById(1);
        Optional<Purchase> second = ordersRepository.getById(4);
        boolean result = second.equals(fist);
        assertEquals(result,false);
    }

    @Test
    void updateByNotValidIdInOrdersRepository() {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        OrdersRepositoryImpl ordersRepository = new OrdersRepositoryImpl();
        McdonaldsImplService mcdonaldsImplService = new McdonaldsImplService(productRepository, ordersRepository);
        productRepository.create(new DessertsModel(1, "American_Cheese", 150, Category.DESSERTS, 2000));
        productRepository.create(new DrinksModel(1, "Cola_Zero", 80, Category.DRINKS, 20, 400));
        mcdonaldsImplService.sale(1, 2);
        mcdonaldsImplService.sale(1, 1);
        mcdonaldsImplService.sale(1);
        ordersRepository.update(1,productRepository,1);
        assertThrows(Exception.class, () -> ordersRepository.update(4,productRepository,1));
    }


}