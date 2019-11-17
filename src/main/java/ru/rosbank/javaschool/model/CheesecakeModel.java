package ru.rosbank.javaschool.model;

public class CheesecakeModel extends AbstractProductModel {

    public CheesecakeModel(int id, String name, int price, Category category, int kcalories) {
        super(id, name, price, category, kcalories);
    }

    @Override
    public AbstractProductModel withId(int id) {
        return new CheesecakeModel(
                id,
                this.getName(),
                this.getPrice(),
                this.getCategory(),
                this.getKcalories());
    }


}
