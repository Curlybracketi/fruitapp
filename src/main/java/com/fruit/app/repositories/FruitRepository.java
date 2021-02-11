package com.fruit.app.repositories;


import com.fruit.app.models.Fruit;

import org.springframework.data.repository.CrudRepository;

public interface FruitRepository extends CrudRepository<Fruit, String> {
    Fruit findBy_id(String _id);

    Fruit deleteBy_id(String FruitId);
}