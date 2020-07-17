import java.util.Arrays;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Sim[] sim = new Sim[5];
        for(int i = 0;i < 5;i++){
            int simId = sc.nextInt();
            sc.nextLine();
            String customerName = sc.nextLine();
            double balance = sc.nextDouble();
            double ratePerSecond = sc.nextDouble();
            sc.nextLine();
            String circle = sc.nextLine();
            sim[i] = new Sim(simId,customerName,balance,ratePerSecond,circle);
        }
        String circle1 = sc.nextLine();
        String circle2 = sc.nextLine();
        sc.close();
        Sim[] result = transferCircle(sim,circle1,circle2);
        for(int i = 0;i < result.length;i++){
            System.out.println(result[i].getSimId() +" "+ result[i].getCustomerName() +" "+ result[i].getCircle() +" "+ result[i].getRatePerSecond());
        }
    }
    public static Sim[] transferCircle(Sim[] sim,String circle1,String circle2){   
        Sim[] refined = new Sim[0];
        for(int i=0;i<5;i++){
            if(sim[i].getCircle().equals(circle1)){
                refined=Arrays.copyOf(refined,refined.length+1);
                refined[refined.length-1]=sim[i];
                refined[refined.length-1].setCircle(circle2);
            }
        }
        for(int i=0;i<refined.length-1;i++){
           for(int j=0;j<refined.length-1-i;j++){
               if(refined[j].getRatePerSecond()<refined[j+1].getRatePerSecond())
               {
                 Sim temp=refined[j];
                 refined[j]=refined[j+1];
                 refined[j+1]=temp; 
               }             
           }
        }
        return refined;
    } 
}
class Sim{
    int simId;
    String customerName;
    double balance;
    double ratePerSecond;
    String circle;

    public int getSimId(){
        return simId;
    }
    public String getCustomerName(){
        return customerName;
    }
    public double getBalance(){
        return balance;
    }
    public double getRatePerSecond(){
        return ratePerSecond;
    }
    public String getCircle(){
        return circle;
    }
    public void setCircle(String circle){
        this.circle=circle;
    }
    Sim(int simId,String customerName,double balance, double ratePerSecond,String circle){
        this.simId = simId;
        this.ratePerSecond = ratePerSecond;
        this.customerName = customerName;
        this.circle = circle;
        this.balance=balance;
    }
}