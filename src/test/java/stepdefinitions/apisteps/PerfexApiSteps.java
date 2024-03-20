package stepdefinitions.apisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.*;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class PerfexApiSteps {

    Response response;
    Map<String, String> data;

    @Given("I have base url {string} and endpoint {string}")
    public void i_have_base_url_and_endpoint(String baseURI, String endpoint) {

        RestAssured.baseURI=baseURI;
        RestAssured.basePath=endpoint;

    }


    @Given("the request has {string} data")
    public void the_request_has_data(String dataName) {
        switch(dataName){
            case "proposals":
                data=new TestData().getProposalData();
                break;
            case "proposalsNegative":
                data=new TestData().getProposalNegData();
                break;
        }
    }

    @When("the user send the {string} request")
    public void the_user_send_the_request(String requestType) {

        switch (requestType){
            case "GET":
                response=given().header("authtoken", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoibWlrZS1hcGkiLCJuYW1lIjoiTWlrZSBUZWNodG9yaWFsIiwiQVBJX1RJTUUiOjE3MTAwNjE0ODB9.16BVdzs3Ssxf3yurelqxe2v754sTkiUPJAzFYibVHoc").when().get();
                System.out.println(response.toString());
                break;
            case "POST":
                RestAssured.config = RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT));

                RequestSpecification specification =given()
                        .header("authtoken", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoibWlrZS1hcGkiLCJuYW1lIjoiTWlrZSBUZWNodG9yaWFsIiwiQVBJX1RJTUUiOjE3MTAwNjE0ODB9.16BVdzs3Ssxf3yurelqxe2v754sTkiUPJAzFYibVHoc")
                        .contentType("multipart/form-data");

                for(Map.Entry<String, String> entry: data.entrySet()){

                    specification.multiPart(entry.getKey(), entry.getValue());

                }

                response=specification.when().post();

                //System.out.println(response.prettyPrint());

                break;
        }

    }
    @Then("verify status code {int}")
    public void verify_status_code(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("verify number of values {int}")
    public void verify_number_of_values(Integer count) {

        response.then().body("size()", is(count));

    }
    @Then("verify response {string} is {string}")
    public void verify_response_is(String jsonPath, String expectedValue) {
        String actualValue=response.jsonPath().getString(jsonPath);
        // what is the json path that i need to provide to get the customer company name for ikea llc.
        Assert.assertEquals(actualValue, expectedValue);
    }
    @Then("verify api response is ordered by {string}")
    public void verify_api_response_is_ordered_by(String keyName) {
        List<String> names=response.jsonPath().getList(keyName);

    }
}
