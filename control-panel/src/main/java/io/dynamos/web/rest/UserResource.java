package io.dynamos.web.rest;

import io.dynamos.domain.entity.User;
import io.dynamos.domain.repository.UserRepository;
import io.dynamos.domain.service.UserService;
import io.dynamos.domain.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by adelmo.pereira on 30/03/2017.
 */
@Controller
@RequestMapping(value = "api/user")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity query(@PageableDefault(sort = {"firstName", "login"}, value = 15) Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity find(@PathVariable Long id) {
        return Optional.ofNullable(userRepository.findOne(id)).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody UserDTO userDTO) {
        User user = userService.createUserInformation(userDTO.getLogin(), userDTO.getPassword(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail());
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity update(@RequestBody UserDTO userDTO) {
        return null;
    }
}
