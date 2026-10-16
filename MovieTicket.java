/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mahmoudelbnna
 */
public class MovieTicket {
   private String ticketId;
   private String movieName;
   private String customerName;
   private String seatNumber;
   private double price=0;
   private String bookingStatus="not booked";
   private double discountPercentage=0;
    
    public MovieTicket(String ticketId, String movieName, String customerName, 
String seatNumber, double price){
        this.ticketId=ticketId;
        this.movieName=movieName;
        this.customerName=customerName;
        this.seatNumber=seatNumber;
        if(price>=0){
            this.price=price;
        }
        else System.out.println("price cant be negative so its set to 0");
        System.out.println("constructing object done");
    }
    
    public String getID(){
        System.out.println(ticketId);
        return ticketId;
    }
    
    public String getmovieName(){
         System.out.println(movieName);
        return movieName;
    }
    
    public String getcustomerName(){
        System.out.println(customerName);
        return customerName;
    }
    
    public String getseatNumber(){
         System.out.println(seatNumber);
        return seatNumber;
    }
    
    public double getprice(){
        System.out.println(price); 
        return price;
    }
    
    public String getbookingStatus(){
        System.out.println(bookingStatus); 
        return bookingStatus;
    }
    
    public double getdiscountPercentage(){
        System.out.println(discountPercentage); 
        return discountPercentage;
    }
    
    public void setcustomerName(String customerName){
        this.customerName=customerName;
         System.out.println("set customer name done");
    }
    
    public void setmovieName(String movieName){
        this.movieName=movieName;
        System.out.println("set movie name done");
    }
    
    public void setprice(double price){
        if(price<0){
        System.out.println(price + " is invalid : price must not be negative");
        return;
        }
        this.price=price;
        System.out.println("set price done");
    }
    
    public void setseatNumber(String seatNumber){
        if(this.bookingStatus.equals("booked")){
            System.out.println("cannot change the seat while the ticket is booked");
            return;
        }
        this.seatNumber=seatNumber;
        System.out.println("set seat number done");
    }
    
    public void setdiscountPercentage(double discountPercentage){
        if(discountPercentage>100 || discountPercentage<0){
            System.out.println(discountPercentage + " is invalid : discount percentage must be between 0 and 100");
            return;
        }
        this.discountPercentage=discountPercentage;
        System.out.println("set discount percentage done");
    }
    
    public void bookTicket(){
        if(this.price==0){ 
            System.out.println("you cant book a ticket with price 0");
            return;
        }
        if(this.bookingStatus.equals("booked")){ 
            System.out.println("this ticket is already booked");
            return;
        }
        this.bookingStatus="booked";
        System.out.println("booking ticket done");
    }
    
    public void cancelBooking(){
        if(this.bookingStatus.equals("not booked")){ 
            System.out.println("this ticket is already not booked");
            return;
        }
        this.bookingStatus="not booked";
        System.out.println("unbocking ticket done");
    }
  
    public double applyDiscount(){
        return this.price-this.price*(this.discountPercentage/100);
    }
    
    public double calculateFinalPrice(){
        double discountedPrice=this.applyDiscount();
        if(this.bookingStatus.equals("booked")){
            System.out.println("booked ticket pricing done");
            return discountedPrice+discountedPrice*0.1;
        }
        System.out.println("booked ticket pricing with no booking done");
        return discountedPrice;
    }
}