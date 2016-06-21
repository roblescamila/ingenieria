import java.util.ArrayList;
import java.util.HashMap;


public class Node {
    private ArrayList<Edge> neighborhood;
    private String label;
    private HashMap<String, String> attribute;

    public Node(String label, HashMap<String, String> hm){
        this.label = label;
        this.attribute = hm;
        this.neighborhood = new ArrayList<Edge>();
    }

    public HashMap<String, String> getAttributes(){
    	return this.attribute;
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
