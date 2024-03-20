package stepdefinitions.apisteps;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Test {

            public static void main(String[] args) {
                RestAssured.baseURI = "https://techtorialperfex.com/perfexcrm/api";

                var response = given()
                        .header("authtoken", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoibWlrZS1hcGkiLCJuYW1lIjoiTWlrZSBUZWNodG9yaWFsIiwiQVBJX1RJTUUiOjE3MTAwNjE0ODB9.16BVdzs3Ssxf3yurelqxe2v754sTkiUPJAzFYibVHoc")
                        .contentType("multipart/form-data") // Setting the content type as multipart/form-data
                        .multiPart("subject", "David_Proposal_Test_TC6")
                        .multiPart("rel_type", "customer")
                        .multiPart("rel_id", "3")
                        .multiPart("proposal_to", "Customer05 Techtorial")
                        .multiPart("email", "customer05-techtorial@techtorialperfex.com")
                        .multiPart("currency", "1")
                        .multiPart("date", "2024-03-10")
                        .multiPart("status", "6")
                        .multiPart("newitems[0][description]", "item 1 description")
                        .multiPart("newitems[0][long_description]", "item 1 long description")
                        .multiPart("newitems[0][qty]", "2")
                        .multiPart("newitems[0][rate]", "10.00")
                        .multiPart("newitems[0][order]", "1")
                        .multiPart("newitems[0][unit]", "100")
                        .multiPart("subtotal", "420.00")
                        .multiPart("total", "441.00")
                        .multiPart("total_tax", "21.0")
                        .when()
                        .post("/proposals")
                        .then()
                        .extract()
                        .response();

                // Output the response details for verification
                System.out.println("Status Code: " + response.getStatusCode());
                System.out.println("Response Body: " + response.asString());
            }
        }


