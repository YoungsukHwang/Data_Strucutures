
public class Expression {
	String expr;
	int cur;

	public Expression(String expr){
		this.expr = expr;
		this.cur = 0;
	}
	
	public void increment(){
		this.cur++;
	}

	public String getExpr() {
		return expr;
	}

	public int getCur() {
		return cur;
	}
	
	public String giveCurrent(int cur){
		if(cur<expr.length())
			return Character.toString(expr.charAt(cur));
		else
			return null;
	}

}
