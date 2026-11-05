/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.studentapp.allureexamples.app;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@Epic("Just an epic")
@Feature("Pass Feature")
public class EpicFeatureStoryTest {
    
    @DisplayName("I am just a test which will always pass")
    @Story("I am just a test which will always pass")
    @Test
    public void tc1() {
        assertTrue(true);
        CalculatorSteps steps = new CalculatorSteps();
        steps.writeText("This is important information");
    }
    
    @DisplayName("This is an image attachment example")
    @Story("This is an image attachment example")
    @Test
    public void tc2() throws IOException { 
        CalculatorSteps steps = new CalculatorSteps();
        String userDir = System.getProperty("user.dir");
        File resourcesDir = Paths.get(userDir, "src", "main","resources").toFile();
        BufferedImage bufferImage = ImageIO.read(new File(resourcesDir, "dancing_banana.png"));
        ByteArrayOutputStream byteArrOS = new ByteArrayOutputStream();
        ImageIO.write(bufferImage, "png", byteArrOS);
        byte[] data = byteArrOS.toByteArray();
        steps.attachImage(data);
    }
}
