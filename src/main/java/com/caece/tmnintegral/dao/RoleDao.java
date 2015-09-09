package com.caece.tmnintegral.dao;

import java.util.List;

import javax.persistence.NoResultException;

import com.caece.tmnintegral.repository.Role;

/**
 * @author Agustina
 *
 */
public interface RoleDao {

	public Role getRole(int roleId) throws NoResultException;
	
	public List<Role> getRoles();
	
	public void saveRole(Role r) throws Exception;
	
	public void updateRole(Role r);
	
	public void deleteRole(Role r);
	
	public void deleteRole(int roleId);
	
}
