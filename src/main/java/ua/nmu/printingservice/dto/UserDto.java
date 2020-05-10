package ua.nmu.printingservice.dto;

import lombok.Data;
import ua.nmu.printingservice.validation.UniqueEmail;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    @Size(min = 3, message = "minimum 3 characters")
    private String firstName;

    @Size(min = 3, message = "minimum 3 characters")
    private String lastName;

    @UniqueEmail
    @Pattern(
            regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
            message = "invalid email"
    )
    private String email;

    @Pattern(
            regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$",
            message = """
                    password must contain:
                    minimum 8 characters;
                    at least 1 capital letter;
                    at least 1 small letter;
                    """
    )
    private String password;

}
