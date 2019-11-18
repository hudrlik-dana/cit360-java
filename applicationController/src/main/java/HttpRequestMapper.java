import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@WebServlet(name = "HttpRequestMapper")
public class HttpRequestMapper extends HttpServlet {

    protected void doPost()
            throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public Map<String, String[]> extract(HttpServletRequest request) {
        return Collections.emptyMap();
    }

    public void bind(HttpServletRequest request, Map<String, Object> responseMap) {
        return;
    }

}
