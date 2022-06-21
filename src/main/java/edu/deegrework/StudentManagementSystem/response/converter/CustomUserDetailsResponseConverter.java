package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.response.CustomUserDetailsResponse;
import edu.deegrework.StudentManagementSystem.model.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CustomUserDetailsResponseConverter implements Function<User, CustomUserDetailsResponse> {

    @Override
    public CustomUserDetailsResponse apply(User user) {
        return CustomUserDetailsResponse.builder()
                .id(user.getId())
                .role(user.getRole())
                .build();
    }
}
