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
import io.github.ma1uta.matrix.server.model.federation.edu.content.nested.DeviceKeys;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;

/**
 * User device.
 */
@Schema(
    description = "user device."
)
public class UserDevice {

    /**
     * Required. The device ID.
     */
    @Schema(
        name = "device_id",
        description = "The device ID.",
        required = true
    )
    @JsonbProperty("device_id")
    private String deviceId;

    /**
     * Required. Identity keys for the device.
     */
    @Schema(
        description = "Identity keys for the device.",
        required = true
    )
    private DeviceKeys keys;

    /**
     * Optional display name for the device.
     */
    @Schema(
        name = "device_display_name",
        description = "Optional display name for the device."
    )
    @JsonbProperty("device_display_name")
    private String deviceDisplayName;

    @JsonProperty("device_id")
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public DeviceKeys getKeys() {
        return keys;
    }

    public void setKeys(DeviceKeys keys) {
        this.keys = keys;
    }

    @JsonProperty("device_display_name")
    public String getDeviceDisplayName() {
        return deviceDisplayName;
    }

    public void setDeviceDisplayName(String deviceDisplayName) {
        this.deviceDisplayName = deviceDisplayName;
    }
}
