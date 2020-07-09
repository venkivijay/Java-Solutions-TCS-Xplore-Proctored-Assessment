import java.util.Scanner;

public class Solution {

 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  NavalVessel[] navalVessels = new NavalVessel[4];
  for (int i = 0; i < navalVessels.length; i++) {
   int vesselId = sc.nextInt();
   sc.nextLine();
   String vesselName = sc.nextLine();
   int noOfVoyagesPlanned = sc.nextInt();
   int noOfVoyagesCompleted = sc.nextInt();
   sc.nextLine();
   String purpose = sc.nextLine();
   navalVessels[i] = new NavalVessel(vesselId, vesselName, noOfVoyagesPlanned, noOfVoyagesCompleted, purpose);
  }
  int searchPercentageValue = sc.nextInt();
  sc.nextLine();
  String searchPurposeValue = sc.nextLine();
  int avgOfVoyagesCompleted = findAvgVoyagesByPct(navalVessels, searchPercentageValue);

  if (avgOfVoyagesCompleted > 0)
   System.out.println(avgOfVoyagesCompleted);
  else
   System.out.println("There are no voyages completed with this percentage");

  NavalVessel navalvessel = findVesselByGrade(navalVessels, searchPurposeValue);
  if (navalvessel == null)
   System.out.println("No Naval Vessel is available with the specified purpose");
  else
   System.out.println(navalvessel.getVesselName() + "%" + navalvessel.getClassification());
 }

 public static int findAvgVoyagesByPct(NavalVessel[] navalVessels, int searchPercentageValue) {
  int avg = 0, count = 0;
  for (int i = 0; i < navalVessels.length; i++) {
   int percent = (navalVessels[i].getNoOfVoyagesCompleted() * 100) / navalVessels[i].getNoOfVoyagesPlanned();
   if (percent >= searchPercentageValue) {
    avg += navalVessels[i].getNoOfVoyagesCompleted();
    count++;
   }
  }
  if (avg == 0)
   return 0;
  else
   return avg / count;
 }

 public static NavalVessel findVesselByGrade(NavalVessel[] navalVessels, String searchPurposeValue) {
  for (int i = 0; i < navalVessels.length; i++) {
   if (searchPurposeValue.equalsIgnoreCase(navalVessels[i].getPurpose())) {
    int percentage = (navalVessels[i].getNoOfVoyagesCompleted() * 100) / navalVessels[i].getNoOfVoyagesPlanned();
    if (percentage == 100) navalVessels[i].setClassification("Star");
    else if (percentage >= 80 && percentage <= 99) navalVessels[i].setClassification("Leader");
    else if (percentage >= 55 && percentage <= 79) navalVessels[i].setClassification("Inspirer");
    else
     navalVessels[i].setClassification("Striver");
    return navalVessels[i];
   }
  }
  return null;
 }
}

class NavalVessel {
 private int vesselId, noOfVoyagesPlanned, noOfVoyagesCompleted;
 private String vesselName, purpose, classification;
 NavalVessel(int vesselId, String vesselName, int noOfVoyagesPlanned, int noOfVoyagesCompleted, String purpose) {
  this.vesselId = vesselId;
  this.vesselName = vesselName;
  this.noOfVoyagesPlanned = noOfVoyagesPlanned;
  this.noOfVoyagesCompleted = noOfVoyagesCompleted;
  this.purpose = purpose;
 }
 int getVesselId() {
  return vesselId;
 }
 String getVesselName() {
  return vesselName;
 }
 int getNoOfVoyagesPlanned() {
  return noOfVoyagesPlanned;
 }
 int getNoOfVoyagesCompleted() {
  return noOfVoyagesCompleted;
 }
 String getPurpose() {
  return purpose;
 }
 void setClassification(String classification) {
  this.classification = classification;
 }
 String getClassification() {
  return classification;
 }
}