package com.yeep.study.junit.sample1;

/**
* Provides database access for login related functions
*/
public interface UserDao
{

	/**
	* Loads a User object for the record that
	* is returned with the same userName and password.
	* 
	* @parameter userName
	* @parameter password
	* @return    User
	*/
	User loadByUsernameAndPassword(String userName, String password);
}
