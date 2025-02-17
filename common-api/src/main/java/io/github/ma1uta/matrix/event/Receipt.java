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

package io.github.ma1uta.matrix.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.ma1uta.matrix.event.content.ReceiptContent;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;

/**
 * A map of which rooms are considered 'direct' rooms for specific users is kept in account_data in an event of type m.direct.
 * The content of this event is an object where the keys are the user IDs and values are lists of room ID strings of the 'direct'
 * rooms for that user ID.
 * <p>
 * Map EVENT_ID -&gt; 'm.read' -&gt; USER_ID -&gt; ts: long
 * </p>
 */
@Schema(
    description = "A map of which rooms are considered 'direct' rooms for specific users is kept in account_data in an"
        + " event of type m.direct. The content of this event is an object where the keys are the user IDs and values are lists"
        + " of room ID strings of the 'direct' rooms for that user ID."
)
public class Receipt extends Event<ReceiptContent> {

    /**
     * Informs the client of new receipts.
     */
    public static final String TYPE = "m.receipt";

    /**
     * Required. The ID of the room associated with this event.
     */
    @Schema(
        name = "room_id",
        description = "The ID of the room associated with this event.",
        required = true
    )
    @JsonbProperty("room_id")
    private String roomId;

    @JsonProperty("room_id")
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
