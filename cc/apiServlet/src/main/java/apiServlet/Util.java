package apiServlet;

import java.util.ArrayList;
import java.util.List;

public class Util {
	List<ResMessage> data = new ArrayList<>();

	public List<ResMessage> getRespData(ReqData jsonData) {

		List<Parameter> rquireData = jsonData.getData().getParameters();

		
		for (Parameter parameter : rquireData) {
			//Prams Class use to message err
			Prams p = new Prams(parameter.getTransactionId(), "", parameter.getFiberType());
			p.setSuccess();

			// Responce message save data into message variable
			ResMessage message = new ResMessage("", "", "Success", p);
			try {
				// check the same Transaction or no.
				saveToDB(parameter.getPriority(), parameter.getAppointmentNo(), parameter.getFeasibilityId(),
						parameter.getTransactionId(), p.getSuccess());
			} catch (Exception e) {
				message.setEerCode("400");
				message.setEerMessage(e.getMessage());
			}

			data.add(message);
		}

		return data;

	}

	public void saveToDB(String Priority, String AppointmentNo, String FeasibilityId, String TransactionId,
			boolean Success) {
		DbUtil dbUtil = new DbUtil();

		dbUtil.saveDataRequst(Priority, AppointmentNo, FeasibilityId, TransactionId, Success);

	}

}