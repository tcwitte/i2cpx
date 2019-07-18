import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class Team {
				public static void main(String[] args) throws FileNotFoundException {
								String fileName = "team";
								InputStream inputStream = new FileInputStream(fileName + ".in");
								OutputStream outputStream = new FileOutputStream(fileName + ".out");
								Scanner scanner = new Scanner(inputStream);
								PrintWriter out = new PrintWriter(outputStream);

								// Gather input
								int[] a = new int[3];
								int[] b = new int[3];
								int[] c = new int[3];
								for (int i = 0; i < 3; i++) {
												a[i] = scanner.nextInt();
								}
								for (int i = 0; i < 3; i++) {
												b[i] = scanner.nextInt();
								}
								for (int i = 0; i < 3; i++) {
												c[i] = scanner.nextInt();
								}

								// Optimize
								long best_efficiency = 0;
								long efficiency;
								int a_role = 0;
								int b_role = 0;
								int c_role = 0;
								for (int i = 0; i < 3; i++) {
												for (int j = 0; j < 3; j++) {
																for (int k = 0; k < 3; k++) {
																				if (i == j || i == k || j == k) {
																								continue;
																				}
																				efficiency = a[i]*a[i] + b[j]*b[j] + c[k]*c[k];
																				if (efficiency > best_efficiency) {
																								best_efficiency = efficiency;
																								a_role = i;
																								b_role = j;
																								c_role = k;
																				}
																}
												}
								}

								// System.out.println("<a, b, c> = " + "<" + a_role + ", " + b_role + ", " + c_role + ">");
								out.print(Math.sqrt(best_efficiency));
								out.flush();
				}
}
