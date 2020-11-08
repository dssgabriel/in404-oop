import java.util.*;

public class MyStack {
	private Stack<Double> stack;
    private int len;

    public MyStack() {
  		  this.stack = new Stack<Double>();
  		  this.len = 0;
      }
 	
  	public Stack<Double> getStack() {  
  		  return this.stack;
      }

  	public int getLen() {
  		return this.len;
  	}

  	public boolean isEmpty() {
  		return this.stack.empty();
  	}

  	public void myPush(Double item) {
  		this.len += 1;
  		this.stack.push(item);
  	}

  	public Double myPeek() throws EmptyStackException {
    	try {
    		double peek = this.stack.peek();
      		return peek;
    	} catch(EmptyStackException except) {
      		System.out.println("Error: stack.peek(): Stack is empty");
      		return (double)-1;
    	}
  	}

  	public Double myPop() throws EmptyStackException {
  		try {
    		this.len -= 1;
  			return this.stack.pop();
  		} catch(EmptyStackException except) {
  			System.out.println("Error: stack.pop(): Stack is empty");
      		return (double)-1;
  		}
  	}
}
