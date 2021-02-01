package com.estiasi.restaurant.controller;

import com.estiasi.restaurant.model.Restaurant;
import com.estiasi.restaurant.service.RestaurantService;
import com.estiasi.restaurant.vo.RestaurantVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public Restaurant findById(@RequestParam("id") Integer id) throws Exception {
        return restaurantService.get(id);
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody RestaurantVO restaurantVO) throws Exception {
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(restaurantVO, restaurant);
        return restaurantService.add(restaurant);
    }

}
