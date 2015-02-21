import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ontology 
{
	
	private static List<Sentence> sentences = new ArrayList<>();
	/*
	 * The following maps store the relation of a string occurring
	 * as a subject or object, respectively, to the list of Sentence
	 * ordinals where they occur.
	 */
	private static Map<String,List<Integer>> subject2index = new HashMap<>();
	private static Map<String,List<Integer>> object2index = new HashMap<>();
	
	/*
	 * This set contains strings that occur as both,
	 * subject and object. This is useful for determining strings
	 * acting as an in-between connecting two relations. 
	 */
	private static Set<String> joints = new HashSet<>();
	
	public static void addSentence( Sentence s )
	{
		
		// add Sentence to the list of all Sentences
		sentences.add( s );
		
		// add the Subject of the Sentence to the map mapping strings
		// occurring as a subject to the ordinal of this Sentence
		List<Integer> subind = subject2index.get( s.getSubject() );
		if( subind == null )
		{
			subind = new ArrayList<>();
			//subind is the number of the sentence where that subject has appeared. 
			// of the form {orange=[1], vitamin C=[0], sauerkraut=[2]}
			subject2index.put( s.getSubject(), subind );
		}
		//sentences is the number of sentences thus far considered
		subind.add( sentences.size() - 1 );
		
		// add the Object of the Sentence to the map mapping strings
		// occurring as an object to the ordinal of this Sentence
		List<Integer> objind = object2index.get( s.getObject() );
		if( objind == null )
		{
			objind = new ArrayList<>();
			object2index.put( s.getObject(), objind );
			//^{vitamin C=[1, 2], scurvy=[0]}
		}
		objind.add( sentences.size() - 1 );
		
		// determine whether we've found a "joining" string
		if( subject2index.containsKey( s.getObject() ) )
		{
			joints.add( s.getObject() );
		}
		if( object2index.containsKey( s.getSubject() ) )
		{
			joints.add( s.getSubject() );
		}
	}

	public static Collection<String> getJoints()
	{
		return joints;
	}
	
	public static List<Integer> getSubjectIndices( String subject )
	{
		return subject2index.get( subject );
	}
	
	public static List<Integer> getObjectIndices( String object )
	{
		return object2index.get( object );
	}
	
	public static Sentence getSentence( int index )
	{
		return sentences.get( index );
	}
	
	
	//map to store learned 'rules'
	public static Map<Sentence, Integer> ruleCount = new HashMap<>();
	//store data
	public static void numberRules(Sentence sentence) 
	{
		if (!ruleCount.containsKey(sentence))
		{
			ruleCount.put(sentence, 0);
		}
		ruleCount.put(sentence, ruleCount.get(sentence) + 1);
	}
		
}






