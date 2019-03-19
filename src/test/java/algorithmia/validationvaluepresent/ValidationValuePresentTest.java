package algorithmia.validationvaluepresent;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidationValuePresentTest {

    @Test
    public void valueProvided_NotTriggered()  {
        String inputJson = "{\"value\":\"Banana\"}";
        String expectedJsonOutput =  "{\"valueFormula\":\"Banana != ''\",\"triggered\":true,\"metaData\":\"{}\"}";
        ValidationValuePresent algorithm = new ValidationValuePresent();
        String outputJson = algorithm.apply(inputJson).toString();
        assertEquals(expectedJsonOutput, outputJson);
    }

    @Test
    public void valueNotProvided_Triggered()  {
        String inputJson = "{\"value\":\"\"}";
        String expectedJsonOutput =  "{\"valueFormula\":\" != ''\",\"triggered\":false,\"metaData\":\"{}\"}";
        ValidationValuePresent algorithm = new ValidationValuePresent();
        String outputJson = algorithm.apply(inputJson).toString();
        assertEquals(expectedJsonOutput, outputJson);
    }

}
