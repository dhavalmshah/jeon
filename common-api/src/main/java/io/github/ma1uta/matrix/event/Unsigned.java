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
import io.github.ma1uta.matrix.event.content.EventContent;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import javax.json.bind.annotation.JsonbProperty;

/**
 * UnsignedData.
 *
 * @param <C> Type of the event content.
 */
@Schema(
    description = "Unsigned addition data."
)
public class Unsigned<C extends EventContent> {

    /**
     * The time in milliseconds that has elapsed since the event was sent. This field is generated by the local homeserver, and may
     * be incorrect if the local time on at least one of the two servers is out of sync, which can cause the age to either be negative
     * or greater than it actually is.
     */
    @Schema(
        description = "The time in milliseconds that has elapsed since the event was sent. This field is generated by the local "
            + "homeserver, and may be incorrect if the local time on at least one of the two servers is out of sync, which can cause "
            + "the age to either be negative or greater than it actually is."
    )
    private Long age;

    /**
     * Optional. The event that redacted this event, if any.
     */
    @Schema(
        name = "redacted_because",
        description = "The event that redacted this event, if any."
    )
    @JsonbProperty("redacted_because")
    private Event redactedBecause;

    /**
     * The client-supplied transaction ID, if the client being given the event is the same one which sent it.
     */
    @Schema(
        name = "transaction_id",
        description = "The client-supplied transaction ID, if the client being given the event is the same one which sent it."
    )
    @JsonbProperty("transaction_id")
    private String transactionId;

    /**
     * Optional. The previous content for this state. This will be present only for state events appearing in the timeline.
     * If this is not a state event, or there is no previous content, this key will be missing.
     */
    @Schema(
        name = "prev_content",
        description = "The previous content for this state. This will be present only for state events "
            + "appearing in the timeline. If this is not a state event, or there is no previous content, this key will be missing."
    )
    @JsonbProperty("prev_content")
    private C prevContent;

    /**
     * This contains an array of StrippedState Events. These events provide information on a subset of state events such as the room name.
     */
    @Schema(
        name = "invite_room_state",
        description = "This contains an array of StrippedState Events. These events provide information on a subset of state events"
            + " such as the room name."
    )
    @JsonbProperty("invite_room_state")
    private List<Event> inviteRoomState;

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @JsonProperty("redacted_because")
    public Event getRedactedBecause() {
        return redactedBecause;
    }

    public void setRedactedBecause(Event redactedBecause) {
        this.redactedBecause = redactedBecause;
    }

    @JsonProperty("transaction_id")
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @JsonProperty("prev_content")
    public C getPrevContent() {
        return prevContent;
    }

    public void setPrevContent(C prevContent) {
        this.prevContent = prevContent;
    }

    @JsonProperty("invite_room_state")
    public List<Event> getInviteRoomState() {
        return inviteRoomState;
    }

    public void setInviteRoomState(List<Event> inviteRoomState) {
        this.inviteRoomState = inviteRoomState;
    }
}
