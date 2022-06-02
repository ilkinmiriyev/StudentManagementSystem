package edu.deegrework.StudentManagementSystem.response.converter;

import edu.deegrework.StudentManagementSystem.response.CustomUserDetailsResponse;
import edu.deegrework.StudentManagementSystem.security.CustomUserDetails;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CustomUserDetailsResponseConverter implements Function<CustomUserDetails, CustomUserDetailsResponse> {

    @Override
    public CustomUserDetailsResponse apply(CustomUserDetails user) {
        return CustomUserDetailsResponse.builder()
                .id(user.getId())
                .role(user.getRole())
                .build();
    }
}
