package com.brightminds.repository;

import com.brightminds.model.Admin;
import com.brightminds.model.User;

public interface AdminRepository extends Base<Admin> {

	public Admin getByUserId(User userId);

}
