package ru.rosbank.javaschool.model;

public class ChickenburgerModel extends AbstractProductModel {

    private String meat;

    public ChickenburgerModel(int id, String name, int price, Category category, int cCalories, String meat) {
        super(id, name, price, category, cCalories);
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
                this.getcCalories(),
                this.getMeat());
    }

//    public ChickenburgerModel from(ChickenburgerModel model){
//        return new ChickenburgerModel(
//                model.getId(),
//                model.getName(),
//                model.getPrice(),
//                model.getCategory(),
//                model.getcCalories(),
//                model.getMeat());
//    }

//    public  ChickenburgerModel() {
//        super(2," chickenburger",52,Category.SANDWICHES, 339);
//        this.meat="chicken";
//    }
}
