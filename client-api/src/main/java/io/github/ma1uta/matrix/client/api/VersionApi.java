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

package io.github.ma1uta.matrix.client.api;

import io.github.ma1uta.matrix.client.model.version.VersionsResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Gets the versions of the specification supported by the server.
 * <p/>
 * Values will take the form rX.Y.Z.
 * <p/>
 * Only the latest Z value will be reported for each supported X.Y value.
 * i.e. if the server implements r0.0.0, r0.0.1, and r1.2.0, it will report r0.0.1 and r1.2.0.
 * <p/>
 * <a href="https://matrix.org/docs/spec/client_server/r0.3.0.html#get-matrix-client-versions">Specification.</a>
 *
 * @author ma1uta
 */
@Path("/_matrix/client/versions")
public interface VersionApi {

    /**
     * Gets the versions of the specification supported by the server.
     *
     * @return Status code 200: The versions supported by the server.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    VersionsResponse versions();
}
