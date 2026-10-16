/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mahmoudelbnna
 */
public class DeliveryOrder {
    private String orderId;
    private String customerName;
    private String deliveryAddress;
    private int numberItems;
    private double subtotal;
    private String paymentMethod;
    private DigitalWallet wallet;
    private boolean paymentStatus=false;
    private boolean deliveryStatus=false;
    
    public DeliveryOrder(String orderId,String customerName,String deliveryAddress,int itemCount,double subtotal){
        if(!isValidText(orderId)) throw new IllegalArgumentException("order id cant be empty");
        if(!isValidText(customerName)) throw new IllegalArgumentException("customer name cant be empty");
        if(!isValidText(deliveryAddress)) throw new IllegalArgumentException("delivery address cant be empty");
        if(itemCount<=0) throw new IllegalArgumentException("item count must be greater than 0");
        if(subtotal<0) throw new IllegalArgumentException("subtotal cant be negative");
        this.orderId=orderId.trim();
        this.customerName=customerName.trim();
        this.deliveryAddress=deliveryAddress.trim();
        this.numberItems=itemCount;
        this.subtotal=subtotal;
        this.paymentMethod="cash";
    }
    
    public DeliveryOrder(String orderId,String customerName,String deliveryAddress,int itemCount,double subtotal,DigitalWallet wallet){
        this(orderId,customerName,deliveryAddress,itemCount,subtotal);
        if(wallet==null) throw new IllegalArgumentException("a wallet order needs a wallet");
        this.paymentMethod="wallet";
        this.wallet=wallet;
    }
    
    private static boolean isValidText(String text){
        return text!=null && !text.trim().isEmpty();
    }
    
    public String getorderID(){
        System.out.println(orderId);
        return orderId;
    }
    
    public String getcustomerName(){
        System.out.println(customerName);
        return customerName;
    } 
   
    public String getdeliveryAddress(){
        System.out.println(deliveryAddress);
        return deliveryAddress;
    } 
    
    public int getnumberItems(){
        System.out.println(numberItems);
        return numberItems;
    }  
   
    public double getsubtotal(){
        System.out.println(subtotal);
        return subtotal;
    }  
    
    public String getpaymentMethod(){
        System.out.println(paymentMethod);
        return paymentMethod;
    }  
   
    public boolean getpaymentStatus(){
        System.out.println(paymentStatus);
        return paymentStatus;
    }
   
    public boolean getdeliveryStatus(){
        System.out.println(deliveryStatus);
        return deliveryStatus;
    }
   
    public void setcustomerName(String customerName){
        if(deliveryStatus){
            System.out.println("order is delivered cannot change customer name");
            return;
        }
        if(!isValidText(customerName)){
            System.out.println("customer name cant be empty");
            return;
        }
        this.customerName=customerName.trim();
        System.out.println("set customer name done");
    }
   
    public void setdeliveryAddress(String deliveryAddress){
        if(deliveryStatus){
            System.out.println("order is delivered cannot change delivery address");
            return;
        }
        if(!isValidText(deliveryAddress)){
            System.out.println("delivery address cant be empty");
            return;
        }
        this.deliveryAddress=deliveryAddress.trim();
        System.out.println("set delivery address done");
    }
   
    public void setnumberItems(int numberItems){
        if(paymentStatus){
            System.out.println("order is paid cannot change number of items");
            return;
        }
        if(numberItems<=0){
            System.out.println(numberItems + " is invalid : item count must be greater than 0");
            return;
        }
        this.numberItems=numberItems;
        System.out.println("set number of items done");
    }
   
    public void setsubtotal(double subtotal){
        if(paymentStatus){
            System.out.println("order is paid cannot change subtotal");
            return;
        }
        if(subtotal<0){
            System.out.println(subtotal + " is invalid : subtotal cant be negative");
            return;
        }
        this.subtotal=subtotal;
        System.out.println("set subtotal done");
    }
   
    private double calculateDeliveryCost(){
        if(this.subtotal<500) return 50;
        else if(this.subtotal<1000) return 30;
        else return 10;
    }
   
    public double calculateTotalCost(){
        return this.subtotal+calculateDeliveryCost();
    }
    
    public boolean pay(){
        if(paymentStatus){
            System.out.println("order is already paid");
            return false;
        }
        if(paymentMethod.equals("wallet")){
            if(!wallet.withdraw(calculateTotalCost())){
                System.out.println("payment failed");
                return false;
            }
        }
        paymentStatus=true;
        System.out.println("payment done");
        return true;
    }
    
    public boolean deliver(){
        if(!paymentStatus){
            System.out.println("order is unpaid cannot deliver");
            return false;
        }
        if(deliveryStatus){
            System.out.println("order is already delivered");
            return false;
        }
        deliveryStatus=true;
        System.out.println("order delivered");
        return true;
    }
}