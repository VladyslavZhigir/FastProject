package org.krjr.usersubscriptions.controller;

import lombok.RequiredArgsConstructor;
import org.krjr.usersubscriptions.dto.UserDTO;
import org.krjr.usersubscriptions.entity.User;
import org.krjr.usersubscriptions.mapper.UserMapper;
import org.krjr.usersubscriptions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        User createdUser = userService.create(userMapper.fromDto(userDTO));
        return ResponseEntity.ok(userMapper.toDto(createdUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> get(@PathVariable Long id) {
        return userService.get(id)
                .map(userMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        User updatedUser = userService.update(id,userMapper.fromDto(userDTO));
        return ResponseEntity.ok(userMapper.toDto(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}