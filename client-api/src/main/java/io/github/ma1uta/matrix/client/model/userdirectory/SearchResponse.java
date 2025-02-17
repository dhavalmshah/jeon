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

package io.github.ma1uta.matrix.client.model.userdirectory;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * JSON body response for user directory api (search result).
 */
@Schema(
    description = "JSON body response for user directory api (search result)."
)
public class SearchResponse {

    /**
     * Required. Ordered by rank and then whether or not profile info is available.
     */
    @Schema(
        description = "Ordered by rank and then whether or not profile info is available."
    )
    private List<User> results;

    /**
     * Required. Indicates if the result list has been truncated by the limit.
     */
    @Schema(
        description = "Indicates if the result list has been truncated by the limit."
    )
    private Boolean limit;

    public List<User> getResults() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }

    public Boolean getLimit() {
        return limit;
    }

    public void setLimit(Boolean limit) {
        this.limit = limit;
    }
}
