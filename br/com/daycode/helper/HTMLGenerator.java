/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.daycode.helper;

import br.com.daycode.model.Movie;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Roberto Tengan
 */
public class HTMLGenerator {
    
    private final String head = "<!DOCTYPE html>"
                                + "<html>"
                                    + "<head>"
                                    + "    <meta charset=\"utf-8\">"
                                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"
                                    + "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" "
                                                + "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">"					
                                    + "</head>"
                                    + "<body>";



    private final String divTemplate = "<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">"
	+ "<h4 class=\"card-header\">%s</h4>"
	+ "<div class=\"card-body\">"
	+ "	<img class=\"card-img\" src=\"%s\" alt=\"%s\">"
		+ "<p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>"
	+ "</div>"
        + "</div>";
    
    private final String tail = "</body>"
                                +"</html>";
    
    private final PrintWriter printer;

    public HTMLGenerator(PrintWriter printer){
        this.printer = printer;
    }
    
    public void generate(List<Movie> movies){
        this.generateHead();
        this.generateBody(movies);
        this.generateTail();
    }
    
    private void generateHead(){
        printer.println(this.head);
    }
    
    private void generateBody(List<Movie> movies){
        movies.forEach(movie -> printer.printf(this.divTemplate, movie.getTitle(), movie.getUrlImage(), movie.getTitle(), movie.getRating(), movie.getYear()));
    }
    
    private void generateTail(){
        printer.println(this.tail);
    }
}
