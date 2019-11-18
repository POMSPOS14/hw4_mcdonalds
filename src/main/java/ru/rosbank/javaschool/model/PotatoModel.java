package ru.rosbank.javaschool.model;

public class PotatoModel extends AbstractProductModel {

    public PotatoModel(int id, String name, int price, Category category, int kcalories) {
        super(id, name, price, category, kcalories);
    }

    @Override
    public AbstractProductModel withId(int id) {
        return new PotatoModel(
                id,
                this.getName(),
                this.getPrice(),
                this.getCategory(), this.getKcalories());
    }



}
