package com.yeep.study.junit.sample1;


public class LoginServiceImpl implements LoginService
{

	private UserDao userDao;

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

	@Override
	public boolean login(String userName, String password)
	{
		boolean valid = false;

		User results = userDao.loadByUsernameAndPassword(userName, password);
		if (results != null)
		{
			valid = true;
		}

		return valid;
	}
}
