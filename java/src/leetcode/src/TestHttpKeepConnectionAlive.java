package main.java.algorithms.src;

public class TestHttpKeepConnectionAlive
{
    public static void main(String[] args) {
        try {
            java.net.URL url = new java.net.URL
                    ("http://my.host.com/examples/servlet/Example");
            java.net.URLConnection uc = url.openConnection();
            uc.setRequestProperty("connection", "Keep-Alive");
            uc.connect();
            java.io.BufferedReader br = new
                    java.io.BufferedReader(
                    new java.io.InputStreamReader(uc.getInputStream()));
        } catch (Exception e) {

        }
    }
}