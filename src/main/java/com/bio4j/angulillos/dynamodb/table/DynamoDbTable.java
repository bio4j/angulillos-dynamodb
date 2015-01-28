package com.bio4j.angulillos.dynamodb.table;


import com.amazonaws.regions.Region;

public interface DynamoDbTable {

    String name();
    Region region();
}
