package cl.bci.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Phone implements Serializable{
	
	private static final long serialVersionUID = 8447300446720231077L;

	private  String number;
	
	private String citycode;
	
	private String contrycode;

}
