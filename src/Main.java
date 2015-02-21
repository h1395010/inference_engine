
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.mit.jwi.item.POS;
import static java.util.Collections.reverseOrder;


public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		
		String folder_structure = "./input/input.txt";

		
		ReadInput.read_file( folder_structure );
	    
		InferenceExtractor.extract_inferences();
	    
	    FormatOutput.inference_rules();
	    
	}	
} 


	

	