package com.fruit.app.controller;

import com.fruit.app.dto.input.CreateFruitInputDTO;
import com.fruit.app.dto.input.RottenFruitInputDTO;
import com.fruit.app.dto.output.FruitCartResponseDTO;
import com.fruit.app.dto.output.FruitListResponseDTO;
import com.fruit.app.dto.output.FruitResponseDTO;
import com.fruit.app.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("/v1")
public class FruitController extends Controller {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private FruitService fruitService;

    @PostMapping("/fruit")
    public FruitResponseDTO createFruits(@PathVariable @Valid CreateFruitInputDTO createFruitInputDTO){
        FruitResponseDTO fruitCartResponseDTO = fruitService.createFruits(createFruitInputDTO);
        updateHttpStatus(fruitCartResponseDTO,response);
        return fruitCartResponseDTO;
    }

    @PostMapping("/rotten/{fruitId}")
    public FruitCartResponseDTO createFruits(@PathVariable(name ="fruitId") RottenFruitInputDTO dto){
        FruitCartResponseDTO createFruits = fruitService.createFruits(dto);
        updateHttpStatus(createFruits,response);
        return createFruits;
    }

    @GetMapping("/fruit")
    public FruitListResponseDTO fetchFruitCart(@PageableDefault(value = 20) Pageable pageable){
        FruitListResponseDTO fetchFruitCart= fruitService.fetchFruitCart(pageable);
        updateHttpStatus(fetchFruitCart,response);
        return fetchFruitCart;
    }

    @GetMapping("/fruit/{fruitId}")
    public FruitResponseDTO fetchFruitCart(@PathVariable(name = "fruitId") String fruitId){
        FruitResponseDTO fruitCartResponseDTO = fruitService.fetchSingleFruit(fruitId);
        updateHttpStatus(fruitCartResponseDTO,response);
        return fruitCartResponseDTO;
    }
}
