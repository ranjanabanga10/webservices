import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import java.net.URI;
import java.net.URISyntaxException;

import io.restassured.RestAssured;


public class TC001_getCars_request 
{
	private static final int PORT=9000;
	private static final String HOST="localhost";
	private static WireMockServer server= new WireMockServer(PORT);
	@BeforeClass
	public static void setup() {
		server.start();
		
		ResponseDefinitionBuilder mockResponse=new ResponseDefinitionBuilder();
		mockResponse.withStatus(200);
		WireMock.configureFor(HOST, PORT);//http://localhost:9000
		WireMock.stubFor(
				WireMock.get("/api/users")
				.willReturn(mockResponse)
				);
	}
	@Test
	void getCarsDetails() throws URISyntaxException 
	{

		
		RestAssured.given()
		.when()
		.get(new URI("http://localhost:9000/api/users"))
		.then()
		.assertThat()
		.statusCode(200);
		
		
	}
	@AfterClass
	public static void teardown() {
		if(null != server && server.isRunning()) {
			server.shutdown();
		}
	}
}
