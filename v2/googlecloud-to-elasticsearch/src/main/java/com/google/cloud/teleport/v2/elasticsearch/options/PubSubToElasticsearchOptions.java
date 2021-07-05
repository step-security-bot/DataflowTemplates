/*
 * Copyright (C) 2021 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.teleport.v2.elasticsearch.options;

import com.google.cloud.teleport.v2.transforms.JavascriptTextTransformer;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.Validation;

/**
 * The {@link PubSubToElasticsearchOptions} class provides the custom execution options passed by
 * the executor at the command-line.
 *
 * <p>Inherits standard configuration options, options from {@link
 * JavascriptTextTransformer.JavascriptTextTransformerOptions}, and options from {@link ElasticsearchWriteOptions}.
 */
public interface PubSubToElasticsearchOptions
        extends JavascriptTextTransformer.JavascriptTextTransformerOptions, ElasticsearchWriteOptions {

    @Description(
            "The Cloud Pub/Sub subscription to consume from. "
                    + "The name should be in the format of "
                    + "projects/<project-id>/subscriptions/<subscription-name>.")
    String getInputSubscription();

    void setInputSubscription(String inputSubscription);

    @Description(
            "The dead-letter table to output to within BigQuery in <project-id>:<dataset>.<table> "
                    + "format.")
    @Validation.Required
    String getDeadletterTable();

    void setDeadletterTable(String deadletterTable);
}
