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

package org.cloudfoundry.reactor.doppler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.cloudfoundry.Validatable;
import org.cloudfoundry.reactor.util.AbstractReactorOperations;
import org.cloudfoundry.reactor.util.AuthorizationProvider;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import reactor.core.tuple.Tuple2;
import reactor.io.netty.http.HttpClient;
import reactor.io.netty.http.HttpInbound;

import java.util.function.Consumer;

abstract class AbstractDopplerOperations extends AbstractReactorOperations {

    AbstractDopplerOperations(AuthorizationProvider authorizationProvider, HttpClient httpClient, ObjectMapper objectMapper, Mono<String> root) {
        super(authorizationProvider, httpClient, objectMapper, root);
    }

    @Override
    protected final <REQ extends Validatable, RSP> Mono<RSP> delete(REQ request, Class<RSP> responseType, Consumer<Tuple2<UriComponentsBuilder, REQ>> builderCallback) {
        return super.delete(request, responseType, builderCallback);
    }

    @Override
    protected final <REQ extends Validatable, RSP> Mono<RSP> get(REQ request, Class<RSP> responseType, Consumer<Tuple2<UriComponentsBuilder, REQ>> builderCallback) {
        return super.get(request, responseType, builderCallback);
    }

    @Override
    protected final <REQ extends Validatable> Mono<HttpInbound> get(REQ request, Consumer<Tuple2<UriComponentsBuilder, REQ>> builderCallback) {
        return super.get(request, builderCallback);
    }

    @Override
    protected final <REQ extends Validatable, RSP> Mono<RSP> post(REQ request, Class<RSP> responseType, Consumer<Tuple2<UriComponentsBuilder, REQ>> builderCallback) {
        return super.post(request, responseType, builderCallback);
    }

    @Override
    protected final <REQ extends Validatable, RSP> Mono<RSP> put(REQ request, Class<RSP> responseType, Consumer<Tuple2<UriComponentsBuilder, REQ>> builderCallback) {
        return super.put(request, responseType, builderCallback);
    }

    @Override
    protected final <REQ extends Validatable> Mono<HttpInbound> ws(REQ request, Consumer<Tuple2<UriComponentsBuilder, REQ>> builderCallback) {
        return super.ws(request, builderCallback);
    }

}