package algorithmia.validationvaluepresent;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidationValuePresentTest {

    private final ValidationValuePresent underTest;

    public ValidationValuePresentTest() {
        underTest = new ValidationValuePresent();
    }

    @Test
    public void testValidationValuePresent() throws Exception {
        assertThat(underTest.apply("Bob"), equalTo("Hello Bob"));
    }
}
