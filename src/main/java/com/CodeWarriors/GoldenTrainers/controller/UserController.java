package com.CodeWarriors.GoldenTrainers.controller;

import com.CodeWarriors.GoldenTrainers.model.User;
import com.CodeWarriors.GoldenTrainers.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    // Método para iniciar sesión
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser) {
        String email = loginUser.getEmail();
        String password = loginUser.getPassword();

        // Buscar el usuario por correo electrónico y contraseña en la base de datos
        User user = userService.findByEmailAndPassword(email, password);

        // Si no se encuentra un usuario con las credenciales proporcionadas, devolver un ResponseEntity con estado 401 (Unauthorized)
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo electrónico o contraseña incorrectos.");
        }

        // Si se encuentra el usuario, devolver un ResponseEntity con estado 200 (OK) y el usuario encontrado
        return ResponseEntity.ok(user);
    }
}


