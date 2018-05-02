# ballerina-regex

Ballerina 'regex' is a package to enable regular expressions in a ballerina program. 

## Configuration Steps

1. Get a clone or download the source from this repository.
2. Perform a Maven build using the following command.
        
        mvn clean install
3. Copy `ballerina-regex/component/target/ballerina-regex-1.0-SNAPSHOT.jar` to `<ballerina_home>/bre/lib`

### Try out the sample

    import ballerina/io;
    import wso2/regex;
    
    function main(string... args) {
        string pattern = "^[a-zA-Z0-9]+$";
        string input1 = "hello123";
        string input2 = "hello_123";
        io:println(regex:matches(pattern, input1));
        io:println(regex:matches(pattern, input2));
    }

#### Output

    true
    false