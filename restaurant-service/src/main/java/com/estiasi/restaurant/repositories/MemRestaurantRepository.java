package com.estiasi.restaurant.repositories;

import com.estiasi.repositories.Repository;
import com.estiasi.restaurant.model.Restaurant;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@org.springframework.stereotype.Repository
public class MemRestaurantRepository implements Repository<Restaurant, Integer> {

    private final Map<Integer, Restaurant> idToRestaurantMap = new ConcurrentHashMap<>();

    @Override
    public boolean contains(Integer id) {
        return idToRestaurantMap.containsKey(id);
    }

    @Override
    public Restaurant get(Integer id) {
        return idToRestaurantMap.get(id);
    }

    @Override
    public Collection<Restaurant> getAll() {
        return idToRestaurantMap.values();
    }

    @Override
    public void add(Restaurant entity) {
        idToRestaurantMap.put(entity.getId(), entity);
    }

    @Override
    public void remove(Integer id) {
        idToRestaurantMap.remove(id);
    }

    @Override
    public void update(Restaurant entity) {
        idToRestaurantMap.put(entity.getId(), entity);
    }
}
