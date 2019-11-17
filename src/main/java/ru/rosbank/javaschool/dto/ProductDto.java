package ru.rosbank.javaschool.dto;

import ru.rosbank.javaschool.model.AbstractProductModel;
import ru.rosbank.javaschool.model.Category;

public class ProductDto {
    private int id;
    private String name;
    private Category category;
    private int prise;

    public ProductDto(int id, String name, int prise, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.prise = prise;
    }

    public static ProductDto from(AbstractProductModel model) {
        return new ProductDto(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getCategory()
        );
    }
}
