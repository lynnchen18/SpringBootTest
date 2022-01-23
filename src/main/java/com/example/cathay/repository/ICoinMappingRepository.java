package com.example.cathay.repository;

import com.example.cathay.entity.Coin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoinMappingRepository extends CrudRepository<Coin, Integer> {
    Coin findByCode(String code);

    void deleteByCode(String code);
}
