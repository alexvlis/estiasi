package com.estiasi.user.repositories;

import com.estiasi.repositories.Repository;
import com.estiasi.user.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@org.springframework.stereotype.Repository
public class MemUserRepository implements Repository<User, Integer> {

    private final Map<Integer, User> idToUserMap = new ConcurrentHashMap<>();

    @Override
    public boolean contains(Integer id) {
        return idToUserMap.containsKey(id);
    }

    @Override
    public User get(Integer id) {
        return idToUserMap.get(id);
    }

    @Override
    public Collection<User> getAll() {
        return idToUserMap.values();
    }

    @Override
    public void add(User entity) {
        idToUserMap.put(entity.getId(), entity);
    }

    @Override
    public void remove(Integer id) {
        idToUserMap.remove(id);
    }

    @Override
    public void update(User entity) {
        idToUserMap.put(entity.getId(), entity);
    }

}
