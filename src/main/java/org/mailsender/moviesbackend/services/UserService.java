package org.mailsender.moviesbackend.services;


import org.mailsender.moviesbackend.entities.User;
import org.mailsender.moviesbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public User signUp(User user) {
        // Check if the email is already registered
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already registered");
        }

        // Encrypt the password before saving it to the database
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Save the user to the database
        System.out.println("user added");
        return userRepository.save(user);
    }

    public User signIn(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }

        return null;
    }
}
