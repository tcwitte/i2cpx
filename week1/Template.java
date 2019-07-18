import java.io.*;
import java.util.Scanner;
import java.lang.Math;
import java.lang.Long;

public class Template {
				public static void main(String[] args) throws FileNotFoundException {
								String fileName = "template";
								Scanner scanner = new Scanner(new File(fileName + ".in"));
								PrintWriter out = new PrintWriter(fileName + ".out");

								int w = scanner.nextInt();
								int h = scanner.nextInt();
								scanner.nextLine(); // Skip newline character
								char keys[][] = new char[h][w];
								for (int h_i = 0; h_i < h; h_i++) {
												String line = scanner.nextLine();
												for (int w_i = 0; w_i < w; w_i++) {
																keys[h_i][w_i] = line.charAt(w_i);
												}
								}
								scanner.nextLine(); // Skip

								int numLanguages = 3;
								String languages[] = new String[numLanguages];
								long lowestScore = java.lang.Long.MAX_VALUE;
								int bestLanguage = 0;

								for (int i = 0; i < numLanguages; i++) {
												languages[i] = scanner.nextLine();
												long score = 0;

												String line;
												boolean firstCharacter = true;
												int last_h = 0;
												int last_w = 0;
												int current_h = 0;
												int current_w = 0;
												while (scanner.hasNextLine()) {
																line = scanner.nextLine();
																if (line.equals("")) {
																				break;
																}
																for (int line_i = 0; line_i < line.length(); line_i++) {
																				char c = line.charAt(line_i);
																				// Find index
																				for (int h_i = 0; h_i < h; h_i++) {
																								for (int w_i = 0; w_i < w; w_i++) {
																												if (keys[h_i][w_i] == c) {
																																current_h = h_i;
																																current_w = w_i;
																																break;
																												}
																								}
																				}
																				if (firstCharacter) {
																								firstCharacter = false;
																								last_w = current_w;
																								last_h = current_h;
																								continue;
																				}
																				// Add score
																				int h_distance = Math.max(current_h, last_h) - Math.min(current_h, last_h);
																				int w_distance = Math.max(current_w, last_w) - Math.min(current_w, last_w);
																				score += Math.max(h_distance, w_distance);
																				last_w = current_w;
																				last_h = current_h;
																}
												}

												if (score < lowestScore) {
																lowestScore = score;
																bestLanguage = i;
												}
								}

								out.println(languages[bestLanguage]);
								out.println(lowestScore);
								out.flush();
				}
}
