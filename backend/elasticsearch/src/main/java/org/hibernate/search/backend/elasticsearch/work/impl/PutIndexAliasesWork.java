/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.work.impl;

import java.util.Map;
import org.hibernate.search.backend.elasticsearch.client.common.gson.spi.GsonProvider;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchRequest;
import org.hibernate.search.backend.elasticsearch.client.common.spi.ElasticsearchResponse;
import org.hibernate.search.backend.elasticsearch.client.common.util.spi.URLEncodedString;
import org.hibernate.search.backend.elasticsearch.client.impl.Paths;
import org.hibernate.search.backend.elasticsearch.lowlevel.index.aliases.impl.IndexAliasDefinition;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class PutIndexAliasesWork extends AbstractNonBulkableWork<Void> {

    protected PutIndexAliasesWork(Builder builder) {
        super(builder);
    }

    @Override
    protected Void generateResult(ElasticsearchWorkExecutionContext context, ElasticsearchResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class Builder extends AbstractBuilder<Builder> {

        private final JsonObject payload;

        public Builder(GsonProvider gsonProvider, URLEncodedString indexName, Map<String, IndexAliasDefinition> aliases) {
            super(ElasticsearchRequestSuccessAssessor.DEFAULT_INSTANCE);
            this.payload = createPayload(gsonProvider, indexName.original, aliases);
        }

        @Override
        protected ElasticsearchRequest buildRequest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public PutIndexAliasesWork build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private static JsonObject createPayload(GsonProvider gsonProvider, String indexName, Map<String, IndexAliasDefinition> aliases) {
            /*
			 * Serializing nulls is really not a good idea here, it triggers NPEs in Elasticsearch
			 * We better not include the null fields.
			 */
            Gson gson = gsonProvider.getGsonNoSerializeNulls();
            JsonObject payload = new JsonObject();
            JsonArray actions = new JsonArray();
            payload.add("actions", actions);
            for (Map.Entry<String, IndexAliasDefinition> entry : aliases.entrySet()) {
                JsonObject action = new JsonObject();
                JsonObject aliasDefinition = gson.toJsonTree(entry.getValue()).getAsJsonObject();
                action.add("add", aliasDefinition);
                aliasDefinition.addProperty("index", indexName);
                aliasDefinition.addProperty("alias", entry.getKey());
                actions.add(action);
            }
            return payload;
        }
    }
}
