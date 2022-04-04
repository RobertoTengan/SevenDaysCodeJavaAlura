/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.daycode;

import br.com.daycode.helper.HTMLGenerator;
import br.com.daycode.model.Movie;
import java.io.IOException;
import java.io.PrintWriter;
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
public class SevenDaysOfCode_4 {
    
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
            List<Movie> movies = parseMovies(body);
            
            PrintWriter printer;
            printer = new PrintWriter("listMovies.html");
            HTMLGenerator html = new HTMLGenerator(printer);
            html.generate(movies);
            printer.close();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(SevenDaysOfCode_3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Movie> parseMovies(String jsonMovies) {
        List<Movie> movies = new ArrayList<>();
        
        jsonMovies = jsonMovies.replace("{\"items\":[{", "").replace("}]", "");
        String[] arrMovies = jsonMovies.split("\\},\\{");
        
        for (String arrMovie : arrMovies) {
            String[] attribute = arrMovie.split("\",\"");
            
            var titulo = attribute[2].split("\":\"")[1].replace("\"", "");
            var urlImage = attribute[5].split("\":\"")[1].replace("\"", "");
            var rating = Double.parseDouble(attribute[7].split("\":\"")[1].replace("\"", ""));
            var year = Integer.parseInt(attribute[4].split("\":\"")[1].replace("\"", ""));
            
            movies.add(new Movie(titulo, urlImage, rating, year));
        }        
        
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
