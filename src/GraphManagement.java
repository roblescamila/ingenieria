import java.util.HashMap;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;

public class GraphManagement {
	private MongoClient mongoClient;
	private DB database;
	private DBCollection collection;
	private List<Graph> grafos;
	
	public GraphManagement(){
		mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

    	database = mongoClient.getDB("test");
    	collection = database.getCollection("test");
    	
    	/**** EJEMPLO GRAFO******/
    	HashMap<String, String> atts1 = new HashMap<String, String>();
    	atts1.put("a", "aaaaa");
    	Node a = new Node("REQM", atts1);
    	
    	HashMap<String, String> atts2 = new HashMap<String, String>();
    	atts2.put("b", "bbbbb");
    	Node b = new Node("PMC", atts2);  
    	
    	HashMap<String, String> atts3 = new HashMap<String, String>();
    	atts3.put("e", "eeee");
    	Node c = new Node("RM", atts3);
    	
    	
    	HashMap<String, String> atts4 = new HashMap<String, String>();
    	atts4.put("c", "ccccccc");
    	atts4.put("d", "dddddd");
    	
    	HashMap<String, String> atts5 = new HashMap<String, String>();
    	atts5.put("f", "fffff");
    	atts5.put("g", "ggggg");
    	
    	
    	Graph g = new Graph("ProcesosQuinto");
    	g.addNode(a, true);
    	g.addNode(b, true);
    	g.addNode(c, true);
    	g.addEdge(a, b, atts4);
    	g.addEdge(a, c, atts5);
    	importJSON(g.toJSON());
    	/**** EJEMPLO GRAFO******/
    	
    	
    	Graph g2 = new Graph();
    	g2.fromJSON(g.toJSON());
    	g2.setName("Procesos");
    	this.importJSON(g2.toJSON());
    	
    	g.getNode("REQM").setLabel("hola");
    	saveGraph(g);
	}
	
	public void importJSON(String json){
    	collection.insert((BasicDBObject)JSON.parse(json));
	}
	
	public void saveGraph(Graph g){
		BasicDBObject queryTest = new BasicDBObject("nombre", g.getName());
    	collection.remove(queryTest);   	
    	
    	this.importJSON(g.toJSON());
	}
	
	public String exportJSON(String nombre){
		BasicDBObject queryTest = new BasicDBObject("nombre", nombre);
    	DBCursor cursor = collection.find(queryTest);   	
    	
    	DBObject item = cursor.next();
    	return item.toString();
	}
	
	public static void main(String[] args){
		GraphManagement gg = new GraphManagement();
    	    	
    }
}
