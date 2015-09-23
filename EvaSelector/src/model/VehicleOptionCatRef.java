package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the VEHICLE_OPTION_CAT_REF database table.
 * 
 */
@Entity
@Table(name="VEHICLE_OPTION_CAT_REF")
@NamedQuery(name="VehicleOptionCatRef.findAll", query="SELECT v FROM VehicleOptionCatRef v")
public class VehicleOptionCatRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VEHICLE_OPTION_CAT_REF_NO")
	private long vehicleOptionCatRefNo;

	private String code;

	@Column(name="DEALER_GROUP_NO")
	private BigDecimal dealerGroupNo;

	@Column(name="DO_NOT_UPDATE")
	private BigDecimal doNotUpdate;

	@Column(name="IS_TEMPORARY")
	private BigDecimal isTemporary;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_TRANSFER")
	private Date lastTransfer;

	@Column(name="SYSTEM_CODE")
	private String systemCode;

	@Column(name="SYSTEM_TYPE")
	private BigDecimal systemType;

	@Temporal(TemporalType.DATE)
	@Column(name="\"TIMESTAMP\"")
	private Date timestamp;

	@Column(name="TRANSFER_MODE")
	private BigDecimal transferMode;

	public VehicleOptionCatRef() {
	}

	public long getVehicleOptionCatRefNo() {
		return this.vehicleOptionCatRefNo;
	}

	public void setVehicleOptionCatRefNo(long vehicleOptionCatRefNo) {
		this.vehicleOptionCatRefNo = vehicleOptionCatRefNo;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getDealerGroupNo() {
		return this.dealerGroupNo;
	}

	public void setDealerGroupNo(BigDecimal dealerGroupNo) {
		this.dealerGroupNo = dealerGroupNo;
	}

	public BigDecimal getDoNotUpdate() {
		return this.doNotUpdate;
	}

	public void setDoNotUpdate(BigDecimal doNotUpdate) {
		this.doNotUpdate = doNotUpdate;
	}

	public BigDecimal getIsTemporary() {
		return this.isTemporary;
	}

	public void setIsTemporary(BigDecimal isTemporary) {
		this.isTemporary = isTemporary;
	}

	public Date getLastTransfer() {
		return this.lastTransfer;
	}

	public void setLastTransfer(Date lastTransfer) {
		this.lastTransfer = lastTransfer;
	}

	public String getSystemCode() {
		return this.systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public BigDecimal getSystemType() {
		return this.systemType;
	}

	public void setSystemType(BigDecimal systemType) {
		this.systemType = systemType;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public BigDecimal getTransferMode() {
		return this.transferMode;
	}

	public void setTransferMode(BigDecimal transferMode) {
		this.transferMode = transferMode;
	}

}