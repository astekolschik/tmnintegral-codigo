package com.tmnintegral.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tmnintegral.domain.Command;


public class JPACommandDaoTest {

    private ApplicationContext context;
    private CommandDao commandDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        commandDao = (CommandDao) context.getBean("commandDao");
    }

    @Test
    public void testGetCommandById() {
    	Command Command = commandDao.getCommand(1);
    	assertEquals(Command.getId_command(), 1, 0);
    }

    @Test
    public void testGetCommandList() {
        List<Command> Commands = commandDao.getCommandList();
        assertEquals(Commands.size(), 3, 0);	   
    }
    
    @Test
    public void testSaveNewCommand() {
        Command te = new Command(999, "test", "test");
        try {
			te = commandDao.saveCommand(te);

			Command tmpCommand = commandDao.getCommand(te.getId_command());
			assertNotNull(tmpCommand);
			
			commandDao.deleteCommand(te.getId_command());
		} catch (Exception e) {
			//te duplicado
			System.out.println(e.getMessage());
		}
    }

    @Test
    public void testUpdateCommand() {
        List<Command> Commands = commandDao.getCommandList();

        Command te = Commands.get(0);
        te.setCommand_type("pingggg");
        commandDao.updateCommand(te);
    }
    
    @Test
    public void testDeleteCommandById() {
        commandDao.deleteCommand(999);
        
        Command te = commandDao.getCommand(999);
        assertNull(te);
    }
}
