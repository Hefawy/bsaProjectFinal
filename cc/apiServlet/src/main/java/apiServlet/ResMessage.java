package apiServlet;

public class ResMessage {

	private String eerCode;
	private String eerMessage;
	private String Status;
	private Prams data;

	public ResMessage(String eerCode, String eerMessage, String status, Prams data) {
		super();
		this.eerCode = eerCode;
		this.eerMessage = eerMessage;
		Status = status;
		this.data = data;
	}

	public Prams getdata() {
		return data;
	}

	public void setdata(Prams data) {
		this.data = data;
	}

	public String getEerCode() {

		return eerCode;
	}

	public void setEerCode(String eerCode) {
		this.eerCode = eerCode;
	}

	public String getEerMessage() {
		return eerMessage;
	}

	public void setEerMessage(String eerMessage) {
		this.eerMessage = eerMessage;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

}
