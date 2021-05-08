package com.selvam.hibernateexample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selvam.hibernateexample.model.OpenUser;
import com.selvam.hibernateexample.repository.OpenUserRepository;

@Service
public class SoccerServiceImpl implements SoccerService {
	@Autowired
	private OpenUserRepository userRepository;

	@Override
	public OpenUser addOpenUser(long id, String name, String email, int age) {
		OpenUser user = new OpenUser();
		user.setName(name);
		user.setEmail(email);
		user.setId(id);
		user.setAge(age);
		return userRepository.save(user);
	}

	@Override
	public List<OpenUser> getAllUsers() {
		List<OpenUser> result = new ArrayList<OpenUser>();
		Iterable<OpenUser>  players = userRepository.findAll();
		for(OpenUser ou : players) {
			result.add(ou);
		}
		return result;
	}

	@Override
	public Optional<OpenUser> getUserByID(long id) {
		return userRepository.findById(id);
	}

}