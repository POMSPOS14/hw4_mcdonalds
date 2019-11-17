package ru.rosbank.javaschool.repositoryForOrders;

import ru.rosbank.javaschool.repositoryForProduct.ProductRepositoryImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrdersRepositoryImpl {

    private Collection<Purchase> items = Collections.emptyList();
    private int nextId = 1;

    public Collection<Purchase> getAll(){return Collections.unmodifiableCollection(items);}

    public Purchase create(ProductRepositoryImpl repository, int ... product){
        Purchase copy = new Purchase(nextId++, repository ,product);
        items = Stream.concat(items.stream(), Stream.of(copy))
                .collect(Collectors.toList())
        ;
        return copy;
    }
}
