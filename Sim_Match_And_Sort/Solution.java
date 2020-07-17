import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Sim[] sim = new Sim[4];
        for(int i = 0;i < 4;i++){
            sim[i] = new Sim(sc.nextInt(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.next());
        }
        String search_circle=sc.next();
        double search_rate=sc.nextDouble();
        sc.nextLine();
        sc.close();
        Sim[] result=matchAndSort(sim,search_circle,search_rate);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i].getId());
        }
    }

    public static Sim[] matchAndSort(Sim[] sim,String search_circle,double search_rate){
        Sim[] refined = new Sim[0];
        for(int i=0;i<sim.length;i++){
            if((sim[i].getCircle()).equals(search_circle)&&(sim[i].getRatePerSecond()<search_rate)){
                refined=Arrays.copyOf(refined, refined.length+1);
                refined[refined.length-1]=sim[i];
            }
        }
        for(int i=0;i<refined.length-1;i++){
            for(int j=0;j<refined.length-i-1;j++){
                if(refined[j].getBalance()<refined[j+1].getBalance()){
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
    int id;
    String company;
    int balance;
    double ratePerSecond;
    String circle;
    String getCircle(){
        return circle;
    }
    double getRatePerSecond(){
        return ratePerSecond;
    }
    int getBalance(){
        return balance;
    }
    int getId(){
        return id;
    }
    Sim(int id,String company,int balance,double ratePerSecond,String circle){
        this.id=id;
        this.company=company;
        this.balance=balance;
        this.ratePerSecond=ratePerSecond;
        this.circle=circle;
    }
}
