import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

// servlet to map http and context
public class ContextFactory extends HttpServlet {

    public RequestContext getContextObject(HttpServletRequest request) {
        Map < String, String[] > requestMap = null;
        RequestContext requestContext = null;
        HttpRequestMapper requestMapper = null;

        requestMapper = new HttpRequestMapper();
        requestMap = requestMapper.extract(request);
        requestContext = new RequestContext(request.getRequestURI(), requestMap);

        return requestContext;
    }

    public void bindContextObject(HttpServletRequest request, RequestContext requestContext) {
        HttpRequestMapper requestMapper = null;

        requestMapper = new HttpRequestMapper();
        requestMapper.bind(request, requestContext.getResponseMap());
    }

}