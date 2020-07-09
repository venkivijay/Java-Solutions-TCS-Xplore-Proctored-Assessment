import java.util.Scanner;

public class Solution {

 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  AutonomousCar[] cars = new AutonomousCar[4];
  for (int i = 0; i < cars.length; i++) {
   int carId = sc.nextInt();
   sc.nextLine();
   String brand = sc.nextLine();
   int noOfTestsConducted = sc.nextInt();
   int noOfTestsPassed = sc.nextInt();
   sc.nextLine();
   String environment = sc.nextLine();
   cars[i] = new AutonomousCar(carId, brand, noOfTestsConducted, noOfTestsPassed, environment);
  }
  String env = sc.nextLine();
  String brand = sc.nextLine();
  int testsPassed = findTestPassedByEnv(cars, env);
  if (testsPassed == 0)
   System.out.println("There are no tests passed in this particular environment");
  else
   System.out.println(testsPassed);
  AutonomousCar updatedCar = updateCarGrade(cars, brand);
  if (updatedCar == null)
   System.out.println("No Car is available with the specified brand");
  else
   System.out.println(updatedCar.getBrand() + "::" + updatedCar.getGrade());
 }


 public static int findTestPassedByEnv(AutonomousCar[] cars, String env) {
  int sum = 0;
  for (int i = 0; i < cars.length; i++) {
   if (env.equalsIgnoreCase(cars[i].getEnvironment())) {
    sum = sum + cars[i].getNoOfTestsPassed();
   }
  }
  return sum;
 }

 public static AutonomousCar updateCarGrade(AutonomousCar[] cars, String brand) {
  int rating;
  for (int i = 0; i < cars.length; i++) {
   if (brand.equalsIgnoreCase(cars[i].getBrand())) {
    rating = (cars[i].getNoOfTestsPassed() * 100) / cars[i].getNoOfTestsConducted();
    if (rating >= 80) cars[i].setGrade("A1");
    else cars[i].setGrade("B2");
    return cars[i];
   }
  }
  return null;
 }
}

class AutonomousCar {
 private int carId, noOfTestsConducted, noOfTestsPassed;
 private String brand, environment, grade;
 AutonomousCar(int carId, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment) {
  this.carId = carId;
  this.brand = brand;
  this.noOfTestsConducted = noOfTestsConducted;
  this.noOfTestsPassed = noOfTestsPassed;
  this.environment = environment;
 }
 int getCarId() {
  return carId;
 }
 String getBrand() {
  return brand;
 }
 int getNoOfTestsConducted() {
  return noOfTestsConducted;
 }
 int getNoOfTestsPassed() {
  return noOfTestsPassed;
 }
 String getEnvironment() {
  return environment;
 }
 void setGrade(String grade) {
  this.grade = grade;
 }
 String getGrade() {
  return grade;
 }
}