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

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Group.
 */
@Schema(
    description = "Group."
)
public class Group {

    /**
     * Room.
     */
    public static final String ROOM_ID = "room_id";

    /**
     * Sender.
     */
    public static final String SENDER = "sender";

    /**
     * Key that defines the group. One of: ["room_id", "sender"]
     */
    @Schema(
        description = "Key that defines the group."
    )
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
