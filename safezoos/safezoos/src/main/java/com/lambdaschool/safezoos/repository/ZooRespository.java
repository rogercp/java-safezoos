package com.lambdaschool.safezoos.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ZooRespository
{
    @Modifying
    @Query(value ="DELETE FROM zooanimals WHERE zooid=:zooid", nativeQuery = true)
    void deleteZooFromZoos(long zooid);

    @Modifying
    @Query(value = "DELETE FROM telephone WHERE zooid=:zooid",nativeQuery = true)
    void deletePhonesFromZoos(long zooid);
}
