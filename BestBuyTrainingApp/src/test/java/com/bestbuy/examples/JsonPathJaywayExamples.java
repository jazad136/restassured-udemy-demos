/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bestbuy.examples;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

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
}
