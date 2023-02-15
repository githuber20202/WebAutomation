
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WebScrap {
	public static void main(String[] args) 
	{
		final String url = "https://yellow-forest-00099c403.2.azurestaticapps.net/";

		try
		{
			final Document document = Jsoup.connect(url).get();
		//	System.out.println(document.outerHtml());
			Element dataElement = document.select("#data-container").first();
			String data = dataElement.text();
		    System.out.println(data);

		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}	
	}
}
