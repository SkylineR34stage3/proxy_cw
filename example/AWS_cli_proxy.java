package proxy.example;

public class AWS_cli_proxy implements AWS_cli_interface {

    private boolean isAdmin;
    private final AWS_cli_interface executor;

    public AWS_cli_proxy(String user, String pwd) {
        if ("admin".equals(user) && "123456".equals(pwd)) isAdmin = true;
        executor = new AWS_cli();
    }

    //proxy class implementation so now user cannot do illegal stuff
    @Override
    public void runCommand(String cmd) throws Exception {
        if (isAdmin) {
            executor.runCommand(cmd);
        } else {
            if (cmd.trim().startsWith("rm")) {
                throw new Exception("rm command is not allowed for non-admin users.");
            } else {
                executor.runCommand(cmd);
            }
        }
    }
}
