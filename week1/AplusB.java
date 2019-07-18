import java.io.*;
import java.util.Scanner;

public class AplusB {
				public static void main(String[] args) throws FileNotFoundException {
								String fileName = "aplusb";
								InputStream inputStream = new FileInputStream(fileName + ".in");
								OutputStream outputStream = new FileOutputStream(fileName + ".out");
								Scanner scanner = new Scanner(inputStream);
								PrintWriter out = new PrintWriter(outputStream);

								out.print(scanner.nextInt() + scanner.nextInt());
								out.flush();
				}
}
