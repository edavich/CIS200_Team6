import java.io.IOException;
import java.util.Scanner;

public class Test {

	public static void main(String args[]) throws IOException
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter an IMDB movie page URL: ");
		String url = s.nextLine();
		
		movieList list = new movieList();
		
		list.addMovie(url);
		
		System.out.println(list.movies.get(0).getName());
		System.out.println(list.movies.get(0).getSummary());
		System.out.println(list.movies.get(0).getReleaseDate());
		System.out.println(list.movies.get(0).getRating());
		System.out.println(list.movies.get(0).getRunTime());
		
		String [] genre = list.movies.get(0).getGenres();
		
		for(int i = 0; i < genre.length; i++)
			System.out.println(genre[i]);
		
		String [] stars = list.movies.get(0).getStars();
		
		for(int i = 0; i < stars.length; i++)
			System.out.println(stars[i]);
	}
}
