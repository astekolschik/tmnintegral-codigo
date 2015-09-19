package com.tmnintegral.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tmnintegral.domain.Role;
import com.tmnintegral.domain.User;


public class JPAUserDaoTest {

    private ApplicationContext context;
    private UserDao userDao;
    private RoleDao	roleDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        userDao = (UserDao) context.getBean("userDao");
        roleDao = (RoleDao) context.getBean("roleDao");
    }

    @Test
    public void testGetUserById() {
    	User user = userDao.getUser(1);
    	assertEquals(user.getId(), 1, 0);
    }

    @Test
    public void testGetUserByName() {
    	User user = userDao.getUser("ADMIN");
    	assertEquals(user.getId(), 1, 0);
    }
    
    @Test
    public void testGetUserList() {
        List<User> users = userDao.getUsersList();
        assertEquals(users.size(), 1, 0);	   
    }
    
    @Test
    public void testSaveNewUser() {
        Role r = roleDao.getRole(2);
    	User u = new User("TEST", "1234", "test@tmn.com", "test", "test", r);
        try {
			userDao.saveUser(u);
			
			User tmpUser = userDao.getUser("TEST");
			assertNotNull(tmpUser);
			
			userDao.deleteUser(u.getId());
		} catch (Exception e) {
			//rol duplicado
			System.out.println(e.getMessage());
		}
        
    	
    }

    @Test
    public void testUpdateUser() {
        List<User> users = userDao.getUsersList();

        User u = users.get(0);
        u.setName("ADMIN");
        userDao.updateUser(u);
    }
    
    @Test
    public void testDeleteUserById() {
        userDao.deleteUser(999);
        
        User u = userDao.getUser(999);
        assertNull(u);
    }
}
