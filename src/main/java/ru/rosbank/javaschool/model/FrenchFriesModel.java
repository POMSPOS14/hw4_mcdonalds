package ru.rosbank.javaschool.model;

public class FrenchFriesModel extends AbstractProductModel {

    public FrenchFriesModel(int id, String name, int price, Category category, int kcalories) {
        super(id, name, price, category, kcalories);
    }

    @Override
    public AbstractProductModel withId(int id) {
        return new FrenchFriesModel(
                id,
                this.getName(),
                this.getPrice(),
                this.getCategory(), this.getKcalories());
    }



}
