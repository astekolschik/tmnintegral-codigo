/**
 * 
 */
package com.tmnintegral.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tmnintegral.repository.CommandDao;

/**
 * @author Agustina
 *
 */
public class ConfigurationManagerTests {
	
	private ApplicationContext context;
	private ConfigurationManager configurationManager;
	
    @Before
    public void setUp() throws Exception {
    	context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        configurationManager = new ConfigurationManager();
        configurationManager.setCommandDao((CommandDao) context.getBean("commandDao"));
    }


    @Test
    public void testObtenerComandos() {
    	assertNotNull(this.configurationManager.getCommandList());
    }
}
