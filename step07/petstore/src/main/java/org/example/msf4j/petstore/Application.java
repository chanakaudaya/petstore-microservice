/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.example.msf4j.petstore;

import org.example.msf4j.petstore.exception.DuplicatePetMapper;
import org.example.msf4j.petstore.exception.EntityNotFoundMapper;
import org.example.msf4j.petstore.exception.PetNotFoundMapper;
import org.wso2.msf4j.MicroservicesRunner;
import org.wso2.msf4j.security.oauth2.OAuth2SecurityInterceptor;

/**
 * Application entry point.
 *
 * @since 1.0.0
 */
public class Application {
    public static void main(String[] args) {

        String authServerURL = System.getProperty("AUTH_SERVER_URL");
        if (authServerURL == null || authServerURL.equals("")) {
            System.setProperty("AUTH_SERVER_URL", "http://localhost:9763/introspect");
        }

        new MicroservicesRunner()
                .addInterceptor(new OAuth2SecurityInterceptor())
                .addExceptionMapper(new EntityNotFoundMapper(), new PetNotFoundMapper(), new DuplicatePetMapper())
                .deploy(new PetService())
                .start();
    }
}
