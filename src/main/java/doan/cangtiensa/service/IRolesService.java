/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */

package doan.cangtiensa.service;

import java.util.List;

import doan.cangtiensa.entity.Roles;

public interface IRolesService {
	public List<Roles> getListRoles();

	public Roles getRoleById(int id);

	public void addOrEditMovie(Roles roles);

	public void deleteMovie(int id);


}
