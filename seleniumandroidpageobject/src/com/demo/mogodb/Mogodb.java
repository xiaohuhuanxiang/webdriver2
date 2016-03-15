package com.demo.mogodb;


import java.net.UnknownHostException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;


public class Mogodb {

	public static void main(String[] args)  {
		try{
		//ʵ����Mongo��������27017�˿�
        Mongo mongo = new Mongo("localhost", 27017);
        
      //������Ϊyourdb�����ݿ⣬�������ݿⲻ���ڵĻ���mongodb���Զ�����
        DB db = mongo.getDB("yourdb");
     // Get collection from MongoDB, database named "yourDB"
      //��Mongodb�л����ΪyourColleection�����ݼ��ϣ���������ݼ��ϲ����ڣ�Mongodb��Ϊ���½���
        DBCollection collection = db.getCollection("yourCollection");
        
     // ʹ��BasicDBObject���󴴽�һ��mongodb��document,�����踳ֵ��
        BasicDBObject document = new BasicDBObject();
        document.put("id", 1001);
        document.put("msg", "hello world mongoDB in Java");
        //���½�����document���浽collection��ȥ
        collection.insert(document);
        // ����Ҫ��ѯ��document
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("id", 1001);
        // ʹ��collection��find��������document
        DBCursor cursor = collection.find(searchQuery);
        //ѭ��������
        while (cursor.hasNext()) {
        System.out.println(cursor.next());
        }
        System.out.println("Done");
    } catch (UnknownHostException e) {
        e.printStackTrace();
    } catch (MongoException e) {
        e.printStackTrace();
    }
	

	
	}

}
