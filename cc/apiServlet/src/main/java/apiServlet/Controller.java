package apiServlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@SuppressWarnings({ "unused", "serial" })
@WebServlet("/api/data")
public class Controller extends HttpServlet {
	private Gson gson = new Gson();
	DbUtil dbUtil = new DbUtil();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String line = "";

		// use StringBuilder to accept data of any type
		StringBuilder jb = new StringBuilder();
		try {
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String resBody = req.getReader().toString();
		ReqData d = gson.fromJson(jb.toString(), ReqData.class);
		if (resBody.equals(null)) {
			resp.setStatus(404);

			out.print("Please Provide data");
		}
		Util util = new Util();

		List<ResMessage> data = util.getRespData(d);
		String responseMassege = gson.toJson(data, new TypeToken<List<ResMessage>>() {
		}.getType());

		out.println(responseMassege);

	}

}
