package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the VEHICLE_OPTION_CATEGORY database table.
 * 
 */
@Entity
@Table(name="VEHICLE_OPTION_CATEGORY")
@NamedQuery(name="VehicleOptionCategory.findAll", query="SELECT v FROM VehicleOptionCategory v")
public class VehicleOptionCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private String description;

	@Column(name="\"TYPE\"")
	private BigDecimal type;

	public VehicleOptionCategory() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getType() {
		return this.type;
	}

	public void setType(BigDecimal type) {
		this.type = type;
	}

}