/*
 *   Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *   WSO2 Inc. licenses this file to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.ballerinalang.regex;


import org.ballerinalang.bre.Context;
import org.ballerinalang.bre.bvm.BlockingNativeCallableUnit;
import org.ballerinalang.model.types.TypeKind;
import org.ballerinalang.model.values.BBoolean;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.ReturnType;

import java.util.regex.Pattern;

/**
 * Implementation of ballerina native function of regex:matches
 */
@BallerinaFunction(
        orgName = "wso2", packageName = "regex",
        functionName = "matches",
        args = {@Argument(name = "pattern", type = TypeKind.STRING), @Argument(name = "input", type = TypeKind.STRING)},
        returnType = {@ReturnType(type = TypeKind.BOOLEAN)},
        isPublic = true
)
public class Matches extends BlockingNativeCallableUnit {

    @Override
    public void execute(Context context) {
        String pattern = context.getStringArgument(0);
        String input = context.getStringArgument(1);

        boolean match = Pattern.matches(pattern, input);
        context.setReturnValues(new BBoolean(match));
    }
}
