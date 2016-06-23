package core;
import java.util.ArrayList;
import java.util.HashMap;


public class Node {
    private ArrayList<Edge> neighborhood;
    private String label;
    private HashMap<String, String> attributes;

    public Node(String label, HashMap<String, String> hm){
        this.label = label;
        this.attributes = hm;
        this.neighborhood = new ArrayList<Edge>();
    }

    public Node(String l) {
		this.label = l;
		this.attributes = new HashMap<String, String>();
        this.neighborhood = new ArrayList<Edge>();
	}

    public void setAttribute(String att, String desc){
    	this.attributes.put(att, desc);
    }
    public void removeAttribute(String s){
    	this.attributes.remove(s);
    }
	public void changeKey(String a, String b){
    	String aux = this.attributes.get(a);
    	this.attributes.remove(a);
    	this.attributes.put(b, aux);
    }
    public void changeAtt(String a, String b){
    	this.attributes.put(a, b);
    }
    public void setLabel(String s){
    	this.label = s;
    }
    public HashMap<String, String> getAttributes(){
    	return this.attributes;
    }
    public void addNeighbor(Edge edge){
        if(this.neighborhood.contains(edge))
            return;
     
        this.neighborhood.add(edge);
    }

    public boolean containsNeighbor(Edge other){
        return this.neighborhood.contains(other);
    }

    public Edge getNeighbor(int index){
        return this.neighborhood.get(index);
    }

    Edge removeNeighbor(int index){
        return this.neighborhood.remove(index);
    }

    public void removeNeighbor(Edge e){
        this.neighborhood.remove(e);
    }

    public int getNeighborCount(){
        return this.neighborhood.size();
    }
    
    public String getLabel(){
        return this.label;
    }

    public String toString(){
        return "Nodo " + label;
    }

    public int hashCode(){
        return this.label.hashCode();
    }

    public boolean equals(Object other){
        if(!(other instanceof Node))
            return false;         

        Node v = (Node)other;

        return this.label.equals(v.label);
    }

    public ArrayList<Edge> getNeighbors(){
        return new ArrayList<Edge>(this.neighborhood);
    }
}
