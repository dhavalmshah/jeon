/*
 * Copyright sablintolya@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.ma1uta.matrix.client.model.search;

import io.github.ma1uta.matrix.event.Event;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Search result.
 */
@Schema(
    description = "Search result."
)
public class Result {

    /**
     * A number that describes how closely this result matches the search. Higher is closer.
     */
    @Schema(
        description = "A number that describes how closely this result matches the search. Higher is closer."
    )
    private Long rank;

    /**
     * The event that matched.
     */
    @Schema(
        description = "The event that matched."
    )
    private Event result;

    /**
     * Context for result, if requested.
     */
    @Schema(
        description = "Context for result, if requested."
    )
    private EventContextResponse context;

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Event getResult() {
        return result;
    }

    public void setResult(Event result) {
        this.result = result;
    }

    public EventContextResponse getContext() {
        return context;
    }

    public void setContext(EventContextResponse context) {
        this.context = context;
    }
}
