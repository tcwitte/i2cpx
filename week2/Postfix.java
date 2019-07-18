import java.io.*;
import java.util.Stack;
import java.lang.Character;

public class Postfix {
				public static void main(String[] args) throws IOException {
								String fileName = "postfix";
								BufferedReader reader = new BufferedReader(new FileReader(fileName + ".in"));
								PrintWriter out = new PrintWriter(fileName + ".out");

								Stack<Integer> stack = new Stack<Integer>();
								char[] line = reader.readLine().toCharArray();
								int a, b;

								for (int i = 0; i < line.length; i += 2) {
												switch (line[i]) {
																case '+':
																				b = stack.pop();
																				a = stack.pop();
																				stack.push(a + b);
																				break;
																case '-':
																				b = stack.pop();
																				a = stack.pop();
																				stack.push(a - b);
																				break;
																case '*':
																				b = stack.pop();
																				a = stack.pop();
																				stack.push(a * b);
																				break;
																default:
																				stack.push(Character.getNumericValue(line[i]));
																				
												}
								}

								out.println(stack.pop());
								out.flush();
				}
}
