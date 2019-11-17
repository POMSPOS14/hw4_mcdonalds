package ru.rosbank.javaschool.repositoryForProduct;

import ru.rosbank.javaschool.model.AbstractProductModel;

import java.util.Optional;

public interface ProductRepository {
    AbstractProductModel create(AbstractProductModel item);
    Optional<AbstractProductModel> readById(int id);
    AbstractProductModel update(AbstractProductModel item);
    boolean deleteById(int id);
}
