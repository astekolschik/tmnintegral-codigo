package com.caece.tmnintegral.dao;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.caece.tmnintegral.repository.Role;


public class JPARoleDaoTest {

    private ApplicationContext context;
    private RoleDao roleDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        roleDao = (RoleDao) context.getBean("roleDao");
    }

    @Test
    public void testGetRoleById() {
    	Role role = roleDao.getRole(1);
    	assertEquals(role.getRole_id(), 1, 0);
    }

    @Test
    public void testGetRolesList() {
        List<Role> roles = roleDao.getRoles();
        assertEquals(roles.size(), 2, 0);	   
    }
    
    @Test
    public void testSaveNewRole() {
        Role r = new Role(999, "TEST", true, true, true, true);
        try {
			roleDao.saveRole(r);
			
			Role tmprole = roleDao.getRole(999);
			assertNotNull(tmprole);
			assertEquals(tmprole.getRole_id(), 999, 0);
			
			roleDao.deleteRole(r.getRole_id());
		} catch (Exception e) {
			//rol duplicado
			System.out.println(e.getMessage());
		}
        
    	
    }

    @Test
    public void testUpdateRole() {
        List<Role> roles = roleDao.getRoles();

        Role r = roles.get(0);
        r.setName("ADMIN");
        roleDao.updateRole(r);
    }
    
    @Test
    public void testDeleteRoleById() {
        roleDao.deleteRole(999);
        
        Role r = roleDao.getRole(999);
        assertNull(r);
    }
}
