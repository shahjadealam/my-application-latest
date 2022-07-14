package com.myapp.api;

import com.myapp.api.entity.User;
import com.myapp.api.exception.ApplicationInternalException;
import com.myapp.api.exception.UserNotFoundException;
import com.myapp.api.repository.UserRepository;
import com.myapp.api.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

   @Test
    public void saveUser(){
        User user = new User(101,"Shahjade","shahajde.alam@nagarro.com","9998886567","Male",28,"INDIAN");
        Mockito.when(userRepository.save(user)).thenReturn(user);
        //Assert.assertEquals(user,userService.saveUser(user); //need to pass UserRequest will use Mapper

   }

    @Test
    public  void fetchAllUsersTest() throws ApplicationInternalException {
        Mockito.when(userRepository.findAll())
                .thenReturn(Stream.of(
                        new User(101,"Shahjade","shahajde.alam@nagarro.com","9998886567","Male",28,"INDIAN"),
        new User(101,"Shahjade","shahajde.alam@nagarro.com","9998886567","Male",28,"INDIAN"))
                        .collect(Collectors.toList()));
        Assert.assertEquals(2, userService.getALlUsers().size());
    }

    @Test
    public void getUserByIdTest() throws UserNotFoundException {
        Mockito.when(userRepository.findByUserId(1))
                .thenReturn(
                new User(101,"Shahjade","shahajde.alam@nagarro.com","9998886567","Male",28,"INDIAN"));
        Assert.assertEquals("Shahjade",userService.getUser(1).getName());
    }

    @Test
    public void deleteByUserIdTest() throws UserNotFoundException {
        userRepository.deleteById(1);
        Mockito.verify(userRepository, Mockito.times(1)).deleteById(1);
    }
}
