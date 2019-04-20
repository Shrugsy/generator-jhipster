<%#
    Copyright 2019-Present the original author or authors from the JHipster project.

    This file is part of the JHipster project, see http://www.jhipster.tech/
    for more information.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
-%>
package <%=packageName%>.web.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Resource to return information about OIDC properties
 */
@RestController
@RequestMapping("/api")
public class AuthInfoResource {

    @Value("${spring.security.oauth2.client.provider.oidc.issuer-uri:}")
    private String issuer;
    @Value("${spring.security.oauth2.client.registration.oidc.client-id:}")
    private String clientId;


    @GetMapping("/auth-info")
    public AuthInfoVM getAuthInfo() {
        return new AuthInfoVM(issuer, clientId);
    }

    class AuthInfoVM {
        private String issuer;
        private String clientId;

        AuthInfoVM(String issuer, String clientId) {
            this.issuer = issuer;
            this.clientId = clientId;
        }

        public String getIssuer() {
            return this.issuer;
        }

        public void setIssuer(String issuer) {
            this.issuer = issuer;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }
    }
}
