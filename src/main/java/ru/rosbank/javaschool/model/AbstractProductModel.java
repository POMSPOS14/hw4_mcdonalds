package ru.rosbank.javaschool.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.dto.ProductDto;

@Getter
@NoArgsConstructor



public abstract class AbstractProductModel {
    private int id;
    private String name;
    private int price;
    private Category category;
    private int cCalories;

    public AbstractProductModel(int id, String name, int price, Category category, int cCalories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.cCalories = cCalories;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public int getcCalories() {
        return cCalories;
    }

    public AbstractProductModel withId(int id) {
        return null;
    }


    public static AbstractProductModel from(AbstractProductModel model) {
        return new RusticPotatoesModel(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getCategory(),
                model.getcCalories());
    }

    public static AbstractProductModel from(CheeseburgerModel model) {
        return new CheeseburgerModel(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getCategory(),
                model.getcCalories(),
                model.getMeat());
    }

    public static AbstractProductModel from(CheesecakeModel model) {
        return new CheesecakeModel(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getCategory(),
                model.getcCalories());
    }

    public static AbstractProductModel from(ColaModel model) {
        return new ColaModel(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getCategory(),
                model.getcCalories(),
                model.getSizeInMl());
    }

    public static AbstractProductModel from(DonatModel model) {
        return new DonatModel(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getCategory(),
                model.getcCalories());
    }

    public static AbstractProductModel from(FantaModel model) {
        return new FantaModel(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getCategory(),
                model.getcCalories(),
                model.getSizeInMl());
    }

    public static AbstractProductModel from(FrenchFriesModel model) {
        return new FrenchFriesModel(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getCategory(),
                model.getcCalories());
    }

    public static AbstractProductModel from(RusticPotatoesModel model) {
        return new RusticPotatoesModel(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getCategory(),
                model.getcCalories());
    }


}
