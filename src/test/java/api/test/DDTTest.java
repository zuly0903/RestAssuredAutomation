package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTTest {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostuser(String userID, String userName, String fname, String lname, String uemail, String pwd, String ph)
	{
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstname(fname);
		userPayload.setLastname(lname);
		userPayload.setEmail(uemail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response rp = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(rp.getStatusCode(), 200);
	}
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String uname) 
	{
		Response rp = UserEndPoints.deleteUser(uname);
		Assert.assertEquals(rp.getStatusCode(), 200);

	}
}
