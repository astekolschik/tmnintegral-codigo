/**
 * 
 */
package com.tmnintegral.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tmnintegral.domain.User;
import com.tmnintegral.repository.RoleDao;
import com.tmnintegral.repository.UserDao;

/**
 * @author Agustina
 *
 */
public class UserManagerTests {
	
	private ApplicationContext context;
	private UserManager userManager;
	
    @Before
    public void setUp() throws Exception {
    	context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        userManager = new UserManager();
        userManager.setRoleDao((RoleDao) context.getBean("roleDao"));
        userManager.setUserDao((UserDao) context.getBean("userDao"));
    }

    @Test
    public void testCreateUser() {
    	User u = null;
		try {
			u = this.userManager.crearUsuario("agussteko", "Agustina", "Stekolschik", "agussteko@gmail.com",
						"123456", 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	assertNotNull(u);
    }

    @Test
    public void testAutenticarUser() {
    	boolean u = false;
		try {
			u = this.userManager.autenticarUsuario("agussteko", "123456");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	assertTrue(u);
    }
}
