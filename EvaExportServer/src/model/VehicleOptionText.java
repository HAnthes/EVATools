package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the VEHICLE_OPTION_TEXTS database table.
 * 
 */
@Entity
@Table(name="VEHICLE_OPTION_TEXTS")
@NamedQuery(name="VehicleOptionText.findAll", query="SELECT v FROM VehicleOptionText v")
public class VehicleOptionText implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VehicleOptionTextPK id;

	private String description;

	@Column(name="SHORT_DESC")
	private String shortDesc;

	public VehicleOptionText() {
	}

	public VehicleOptionTextPK getId() {
		return this.id;
	}

	public void setId(VehicleOptionTextPK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

}