package cl.bci.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = -3575847287295443577L;
	
	@JsonProperty("mensaje")
	private String mensaje;
}
