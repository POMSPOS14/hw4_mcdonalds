package ru.rosbank.javaschool.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor



public abstract class AbstractProductModel {
    private int id;
    private String name;
    private int price;
    private Category category;
    private int kcalories;

    public AbstractProductModel(int id, String name, int price, Category category, int kcalories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.kcalories = kcalories;
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

    public int getKcalories() {
        return kcalories;
    }

    public AbstractProductModel withId(int id) {
        return null;
    }


    public static AbstractProductModel from(AbstractProductModel model) {
        return new DessertsModel(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getCategory(),
                model.getKcalories());
    }

    public static AbstractProductModel from(BurgerModel model) {
        return new BurgerModel(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getCategory(),
                model.getKcalories(),
                model.getMeat());
    }

    public static AbstractProductModel from(DessertsModel model) {
        return new DessertsModel(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getCategory(),
                model.getKcalories());
    }

    public static AbstractProductModel from(DrinksModel model) {
        return new DrinksModel(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getCategory(),
                model.getKcalories(),
                model.getSizeInMl());
    }

//    public static AbstractProductModel from(DonatModel model) {
//        return new DonatModel(
//                model.getId(),
//                model.getName(),
//                model.getPrice(),
//                model.getCategory(),
//                model.getKcalories());
//    }

//    public static AbstractProductModel from(FantaModel model) {
//        return new FantaModel(
//                model.getId(),
//                model.getName(),
//                model.getPrice(),
//                model.getCategory(),
//                model.getKcalories(),
//                model.getSizeInMl());
//    }

    public static AbstractProductModel from(PotatoModel model) {
        return new PotatoModel(
                model.getId(),
                model.getName(),
                model.getPrice(),
                model.getCategory(),
                model.getKcalories());
    }

//    public static AbstractProductModel from(RusticPotatoesModel model) {
//        return new RusticPotatoesModel(
//                model.getId(),
//                model.getName(),
//                model.getPrice(),
//                model.getCategory(),
//                model.getKcalories());
//    }


}
