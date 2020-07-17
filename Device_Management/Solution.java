import java.util.Scanner;
public class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Phone[] phones = new Phone[4];
        for(int i = 0; i<4;i++){
            int id = sc.nextInt();
            sc.nextLine();
            String os = sc.nextLine();
            String  brand = sc.nextLine();
            int price = sc.nextInt();
            phones[i] = new Phone(id, os, brand, price);
        }
        sc.nextLine();
        String searchBrand = sc.nextLine();
        String searchOS = sc.nextLine();
        sc.close();
        int priceResult = findPriceForGivenBrand(phones, searchBrand);
        if(priceResult!=0){
            System.out.println(priceResult);
        }
        else{
            System.out.println("The given Brand is not available");
        }
        Phone phoneResult = getPhoneIdBasedOnOs(phones, searchOS);
        if(phoneResult!=null){
            System.out.println(phoneResult.phoneId);
        }
        else{
            System.out.println("No phones are available with specified os and price range");
        }

    }

    public static int findPriceForGivenBrand(Phone[] phones, String brand)
      {
          int price = 0;
          for(int i = 0;i<phones.length;i++){
              if(phones[i].getBrand().equalsIgnoreCase(brand)){
                  price += phones[i].getPrice();
              }
          }
          if(price>0)
            return price;
        else
            return 0;
      }

    public static Phone getPhoneIdBasedOnOs(Phone[] phones, String os)
      {
          Phone temp = null;
          for(int i = 0;i<phones.length;i++){
              if(phones[i].getOS().equalsIgnoreCase(os) && phones[i].getPrice()>=50000){
                  temp = phones[i];
                  return temp;
              }
          }
          return temp;
      }
}

class Phone
{
   int phoneId,price;
   String os,brand;
   Phone(int phoneId,String os,String brand,int price){
       this.phoneId = phoneId;
       this.os = os;
       this.brand = brand;
       this.price = price;
   }
   String getOS(){
       return os;
   }
   int getPrice(){
       return price;
   }
   String getBrand(){
       return brand;
   }
}