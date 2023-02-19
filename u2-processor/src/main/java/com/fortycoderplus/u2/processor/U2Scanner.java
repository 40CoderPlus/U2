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

import com.fortycoderplus.u2.core.Unified;
import com.fortycoderplus.u2.core.UnifiedUdf;
import com.fortycoderplus.u2.core.UnifiedUdfScanner;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;

public class U2Scanner implements UnifiedUdfScanner {

    @Override
    public List<Class<UnifiedUdf>> scan(ClassLoader classLoader, String... basePackages) {
        ConfigurationBuilder builder =
                new ConfigurationBuilder().addClassLoaders(classLoader).forPackages(basePackages);
        Reflections reflections = new Reflections(builder);
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Unified.class);
        return annotated.stream()
                .filter(Class::isInterface)
                .filter(UnifiedUdf.class::isAssignableFrom)
                .map(c -> (Class<UnifiedUdf>) c)
                .collect(Collectors.toList());
    }
}
