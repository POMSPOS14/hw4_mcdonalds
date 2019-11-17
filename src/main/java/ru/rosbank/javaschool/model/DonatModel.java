package ru.rosbank.javaschool.model;

public class DonatModel extends AbstractProductModel {

    public DonatModel(int id, String name, int price, Category category, int kcalories) {
        super(id, name, price, category, kcalories);
    }


    @Override
    public AbstractProductModel withId(int id) {
        return new DonatModel(
                id,
                this.getName(),
                this.getPrice(),
                this.getCategory(),
                this.getKcalories());
    }



}
