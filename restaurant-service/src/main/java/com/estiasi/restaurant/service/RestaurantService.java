package com.estiasi.restaurant.service;

import com.estiasi.exceptions.EntityNotFoundException;
import com.estiasi.restaurant.model.Restaurant;
import com.estiasi.restaurant.repositories.MemRestaurantRepository;
import com.estiasi.restaurant.repositories.RestaurantRepository;
import com.estiasi.service.BaseService;
import org.apache.tomcat.util.buf.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService extends BaseService<Restaurant, Integer> {

    private final Logger logger = LoggerFactory.getLogger(RestaurantService.class);

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository,
                             MemRestaurantRepository memRestaurantRepository) {
        super(memRestaurantRepository);
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant get(Integer id) throws Exception {
        if (super.contains(id)) {
            return super.get(id);
        }
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if (restaurant.isPresent()) {
            return restaurant.get();
        }
        logger.error("Failed to find restaurant with id {}", id);
        throw new EntityNotFoundException(Restaurant.class, id);
    }

    public List<Restaurant> get(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Cannot search restaurants by name with empty name");
        }
        return restaurantRepository.findByName(name);
    }

    @Override
    public Iterable<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant add(Restaurant restaurant) throws Exception {
        if (restaurant.getId() != null) {
            logger.error("New restaurant cannot have id set");
            throw new IllegalArgumentException("Restaurant create cannot have id set");
        }
        restaurant = restaurantRepository.save(restaurant);
        super.add(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant update(Restaurant restaurant) throws Exception {
        if (restaurant.getId() == null) {
            logger.error("Restaurant update service method received null id");
            throw new IllegalArgumentException("Cannot update restaurant with null id");
        }
        if (!restaurantRepository.existsById(restaurant.getId())) {
            logger.error("Failed to update restaurant with id {}", restaurant.getId());
            throw new EntityNotFoundException(Restaurant.class, restaurant.getId());
        }
        restaurantRepository.save(restaurant);
        super.update(restaurant);
        return restaurant;
    }

    @Override
    public void remove(Integer id) {
        if (restaurantRepository.existsById(id)) {
            restaurantRepository.deleteById(id);
        }
        super.remove(id);
    }

}
