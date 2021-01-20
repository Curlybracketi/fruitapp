package com.fruit.app.repositories;

import com.fruit.app.models.FruitCart;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;


public interface FruitCartRepository
  extends CrudRepository<FruitCart,String> {
       FruitCart findByDate(Date date);
}
