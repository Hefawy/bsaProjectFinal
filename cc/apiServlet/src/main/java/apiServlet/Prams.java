package apiServlet;

public class Prams {

	private boolean success;
	private String TransactionId;
	private String error_message;

	public Prams() {
		super();
	}

	public Prams(String transactionId, String error_message, String FiberType) {
		super();
		success = (FiberType.equalsIgnoreCase("FTTB") || FiberType.equalsIgnoreCase("FTTH")) ? true : false;

		TransactionId = transactionId;
		this.error_message = error_message;
	}

	public String getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess() {

	}

}
