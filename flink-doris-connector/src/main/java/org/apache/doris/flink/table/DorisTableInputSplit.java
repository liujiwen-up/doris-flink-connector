// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.flink.table;

import org.apache.flink.core.io.InputSplit;

import org.apache.doris.flink.rest.PartitionDefinition;

/** DorisTableInputSplit. */
public class DorisTableInputSplit implements InputSplit, java.io.Serializable {

    /** The number of the split. */
    private final int splitNumber;

    protected final PartitionDefinition partition;

    public DorisTableInputSplit(int splitNumber, PartitionDefinition partition) {
        super();
        this.splitNumber = splitNumber;
        this.partition = partition;
    }

    @Override
    public int getSplitNumber() {
        return splitNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "DorisTableInputSplit: %s.%s,id=%s,be=%s,tablets=%s",
                partition.getDatabase(),
                partition.getTable(),
                splitNumber,
                partition.getBeAddress(),
                partition.getTabletIds());
    }
}
