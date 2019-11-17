package ru.rosbank.javaschool.model;

public class FrenchFriesModel extends AbstractProductModel {

    public FrenchFriesModel(int id, String name, int price, Category category, int cCalories) {
        super(id, name, price, category, cCalories);
    }

    @Override
    public AbstractProductModel withId(int id) {
        return new FrenchFriesModel(
                id,
                this.getName(),
                this.getPrice(),
                this.getCategory(), this.getcCalories());
    }

//    public FrenchFriesModel from(FrenchFriesModel model){
//        return new FrenchFriesModel(
//                model.getId(),
//                model.getName(),
//                model.getPrice(),
//                model.getCategory()
//                ,model.getcCalories());
//    }
//    public FrenchFriesModel() {
//        super(3, "FrenchFries", 59, Category.POTATO, 330);
//    }

}
