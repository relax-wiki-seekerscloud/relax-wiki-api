package com.example.relaxwikiapi.service;

import com.example.relaxwikiapi.config.JwtUtil;
import com.example.relaxwikiapi.dto.UserLoginDTO;
import com.example.relaxwikiapi.dto.UserSignUpDTO;
import com.example.relaxwikiapi.entity.User;
import com.example.relaxwikiapi.entity.UserAddress;
import com.example.relaxwikiapi.repo.UserAddressRepository;
import com.example.relaxwikiapi.repo.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;

    private JwtUtil jwtUtil = new JwtUtil();

    @Autowired
    private UserAddressRepository userAddressRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public User addUser(User user) {

        return userRepository.save(user);
    }

//    @Override
//    public String addUser(UserSignUpDTO userDTO) {
//        User existingUser = userRepository.findByEmail(userDTO.getEmail());
//        if (existingUser != null) {
//            return "Email Exists";
//        }
//        User user = new User(
//                userDTO.getFirstName(),
//                userDTO.getLastName(),
//                userDTO.getEmail(),
//                passwordEncoder.encode(userDTO.getPassword())
//        );
//        try {
//            userRepository.save(user);
//        } catch (Exception e) {
//            return "Error";
//        }
//        return "Success";
//    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUserFirstName(Long id, String firstName) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setFirstName(firstName);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User updateUserLastName(Long id, String lastName) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setLastName(lastName);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User updateUserEmail(Long id, String email) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setEmail(email);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User updateUserPhoneNo(Long id, String phoneNo) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setPhoneNo(phoneNo);
            return userRepository.save(user);
        }
        return null;
    }


    @Override
    public User updateUserGender(Long id, String gender) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setGender(gender);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public User updateUserAddress(Long userId, Long addressId, UserAddress updatedAddress) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        UserAddress address = userAddressRepository.findById(addressId).orElseThrow(() -> new EntityNotFoundException("Address not found"));

        // Update address fields
        address.setAddress(updatedAddress.getAddress());
        address.setCity(updatedAddress.getCity());
        address.setCountry(updatedAddress.getCountry());

        // Save updated address
        userAddressRepository.save(address);

        // Update user's address list
        List<UserAddress> addresses = user.getAddress();
        for (int i = 0; i < addresses.size(); i++) {
            if (addresses.get(i).getId().equals(addressId)) {
                addresses.set(i, address);
                break;
            }
        }

        // Save updated user
        user.setAddress(addresses);
        userRepository.save(user);

        return user;
    }


    @Override
    public User updatePassword(Long id, String password) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setPassword(password);
            return userRepository.save(user);
        }
        return null;
    }

//    @Override
//    public String login(UserLoginDTO userLoginDTO) {
//        try {
//            User user = userRepository.findByEmail(userLoginDTO.getEmail());
//            if (user != null) {
//                if (passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword())) {
//                    String token = jwtUtil.generateToken(user);
//                    return token;
//                } else {
//                    return "Invalid";
//                }
//            } else {
//                return "User Not Found";
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Error";
//        }
//    }

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email: "+ email));

        return user;
    }
}