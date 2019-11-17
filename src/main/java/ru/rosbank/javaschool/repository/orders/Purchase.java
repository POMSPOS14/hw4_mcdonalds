package ru.rosbank.javaschool.repository.orders;

import ru.rosbank.javaschool.model.AbstractProductModel;
import ru.rosbank.javaschool.repository.product.ProductRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Purchase {
    private Collection<AbstractProductModel> items = Collections.emptyList();
    private int id;

    public Collection<AbstractProductModel> getItems() {
        return items;
    }


    public int getId() {
        return id;
    }

    public Purchase(int id, ProductRepositoryImpl repository, int... idProduct) {
        this.id = id;
        for (int i = 0; i < idProduct.length; i++) {

            int finalI = i;
            repository.getAll()
                    .stream()
                    .filter(o -> o.getId() == idProduct[finalI])
                    .findFirst()
                    .orElseThrow(RuntimeException::new);

            items = Stream.concat(items.stream(), repository.getAll()
                    .stream()
                    .filter(o -> o.getId() == idProduct[finalI]))
                    .collect(Collectors.toList());

        }

    }


    public List<Integer> getIdAllProduct() {
        List<Integer> result = new ArrayList<>();
        for (AbstractProductModel item : items) {
            result.add(item.getId());
        }
        return result;

    }

}
