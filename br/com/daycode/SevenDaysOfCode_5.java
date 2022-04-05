/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.daycode;

import br.com.daycode.helper.HTMLGenerator;
import br.com.daycode.helper.ImdbApiClient;
import br.com.daycode.helper.ImdbMovieJsonParser;
import br.com.daycode.model.Movie;
import java.io.FileNotFoundException;
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
public class SevenDaysOfCode_5 {
    
    public static void main(String[] args) throws FileNotFoundException{
        String key = "<apiKey>";
        var body = new ImdbApiClient(key).getBody();
        
        List<Movie> movies = new ImdbMovieJsonParser(body).parse();
            
        PrintWriter printer;
        printer = new PrintWriter("content.html");
        HTMLGenerator html = new HTMLGenerator(printer);
        html.generate(movies);
        printer.close();
    }
}
