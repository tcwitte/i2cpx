import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.lang.String;
import java.lang.Integer;

public class StackProg {
				public static void main(String[] args) throws IOException {
								String fileName = "stack";
								BufferedReader reader = new BufferedReader(new FileReader(fileName + ".in"));
								PrintWriter out = new PrintWriter(fileName + ".out");

								Stack<Integer> stack = new Stack<Integer>();

								String line;
								String number;

								reader.readLine(); // Ignore first line
								while ((line = reader.readLine()) != null) {
												if (line.charAt(0) == '+') {
																number = line.substring(2);
																stack.push(Integer.valueOf(number));
												} else {
																out.println(stack.pop());
												}
								}
								out.flush();
				}
}
