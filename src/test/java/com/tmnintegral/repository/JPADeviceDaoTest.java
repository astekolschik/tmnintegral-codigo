package com.tmnintegral.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tmnintegral.domain.Device;
import com.tmnintegral.domain.TipoEquipo;


public class JPADeviceDaoTest {

    private ApplicationContext context;
    private DeviceDao deviceDao;
    private TipoEquipoDao tipoEquipoDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        deviceDao = (DeviceDao) context.getBean("deviceDao");
    }

    @Test
    public void testGetRoleById() {
    	Device device = deviceDao.getDevice(1);
    	assertEquals(device.getDevice_id(), 1, 0);
    }

    @Test
    public void testGetDeviceList() {
        List<Device> device = deviceDao.getDeviceList();
        assertEquals(device.size(), 2, 0);	   
    }
    
    @Test
    public void testSaveNewDevice() {
    	TipoEquipo te = tipoEquipoDao.getTipoEquipo(1);
        Device d = new Device();//"TEST", "TEST", "TEST","TEST","TEST","TEST","TEST","TEST", te, null, null, true);
        try {
			deviceDao.saveDevice(d);
			
			Device tmpdevice = deviceDao.getDevice(999);
			assertNotNull(tmpdevice);
			assertEquals(tmpdevice.getDevice_id(), 999, 0);
			
			deviceDao.deleteDevice(d.getDevice_id());
		} catch (Exception e) {
			//device duplicado
			System.out.println(e.getMessage());
		}
        
    	
    }

    @Test
    public void testUpdateDevice() {
        List<Device> device = deviceDao.getDeviceList();

        Device d = device.get(0);
        d.setHostName("ADMIN");
        deviceDao.updateDevice(d);
    }
    
    @Test
    public void testDeleteDeviceById() {
        deviceDao.deleteDevice(999);
        
        Device d = deviceDao.getDevice(999);
        assertNull(d);
    }
}
