package com.estiasi.restaurant.repositories;

import com.estiasi.restaurant.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

    List<Restaurant> findByName(String name);

}
