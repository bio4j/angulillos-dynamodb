package com.bio4j.angulillos.dynamodb.model;


import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.util.Map;

public class DynamoDbItem {
    private  Map<String,AttributeValue> item;

    public DynamoDbItem withItem(Map<String, AttributeValue> item){
        setItem(item);
        return this;
    }

    public Map<String, AttributeValue> getItem() {
        return item;
    }

    public void setItem(Map<String, AttributeValue> item) {
        this.item = item;
    }
}
