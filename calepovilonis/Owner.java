import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Owner extends App {
	
	public Owner() throws FileNotFoundException {	
		super(setMovies());
		printMovies(super.screens);
	} //end of constructor

	private static Screen[] setMovies() throws FileNotFoundException {
		Scanner s = new Scanner(System.in);
		movieList list = new movieList();
		ArrayList<Movie> movies = list.getMovieList();
		System.out.println("Welcome to Owner Mode!");
		System.out.print("How many screens are in the theater?: ");
		int screenAmount = Integer.parseInt(s.nextLine());
		Screen[] screens = new Screen[screenAmount];
		for (int i = 0; i < screens.length; i++ ) {
			System.out.println("Search for a movie to run on Screen #" + (i+1) + ": ");
			Movie movie = null;
			while (movie == null) {
				System.out.print("What do you want to search by? (Name), (Stars), (Genres), (Release Date), (Rating), (Run Time), (Score): ");
				String response = s.nextLine().toLowerCase();
				if (response.equals("name")) {
					System.out.print("Enter in the name of the movie: ");
					String movieName = s.nextLine();
					ArrayList<Movie> temp = list.search(movieName, null, null, null, null, null, -1);
					if (temp.size() == 0) {
						System.out.println("No movies found.");
					}
					else {
						System.out.println("Movies found:");
						int display = 0;
						for (int z = 0; z < temp.size(); z++) {
							System.out.print("(" + z + ")" + temp.get(z).getName() + "\t");
							display++;
							if (display == 5) {
								System.out.println("");
								display = 0;
							}
						} // end of displaying movies
						System.out.print("\nEnter in the corresponding movie number to add movie to Screen #" + (i+1) + ": ");
						int movieNum = Integer.parseInt(s.nextLine());
						System.out.print("How many seats are in this Screen?: ");
						int seatsSize = Integer.parseInt(s.nextLine());
						int [] screenSeats = new int[seatsSize];
						movie = temp.get(movieNum);
						screens[i] = new Screen(movie, screenSeats);
					} // end of if/else chain
				} // end of if name
				else if (response.equals("stars")) {
					System.out.print("Enter in the star of the movie: ");
					String starName = s.nextLine();
					String[] starray = new String[1];
					starray[0] = starName;
					ArrayList<Movie> temp = list.search(null, starray, null, null, null, null, -1);
					if (temp.size() == 0) {
						System.out.println("No movies found.");
					}
					else {
						System.out.println("Movies found:");
						int display = 0;
						for (int z = 0; z < temp.size(); z++) {
							System.out.print("(" + z + ")" + temp.get(z).getName() + "\t");
							display++;
							if (display == 5) {
								System.out.println("");
								display = 0;
							}
						} // end of displaying movies
						System.out.print("\nEnter in the corresponding movie number to add movie to Screen #" + (i+1) + ": ");
						int movieNum = Integer.parseInt(s.nextLine());
						System.out.print("How many seats are in this Screen?: ");
						int seatsSize = Integer.parseInt(s.nextLine());
						int [] screenSeats = new int[seatsSize];
						movie = temp.get(movieNum);
						screens[i] = new Screen(movie, screenSeats);
					} // end of if/else chain
				}
				else if (response.equals("genres")) {
					System.out.print("Enter in the genre of the movie: ");
					String genreName = s.nextLine();
					String[] genreArr = new String[1];
					genreArr[0] = genreName;
					ArrayList<Movie> temp = list.search(null, null, genreArr, null, null, null, -1);
					if (temp.size() == 0) {
						System.out.println("No movies found.");
					}
					else {
						System.out.println("Movies found:");
						int display = 0;
						for (int z = 0; z < temp.size(); z++) {
							System.out.print("(" + z + ")" + temp.get(z).getName() + "\t");
							display++;
							if (display == 5) {
								System.out.println("");
								display = 0;
							}
						} // end of displaying movies
						System.out.print("\nEnter in the corresponding movie number to add movie to Screen #" + (i+1) + ": ");
						int movieNum = Integer.parseInt(s.nextLine());
						System.out.print("How many seats are in this Screen?: ");
						int seatsSize = Integer.parseInt(s.nextLine());
						int [] screenSeats = new int[seatsSize];
						movie = temp.get(movieNum);
						screens[i] = new Screen(movie, screenSeats);
					} // end of if/else chain
				}
				else if (response.equals("release date")) {
					System.out.print("Enter in the release date of the movie: ");
					String releaseDate = s.nextLine();
					ArrayList<Movie> temp = list.search(null, null, null, releaseDate, null, null, -1);
					if (temp.size() == 0) {
						System.out.println("No movies found.");
					}
					else {
						System.out.println("Movies found:");
						int display = 0;
						for (int z = 0; z < temp.size(); z++) {
							System.out.print("(" + z + ")" + temp.get(z).getName() + "\t");
							display++;
							if (display == 5) {
								System.out.println("");
								display = 0;
							}
						} // end of displaying movies
						System.out.print("\nEnter in the corresponding movie number to add movie to Screen #" + (i+1) + ": ");
						int movieNum = Integer.parseInt(s.nextLine());
						System.out.print("How many seats are in this Screen?: ");
						int seatsSize = Integer.parseInt(s.nextLine());
						int [] screenSeats = new int[seatsSize];
						movie = temp.get(movieNum);
						screens[i] = new Screen(movie, screenSeats);
					} // end of if/else chain
				}
				else if (response.equals("rating")) {
					System.out.print("Enter in the rating of the movie: ");
					String rating = s.nextLine();
					ArrayList<Movie> temp = list.search(null, null, null, null, rating, null, -1);
					if (temp.size() == 0) {
						System.out.println("No movies found.");
					}
					else {
						System.out.println("Movies found:");
						int display = 0;
						for (int z = 0; z < temp.size(); z++) {
							System.out.print("(" + z + ")" + temp.get(z).getName() + "\t");
							display++;
							if (display == 5) {
								System.out.println("");
								display = 0;
							}
						} // end of displaying movies
						System.out.print("\nEnter in the corresponding movie number to add movie to Screen #" + (i+1) + ": ");
						int movieNum = Integer.parseInt(s.nextLine());
						System.out.print("How many seats are in this Screen?: ");
						int seatsSize = Integer.parseInt(s.nextLine());
						int [] screenSeats = new int[seatsSize];
						movie = temp.get(movieNum);
						screens[i] = new Screen(movie, screenSeats);
					} // end of if/else chain
				}
				else if (response.equals("run time")) {
					System.out.print("Enter in the run time of the movie: ");
					String runTime = s.nextLine();
					ArrayList<Movie> temp = list.search(null, null, null, null, null, runTime, -1);
					if (temp.size() == 0) {
						System.out.println("No movies found.");
					}
					else {
						System.out.println("Movies found:");
						int display = 0;
						for (int z = 0; z < temp.size(); z++) {
							System.out.print("(" + z + ")" + temp.get(z).getName() + "\t");
							display++;
							if (display == 5) {
								System.out.println("");
								display = 0;
							}
						} // end of displaying movies
						System.out.print("\nEnter in the corresponding movie number to add movie to Screen #" + (i+1) + ": ");
						int movieNum = Integer.parseInt(s.nextLine());
						System.out.print("How many seats are in this Screen?: ");
						int seatsSize = Integer.parseInt(s.nextLine());
						int [] screenSeats = new int[seatsSize];
						movie = temp.get(movieNum);
						screens[i] = new Screen(movie, screenSeats);
					} // end of if/else chain
				}
				else if (response.equals("score")) {
					System.out.print("Enter in the score of the movie: ");
					double score = Double.parseDouble(s.nextLine());
					ArrayList<Movie> temp = list.search(null, null, null, null, null, null, score);
					if (temp.size() == 0) {
						System.out.println("No movies found.");
					}
					else {
						System.out.println("Movies found:");
						int display = 0;
						for (int z = 0; z < temp.size(); z++) {
							System.out.print("(" + z + ")" + temp.get(z).getName() + "\t");
							display++;
							if (display == 5) {
								System.out.println("");
								display = 0;
							}
						} // end of displaying movies
						System.out.print("\nEnter in the corresponding movie number to add movie to Screen #" + (i+1) + ": ");
						int movieNum = Integer.parseInt(s.nextLine());
						System.out.print("How many seats are in this Screen?: ");
						int seatsSize = Integer.parseInt(s.nextLine());
						int [] screenSeats = new int[seatsSize];
						movie = temp.get(movieNum);
						screens[i] = new Screen(movie, screenSeats);
					} // end of if/else chain
				}
				else {
					System.out.println("No movies found.");
				} // if/else if chain for search result
			} // while chain for selecting movie
		} // end of search
		return screens;
	} // end of method
	
	private void printMovies(Screen[] s) {
		System.out.println("Currently in theaters: ");
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i].getMovie().getName() + "\n");
		}
	}
	
}
