import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class Chairs {
				public static void main(String[] args) throws FileNotFoundException {
								String fileName = "chairs";
								InputStream inputStream = new FileInputStream(fileName + ".in");
								OutputStream outputStream = new FileOutputStream(fileName + ".out");
								Scanner scanner = new Scanner(inputStream);
								PrintWriter out = new PrintWriter(outputStream);

								int i = scanner.nextInt();
								int j = scanner.nextInt();
								int k = scanner.nextInt();

								// Midpoint theorem: the sides of the triangle inside are half the size
								double avg_distance = (i/2.0 + j/2.0 + k/2.0)/3.0;
								out.print(avg_distance);
								out.flush();
				}
}
