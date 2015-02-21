import java.util.Objects;

public class Sentence 
{
	private String verb;
	private String object;
	private String subject;
	public Sentence(String verb, String object, String subject )
	{
		this.verb = verb;
		this.object = object;
		this.subject = subject;
	}
	
	public String getVerb()
	{
		return verb; 
	}
	
	public String getObject()
	{
		return object; 
	}
			
	public String getSubject()
	{
		return subject;
	}
	
	public String toString()
	{
		return verb + "(" + object + ", " + subject + ").";
	}
	
	//I want to relocate these, but where?
	@Override
	public boolean equals(Object other)
	{
	    if (!(other instanceof Sentence))
	        return false;
	    if (other == this)
	        return true;
	    Sentence o = (Sentence) other;
	    return o.subject.equals(subject) && o.verb.equals(verb) && o.object.equals(object);
	}
	
	//this returns the hash code for the object
	@Override
	public int hashCode()
	{
		//so this is basically de-hashifying the data
	    return Objects.hash(object, subject, verb);
	}
	
	
	
	
}


