package ru.rosbank.javaschool.model;

public class DonatModel extends AbstractProductModel {

    public DonatModel(int id, String name, int price, Category category, int cCalories) {
        super(id, name, price, category, cCalories);
    }


    @Override
    public AbstractProductModel withId(int id) {
        return new DonatModel(
                id,
                this.getName(),
                this.getPrice(),
                this.getCategory(),
                this.getcCalories());
    }

//    public DonatModel(AbstractProductModel model){
//        super(
//                model.getId(),
//                model.getName(),
//                model.getPrice(),
//                model.getCategory(),
//                model.getcCalories()
//            );
//
//
//    }



//    public DonatModel() {
//        super(5, "Donat", 79, Category.DESSERTS, 263);
//    }

}
