import java.util.ArrayList;

public class Movie {

	private String name; //Delcaring private variables
	private String summary;
	private String [] stars;
	private String [] genres;
	private String releaseDate;
	private String rating;
	private String runTime;
	private double score;
	
	public Movie()
	{
		
	}
	
	public Movie(String n, String su, String [] st, String [] g, String rd, String ra, String rt, double sc)
	{
		name = n;
		summary = su;
		stars = st;
		genres = g;
		releaseDate = rd;
		rating = ra;
		runTime = rt;
		score = sc;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getSummary()
	{
		return summary;
	}
	
	public String [] getStars()
	{
		return stars;
	}
	
	public String [] getGenres()
	{
		return genres;
	}
	
	public String getReleaseDate()
	{
		return releaseDate;
	}
	
	public String getRating()
	{
		return rating;
	}
	
	public String getRunTime()
	{
		return runTime;
	}
	
	public double getScore()
	{
		return score;
	}
}
