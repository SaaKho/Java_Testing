/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package junit5_scdassignment3;

/**
 *
 * @author hp
 */
public abstract class Phone {
    protected String name,mobileno,email,city,nationality;

    abstract void menue() ;
    abstract boolean insert() ;
    abstract boolean view() ;
    abstract boolean search() ;
    abstract boolean edit() ;
    abstract boolean deleteparticular() ;
    abstract boolean deleteall() ;
    
}


