import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	protected Screen[] screens;
	
	public App () throws FileNotFoundException {
		movieList list = new movieList();
		ArrayList<Movie> movies = list.getMovieList();
	}
	
	public App (Screen[] s) throws FileNotFoundException {
		this.screens = s;
	}
} // end of class
