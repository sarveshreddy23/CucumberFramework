package com.dkstalis.steps;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import javax.net.ssl.SSLException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Comparator {

    FileInputStream inputStreamFileA = null, inputStreamFileB = null;
    Scanner scannerFileA = null, scannerFileB = null;
    String urlFileA = null, urlFileB = null;
    String responseFileA = null, responseFileB = null;

    @Test
    public void compareFiles() throws IOException{

        try {
            inputStreamFileA = new FileInputStream(System.getProperty("user.dir")+"/src/test/resource/Files/FileA.txt");
            inputStreamFileB = new FileInputStream(System.getProperty("user.dir")+"/src/test/resource/Files/FileB.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            scannerFileA = new Scanner(inputStreamFileA);
            scannerFileB = new Scanner(inputStreamFileB);

            RestAssured.useRelaxedHTTPSValidation();
            Response response;
            for (int i = 0; ; i++) {
                if(!scannerFileA.hasNext() || !scannerFileB.hasNext()){
                    System.out.println("END OF FILE reqhed.");
                    break;
                }

                System.out.println("iteration: " + i);
                urlFileA = scannerFileA.nextLine();
                urlFileB = scannerFileB.nextLine();
                if (scannerFileA.ioException() != null) {
                    throw scannerFileA.ioException();
                }
                if (scannerFileB.ioException() != null) {
                    throw scannerFileB.ioException();
                }

                try{
                    response = given().get(urlFileA);

                    if(response.getStatusCode()==200)
                        responseFileA = response.getBody().asString();
                    else responseFileA = "invalid response from File A";
                    System.out.println("Response File A"+responseFileA);

                    response = given().get(urlFileB);

                    if(response.getStatusCode()==200)
                        responseFileB = response.getBody().asString();
                    else responseFileB = "invalid response from File B";
                    System.out.println("Response File B"+responseFileB);

                    if (responseFileA.equals(responseFileB))
                        System.out.println(urlFileA + " equals " + urlFileB);
                    else
                        System.out.println(urlFileA + " not equals " + urlFileB);

                } catch (Exception e){ }

            }
        } finally {
            if (inputStreamFileA != null) {
                inputStreamFileA.close();
            }
            if (scannerFileA != null) {
                scannerFileA.close();
            }
            if (inputStreamFileB != null) {
                inputStreamFileB.close();
            }
            if (scannerFileB != null) {
                scannerFileB.close();
            }

        }

    }




}
