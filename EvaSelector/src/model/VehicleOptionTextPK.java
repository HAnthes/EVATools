package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the VEHICLE_OPTION_TEXTS database table.
 * 
 */
@Embeddable
public class VehicleOptionTextPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SYSTEM_TYPE")
	private long systemType;

	@Column(name="SYSTEM_CODE")
	private String systemCode;

	public VehicleOptionTextPK() {
	}
	public long getSystemType() {
		return this.systemType;
	}
	public void setSystemType(long systemType) {
		this.systemType = systemType;
	}
	public String getSystemCode() {
		return this.systemCode;
	}
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VehicleOptionTextPK)) {
			return false;
		}
		VehicleOptionTextPK castOther = (VehicleOptionTextPK)other;
		return 
			(this.systemType == castOther.systemType)
			&& this.systemCode.equals(castOther.systemCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.systemType ^ (this.systemType >>> 32)));
		hash = hash * prime + this.systemCode.hashCode();
		
		return hash;
	}
}