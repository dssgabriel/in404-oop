import java.lang.String;

public enum Operation {
	PLUS('+') {
		public double eval(double val1, double val2) { 
			return val1 + val2; 
		} 
	},
  	
    MINUS('-') { 
  		public double eval(double val1, double val2) { 
  			return val1 - val2; 
  		} 
  	},
  	
    MULT('*') { 
  		public double eval(double val1, double val2) {
  		 	return val1 * val2;
  		 } 
  	},
  	
    DIV('/') { 
  		public double eval(double val1, double val2) { 
  			return val1 / val2; 
  		} 
  	};

  	private char symbol;

  	Operation(char symbol) {
    	this.symbol = symbol;
  	}

  	public abstract double eval(double val1, double val2);
}
