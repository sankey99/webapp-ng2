package com.cs.common.persistence.service.data;

import com.cs.common.IntegrationTestBase;
import com.cs.common.persistence.domain.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by sankey on 2017-05-14.
 */
public class CommonJpaDataAccessServiceTest extends IntegrationTestBase{

    User user;
    @BeforeMethod
    public void setUp() throws Exception {
        user=new User();
        user.setName("test");
        user.setEmail("test@email.com");
        user.setUserId("testid");
        user.setPassword("testpassword");

        commonJpaDataAccessService.create(user);
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }
    @Test
    public void findUSer(){
        User u= (User)commonJpaDataAccessService.find(User.class, this.user.getId());
        Assert.assertNotNull(u);
    }

}