package ru.rosbank.javaschool.model;

public class ChickenburgerModel extends AbstractProductModel {

    private String meat;

    public ChickenburgerModel(int id, String name, int price, Category category, int kcalories, String meat) {
        super(id, name, price, category, kcalories);
        this.meat = meat;
    }

    public String getMeat() {
        return meat;
    }

    @Override
    public AbstractProductModel withId(int id) {
        return new ChickenburgerModel(
                id,
                this.getName(),
                this.getPrice(),
                this.getCategory(),
                this.getKcalories(),
                this.getMeat());
    }


}
