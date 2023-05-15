package cl.bci.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable{

	private static final long serialVersionUID = -7071016913020377467L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ApiModelProperty(hidden = true)
    private UUID id;

	private String name;

	@Column(unique=true)
	private String email;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	private ArrayList<Phone> phones;
	
	@CreationTimestamp
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date created;

    @UpdateTimestamp
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date modified;
    
    @CreationTimestamp
    @JsonProperty(value="last_login", access = JsonProperty.Access.READ_ONLY)
    private Date lastLogin;
    
    private boolean active;
    
	@GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ApiModelProperty(hidden = true)
    private UUID token;
    
    

}

