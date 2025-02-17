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

package io.github.ma1uta.matrix.application.model;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * JSON body request of the room service api.
 */
@Schema(
    description = "JSON body request of the room service api."
)
public class RoomVisibility {

    /**
     * Required. Whether the room should be visible (public) in the directory or not (private). One of: ["public", "private"].
     */
    @Schema(
        description = "Whether the room should be visible (public) in the directory or not (private).",
        required = true,
        allowableValues = {"public", "private"}
    )
    private String visibility;

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
