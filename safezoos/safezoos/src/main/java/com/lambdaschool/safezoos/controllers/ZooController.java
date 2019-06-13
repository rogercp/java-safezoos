package com.lambdaschool.safezoos.controllers;


import com.lambdaschool.safezoos.model.Zoo;
import com.lambdaschool.safezoos.service.AnimalService;
import com.lambdaschool.safezoos.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping(value="zoos")
public class ZooController
{
    @Autowired
    private ZooService zooService;


    @GetMapping(value="/zoos",produces = {"application/json"})
    public ResponseEntity<?>listAllZoos()
    {
        ArrayList<Zoo> myZoos=zooService.findAll();
        return new ResponseEntity<>(myZoos, HttpStatus.OK);
    }

    @DeleteMapping(" /admin/zoos/{id}")
    public ResponseEntity<?> deleteZooById(@PathVariable long id)
    {
        zooService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value="/admin/zoos",
            consumes = {"application/json"},
            produces="application/json")
    public ResponseEntity<?> addNewZoo(@Valid @RequestBody Zoo newZoo)
    {
        newZoo=zooService.save(newZoo);

        HttpHeaders responseHeader= new HttpHeaders();

        URI newZooURI= ServletUriComponentsBuilder.fromCurrentRequest().path("/{zooid}").buildAndExpand(newZoo.getZooid()).toUri();
        responseHeader.setLocation(newZooURI);

        return new ResponseEntity<>(null,responseHeader,HttpStatus.OK);
    }


    @PutMapping(value="/admin/zoos/{zooid}",
            consumes={"application/json"})
    public ResponseEntity<?> updateZoo(@RequestBody Zoo updateZoo, @PathVariable long zooid)
    {
        zooService.update(updateZoo,zooid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}




