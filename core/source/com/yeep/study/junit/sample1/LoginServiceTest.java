package com.yeep.study.junit.sample1;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.easymock.classextension.EasyMock.createMock;
import junit.framework.TestCase;

public class LoginServiceTest extends TestCase
{

	private LoginServiceImpl service;
	private UserDao mockDao;

	/**
	* setUp overrides the default, empty implementation provided by
	* JUnit's TestCase.  We will use it to instantiate our required
	* objects so that we get a clean copy for each test.
	*/
	@Override
	public void setUp()
	{
		service = new LoginServiceImpl();
		mockDao = createMock(UserDao.class);
		service.setUserDao(mockDao);
	}

	/**
	 * This method will test the "rosy" scenario of passing a valid
	 * username and password and retrieveing the user.  Once the user
	 * is returned to the service, the service will return true to
	 * the caller.
	 */
	public void testRosyScenario()
	{
		User results = new User();
		String userName = "testUserName";
		String password = "testPassword";
		expect(mockDao.loadByUsernameAndPassword(userName, password)).andReturn(results);

		// Tells EasyMock "We're done declaring our expectations. It's now time to run what we told you"
		replay(mockDao);
		
		assertTrue(service.login(userName, password));

		//Tells EasyMock to validate that all of the expected method calls were executed and in the correct order. 
		verify(mockDao);
	}
}
