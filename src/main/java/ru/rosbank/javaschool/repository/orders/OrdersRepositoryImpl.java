package ru.rosbank.javaschool.repository.orders;

import ru.rosbank.javaschool.exception.DataNotFoundException;
import ru.rosbank.javaschool.repository.product.ProductRepositoryImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrdersRepositoryImpl implements OrdersRepository {

    private Collection<Purchase> items = Collections.emptyList();
    private int nextId = 1;

    public OrdersRepositoryImpl() {
    }

    @Override
    public int getNextId() {
        return nextId;
    }

    public Collection<Purchase> getAll() {
        return Collections.unmodifiableCollection(items);
    }

    @Override
    public Optional<Purchase> getById(int id) {
        return items.stream()
                .filter(o -> o.getId() == id)
                .findFirst();

    }


    @Override
    public Purchase create(ProductRepositoryImpl repository, int... idProduct) {
        Purchase copy = new Purchase(nextId++, repository, idProduct);
        items = Stream.concat(items.stream(), Stream.of(copy))
                .collect(Collectors.toList())
        ;
        return copy;
    }

    @Override
    public Purchase update(int id, ProductRepositoryImpl repository, int... product) {
        Purchase copy = new Purchase(id, repository, product);
        items.stream()
                .filter(o -> o.getId() == copy.getId())
                .findAny()
                .orElseThrow(DataNotFoundException::new);

        items = items.stream()
                .map(o -> o.getId() == copy.getId() ? copy : o)
                .collect(Collectors.toList());
        return copy;
    }

    @Override
    public boolean deleteById(int id) {
        Collection<Purchase> original = items;
        Collection<Purchase> copy = items.stream()
                .filter(o -> o.getId() != id)
                .collect(Collectors.toList());
        items = copy;

        return original.size() == copy.size();
    }
}
