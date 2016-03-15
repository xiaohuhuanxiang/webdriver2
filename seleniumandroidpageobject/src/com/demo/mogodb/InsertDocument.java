package com.demo.mogodb;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;


public class InsertDocument {

	public static void main(String[] args) {
//		ͨ��JAVA������Mongodb�������ϸ�ʽ��JSON����:4�ַ���
//		ʹ��BasicDBObject
//		ʹ��BasicDBObjectBuilder����
//		ʹ��Map����
//		ֱ�Ӳ���JSON��ʽ����
		
Mongo mongo;
try {
	mongo = new Mongo("localhost", 27017);

DB db = mongo.getDB("yourdb");
// get a single collection
DBCollection collection = db.getCollection("dummyColl");
			
			// JSON parse example
String json ="{'database' : 'mkyongDB','table' : 'hosting',"+
"'detail' : {'records' : 99, 'index' : 'vps_index1', 'active' : 'true'}}}";
DBObject dbObject =(DBObject)JSON.parse(json);
collection.insert(dbObject);
DBCursor cursorDocJSON = collection.find();
while(cursorDocJSON.hasNext()){
System.out.println(cursorDocJSON.next());
}
collection.remove(new BasicDBObject());
} catch (UnknownHostException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}		
	
	}

}
