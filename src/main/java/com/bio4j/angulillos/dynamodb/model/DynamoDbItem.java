package com.bio4j.angulillos.dynamodb.model;


import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.bio4j.angulillos.dynamodb.AttributeValueCreator;
import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DynamoDbItem {

    private static final Map<Class<?>, Function<? extends Object,AttributeValue>> attributeValueCreators = new HashMap<>();

    static{
        attributeValueCreators.put(String.class, (String value) -> new AttributeValue().withS(value));
        attributeValueCreators.put(Long.class, (Long value) -> new AttributeValue().withN(value.toString()));
        attributeValueCreators.put(Double.class, (Double value) -> new AttributeValue().withN(value.toString()));
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
        Function<V, AttributeValue> attributeValueFunction = ((Function<V, AttributeValue>)Preconditions.
                checkNotNull(attributeValueCreators.get(value.getClass()), "Given type is not yet supported"));
        attributes.put(name,attributeValueFunction.apply(value));
    }

}
