package com.myapp.api.controller;

import com.myapp.api.dto.UserRequest;
import com.myapp.api.entity.User;
import com.myapp.api.exception.ApplicationInternalException;
import com.myapp.api.exception.UserNotFoundException;
import com.myapp.api.response.ResponseContainer;
import com.myapp.api.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User Controller", description = "User Controller for All the users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<ResponseContainer<List<User>>> getAllUsers() throws ApplicationInternalException {
        return ResponseEntity.ok(new ResponseContainer<>(service.getALlUsers()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<User>> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(new ResponseContainer<>(service.getUser(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseContainer<String>> deleteUser(@PathVariable int id) throws UserNotFoundException {
        service.deleteUSer(id);
        return ResponseEntity.ok(new ResponseContainer<>("User Deleted with Id:"+id));
    }
   /* @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers() throws ApplicationInternalException {
        return ResponseEntity.ok((service.getALlUsers()));
    }
*/
}
