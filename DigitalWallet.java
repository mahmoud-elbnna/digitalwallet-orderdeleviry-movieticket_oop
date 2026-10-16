/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mahmoudelbnna
 */
public class DigitalWallet {
   private String walletId;
   private String ownerName;
   private double balance=0;
   private int transactionCount=0;
    
    public DigitalWallet(String walletId, String ownerName, double balance){
        this.walletId=walletId;
        this.ownerName=ownerName;
        if(balance>=0) this.balance=balance;
        else System.out.println("the balance cant be negative so its set to 0");
        System.out.println("constructing object done");
    }
    
    public String getwalletId(){
        System.out.println(walletId);
        return walletId;
    }
    
    public String getownerName(){
        System.out.println(ownerName);
        return ownerName;
    }
    
    public double getbalance(){
        System.out.println(balance);
        return balance;
    }
    
   public int gettransactionCount(){
        System.out.println(transactionCount);
        return transactionCount;
    } 
    
   public void setownerName(String ownerName){
        this.ownerName=ownerName;
        System.out.println("set owner name done");
    } 
   private double calculateTransactionFee(double amount) {
       if(amount<500) return 5;
       else if(amount>=500 && amount<1000) return 10;
       else return 15;
   } 
   
   public void deposit(double amount){
       if(amount>0){ this.balance+=amount;
       this.transactionCount++;
       System.out.println("deposit done");
       }
       else System.out.println("deposit must be greater than 0");
   }
   
   public boolean withdraw(double amount){
       if(amount>0 && amount<=this.balance){
           this.balance=this.balance-amount;
           this.transactionCount++;
           System.out.println("withdraw done");
           return true;
       }
       System.out.println("invalid withdraw");
       return false;
   }
   
    public boolean transfer(DigitalWallet receiver,double amount){
        if(receiver==null){
            System.out.println("invalid the receiver cant be null");
            return false;
        }
        if(this==receiver){
            System.out.println("invalid the sender and the receiver cant be same acount ");
            return false;
        }
        if(amount<=0){
            System.out.println("amount must be greater than 0");
            return false;
        }
        double fee=calculateTransactionFee(amount);
        if(this.balance<amount+fee){
            System.out.println("insufficient balance");
            return false;
        }
        this.balance=this.balance-amount-fee;
        receiver.balance+=amount;
        this.transactionCount++;
        receiver.transactionCount++;
        System.out.println("transfer done");
        return true;
    }
}