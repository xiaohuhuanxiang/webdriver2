package com.demo.mogodb;

import java.net.UnknownHostException;
import java.util.Set;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;


public class MogodbCollection {

//	����㲻֪��collection�����ƣ�����ʹ��db.getCollectionNames()��ü��ϣ�Ȼ���ٱ��������£�
//	����DB db = mongo.getDB("yourdb");
//	����Set collections = db.getCollectionNames();
//	����for(String collectionName : collections){
//	����System.out.println(collectionName);
//	����}
	public static void main(String[] args) {
		try {
			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("yourdb");
			Set<String> collections = db.getCollectionNames();
			for (String collectionName : collections) {
			System.out.println(collectionName);
			}
			DBCollection collection = db.getCollection("yourCollection");
			System.out.println(collection.toString());
			System.out.println("Done");

			} catch (UnknownHostException e) {
			e.printStackTrace();
			} catch (MongoException e) {
			e.printStackTrace();
			}
	}

}
