package com.CodeWarriors.GoldenTrainers.service;

import com.CodeWarriors.GoldenTrainers.model.User;
import com.CodeWarriors.GoldenTrainers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        // Actualiza los detalles del usuario
        user.setName(userDetails.getName());
        user.setNumber(userDetails.getNumber());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        // Asume que las órdenes no se actualizan a través de este método

        return userRepository.save(user);
    }

    // Método para buscar un usuario por correo electrónico y contraseña
    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}

