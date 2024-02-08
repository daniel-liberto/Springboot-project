package com.danielalmeida.springlesson.resources;

import com.danielalmeida.springlesson.entities.User;
import com.danielalmeida.springlesson.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
  @Autowired
  private UserService service;
  @GetMapping // return all users
  public ResponseEntity<List<User>> findAll(){
    List<User> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }
  @GetMapping(value = "/{id}") // return specified id
  public ResponseEntity<User> findById(@PathVariable Long id){
    User obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @PostMapping
  public ResponseEntity<User> insert(@RequestBody User obj){
    obj = service.insert(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(obj.getId())
            .toUri();
    return ResponseEntity.created(uri).body(obj);
  }
}
