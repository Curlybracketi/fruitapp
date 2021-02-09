package com.fruit.app.service;

import com.fruit.app.dto.input.CreateFruitInputDTO;
import com.fruit.app.dto.input.FetchFruitCartInputDTO;
import com.fruit.app.dto.input.RottenFruitInputDTO;
import com.fruit.app.dto.output.FruitCartResponseDTO;
import com.fruit.app.dto.output.FruitListResponseDTO;
import com.fruit.app.dto.output.FruitResponseDTO;

import org.springframework.data.domain.Pageable;

public interface FruitService  {

    FruitResponseDTO createFruit(CreateFruitInputDTO createFruitInputDTO);

    FruitCartResponseDTO markFruitCart(RottenFruitInputDTO dto);

    FruitListResponseDTO fetchFruit(Pageable pageable);

    FruitCartResponseDTO fetchFruitCart(FetchFruitCartInputDTO dto);

    FruitResponseDTO fetchSingleFruit(String fruitId);
}
