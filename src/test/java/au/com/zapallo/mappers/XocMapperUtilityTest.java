package au.com.zapallo.mappers;

import static org.junit.Assert.fail;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by aaron.spiteri on 19/02/2016.
 */

public class XocMapperUtilityTest {
    private enum FooTestClass implements XocMapperInterface<ArrayList<String>, ArrayList<String>>  {

        CASE1 {
            public void mapTo(ArrayList<String> inObj, ArrayList<String> outObj) {
                outObj.add(0, inObj.get(0));
            }

            public void mapFrom(ArrayList<String> outObj, ArrayList<String> inObj) {
                inObj.add(0, outObj.get(0));
            }
        },

        CASE2 {
            public void mapTo(ArrayList<String> inObj, ArrayList<String> outObj) {
                outObj.add(1, inObj.get(0));
            }

            public void mapFrom(ArrayList<String> outObj, ArrayList<String> inObj) {
                inObj.add(1, outObj.get(0));
            }
        };
    }

    @Test
    public void shouldCorrectlyMapObject() {
        ArrayList<String> inObj = new ArrayList<String>();
        ArrayList<String> outObj = new ArrayList<String>();

        try {
            inObj.add(0, "Hello");
            FooTestClass c1 = FooTestClass.CASE1;
            c1.mapTo(inObj, outObj);
            assertThat(outObj.get(0), is("Hello"));
        }
        catch (Exception e) {
            fail("exception was thrown");
        }
    }

    @Test
    public void shouldCorrectlyAssign() {

        ArrayList<String> inObj = new ArrayList<>();
        ArrayList<String> outObj = new ArrayList<>();
        FooTestClass foo = FooTestClass.CASE1;
        inObj.add(0, "Hello");

        try {
            XocMapperUtility<ArrayList<String>, ArrayList<String>, FooTestClass> xocMapperUtility = new XocMapperUtility<>(foo);
            xocMapperUtility.mapTo(inObj, outObj);
        }
        catch (Exception e) {
            System.out.printf("exception is thrown %s - %s", e.getClass(), e.getMessage());
        }

        assertThat(outObj.get(0), is("Hello"));
        assertThat(outObj.get(1), is("Hello"));

        outObj.add(0, "Hello World");
        try {
            XocMapperUtility<ArrayList<String>, ArrayList<String>, FooTestClass> xocMapperUtility = new XocMapperUtility<>(foo);
            xocMapperUtility.mapFrom(outObj, inObj);
        }
        catch (Exception e) {
            System.out.printf("exception is thrown %s - %s", e.getClass(), e.getMessage());
        }

        assertThat(inObj.get(0), is("Hello World"));
        assertThat(inObj.get(1), is("Hello World"));
    }
}
