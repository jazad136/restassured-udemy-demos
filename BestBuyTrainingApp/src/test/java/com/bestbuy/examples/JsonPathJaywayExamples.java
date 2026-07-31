/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bestbuy.examples;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.List;
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
    
    @DisplayName("Get all the data elements")
    @Test
    public void getAllDataElements() { 
        List<HashMap<String, Object>> dataElements = JsonPath.read(jsonResponse, "$.data");
        dataElements.stream().forEach(System.out::println);
    }
    
    @DisplayName("Get firstDataElement")
    @Test
    public void getFirstDataElement() { 
        Map<String,?> firstDataElement = JsonPath.read(jsonResponse, "$.data[0]");
        print(firstDataElement.toString());
    }
    @DisplayName("Get lastDataElement")
    @Test
    public void getLastDataElement() { 
        Map<String,?> firstDataElement = JsonPath.read(jsonResponse, "$.data[-1]");
        print(firstDataElement.toString());
    }
    
    @DisplayName("Get all ids in the data")
    @Test
    public void getAllIdsUnderData() { 
        List<String> dataElements = JsonPath.read(jsonResponse, "$.data[*].id");
        print(dataElements.toString());
    }
    
    @DisplayName("Get all ids in the data")
    @Test
    public void getAllIds() { 
        List<String> dataElements = JsonPath.read(jsonResponse, "$..id");
        print(dataElements.toString());
    }
    
    @DisplayName("Get the Name of the product whose price is less than 5")
    @Test
    public void getNameOfProductsWhosePriceIsLessThan5() { 
        List<String> names = JsonPath.read(jsonResponse, "$.data[?(@.price<5)].name");
        names.stream().forEach(System.out::println);
    }
    
        @DisplayName("Get the Names of the products whose price is less than 5")
    @Test
    public void getNameOfProductsWhosePriceIsGreaterThan5() { 
        List<String> names = JsonPath.read(jsonResponse, "$.data[?(@.price>5)].name");
        names.stream().forEach(System.out::println);
    }
//    public void 
}
