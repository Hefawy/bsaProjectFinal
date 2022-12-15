package appCore.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;

public class ReadJsonFile {

	@SuppressWarnings("unused")
	public ApiDataObject readJsonFile() {
		ApiDataObject apiDataObject = new ApiDataObject();

		JSONParser jsonParser = new JSONParser();

		try {
			File file = new File("file.json");

			BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));

			Gson g = new Gson();
			apiDataObject = g.fromJson(reader, ApiDataObject.class);

			// Change value from >> "TransactionId":"#TRANSACTION#" << to ID Number
			List<Parameter> list = apiDataObject.getData().getParameters();

			for (int x = 0; x < list.size(); x++) {
				list.get(x).setTransactionId(String.valueOf(x + 1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiDataObject;
	}
}
