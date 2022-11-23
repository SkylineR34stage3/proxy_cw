package proxy.example;

import java.io.IOException;

public class AWS_cli implements AWS_cli_interface {

    //basic service function that is used locally in dev team
    @Override
    public void runCommand(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);
        System.out.println("'" + cmd + "' command executed.");
    }
}
