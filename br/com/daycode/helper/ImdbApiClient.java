/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.daycode.helper;

import br.com.daycode.SevenDaysOfCode_3;
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
public class ImdbApiClient {
    private final String key;
    
    public ImdbApiClient(String key){
        this.key = key;
    }
    
    public String getBody(){
        // create a client
        var client = HttpClient.newHttpClient();
        
        var request = HttpRequest.newBuilder(
            URI.create("https://imdb-api.com/en/API/Top250Movies/" + this.key))
                .header("accept", "application/json")
                .build();

        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            // the response:
            String body = response.body();
            return body;
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(SevenDaysOfCode_3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
