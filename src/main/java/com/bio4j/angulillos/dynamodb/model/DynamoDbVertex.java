package com.bio4j.angulillos.dynamodb.model;


public class DynamoDbVertex {

    private String type;

    private DynamoDbItem item;

    public String type(){return type;}

    public DynamoDbVertex withType(String type){
        this.type = type;
        return this;
    }

    public DynamoDbVertex withItem(DynamoDbItem item){
        this.item = item;
        return this;
    }

    public <V> DynamoDbVertex setAttribute(String name, V value){
        item.<V>setAttribute(name,value);
        return this;
    }

}
