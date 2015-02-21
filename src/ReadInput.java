import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.mit.jwi.item.POS;


public class ReadInput 
{
	public static void read_file( String file ) throws FileNotFoundException
	{
		
		//set input location
		BufferedReader br = new BufferedReader( new FileReader( file ) );
	    
		try 
		{
		
			Pattern p = Pattern.compile("'(.*?)'\\('(.*?)',\\s*'(.*?)'\\)\\.");
			String line;
			while ((line = br.readLine()) != null) 
			{
				Matcher m = p.matcher(line);
				if( m.matches() ) 
				{
					String raw_verb    = m.group(1);
					String raw_object  = m.group(2);
					String raw_subject = m.group(3);
					
					//you need this first because of the konstrukteur
					WordNet wordnet = new WordNet();
					
					String verb = wordnet.getStem( raw_verb, POS.VERB );
					
					Ontology.addSentence( new Sentence( verb, raw_object, raw_subject ) );
				}
			}
	    
	    
		} 
		catch (IOException ex) 
		{
			// ...
		} 
		finally 
		{
			if (br != null) 
			{
				try 
				{
					br.close();
				} 
				catch (IOException ex) 
				{
					// ignore
				}
			}
		}
	}

}
