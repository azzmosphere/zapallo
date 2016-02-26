package au.com.zapallo.views;

import java.util.Map;
import java.util.HashMap;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.view.AbstractView;
import org.springframework.web.servlet.View;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.io.ByteArrayOutputStream;

import au.com.zapallo.mappers.XocMapperInterface;
import au.com.zapallo.mappers.XocMapperUtility;
import au.com.zapallo.exceptions.XocRenderException;

/**
 * Created by aaron.spiteri on 22/02/2016.
 */
public abstract class XocAbstractView<U extends XocMapperInterface>  extends AbstractView  implements View {

    /*
     * As per RFC 4627, see reference: http://www.ietf.org/rfc/rfc4627.txt
     * This is the content type that should be used for JSON.
     */
    private static String CONTENT_TYPE = "application/json";
    private static final Logger logger = LoggerFactory.getLogger(XocAbstractView.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    public abstract U getMapper();

    /**
     * As per RFC 4627 (section 6) the current MIME type for JSON data is
     * application/json
     *
     * @return the content type for JSON documents
     */
    @Override
    public String getContentType() {
        return CONTENT_TYPE;
    }

    /**
     * Converts model map to a JSON string and writes it to the response object.
     *
     * @param model The mapped keys to values.
     * @param request The request supplied by the servlet
     * @param response The response that will be written
     *        to the client
     * @throws Exception an exception has occurred during the rendering
     *         phase which could not be caught.
     */
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        logger.debug("started to render view");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        response.setContentType(getContentType());
        ServletOutputStream out = response.getOutputStream();
        Map<String, Object> resolvedMap = new HashMap<>();

        try {
            XocMapperUtility<Map<String, Object>, Map<String, Object>, U> mapperUtility = new XocMapperUtility<>(getMapper());
            mapperUtility.mapFrom(resolvedMap, model);
            baos.write(objectMapper.writeValueAsString(resolvedMap).getBytes());
            response.setBufferSize(baos.size());
            baos.writeTo(out);
        }

        // This will throw a error and fail the test.
        catch (Exception e) {

            throw new XocRenderException();
        }

    }
}
