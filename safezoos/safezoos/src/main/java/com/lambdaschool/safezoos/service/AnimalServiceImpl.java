package com.lambdaschool.safezoos.service;

import com.lambdaschool.safezoos.repository.AnimalRepository;
import com.lambdaschool.safezoos.view.CountZoosOfAnimals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService
{
    @Autowired
    private AnimalRepository animalrepos;


    @Override
    public ArrayList<CountZoosOfAnimals> getCountZoosOfAnimal()
    {
        return animalrepos.getCountZoosOfAnimal();
    }


}
