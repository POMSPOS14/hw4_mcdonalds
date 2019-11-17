package ru.rosbank.javaschool.service;

import ru.rosbank.javaschool.model.AbstractProductModel;
import ru.rosbank.javaschool.model.Category;

import java.util.List;

public interface McdonaldsService {
    void sale(int... idProduct);
    List<AbstractProductModel> getProductForCategory(Category category);
    List<AbstractProductModel> searchBy(String text);
}
