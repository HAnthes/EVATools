package accessModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import model.Fextra;
import model.Vehicle;
import model.VehiclesMm;

public class DTOCar {

	private boolean error = false;

	private long ser_id;
	private String auf_nr;
	private String aufbau;
	private String hersteller;
	private String modell;
	private BigDecimal leistung;
	private String tuv;
	private String au;
	private Date ez;
	private BigDecimal tacho;
	private BigDecimal preis;
	private BigDecimal gesch_art;
	private BigDecimal treibstoff;
	private BigDecimal automatic;
	private String lack;
	private BigDecimal klima;
	private String be="";
	private BigDecimal met;
	private BigDecimal mws;
	private BigDecimal esp;
	private BigDecimal asp;
	private BigDecimal ahk;
	private BigDecimal leder;
	private BigDecimal weg;
	private BigDecimal nav;
	private BigDecimal schieb;
	private BigDecimal zentr;
	private BigDecimal elfenster;
	private BigDecimal tueren;
	private BigDecimal hubraum;
	private String modellbezeichnung;
	private BigDecimal emiss_co2_mix;
	private BigDecimal consump_mix;
	private BigDecimal consump_road;
	private BigDecimal consump_city;
	private BigDecimal allwheel;
	private BigDecimal motor_id;
	private Date date_created;
	private String hsn;
	private String tsn;
	private BigDecimal garantie;
	private BigDecimal care_status;
	private BigDecimal was_commerical_use;
	private BigDecimal euromobil;
	private BigDecimal emis_badge;
	private BigDecimal emis_standard;
	private String chassisno;
	private BigDecimal reseller;
	private BigDecimal owner_count;
	private BigDecimal car_seats;
	private String color_generic;
	private String hints;
	private String category="";
	private BigDecimal veh_type;
	private BigDecimal neuwagen;
	private String landeskennung;
	private String co2eff;
	private List<DTOFextra> extraListe = new ArrayList<DTOFextra>();
	private List<DTOextraCat> extras = new ArrayList<DTOextraCat>();
	private List<Pictures> bilder = new ArrayList<Pictures>();
	
	
	
	private String fzKat(BigDecimal fzt) {
		// TODO Prüfung auf Polo, Up!, Fox und Lupo!
		int type = fzt.intValue();
		if (type == 1 || type == 8 || type == 9 || type == 10)
			return "andere";
		if (type == 2)
			return "Limousine";
		if (type == 3)
			return "Kombi";
		if (type == 4)
			return "Cabrio";
		if (type == 5 || type == 26)
			return "Sportwagen/Coupe";
		if (type == 6 || type == 19)
			return "Gelaendewagen/Pickup";
		if (type == 27)
			return "Kleinwagen";
		if (type == 7)
			return "Van";
		return "andere";
	}

	private String genColor(String color) {
		if (color.equals("BEI"))
			return "Beige";
		if (color.equals("GEL"))
			return "Gelb";
		if (color.equals("BLA"))
			return "Blau";
		if (color.equals("BRA"))
			return "Braun";
		if (color.equals("BRO"))
			return "Bronze";
		if (color.equals("GOL"))
			return "Gold";
		if (color.equals("GRA"))
			return "Grau";
		if (color.equals("GRU"))
			return "Grün";
		if (color.equals("ORA"))
			return "Orange";
		if (color.equals("ROT"))
			return "Rot";
		if (color.equals("SCH"))
			return "Schwarz";
		if (color.equals("SIL"))
			return "Silber";
		if (color.equals("VIO"))
			return "Violett";
		if (color.equals("WEI"))
			return "Weiß";
		return "";

	}

	public DTOCar(Vehicle car) {
		// 129
		ser_id = car.getVehicleNo();
		auf_nr = car.getOrderNo();
		aufbau = fzKat(car.getVehType());
		veh_type = car.getVehType();
		hersteller = car.getText1().equals("VW NFZ") ? "VW" : car.getText1();
		// 193
		modell = car.getText2() + " " + car.getDesignDesc();
		modell = modell.substring(0,
				modell.length() > 47 ? 47 : modell.length());

		modellbezeichnung = car.getText2();

		leistung = car.getPower();
		tuv = car.getMainCheck();
		au = car.getEmissionCheck();
		
		
		// 219
		tacho = car.getSpeedoKm();
		ez = car.getRegdate();
		preis = car.getPriceSell();
		gesch_art = car.getBusinessType();

		// 245
		treibstoff = new BigDecimal(-1);; // Out of date

		automatic = car.getAuto().multiply( new BigDecimal(-1));   // Automatik = 1 , Schaltgetriebe  = 0 Hablautomatik = 2

		lack = car.getColorExtText();
		met = new BigDecimal(-1);

		color_generic = genColor(car.getColorExtGeneric());

		// 287
		mws = car.getBusinessType().equals(new BigDecimal(1))?new BigDecimal(19) :new BigDecimal(0);
		ahk = car.getTrailCoupl().multiply( new BigDecimal(-1));
		leder = new BigDecimal(0);
		weg = car.getDemobil().multiply( new BigDecimal(-1));
		tueren = car.getDoors();
		hubraum = car.getCapacity();

		// 321 Validieren!!!!!
		consump_city = car.getConsumpCity();
		consump_road = car.getConsumpRoad();
		consump_mix = car.getConsumpMix();
		emiss_co2_mix = car.getEmissCo2Mix();
		if (consump_city.equals(new BigDecimal(0))  || consump_road.equals(new BigDecimal(0)) || consump_mix.equals(new BigDecimal(0))
				|| emiss_co2_mix.equals(new BigDecimal(0)))
			error = true;

		allwheel = car.getAllwheel();
		motor_id = car.getMotorId();
		date_created = car.getDateCreated();

		hsn = car.getHsn();
		tsn = car.getTsn();

		// 362
		garantie = car.getUcGuaranteeProdOffid();
		care_status = car.getCareStatus();
		was_commerical_use = car.getWasCommercialUse();
		euromobil = car.getEuromobil();

		// Umweltplakette
		if (car.getEmisBadge().intValue() == 0
				|| car.getEmisStandard().intValue() == 0)
			error = true;
		emis_badge = car.getEmisBadge();
		emis_standard = car.getEmisStandard();

		chassisno = car.getChassisno();
	
		reseller = car.getResellerPrice();
		if (car.getResellerPrice().compareTo(car.getPriceSell()) > 0)
			error = true;

		car_seats = car.getCarSeats();

		int first = 0;

		for (Fextra f : car.getFextras()) {
			if (first == 0) {
				be += f.getDescr();
				first = 1;
			} else {
			be += "<MetaKomma>" + f.getDescr();
			}
			DTOFextra extra = new DTOFextra();
			extra.setBezeichnung(f.getDescr());
			extra.setExtraid(car.getVehicleNo());
			extra.setKey(f.getKey());
			extra.setExtraid(f.getVehExtraNo());
			extraListe.add(extra);

			if (f.getCategory() != null) {
				String[] help = f.getCategory()
						.substring(2, f.getCategory().length())
						.split(Pattern.quote("|"));
				for (int a = 0; a < help.length; a++) {
					category += help[a] + ";";
					DTOextraCat ecat = new DTOextraCat(f.getVehExtraNo(), help[a]);
					extras.add(ecat);
				}
			}
		}

		// 483 bis 530 ausgelassen : werden nicht mehr so gebraucht aber noch im
		// import gelesen.

		owner_count = car.getOwnerCount();

		// Neufahrzeuge!
		// {neu;A;DE}
		if (car.getHints() != null) {
			String help = car.getHints();
			if (help.contains("{")) {
				String[] x = help.substring(1, help.length() - 1).split(
						Pattern.quote(";"));
				if (x.length == 3) {
					co2eff = x[1];
					landeskennung = x[2];
					neuwagen = new BigDecimal(1);
				}
			}
		}
		//das sollte so fast passen!
		
		for(VehiclesMm mm : car.getVehiclesMms()){
			Pictures b = new Pictures(mm.getFilename());
			bilder.add(b);
		}
	}

	public boolean getError(){
		return error;
	}

	public long getSer_id() {
		return ser_id;
	}

	public void setSer_id(long ser_id) {
		this.ser_id = ser_id;
	}

	public String getAuf_nr() {
		return auf_nr;
	}

	public void setAuf_nr(String auf_nr) {
		this.auf_nr = auf_nr;
	}

	public String getAufbau() {
		return aufbau;
	}

	public void setAufbau(String aufbau) {
		this.aufbau = aufbau;
	}

	public String getHersteller() {
		return hersteller;
	}

	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public BigDecimal getLeistung() {
		return leistung;
	}

	public void setLeistung(BigDecimal leistung) {
		this.leistung = leistung;
	}

	public String getTuv() {
		return tuv;
	}

	public void setTuv(String tuv) {
		this.tuv = tuv;
	}

	public String getAu() {
		return au;
	}

	public void setAu(String au) {
		this.au = au;
	}

	public Date getEz() {
		return ez;
	}

	public void setEz(Date ez) {
		this.ez = ez;
	}

	public BigDecimal getTacho() {
		return tacho;
	}

	public void setTacho(BigDecimal tacho) {
		this.tacho = tacho;
	}

	public BigDecimal getPreis() {
		return preis;
	}

	public void setPreis(BigDecimal preis) {
		this.preis = preis;
	}

	public BigDecimal getGesch_art() {
		return gesch_art;
	}

	public void setGesch_art(BigDecimal gesch_art) {
		this.gesch_art = gesch_art;
	}

	public BigDecimal getTreibstoff() {
		return treibstoff;
	}

	public void setTreibstoff(BigDecimal treibstoff) {
		this.treibstoff = treibstoff;
	}

	public BigDecimal getAutomatic() {
		return automatic;
	}

	public void setAutomatic(BigDecimal automatic) {
		this.automatic = automatic;
	}

	public String getLack() {
		return lack;
	}

	public void setLack(String lack) {
		this.lack = lack;
	}

	public BigDecimal getKlima() {
		return klima;
	}

	public void setKlima(BigDecimal klima) {
		this.klima = klima;
	}

	public String getBe() {
		return be;
	}

	public void setBe(String be) {
		this.be = be;
	}

	public BigDecimal getMet() {
		return met;
	}

	public void setMet(BigDecimal met) {
		this.met = met;
	}

	public BigDecimal getMws() {
		return mws;
	}

	public void setMws(BigDecimal mws) {
		this.mws = mws;
	}

	public BigDecimal getEsp() {
		return esp;
	}

	public void setEsp(BigDecimal esp) {
		this.esp = esp;
	}

	public BigDecimal getAsp() {
		return asp;
	}

	public void setAsp(BigDecimal asp) {
		this.asp = asp;
	}

	public BigDecimal getAhk() {
		return ahk;
	}

	public void setAhk(BigDecimal ahk) {
		this.ahk = ahk;
	}

	public BigDecimal getLeder() {
		return leder;
	}

	public void setLeder(BigDecimal leder) {
		this.leder = leder;
	}

	public BigDecimal getWeg() {
		return weg;
	}

	public void setWeg(BigDecimal weg) {
		this.weg = weg;
	}

	public BigDecimal getNav() {
		return nav;
	}

	public void setNav(BigDecimal nav) {
		this.nav = nav;
	}

	public BigDecimal getSchieb() {
		return schieb;
	}

	public void setSchieb(BigDecimal schieb) {
		this.schieb = schieb;
	}

	public BigDecimal getZentr() {
		return zentr;
	}

	public void setZentr(BigDecimal zentr) {
		this.zentr = zentr;
	}

	public BigDecimal getElfenster() {
		return elfenster;
	}

	public void setElfenster(BigDecimal elfenster) {
		this.elfenster = elfenster;
	}

	public BigDecimal getTueren() {
		return tueren;
	}

	public void setTueren(BigDecimal tueren) {
		this.tueren = tueren;
	}

	public BigDecimal getHubraum() {
		return hubraum;
	}

	public void setHubraum(BigDecimal hubraum) {
		this.hubraum = hubraum;
	}

	public String getModellbezeichnung() {
		return modellbezeichnung;
	}

	public void setModellbezeichnung(String modellbezeichnung) {
		this.modellbezeichnung = modellbezeichnung;
	}

	public BigDecimal getEmiss_co2_mix() {
		return emiss_co2_mix;
	}

	public void setEmiss_co2_mix(BigDecimal emiss_co2_mix) {
		this.emiss_co2_mix = emiss_co2_mix;
	}

	public BigDecimal getConsump_mix() {
		return consump_mix;
	}

	public void setConsump_mix(BigDecimal consump_mix) {
		this.consump_mix = consump_mix;
	}

	public BigDecimal getConsump_road() {
		return consump_road;
	}

	public void setConsump_road(BigDecimal consump_road) {
		this.consump_road = consump_road;
	}

	public BigDecimal getConsump_city() {
		return consump_city;
	}

	public void setConsump_city(BigDecimal consump_city) {
		this.consump_city = consump_city;
	}

	public BigDecimal getAllwheel() {
		return allwheel;
	}

	public void setAllwheel(BigDecimal allwheel) {
		this.allwheel = allwheel;
	}

	public BigDecimal getMotor_id() {
		return motor_id;
	}

	public void setMotor_id(BigDecimal motor_id) {
		this.motor_id = motor_id;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public String getHsn() {
		return hsn;
	}

	public void setHsn(String hsn) {
		this.hsn = hsn;
	}

	public String getTsn() {
		return tsn;
	}

	public void setTsn(String tsn) {
		this.tsn = tsn;
	}

	public BigDecimal getGarantie() {
		return garantie;
	}

	public void setGarantie(BigDecimal garantie) {
		this.garantie = garantie;
	}

	public BigDecimal getCare_status() {
		return care_status;
	}

	public void setCare_status(BigDecimal care_status) {
		this.care_status = care_status;
	}

	public BigDecimal getWas_commerical_use() {
		return was_commerical_use;
	}

	public void setWas_commerical_use(BigDecimal was_commerical_use) {
		this.was_commerical_use = was_commerical_use;
	}

	public BigDecimal getEuromobil() {
		return euromobil;
	}

	public void setEuromobil(BigDecimal euromobil) {
		this.euromobil = euromobil;
	}

	public BigDecimal getEmis_badge() {
		return emis_badge;
	}

	public void setEmis_badge(BigDecimal emis_badge) {
		this.emis_badge = emis_badge;
	}

	public BigDecimal getEmis_standard() {
		return emis_standard;
	}

	public void setEmis_standard(BigDecimal emis_standard) {
		this.emis_standard = emis_standard;
	}

	public String getChassisno() {
		return chassisno;
	}

	public void setChassisno(String chassisno) {
		this.chassisno = chassisno;
	}

	public BigDecimal getReseller() {
		return reseller;
	}

	public void setReseller(BigDecimal reseller) {
		this.reseller = reseller;
	}

	public BigDecimal getOwner_count() {
		return owner_count;
	}

	public void setOwner_count(BigDecimal owner_count) {
		this.owner_count = owner_count;
	}

	public BigDecimal getCar_seats() {
		return car_seats;
	}

	public void setCar_seats(BigDecimal car_seats) {
		this.car_seats = car_seats;
	}

	public String getColor_generic() {
		return color_generic;
	}

	public void setColor_generic(String color_generic) {
		this.color_generic = color_generic;
	}

	public String getHints() {
		return hints;
	}

	public void setHints(String hints) {
		this.hints = hints;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getVeh_type() {
		return veh_type;
	}

	public void setVeh_type(BigDecimal veh_type) {
		this.veh_type = veh_type;
	}

	public BigDecimal getNeuwagen() {
		return neuwagen;
	}

	public void setNeuwagen(BigDecimal neuwagen) {
		this.neuwagen = neuwagen;
	}

	public String getLandeskennung() {
		return landeskennung;
	}

	public void setLandeskennung(String landeskennung) {
		this.landeskennung = landeskennung;
	}

	public String getCo2eff() {
		return co2eff;
	}

	public void setCo2eff(String co2eff) {
		this.co2eff = co2eff;
	}

	public List<DTOFextra> getExtraListe() {
		return extraListe;
	}

	public void setExtraListe(List<DTOFextra> extraListe) {
		this.extraListe = extraListe;
	}

	public List<DTOextraCat> getExtras() {
		return extras;
	}

	public void setExtras(List<DTOextraCat> extras) {
		this.extras = extras;
	}

	public List<Pictures> getBilder() {
		return bilder;
	}

	public void setBilder(List<Pictures> bilder) {
		this.bilder = bilder;
	}


}
