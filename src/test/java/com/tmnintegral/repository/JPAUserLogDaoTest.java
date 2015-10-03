package com.tmnintegral.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tmnintegral.domain.Role;
import com.tmnintegral.domain.UserLog;


public class JPAUserLogDaoTest {

    private ApplicationContext context;
    private UserLogDao userLogDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        userLogDao = (UserLogDao) context.getBean("userLogDao");
    }

    @Test
    public void testGetLogs() {
    	List<UserLog> ul = userLogDao.getAllUserLogs();
    	assertNotNull(ul);
    }
    
    @Test
    public void testGetLogsByUser() {
    	List<UserLog> ul = userLogDao.getUserLogs(1);
    	assertNotNull(ul);
    }
    
    @Test
    public void testSaveUserLog() {
    	UserLog ul = new UserLog(1, "test log", new Date());
    	try {
			this.userLogDao.saveUserLog(ul);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
    	List<UserLog> uls = userLogDao.getUserLogs(1);
    	assertEquals((uls.get(0)).getUser(), 1, 0);
    }
}
