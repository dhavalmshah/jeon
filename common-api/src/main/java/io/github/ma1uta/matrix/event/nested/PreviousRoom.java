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

package io.github.ma1uta.matrix.event.nested;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;

/**
 * A reference to the room this room replaces, if the previous room was upgraded.
 */
@Schema(
    description = "A reference to the room this room replaces, if the previous room was upgraded."
)
public class PreviousRoom {

    /**
     * Required. The ID of the old room.
     */
    @Schema(
        name = "room_id",
        description = "The ID of the old room.",
        required = true
    )
    @JsonbProperty("room_id")
    private String roomId;

    /**
     * Required. The event ID of the last known event in the old room.
     */
    @Schema(
        name = "event_id",
        description = "The event ID of the last known event in the old room.",
        required = true
    )
    @JsonbProperty("event_id")
    private String eventId;

    @JsonProperty("room_id")
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @JsonProperty("event_id")
    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
