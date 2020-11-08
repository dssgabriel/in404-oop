public enum RPNCalculator {	
	MIN_VALUE(-65535) {
		public double value() {
			return -65535;
		}
	},

	MAX_VALUE(65536) {
		public double value() {
			return 65536;
		}
	};

	public static void main(String[] args) {
    	RPNInput calc = new RPNInput();
    	System.out.println("\nType 'exit' to quit the program");
    	System.out.println("Values recognized by the calculator should be in the range of: [" + MAX_VALUE.value() + ", " + MIN_VALUE.value() + "]");
     	System.out.println("Please input a number:");
    	while(true) 
    		calc.input();
  	}

  	public double value;

  	RPNCalculator(double value) {
  		this.value = value;
  	}

  	public abstract double value();
}
