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

import io.github.ma1uta.matrix.event.content.CallAnswerContent;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Message Event.
 * <p>
 * This event is sent by the callee when they wish to answer the call.
 * </p>
 */
@Schema(
    description = "This event is sent by the callee when they wish to answer the call."
)
public class CallAnswer extends RoomEvent<CallAnswerContent> {

    /**
     * This event is sent by the callee when they wish to answer the call.
     */
    public static final String TYPE = "m.call.answer";

    @Override
    public String getType() {
        return TYPE;
    }
}
