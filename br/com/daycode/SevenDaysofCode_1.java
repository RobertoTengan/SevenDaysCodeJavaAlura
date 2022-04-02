/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.daycode;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roberto Tengan
 */
public class SevenDaysofCode_1 {
    
    public static void main(String[] args){
        // create a client
        var client = HttpClient.newHttpClient();

        // create a request
        var request = HttpRequest.newBuilder(
            URI.create("https://imdb-api.com/en/API/Top250Movies/<apiKey>"))
                .header("accept", "application/json")
                .build();

        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // the response:
            System.out.println(response.body());
        } catch (IOException ex) {
            Logger.getLogger(SevenDaysofCode_1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(SevenDaysofCode_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
