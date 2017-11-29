import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String args[]) throws IOException
	{
		
		
		movieList list = new movieList();
		
		String done = "";
		while(!done.equals("y"))
		{
			Scanner s = new Scanner(System.in);
			System.out.print("Enter an IMDB movie page URL: ");
			String url = s.nextLine();
			list.addMovie(url);
			
			System.out.print("Do you want to enter another");
			done = s.nextLine();
		}
		
		
		
		ArrayList<Movie> movies = list.getMovieList();
		/*
		System.out.println(movies.get(0).getName());
		System.out.println(movies.get(0).getSummary());
		System.out.println(movies.get(0).getReleaseDate());
		System.out.println(movies.get(0).getRating());
		System.out.println(movies.get(0).getRunTime());
		
		String [] genre = movies.get(0).getGenres();
		
		for(int i = 0; i < genre.length; i++)
			System.out.println(genre[i]);
		
		String [] stars = movies.get(0).getStars();
		
		for(int i = 0; i < stars.length; i++)
			System.out.println(stars[i]);
		
		
		for(int i = 0; i < movies.size(); i ++)
		{
			System.out.println(movies.get(i).toString());
			System.out.println();
		}
		*/
		String [] stars = {"Drama"};
		
		ArrayList<Movie> temp = list.sortByScore();
				//list.search(null, null, null, "1 April 2017", null, null, -1);
		for(int i = 0; i < temp.size(); i++)
		{
			System.out.println(temp.get(i).toString());
			System.out.println();
		}
	}
}
