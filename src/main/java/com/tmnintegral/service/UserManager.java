package com.tmnintegral.service;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tmnintegral.domain.Role;
import com.tmnintegral.domain.User;
import com.tmnintegral.repository.RoleDao;
import com.tmnintegral.repository.UserDao;

/**
 * Encargado del manejo de usuarios
 * @author Agustina
 * @version 1.0
 */
@Component
public class UserManager implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private RoleDao roleDao;
	@Autowired
	private UserDao userDao;
	
	
	/**
	 * 
	 * @param userId
	 * @param password
	 * @throws Exception 
	 */
	public User autenticarUsuario(String username, String password) throws Exception{
		User u = userDao.getUser(username);
		if (u != null){
			String loginPwd = this.generarPassword(username, password);
			if (loginPwd.equals(u.getPassword()))
				return u;
			else
				return null;
		}else{
			throw new Exception("Usuario inexistente");
		}
	}

	/**
	 * Crea un usuario a partir de los datos proporcionados
	 * @param userName
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param password
	 * @param roleId
	 * @throws Exception 
	 */
	public User crearUsuario(
				String userName,
				String nombre, String apellido, 
				String email, 
				String password, 
				int roleId) throws Exception{
		
		if (!existeUsuario(userName)){
		
			String encPwd = this.generarPassword(userName, password);
			Role r = roleDao.getRole(roleId);
			User u = new User(userName, encPwd, email, nombre, apellido, r);

			userDao.saveUser(u);
			
			return u;
		}else{
			throw new Exception("Usuario duplicado");
		}
	}

	/**
	 * 
	 * @param userId
	 */
	public void eliminarUsuario(String userId){
		this.userDao.deleteUser(userId);
	}

	public User getUser(String userId){
		User u = this.userDao.getUser(userId);
		return u;
	}

	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param username
	 * @param password
	 * @return
	 */
	public User modificarUsuario(String nombre, String apellido, String email, String username, String password){
		User u = this.getUser(username);
		if (u != null){
			if (!u.getName().equals(nombre))
				u.setName(nombre);
			if (!u.getLastName().equals(apellido))
				u.setLastName(apellido);
			if (!u.getEmail().equals(email))
				u.setEmail(email);
			String encPwd = this.generarPassword(username, password);
			if (!u.getPassword().equals(encPwd))
				u.setPassword(encPwd);
			
			this.userDao.updateUser(u);
		}
		
		return u;
	}
	
	/**
	 * 
	 * @param u
	 */
	public void updateUser(User u){
		this.userDao.updateUser(u);
	}
	
	/**
	 * Genera una nueva contraseņa para el usuario
	 * @param username
	 * @return
	 */
	public boolean resetearContrasena(String username){
		User u = this.getUser(username);
		if (u != null){
			String randomString = (UUID.randomUUID().toString()).replace("-", "");
			String newPass = this.generarPassword(username, randomString);
			
			u.setPassword(newPass);
			this.userDao.updateUser(u);
			MailManager.sendPasswordMail(u.getName(), u.getEmail(), 
					"TMN Integral - Nueva Contraseņa", 
					"Su nueva contraseņa es: " + randomString);
			return true;
		}

		return false;
	}

	/**
	 * Obtiene la lista de todos los usuarios
	 * @return lista de usuarios
	 */
	public List<User> getUserList(){
		return this.userDao.getUsersList();
	}
	
	/**
	 * Chequea la existencia de un username repetido
	 * @param username
	 * @return userduplicado
	 */
	private boolean existeUsuario(String username){
		if(userDao.getUser(username) != null)
			return true;
		return false;
	}
	
	private String generarPassword(String username, String password){
		return getStringMessageDigest(username + password);
	}
	
	private String getStringMessageDigest(String message){
	     byte[] digest = null;
	     byte[] buffer = message.getBytes();
	     try {
	         MessageDigest messageDigest = MessageDigest.getInstance("MD5");
	         messageDigest.reset();
	         messageDigest.update(buffer);
	         digest = messageDigest.digest();
	     } catch (NoSuchAlgorithmException ex) {
	         System.out.println("Error creando Digest");
	     }
	     return toHexadecimal(digest);
	 }
	
	private static String toHexadecimal(byte[] digest){
        String hash = "";
        for(byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }
        return hash;
    }
	
	/**
	 * @param roleDao the roleDao to set
	 */
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}