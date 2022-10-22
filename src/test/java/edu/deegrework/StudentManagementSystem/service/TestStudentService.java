package edu.deegrework.StudentManagementSystem.service;

import edu.deegrework.StudentManagementSystem.email.EmailSender;
import edu.deegrework.StudentManagementSystem.model.StudentEntity;
import edu.deegrework.StudentManagementSystem.repository.StudentRepository;
import edu.deegrework.StudentManagementSystem.repository.TeamRepository;
import edu.deegrework.StudentManagementSystem.repository.UserRepository;
import edu.deegrework.StudentManagementSystem.request.converter.StudentRequestConverter;
import edu.deegrework.StudentManagementSystem.response.StudentResponse;
import edu.deegrework.StudentManagementSystem.response.converter.StudentResponseConverter;
import edu.deegrework.StudentManagementSystem.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TestStudentService {

    @Mock
    private StudentRepository repository;
    @Mock
    private TeamRepository teamRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private StudentResponseConverter responseConverter;
    @Mock
    private StudentRequestConverter requestConverter;
    @Mock
    private EmailSender emailSender;
    @Mock
    private PasswordEncoder encoder;

    @InjectMocks
    private StudentServiceImpl service;

    @BeforeEach
    public void setUp() {
        System.out.println("beforeEach called");
        List list = new ArrayList<>();
        StudentEntity s = new StudentEntity();
        s.setFirstName("Test");
        s.setLastName("Test");
        list.add(s);
        Mockito.when(repository.findAll()).thenReturn(list);
    }

    @BeforeAll
    public static void before() {

    }

    @Test
    public void testGetStudents() {
        List<StudentResponse> students = service.getStudents();
        Assert.notEmpty(students, "students mustnt be null");
//        Assert.isTrue(students.get(0).getFirstname()=="Test", "FirstName must be Test");
    }
}
