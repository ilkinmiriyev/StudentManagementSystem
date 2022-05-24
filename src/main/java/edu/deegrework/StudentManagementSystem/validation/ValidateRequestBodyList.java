package edu.deegrework.StudentManagementSystem.validation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class ValidateRequestBodyList<T> {
    @Valid
    List<T> requestBody;
}
