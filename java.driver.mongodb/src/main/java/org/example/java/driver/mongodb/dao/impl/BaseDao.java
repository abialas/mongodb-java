package org.example.java.driver.mongodb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.java.driver.mongodb.config.MongoDB;
import org.example.java.driver.mongodb.dao.IBaseDao;
import org.example.java.driver.mongodb.entity.IBaseEntity;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public abstract class BaseDao<T extends IBaseEntity> implements IBaseDao<T> {

    protected final MongoDatabase database;
    protected final Class<T> clazz;

    public BaseDao(final Class<T> clazz) {
        this.database = MongoDB.instance().getDatabase();
        this.clazz = clazz;
    }

    public T save(T entity) {
        if (entity == null) {
            return null;
        }
        database.getCollection(getCollectionName()).insertOne(entity.toDocument());
        return entity;
    }

    public long count() {
        return database.getCollection(getCollectionName()).count();
    }

    public T get(ObjectId id) {

        return null;
    }

    public List<T> findAll() {
        final MongoCursor<Document> cursor = database.getCollection(getCollectionName()).find().iterator();
        final List<T> result = new ArrayList<T>();
        try {
            while (cursor.hasNext()) {
                result.add(parseDocument(cursor.next()));
            }
        } finally {
            cursor.close();
        }
        return result;
    }

    public void deleteAll() {
        database.getCollection(getCollectionName()).deleteMany(new BasicDBObject());
    }

    public void close() {
        MongoDB.instance().getMongoClient().close();
    }

}

/*
 * $Log$
 */
