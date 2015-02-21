import static java.util.Collections.reverseOrder;

import java.util.Map;


public class FormatOutput 
{
    public static void inference_rules()
    {
		//set output location
		/*
		System.setOut(
			       new PrintStream(
			           new BufferedOutputStream(
			               new FileOutputStream(
			                   folder_structure + "/Dropbox/Work/Code/Arthur_Ignatius/output/final_output.txt"))));
		*/
    	
    	
		//this is where I'll implement a triviality filter
	    //used to print results in reverse order
	    Ontology.ruleCount
	            .entrySet()
	            .stream()
	            //just some threshold
	            .filter(e -> e.getValue() > 0)
	            .sorted(reverseOrder(Map.Entry.comparingByValue()))
	            .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }
}
