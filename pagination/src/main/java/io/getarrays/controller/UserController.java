package io.getarrays.controller;


import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.getarrays.domain.Employee;
import io.getarrays.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class UserController {
   private final UserService userService;
   
   @GetMapping("/users")
   public ResponseEntity<Page<Employee>> getUsers(@RequestParam Optional<String> name,
		   @RequestParam Optional<Integer> page,
		   @RequestParam Optional<Integer> size) throws InterruptedException{
//	       TimeUnit.SECONDS.sleep(3);
//	       throw new RuntimeException("Forced Exception for testing");
	       Page<Employee> users = userService.getUsers(name.orElse(""),page.orElse(0),size.orElse(10));
		  return new ResponseEntity<>(users,HttpStatus.OK);
	   
   }
}
                                                                                                            