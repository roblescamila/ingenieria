package core;
import java.util.HashMap;

public class Edge implements Comparable<Edge> {
    private Node one, two;
    private HashMap<String, String> attributes;
    
    
    public Edge(Node one, Node two){
        this.attributes = new HashMap<String, String>();
        this.one = one;
        this.two = two;
   }
    
    public Edge(Node one, Node two, HashMap<String, String> attributes){
        this.attributes = attributes;
        this.one = one;
        this.two = two;
    }
    
    public HashMap<String, String> getAttributes(){
    	return this.attributes;
    }
    
    public Node getNeighbor(Node current){
        if(!(current.equals(one) || current.equals(two)))
            return null;

        return (current.equals(one)) ? two : one;
    }

    public Node getOne(){
        return this.one;
    }
    
    public void addAttribute(String a, String b){
    	this.attributes.put(a, b);
    }
    
    public void removeAttribute(String a){
    	this.attributes.remove(a);
    }
    
    public void changeAttribute(String a, String b){
    	String aux = this.attributes.get(a);
    	attributes.remove(a);
    	attributes.put(b, aux);
    }
    
    public void changeDescription(String a, String b){
    	this.attributes.put(a, b);
    }

    public Node getTwo(){
        return this.two;
    }


    public void setAttribute(String name, String desc){
        this.attributes.put(name, desc);
    }


    public int hashCode(){
        return (one.getLabel() + two.getLabel()).hashCode();
    }

    public boolean equals(Object other){
        if(!(other instanceof Edge))
            return false;

        Edge e = (Edge)other;

        return e.one.equals(this.one) && e.two.equals(this.two);
    }

	public int compareTo(Edge arg0) {
		return 0;
	}  
}
