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

package io.github.ma1uta.matrix.client.model.account;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Response for gets a list of the third party identifiers that the homeserver has associated with the user's account.
 */
@ApiModel(description = "Response for gets a list of the third party identifiers that the homeserver has associated with the user's"
    + " account")
public class ThreePidResponse {

    /**
     * All 3Pids.
     */
    @ApiModelProperty(
        value = "All 3pids"
    )
    private ThirdPartyIdentifier[] threepids;

    public ThirdPartyIdentifier[] getThreepids() {
        return threepids;
    }

    public void setThreepids(ThirdPartyIdentifier[] threepids) {
        this.threepids = threepids;
    }
}
