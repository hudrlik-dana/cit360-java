
// get the uri and create new student view
public class CommandHelper {

    public Command getCommand(String uri) {

        Command command = null;

        if (uri.contains("studentView.do")) {
            command = new StudentViewCommand();
        }
        return command;
    }

}