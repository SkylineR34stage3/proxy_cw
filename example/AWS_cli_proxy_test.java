package proxy.example;

public class AWS_cli_proxy_test {

    public static void main(String[] args) {
        AWS_cli_interface executor = new AWS_cli_proxy("admin", "111111");
        try {
            executor.runCommand("ls -la");
            executor.runCommand("rm -rf *");
        } catch (Exception e) {
            System.out.println("Fatal error: " + e.getMessage());
        }
    }
}
