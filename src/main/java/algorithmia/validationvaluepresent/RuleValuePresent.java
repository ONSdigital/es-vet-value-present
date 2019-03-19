package algorithmia.validationvaluepresent;

/**
 * Validation rule for Value Present.
 *
 * If the given value is not empty then this rule triggers and returns true, false otherwise
 *
 * Missing/invalid values are treated as blank
 *
 * @formula: formulaVariable != ""
 */
public class RuleValuePresent {

    private InputData inputData;

    public RuleValuePresent(InputData sourceInputData) {
        inputData = (sourceInputData == null) ? new InputData() : sourceInputData;
    }

    public String getValueFormula() {
        return getFormula(inputData.getValue());
    }

    private static String getFormula( String formulaVariable ) {
        return formulaVariable + " != ''";
    }

    public boolean run() {
        return !inputData.getValue().isEmpty();
    }

}