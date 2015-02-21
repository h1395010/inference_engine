
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.ISynset;
import edu.mit.jwi.item.ISynsetID;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import edu.mit.jwi.item.Pointer;
import edu.mit.jwi.morph.WordnetStemmer;

public class WordNet 
{
	private String wnhome;
	private String path;
	private URL url;
	private static IDictionary dict;
	
	

	public WordNet() throws IOException
	{ 
		// construct the URL to the Wordnet dictionary directory
		wnhome = System.getenv("WNHOME");
		
		path = wnhome + File.separator + "dict";
		url = new URL ("file", null , path );
		
		// construct the dictionary object and open it
		dict = new Dictionary ( url ) ;
		dict.open();
	}
	
	public String getStem(String word, POS pos)
	{
		WordnetStemmer stem =  new WordnetStemmer( dict );
		 
		List<String> stemmed_words = stem.findStems( word, pos );
		
		if ( !stemmed_words.isEmpty() )
			return stemmed_words.get(0);
		else
			return word;
	}
	
}

