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
package org.ballerinalang.test.regex;

import org.ballerinalang.launcher.util.BCompileUtil;
import org.ballerinalang.launcher.util.BRunUtil;
import org.ballerinalang.launcher.util.CompileResult;
import org.ballerinalang.model.values.BString;
import org.ballerinalang.model.values.BValue;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Test regex package for ballerina
 */
public class BallerinaRegexTest {
    private CompileResult compileResult;

    @BeforeClass
    public void setup() {
        compileResult = BCompileUtil.compile("regex/regex-test.bal");
    }

    @Test
    public void testRegexForAlphabeticValues() {
        BValue[] input = {new BString("Hello")};
        BValue[] returns = BRunUtil.invoke(compileResult, "testRegexForAlphabeticValues", input);
        Assert.assertTrue(new Boolean(returns[0].toString()));
    }

    @Test
    public void testRegexForAlphabeticValuesFalseCase() {
        BValue[] input = {new BString("Hello123")};
        BValue[] returns = BRunUtil.invoke(compileResult, "testRegexForAlphabeticValues", input);
        Assert.assertFalse(new Boolean(returns[0].toString()));
    }

    @Test
    public void testRegexForAlphaNumericValues() {
        BValue[] input = {new BString("hello123")};
        BValue[] returns = BRunUtil.invoke(compileResult, "testRegexForAlphaNumericValues", input);
        Assert.assertTrue(new Boolean(returns[0].toString()));
    }

    @Test
    public void testRegexForAlphaNumericValuesFalseCase() {
        BValue[] input = {new BString("hello_123")};
        BValue[] returns = BRunUtil.invoke(compileResult, "testRegexForAlphaNumericValues", input);
        Assert.assertFalse(new Boolean(returns[0].toString()));
    }

    @Test
    public void testRegexforNumericValues() {
        BValue[] input = {new BString("2.4")};
        BValue[] returns = BRunUtil.invoke(compileResult, "testRegexForNumericValues", input);
        Assert.assertTrue(new Boolean(returns[0].toString()));
    }

    @Test
    public void testRegexforNumericValuesFalseCase() {
        BValue[] input = {new BString("$2.4")};
        BValue[] returns = BRunUtil.invoke(compileResult, "testRegexForNumericValues", input);
        Assert.assertFalse(new Boolean(returns[0].toString()));
    }

    @Test
    public void testRegexForSpecialCharacters() {
        BValue[] input = {new BString("*")};
        BValue[] returns = BRunUtil.invoke(compileResult, "testRegexForSpecialCharacters", input);
        Assert.assertTrue(new Boolean(returns[0].toString()));
    }

    @Test
    public void testRegexForSpecialCharactersFalseCase() {
        BValue[] input = {new BString("a")};
        BValue[] returns = BRunUtil.invoke(compileResult, "testRegexForSpecialCharacters", input);
        Assert.assertFalse(new Boolean(returns[0].toString()));
    }
}
