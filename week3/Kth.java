import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Kth {
				public static int qselect(Random r, int[] a, int left, int right, int k) {
								if (left == right) {
												return a[left];
								}

								int leftP = left;
								int rightP = right;
								int pivotIndex = left + r.nextInt(1 + right - left);
								int m = a[pivotIndex];
								while (leftP <= rightP) {
												while (a[leftP] <= m && leftP < right) {
																leftP++;
												}
												while (m <= a[rightP] && rightP > left) {
																rightP--;
												}
												if (leftP <= rightP) {
																int buf = a[leftP];
																a[leftP] = a[rightP];
																a[rightP] = buf;
																leftP++;
																rightP--;
												}
								}

								if (left <= rightP && k < rightP) {
												return qselect(r, a, left, rightP, k);
								} else if (leftP <= right && leftP < k) {
												return qselect(r, a, leftP, right, k);
								} else {
												return a[pivotIndex];
								}
				}

				public static void main(String[] args) throws IOException {
								String filename = "kth";
								BufferedReader reader = new BufferedReader(new FileReader(filename + ".in"));
								Scanner scanner = new Scanner(reader);
								PrintWriter out = new PrintWriter(filename + ".out");

								int n = scanner.nextInt();
								int k1 = scanner.nextInt();
								int k2 = scanner.nextInt();
								int[] sequence = new int[n];

								int a = scanner.nextInt();
								int b = scanner.nextInt();
								int c = scanner.nextInt();
								sequence[0] = scanner.nextInt();
								sequence[1] = scanner.nextInt();

								for (int i = 2; i < n; i++) {
												sequence[i] = a*sequence[i-2] + b*sequence[i-1] + c;
								}
								if (a == 0 && b == 0) {
												for (int i = k1-1; i < k2; i++) {
																out.print(sequence[i]);
																if (i != k2 - 1) {
																				out.print(" ");
																}
												}
								} else {
												Random r = new Random();
								
												for (int i = k1-1; i < k2; i++) {
																out.print(qselect(r, sequence, 0, n-1, i));
																if (i != k2 - 1) {
																				out.print(" ");
																}
												}
								}

								out.flush();
				}
}
