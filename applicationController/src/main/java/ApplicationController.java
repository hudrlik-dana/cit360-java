
// client invokes the application controller
// uses a mapper to resolve an incoming request to the action and view
// to which it delegates or dispatches
public class ApplicationController {

    public String process(RequestContext requestContext) {
        String view = null;
        Command command = null;
        CommandHelper commandHelper = null;

        commandHelper = new CommandHelper();
        command = commandHelper.getCommand(requestContext.getRequestUri());
        view = command.execute(requestContext);

        return view;
    }

    public String mapViewToPage(String view) {
        String page = null;
        if (view != null) {
            page = "WEB-INF/viewStudent.jsp";
        }
        return page;
    }
}