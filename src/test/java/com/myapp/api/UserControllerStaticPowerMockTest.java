/*
package com.myapp.api;

import com.myapp.api.service.UserService;
import com.myapp.api.util.NotificationUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PowerMockIgnore("jdk.internal.reflect.*")
@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.myapp.api.*")
public class UserControllerStaticPowerMockTest {

    @InjectMocks
    private UserService userService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(NotificationUtil.class);
    }

    @Test
    public void testStaticMethod() {
        //given
        String email = "shahjade.alam@nagarro.com";
        Mockito.mockStatic(NotificationUtil.class);
        //when
        Mockito.when(NotificationUtil.sendEmail(email)).thenReturn("success");
        //then
        Assert.assertEquals("success", userService.getMailStatus(email));

    }

}
*/
