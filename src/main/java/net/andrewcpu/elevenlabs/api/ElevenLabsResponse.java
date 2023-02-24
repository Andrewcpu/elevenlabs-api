package net.andrewcpu.elevenlabs.api;

import net.andrewcpu.elevenlabs.enums.ResponseType;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsExceptionBuilder;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsValidationException;
import net.andrewcpu.elevenlabs.util.DebugLogger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ElevenLabsResponse<T> {
	private final int responseCode;
	private final InputStream errorStream;
	private final InputStream successStream;
	private final ElevenLabsRequest<T> request;
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
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	private void _buildObjects() throws IOException, ParseException {
		if(isSuccessful()){
			if(request.getResponseType() == ResponseType.JSON){
				String responseBody = new String(successStream.readAllBytes(), StandardCharsets.UTF_8);
				DebugLogger.log(getClass(), responseBody);
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
				String responseBody = new String(successStream.readAllBytes(), StandardCharsets.UTF_8);
				DebugLogger.log(getClass(), responseBody);
				resultingObject = (T)request.getResultTransformer().transform(responseBody);
			}
		}
		else{
			String responseBody = new String(errorStream.readAllBytes(), StandardCharsets.UTF_8);
			DebugLogger.log(getClass(), responseBody);
			this.error = ((JSONObject) new JSONParser().parse(responseBody));
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
