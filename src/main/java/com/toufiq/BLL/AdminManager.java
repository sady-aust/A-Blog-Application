package com.toufiq.BLL;

import com.toufiq.DAL.AdminGetway;
import com.toufiq.Model.Admin;

public class AdminManager {
	AdminGetway myAdminGetway = new AdminGetway();
	
	public Admin getAdmin(Admin admin) {
		return myAdminGetway.getAdmin(admin);
	}

}
