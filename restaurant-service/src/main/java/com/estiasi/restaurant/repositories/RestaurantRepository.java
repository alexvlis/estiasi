package com.estiasi.restaurant.repositories;

import com.estiasi.restaurant.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

}
