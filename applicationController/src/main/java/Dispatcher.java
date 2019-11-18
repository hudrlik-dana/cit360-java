import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Dispatcher {

    public void dispatch(HttpServletRequest request, HttpServletResponse response, String page) {

        RequestDispatcher requestDispatcher = null;

        requestDispatcher = request.getRequestDispatcher(page);

        try {
            requestDispatcher.forward(request, response);

        } catch (ServletException somethingWentWrong) {
            somethingWentWrong.printStackTrace();

        } catch (IOException somethingElseWentWrong) {
            somethingElseWentWrong.printStackTrace();
        }
    }

}