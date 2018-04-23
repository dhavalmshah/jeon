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

import io.github.ma1uta.matrix.EmptyResponse;
import io.github.ma1uta.matrix.client.model.account.DeactivateRequest;
import io.github.ma1uta.matrix.client.model.account.PasswordRequest;
import io.github.ma1uta.matrix.client.model.account.RegisterRequest;
import io.github.ma1uta.matrix.client.model.account.RequestToken;
import io.github.ma1uta.matrix.client.model.account.ThreePidRequest;
import io.github.ma1uta.matrix.client.model.account.ThreePidResponse;
import io.github.ma1uta.matrix.client.model.account.WhoamiResponse;
import io.github.ma1uta.matrix.client.model.auth.LoginResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Account registration and management.
 * <p/>
 * <a href="https://matrix.org/docs/spec/client_server/r0.3.0.html#account-registration-and-management">Specification.</a>
 *
 * @author ma1uta
 * @version 0.0.1
 */
@Path("/_matrix/client/r0")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AccountApi {

    /**
     * The kind of account to register.
     */
    class RegisterType {

        private RegisterType() {
        }

        /**
         * Guest.
         */
        public static final String GUEST = "guest";

        /**
         * User. Default.
         */
        public static final String USER = "user";
    }

    /**
     * Register for an account on this homeserver.
     * <p/>
     *
     * @param kind            The kind of account to register. Defaults to user. One of: ["guest", "user"].
     * @param registerRequest JSON body parameters.
     * @return <p>Status code 200: The account has been registered.</p>
     * <p>Status code 400: Part of the request was invalid. This may include one of the following error codes:
     * <ul>
     * <li>M_USER_IN_USE : The desired user ID is already taken.</li>
     * <li>M_INVALID_USERNAME : The desired user ID is not a valid user name.</li>
     * <li>M_EXCLUSIVE : The desired user ID is in the exclusive namespace claimed by an application service.</li>
     * </ul>
     * </p>
     * <p>
     * These errors may be returned at any stage of the registration process, including after authentication
     * if the requested user ID was registered whilst the client was performing authentication.
     * </p>
     * <p>
     * Homeservers MUST perform the relevant checks and return these codes before performing User-Interactive Authentication,
     * although they may also return them after authentication is completed if, for example,
     * the requested user ID was registered whilst the client was performing authentication.
     * </p>
     * <p>Status code 401: The homeserver requires additional authentication information.</p>
     * <p>Status code 429: This request was rate-limited.</p>
     * @see <a href="https://matrix.org/docs/spec/client_server/r0.3.0.html#id147">Register for an account on this homeserver.</a>
     */
    @POST
    @Path("/register")
    LoginResponse register(@QueryParam("kind") String kind, RegisterRequest registerRequest);

    /**
     * Proxies the identity server API validate/email/requestToken, but first checks that the given email address is not already
     * associated with an account on this Home Server. Note that, for consistency, this API takes JSON objects, though the
     * Identity Server API takes x-www-form-urlencoded parameters. See the Identity Server API for further information.
     *
     * @param requestToken request.
     * @return <p>Status code 200: An email has been sent to the specified address. Note that this may be an email containing the
     * validation token or it may be informing the user of an error.</p>
     * <p>Status code 400: Part of the request was invalid. This may include one of the following error codes:
     * <ul>
     * <li>M_THREEPID_IN_USE : The email address is already registered to an account on this server.
     * However, if the home server has the ability to send email, it is recommended that the server instead send an email to
     * the user with instructions on how to reset their password. This prevents malicious parties from being able to determine
     * if a given email address has an account on the Home Server in question.</li>
     * <li>M_SERVER_NOT_TRUSTED : The id_server parameter refers to an ID server that is not trusted by this Home Server.</li>
     * </ul>
     * </p>
     */
    @POST
    @Path("/register/email/requestToken")
    EmptyResponse requestToken(RequestToken requestToken);

    /**
     * Changes the password for an account on this homeserver.
     * <p/>
     * This API endpoint uses the User-Interactive Authentication API.
     * <p/>
     * An access token should be submitted to this endpoint if the client has an active session.
     * <p/>
     * The homeserver may change the flows available depending on whether a valid access token is provided.
     *
     * @param passwordRequest password.
     * @return <p>Status code 200: The password has been changed.</p>
     * <p>Status code 401: The homeserver requires additional authentication information.</p>
     * <p>Status code 429: This request was rate-limited.</p>
     */
    @POST
    @Path("/account/password")
    EmptyResponse password(PasswordRequest passwordRequest);

    /**
     * Proxies the identity server API validate/email/requestToken, but first checks that the given email address is associated
     * with an account on this Home Server. This API should be used to request validation tokens when authenticating for
     * the account/password endpoint. This API's parameters and response are identical to that of the HS API
     * /register/email/requestToken except that M_THREEPID_NOT_FOUND may be returned if no account matching the given email
     * address could be found. The server may instead send an email to the given address prompting the user to create an account.
     * M_THREEPID_IN_USE may not be returned.
     *
     * @return Status code 200: An email was sent to the given address.
     */
    @POST
    @Path("/account/password/email/requestToken")
    EmptyResponse passwordRequestToken();

    /**
     * Deactivate the user's account, removing all ability for the user to login again.
     * <p/>
     * This API endpoint uses the User-Interactive Authentication API.
     * <p/>
     * An access token should be submitted to this endpoint if the client has an active session.
     * <p/>
     * The homeserver may change the flows available depending on whether a valid access token is provided.
     *
     * @param deactivateRequest request.
     * @return <p>Status code 200: The account has been deactivated.</p>
     * <p>Status code 401: The homeserver requires additional authentication information.</p>
     * <p>Status code 429: This request was rate-limited.</p>
     */
    @POST
    @Path("/account/deactivate")
    EmptyResponse deactivate(DeactivateRequest deactivateRequest);

    /**
     * Gets a list of the third party identifiers that the homeserver has associated with the user's account.
     * <p/>
     * This is not the same as the list of third party identifiers bound to the user's Matrix ID in Identity Servers.
     * <p/>
     * Identifiers in this list may be used by the homeserver as, for example, identifiers that it will accept to reset the user's
     * account password.
     *
     * @return Status code 200: The lookup was successful.
     */
    @GET
    @Path("/account/3pid")
    ThreePidResponse showThreePid();

    /**
     * Adds contact information to the user's account.
     *
     * @param threePidRequest new contact information.
     * @return <p>Status code 200: The addition was successful.</p>
     * <p>Status code 403: The credentials could not be verified with the identity server.</p>
     */
    @POST
    @Path("/account/3pid")
    EmptyResponse updateThreePid(ThreePidRequest threePidRequest);

    /**
     * Proxies the identity server API validate/email/requestToken, but first checks that the given email address is not already
     * associated with an account on this Home Server. This API should be used to request validation tokens when adding an email
     * address to an account. This API's parameters and response is identical to that of the HS API /register/email/requestToken endpoint.
     *
     * @return Status code 200: An email was sent to the given address.
     */
    @POST
    @Path("/account/3pid/email/requestToken")
    EmptyResponse threePidRequestToken();

    /**
     * Gets information about the owner of a given access token.
     *
     * @return Status code 200: The token belongs to a known user.
     */
    @GET
    @Path("/account/whoami")
    WhoamiResponse whiami();
}
