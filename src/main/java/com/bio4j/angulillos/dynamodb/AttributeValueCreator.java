package com.bio4j.angulillos.dynamodb;


import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public interface AttributeValueCreator<T extends Object> {

    AttributeValue create(T value);
}
