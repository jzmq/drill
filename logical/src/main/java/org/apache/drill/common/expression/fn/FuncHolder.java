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
package org.apache.drill.common.expression.fn;

import org.apache.drill.common.expression.ExpressionPosition;
import org.apache.drill.common.expression.FunctionHolderExpression;
import org.apache.drill.common.expression.LogicalExpression;
import org.apache.drill.common.types.TypeProtos;

import java.util.List;

public interface FuncHolder {

  boolean isNested();

  FunctionHolderExpression getExpr(String name, List<LogicalExpression> args, ExpressionPosition pos);

  TypeProtos.MajorType getParamMajorType(int i);

  int getParamCount();

  /**
   * Checks that the current function holder stores output value
   * using field writer instead of vector holder.
   *
   * @return true if current function holder uses field writer to store the output value
   */
  boolean isComplexWriterFuncHolder();

}
