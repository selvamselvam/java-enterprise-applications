package com.selvam.hibernateexample.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.selvam.hibernateexample.model.OpenUser;

@Repository
public interface OpenUserRepository extends CrudRepository<OpenUser, Long> {
    Optional<OpenUser> findById(Long userID);
    Iterable<OpenUser> findAll();
}