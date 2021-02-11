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
import com.fruit.app.models.extras.RottenFruit;
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
  private FruitCartRepository fruitCartRepository;

  private static final String SERVICE_NAME = "FruitService";


  void logError(String serviceName, String methodName, Exception ex) {
   ex.printStackTrace(); //fluentd, logstash
  }

  @Override
  public FruitResponseDTO createFruit(CreateFruitInputDTO dto) {
   try{
   Fruit newFruit = createNewFruit(dto);
   fruitRepository.save(newFruit);

   return new FruitResponseDTO(Status.SUCCESS, newFruit);
  }catch(Exception e){
    logError(SERVICE_NAME, "createFruit", e);
    return new FruitResponseDTO(Status.INTERNAL_ERROR);
   }
  }


  @Override
  public FruitCartResponseDTO markFruitCart(RottenFruitInputDTO dto) {
   try{
    FruitCart fruitCart = new FruitCart();
    fruitCart.setDate(new Date());

    List<RottenFruit> fruitCartForms = dto.getFruitCartForms();
    for (RottenFruit fruitCartForm : fruitCartForms){
     if (fruitCartForm.isRotten()){
      String fruitId = fruitCartForm.getFruitId();
      Fruit fruit = fruitRepository.findBy_id(fruitId);
      List<Fruit> totalFruits = getExisting(fruitCart.getTotalFruits());
      totalFruits.add(fruit);
      fruitCart.setTotalFruits(totalFruits);
      int numberOfTotalFruits = fruitCart.getTotalFruits().size();
      fruitCart.setNumberOfTotalFruits(numberOfTotalFruits);
      fruitCartRepository.save(fruitCart);
     }else if (isSold(fruitCartForm)){
      String fruitId =fruitCartForm.getFruitId();
      Fruit fruit = fruitRepository.findBy_id(fruitId);
      List<Fruit> soldFruits = getExisting(fruitCart.getSoldFruits());
      soldFruits.add(fruit);
      fruitCart.setSoldFruits(soldFruits);
      int numberOfSoldFruits = fruitCart.getSoldFruits().size();
      fruitCart.setNumberOfSoldFruits(numberOfSoldFruits);
      fruitCartRepository.save(fruitCart);
     }
    }

    return new FruitCartResponseDTO(Status.SUCCESS,fruitCart);

   } catch (Exception e){
    logError(SERVICE_NAME, "markFruitCart", e);
    return new FruitCartResponseDTO(Status.INTERNAL_ERROR);
   }
  }

  private boolean isSold(RottenFruit form){
   return form.isRotten() == false;
  }

  @Override
  public FruitListResponseDTO fetchFruit(Pageable pageable) {
   List<Fruit> fruitList = (List<Fruit>) fruitRepository.findAll();
   return new FruitListResponseDTO(Status.SUCCESS,fruitList);
  }

 @Override
  public FruitCartResponseDTO fetchFruitCart(FetchFruitCartInputDTO dto) {
   FruitCart fruitCart = fruitCartRepository.findByDate(dto.getDate());
   if (fruitCart == null){
    return new FruitCartResponseDTO(Status.NOT_FOUND);
   }
   return  new FruitCartResponseDTO(Status.SUCCESS,fruitCart);

  }

  @Override
  public FruitResponseDTO fetchSingleFruit(String fruitId) {
    Fruit fruit = fruitRepository.findBy_id(fruitId);
    if (fruit == null){
     return new FruitResponseDTO(Status.NOT_FOUND);
    }
    return new FruitResponseDTO(Status.SUCCESS, fruit);
  }

  @Override
  public FruitResponseDTO deleteFruit(String fruitId) {

   Fruit fruit  = fruitRepository.deleteBy_id(fruitId);

   if (fruit == null) {
    return new FruitResponseDTO(Status.NO_CONTENT);
   }

   return new FruitResponseDTO(Status.INTERNAL_ERROR);
  }


  private <T> List<T> getExisting(List<T> t) {
   return t == null ? new ArrayList() : t;
  }

  private Fruit createNewFruit(CreateFruitInputDTO dto) {
   return new Fruit(dto.getName(),dto.getType());
  }

 }
