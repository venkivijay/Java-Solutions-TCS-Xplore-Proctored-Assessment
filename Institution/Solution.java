import java.util.Scanner;
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Institution[] instArray = new Institution[4];
        for(int i=0;i<4;i++){
            int institutionId = sc.nextInt();
            sc.nextLine();
            String institutionName = sc.nextLine();
            String noOfStudentsPlaced = sc.nextLine();
            int noOfStudentsCleared = sc.nextInt();
            sc.nextLine();
            String location= sc.nextLine();
            instArray[i] = new Institution(institutionId,institutionName,noOfStudentsPlaced,noOfStudentsCleared,location);
        }
        String location = sc.nextLine();
        String institutionName = sc.nextLine();
        sc.close();
        int noOfClearance = findNumClearancedByLoc(instArray, location);
        if(noOfClearance!=0) System.out.println(noOfClearance);
        else System.out.println("There are no cleared students in this particular location");
        
        Institution updated = updateInstitutionGrade(instArray, institutionName);
        if(updated!=null) System.out.println(updated.getInstitutionName()+"::"+updated.getGrade());
        else System.out.println("No Institute is available with the specified name");
    }
    
    public static int findNumClearancedByLoc(Institution[] instArray, String location) 
    {
        int noOfClearance = 0;
        for(int i=0;i<instArray.length;i++){
            if(instArray[i].getLocation().equalsIgnoreCase(location)){
                noOfClearance += instArray[i].getNoOfStudentsCleared();
            }
        }
        return noOfClearance;
    }

    public static Institution updateInstitutionGrade(Institution[] instArray, String instName) 
    {
        for(int i=0;i<instArray.length;i++){
            if(instArray[i].getInstitutionName().equalsIgnoreCase(instName)){
                int rating = ((Integer.parseInt(instArray[i].getNoOfStudentsPlaced())*100)/instArray[i].getNoOfStudentsCleared());
                if(rating>=80) instArray[i].setGrade("A");
                else instArray[i].setGrade("B");
                return instArray[i];
            }
        }
        return null;
  }
}

class Institution {
    int institutionId;
    String institutionName;
    String noOfStudentsPlaced;
    int noOfStudentsCleared;
    String location;
    String grade;

    Institution(int institutionId,String institutionName,String noOfStudentsPlaced,int noOfStudentsCleared,String location){
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.noOfStudentsPlaced = noOfStudentsPlaced;
        this.noOfStudentsCleared = noOfStudentsCleared;
        this.location = location;
    }

    int getInstitutionId(){
        return institutionId;
    }

    String getInstitutionName(){
        return institutionName;
    }

    String getNoOfStudentsPlaced(){
        return noOfStudentsPlaced;
    }

    int getNoOfStudentsCleared(){
        return noOfStudentsCleared;
    }

    String getLocation(){
        return location;
    }

    String getGrade(){
        return grade;
    }


    void setInstitutionId(int institutionId){
        this.institutionId = institutionId;
    }

    void setInstitutionName(String institutionName){
        this.institutionName = institutionName;
    }

    void setNoOfStudentsPlaced(String noOfStudentsPlaced){
        this.noOfStudentsPlaced = noOfStudentsPlaced;
    }

    void setNoOfStudentsCleared(int noOfStudentsCleared){
        this.noOfStudentsCleared = noOfStudentsCleared;
    }

    void setLocation(String location){
        this.location = location;
    }

    void setGrade(String grade){
        this.grade = grade;
    }
}