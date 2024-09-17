package tests;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload.User;
import utilities.DataProviders;

public class UserTestsMultiUsers {

    @Test(priority = 1 , dataProvider = "Data" , dataProviderClass = DataProviders.class)
    public void testPostUser(String id ,String username , String firstName , String lastName , String email , String password , String phone ){
        User userPayLoad = new User();
        userPayLoad.setId(Integer.parseInt(id));
        userPayLoad.setUsername(username);
        userPayLoad.setFirstName(firstName);
        userPayLoad.setLastName(lastName);
        userPayLoad.setEmail(email);
        userPayLoad.setPassword(password);
        userPayLoad.setPhone(phone);
        Response response = UserEndPoints.createUser(userPayLoad);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
