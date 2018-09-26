import java.io.*;
import java.util.*;
import java.net.*;
public class server {
    public static void main(String[] args) throws IOException {
        new QuoteServerThread().start();
    }
}

