package cl.bci.model;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Data
public class NewUserDTO implements Serializable {

	private static final long serialVersionUID = 8857711477290949098L;

	private String name;

	private String email;

	private String password;

	private ArrayList<Phone> phones;

}
