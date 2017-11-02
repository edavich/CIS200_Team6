import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class movieList {
	
	public ArrayList<Movie> movies = new ArrayList<>();
	
	public movieList()
	{
		
	}
	
	public void addMovie(String url) throws IOException
	{
		
		System.out.println(url.substring(0, 26));
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
		
		String name = doc.select("#title-overview-widget > div.vital > div.title_block > div > div.titleBar > div.title_wrapper > h1").text();
		
		
		String ratingGerneReleaseDate = doc.select("#title-overview-widget > div.vital > div.title_block > div > div.titleBar > div.title_wrapper > div").text();
		
		String [] tempArray = ratingGerneReleaseDate.split(" \\| ");
		String rating = tempArray[0];
		String runTime = tempArray[1];
		String [] genres = tempArray[2].split(", ");
		String releaseDate = tempArray[3].substring(0, tempArray[3].indexOf("("));
		
		String plotSummary = doc.select("#title-overview-widget > div.minPosterWithPlotSummaryHeight > div.plot_summary_wrapper > div.plot_summary.minPlotHeightWithPoster > div.summary_text").text();
		
		String x = doc.select("#title-overview-widget > div.minPosterWithPlotSummaryHeight > div.plot_summary_wrapper > div.plot_summary.minPlotHeightWithPoster > div:nth-child(4)").text();
		
		String [] stars = x.substring(7, x.indexOf("|")).split(", ");
		
		
		//TODO: add score parser
		double score = 1;
		
		Movie temp = new Movie(name, plotSummary, stars, genres, releaseDate, rating, runTime, score);
		movies.add(temp);
		
	}
	
	
}
