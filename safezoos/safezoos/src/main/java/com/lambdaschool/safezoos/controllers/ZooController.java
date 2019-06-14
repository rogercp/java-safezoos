package com.lambdaschool.safezoos.controllers;


import com.lambdaschool.safezoos.model.Zoo;
import com.lambdaschool.safezoos.service.AnimalService;
import com.lambdaschool.safezoos.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAuthority('ROLE_ZOODATA')")
    @GetMapping(value="/zoos",produces = {"application/json"})
    public ResponseEntity<?>listAllZoos()
    {
        ArrayList<Zoo> myZoos=zooService.findAll();
        return new ResponseEntity<>(myZoos, HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ROLE_ZOODATA')")
    @GetMapping(value = "/zoos/{id}", produces = {"application/json"})
    public ResponseEntity<?> findZooById(@PathVariable long id)
    {
        Zoo z = zooService.findZooById(id);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('ROLE_ZOODATA')")
    @GetMapping(value = "/{name}", produces = {"application/json"})
    public ResponseEntity<?> findZooByName(@PathVariable String name)
    {
        Zoo z = zooService.findZooByName(name);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }




    

}




