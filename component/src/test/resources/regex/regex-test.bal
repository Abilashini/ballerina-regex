import wso2/regex;

function testRegex() returns (boolean) {
    string pattern = "[a-zA-Z0-9]{6}";
    string input = "hello1";
    return regex:matches(pattern, input);
}

function testRegexFalseCase() returns (boolean) {
    string pattern = "[a-zA-Z0-9]{6}";
    string input = "hello123";
    return regex:matches(pattern, input);
}


