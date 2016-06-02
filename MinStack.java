public class MinStack {
	Stack stack;
	Stack mins;
	int minValue;

	public MinStack() {
		stack = new Stack();
		mins = new Stack();
	}

	public void push(int data) {
		stack.push(data);
		System.out.println("Comparing " + minValue + " and " + data);
		if (mins.size() == 0 || (mins.size() > 0 && minValue > data)) {
			minValue = data;
			mins.push(minValue);
		}
	}

	public void pop() {
		if (getMin() == (int) stack.peek().data) {
			mins.pop();
			if (mins.size() > 0) minValue = (int) mins.peek().data;
		} 
		stack.pop();
	}

	public int getMin() {
		int min = (int) mins.peek().data;
		return min;
	}
}