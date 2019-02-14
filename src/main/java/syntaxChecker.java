import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class syntaxChecker {
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println(isBalanced("badFile1.txt"));
        System.out.println(isBalanced("badFile2.txt"));
        System.out.println(isBalanced("goodFile1.txt"));
        System.out.println(isBalanced("goodFile2.txt"));

    }

    public static boolean isBalanced(String filePath) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filePath));
        Stack<Character> stack = new Stack<>();
        while(input.hasNextLine()) {
            String inputScan = input.nextLine();
            for (int i = 0; i < inputScan.length(); i++) {
                char x = inputScan.charAt(i);
                if (x == '{' || x == '[' || x == '<' || x == '(') {
                    stack.push(x);
                } else if (x == '}' || x == ']' || x == '>' || x == ')') {
                    if (stack.size() == 0) {
                        return false;
                    }
                    if (stack.peek() == '{') {
                        stack.pop();
                        if (x != '}') {
                            return false;
                        }
                    } else if (stack.peek() == '[') {
                        stack.pop();
                        if (x != ']') {
                            return false;
                        }
                    } else if (stack.peek() == '<') {
                        stack.pop();
                        if (x != '>') {
                            return false;
                        }
                    } else if (stack.peek() == '(') {
                        stack.pop();
                        if (x != ')') {
                            return false;
                        }
                    }

                }

            }
        }
        return true;

    }
}
