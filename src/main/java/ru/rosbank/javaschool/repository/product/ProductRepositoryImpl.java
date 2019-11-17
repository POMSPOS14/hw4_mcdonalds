package ru.rosbank.javaschool.repository.product;

import ru.rosbank.javaschool.exception.DataNotFoundException;
import ru.rosbank.javaschool.model.AbstractProductModel;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductRepositoryImpl implements ProductRepository {
    private Collection<AbstractProductModel> items = Collections.emptyList();
    private int nextId = 1;

    public int getNextId() {
        return nextId;
    }

    public ProductRepositoryImpl() {
    }

    public Collection<AbstractProductModel> getAll() {
        return Collections.unmodifiableCollection(items);
    }

    @Override
    public AbstractProductModel create(AbstractProductModel item) {
        AbstractProductModel copy = item.withId(nextId++);
        items = Stream.concat(items.stream(), Stream.of(copy))
                .collect(Collectors.toList());

        return copy;
    }

    @Override
    public Optional<AbstractProductModel> readById(int id) {
        return items.stream()
                .filter(o -> o.getId() == id)
                .findFirst();
    }


    @Override
    public AbstractProductModel update(AbstractProductModel item) {
        AbstractProductModel copy = AbstractProductModel.from(item);

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
        Collection<AbstractProductModel> original = items;
        Collection<AbstractProductModel> copy = items.stream()
                .filter(o -> o.getId() != id)
                .collect(Collectors.toList());
        items = copy;

        return original.size() == copy.size();
    }
}
