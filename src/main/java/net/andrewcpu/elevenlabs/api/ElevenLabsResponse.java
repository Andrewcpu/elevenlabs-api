package net.andrewcpu.elevenlabs.api;

import net.andrewcpu.elevenlabs.enums.ResponseType;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsExceptionBuilder;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsValidationException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ElevenLabsResponse<T> {
	private int responseCode;
	private InputStream errorStream;
	private InputStream successStream;
	private ElevenLabsRequest request;
	private JSONObject successful;
	private JSONObject error;
	private T resultingObject;

	public ElevenLabsResponse(int responseCode, InputStream errorStream, InputStream successStream, ElevenLabsRequest<T> request) {
		this.responseCode = responseCode;
		this.errorStream = errorStream;
		this.successStream = successStream;
		this.request = request;
		try {
			_buildObjects();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	private void _buildObjects() throws IOException, ParseException {
		if(isSuccessful()){
			if(request.getResponseType() == ResponseType.JSON){
				String responseBody = new String(successStream.readAllBytes(), "UTF-8");

				JSONObject object = ((JSONObject) new JSONParser().parse(responseBody));
				this.successful = object;
				resultingObject = (T)request.getResultTransformer().transform(object);
			}
			else if(request.getResponseType() == ResponseType.FILE_STREAM){
				try (InputStream inputStream = successStream) {
					byte[] buffer = new byte[4096];
					int bytesRead;
					try (OutputStream outputStream = new FileOutputStream(request.getOutputFilePath())) {
						while ((bytesRead = inputStream.read(buffer)) != -1) {
							outputStream.write(buffer, 0, bytesRead);
						}
					}
				}
				resultingObject = (T)request.getResultTransformer().transform();

			}
			else if(request.getResponseType() == ResponseType.STRING){
				String responseBody = new String(successStream.readAllBytes(), "UTF-8");
				resultingObject = (T)request.getResultTransformer().transform(responseBody);
			}
		}
		else{
			String responseBody = new String(errorStream.readAllBytes(), "UTF-8");
			JSONObject object = ((JSONObject) new JSONParser().parse(responseBody));
			this.error = object;
		}
	}

	public ElevenLabsValidationException getException() {
		return ElevenLabsExceptionBuilder.build(this.error);
	}

	public T getResult() {
		return resultingObject;
	}

	public JSONObject getResultJSON() {
		return successful;
	}
	public boolean isSuccessful() {
		return responseCode >= 200 && responseCode < 300;
	}
}
