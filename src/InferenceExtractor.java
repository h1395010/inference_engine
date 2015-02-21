
public class InferenceExtractor 
{
	public static void extract_inferences()
	{
		//vitamin c
	    for( String joint: Ontology.getJoints() )
	    {
	    	//0
	    	for( Integer subind: Ontology.getSubjectIndices( joint ) )
	        {
	    		//prevents(scurvy, vitamin c)
	        	Sentence xaS = Ontology.getSentence( subind );

	        	//1
	        	for( Integer obind: Ontology.getObjectIndices( joint ) )
	            {
	        		//contains(vitamin c, orange)
	        		Sentence yOb = Ontology.getSentence( obind );
	                
	        		//prevents(scurvy, orange)
	                Sentence s = new Sentence( xaS.getVerb(),
	                                           xaS.getObject(),
	                                           yOb.getSubject() );
	                //System.out.println( s );                
	                Ontology.numberRules( s );    
	                
	            }
	        }
	    }
	}
}
