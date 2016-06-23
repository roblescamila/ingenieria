package core;
import java.util.ArrayList;
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
    	grafos = new ArrayList<Graph>();
    	
    	/**** EJEMPLO GRAFO******/
    	/*HashMap<String, String> atts1 = new HashMap<String, String>();
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
    	atts5.put("g", "ggggg");*/
    	
    	
    	/*Graph g = new Graph("ProcesosQuinto");
    	g.addNode(a, true);
    	g.addNode(b, true);
    	g.addNode(c, true);
    	g.addEdge(a, b, atts4);
    	g.addEdge(a, c, atts5);
    	importJSON(g.toJSON());
    	/**** EJEMPLO GRAFO******/
    	
    	
    	/*Graph g2 = new Graph();
    	g2.fromJSON(g.toJSON());
    	g2.setName("Procesos");
    	this.importJSON(g2.toJSON());*/
    	
	}
	
	public Graph importJSON(String json){
		Graph aux = new Graph();
		aux.fromJSON(json);
    	collection.insert((BasicDBObject)JSON.parse(json));
    	this.grafos.add(aux);
    	return aux;
	}
	
	public void removeGraph(Graph g){
		this.grafos.remove(g);
		BasicDBObject queryTest = new BasicDBObject("nombre", g.getName());
    	collection.remove(queryTest); 
	}
	
	public Graph createGraph(String name){
		Graph a = new Graph(name);
		this.grafos.add(a);
		return a;
	}
	
	public void loadGraphs(){
		List<String> gs = this.getAllProyects();
		for(String n:gs){
			Graph aux = new Graph(n);
			aux.fromJSON(this.exportJSON(n));
			this.grafos.add(aux);	
		}
	}
	
	public Graph getGraph(String g){
		for(Graph a:this.grafos)
			if(a.getName().equals(g))
				return a;
		return null;
	}
	
	public List<String> getAllProyects(){
		List<String> out = new ArrayList<String>();
    	out = collection.distinct("nombre");
    	
		return out;
	}
	
	public void saveGraphs(){
		List<String> jsons = new ArrayList<String>();
		List<String> nombres = new ArrayList<String>();
		for(int i=0 ; i<grafos.size() ; i++){
			nombres.add(grafos.get(i).getName());
			jsons.add(grafos.get(i).toJSON());	
		}
		for(String s:nombres){
			BasicDBObject queryTest = new BasicDBObject("nombre", s);
	    	collection.remove(queryTest);   
		}
		for(String s:jsons){
			collection.insert((BasicDBObject)JSON.parse(s));
		}
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
