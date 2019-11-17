package ru.rosbank.javaschool.model;

public class ColaModel extends AbstractProductModel {

    private int sizeInMl;

    public ColaModel(int id, String name, int price, Category category, int kcalories, int sizeInMl) {
        super(id, name, price, category, kcalories);
        this.sizeInMl = sizeInMl;
    }

    public int getSizeInMl() {
        return sizeInMl;
    }

    @Override
    public AbstractProductModel withId(int id) {
        return new ColaModel(
                id,
                this.getName(),
                this.getPrice(),
                this.getCategory(),
                this.getKcalories(),
                this.getSizeInMl());
    }



}
