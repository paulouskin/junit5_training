package by.paulouskin.hamcrest.examples;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersExamplesTest {

    @Test
    public void hamcrestCoreMatchers() {
        assertThat(false,describedAs("Anything is equals whatever we want",is(anything())));
    }

    @Test
    public void hamcrestLogicalMatchers() {
        String str = "Test Automation";
        String sub1 = "Test";
        String sub2 = "Luxoft";
        assertThat("Logical matchers assertions",str ,
                anyOf(
                        startsWith(sub1),
                        not(containsString(sub2))
                ));
    }

    @Test
    public void hamcrestObjectMatchers() {
        assertThat(ArrayList.class, typeCompatibleWith(List.class));
    }

    @Test
    public void hamcrestCollectionsMatchers() {
        List<String> strList = Arrays.asList("str1", "str2", "str3");
        String[] strArray = {"str1", "str2", "str3"};
        //array
        assertThat(strArray, is(arrayWithSize(3)));
        assertThat(strArray, hasItemInArray("str2"));
        assertThat("str2", isIn(strArray));
        assertThat(strArray, arrayContainingInAnyOrder("str1","str2","str3"));
        //list
        assertThat(strList, containsInAnyOrder("str1","str3","str2"));
        assertThat(strList, contains("str1","str2","str3"));
        assertThat(strList, not(contains("str4")));

    }


}
