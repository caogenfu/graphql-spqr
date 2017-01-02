package io.leangen.graphql.generator.mapping.strategy;

import java.util.Optional;

import graphql.schema.GraphQLOutputType;
import io.leangen.graphql.generator.QueryRepository;
import io.leangen.graphql.metadata.DomainType;

public abstract class AbstractTypeGenerationStrategy {

    protected QueryRepository queryRepository;

    public AbstractTypeGenerationStrategy(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    public abstract Entry get(DomainType domainType);

    public static class Entry {
        public String name;
        public Optional<GraphQLOutputType> type;

        public Entry(String name, GraphQLOutputType type) {
            this.name = name;
            this.type = Optional.ofNullable(type);
        }
    }
}