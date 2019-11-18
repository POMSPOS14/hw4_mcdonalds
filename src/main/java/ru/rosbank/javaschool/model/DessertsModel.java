package ru.rosbank.javaschool.model;

public class DessertsModel extends AbstractProductModel {

    public DessertsModel(int id, String name, int price, Category category, int kcalories) {
        super(id, name, price, category, kcalories);
    }

    @Override
    public AbstractProductModel withId(int id) {
        return new DessertsModel(
                id,
                this.getName(),
                this.getPrice(),
                this.getCategory(),
                this.getKcalories());
    }


}
