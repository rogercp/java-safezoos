package com.lambdaschool.safezoos.service;

import com.lambdaschool.safezoos.model.Zoo;

import java.util.ArrayList;

public interface ZooService
{
    ArrayList<Zoo> findAll();

    Zoo findZooById(long id);

    Zoo findZooByName(String name);

    void delete(long id);

    Zoo save(Zoo zoo);

    Zoo update(Zoo zoo, long id);


}
