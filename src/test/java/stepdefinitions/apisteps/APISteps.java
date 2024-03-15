package stepdefinitions.apisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.ConfigReader;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class APISteps {
    Response response;
    @Given("User has baseurl and endpoint")
    public void user_has_baseurl_and_endpoint() {
        RestAssured.baseURI= ConfigReader.readProperty("base_url_api");
        RestAssured.basePath=ConfigReader.readProperty("customer_endpoint");
    }
    @When("User sends {string} request")
    public void user_sends_request(String requestType) {
        switch(requestType){
            case "GET":
                response=RestAssured.given().header("authtoken",ConfigReader.readProperty("token"))
                        .when().get();
                break;
        }
    }
    @Then("User validates status code is {int}")
    public void user_validates_status_code_is(Integer int1) {
        response.then().statusCode(int1);

    }
    @Then("User validates number of values is {int}")
    public void user_validates_number_of_values_is(Integer count) {
        response.then().body("size()",is(count));

    }
    @Then("User validates user ids {string},{string},{string},{string},{string}")
    public void user_validates_user_ids(String id1, String id2, String id3, String id4, String id5) {
    List<String> userIds = response.jsonPath().getList("userid");
        Collections.sort(userIds);
    List<String> expectedUserIds = Arrays.asList(id1,id2,id3,id4,id5);
        Assert.assertTrue(userIds.containsAll(expectedUserIds));
    }
    @Then("User validates companies are ordered alphabetically")
    public void user_validates_response_is_ordered_by() {
        List<String> companies = response.jsonPath().getList("company");
        List<String> expectedCompanies = new ArrayList<>(companies);
        Collections.sort(expectedCompanies);
        Assert.assertEquals(companies,expectedCompanies);
    }
}
