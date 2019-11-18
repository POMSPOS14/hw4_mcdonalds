package ru.rosbank.javaschool.model;


import lombok.Getter;

@Getter

public class BurgerModel extends AbstractProductModel {

    private String meat;



    public BurgerModel(int id, String name, int price, Category category, int kcalories, String meat) {
        super(id, name, price, category, kcalories);
        this.meat = meat;
    }

    public String getMeat() {
        return meat;
    }

    @Override
    public AbstractProductModel withId(int id) {
        return new BurgerModel(
                id,
                this.getName(),
                this.getPrice(),
                this.getCategory(),
                this.getKcalories(),
                this.getMeat());
    }



}
