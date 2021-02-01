package com.estiasi.user.repositories;

import com.estiasi.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
