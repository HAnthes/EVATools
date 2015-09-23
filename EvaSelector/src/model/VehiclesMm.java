package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the VEHICLES_MM database table.
 * 
 */
@Entity
@Table(name="VEHICLES_MM")
@NamedQuery(name="VehiclesMm.findAll", query="SELECT v FROM VehiclesMm v")
public class VehiclesMm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VEHICLES_MM_NO")
	private long vehiclesMmNo;

	@Lob
	@Column(name="\"DATA\"")
	private byte[] data;

	private String description;

	@Column(name="DO_USE_FOR_STK_EXCH")
	private BigDecimal doUseForStkExch;

	private String filename;

	@Column(name="FILENAME_CONTAINS_URL")
	private BigDecimal filenameContainsUrl;

	@Column(name="OPTION_KEY")
	private String optionKey;

	@Column(name="REF_TYPE")
	private BigDecimal refType;

	@Temporal(TemporalType.DATE)
	@Column(name="TIME_STAMP")
	private Date timeStamp;

	@Column(name="\"TYPE\"")
	private BigDecimal type;

	@Column(name="VIEW_TYPE")
	private BigDecimal viewType;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	@JoinColumn(name="VEHICLE_NO")
	private Vehicle vehicle;

	public VehiclesMm() {
	}

	public long getVehiclesMmNo() {
		return this.vehiclesMmNo;
	}

	public void setVehiclesMmNo(long vehiclesMmNo) {
		this.vehiclesMmNo = vehiclesMmNo;
	}

	public byte[] getData() {
		return this.data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDoUseForStkExch() {
		return this.doUseForStkExch;
	}

	public void setDoUseForStkExch(BigDecimal doUseForStkExch) {
		this.doUseForStkExch = doUseForStkExch;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public BigDecimal getFilenameContainsUrl() {
		return this.filenameContainsUrl;
	}

	public void setFilenameContainsUrl(BigDecimal filenameContainsUrl) {
		this.filenameContainsUrl = filenameContainsUrl;
	}

	public String getOptionKey() {
		return this.optionKey;
	}

	public void setOptionKey(String optionKey) {
		this.optionKey = optionKey;
	}

	public BigDecimal getRefType() {
		return this.refType;
	}

	public void setRefType(BigDecimal refType) {
		this.refType = refType;
	}

	public Date getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public BigDecimal getType() {
		return this.type;
	}

	public void setType(BigDecimal type) {
		this.type = type;
	}

	public BigDecimal getViewType() {
		return this.viewType;
	}

	public void setViewType(BigDecimal viewType) {
		this.viewType = viewType;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}