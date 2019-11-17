package ru.rosbank.javaschool.model;

public class RusticPotatoesModel extends AbstractProductModel {

//    public RusticPotatoesModel() {
//        super(4, "FrenchFries", 77, Category.POTATO, 321);
//
//    }

    public RusticPotatoesModel(int id, String name, int price, Category category, int cCalories) {
        super(id, name, price, category, cCalories);
    }

    @Override
    public AbstractProductModel withId(int id) {
        return new RusticPotatoesModel(
                id,
                this.getName(),
                this.getPrice(),
                this.getCategory(),
                this.getcCalories());
    }

//    public RusticPotatoesModel from(RusticPotatoesModel model){
//        return new RusticPotatoesModel(
//                model.getId(),
//                model.getName(),
//                model.getPrice(),
//                model.getCategory(),
//                model.getcCalories());
//    }
}
