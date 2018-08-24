package by.paulouskin.junit5.features;

import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;

@DisplayName("Test for Parameter Resolver API demonstration")
public class ParameterResolverTest {

    public ParameterResolverTest(TestInfo testInfo) {
        assertThat("Test for Parameter Resolver API demonstration",
                is(equalTo(testInfo.getDisplayName())));
    }

    @DisplayName("Test with TR and TI")
    @RepeatedTest(10)
    public void test_reporter_with_test_info_combination(TestInfo testInfo, TestReporter testReporter) {
        testReporter.publishEntry("test name", testInfo.getDisplayName());
        assertThat(testReporter, is(notNullValue()));
    }
}
