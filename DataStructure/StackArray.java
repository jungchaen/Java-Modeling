public class StackArray {
    public static void main(String[] args) {
        int size = 5;
        Stack stack = new Stack(size);

        stack.push(1);
        stack.printStack();
        stack.push(2);
        stack.printStack();
        stack.pop();
        stack.printStack();
    }
}

class Stack {
    private int top;
    private int[] stackArray;
    private int size;

    public Stack(int size) {
        this.size = size;
        this.stackArray = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        stackArray[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return stackArray[top--];
    }

	public int peek() {
		if (isEmpty()) {
	throw new ArrayIndexOutOfBoundsException();
	}
	return stackArray[top];
	}

    public boolean isFull() {
        return (top == size - 1);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
        }
        System.out.println("");
    }
}
