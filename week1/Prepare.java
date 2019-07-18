import java.io.*;
import java.util.Scanner;

public class Prepare {
				public static void main(String[] args) throws FileNotFoundException {
								String fileName = "prepare";
								InputStream inputStream = new FileInputStream(fileName + ".in");
								OutputStream outputStream = new FileOutputStream(fileName + ".out");
								Scanner scanner = new Scanner(inputStream);
								PrintWriter out = new PrintWriter(outputStream);

								// Gather input
								int n = scanner.nextInt();
								int[] p = new int[n];
								for (int i = 0; i < n; i++) {
												p[i] = scanner.nextInt();
								}
								int[] t = new int[n];
								for (int i = 0; i < n; i++) {
												t[i] = scanner.nextInt();
								}

								// Optimize
								long sum = 0;
								boolean t_done = false;
								boolean p_done = false;
								for (int i = 0; i < n; i++) {
												if (p[i] > t[i]) {
																sum += p[i];
																p_done = true;
												} else {
																sum += t[i];
																t_done = true;
												}
								}

								// Do required practice or theory, if not done yet
								if (!p_done) {
												// Apparently theory is more advantageous on each day
												int smallest_diff = t[0] - p[0];
												int pos = 0;
												for (int i = 1; i < n; i++) {
																if (t[i] - p[i] < smallest_diff) {
																				smallest_diff = t[i] - p[i];
																				pos = i;
																}
												}
												// Exchange
												sum -= t[pos];
												sum += p[pos];
								}
								if (!t_done) {
												// TODO: yuck, code duplication
												// Apparently practice is more advantageous on each day
												int smallest_diff = p[0] - t[0];
												int pos = 0;
												for (int i = 1; i < n; i++) {
																if (p[i] - t[i] < smallest_diff) {
																				smallest_diff = p[i] - t[i];
																				pos = i;
																}
												}
												// Exchange
												sum -= p[pos];
												sum += t[pos];
								}

								out.print(sum);
								out.flush();
				}
}
