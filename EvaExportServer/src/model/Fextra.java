package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FEXTRAS database table.
 * 
 */
@Entity
@Table(name="FEXTRAS")
@NamedQuery(name="Fextra.findAll", query="SELECT f FROM Fextra f")
public class Fextra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VEH_EXTRA_NO")
	private long vehExtraNo;

	@Column(name="AMORTIZATION_RATE")
	private BigDecimal amortizationRate;

	@Column(name="ASSESS_CODED_DATA")
	private String assessCodedData;

	private String category;

	@Column(name="COMPANY_ID")
	private String companyId;

	private String descr;

	@Column(name="EQUIP_NO")
	private String equipNo;

	@Column(name="INST_COSTS")
	private BigDecimal instCosts;

	@Column(name="INST_TYPE")
	private BigDecimal instType;

	@Column(name="\"KEY\"")
	private String key;

	private String mbvobject;

	@Column(name="ORIGINAL_PRICE")
	private BigDecimal originalPrice;

	@Column(name="PACKET_KEY")
	private String packetKey;

	private BigDecimal price;

	@Column(name="PRICE_FLAGS")
	private BigDecimal priceFlags;

	private BigDecimal subtype;

	@Column(name="TRANSFER_MODE")
	private BigDecimal transferMode;

	@Column(name="\"TYPE\"")
	private String type;

	@Temporal(TemporalType.DATE)
	@Column(name="UPD_DATE")
	private Date updDate;

	@Column(name="XTRA_RELEVANT")
	private BigDecimal xtraRelevant;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	@JoinColumn(name="VEHICLE_NO")
	private Vehicle vehicle;

	public Fextra() {
	}

	public long getVehExtraNo() {
		return this.vehExtraNo;
	}

	public void setVehExtraNo(long vehExtraNo) {
		this.vehExtraNo = vehExtraNo;
	}

	public BigDecimal getAmortizationRate() {
		return this.amortizationRate;
	}

	public void setAmortizationRate(BigDecimal amortizationRate) {
		this.amortizationRate = amortizationRate;
	}

	public String getAssessCodedData() {
		return this.assessCodedData;
	}

	public void setAssessCodedData(String assessCodedData) {
		this.assessCodedData = assessCodedData;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getEquipNo() {
		return this.equipNo;
	}

	public void setEquipNo(String equipNo) {
		this.equipNo = equipNo;
	}

	public BigDecimal getInstCosts() {
		return this.instCosts;
	}

	public void setInstCosts(BigDecimal instCosts) {
		this.instCosts = instCosts;
	}

	public BigDecimal getInstType() {
		return this.instType;
	}

	public void setInstType(BigDecimal instType) {
		this.instType = instType;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMbvobject() {
		return this.mbvobject;
	}

	public void setMbvobject(String mbvobject) {
		this.mbvobject = mbvobject;
	}

	public BigDecimal getOriginalPrice() {
		return this.originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getPacketKey() {
		return this.packetKey;
	}

	public void setPacketKey(String packetKey) {
		this.packetKey = packetKey;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPriceFlags() {
		return this.priceFlags;
	}

	public void setPriceFlags(BigDecimal priceFlags) {
		this.priceFlags = priceFlags;
	}

	public BigDecimal getSubtype() {
		return this.subtype;
	}

	public void setSubtype(BigDecimal subtype) {
		this.subtype = subtype;
	}

	public BigDecimal getTransferMode() {
		return this.transferMode;
	}

	public void setTransferMode(BigDecimal transferMode) {
		this.transferMode = transferMode;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public BigDecimal getXtraRelevant() {
		return this.xtraRelevant;
	}

	public void setXtraRelevant(BigDecimal xtraRelevant) {
		this.xtraRelevant = xtraRelevant;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}