
package seop.com.stockportfolio.global.httpresponse;


public enum Result {
	SUCCESS("SUCCESS"),
	FAIL("FAIL");
	
	private final String value;
	
	private Result(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	
}
