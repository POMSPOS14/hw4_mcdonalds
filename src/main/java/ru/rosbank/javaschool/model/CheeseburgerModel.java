package ru.rosbank.javaschool.model;


import lombok.Getter;

@Getter

public class CheeseburgerModel extends AbstractProductModel {

    private String meat;



    public CheeseburgerModel(int id, String name, int price, Category category, int cCalories, String meat) {
        super(id, name, price, category, cCalories);
        this.meat = meat;
    }

    public String getMeat() {
        return meat;
    }

    @Override
    public AbstractProductModel withId(int id) {
        return new CheeseburgerModel(
                id,
                this.getName(),
                this.getPrice(),
                this.getCategory(),
                this.getcCalories(),
                this.getMeat());
    }

//    public CheeseburgerModel from(CheeseburgerModel model){
//        return new CheeseburgerModel(
//                model.getId(),
//                model.getName(),
//                model.getPrice(),
//                model.getCategory(),
//                model.getcCalories(),
//                model.getMeat());
//    }

//    public CheeseburgerModel() {
//        super(1,"cheeseburger",52,Category.SANDWICHES, 302);
//        this.meat="beef";
//    }
}
