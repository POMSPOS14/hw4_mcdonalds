package ru.rosbank.javaschool.service;

import ru.rosbank.javaschool.model.AbstractProductModel;
import ru.rosbank.javaschool.model.Category;
import ru.rosbank.javaschool.repositoryForProduct.ProductRepository;
import ru.rosbank.javaschool.repositoryForProduct.ProductRepositoryImpl;

import java.util.List;

public interface McdonaldsService {
    void sale(int ... IdProduct);
    List<AbstractProductModel> getProductForCategory(Category category);
    List<AbstractProductModel> searchBy(String text);
}
