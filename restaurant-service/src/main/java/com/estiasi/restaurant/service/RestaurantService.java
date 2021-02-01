package com.estiasi.restaurant.service;

import com.estiasi.restaurant.model.Restaurant;
import com.estiasi.restaurant.repositories.MemRestaurantRepository;
import com.estiasi.restaurant.repositories.RestaurantRepository;
import com.estiasi.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService extends BaseService<Restaurant, Integer> {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository,
                             MemRestaurantRepository memRestaurantRepository) {
        super(memRestaurantRepository);
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant get(Integer id) {
        if (super.contains(id)) {
            return super.get(id);
        }
        return restaurantRepository.findById(id).get();
    }

    @Override
    public Restaurant add(Restaurant restaurant) throws Exception {
        restaurant = restaurantRepository.save(restaurant);
        super.add(restaurant);
        return restaurant;
    }

}
