package au.com.zapallo.views;


import java.util.HashMap;
import au.com.zapallo.mappers.XocMapperInterface;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.Test;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.when;
import static org.junit.Assert.fail;

/**
 * Created by aaron.spiteri on 22/02/2016.
 */
public class XocAbstractViewTest {
    public static enum ViewTestMap implements XocMapperInterface<HashMap<String, String>, HashMap<String, String>> {
        ATTR1 {
            public void mapFrom(HashMap<String, String> outObj, HashMap<String, String> inObj) {
                outObj.put("ATTR1", inObj.get("ATTR1"));
            }
        },

        ATTR2 {
            public void mapFrom(HashMap<String, String> outObj, HashMap<String, String> inObj) {
                outObj.put("ATTR2", inObj.get("ATTR2"));
            }
        },

        ATTR3 {
            public void mapFrom(HashMap<String, String> outObj, HashMap<String, String> inObj) {
                outObj.put("ATTR3", inObj.get("ATTR3"));
            }
        };

        public void mapTo(HashMap<String, String> inObj, HashMap<String, String> outObj) {
        }
    }

    class ViewTest extends XocAbstractView<ViewTestMap> {
        public ViewTestMap getMapper() {
            return ViewTestMap.ATTR1;
        }
    }
    @Mock
    private HttpServletResponse response = Mockito.mock(HttpServletResponse.class);;

    @Mock
    private ServletOutputStream out = Mockito.mock(ServletOutputStream.class);

    @Test
    public void shouldRenderView() {
        HashMap<String, Object> inObj = new HashMap<>();
        inObj.put("ATTR1", "attr1");
        inObj.put("ATTR2", "attr2");
        inObj.put("ATTR3", "attr3");
        try {
            when(response.getOutputStream()).thenReturn(out);
            ViewTest view = new ViewTest();
            view.renderMergedOutputModel(inObj, null, response);
        }
        catch (Exception e) {
            fail("A exception occurred");
        }
    }
}
