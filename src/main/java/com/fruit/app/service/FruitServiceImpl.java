package com.fruit.app.service;

import com.fruit.app.dto.enums.Status;
import com.fruit.app.dto.input.CreateFruitInputDTO;
import com.fruit.app.dto.input.FetchFruitCartInputDTO;
import com.fruit.app.dto.input.RottenFruitInputDTO;
import com.fruit.app.dto.output.FruitCartResponseDTO;
import com.fruit.app.dto.output.FruitListResponseDTO;
import com.fruit.app.dto.output.FruitResponseDTO;
import com.fruit.app.models.Fruit;
import com.fruit.app.models.FruitCart;
import com.fruit.app.models.RottenFruit;
import com.fruit.app.repositories.FruitRepository;
import com.fruit.app.repositories.FruitCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 @Service("fruitService")
  public class FruitServiceImpl implements FruitService {
  @Autowired
  private FruitRepository fruitRepository;

  @Autowired
  private FruitCartRepository fruitcartRepository;

  private static final String SERVICE_NAME = "FruitService";


  void logError(String serviceName, String methodName, Exception ex) {
   ex.printStackTrace(); //fluentd, logstash
  }

  @Override
  public FruitResponseDTO createFruits(CreateFruitInputDTO dto) {
   Fruit newFruit = createNewFruit(dto);
   fruitRepository.save(newFruit);
   if (newFruit == null){
    return new FruitResponseDTO(Status.NOT_FOUND);
   }
   return new FruitResponseDTO(Status.SUCCESS, newFruit);
  }

  @Override
  public FruitCartResponseDTO createFruits(RottenFruitInputDTO dto) {
   try{
    FruitCart fruitcart = new FruitCart();
    fruitcart.setDate(new Date());

    List<RottenFruit> fruit = dto.getFruits();
    for (RottenFruit rottenfruit : fruit){
     if (rottenfruit.isRotten()){
      String fruitId = rottenfruit.getFruitId();
      Fruit fruits = fruitRepository.findBy_id(fruitId);
      List<Fruit> totalFruits = getExisting(fruitcart.getTotalFruits());
      totalFruits.add(fruits);
      fruitcart.setTotalFruits(totalFruits);
      int numberOfTotalFruits = fruitcart.getTotalFruits().size();
      fruitcart.setNumberOfTotalFruits(numberOfTotalFruits);
      fruitcartRepository.save(fruitcart);
     }else if (isSold(rottenfruit)){
      String fruitId = rottenfruit.getFruitId();
      Fruit fruits = fruitRepository.findBy_id(fruitId);
      List<Fruit> soldFruits = getExisting(fruitcart.getSoldFruits());
      soldFruits.add(fruits);
      fruitcart.setSoldFruits(soldFruits);
      int numberOfSoldFruits = fruitcart.getSoldFruits().size();
      fruitcart.setNumberOfSoldFruits(numberOfSoldFruits);
      fruitcartRepository.save(fruitcart);
     }
    }

    return new FruitCartResponseDTO(Status.SUCCESS,fruitcart);

   } catch (Exception e){
    logError(SERVICE_NAME, "RottenFruit", e);
    return new FruitCartResponseDTO(Status.INTERNAL_ERROR);
   }
  }

  private boolean isSold(RottenFruit fruit){
   return fruit.isRotten() == false;
  }

  @Override
  public FruitListResponseDTO fetchFruitCart(Pageable pageable) {
   List<Fruit> FruitList = (List<Fruit>) fruitRepository.findAll();
   return new FruitListResponseDTO(Status.SUCCESS,FruitList);
  }

  @Override
  public FruitCartResponseDTO fetchFruitCart(FetchFruitCartInputDTO dto) {
   FruitCart fruit = fruitcartRepository.findByDate(dto.getDate());
   if (fruit == null){
    return new FruitCartResponseDTO(Status.NOT_FOUND);
   }
   return  new FruitCartResponseDTO(Status.SUCCESS,fruit);

  }

  @Override
  public FruitResponseDTO fetchSingleFruit(String fruitId) {
    Fruit fruit = fruitRepository.findBy_id(fruitId);
    if (fruit == null){
     return new FruitResponseDTO(Status.NOT_FOUND);
    }
    return new FruitResponseDTO(Status.SUCCESS, fruit);
  }

  private <T> List<T> getExisting(List<T> t) {
   return t == null ? new ArrayList() : t;
  }

  private Fruit createNewFruit(CreateFruitInputDTO dto) {
   return new Fruit(dto.getName(),dto.getSize(),dto.getSize());
  }

 }
