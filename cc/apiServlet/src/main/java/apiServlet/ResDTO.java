package apiServlet;

public class ResDTO {
	private String priority;
	private String appointmentNo;
	private String eventCode;
	private String city;
	private String firstName;
	private String lastName;
	private String requestID;
	private String feasibilityID;

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getAppointmentNo() {
		return appointmentNo;
	}

	public void setAppointmentNo(String appointmentNo) {
		this.appointmentNo = appointmentNo;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}

	public String getFeasibilityID() {
		return feasibilityID;
	}

	public void setFeasibilityID(String feasibilityID) {
		this.feasibilityID = feasibilityID;
	}

}