/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.daycode.helper;

import br.com.daycode.model.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberto Tengan
 */
public class ImdbMovieJsonParser {
    
    private String JSONbody;
    
    public ImdbMovieJsonParser(String JSONbody){
        this.JSONbody = JSONbody;
    }
    
    public List<Movie> parse(){
        List<Movie> movies = new ArrayList<>();
        
        this.JSONbody = this.JSONbody.replace("{\"items\":[{", "").replace("}]", "");
        String[] arrMovies = this.JSONbody.split("\\},\\{");
        
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
}
