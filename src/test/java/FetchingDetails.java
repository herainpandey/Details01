import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import pojo.PhoneNumbers;
import pojo.StudentDetail;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import static io.restassured.RestAssured.*;

public class FetchingDetails {
	
	
	public static void main(String Args[])
	{
	System.out.println("New Change");
    String[] expectedlist = {"iPhone", "home"};
	RestAssured.baseURI =  "http://localhost:3000";
	StudentDetail sd = given().expect().defaultParser(Parser.JSON)
	.when().get("/Details")
	.then().assertThat().statusCode(200).extract().as(StudentDetail.class);

	System.out.println(sd.getFirstName());
	System.out.println(sd.getAddress().getStreetAddress());
	
	List<PhoneNumbers> lpn  = sd.getPhoneNumbers();
	
	ArrayList<String> a = new ArrayList<String>();
	
	
	for (int i=0;i<lpn.size();i++)
	{
		//if (lpn.get(i).getType().equalsIgnoreCase(Types1[i]))
			//	{
			a.add(lpn.get(i).getType());
			//break;
				//}
	}
	List<String> b = Arrays.asList(expectedlist);
	
     Assert.assertTrue(a.equals(b));
      
	}
}
