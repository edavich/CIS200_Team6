import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Screen {
	private Movie movie;
	private int[] seats;
	
	public Screen() {}
	
	public Screen(Movie m, int[] s) {
		this.movie = m;
		this.seats = s;
	}
	
	public Movie getMovie() {
		return this.movie;
	}
	
}
