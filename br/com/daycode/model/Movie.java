/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.daycode.model;

/**
 *
 * @author Roberto Tengan
 */
public class Movie {
    
    private String title;
    private String urlImage;
    private double rating;
    private int year;
    
    public Movie(String title, String urlImage, double rating, int year){
        this.title = title;
        this.urlImage = urlImage;
        this.rating = rating;
        this.year = year;
    }
    
    public Movie(){
    
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the tittle to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the urlImage
     */
    public String getUrlImage() {
        return urlImage;
    }

    /**
     * @param urlImage the urlImage to set
     */
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    /**
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }
}