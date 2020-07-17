import java.util.Arrays;
import java.util.Scanner;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Movie[] movies = new Movie[4];
        for(int i = 0;i < 4;i++){
            movies[i] = new Movie(sc.next(),sc.next(),sc.next(),sc.nextInt());
            sc.nextLine();
        }
        String searchGenre = sc.nextLine();
        sc.close();
        Movie[] result = getMovieByGenre(movies,searchGenre);
        for(int i = 0;i < result.length;i++){
            if(result[i].getBudget() > 80000000)
                System.out.println("High Budget Movie");
            else
                System.out.println("Low Budget Movie");
        }
    }
    
    public static Movie[] getMovieByGenre(Movie[] movies,String searchGenre){
        Movie[] refined = new Movie[0];
        for(int i = 0;i < 4;i++){
            if(movies[i].getGenre().equals(searchGenre)){
                refined=Arrays.copyOf(refined, refined.length+1);
                refined[refined.length-1] = movies[i];   
            }
        }
        return refined;
    }
}

class Movie{
    String movieName;
    String company;
    String genre;
    int budget;
    
    public String getGenre(){
        return genre;
    }

    public int getBudget(){
        return budget;
    }

    Movie(String movieName, String company, String genre, int budget){
        this.movieName = movieName;
        this.company = company;
        this.genre = genre;
        this.budget = budget;
    }
}