package com.bio4j.angulillos.dynamodb.model;


public class DynamoDbEdge {

    private String type;

    private DynamoDbItem item;

    public String type(){return type;}

    public DynamoDbEdge withType(String type){
        this.type = type;
        return this;
    }

    public DynamoDbEdge withItem(DynamoDbItem item){
        this.item = item;
        return this;
    }

    public <V> DynamoDbEdge setAttribute(String name, V value){
        item.<V>setAttribute(name,value);
        return  this;
    }

}
