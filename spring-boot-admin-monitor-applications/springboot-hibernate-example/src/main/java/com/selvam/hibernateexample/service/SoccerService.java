package com.selvam.hibernateexample.service;

import java.util.List;
import java.util.Optional;

import com.selvam.hibernateexample.model.OpenUser;
public interface SoccerService {
    public List<OpenUser> getAllUsers();
    public OpenUser addOpenUser(long id, String name, String email, int age);
    public Optional<OpenUser> getUserByID(long id);
}