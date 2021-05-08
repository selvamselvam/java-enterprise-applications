package com.siva.core;

import java.net.UnknownHostException;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class App {
    public static void main(String[] args) throws UnknownHostException {

        try {
            /**** Connect to MongoDB ****/
            MongoClient mongo = new MongoClient("localhost", 27017);

            /**** Get database ****/
            DB db = mongo.getDB("test");

            /**** Get collection / table from 'test' ****/
            DBCollection table = db.getCollection("user");

            /**** Insert ****/
            BasicDBObject document = new BasicDBObject();
            document.put("name", "selvam");
            document.put("age", 33);
            document.put("createdDate", new Date());
            table.insert(document);

            /**** Find and display ****/
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("name", "siva");

            DBCursor cursor = table.find(searchQuery);

            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }

    }
}
