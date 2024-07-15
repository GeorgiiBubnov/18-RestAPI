package api;

import models.CredentialsModel;
import models.LoginResponseModel;

import static data.BaseUri.BaseURIs.loginURI;
import static data.UserData.PASSWORD;
import static data.UserData.USERNAME;
import static io.restassured.RestAssured.given;
import static specs.DemoQaSpec.requestSpec;
import static specs.DemoQaSpec.responseSpecWithStatusCode200;

public class AuthorizationApi {

     public static LoginResponseModel login(){
          CredentialsModel credentialsModel = new CredentialsModel();
          credentialsModel.setUserName(USERNAME);
          credentialsModel.setPassword(PASSWORD);

          return
                  given(requestSpec)
                          .body(credentialsModel)
                          .when()
                          .post(loginURI)
                          .then()
                          .spec(responseSpecWithStatusCode200)
                          .extract().as(LoginResponseModel.class);
     }
}


