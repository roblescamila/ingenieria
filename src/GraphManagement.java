import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class GraphManagement {
	private MongoClient mongoClient;
	private DB database;
	private DBCollection collection;
	
	public GraphManagement(){
		mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

    	database = mongoClient.getDB("test");
    	collection = database.getCollection("test");
	}
	
	public static void main(String[] args){
		GraphManagement gg = new GraphManagement();
    	    	
    }
}
