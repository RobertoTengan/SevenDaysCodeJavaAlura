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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roberto Tengan
 */
public class SevenDaysOfCode_2 {
    
    public static void main(String[] args){
        // create a client
        var client = HttpClient.newHttpClient();

        String key = "<apiKey>";
        // create a request
        var request = HttpRequest.newBuilder(
            URI.create("https://imdb-api.com/en/API/Top250Movies/" + key))
                .header("accept", "application/json")
                .build();

        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            // the response:
            String body = response.body();
            String[] movies = parseMovies(body);
            
            System.out.println("*** Titles ***");
            List<String> titles = parseAttribute(movies, 2);
            titles.forEach(System.out::println);
            
            System.out.println("*** URLImages ***");
            List<String> urlImages = parseAttribute(movies, 5);
            urlImages.forEach(System.out::println);
            
            System.out.println("*** Ids ***");
            List<String> ids = parseAttribute(movies, 0);
            ids.forEach(System.out::println);
            
            System.out.println("*** Ranks ***");
            List<String> ranks = parseAttribute(movies, 1);
            ranks.forEach(System.out::println);
            
            System.out.println("*** FullTitles ***");
            List<String> fullTitles = parseAttribute(movies, 3);
            fullTitles.forEach(System.out::println);
            
            System.out.println("*** Years ***");
            List<String> years = parseAttribute(movies, 4);
            years.forEach(System.out::println);
            
            System.out.println("*** Crews ***");
            List<String> crews = parseAttribute(movies, 6);
            crews.forEach(System.out::println);
            
            System.out.println("*** IMDBRatings ***");
            List<String> imdbRatings = parseAttribute(movies, 7);
            imdbRatings.forEach(System.out::println);
            
            System.out.println("*** IMDBRatingCount ***");
            List<String> imdbRatingCount = parseAttribute(movies, 8);
            imdbRatingCount.forEach(System.out::println);

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(SevenDaysOfCode_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String[] parseMovies(String jsonMovies) {
        jsonMovies = jsonMovies.replace("{\"items\":[{", "").replace("}]", "");
           
        String[] movies = jsonMovies.split("\\},\\{");
        return movies;
    }
    
    private static List<String> parseAttribute(String[] movies, int attrIndex) {
        List<String> attributes = new ArrayList<>();
        
        for (String movie : movies) {
            String[] attribute = movie.split("\",\"");
            attributes.add(attribute[attrIndex].split("\":\"")[1].replace("\"", ""));
        }
        
        return attributes;
    }
}
