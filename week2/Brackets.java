import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.lang.Character;
import java.lang.Integer;

public class Brackets {
				public static void main(String[] args) throws IOException {
								String fileName = "brackets";
								BufferedReader reader = new BufferedReader(new FileReader(fileName + ".in"));
								PrintWriter out = new PrintWriter(fileName + ".out");

								Stack<Character> stack = new Stack<Character>();

								String line;
								char[] array;
								int i;
								char c;
								boolean correct;

								while ((line = reader.readLine()) != null) {
												array = line.toCharArray();
												correct = true;
												for (i = 0; i < array.length; i++) {
																c = array[i];
																if (c == '(' || c == '[') {
																				stack.push(c);
																} else {
																				if (stack.empty()) {
																								correct = false;
																								break;
																				}

																			 	if (c == ')') {
																			 					correct = (stack.pop() == '(');
																				} else if (c == ']') {
																								correct = (stack.pop() == '[');
																				}
																}
																if (!correct) {
																				break;
																}
												}
												if (!stack.empty()) {
																correct = false;
																while (!stack.empty()) {
																				stack.pop();
																}
												}

												if (correct) {
																out.println("YES");
												} else {
																out.println("NO");
												}
								}

								out.flush();
				}
}
