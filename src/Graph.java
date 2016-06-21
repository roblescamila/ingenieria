import java.util.*;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObjectCodec;
import com.mongodb.util.JSON;

 

public class Graph {
	private String name;
    private HashMap<String, Node> nodes;
    private HashMap<Integer, Edge> edges;

    public Graph(String n){
    	this.name = n;
        this.nodes = new HashMap<String, Node>();
        this.edges = new HashMap<Integer, Edge>();
    }
    
    public Graph(){
        this.nodes = new HashMap<String, Node>();
        this.edges = new HashMap<Integer, Edge>();
    }

    public Graph(ArrayList<Node> edges, String n){
    	this.name = n;
        this.nodes = new HashMap<String, Node>();
        this.edges = new HashMap<Integer, Edge>();

        for(Node v: edges)
            this.nodes.put(v.getLabel(), v);
    }
    
    public boolean addEdge(Node one, Node two, HashMap<String, String> attributes){

        if(one.equals(two))
            return false;

        Edge e = new Edge(one, two, attributes);

        if(edges.containsKey(e.hashCode()))
            return false;
        

        else if(one.containsNeighbor(e) || two.containsNeighbor(e))
            return false;
        
        edges.put(e.hashCode(), e);

        one.addNeighbor(e);
        two.addNeighbor(e);

        return true;
    }

    public boolean containsEdge(Edge e){
        if(e.getOne() == null || e.getTwo() == null)
            return false;

        return this.edges.containsKey(e.hashCode());
    }

    public Edge removeEdge(Edge e){
       e.getOne().removeNeighbor(e);
       e.getTwo().removeNeighbor(e);
       return this.edges.remove(e.hashCode());
    }     

    public boolean containsNode(Node node){
        return this.nodes.get(node.getLabel()) != null;
    }

    public Node getNode(String label){
        return nodes.get(label);
    }
    
    public boolean addNode(Node node, boolean overwriteExisting){
        Node current = this.nodes.get(node.getLabel());
        
        if(current != null){
            if(!overwriteExisting)
                return false;
            while(current.getNeighborCount() > 0)
                this.removeEdge(current.getNeighbor(0));
        }

        nodes.put(node.getLabel(), node);

        return true;
    }


    public Node removeNode(String label){
        Node v = nodes.remove(label);

        while(v.getNeighborCount() > 0)
            this.removeEdge(v.getNeighbor((0)));         

        return v;
    }
    
    
    public void fromJSON(String j){
    	BasicDBObject o = (BasicDBObject)JSON.parse(j);
    	this.name = (String)o.get("nombre");
    	
    	
    	List<BasicDBObject> aux = (List<BasicDBObject>) o.get("nodos");
    	for(BasicDBObject bo: aux){
        	HashMap<String, String> atts1 =  new HashMap<String, String>();
    		List<BasicDBObject> listAux = (List<BasicDBObject>) bo.get("atributos");
    		for(BasicDBObject a:listAux)
    			atts1.put(a.getString("nombre"), a.getString("descripcion"));   
    		this.addNode(new Node(bo.getString("proceso"), atts1), true);
    	}
    	
    	
    	
    	List<BasicDBObject> auxVert = (List<BasicDBObject>) o.get("arcos");
    	for(BasicDBObject bo: auxVert){
        	HashMap<String, String> atts =  new HashMap<String, String>();
    		List<BasicDBObject> listAux = (List<BasicDBObject>) bo.get("atributos");
    		for(BasicDBObject a:listAux)
    			atts.put(a.getString("nombre"), a.getString("descripcion"));   
    		
    		this.addEdge(this.getNode(bo.getString("origen")), this.getNode(bo.getString("destino")), atts);
    	}
    		
    	
    }

    public Set<String> NodoKeys(){
        return this.nodes.keySet();
    }
    

    public Set<Edge> getEdges(){
        return new HashSet<Edge>(this.edges.values());
    }
}
