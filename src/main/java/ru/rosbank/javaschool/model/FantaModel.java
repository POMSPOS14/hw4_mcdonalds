package ru.rosbank.javaschool.model;

public class FantaModel extends AbstractProductModel {

    private int sizeInMl;

    public FantaModel(int id, String name, int price, Category category, int kcalories, int sizeInMl) {

        super(id, name, price, category, kcalories);

        this.sizeInMl = sizeInMl;
    }

    public int getSizeInMl() {
        return sizeInMl;
    }

    @Override
    public AbstractProductModel withId(int id) {
        return new FantaModel(
                id,
                this.getName(),
                this.getPrice(),
                this.getCategory(),
                this.getKcalories(),
                this.sizeInMl);
    }




}
