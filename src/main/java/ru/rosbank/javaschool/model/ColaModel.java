package ru.rosbank.javaschool.model;

public class ColaModel extends AbstractProductModel {

    private int sizeInMl;

    public ColaModel(int id, String name, int price, Category category, int cCalories, int sizeInMl) {
        super(id, name, price, category, cCalories);
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
                this.getcCalories(),
                this.getSizeInMl());
    }

//    public ColaModel from(ColaModel model){
//        return new ColaModel(
//                model.getId(),
//                model.getName(),
//                model.getPrice(),
//                model.getCategory(),
//                model.getcCalories(),
//                model.getSizeInMl());
//    }

//    public ColaModel() {
//        super(7, "Cola", 65, Category.DRINKS, 170);
//        this.sizeInMl = 400;
//    }

}
