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

package io.github.ma1uta.matrix.server.api;

import io.github.ma1uta.matrix.EmptyResponse;
import io.github.ma1uta.matrix.server.model.bind.OnBindRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * 3pid federation api.
 */
@Path("/_matrix/federation/v1/3pid")
public interface BindApi {

    /**
     * If the owner of that particular 3pid binds it with a Matrix user ID, the identity server will attempt to make an HTTP POST
     * to the Matrix user's homeserver.
     *
     * @param onBindRequest   request.
     * @param servletRequest  servlet request.
     * @param servletResponse servlet response.
     * @return Status code 200: success.
     */
    @Path("/onbind")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    EmptyResponse onBind(OnBindRequest onBindRequest, @Context HttpServletRequest servletRequest,
                         @Context HttpServletResponse servletResponse);
}
