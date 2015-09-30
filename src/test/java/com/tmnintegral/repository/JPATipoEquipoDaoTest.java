package com.tmnintegral.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tmnintegral.domain.TipoEquipo;


public class JPATipoEquipoDaoTest {

    private ApplicationContext context;
    private TipoEquipoDao tipoEquipoDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        tipoEquipoDao = (TipoEquipoDao) context.getBean("tipoEquipoDao");
    }

    @Test
    public void testGetTipoEquipoById() {
    	TipoEquipo tipoEquipo = tipoEquipoDao.getTipoEquipo(1);
    	assertEquals(tipoEquipo.getId(), 1, 0);
    }

    @Test
    public void testGetTipoEquipoList() {
        List<TipoEquipo> tipoEquipos = tipoEquipoDao.getTipoEquiposList();
        assertEquals(tipoEquipos.size(), 2, 0);	   
    }
    
    @Test
    public void testSaveNewTipoEquipo() {
        TipoEquipo te = new TipoEquipo(999, "test", "ping", "1", "1", "1", "pepe");
        try {
			tipoEquipoDao.saveTipoEquipo(te);

			TipoEquipo tmpTipoEquipo = tipoEquipoDao.getTipoEquipo(999);
			assertNotNull(tmpTipoEquipo);
			assertEquals(tmpTipoEquipo.getId(), 999, 0);
			
			tipoEquipoDao.deleteTipoEquipo(te.getId());
		} catch (Exception e) {
			//te duplicado
			System.out.println(e.getMessage());
		}
    }

    @Test
    public void testUpdateTipoEquipo() {
        List<TipoEquipo> tipoEquipos = tipoEquipoDao.getTipoEquiposList();

        TipoEquipo te = tipoEquipos.get(0);
        te.setDefault_comm_read("pingggg");
        tipoEquipoDao.updateTipoEquipo(te);
    }
    
    @Test
    public void testDeleteTipoEquipoById() {
        tipoEquipoDao.deleteTipoEquipo(999);
        
        TipoEquipo te = tipoEquipoDao.getTipoEquipo(999);
        assertNull(te);
    }
}
