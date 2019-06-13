package com.lambdaschool.safezoos.repository;

import com.lambdaschool.safezoos.model.Telephone;
import org.springframework.data.repository.CrudRepository;

public interface TelephoneRepository extends CrudRepository<Telephone,Long>
{
}