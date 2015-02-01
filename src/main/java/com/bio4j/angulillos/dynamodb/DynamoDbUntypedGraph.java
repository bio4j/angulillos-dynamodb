package com.bio4j.angulillos.dynamodb;

import com.bio4j.angulillos.*;
import com.bio4j.angulillos.dynamodb.model.DynamoDbEdge;
import com.bio4j.angulillos.dynamodb.model.DynamoDbVertex;

public interface DynamoDbUntypedGraph extends UntypedGraph<DynamoDbVertex, String, DynamoDbEdge, String>  {

    @Override
    default <V> void setPropertyE(DynamoDbEdge dynamoDbEdge, String name, V value){
        dynamoDbEdge.<V>setAttribute(name,value);
    }

    @Override
    default <V> void setPropertyV(DynamoDbVertex dynamoDbVertex, String name, V value){
        dynamoDbVertex.<V>setAttribute(name, value);
    }
}
