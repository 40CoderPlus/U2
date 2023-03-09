/*
 * (c) Copyright 2023 40CoderPlus. All rights reserved.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fortycoderplus.u2.processor;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class U2Processor {

    public static void main(String[] args) throws IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("template/doris-scalar.mustache");
        mustache.execute(
                        new PrintWriter(System.out),
                        U2GenerationMeta.builder()
                                .packagePrefix("com.fortycoderplus.u2")
                                .udfName("U2")
                                .udfDescription("u2 sample function")
                                .udfVersion("1.0.0")
                                .imports(List.of("com.github.mustachejava.Mustache"))
                                .udfClass("com.fortycoderplus.u2.functions.U2")
                                .build())
                .flush();
    }
}
