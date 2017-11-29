import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class movieList {
	
	private ArrayList<Movie> movies = new ArrayList<>();
	
	public movieList() throws FileNotFoundException
	{
		readFile();
	}
	
	public ArrayList<Movie> getMovieList()
	{
		return movies;
	}
	
	public void addMovie(String url) throws IOException
	{
		
		if (!(url.substring(0, 26).equals("http://www.imdb.com/title/") || url.substring(0, 19).equals("www.imdb.com/title/")))
			throw new IOException("Use IMDB URLS that start with http://www.imdb.com/title/");
		
		Document doc;
		try
		{
			doc = Jsoup.connect(url).get();
		
		}
		catch(IOException i)
		{
			throw new IOException("Invalid URL");
		}
		
		String tempName = doc.select("#title-overview-widget > div.vital > div.title_block > div > div.titleBar > div.title_wrapper > h1").text();
		String name = tempName.substring(0, tempName.indexOf("(") - 1);
		
		String ratingGerneReleaseDate = doc.select("#title-overview-widget > div.vital > div.title_block > div > div.titleBar > div.title_wrapper > div").text();
		
		String [] tempArray = ratingGerneReleaseDate.split(" \\| ");
		String rating = tempArray[0];
		String runTime = tempArray[1];
		String [] genres = tempArray[2].split(", ");
		String releaseDate = tempArray[3].substring(0, tempArray[3].indexOf("("));
		
		String plotSummary = doc.select("#title-overview-widget > div.minPosterWithPlotSummaryHeight > div.plot_summary_wrapper > div.plot_summary.minPlotHeightWithPoster > div.summary_text").text();
		
		if(plotSummary.equals(""))
			plotSummary = doc.select("#title-overview-widget > div.plot_summary_wrapper > div.plot_summary > div.summary_text").text();
		
		String x = doc.select("#title-overview-widget > div.minPosterWithPlotSummaryHeight > div.plot_summary_wrapper > div.plot_summary.minPlotHeightWithPoster > div:nth-child(4)").text();
		
		if(x.equals(""))
			x = doc.select("#title-overview-widget > div.plot_summary_wrapper > div.plot_summary > div:nth-child(4)").text();

		String [] stars = x.substring(7, x.indexOf(" |")).split(", ");
		
		x = doc.select("#title-overview-widget > div.vital > div.title_block > div > div.ratings_wrapper > div.imdbRating > div.ratingValue > strong > span").text();
		double score = 0;
		if(!x.equals(""))
		{
			score = Double.parseDouble(x);
		}
		
		Movie temp = new Movie(name, plotSummary, stars, genres, releaseDate, rating, runTime, score);
		movies.add(temp);
		appendFile(temp);
	}
	
	public void addMovie(String n, String p, String [] st, String [] g, String r, String ra, String ru, double s) throws IOException
	{
		Movie temp = new Movie(n, p, st, g, r, ra, ru, s);
		movies.add(temp);
		appendFile(temp);
	}
	
	private void appendFile(Movie x) throws IOException
	{
		FileWriter outFile = new FileWriter("MovieList.txt", true);
		
		outFile.append(x.getName() + "\\" + x.getSummary() + "\\" + x.getReleaseDate() + "\\" + x.getRunTime()
						+ "\\" + x.getScore() + "\\" + x.getRating() + System.lineSeparator());
		for(int i = 0; i < x.getStars().length; i++)
			outFile.append(x.getStars()[i] + "\\");
		outFile.append(System.lineSeparator());
		for(int i = 0; i < x.getGenres().length; i++)
			outFile.append(x.getGenres()[i] + "\\");
		outFile.append(System.lineSeparator() + "END OF MOVIE" + System.lineSeparator());
		outFile.close();
	}
	
	private void readFile() throws FileNotFoundException
	{
		Scanner inFile;
		try 
		{
			inFile = new Scanner(new File("MovieList.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			throw new FileNotFoundException("MovieList.txt is missing");
		}
		
		while(inFile.hasNext())
		{
			String [] line1 = inFile.nextLine().split("\\\\");
			String name = line1[0];
			String plotSummary = line1[1];
			String releaseDate = line1[2];
			String runTime = line1[3];
			double score = Double.parseDouble(line1[4]);
			String rating = line1[5];
			String [] stars = inFile.nextLine().split("\\\\");
			String [] genres = inFile.nextLine().split("\\\\");
			movies.add(new Movie(name, plotSummary, stars, genres, releaseDate, rating, runTime, score));
			inFile.nextLine();
		}
		
		inFile.close();
	}
	
	public ArrayList<Movie> sortByScore()
	{
		ArrayList<Movie> clone = new ArrayList<>();
		for(Movie m : movies)
			clone.add(m.Clone());
		
		Movie temp = new Movie();
		boolean isGreater = false;
		for(int i = 0; i <clone.size()-1; i++)
		{
			isGreater = false;
			int j = 0;
			do
			{
				if(clone.get(i - j).getScore() > clone.get(i+1 - j).getScore())
				{
					temp = new Movie(clone.get(i - j));
					clone.add(i-j + 1, clone.get(i+1 - j));
					clone.remove(i-j);
					clone.add(i + 1 - j + 1, temp);
					clone.remove(i + 1-j);
					j++;
				}
				else
					isGreater = true;
			}while(!isGreater && j < i);
		}
		
		return clone;
	}
	
	public ArrayList<Movie> sortByRuntime()
	{
		ArrayList<Movie> clone = new ArrayList<>();
		for(Movie m : movies)
			clone.add(m.Clone());
		
		Movie temp = new Movie();
		boolean isGreater = false;
		for(int i = 0; i <clone.size()-1; i++)
		{
			isGreater = false;
			int j = 0;
			do
			{
				if(parseRunTime(clone.get(i - j).getRunTime())
						> parseRunTime(clone.get(i+1 - j).getRunTime()))
				{
					temp = new Movie(clone.get(i - j));
					clone.add(i-j + 1, clone.get(i+1 - j));
					clone.remove(i-j);
					clone.add(i + 1 - j + 1, temp);
					clone.remove(i + 1-j);
					j++;
				}
				else
					isGreater = true;
			}while(!isGreater && j < i);
		}
		
		return clone;
	}
	
	public ArrayList<Movie> search(String name, String [] stars, String [] genres, String releaseDate, String rating, String runTime, double score)
	{
		ArrayList<Movie> clone = new ArrayList<>();
		for(Movie m : movies)
			clone.add(m.Clone());
		
		if(name != null)
		{
			for(int i = 0; i < clone.size(); i++)
			{
				if(!clone.get(i).getName().contains(name))
				{
					clone.remove(i);
					i--;
				}
				
			}
		}
		
		if(stars != null)
		{
			boolean hasStar = false;
			for(int i = 0; i < clone.size(); i++)
			{
				hasStar = false;
				String [] cloneStars = clone.get(i).getStars();
				for(int j = 0; j < cloneStars.length; j++)	
				{
					for(int k = 0; k < stars.length; k++)
					{
						if(cloneStars[j].equals(stars[k]))
						{
							hasStar = true;
						}
					}
				}
				
				if(!hasStar)
				{
					clone.remove(i);
					i--;
				}
			}
		}
		
		if(genres != null)
		{
			boolean isGenre = false;
			for(int i = 0; i < clone.size(); i++)
			{
				isGenre = false;
				String [] cloneGenres = clone.get(i).getGenres();
				for(int j = 0; j < cloneGenres.length; j++)	
				{
					for(int k = 0; k < genres.length; k++)
					{
						if(cloneGenres[j].equals(genres[k]))
						{
							isGenre = true;
						}
					}
				}
				
				if(!isGenre)
				{
					clone.remove(i);
					i--;
				}
			}
		}
		
		if(releaseDate != null)
		{
			for(int i = 0; i < clone.size(); i++)
			{
				if(parseReleaseDate(releaseDate) > parseReleaseDate(clone.get(i).getReleaseDate()))
				{
					clone.remove(i);
					i--;
				}
			}
		}
		
		if(rating != null)
		{
			for(int i = 0; i < clone.size(); i++)
			{
				if(parseRating(rating) > parseRating(clone.get(i).getRating()))
				{
					clone.remove(i);
					i--;
				}
			}
		}
		
		if(runTime != null)
		{
			for(int i = 0; i < clone.size(); i++)
			{
				if(parseRunTime(runTime) > parseRunTime(clone.get(i).getRunTime()))
				{
					clone.remove(i);
					i--;
				}
			}
		}
		
		if(score > 0)
		{
			for(int i = 0; i < clone.size(); i++)
			{
				if(score > clone.get(i).getScore())
				{
					clone.remove(i);
					i--;
				}
			}
		}
		
		return clone;
	}
	
	private int parseReleaseDate(String s)
	{
		String [] str = s.split(" ");
		String date = "";
		if(Character.isDigit(str[0].charAt(0)))
		{
			switch(str[1])
			{
			case "January":
				str[1] = "01";
				break;
			case "February":
				str[1] = "02";
				break;
			case "March":
				str[1] = "03";
				break;
			case "April":
				str[1] = "04";
				break;
			case "May":
				str[1] = "05";
				break;
			case "June":
				str[1] = "06";
				break;
			case "July":
				str[1] = "07";
				break;
			case "August":
				str[1] = "08";
				break;
			case "September":
				str[1] = "09";
				break;
			case "October":
				str[1] = "10";
				break;
			case "November":
				str[1] = "11";
				break;
			case "December":
				str[1] = "12";
				break;
			}
			if(Integer.parseInt(str[0]) < 10)
				str[0] = "0" + str[0];
			date = str[2] + str[1] + str[0];
		}
		
		else
		{
			switch(str[0])
			{
			case "January":
				str[0] = "01";
				break;
			case "February":
				str[0] = "02";
				break;
			case "March":
				str[0] = "03";
				break;
			case "April":
				str[0] = "04";
				break;
			case "May":
				str[0] = "05";
				break;
			case "June":
				str[0] = "06";
				break;
			case "July":
				str[0] = "07";
				break;
			case "August":
				str[0] = "08";
				break;
			case "September":
				str[0] = "09";
				break;
			case "October":
				str[0] = "10";
				break;
			case "November":
				str[0] = "11";
				break;
			case "December":
				str[0] = "12";
				break;
			}
			date = str[1] + str[0] + "00";
		}
		
		return Integer.parseInt(date);
	}

	private int parseRating(String s)
	{
		switch(s)
		{
		case "G":
			return 1;
		case "PG":
			return 2;
		case "PG-13":
			return 3;
		case "R":
			return 4;
		default:
			return 5;
		}
	}

	private int parseRunTime(String s)
	{
		if(s.contains("h"))
		{
			String [] str = s.split(" ");
			str[0] = str[0].replace("h", "");
			str[1] = str[1].replace("min", "");
			return (Integer.parseInt(str[0]) * 60) + Integer.parseInt(str[1]);
		}
		else
		{
			s = s.replace("min", "");
			return Integer.parseInt(s); 
		}
	}
}
