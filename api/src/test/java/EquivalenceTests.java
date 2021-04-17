import model.Operations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.function.BiFunction;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class EquivalenceTests extends TestBase {

    @ParameterizedTest(name = "{displayName} val1 = {0} val2 = {1}")
    @CsvFileSource(resources = "/testdata/add.csv", numLinesToSkip = 1)
    @DisplayName("/GET Checking add method")
    public void getCheckingAddMethod(Integer val1, Integer val2) {
        BiFunction<Integer, Integer, Integer> expectedResultFunction = Operations.ADD::getExpectedResult;
        getCalculation(Operations.ADD,val1,val2)
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/result.json"))
                .body("result", equalTo(expectedResultFunction.apply(val1, val2)));
    }

    @ParameterizedTest(name = "{displayName} val1 = {0} val2 = {1}")
    @CsvFileSource(resources = "/testdata/multiply.csv", numLinesToSkip = 1)
    @DisplayName("/GET Checking multiply method")
    public void getCheckingMultiplyMethod(Integer val1, Integer val2) {
        BiFunction<Integer, Integer, Integer> expectedResultFunction = Operations.MULTIPLY::getExpectedResult;
        getCalculation(Operations.MULTIPLY,val1,val2)
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/result.json"))
                .body("result", equalTo(expectedResultFunction.apply(val1, val2)));
    }

    @ParameterizedTest(name = "{displayName} val1 = {0} val2 = {1}")
    @CsvFileSource(resources = "/testdata/divide_positive.csv", numLinesToSkip = 1)
    @DisplayName("/GET Checking divide method - positive")
    public void getCheckingDivideMethodPositive(Integer val1, Integer val2) {
        BiFunction<Integer, Integer, Integer> expectedResultFunction = Operations.DIVIDE::getExpectedResult;
        getCalculation(Operations.DIVIDE,val1,val2)
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/result.json"))
                .body("result", equalTo(expectedResultFunction.apply(val1, val2)));
    }

    @ParameterizedTest(name = "{displayName} val1 = {0} val2 = {1}")
    @CsvFileSource(resources = "/testdata/divide_negative.csv", numLinesToSkip = 1)
    @DisplayName("/GET Checking divide method - negative")
    public void getCheckingDivideMethodNegative(Integer val1, Integer val2) {
        getCalculation(Operations.DIVIDE,val1,val2)
                .assertThat()
                .statusCode(422);
    }

    @ParameterizedTest(name = "{displayName} val1 = {0} val2 = {1}")
    @CsvFileSource(resources = "/testdata/subtract.csv", numLinesToSkip = 1)
    @DisplayName("/GET Checking subtract method")
    public void getCheckingSubtractMethod(Integer val1, Integer val2) {
        BiFunction<Integer, Integer, Integer> expectedResultFunction = Operations.SUBTRACT::getExpectedResult;
        getCalculation(Operations.SUBTRACT,val1,val2)
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/result.json"))
                .body("result", equalTo(expectedResultFunction.apply(val1, val2)));
    }

    @ParameterizedTest(name = "{displayName} val1 = {0} val2 = {1}")
    @CsvFileSource(resources = "/testdata/add.csv", numLinesToSkip = 1)
    @DisplayName("/POST Checking add method")
    public void postCheckingAddMethod(Integer val1, Integer val2) {
        BiFunction<Integer, Integer, Integer> expectedResultFunction = Operations.ADD::getExpectedResult;
        postCalculation(Operations.ADD,val1,val2)
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/result.json"))
                .body("result", equalTo(expectedResultFunction.apply(val1, val2)));
    }

    @ParameterizedTest(name = "{displayName} val1 = {0} val2 = {1}")
    @CsvFileSource(resources = "/testdata/multiply.csv", numLinesToSkip = 1)
    @DisplayName("/POST Checking multiply method")
    public void postCheckingMultiplyMethod(Integer val1, Integer val2) {
        BiFunction<Integer, Integer, Integer> expectedResultFunction = Operations.MULTIPLY::getExpectedResult;
        postCalculation(Operations.MULTIPLY,val1,val2)
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/result.json"))
                .body("result", equalTo(expectedResultFunction.apply(val1, val2)));
    }

    @ParameterizedTest(name = "{displayName} val1 = {0} val2 = {1}")
    @CsvFileSource(resources = "/testdata/divide_positive.csv", numLinesToSkip = 1)
    @DisplayName("/POST Checking divide method - positive")
    public void postCheckingDivideMethodPositive(Integer val1, Integer val2) {
        BiFunction<Integer, Integer, Integer> expectedResultFunction = Operations.DIVIDE::getExpectedResult;
        postCalculation(Operations.DIVIDE,val1,val2)
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/result.json"))
                .body("result", equalTo(expectedResultFunction.apply(val1, val2)));
    }

    @ParameterizedTest(name = "{displayName} val1 = {0} val2 = {1}")
    @CsvFileSource(resources = "/testdata/divide_negative.csv", numLinesToSkip = 1)
    @DisplayName("/POST Checking divide method - negative")
    public void postCheckingDivideMethodNegative(Integer val1, Integer val2) {
        postCalculation(Operations.DIVIDE,val1,val2)
                .assertThat()
                .statusCode(422);
    }

    @ParameterizedTest(name = "{displayName} val1 = {0} val2 = {1}")
    @CsvFileSource(resources = "/testdata/subtract.csv", numLinesToSkip = 1)
    @DisplayName("/POST Checking subtract method")
    public void postCheckingSubtractMethod(Integer val1, Integer val2) {
        BiFunction<Integer, Integer, Integer> expectedResultFunction = Operations.SUBTRACT::getExpectedResult;
        postCalculation(Operations.SUBTRACT,val1,val2)
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/result.json"))
                .body("result", equalTo(expectedResultFunction.apply(val1, val2)));
    }
}