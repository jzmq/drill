/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.drill.exec.vector.complex.reader;

import org.apache.drill.exec.vector.UntypedReader;
import org.apache.drill.exec.vector.complex.reader.BaseReader.ListReader;
import org.apache.drill.exec.vector.complex.reader.BaseReader.MapReader;
import org.apache.drill.exec.vector.complex.reader.BaseReader.RepeatedListReader;
import org.apache.drill.exec.vector.complex.reader.BaseReader.RepeatedMapReader;
import org.apache.drill.exec.vector.complex.reader.BaseReader.DictReader;
import org.apache.drill.exec.vector.complex.reader.BaseReader.ScalarReader;

public interface FieldReader extends MapReader, DictReader, ListReader, ScalarReader, RepeatedMapReader, RepeatedListReader, UntypedReader {

  /**
   * Returns {@code String} representation of the reader's type. In case if {@link #getType()} is primitive,
   * the method is equivalent to {@link #getType().getMinorType().name()}. If the reader has minor type equal to
   * {@link org.apache.drill.common.types.TypeProtos.MinorType#DICT}, {@code DICT&lt;keyMinorType,valueMinorType&gt;},
   * with {@code keyMinorType} and {@code valueMinorType} being key's and value's minor types respectively,
   * will be returned. Used in {@code typeOf} UDF.
   *
   * @return {@code String} representation of reader's type.
   */
  String getTypeString();
}
