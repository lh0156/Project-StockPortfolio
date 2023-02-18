package seop.com.stockportfolio.global.httpresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ResponseMessage {

	private String result;

	private String message;

	private Object data;

	public static ResponseMessage success() {
		
		return ResponseMessage.builder()
					.result(Result.SUCCESS.getValue())
					.data(null)
					.message(EMPTY)
					.build();
	}
	
	public static ResponseMessage success(Object data, String message) {

		return ResponseMessage.builder()
				.result(Result.SUCCESS.getValue())
				.data(data)
				.message(message)
				.build();
	}
	
	public static ResponseMessage success(Object data) {

		return ResponseMessage.builder()
				.result(Result.SUCCESS.getValue())
				.data(data)
				.message(EMPTY)
				.build();
	}
	
	public static ResponseMessage fail(Object data, String message) {

		return ResponseMessage.builder()
					.result(Result.FAIL.getValue())
					.data(data)
					.message(message)
					.build();
	}
	
}
