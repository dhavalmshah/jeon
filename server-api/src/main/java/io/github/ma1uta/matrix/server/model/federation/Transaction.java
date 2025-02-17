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

package io.github.ma1uta.matrix.server.model.federation;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.ma1uta.matrix.server.model.federation.edu.EphemeralDataUnit;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import javax.json.bind.annotation.JsonbProperty;

/**
 * The transfer of EDUs and PDUs between homeservers is performed by an exchange of Transaction messages, which are encoded as
 * JSON objects, passed over an HTTP PUT request. A Transaction is meaningful only to the pair of homeservers that exchanged it;
 * they are not globally-meaningful.
 * <br>
 * Each transaction has:
 * <ul>
 * <li>An opaque transaction ID, unique among transactions from the same origin.</li>
 * <li>A timestamp (UNIX epoch time in milliseconds) generated by its origin server.</li>
 * <li>An origin and destination server name.</li>
 * <li>A list of PDUs and EDUs - the actual message payload that the Transaction carries.</li>
 * </ul>
 */
@Schema(
    description = "Transaction for Federation API."
)
public class Transaction {

    /**
     * Required. server_name of homeserver sending this transaction.
     */
    @Schema(
        description = "server_name of homeserver sending this transaction.",
        required = true
    )
    private String origin;

    /**
     * Required. Timestamp in milliseconds on originating homeserver when this transaction started.
     */
    @Schema(
        name = "origin_server_ts",
        description = "Timestamp in milliseconds on originating homeserver when this transaction started.",
        required = true
    )
    @JsonbProperty("origin_server_ts")
    private Long originServerTs;

    /**
     * Required. List of persistent updates to rooms.
     */
    @Schema(
        description = "List of persistent updates to rooms.",
        required = true
    )
    private List<PersistedDataUnit> pdus;

    /**
     * List of ephemeral messages. May be omitted if there are no ephemeral messages to be sent.
     */
    @Schema(
        description = "List of ephemeral messages. May be omitted if there are no ephemeral messages to be sent."
    )
    private List<EphemeralDataUnit> edus;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @JsonProperty("origin_server_ts")
    public Long getOriginServerTs() {
        return originServerTs;
    }

    public void setOriginServerTs(Long originServerTs) {
        this.originServerTs = originServerTs;
    }

    public List<PersistedDataUnit> getPdus() {
        return pdus;
    }

    public void setPdus(List<PersistedDataUnit> pdus) {
        this.pdus = pdus;
    }

    public List<EphemeralDataUnit> getEdus() {
        return edus;
    }

    public void setEdus(List<EphemeralDataUnit> edus) {
        this.edus = edus;
    }
}
