package stepdefinitions.apisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.Config;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.ConfigReader;

import java.io.ObjectInputFilter;
//import java.lang.runtime.SwitchBootstraps;
import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class APISteps {
    Response response;
    Map <String,String> data;

    @Given("User has baseurl and endpoint")
    public void user_has_baseurl_and_endpoint() {
        RestAssured.baseURI = ConfigReader.readProperty("base_url_api");
        RestAssured.basePath = ConfigReader.readProperty("customer_endpoint");
    }

    @When("User sends {string} request")
    public void user_sends_request(String requestType) {
        switch (requestType) {
            case "GET":
                response = RestAssured.given().header("authtoken", ConfigReader.readProperty("token"))
                        .when().get();

                break;
            case "POST":
                RestAssured.config = RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()
                        .encodeContentTypeAs("multipart/form-data", ContentType.TEXT ));
                RequestSpecification specification = given().header("authtoken", ConfigReader.readProperty("token"))
                        .contentType("multipart/form-data");

                for(Map.Entry<String,String> entry : data.entrySet()){
                    specification.multiPart(entry.getKey(),entry.getValue());

                }
                response=specification.when().post();
                break;
        }
    }

    @Then("User validates status code is {int}")
    public void user_validates_status_code_is(Integer int1) {
        response.then().statusCode(int1);

    }

    @Then("User validates number of values is {int}")
    public void user_validates_number_of_values_is(Integer count) {
        response.then().body("size()", is(count));

    }

    @Then("User validates user ids {string},{string},{string},{string},{string}")
    public void user_validates_user_ids(String id1, String id2, String id3, String id4, String id5) {
        List<String> userIds = response.jsonPath().getList("userid");
        Collections.sort(userIds);
        List<String> expectedUserIds = Arrays.asList(id1, id2, id3, id4, id5);
        Assert.assertTrue(userIds.containsAll(expectedUserIds));
    }

    @Then("User validates companies are ordered alphabetically")
    public void user_validates_response_is_ordered_by() {
        List<String> companies = response.jsonPath().getList("company");
        List<String> expectedCompanies = new ArrayList<>(companies);
        Collections.sort(expectedCompanies);
        Assert.assertEquals(companies, expectedCompanies);

    }

    @Given("user has {string} and {string}")
    public void user_has_and(String baseURI, String endpoint) {
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = endpoint;

    }

    @Then("verify response {string} is {string}")
    public void verify_response_is(String jsonPath, String expectedValue) {
        String actualValue = response.jsonPath().getString(jsonPath);
        Assert.assertEquals(actualValue, expectedValue);
    }

    @Then("That id is {string} and subject is {string}")
    public void that_id_is_and_subject_is(String id, String subject) {
        String actualId = response.jsonPath().getString("id");
        String actualSubject = response.jsonPath().getString("subject");
        Assert.assertEquals(id, actualId);
        Assert.assertEquals(subject, actualSubject);
    }

    @Then("There are {int} added items, {int} quantity of {string} and {int} quantity of {string}")
    public void there_are_added_items_quantity_of_and_quantity_of
            (int totalItems, int quantity1, String product1, int quantity2, String product2) {
        int actualTotal = response.jsonPath().getList("items").size();

        int actualQuantity1 =
                (int) response.jsonPath().getDouble("items.find {it.description == '" + product1 + "'}.qty");
        int actualQuantity2 =
                (int) response.jsonPath().getDouble("items.find {it.description == '" + product2 + "'}.qty");

        List<String> actualProducts = response.jsonPath().getList("items.description");
        Collections.sort(actualProducts);
        List<String> expectedProducts = Arrays.asList(product1, product2);
        Collections.sort(expectedProducts);

        Assert.assertEquals(totalItems, actualTotal);
        Assert.assertEquals(quantity1, actualQuantity1);
        Assert.assertEquals(quantity2, actualQuantity2);
        Assert.assertEquals(expectedProducts, actualProducts);
    }

    @Then("client company name is {string}")
    public void client_company_name_is(String company) {
        String actualCompany = response.jsonPath().getString("project_data.client_data.company");
        Assert.assertEquals(company, actualCompany);
    }

    @Given("Request has {string} data")
    public void request_has_data(String dataName) {
        switch(dataName){
            case "proposals":
                data=TestData.getProposalData();
                        break;

        }

    }

}