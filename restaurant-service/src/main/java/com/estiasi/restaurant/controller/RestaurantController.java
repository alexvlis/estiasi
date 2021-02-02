package com.estiasi.restaurant.controller;

import com.estiasi.restaurant.model.Restaurant;
import com.estiasi.restaurant.service.RestaurantService;
import com.estiasi.restaurant.vo.RestaurantVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
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

    @GetMapping("/name")
    public List<Restaurant> findByName(@RequestParam("name") String name) throws Exception {
        return restaurantService.get(name);
    }

    @GetMapping("/all")
    public Iterable<Restaurant> getAll() throws Exception {
        return restaurantService.getAll();
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody @Valid RestaurantVO restaurantVO) throws Exception {
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(restaurantVO, restaurant);
        return restaurantService.add(restaurant);
    }

    @PutMapping
    public Restaurant updateRestaurant(@RequestBody @Valid RestaurantVO restaurantVO) throws Exception {
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(restaurantVO, restaurant);
        return restaurantService.update(restaurant);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRestaurant(@RequestParam("id") Integer id) throws Exception {
        restaurantService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
