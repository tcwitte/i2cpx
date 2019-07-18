import java.io.*;
import java.util.Scanner;

// Note: doesn't work yet
public class Antiqs {
				public static void antiQs(int[] a, int left, int right, int[] minimums) {
								// Let the worst possible pivot (the minimum value) be in the middle
								int minimum = a[left];
								int minimum_pos = left;
								for (int i = left; i < right; i++) {
												if (a[i] < minimum) {
																minimum = a[i];
																minimum_pos = i;
												}
								}
								int midpoint = (left + right)/2;
								if (a[midpoint] != minimum) {
												int buf = a[midpoint];
												a[midpoint] = minimum;
												a[minimum_pos] = buf;
								}

								minimums[midpoint] = minimum;
								int pivot = minimum; //a[midpoint];

								int i = left;
								int j = right-1;
								while (i <= j) {
												while (a[i] < pivot) {
																i++;
												}
												while (pivot < a[j]) {
																j--;
												}
												if (i <= j) {
																int buf = a[i];
																a[i] = a[j];
																a[j] = buf;
																i++;
																j--;
												}
								}
								if (left < j) {
												antiQs(a, left, j, minimums);
								}
								if (i < right) {
												antiQs(a, i, right, minimums);
								}
				}

				public static void main(String[] args) throws IOException {
								String filename = "antiqs";
								BufferedReader reader = new BufferedReader(new FileReader(filename + ".in"));
								Scanner scanner = new Scanner(reader);
								PrintWriter out = new PrintWriter(filename + ".out");

								int n = scanner.nextInt();
								if (n == 1) {
												out.print(1);
								} else if (n == 2) {
												out.print("1 2");
								} else if (n == 3) {
												out.print("1 3 2");
								} else if (n == 4) {
												out.print("1 4 2 3");
								} else {
												int[] values = new int[n];
												for (int i = 0; i < n; i++) {
																values[i] = i + 1;
												}
												int[] minimums = new int[n];
												antiQs(values, 0, n, minimums);

												for (int i = 0; i < n; i++) {
																out.print(minimums[i]);
																if (i != n - 1) {
																				out.print(" ");
																}
												}
								}

								out.flush();
				}
}
