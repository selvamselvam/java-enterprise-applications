package com.selvam.hibernateexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.selvam.hibernateexample.model.OpenUser;
import com.selvam.hibernateexample.service.SoccerService;

@Controller
@RestController
public class UserController {

	List<OpenUser> list = new ArrayList<>();

	@Autowired
	SoccerService soccerService;

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<OpenUser> getUsers() {
		list = soccerService.getAllUsers();
		return list;
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public OpenUser CreaseUser(@RequestBody OpenUser user) {
		return soccerService.addOpenUser(user.getId(), user.getName(), user.getEmail(), user.getAge());
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<OpenUser> getUserByID(@PathVariable("id") int id) {
		Optional<OpenUser> ouser = soccerService.getUserByID(id);
		OpenUser obj = null;
		if (Objects.nonNull(ouser)) {
			obj = ouser.get();

			if (Objects.isNull(obj))
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			else
				return new ResponseEntity<OpenUser>(obj, HttpStatus.OK);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}

}
