/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bestbuy.examples;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JonathanSaddler
 */
public class JsonPathJaywayExamples {
    static String jsonResponse;
    
    @BeforeAll
    public static void initialize() { 
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        jsonResponse = given().when().get("/products").asString();
    }
    @BeforeEach
    void printToConsole() {
        System.out.println("-----Starting the test method-----");
        System.out.println("     ");
    }
    void printToConsoleAgain() { 
        System.out.println("-----Ending the test method-----");
        System.out.println("     ");
    }
    static void print(String print) {
        System.out.println(print);
    }
    @DisplayName("Get the root element")
    @Test
    public void getRoot() {
        Map<String, ?> rootElement = JsonPath.read(jsonResponse, "$");
        print(rootElement.toString());
    }

    @DisplayName("Get the total value from the response")
    @Test
    public void getTotalFromResponse() {
        int totalValue = JsonPath.read(jsonResponse, "$.total");
        print(totalValue + "");
    }

}
