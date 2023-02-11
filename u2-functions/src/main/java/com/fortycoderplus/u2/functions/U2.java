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

package com.fortycoderplus.u2.functions;

import com.fortycoderplus.u2.core.Category;
import com.fortycoderplus.u2.core.Kind;
import com.fortycoderplus.u2.core.UnifiedUdf0;
import java.util.Set;

public interface U2 extends UnifiedUdf0<String> {

    @Override
    default Kind kind() {
        return Kind.SCALAR;
    }

    @Override
    default Set<Category> categories() {
        return Set.of(Category.MISC);
    }

    @Override
    default String call() {
        return "U2";
    }
}
