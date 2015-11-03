package model;

import java.io.Serializable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the VEHICLES database table.
 * 
 */
@Entity
@Table(name="VEHICLES")
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VEHICLE_NO")
	private Long vehicleNo;

	@Column(name="ACC_DAMAGES_NUM")
	private BigDecimal accDamagesNum;

	@Column(name="ACC_REPAIRED_BY")
	private String accRepairedBy;

	@Column(name="ACCIDENT_FREE")
	private BigDecimal accidentFree;

	@Column(name="ADDITIONAL_USAGE_CODE")
	private BigDecimal additionalUsageCode;

	@Column(name="ALLOW_PROPGTN")
	private BigDecimal allowPropgtn;

	private BigDecimal allwheel;

	@Column(name="ASS_CORRECTION_FACTOR")
	private BigDecimal assCorrectionFactor;

	@Column(name="ASS_ESTIMATION")
	private BigDecimal assEstimation;

	@Column(name="ASS_USER")
	private String assUser;

	@Column(name="ASS_USER_FIRST_NAME")
	private String assUserFirstName;

	@Column(name="ASSEMBLY_COMPANY_ID")
	private String assemblyCompanyId;

	@Column(name="ASSESS_CODED_DATA")
	private String assessCodedData;

	@Column(name="ASSESS_SYS_ID")
	private BigDecimal assessSysId;

	private BigDecimal auto;

	@Column(name="BASE_MODEL_EMISS")
	private BigDecimal baseModelEmiss;

	@Column(name="BASE_VEHICLE_NO")
	private BigDecimal baseVehicleNo;

	@Column(name="BODY_CODE")
	private BigDecimal bodyCode;

	@Column(name="BUSINESS_TYPE")
	private BigDecimal businessType;

	@Column(name="CALC_INFO")
	private String calcInfo;

	private BigDecimal capacity;

	@Column(name="CAR_CONDITION")
	private String carCondition;

	@Column(name="CAR_SEATS")
	private BigDecimal carSeats;

	@Column(name="CARE_STATUS")
	private BigDecimal careStatus;

	private String chassis;

	private String chassisno;

	@Column(name="CLEAR_LEVEL_EDIT")
	private BigDecimal clearLevelEdit;

	@Column(name="CLEAR_LEVEL_VIEW")
	private BigDecimal clearLevelView;

	@Column(name="COLOR_EXT_BRIGHTNESS")
	private String colorExtBrightness;

	@Column(name="COLOR_EXT_GENERIC")
	private String colorExtGeneric;

	@Column(name="COLOR_EXT_MBV")
	private String colorExtMbv;

	@Column(name="COLOR_EXT_PRICE")
	private BigDecimal colorExtPrice;

	@Column(name="COLOR_EXT_TEXT")
	private String colorExtText;

	@Column(name="COLOR_EXT_TYPE")
	private BigDecimal colorExtType;

	@Column(name="COLOR_EXT_TYPE_GENERIC")
	private String colorExtTypeGeneric;

	@Column(name="COLOR_INT_MBV")
	private String colorIntMbv;

	@Column(name="COLOR_INT_TEXT")
	private String colorIntText;

	@Column(name="COLOR_KEY")
	private String colorKey;

	@Column(name="COLOR_PRICE_FLAGS")
	private BigDecimal colorPriceFlags;

	@Column(name="COMP_NO")
	private String compNo;

	@Column(name="COMPANY_NO")
	private BigDecimal companyNo;

	@Column(name="CONFIG_ID")
	private BigDecimal configId;

	@Column(name="CONFIGURATION_FLAGS")
	private BigDecimal configurationFlags;

	@Column(name="CONSUMP_CITY")
	private BigDecimal consumpCity;

	@Column(name="CONSUMP_CITY_ALT")
	private BigDecimal consumpCityAlt;

	@Temporal(TemporalType.DATE)
	@Column(name="CONSUMP_CREATION_DATE")
	private Date consumpCreationDate;

	@Column(name="CONSUMP_EFFICENCY")
	private String consumpEfficency;

	@Column(name="CONSUMP_ELECTRICITY")
	private BigDecimal consumpElectricity;

	@Column(name="CONSUMP_MIX")
	private BigDecimal consumpMix;

	@Column(name="CONSUMP_MIX_ALT")
	private BigDecimal consumpMixAlt;

	@Column(name="CONSUMP_ROAD")
	private BigDecimal consumpRoad;

	@Column(name="CONSUMP_ROAD_ALT")
	private BigDecimal consumpRoadAlt;

	@Column(name="CONSUMP_TAX")
	private BigDecimal consumpTax;

	@Column(name="CONSUMP_UNIT")
	private BigDecimal consumpUnit;

	@Column(name="CONSUMP_UNIT_ALT")
	private BigDecimal consumpUnitAlt;

	@Temporal(TemporalType.DATE)
	@Column(name="CONTRACT_END_DATE")
	private Date contractEndDate;

	@Column(name="CURRENCY_FLAG")
	private BigDecimal currencyFlag;

	@Column(name="CURRENCY_TYPE")
	private BigDecimal currencyType;

	private BigDecimal cylinders;

	@Column(name="DAMAGES_DESC")
	private String damagesDesc;

	@Column(name="DAMAGES_DESC_DETAILS")
	private String damagesDescDetails;

	@Column(name="DAMAGES_DESC_OTHER")
	private String damagesDescOther;

	@Column(name="DATA_EXTENSION")
	private String dataExtension;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_BUY_NEW")
	private Date dateBuyNew;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_CHANGED")
	private Date dateChanged;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_CREATED")
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_LAST_INSPEC")
	private Date dateLastInspec;

	@Column(name="DEALER_NO")
	private BigDecimal dealerNo;

	@Column(name="DEBIT_TEXT")
	private String debitText;

	@Temporal(TemporalType.DATE)
	@Column(name="DELIV_DATE")
	private Date delivDate;

	private BigDecimal demobil;

	private String demobilno;

	@Column(name="DEMONSTR_MOD")
	private BigDecimal demonstrMod;

	@Column(name="DEPRECIATION_AMOUNT")
	private BigDecimal depreciationAmount;

	@Column(name="DESIGN_DESC")
	private String designDesc;

	@Column(name="DO_PUBLISH_DATA")
	private BigDecimal doPublishData;

	private BigDecimal doors;

	@Column(name="ELECTRICITY_COSTS")
	private BigDecimal electricityCosts;

	@Column(name="ELECTRICITY_TARIFF")
	private BigDecimal electricityTariff;

	@Column(name="EMIS_BADGE")
	private BigDecimal emisBadge;

	@Column(name="EMIS_STANDARD")
	private BigDecimal emisStandard;

	@Column(name="EMISS_CO2_CITY")
	private BigDecimal emissCo2City;

	@Column(name="EMISS_CO2_MIX")
	private BigDecimal emissCo2Mix;

	@Column(name="EMISS_CO2_MIX_ALT")
	private BigDecimal emissCo2MixAlt;

	@Column(name="EMISS_CO2_ROAD")
	private BigDecimal emissCo2Road;

	@Column(name="EMISSION_CHECK")
	private String emissionCheck;

	private BigDecimal engine;

	@Temporal(TemporalType.DATE)
	@Column(name="EST_TAKEIN_DATE")
	private Date estTakeinDate;

	private BigDecimal euromobil;

	@Column(name="EXCHANGE_ID")
	private String exchangeId;

	@Temporal(TemporalType.DATE)
	@Column(name="EXT_SYS_TIMESTAMP")
	private Date extSysTimestamp;

	@Column(name="FINANCE_PRICE")
	private BigDecimal financePrice;

	@Column(name="FINANCE_TYPE")
	private BigDecimal financeType;

	private BigDecimal flags;

	@Column(name="FUEL_COSTS")
	private BigDecimal fuelCosts;

	@Column(name="FUEL_ID")
	private String fuelId;

	@Column(name="FUEL_ID_ALT")
	private String fuelIdAlt;

	@Column(name="FUEL_TARIFF")
	private BigDecimal fuelTariff;

	@Column(name="FUEL_TEXT")
	private String fuelText;

	@Column(name="FUEL_TEXT_ALT")
	private String fuelTextAlt;

	@Column(name="GARAGE_MASTER_FIRST_NAME")
	private String garageMasterFirstName;

	@Column(name="GARAGE_MASTER_NAME")
	private String garageMasterName;

	@Column(name="GEAR_TEXT")
	private String gearText;

	@Column(name="GESA_MODEL_CODE")
	private String gesaModelCode;

	@Column(name="GW_PLUS")
	private BigDecimal gwPlus;

	@Column(name="HAS_1ST_MOTOR")
	private BigDecimal has1stMotor;

	@Column(name="HAS_1ST_SPEEDO")
	private BigDecimal has1stSpeedo;

	@Column(name="HAS_CONSUMPTIONS")
	private BigDecimal hasConsumptions;

	private String hints;

	private String hsn;

	@Column(name="HSN_T")
	private String hsnT;

	@Column(name="INSP_PAPER_COPIES")
	private BigDecimal inspPaperCopies;

	@Column(name="IS_DEBIT")
	private BigDecimal isDebit;

	@Column(name="IS_GEWATO")
	private BigDecimal isGewato;

	@Column(name="IS_PRECONFIG_VEHICLE")
	private BigDecimal isPreconfigVehicle;

	@Column(name="IS_REIMPORTED")
	private BigDecimal isReimported;

	private BigDecimal iscpncar;

	private BigDecimal issyscar;

	private BigDecimal isused;

	private String keyno;

	@Column(name="KM_LAST_INSPEC")
	private String kmLastInspec;

	@Column(name="KNOWN_LACKS")
	private String knownLacks;

	@Column(name="KNOWN_LACKS_DETAILS")
	private String knownLacksDetails;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_ASS_DATE")
	private Date lastAssDate;

	private String loadarea;

	private String location;

	@Column(name="MAIN_CHECK")
	private String mainCheck;

	@Column(name="MAIN_GROUP")
	private BigDecimal mainGroup;

	@Column(name="MAKE_ID")
	private String makeId;

	@Column(name="MAKE_TEXT")
	private String makeText;

	@Column(name="MAKE_TEXT_LABELLING")
	private String makeTextLabelling;

	@Column(name="MANUFACT_YEAR")
	private BigDecimal manufactYear;

	@Column(name="MARKET_CODE")
	private String marketCode;

	@Column(name="MAX_WEIGHT")
	private BigDecimal maxWeight;

	@Column(name="MBV_CARLINE_GRP")
	private String mbvCarlineGrp;

	@Temporal(TemporalType.DATE)
	@Column(name="MBV_CHECK")
	private Date mbvCheck;

	@Temporal(TemporalType.DATE)
	@Column(name="MBV_VERSION_DATE")
	private Date mbvVersionDate;

	private String mbvbkgrp;

	private String mbvbook;

	private String mbvext;

	private String mbvorderformat;

	private String mbvorgext;

	private String mbvversion;

	private String mmobj1;

	private String mmobj2;

	private BigDecimal mobil;

	@Column(name="MODEL_TEXT")
	private String modelText;

	@Column(name="MODEL_TEXT_LABELLING")
	private String modelTextLabelling;

	@Column(name="MODEL_TYPE")
	private String modelType;

	private String modelkey;

	private BigDecimal modelyear;

	@Temporal(TemporalType.DATE)
	@Column(name="MOTOR_CHANGED_DATE")
	private Date motorChangedDate;

	@Column(name="MOTOR_CHANGED_KM")
	private BigDecimal motorChangedKm;

	@Column(name="MOTOR_CHANGED_TEXT")
	private String motorChangedText;

	@Column(name="MOTOR_ID")
	private BigDecimal motorId;

	private String motorno;

	@Column(name="NATIONAL_ID")
	private String nationalId;

	@Column(name="NEWADA_YEAR")
	private BigDecimal newadaYear;

	@Column(name="NUM_BERTHES")
	private BigDecimal numBerthes;

	@Column(name="ONE_DAY_REGISTRATION")
	private BigDecimal oneDayRegistration;

	@Column(name="ORDER_NO")
	private String orderNo;

	@Column(name="ORIGINAL_PRICE")
	private BigDecimal originalPrice;

	@Column(name="OTHER_ENERGY_SOURCE")
	private String otherEnergySource;

	@Column(name="OWNER_COUNT")
	private BigDecimal ownerCount;

	private BigDecimal payload;

	@Column(name="\"POWER\"")
	private BigDecimal power;

	@Column(name="PREPARATION_COSTS")
	private BigDecimal preparationCosts;

	@Column(name="PRICE_BUY")
	private BigDecimal priceBuy;

	@Column(name="PRICE_COMP")
	private BigDecimal priceComp;

	@Column(name="PRICE_LIST")
	private BigDecimal priceList;

	@Column(name="PRICE_SELL")
	private BigDecimal priceSell;

	@Column(name="PRIVATE_USAGE")
	private BigDecimal privateUsage;

	@Column(name="PRODUCT_LINE")
	private String productLine;

	@Column(name="PUBLIC_HINTS")
	private String publicHints;

	@Temporal(TemporalType.DATE)
	private Date purdate;

	private String radiono;

	@Column(name="RCRD_TYPE")
	private BigDecimal rcrdType;

	@Temporal(TemporalType.DATE)
	@Column(name="REG_CUST_DATE")
	private Date regCustDate;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	private String registr;

	@Column(name="REGISTR_DOC")
	private String registrDoc;

	@Column(name="REPAIR_COSTS")
	private BigDecimal repairCosts;

	@Column(name="RES_COMMENT")
	private String resComment;

	@Column(name="RESELLER_PRICE")
	private BigDecimal resellerPrice;

	@Column(name="RESERVE_STATE")
	private BigDecimal reserveState;

	@Column(name="RESERVED_BY")
	private String reservedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="RESERVED_TILL")
	private Date reservedTill;

	@Column(name="SEARCH_ASS_NO")
	private String searchAssNo;

	@Column(name="SELL_PRICE_CHANGED_BY")
	private String sellPriceChangedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="SELL_PRICE_CHANGED_DATE")
	private Date sellPriceChangedDate;

	private BigDecimal shfc;

	@Column(name="SPEC_CONSUMP_IDS")
	private String specConsumpIds;

	@Column(name="SPECIAL_MODEL_TEXT")
	private String specialModelText;

	@Temporal(TemporalType.DATE)
	@Column(name="SPEEDO_CHANGED_DATE")
	private Date speedoChangedDate;

	@Column(name="SPEEDO_CHANGED_KM")
	private BigDecimal speedoChangedKm;

	@Column(name="SPEEDO_CHANGED_TEXT")
	private String speedoChangedText;

	@Column(name="SPEEDO_KM")
	private BigDecimal speedoKm;

	@Column(name="STORAGE_COSTS")
	private BigDecimal storageCosts;

	@Column(name="SUMMER_TYRE")
	private BigDecimal summerTyre;

	@Column(name="SYSCAR_ADD_IN_PERCENT")
	private BigDecimal syscarAddInPercent;

	@Temporal(TemporalType.DATE)
	@Column(name="TAKEIN_DATE")
	private Date takeinDate;

	@Column(name="TAX_ID")
	private BigDecimal taxId;

	private BigDecimal taxi;

	private String text1;

	@Column(name="TEXT1_UP")
	private String text1Up;

	private String text2;

	@Column(name="TEXT2_UP")
	private String text2Up;

	@Column(name="TM_ICC_ID")
	private String tmIccId;

	@Column(name="TM_IMEI")
	private String tmImei;

	@Column(name="TM_KEY_ID")
	private String tmKeyId;

	@Column(name="TOTAL_KM")
	private BigDecimal totalKm;

	@Column(name="TRADE_PORT")
	private BigDecimal tradePort;

	@Column(name="TRAIL_COUPL")
	private BigDecimal trailCoupl;

	private String tsn;

	@Column(name="TSN_T")
	private String tsnT;

	@Column(name="TYRE_MANUFACTURER")
	private String tyreManufacturer;

	@Column(name="TYRE_SIZE")
	private String tyreSize;

	@Column(name="TYRE_STATE_FL")
	private BigDecimal tyreStateFl;

	@Column(name="TYRE_STATE_FR")
	private BigDecimal tyreStateFr;

	@Column(name="TYRE_STATE_RES")
	private BigDecimal tyreStateRes;

	@Column(name="TYRE_STATE_RL")
	private BigDecimal tyreStateRl;

	@Column(name="TYRE_STATE_RR")
	private BigDecimal tyreStateRr;

	@Column(name="UC_GUARANTEE_PREMIUM")
	private BigDecimal ucGuaranteePremium;

	@Column(name="UC_GUARANTEE_PROD_ID")
	private BigDecimal ucGuaranteeProdId;

	@Column(name="UC_GUARANTEE_PROD_OFFID")
	private BigDecimal ucGuaranteeProdOffid;

	@Temporal(TemporalType.DATE)
	@Column(name="UPD_DATE")
	private Date updDate;

	@Column(name="USED_DRIVING_SCHOOL")
	private BigDecimal usedDrivingSchool;

	@Column(name="USED_ELSE")
	private BigDecimal usedElse;

	@Column(name="USED_ELSE_TEXT")
	private String usedElseText;

	@Column(name="USED_RENTAL_CAR")
	private BigDecimal usedRentalCar;

	@Column(name="UV_TYPE")
	private BigDecimal uvType;

	@Column(name="VAUDIS_STATE")
	private String vaudisState;

	@Column(name="VEH_BODY")
	private String vehBody;

	@Column(name="VEH_SYS_TYPE")
	private String vehSysType;

	@Column(name="VEH_TYPE")
	private BigDecimal vehType;

	@Column(name="VEHICLE_ID_EXT")
	private BigDecimal vehicleIdExt;

	@Column(name="VEHICLE_MODEL")
	private BigDecimal vehicleModel;

	@Column(name="VEHICLE_NO_EXT")
	private BigDecimal vehicleNoExt;

	@Column(name="VISIT_COUNT")
	private BigDecimal visitCount;

	@Column(name="WAS_COMMERCIAL_USE")
	private BigDecimal wasCommercialUse;

	private BigDecimal weight;

	private String wheelbase;

	@Column(name="WINTER_TYPE")
	private BigDecimal winterType;

	private BigDecimal zdk;

	//bi-directional many-to-one association to VehiclesMm
	@OneToMany(mappedBy="vehicle" , fetch=FetchType.EAGER)
	private List<VehiclesMm> vehiclesMms;

	//bi-directional many-to-one association to Fextra
	@OneToMany(mappedBy="vehicle" )
	private List<Fextra> fextras;

	public Vehicle() {
	}

	public Long getVehicleNo() {
		return this.vehicleNo;
	}

	public void setVehicleNo(long vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public BigDecimal getAccDamagesNum() {
		return this.accDamagesNum;
	}

	public void setAccDamagesNum(BigDecimal accDamagesNum) {
		this.accDamagesNum = accDamagesNum;
	}

	public String getAccRepairedBy() {
		return this.accRepairedBy;
	}

	public void setAccRepairedBy(String accRepairedBy) {
		this.accRepairedBy = accRepairedBy;
	}

	public BigDecimal getAccidentFree() {
		return this.accidentFree;
	}

	public void setAccidentFree(BigDecimal accidentFree) {
		this.accidentFree = accidentFree;
	}

	public BigDecimal getAdditionalUsageCode() {
		return this.additionalUsageCode;
	}

	public void setAdditionalUsageCode(BigDecimal additionalUsageCode) {
		this.additionalUsageCode = additionalUsageCode;
	}

	public BigDecimal getAllowPropgtn() {
		return this.allowPropgtn;
	}

	public void setAllowPropgtn(BigDecimal allowPropgtn) {
		this.allowPropgtn = allowPropgtn;
	}

	public BigDecimal getAllwheel() {
		return this.allwheel;
	}

	public void setAllwheel(BigDecimal allwheel) {
		this.allwheel = allwheel;
	}

	public BigDecimal getAssCorrectionFactor() {
		return this.assCorrectionFactor;
	}

	public void setAssCorrectionFactor(BigDecimal assCorrectionFactor) {
		this.assCorrectionFactor = assCorrectionFactor;
	}

	public BigDecimal getAssEstimation() {
		return this.assEstimation;
	}

	public void setAssEstimation(BigDecimal assEstimation) {
		this.assEstimation = assEstimation;
	}

	public String getAssUser() {
		return this.assUser;
	}

	public void setAssUser(String assUser) {
		this.assUser = assUser;
	}

	public String getAssUserFirstName() {
		return this.assUserFirstName;
	}

	public void setAssUserFirstName(String assUserFirstName) {
		this.assUserFirstName = assUserFirstName;
	}

	public String getAssemblyCompanyId() {
		return this.assemblyCompanyId;
	}

	public void setAssemblyCompanyId(String assemblyCompanyId) {
		this.assemblyCompanyId = assemblyCompanyId;
	}

	public String getAssessCodedData() {
		return this.assessCodedData;
	}

	public void setAssessCodedData(String assessCodedData) {
		this.assessCodedData = assessCodedData;
	}

	public BigDecimal getAssessSysId() {
		return this.assessSysId;
	}

	public void setAssessSysId(BigDecimal assessSysId) {
		this.assessSysId = assessSysId;
	}

	public BigDecimal getAuto() {
		return this.auto;
	}

	public void setAuto(BigDecimal auto) {
		this.auto = auto;
	}

	public BigDecimal getBaseModelEmiss() {
		return this.baseModelEmiss;
	}

	public void setBaseModelEmiss(BigDecimal baseModelEmiss) {
		this.baseModelEmiss = baseModelEmiss;
	}

	public BigDecimal getBaseVehicleNo() {
		return this.baseVehicleNo;
	}

	public void setBaseVehicleNo(BigDecimal baseVehicleNo) {
		this.baseVehicleNo = baseVehicleNo;
	}

	public BigDecimal getBodyCode() {
		return this.bodyCode;
	}

	public void setBodyCode(BigDecimal bodyCode) {
		this.bodyCode = bodyCode;
	}

	public BigDecimal getBusinessType() {
		return this.businessType;
	}

	public void setBusinessType(BigDecimal businessType) {
		this.businessType = businessType;
	}

	public String getCalcInfo() {
		return this.calcInfo;
	}

	public void setCalcInfo(String calcInfo) {
		this.calcInfo = calcInfo;
	}

	public BigDecimal getCapacity() {
		return this.capacity;
	}

	public void setCapacity(BigDecimal capacity) {
		this.capacity = capacity;
	}

	public String getCarCondition() {
		return this.carCondition;
	}

	public void setCarCondition(String carCondition) {
		this.carCondition = carCondition;
	}

	public BigDecimal getCarSeats() {
		return this.carSeats;
	}

	public void setCarSeats(BigDecimal carSeats) {
		this.carSeats = carSeats;
	}

	public BigDecimal getCareStatus() {
		return this.careStatus;
	}

	public void setCareStatus(BigDecimal careStatus) {
		this.careStatus = careStatus;
	}

	public String getChassis() {
		return this.chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public String getChassisno() {
		return this.chassisno;
	}

	public void setChassisno(String chassisno) {
		this.chassisno = chassisno;
	}

	public BigDecimal getClearLevelEdit() {
		return this.clearLevelEdit;
	}

	public void setClearLevelEdit(BigDecimal clearLevelEdit) {
		this.clearLevelEdit = clearLevelEdit;
	}

	public BigDecimal getClearLevelView() {
		return this.clearLevelView;
	}

	public void setClearLevelView(BigDecimal clearLevelView) {
		this.clearLevelView = clearLevelView;
	}

	public String getColorExtBrightness() {
		return this.colorExtBrightness;
	}

	public void setColorExtBrightness(String colorExtBrightness) {
		this.colorExtBrightness = colorExtBrightness;
	}

	public String getColorExtGeneric() {
		return this.colorExtGeneric;
	}

	public void setColorExtGeneric(String colorExtGeneric) {
		this.colorExtGeneric = colorExtGeneric;
	}

	public String getColorExtMbv() {
		return this.colorExtMbv;
	}

	public void setColorExtMbv(String colorExtMbv) {
		this.colorExtMbv = colorExtMbv;
	}

	public BigDecimal getColorExtPrice() {
		return this.colorExtPrice;
	}

	public void setColorExtPrice(BigDecimal colorExtPrice) {
		this.colorExtPrice = colorExtPrice;
	}

	public String getColorExtText() {
		return this.colorExtText;
	}

	public void setColorExtText(String colorExtText) {
		this.colorExtText = colorExtText;
	}

	public BigDecimal getColorExtType() {
		return this.colorExtType;
	}

	public void setColorExtType(BigDecimal colorExtType) {
		this.colorExtType = colorExtType;
	}

	public String getColorExtTypeGeneric() {
		return this.colorExtTypeGeneric;
	}

	public void setColorExtTypeGeneric(String colorExtTypeGeneric) {
		this.colorExtTypeGeneric = colorExtTypeGeneric;
	}

	public String getColorIntMbv() {
		return this.colorIntMbv;
	}

	public void setColorIntMbv(String colorIntMbv) {
		this.colorIntMbv = colorIntMbv;
	}

	public String getColorIntText() {
		return this.colorIntText;
	}

	public void setColorIntText(String colorIntText) {
		this.colorIntText = colorIntText;
	}

	public String getColorKey() {
		return this.colorKey;
	}

	public void setColorKey(String colorKey) {
		this.colorKey = colorKey;
	}

	public BigDecimal getColorPriceFlags() {
		return this.colorPriceFlags;
	}

	public void setColorPriceFlags(BigDecimal colorPriceFlags) {
		this.colorPriceFlags = colorPriceFlags;
	}

	public String getCompNo() {
		return this.compNo;
	}

	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}

	public BigDecimal getCompanyNo() {
		return this.companyNo;
	}

	public void setCompanyNo(BigDecimal companyNo) {
		this.companyNo = companyNo;
	}

	public BigDecimal getConfigId() {
		return this.configId;
	}

	public void setConfigId(BigDecimal configId) {
		this.configId = configId;
	}

	public BigDecimal getConfigurationFlags() {
		return this.configurationFlags;
	}

	public void setConfigurationFlags(BigDecimal configurationFlags) {
		this.configurationFlags = configurationFlags;
	}

	public BigDecimal getConsumpCity() {
		return this.consumpCity;
	}

	public void setConsumpCity(BigDecimal consumpCity) {
		this.consumpCity = consumpCity;
	}

	public BigDecimal getConsumpCityAlt() {
		return this.consumpCityAlt;
	}

	public void setConsumpCityAlt(BigDecimal consumpCityAlt) {
		this.consumpCityAlt = consumpCityAlt;
	}

	public Date getConsumpCreationDate() {
		return this.consumpCreationDate;
	}

	public void setConsumpCreationDate(Date consumpCreationDate) {
		this.consumpCreationDate = consumpCreationDate;
	}

	public String getConsumpEfficency() {
		return this.consumpEfficency;
	}

	public void setConsumpEfficency(String consumpEfficency) {
		this.consumpEfficency = consumpEfficency;
	}

	public BigDecimal getConsumpElectricity() {
		return this.consumpElectricity;
	}

	public void setConsumpElectricity(BigDecimal consumpElectricity) {
		this.consumpElectricity = consumpElectricity;
	}

	public BigDecimal getConsumpMix() {
		return this.consumpMix;
	}

	public void setConsumpMix(BigDecimal consumpMix) {
		this.consumpMix = consumpMix;
	}

	public BigDecimal getConsumpMixAlt() {
		return this.consumpMixAlt;
	}

	public void setConsumpMixAlt(BigDecimal consumpMixAlt) {
		this.consumpMixAlt = consumpMixAlt;
	}

	public BigDecimal getConsumpRoad() {
		return this.consumpRoad;
	}

	public void setConsumpRoad(BigDecimal consumpRoad) {
		this.consumpRoad = consumpRoad;
	}

	public BigDecimal getConsumpRoadAlt() {
		return this.consumpRoadAlt;
	}

	public void setConsumpRoadAlt(BigDecimal consumpRoadAlt) {
		this.consumpRoadAlt = consumpRoadAlt;
	}

	public BigDecimal getConsumpTax() {
		return this.consumpTax;
	}

	public void setConsumpTax(BigDecimal consumpTax) {
		this.consumpTax = consumpTax;
	}

	public BigDecimal getConsumpUnit() {
		return this.consumpUnit;
	}

	public void setConsumpUnit(BigDecimal consumpUnit) {
		this.consumpUnit = consumpUnit;
	}

	public BigDecimal getConsumpUnitAlt() {
		return this.consumpUnitAlt;
	}

	public void setConsumpUnitAlt(BigDecimal consumpUnitAlt) {
		this.consumpUnitAlt = consumpUnitAlt;
	}

	public Date getContractEndDate() {
		return this.contractEndDate;
	}

	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public BigDecimal getCurrencyFlag() {
		return this.currencyFlag;
	}

	public void setCurrencyFlag(BigDecimal currencyFlag) {
		this.currencyFlag = currencyFlag;
	}

	public BigDecimal getCurrencyType() {
		return this.currencyType;
	}

	public void setCurrencyType(BigDecimal currencyType) {
		this.currencyType = currencyType;
	}

	public BigDecimal getCylinders() {
		return this.cylinders;
	}

	public void setCylinders(BigDecimal cylinders) {
		this.cylinders = cylinders;
	}

	public String getDamagesDesc() {
		return this.damagesDesc;
	}

	public void setDamagesDesc(String damagesDesc) {
		this.damagesDesc = damagesDesc;
	}

	public String getDamagesDescDetails() {
		return this.damagesDescDetails;
	}

	public void setDamagesDescDetails(String damagesDescDetails) {
		this.damagesDescDetails = damagesDescDetails;
	}

	public String getDamagesDescOther() {
		return this.damagesDescOther;
	}

	public void setDamagesDescOther(String damagesDescOther) {
		this.damagesDescOther = damagesDescOther;
	}

	public String getDataExtension() {
		return this.dataExtension;
	}

	public void setDataExtension(String dataExtension) {
		this.dataExtension = dataExtension;
	}

	public Date getDateBuyNew() {
		return this.dateBuyNew;
	}

	public void setDateBuyNew(Date dateBuyNew) {
		this.dateBuyNew = dateBuyNew;
	}

	public Date getDateChanged() {
		return this.dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateLastInspec() {
		return this.dateLastInspec;
	}

	public void setDateLastInspec(Date dateLastInspec) {
		this.dateLastInspec = dateLastInspec;
	}

	public BigDecimal getDealerNo() {
		return this.dealerNo;
	}

	public void setDealerNo(BigDecimal dealerNo) {
		this.dealerNo = dealerNo;
	}

	public String getDebitText() {
		return this.debitText;
	}

	public void setDebitText(String debitText) {
		this.debitText = debitText;
	}

	public Date getDelivDate() {
		return this.delivDate;
	}

	public void setDelivDate(Date delivDate) {
		this.delivDate = delivDate;
	}

	public BigDecimal getDemobil() {
		return this.demobil;
	}

	public void setDemobil(BigDecimal demobil) {
		this.demobil = demobil;
	}

	public String getDemobilno() {
		return this.demobilno;
	}

	public void setDemobilno(String demobilno) {
		this.demobilno = demobilno;
	}

	public BigDecimal getDemonstrMod() {
		return this.demonstrMod;
	}

	public void setDemonstrMod(BigDecimal demonstrMod) {
		this.demonstrMod = demonstrMod;
	}

	public BigDecimal getDepreciationAmount() {
		return this.depreciationAmount;
	}

	public void setDepreciationAmount(BigDecimal depreciationAmount) {
		this.depreciationAmount = depreciationAmount;
	}

	public String getDesignDesc() {
		return this.designDesc;
	}

	public void setDesignDesc(String designDesc) {
		this.designDesc = designDesc;
	}

	public BigDecimal getDoPublishData() {
		return this.doPublishData;
	}

	public void setDoPublishData(BigDecimal doPublishData) {
		this.doPublishData = doPublishData;
	}

	public BigDecimal getDoors() {
		return this.doors;
	}

	public void setDoors(BigDecimal doors) {
		this.doors = doors;
	}

	public BigDecimal getElectricityCosts() {
		return this.electricityCosts;
	}

	public void setElectricityCosts(BigDecimal electricityCosts) {
		this.electricityCosts = electricityCosts;
	}

	public BigDecimal getElectricityTariff() {
		return this.electricityTariff;
	}

	public void setElectricityTariff(BigDecimal electricityTariff) {
		this.electricityTariff = electricityTariff;
	}

	public BigDecimal getEmisBadge() {
		return this.emisBadge;
	}

	public void setEmisBadge(BigDecimal emisBadge) {
		this.emisBadge = emisBadge;
	}

	public BigDecimal getEmisStandard() {
		return this.emisStandard;
	}

	public void setEmisStandard(BigDecimal emisStandard) {
		this.emisStandard = emisStandard;
	}

	public BigDecimal getEmissCo2City() {
		return this.emissCo2City;
	}

	public void setEmissCo2City(BigDecimal emissCo2City) {
		this.emissCo2City = emissCo2City;
	}

	public BigDecimal getEmissCo2Mix() {
		return this.emissCo2Mix;
	}

	public void setEmissCo2Mix(BigDecimal emissCo2Mix) {
		this.emissCo2Mix = emissCo2Mix;
	}

	public BigDecimal getEmissCo2MixAlt() {
		return this.emissCo2MixAlt;
	}

	public void setEmissCo2MixAlt(BigDecimal emissCo2MixAlt) {
		this.emissCo2MixAlt = emissCo2MixAlt;
	}

	public BigDecimal getEmissCo2Road() {
		return this.emissCo2Road;
	}

	public void setEmissCo2Road(BigDecimal emissCo2Road) {
		this.emissCo2Road = emissCo2Road;
	}

	public String getEmissionCheck() {
		return this.emissionCheck;
	}

	public void setEmissionCheck(String emissionCheck) {
		this.emissionCheck = emissionCheck;
	}

	public BigDecimal getEngine() {
		return this.engine;
	}

	public void setEngine(BigDecimal engine) {
		this.engine = engine;
	}

	public Date getEstTakeinDate() {
		return this.estTakeinDate;
	}

	public void setEstTakeinDate(Date estTakeinDate) {
		this.estTakeinDate = estTakeinDate;
	}

	public BigDecimal getEuromobil() {
		return this.euromobil;
	}

	public void setEuromobil(BigDecimal euromobil) {
		this.euromobil = euromobil;
	}

	public String getExchangeId() {
		return this.exchangeId;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}

	public Date getExtSysTimestamp() {
		return this.extSysTimestamp;
	}

	public void setExtSysTimestamp(Date extSysTimestamp) {
		this.extSysTimestamp = extSysTimestamp;
	}

	public BigDecimal getFinancePrice() {
		return this.financePrice;
	}

	public void setFinancePrice(BigDecimal financePrice) {
		this.financePrice = financePrice;
	}

	public BigDecimal getFinanceType() {
		return this.financeType;
	}

	public void setFinanceType(BigDecimal financeType) {
		this.financeType = financeType;
	}

	public BigDecimal getFlags() {
		return this.flags;
	}

	public void setFlags(BigDecimal flags) {
		this.flags = flags;
	}

	public BigDecimal getFuelCosts() {
		return this.fuelCosts;
	}

	public void setFuelCosts(BigDecimal fuelCosts) {
		this.fuelCosts = fuelCosts;
	}

	public String getFuelId() {
		return this.fuelId;
	}

	public void setFuelId(String fuelId) {
		this.fuelId = fuelId;
	}

	public String getFuelIdAlt() {
		return this.fuelIdAlt;
	}

	public void setFuelIdAlt(String fuelIdAlt) {
		this.fuelIdAlt = fuelIdAlt;
	}

	public BigDecimal getFuelTariff() {
		return this.fuelTariff;
	}

	public void setFuelTariff(BigDecimal fuelTariff) {
		this.fuelTariff = fuelTariff;
	}

	public String getFuelText() {
		return this.fuelText;
	}

	public void setFuelText(String fuelText) {
		this.fuelText = fuelText;
	}

	public String getFuelTextAlt() {
		return this.fuelTextAlt;
	}

	public void setFuelTextAlt(String fuelTextAlt) {
		this.fuelTextAlt = fuelTextAlt;
	}

	public String getGarageMasterFirstName() {
		return this.garageMasterFirstName;
	}

	public void setGarageMasterFirstName(String garageMasterFirstName) {
		this.garageMasterFirstName = garageMasterFirstName;
	}

	public String getGarageMasterName() {
		return this.garageMasterName;
	}

	public void setGarageMasterName(String garageMasterName) {
		this.garageMasterName = garageMasterName;
	}

	public String getGearText() {
		return this.gearText;
	}

	public void setGearText(String gearText) {
		this.gearText = gearText;
	}

	public String getGesaModelCode() {
		return this.gesaModelCode;
	}

	public void setGesaModelCode(String gesaModelCode) {
		this.gesaModelCode = gesaModelCode;
	}

	public BigDecimal getGwPlus() {
		return this.gwPlus;
	}

	public void setGwPlus(BigDecimal gwPlus) {
		this.gwPlus = gwPlus;
	}

	public BigDecimal getHas1stMotor() {
		return this.has1stMotor;
	}

	public void setHas1stMotor(BigDecimal has1stMotor) {
		this.has1stMotor = has1stMotor;
	}

	public BigDecimal getHas1stSpeedo() {
		return this.has1stSpeedo;
	}

	public void setHas1stSpeedo(BigDecimal has1stSpeedo) {
		this.has1stSpeedo = has1stSpeedo;
	}

	public BigDecimal getHasConsumptions() {
		return this.hasConsumptions;
	}

	public void setHasConsumptions(BigDecimal hasConsumptions) {
		this.hasConsumptions = hasConsumptions;
	}

	public String getHints() {
		return this.hints;
	}

	public void setHints(String hints) {
		this.hints = hints;
	}

	public String getHsn() {
		return this.hsn;
	}

	public void setHsn(String hsn) {
		this.hsn = hsn;
	}

	public String getHsnT() {
		return this.hsnT;
	}

	public void setHsnT(String hsnT) {
		this.hsnT = hsnT;
	}

	public BigDecimal getInspPaperCopies() {
		return this.inspPaperCopies;
	}

	public void setInspPaperCopies(BigDecimal inspPaperCopies) {
		this.inspPaperCopies = inspPaperCopies;
	}

	public BigDecimal getIsDebit() {
		return this.isDebit;
	}

	public void setIsDebit(BigDecimal isDebit) {
		this.isDebit = isDebit;
	}

	public BigDecimal getIsGewato() {
		return this.isGewato;
	}

	public void setIsGewato(BigDecimal isGewato) {
		this.isGewato = isGewato;
	}

	public BigDecimal getIsPreconfigVehicle() {
		return this.isPreconfigVehicle;
	}

	public void setIsPreconfigVehicle(BigDecimal isPreconfigVehicle) {
		this.isPreconfigVehicle = isPreconfigVehicle;
	}

	public BigDecimal getIsReimported() {
		return this.isReimported;
	}

	public void setIsReimported(BigDecimal isReimported) {
		this.isReimported = isReimported;
	}

	public BigDecimal getIscpncar() {
		return this.iscpncar;
	}

	public void setIscpncar(BigDecimal iscpncar) {
		this.iscpncar = iscpncar;
	}

	public BigDecimal getIssyscar() {
		return this.issyscar;
	}

	public void setIssyscar(BigDecimal issyscar) {
		this.issyscar = issyscar;
	}

	public BigDecimal getIsused() {
		return this.isused;
	}

	public void setIsused(BigDecimal isused) {
		this.isused = isused;
	}

	public String getKeyno() {
		return this.keyno;
	}

	public void setKeyno(String keyno) {
		this.keyno = keyno;
	}

	public String getKmLastInspec() {
		return this.kmLastInspec;
	}

	public void setKmLastInspec(String kmLastInspec) {
		this.kmLastInspec = kmLastInspec;
	}

	public String getKnownLacks() {
		return this.knownLacks;
	}

	public void setKnownLacks(String knownLacks) {
		this.knownLacks = knownLacks;
	}

	public String getKnownLacksDetails() {
		return this.knownLacksDetails;
	}

	public void setKnownLacksDetails(String knownLacksDetails) {
		this.knownLacksDetails = knownLacksDetails;
	}

	public Date getLastAssDate() {
		return this.lastAssDate;
	}

	public void setLastAssDate(Date lastAssDate) {
		this.lastAssDate = lastAssDate;
	}

	public String getLoadarea() {
		return this.loadarea;
	}

	public void setLoadarea(String loadarea) {
		this.loadarea = loadarea;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMainCheck() {
		return this.mainCheck;
	}

	public void setMainCheck(String mainCheck) {
		this.mainCheck = mainCheck;
	}

	public BigDecimal getMainGroup() {
		return this.mainGroup;
	}

	public void setMainGroup(BigDecimal mainGroup) {
		this.mainGroup = mainGroup;
	}

	public String getMakeId() {
		return this.makeId;
	}

	public void setMakeId(String makeId) {
		this.makeId = makeId;
	}

	public String getMakeText() {
		return this.makeText;
	}

	public void setMakeText(String makeText) {
		this.makeText = makeText;
	}

	public String getMakeTextLabelling() {
		return this.makeTextLabelling;
	}

	public void setMakeTextLabelling(String makeTextLabelling) {
		this.makeTextLabelling = makeTextLabelling;
	}

	public BigDecimal getManufactYear() {
		return this.manufactYear;
	}

	public void setManufactYear(BigDecimal manufactYear) {
		this.manufactYear = manufactYear;
	}

	public String getMarketCode() {
		return this.marketCode;
	}

	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}

	public BigDecimal getMaxWeight() {
		return this.maxWeight;
	}

	public void setMaxWeight(BigDecimal maxWeight) {
		this.maxWeight = maxWeight;
	}

	public String getMbvCarlineGrp() {
		return this.mbvCarlineGrp;
	}

	public void setMbvCarlineGrp(String mbvCarlineGrp) {
		this.mbvCarlineGrp = mbvCarlineGrp;
	}

	public Date getMbvCheck() {
		return this.mbvCheck;
	}

	public void setMbvCheck(Date mbvCheck) {
		this.mbvCheck = mbvCheck;
	}

	public Date getMbvVersionDate() {
		return this.mbvVersionDate;
	}

	public void setMbvVersionDate(Date mbvVersionDate) {
		this.mbvVersionDate = mbvVersionDate;
	}

	public String getMbvbkgrp() {
		return this.mbvbkgrp;
	}

	public void setMbvbkgrp(String mbvbkgrp) {
		this.mbvbkgrp = mbvbkgrp;
	}

	public String getMbvbook() {
		return this.mbvbook;
	}

	public void setMbvbook(String mbvbook) {
		this.mbvbook = mbvbook;
	}

	public String getMbvext() {
		return this.mbvext;
	}

	public void setMbvext(String mbvext) {
		this.mbvext = mbvext;
	}

	public String getMbvorderformat() {
		return this.mbvorderformat;
	}

	public void setMbvorderformat(String mbvorderformat) {
		this.mbvorderformat = mbvorderformat;
	}

	public String getMbvorgext() {
		return this.mbvorgext;
	}

	public void setMbvorgext(String mbvorgext) {
		this.mbvorgext = mbvorgext;
	}

	public String getMbvversion() {
		return this.mbvversion;
	}

	public void setMbvversion(String mbvversion) {
		this.mbvversion = mbvversion;
	}

	public String getMmobj1() {
		return this.mmobj1;
	}

	public void setMmobj1(String mmobj1) {
		this.mmobj1 = mmobj1;
	}

	public String getMmobj2() {
		return this.mmobj2;
	}

	public void setMmobj2(String mmobj2) {
		this.mmobj2 = mmobj2;
	}

	public BigDecimal getMobil() {
		return this.mobil;
	}

	public void setMobil(BigDecimal mobil) {
		this.mobil = mobil;
	}

	public String getModelText() {
		return this.modelText;
	}

	public void setModelText(String modelText) {
		this.modelText = modelText;
	}

	public String getModelTextLabelling() {
		return this.modelTextLabelling;
	}

	public void setModelTextLabelling(String modelTextLabelling) {
		this.modelTextLabelling = modelTextLabelling;
	}

	public String getModelType() {
		return this.modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public String getModelkey() {
		return this.modelkey;
	}

	public void setModelkey(String modelkey) {
		this.modelkey = modelkey;
	}

	public BigDecimal getModelyear() {
		return this.modelyear;
	}

	public void setModelyear(BigDecimal modelyear) {
		this.modelyear = modelyear;
	}

	public Date getMotorChangedDate() {
		return this.motorChangedDate;
	}

	public void setMotorChangedDate(Date motorChangedDate) {
		this.motorChangedDate = motorChangedDate;
	}

	public BigDecimal getMotorChangedKm() {
		return this.motorChangedKm;
	}

	public void setMotorChangedKm(BigDecimal motorChangedKm) {
		this.motorChangedKm = motorChangedKm;
	}

	public String getMotorChangedText() {
		return this.motorChangedText;
	}

	public void setMotorChangedText(String motorChangedText) {
		this.motorChangedText = motorChangedText;
	}

	public BigDecimal getMotorId() {
		return this.motorId;
	}

	public void setMotorId(BigDecimal motorId) {
		this.motorId = motorId;
	}

	public String getMotorno() {
		return this.motorno;
	}

	public void setMotorno(String motorno) {
		this.motorno = motorno;
	}

	public String getNationalId() {
		return this.nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public BigDecimal getNewadaYear() {
		return this.newadaYear;
	}

	public void setNewadaYear(BigDecimal newadaYear) {
		this.newadaYear = newadaYear;
	}

	public BigDecimal getNumBerthes() {
		return this.numBerthes;
	}

	public void setNumBerthes(BigDecimal numBerthes) {
		this.numBerthes = numBerthes;
	}

	public BigDecimal getOneDayRegistration() {
		return this.oneDayRegistration;
	}

	public void setOneDayRegistration(BigDecimal oneDayRegistration) {
		this.oneDayRegistration = oneDayRegistration;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public BigDecimal getOriginalPrice() {
		return this.originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getOtherEnergySource() {
		return this.otherEnergySource;
	}

	public void setOtherEnergySource(String otherEnergySource) {
		this.otherEnergySource = otherEnergySource;
	}

	public BigDecimal getOwnerCount() {
		return this.ownerCount;
	}

	public void setOwnerCount(BigDecimal ownerCount) {
		this.ownerCount = ownerCount;
	}

	public BigDecimal getPayload() {
		return this.payload;
	}

	public void setPayload(BigDecimal payload) {
		this.payload = payload;
	}

	public BigDecimal getPower() {
		return this.power;
	}

	public void setPower(BigDecimal power) {
		this.power = power;
	}

	public BigDecimal getPreparationCosts() {
		return this.preparationCosts;
	}

	public void setPreparationCosts(BigDecimal preparationCosts) {
		this.preparationCosts = preparationCosts;
	}

	public BigDecimal getPriceBuy() {
		return this.priceBuy;
	}

	public void setPriceBuy(BigDecimal priceBuy) {
		this.priceBuy = priceBuy;
	}

	public BigDecimal getPriceComp() {
		return this.priceComp;
	}

	public void setPriceComp(BigDecimal priceComp) {
		this.priceComp = priceComp;
	}

	public BigDecimal getPriceList() {
		return this.priceList;
	}

	public void setPriceList(BigDecimal priceList) {
		this.priceList = priceList;
	}

	public BigDecimal getPriceSell() {
		return this.priceSell;
	}

	public void setPriceSell(BigDecimal priceSell) {
		this.priceSell = priceSell;
	}

	public BigDecimal getPrivateUsage() {
		return this.privateUsage;
	}

	public void setPrivateUsage(BigDecimal privateUsage) {
		this.privateUsage = privateUsage;
	}

	public String getProductLine() {
		return this.productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getPublicHints() {
		return this.publicHints;
	}

	public void setPublicHints(String publicHints) {
		this.publicHints = publicHints;
	}

	public Date getPurdate() {
		return this.purdate;
	}

	public void setPurdate(Date purdate) {
		this.purdate = purdate;
	}

	public String getRadiono() {
		return this.radiono;
	}

	public void setRadiono(String radiono) {
		this.radiono = radiono;
	}

	public BigDecimal getRcrdType() {
		return this.rcrdType;
	}

	public void setRcrdType(BigDecimal rcrdType) {
		this.rcrdType = rcrdType;
	}

	public Date getRegCustDate() {
		return this.regCustDate;
	}

	public void setRegCustDate(Date regCustDate) {
		this.regCustDate = regCustDate;
	}

	public Date getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getRegistr() {
		return this.registr;
	}

	public void setRegistr(String registr) {
		this.registr = registr;
	}

	public String getRegistrDoc() {
		return this.registrDoc;
	}

	public void setRegistrDoc(String registrDoc) {
		this.registrDoc = registrDoc;
	}

	public BigDecimal getRepairCosts() {
		return this.repairCosts;
	}

	public void setRepairCosts(BigDecimal repairCosts) {
		this.repairCosts = repairCosts;
	}

	public String getResComment() {
		return this.resComment;
	}

	public void setResComment(String resComment) {
		this.resComment = resComment;
	}

	public BigDecimal getResellerPrice() {
		return this.resellerPrice;
	}

	public void setResellerPrice(BigDecimal resellerPrice) {
		this.resellerPrice = resellerPrice;
	}

	public BigDecimal getReserveState() {
		return this.reserveState;
	}

	public void setReserveState(BigDecimal reserveState) {
		this.reserveState = reserveState;
	}

	public String getReservedBy() {
		return this.reservedBy;
	}

	public void setReservedBy(String reservedBy) {
		this.reservedBy = reservedBy;
	}

	public Date getReservedTill() {
		return this.reservedTill;
	}

	public void setReservedTill(Date reservedTill) {
		this.reservedTill = reservedTill;
	}

	public String getSearchAssNo() {
		return this.searchAssNo;
	}

	public void setSearchAssNo(String searchAssNo) {
		this.searchAssNo = searchAssNo;
	}

	public String getSellPriceChangedBy() {
		return this.sellPriceChangedBy;
	}

	public void setSellPriceChangedBy(String sellPriceChangedBy) {
		this.sellPriceChangedBy = sellPriceChangedBy;
	}

	public Date getSellPriceChangedDate() {
		return this.sellPriceChangedDate;
	}

	public void setSellPriceChangedDate(Date sellPriceChangedDate) {
		this.sellPriceChangedDate = sellPriceChangedDate;
	}

	public BigDecimal getShfc() {
		return this.shfc;
	}

	public void setShfc(BigDecimal shfc) {
		this.shfc = shfc;
	}

	public String getSpecConsumpIds() {
		return this.specConsumpIds;
	}

	public void setSpecConsumpIds(String specConsumpIds) {
		this.specConsumpIds = specConsumpIds;
	}

	public String getSpecialModelText() {
		return this.specialModelText;
	}

	public void setSpecialModelText(String specialModelText) {
		this.specialModelText = specialModelText;
	}

	public Date getSpeedoChangedDate() {
		return this.speedoChangedDate;
	}

	public void setSpeedoChangedDate(Date speedoChangedDate) {
		this.speedoChangedDate = speedoChangedDate;
	}

	public BigDecimal getSpeedoChangedKm() {
		return this.speedoChangedKm;
	}

	public void setSpeedoChangedKm(BigDecimal speedoChangedKm) {
		this.speedoChangedKm = speedoChangedKm;
	}

	public String getSpeedoChangedText() {
		return this.speedoChangedText;
	}

	public void setSpeedoChangedText(String speedoChangedText) {
		this.speedoChangedText = speedoChangedText;
	}

	public BigDecimal getSpeedoKm() {
		return this.speedoKm;
	}

	public void setSpeedoKm(BigDecimal speedoKm) {
		this.speedoKm = speedoKm;
	}

	public BigDecimal getStorageCosts() {
		return this.storageCosts;
	}

	public void setStorageCosts(BigDecimal storageCosts) {
		this.storageCosts = storageCosts;
	}

	public BigDecimal getSummerTyre() {
		return this.summerTyre;
	}

	public void setSummerTyre(BigDecimal summerTyre) {
		this.summerTyre = summerTyre;
	}

	public BigDecimal getSyscarAddInPercent() {
		return this.syscarAddInPercent;
	}

	public void setSyscarAddInPercent(BigDecimal syscarAddInPercent) {
		this.syscarAddInPercent = syscarAddInPercent;
	}

	public Date getTakeinDate() {
		return this.takeinDate;
	}

	public void setTakeinDate(Date takeinDate) {
		this.takeinDate = takeinDate;
	}

	public BigDecimal getTaxId() {
		return this.taxId;
	}

	public void setTaxId(BigDecimal taxId) {
		this.taxId = taxId;
	}

	public BigDecimal getTaxi() {
		return this.taxi;
	}

	public void setTaxi(BigDecimal taxi) {
		this.taxi = taxi;
	}

	public String getText1() {
		return this.text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String getText1Up() {
		return this.text1Up;
	}

	public void setText1Up(String text1Up) {
		this.text1Up = text1Up;
	}

	public String getText2() {
		return this.text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	public String getText2Up() {
		return this.text2Up;
	}

	public void setText2Up(String text2Up) {
		this.text2Up = text2Up;
	}

	public String getTmIccId() {
		return this.tmIccId;
	}

	public void setTmIccId(String tmIccId) {
		this.tmIccId = tmIccId;
	}

	public String getTmImei() {
		return this.tmImei;
	}

	public void setTmImei(String tmImei) {
		this.tmImei = tmImei;
	}

	public String getTmKeyId() {
		return this.tmKeyId;
	}

	public void setTmKeyId(String tmKeyId) {
		this.tmKeyId = tmKeyId;
	}

	public BigDecimal getTotalKm() {
		return this.totalKm;
	}

	public void setTotalKm(BigDecimal totalKm) {
		this.totalKm = totalKm;
	}

	public BigDecimal getTradePort() {
		return this.tradePort;
	}

	public void setTradePort(BigDecimal tradePort) {
		this.tradePort = tradePort;
	}

	public BigDecimal getTrailCoupl() {
		return this.trailCoupl;
	}

	public void setTrailCoupl(BigDecimal trailCoupl) {
		this.trailCoupl = trailCoupl;
	}

	public String getTsn() {
		return this.tsn;
	}

	public void setTsn(String tsn) {
		this.tsn = tsn;
	}

	public String getTsnT() {
		return this.tsnT;
	}

	public void setTsnT(String tsnT) {
		this.tsnT = tsnT;
	}

	public String getTyreManufacturer() {
		return this.tyreManufacturer;
	}

	public void setTyreManufacturer(String tyreManufacturer) {
		this.tyreManufacturer = tyreManufacturer;
	}

	public String getTyreSize() {
		return this.tyreSize;
	}

	public void setTyreSize(String tyreSize) {
		this.tyreSize = tyreSize;
	}

	public BigDecimal getTyreStateFl() {
		return this.tyreStateFl;
	}

	public void setTyreStateFl(BigDecimal tyreStateFl) {
		this.tyreStateFl = tyreStateFl;
	}

	public BigDecimal getTyreStateFr() {
		return this.tyreStateFr;
	}

	public void setTyreStateFr(BigDecimal tyreStateFr) {
		this.tyreStateFr = tyreStateFr;
	}

	public BigDecimal getTyreStateRes() {
		return this.tyreStateRes;
	}

	public void setTyreStateRes(BigDecimal tyreStateRes) {
		this.tyreStateRes = tyreStateRes;
	}

	public BigDecimal getTyreStateRl() {
		return this.tyreStateRl;
	}

	public void setTyreStateRl(BigDecimal tyreStateRl) {
		this.tyreStateRl = tyreStateRl;
	}

	public BigDecimal getTyreStateRr() {
		return this.tyreStateRr;
	}

	public void setTyreStateRr(BigDecimal tyreStateRr) {
		this.tyreStateRr = tyreStateRr;
	}

	public BigDecimal getUcGuaranteePremium() {
		return this.ucGuaranteePremium;
	}

	public void setUcGuaranteePremium(BigDecimal ucGuaranteePremium) {
		this.ucGuaranteePremium = ucGuaranteePremium;
	}

	public BigDecimal getUcGuaranteeProdId() {
		return this.ucGuaranteeProdId;
	}

	public void setUcGuaranteeProdId(BigDecimal ucGuaranteeProdId) {
		this.ucGuaranteeProdId = ucGuaranteeProdId;
	}

	public BigDecimal getUcGuaranteeProdOffid() {
		return this.ucGuaranteeProdOffid;
	}

	public void setUcGuaranteeProdOffid(BigDecimal ucGuaranteeProdOffid) {
		this.ucGuaranteeProdOffid = ucGuaranteeProdOffid;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public BigDecimal getUsedDrivingSchool() {
		return this.usedDrivingSchool;
	}

	public void setUsedDrivingSchool(BigDecimal usedDrivingSchool) {
		this.usedDrivingSchool = usedDrivingSchool;
	}

	public BigDecimal getUsedElse() {
		return this.usedElse;
	}

	public void setUsedElse(BigDecimal usedElse) {
		this.usedElse = usedElse;
	}

	public String getUsedElseText() {
		return this.usedElseText;
	}

	public void setUsedElseText(String usedElseText) {
		this.usedElseText = usedElseText;
	}

	public BigDecimal getUsedRentalCar() {
		return this.usedRentalCar;
	}

	public void setUsedRentalCar(BigDecimal usedRentalCar) {
		this.usedRentalCar = usedRentalCar;
	}

	public BigDecimal getUvType() {
		return this.uvType;
	}

	public void setUvType(BigDecimal uvType) {
		this.uvType = uvType;
	}

	public String getVaudisState() {
		return this.vaudisState;
	}

	public void setVaudisState(String vaudisState) {
		this.vaudisState = vaudisState;
	}

	public String getVehBody() {
		return this.vehBody;
	}

	public void setVehBody(String vehBody) {
		this.vehBody = vehBody;
	}

	public String getVehSysType() {
		return this.vehSysType;
	}

	public void setVehSysType(String vehSysType) {
		this.vehSysType = vehSysType;
	}

	public BigDecimal getVehType() {
		return this.vehType;
	}

	public void setVehType(BigDecimal vehType) {
		this.vehType = vehType;
	}

	public BigDecimal getVehicleIdExt() {
		return this.vehicleIdExt;
	}

	public void setVehicleIdExt(BigDecimal vehicleIdExt) {
		this.vehicleIdExt = vehicleIdExt;
	}

	public BigDecimal getVehicleModel() {
		return this.vehicleModel;
	}

	public void setVehicleModel(BigDecimal vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public BigDecimal getVehicleNoExt() {
		return this.vehicleNoExt;
	}

	public void setVehicleNoExt(BigDecimal vehicleNoExt) {
		this.vehicleNoExt = vehicleNoExt;
	}

	public BigDecimal getVisitCount() {
		return this.visitCount;
	}

	public void setVisitCount(BigDecimal visitCount) {
		this.visitCount = visitCount;
	}

	public BigDecimal getWasCommercialUse() {
		return this.wasCommercialUse;
	}

	public void setWasCommercialUse(BigDecimal wasCommercialUse) {
		this.wasCommercialUse = wasCommercialUse;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getWheelbase() {
		return this.wheelbase;
	}

	public void setWheelbase(String wheelbase) {
		this.wheelbase = wheelbase;
	}

	public BigDecimal getWinterType() {
		return this.winterType;
	}

	public void setWinterType(BigDecimal winterType) {
		this.winterType = winterType;
	}

	public BigDecimal getZdk() {
		return this.zdk;
	}

	public void setZdk(BigDecimal zdk) {
		this.zdk = zdk;
	}

	public List<VehiclesMm> getVehiclesMms() {
		return this.vehiclesMms;
	}

	public void setVehiclesMms(List<VehiclesMm> vehiclesMms) {
		this.vehiclesMms = vehiclesMms;
	}

	public VehiclesMm addVehiclesMm(VehiclesMm vehiclesMm) {
		getVehiclesMms().add(vehiclesMm);
		vehiclesMm.setVehicle(this);

		return vehiclesMm;
	}

	public VehiclesMm removeVehiclesMm(VehiclesMm vehiclesMm) {
		getVehiclesMms().remove(vehiclesMm);
		vehiclesMm.setVehicle(null);

		return vehiclesMm;
	}

	public List<Fextra> getFextras() {
		return this.fextras;
	}

	public void setFextras(List<Fextra> fextras) {
		this.fextras = fextras;
	}

	public Fextra addFextra(Fextra fextra) {
		getFextras().add(fextra);
		fextra.setVehicle(this);

		return fextra;
	}

	public Fextra removeFextra(Fextra fextra) {
		getFextras().remove(fextra);
		fextra.setVehicle(null);

		return fextra;
	}
	
}