import wso2/regex;

function testRegexForAlphabeticValues(string input) returns (boolean) {
    string pattern = "^[a-zA-Z]+$";
    return regex:matches(pattern, input);
}

function testRegexForAlphaNumericValues(string input) returns (boolean) {
    string pattern = "^[a-zA-Z0-9]+$";
    return regex:matches(pattern, input);
}

function testRegexForNumericValues(string input) returns (boolean) {
    string pattern = "^\\d+(\\.\\d+)?";
    return regex:matches(pattern, input);
}

function testRegexForSpecialCharacters(string input) returns (boolean) {
    string pattern = "[^\\w]";
    return regex:matches(pattern, input);
}




