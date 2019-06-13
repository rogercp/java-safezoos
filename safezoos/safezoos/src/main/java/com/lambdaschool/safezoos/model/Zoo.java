package com.lambdaschool.safezoos.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="zoo")
public class Zoo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    private String zooname;

    @OneToMany(mappedBy ="zoo",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("zoos")
    private List<Telephone> phones=new ArrayList<>();


    @ManyToMany
    @JoinTable(name="zooanimals",
            joinColumns = {@JoinColumn(name="zooid")},
            inverseJoinColumns = {@JoinColumn(name = "animalid")})
    @JsonIgnoreProperties("zoos")
    private List<Animal> animals= new ArrayList<>();

    public Zoo()
    {
    }

    public Zoo(String zooname)
    {
        this.zooname = zooname;
    }

    public Zoo(String zooname, List<Telephone> phones, List<Animal> animals)
    {
        this.zooname = zooname;
        this.phones = phones;
        this.animals = animals;
    }

    public Zoo(List<Telephone> phones, List<Animal> animals)
    {
        this.phones = phones;
        this.animals = animals;
    }

    public long getZooid()
    {
        return zooid;
    }

    public void setZooid(long zooid)
    {
        this.zooid = zooid;
    }

    public String getZooname()
    {
        return zooname;
    }

    public void setZooname(String zooname)
    {
        this.zooname = zooname;
    }

    public List<Telephone> getPhones()
    {
        return phones;
    }

    public void setPhones(List<Telephone> phones)
    {
        this.phones = phones;
    }

    public List<Animal> getAnimals()
    {
        return animals;
    }

    public void setAnimals(List<Animal> animals)
    {
        this.animals = animals;
    }
}
