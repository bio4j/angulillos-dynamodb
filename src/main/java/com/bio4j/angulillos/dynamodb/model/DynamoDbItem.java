package com.bio4j.angulillos.dynamodb.model;


import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.bio4j.angulillos.dynamodb.AttributeValueCreator;
import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;

public class DynamoDbItem {

    private static final Map<Class<?>, AttributeValueCreator<? extends Object>> attributeValueCreators = new HashMap<>();

    static{
        attributeValueCreators.put(String.class, new AttributeValueCreator<String>() {
            @Override
            public AttributeValue create(String value) {
                return new AttributeValue().withS(value);
            }
        });

        attributeValueCreators.put(Long.class, new AttributeValueCreator<Long>() {
            @Override
            public AttributeValue create(Long value) {
                return new AttributeValue().withN(value.toString());
            }
        });

        attributeValueCreators.put(Double.class, new AttributeValueCreator<Double>() {
            @Override
            public AttributeValue create(Double value) {
                return new AttributeValue().withN(value.toString());
            }
        });
    }

    private  Map<String,AttributeValue> attributes;

    public DynamoDbItem withAttributes(Map<String, AttributeValue> item){
        setAttributes(item);
        return this;
    }

    public Map<String, AttributeValue> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, AttributeValue> attributes) {
        this.attributes = attributes;
    }

    public <V extends Object> void setAttribute(String name, V value){
        AttributeValueCreator<V> creator = (AttributeValueCreator<V>)Preconditions.
                checkNotNull(attributeValueCreators.get(value.getClass()),"Given type is not yet supported");
        attributes.put(name,creator.create(value));
    }

}
