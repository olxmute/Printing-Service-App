package ua.nmu.printingservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.dto.UserDto;
import ua.nmu.printingservice.persistence.domain.User;
import ua.nmu.printingservice.persistence.domain.cart.Cart;
import ua.nmu.printingservice.persistence.domain.enums.UserRole;
import ua.nmu.printingservice.persistence.repository.CartRepository;
import ua.nmu.printingservice.persistence.repository.UserRepository;
import ua.nmu.printingservice.service.UserService;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CartRepository cartRepository;

    @Override
    @Transactional
    public void registerUser(UserDto userDto) {
        User user = User.builder()
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .userRole(UserRole.USER)
                .build();

        User savedUser = userRepository.save(user);

        Cart cart = new Cart();
        cart.setUser(savedUser);
        cartRepository.save(cart);
    }
}
