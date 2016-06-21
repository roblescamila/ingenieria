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
	}
	
	public void importJSON(String json){
    	collection.insert((BasicDBObject)JSON.parse(json));
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
