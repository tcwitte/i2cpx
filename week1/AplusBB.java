import java.io.*;
import java.util.Scanner;

public class AplusBB {
				public static void main(String[] args) throws FileNotFoundException {
								String fileName = "aplusbb";
								InputStream inputStream = new FileInputStream(fileName + ".in");
								OutputStream outputStream = new FileOutputStream(fileName + ".out");
								Scanner scanner = new Scanner(inputStream);
								PrintWriter out = new PrintWriter(outputStream);

								long a = scanner.nextInt();
								long b = scanner.nextInt();
								out.print(a + (b * b));
								out.flush();
				}
}
