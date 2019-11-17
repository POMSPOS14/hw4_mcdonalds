package ru.rosbank.javaschool.model;

public class FantaModel extends AbstractProductModel {

    private int sizeInMl;

    public FantaModel(int id, String name, int price, Category category, int cCalories, int sizeInMl) {

        super(id, name, price, category, cCalories);

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
                this.getcCalories(),
                this.sizeInMl);
    }

//    public FantaModel from(FantaModel model){
//        return new FantaModel(
//                model.getId(),
//                model.getName(),
//                model.getPrice(),
//                model.getCategory(),
//                model.getcCalories(),
//                model.getSizeInMl());
//    }

//    public FantaModel() {
//        super(8, "Fanta", 65, Category.DRINKS, 132);
//        this.sizeInMl = 400;
//    }


}
