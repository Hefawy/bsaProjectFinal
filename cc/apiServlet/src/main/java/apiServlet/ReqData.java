package apiServlet;

import java.util.List;

public class ReqData {
	private String source;
	private String requestId;
	private String createDate;
	private DataApi data;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public DataApi getData() {
		return data;
	}

	public void setData(DataApi data) {
		this.data = data;
	}

	static class DataApi {
		private long bccCustomerNumber;
		private long bccSubProductsId;
		private long bccContractNumber;
		private long workFlowID;
		private boolean batch;
		private boolean isBatch;
		private List<Parameter> parameters;

		public long getBccCustomerNumber() {
			return bccCustomerNumber;
		}

		public void setBccCustomerNumber(long bccCustomerNumber) {
			this.bccCustomerNumber = bccCustomerNumber;
		}

		public long getBccSubProductsId() {
			return bccSubProductsId;
		}

		public void setBccSubProductsId(long bccSubProductsId) {
			this.bccSubProductsId = bccSubProductsId;
		}

		public long getBccContractNumber() {
			return bccContractNumber;
		}

		public void setBccContractNumber(long bccContractNumber) {
			this.bccContractNumber = bccContractNumber;
		}

		public long getWorkFlowID() {
			return workFlowID;
		}

		public void setWorkFlowID(long workFlowID) {
			this.workFlowID = workFlowID;
		}

		public boolean isBatch() {
			return batch;
		}

		public void setBatch(boolean batch) {
			this.batch = batch;
		}

		public boolean Batch() {
			return isBatch;
		}

		public void setIsBatch(boolean isBatch) {
			this.isBatch = isBatch;
		}

		public List<Parameter> getParameters() {
			return parameters;
		}

		public void setParameters(List<Parameter> parameters) {
			this.parameters = parameters;
		}

	}

}

class Parameter {
	private String priority;
	private String eventCode;
	private String HouseNumber;
	private String SeekerOrderNo;
	private String Email;
	private String Address;
	private String FirstName;
	private String SNA;
	private String GovtIdNo;
	private String City;
	private String AppointmentNo;
	private String MiddleName;
	private String Mobile;
	private String FeasibilityId;
	private String SeekerServiceNo;
	private String GovtIdType;
	private String Region;
	private String FiberType;
	private String LastName;
	private String PlateNo;
	private String TransactionId;

	public String getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getHouseNumber() {
		return HouseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		HouseNumber = houseNumber;
	}

	public String getSeekerOrderNo() {
		return SeekerOrderNo;
	}

	public void setSeekerOrderNo(String seekerOrderNo) {
		SeekerOrderNo = seekerOrderNo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getSNA() {
		return SNA;
	}

	public void setSNA(String sNA) {
		SNA = sNA;
	}

	public String getGovtIdNo() {
		return GovtIdNo;
	}

	public void setGovtIdNo(String govtIdNo) {
		GovtIdNo = govtIdNo;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getAppointmentNo() {
		return AppointmentNo;
	}

	public void setAppointmentNo(String appointmentNo) {
		AppointmentNo = appointmentNo;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getFeasibilityId() {
		return FeasibilityId;
	}

	public void setFeasibilityId(String feasibilityId) {
		FeasibilityId = feasibilityId;
	}

	public String getSeekerServiceNo() {
		return SeekerServiceNo;
	}

	public void setSeekerServiceNo(String seekerServiceNo) {
		SeekerServiceNo = seekerServiceNo;
	}

	public String getGovtIdType() {
		return GovtIdType;
	}

	public void setGovtIdType(String govtIdType) {
		GovtIdType = govtIdType;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}

	public String getFiberType() {
		return FiberType;
	}

	public void setFiberType(String fiberType) {
		FiberType = fiberType;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPlateNo() {
		return PlateNo;
	}

	public void setPlateNo(String plateNo) {
		PlateNo = plateNo;
	}

}