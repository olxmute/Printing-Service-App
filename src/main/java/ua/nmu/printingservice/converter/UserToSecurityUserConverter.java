package ua.nmu.printingservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import ua.nmu.printingservice.persistence.domain.User;
import ua.nmu.printingservice.persistence.domain.enums.UserRole;
import ua.nmu.printingservice.security.model.SecurityUser;

import java.util.List;

@Component
public class UserToSecurityUserConverter implements Converter<User, SecurityUser> {
    @Override
    public SecurityUser convert(User user) {
        return SecurityUser.builder()
                .id(user.getId())
                .password(user.getPassword())
                .username(user.getEmail()) // email is username for Spring
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .authorities(List.of(new SimpleGrantedAuthority(user.getUserRole().name())))
                .admin(user.getUserRole() == UserRole.ADMIN)
                .build();
    }
}
