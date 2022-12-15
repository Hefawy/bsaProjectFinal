package appCore.main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import apiServlet.ResMessage;

public class Main {
	private final static String API_URL = "http://localhost:8080/apiServlet/api/data";
	private static InsertToDatabase database = new InsertToDatabase();
	private static ApiDataObject apiDataObject = new ApiDataObject();
	private static List<ResMessage> res = new ArrayList<>();
	private static Gson g = new Gson();

	public static void main(String[] args) throws UnsupportedEncodingException, IOException, InterruptedException {

		ReadJsonFile file = new ReadJsonFile();
		// read file JSON
		apiDataObject = file.readJsonFile();

//		time.timeRes();

		// save and send data to API
		String apiData = g.toJson(apiDataObject, ApiDataObject.class);

		// be used to send requests
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().version(Version.HTTP_1_1).uri(URI.create(API_URL))

				// sets its request body publisher to the given value
				.POST(HttpRequest.BodyPublishers.ofString(apiData)).build();

		// returned as a result of sending an HttpRequest( Data from API )
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		boolean isErr = response.statusCode() != 200;
		if (isErr) {
			return;
		}

		Gson gson = new Gson();

		// res is the ArrayList
		res = gson.fromJson(response.body(), new TypeToken<List<ResMessage>>() {
		}.getType());

		// Call Database Method
		saveToDb();

		System.out.println("DONE");

	}

	static void saveToDb() {

		// get List of JSON data from Parameter model class
		List<Parameter> pramsList = apiDataObject.getData().getParameters();

		// Save data < Object by Object >
		for (int i = 0; i < pramsList.size(); i++) {
			Parameter params = pramsList.get(i);
			String resMessgeForTrans = "";
			for (ResMessage ret : res) {
				if (ret.getdata().getTransactionId().equals(params.getTransactionId()))

					// TO write eerMessage in Database
					resMessgeForTrans = g.toJson(ret, ResMessage.class);

			}

			database.saveDataToDb(params.getEventCode(), params.getCity(), params.getFirstName(), params.getLastName(),
					apiDataObject.getRequestId(), params.getTransactionId(), resMessgeForTrans);

		}

	}

}
