package algorithmia.ValidationValuePresent;

import com.algorithmia.algo.*;
import com.google.gson.*;

public class ValidationValuePresent {

    @AcceptsJson
    @ReturnsJson
    public JsonElement apply(String input) {
        OutputData outputData = parseAndRunValidationRule(input);
        return new JsonParser().parse(new Gson().toJson(outputData));
    }

    // Take any required source JSON, parse it into our data class, run the validation rule and then produce the output
    public OutputData parseAndRunValidationRule(String inputJson){
        OutputData outputData;
        try {
            InputData inputData = new Gson().fromJson(inputJson, InputData.class);
            outputData = runValidationRule(inputData);
        } catch (JsonSyntaxException e) {
            outputData = new OutputData(null,null,null,"Error parsing source JSON: " + inputJson);
        } catch (Exception e) {
            outputData = new OutputData(null,null,null,"Miscellaneous error parsing JSON input parameters: " + inputJson);
        }
        return outputData;
    }

    // Take the given data and invoke the validation rule
    public OutputData runValidationRule(InputData inputData){
        RuleValuePresent rule = new RuleValuePresent(inputData);
        return new OutputData(rule.getValueFormula(),rule.run(),inputData.getMetaData(),null);
    }

}
