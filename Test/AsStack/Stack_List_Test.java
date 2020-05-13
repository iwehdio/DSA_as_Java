package Test.AsStack;

import Sequence.Stack.Stack_List;

import java.util.Random;

public class Stack_List_Test {
    public static void main(String[] args) {
        Stack_List<Integer> stack = new Stack_List<>();
        Random random = new Random();

        System.out.println("入栈：");
        for (int i = 0; i < 10; i++) {
            int temp = random.nextInt(100);
            System.out.print(temp + " ");
            stack.push(temp);
        }
        System.out.println();
        System.out.println("栈顶的元素是：" + stack.top());
        System.out.println("栈的规模：" + stack.getSize());
        System.out.println("依此出栈：");
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
