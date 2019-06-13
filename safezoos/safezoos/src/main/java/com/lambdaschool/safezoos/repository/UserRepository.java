package com.lambdaschool.safezoos.repository;

import com.lambdaschool.safezoos.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
