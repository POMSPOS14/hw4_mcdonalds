package ru.rosbank.javaschool.model;

public class CheesecakeModel extends AbstractProductModel {

    public CheesecakeModel(int id, String name, int price, Category category, int cCalories) {
        super(id, name, price, category, cCalories);
    }

    @Override
    public AbstractProductModel withId(int id) {
        return new CheesecakeModel(
                id,
                this.getName(),
                this.getPrice(),
                this.getCategory(),
                this.getcCalories());
    }

//    public CheesecakeModel from(CheesecakeModel model){
//        return new CheesecakeModel(
//                model.getId(),
//                model.getName(),
//                model.getPrice(),
//                model.getCategory(),
//                model.getcCalories());
//    }


//    public CheesecakeModel() {
//        super(6, "Donat", 129, Category.DESSERTS, 359);
//    }
}
