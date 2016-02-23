/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.operations.services;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.cloudfoundry.Validatable;
import org.cloudfoundry.ValidationResult;

import java.util.Map;

/**
 * The request options for the bind service operation
 */
@Data
public final class BindServiceRequest implements Validatable {

    /**
     * The name of the application to bind
     *
     * @param applicationName the name of the application
     * @return the name of the application
     */
    private final String applicationName;

    /**
     * The name of the service to bind
     *
     * @param serviceName the name of the service
     * @return the name of the service
     */
    private final String serviceName;

    /**
     * The parameters for the service binding
     *
     * @param parameters the service binding parameters 
     * @return the service binding parameters
     */
    private final Map<String, Object> parameters;

    @Builder
    BindServiceRequest(String applicationName, String serviceName, @Singular Map<String, Object> parameters) {
        this.applicationName = applicationName;
        this.serviceName = serviceName;
        this.parameters = parameters;
    }

    @Override
    public ValidationResult isValid() {
        ValidationResult.ValidationResultBuilder builder = ValidationResult.builder();

        if (this.applicationName == null) {
            builder.message("application name must be specified");
        }

        if (this.serviceName == null) {
            builder.message("service name must be specified");
        }

        return builder.build();
    }

}
