package ru.rosbank.javaschool.model;

public class RusticPotatoesModel extends AbstractProductModel {

    public RusticPotatoesModel(int id, String name, int price, Category category, int kcalories) {
        super(id, name, price, category, kcalories);
    }

    @Override
    public AbstractProductModel withId(int id) {
        return new RusticPotatoesModel(
                id,
                this.getName(),
                this.getPrice(),
                this.getCategory(),
                this.getKcalories());
    }


}
