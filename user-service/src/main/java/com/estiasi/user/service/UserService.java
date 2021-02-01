package com.estiasi.user.service;

import com.estiasi.service.BaseService;
import com.estiasi.user.model.User;
import com.estiasi.user.repositories.MemUserRepository;
import com.estiasi.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, Integer> {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, MemUserRepository memUserRepository) {
        super(memUserRepository);
        this.userRepository = userRepository;
    }

    @Override
    public User get(Integer id) {
        if (super.contains(id)) {
            return super.get(id);
        }
        return userRepository.findById(id).get();
    }

    @Override
    public User add(User user) throws Exception {
        user = userRepository.save(user);
        super.add(user);
        return user;
    }

}
