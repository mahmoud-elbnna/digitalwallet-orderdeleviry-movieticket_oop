/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author mahmoudelbnna
 */


public class ooplab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*MovieTicket mt1=new MovieTicket("1","7 dogs","ali","100",200);
        mt1.getprice();
        MovieTicket mt2=new MovieTicket("1","7 dogs","ali","100",-200);
        mt2.getprice();
        mt2.bookTicket();
        mt2.setdiscountPercentage(50);
        mt1.setdiscountPercentage(-20);
        mt1.bookTicket();
        mt1.bookTicket();
        mt1.setseatNumber("200");
        mt1.cancelBooking();
        mt1.setseatNumber("200");
        mt1.setdiscountPercentage(10);
        mt1.calculateFinalPrice();
        mt1.getID();*/
        
        /*DigitalWallet dw1=new DigitalWallet("1","hossam",100);
        DigitalWallet dw2=new DigitalWallet("2","hossam",-100);
        dw2.deposit(300);
        dw2.gettransactionCount();
        dw2.deposit(-300);
        dw2.gettransactionCount();
        dw1.withdraw(20);
        dw1.withdraw(-20);
        dw1.withdraw(330);
        dw2.transfer(dw1,10);
        dw2.transfer(dw2,10);
        dw2.transfer(null,10);*/
        
        DigitalWallet poorW=new DigitalWallet("PW","Sara",100);
        DeliveryOrder o3=new DeliveryOrder("O3","Sara","Giza",1,-400,poorW);
        o3.pay();
        o3.getpaymentStatus();
        poorW.getbalance();
        poorW.gettransactionCount();
        o3.deliver();
        o3.getdeliveryStatus();
        poorW.deposit(200);
        o3.pay();
        poorW.getbalance();
        poorW.gettransactionCount();
        o3.getpaymentStatus();

        DeliveryOrder o4=new DeliveryOrder("O4","Karim","Smouha",1,100);
        o4.setnumberItems(0);
        o4.setnumberItems(5);
        o4.getnumberItems();
        o4.setsubtotal(-10);
        o4.setsubtotal(250);
        o4.getsubtotal();
        o4.setcustomerName("   ");
        o4.setdeliveryAddress("");
        o4.setcustomerName("Karim Ali");
        o4.pay();
        o4.setsubtotal(900);
        o4.setnumberItems(2);
        o4.getsubtotal();

        new DeliveryOrder("B1","Ali","Alex",1,499.99).pay();
        new DeliveryOrder("B2","Ali","Alex",1,500).pay();
        new DeliveryOrder("B3","Ali","Alex",1,999.99).pay();
        new DeliveryOrder("B4","Ali","Alex",1,1000).pay();
    }
    }
    

