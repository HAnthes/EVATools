package csvModel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Pattern;

import util.Setup;
import model.Fextra;
import model.Vehicle;
/**
 * CSV Klasse mit Mobile anpassung und zusatzbuchungen.
 * @author anthes
 * Stand : 06.08.2015 - http://services.mobile.de/manual/changelog.html
 * 12.11.2015 - Erweiterung Mobile API anpassung neue EVA Ausstattung.
 */
public class CSVMobile implements ICSVString {
	
	private String csvLine = "";
	private String a = "\"";
	private String e = "\";";
	private List<String> categorie = new ArrayList<String>();
	private GregorianCalendar now = new GregorianCalendar();
	private String co2eff = "";
	private String landeskennung = "";
	private String neuwagen = "0";
	private String beschreibung = "";

	public CSVMobile(Vehicle car) {

		// Erstellen der Ausstattungsliste

		for (Fextra x : car.getFextras()) {
		
			beschreibung += "* " + x.getDescr() + "\\\\";

			if (x.getCategory() != null) {
				String[] help = x.getCategory()
						.substring(2, x.getCategory().length())
						.split(Pattern.quote("|"));
				for (int a = 0; a < help.length; a++) {
					categorie.add(help[a]);
				}
			}
		}

		// Neuwagenparameter
		// {neu;A;DE}
		if (car.getHints() != null) {
			String help = car.getHints();
			if (help.contains("{")) {
				String[] x = help.substring(1, help.length() - 1).split(
						Pattern.quote(";"));
				if (x.length == 3) {
					co2eff = x[1];
					landeskennung = x[2];
					neuwagen = "1";
				}
			}
		}
		// CSV String aufbauen
		 a_z(car);
		 aa_az(car);
		 ba_bz(car);
		 ca_cz(car);
		 da_ez(car);
		 fa_fz(car);

	}

	private int kraftstoff(int evak) {

		switch (evak) {
		case -1:
			return 1;
		case -2:
			return 2;
		case -3:
		case -9999:
		case -20:
		case -21:
			return 0;
		case -4:
			return 6;
		case -5:
		case -6:
			return 3;
		case -7:
		case -9:
			return 4;
		case -8:
		case -12:
		case -22:
		case -19:
		case -16:
		case -15:
			return 7;
		case -11:
		case -13:
		case -14:
			return 8;
		case -18:
		case -17:
			return 9;
		case -10:
			return 10;
		default:
			return 0;
		}

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

	private boolean isin(String s) {
		for (String x : categorie) {
			if (x.equals(s))
				return true;
		}
		return false;
	}

	private String fzKat(BigDecimal fzt) {

		int type = fzt.intValue();
		if (type == 1 || type == 8 || type == 9 || type == 10)
			return "Car.OtherCar";
		if (type == 2)
			return "Car.Limousine";
		if (type == 3)
			return "Car.EstateCar";
		if (type == 4)
			return "Car.Cabrio";
		if (type == 5 || type == 26)
			return "Car.SportsCar";
		if (type == 6 || type == 19)
			return "Car.OffRoad";
		if (type == 27)
			return "Car.SmallCar";
		if (type == 7)
			return "Car.Van";
		return "Car.OtherCar";
	}

	private void addData(String d) {
		csvLine += a + d + e;
	}

	private int dayDiff(long milis) {
	 	
		GregorianCalendar today = new GregorianCalendar();
		GregorianCalendar past = new GregorianCalendar();
		
		past.setTimeInMillis(milis);

	    long difference = today.getTimeInMillis() - past.getTimeInMillis();
	    return (int)(difference / (1000 * 60 * 60 * 24));
	 }

	
	
	private void a_z(Vehicle car) {

		// 0 A Kundennummer
		addData("" + car.getVehicleNo());
		// 1 B interne Nummer
		addData("" + car.getVehicleNo());
		// 2 C Kategorie
		addData(fzKat(car.getVehType()));
		// 3 D Marke
		addData(car.getText1().equals("VW NFZ") ? "VW" : car.getText1());
		// 4 E Modell 48 zeichen
		String modell = car.getText2() + " " + car.getDesignDesc();
		modell = modell.substring(0, modell.length() > 47 ? 47 : modell.length());
		addData(modell);
		// 5 F Leistung
		addData(car.getPower().toPlainString());
		// 6 G HU
		addData(car.getMainCheck() == null || car.getMainCheck().equals("NEU") ? ""
				: car.getMainCheck());
		// 7 H AU
		addData(car.getEmissionCheck() == null
				|| car.getEmissionCheck().equals("NEU") ? "" : car
				.getEmissionCheck());
		// 8 I EZ
		if (car.getRegdate() != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("MM.yyyy");
			addData(formatter.format(car.getRegdate()));
		} else {
			addData("");
		}
		// 9 J Kilometer
		addData(car.getSpeedoKm().toString());
		// 10 K Preis
		addData(car.getPriceSell().setScale(2, RoundingMode.HALF_UP).toString());
		// 11 L Mwst
		addData(car.getBusinessType().toString());
		// 12 M Leer
		addData("");
		// 13 N Oldtimer
		addData("0");
		// 14 O VIN
		addData(car.getChassisno());
		// 15 P beschädigtes Fahrzeug
		addData("0");
		// 16 Q Farbe
		String farbe = car.getColorExtText() + "/"
				+ genColor(car.getColorExtGeneric());
		addData(farbe.length() > 32 ? car.getColorExtText() : farbe);
		// 17 R Klimaanlage AC, Cp, Ak, Klimatomatik 2 sonst 1
		int help;
		if(isin("AC")) help=2;
		else if(isin("Cp") || isin("Ak")) help=1;
		else help =0;
		addData(""+help);
		// 18 S Taxi
		addData("0");
		// 19 T Behindertengerecht
		addData(isin("BH")?"1":"0");
		// 20 U Jahreswagen unter 45o ab EZ!
		addData(((now.getTimeInMillis() - car.getRegdate().getTime()) / 86400000) > 450 ? "0"
				: "1");
		// 21 V Neuwagen aus Hints im Konstruktor
		addData(neuwagen);
		// 22 W Unsere Empfehlung
		addData("0");
		// 23 Händlerpreis
		if (car.getResellerPrice().compareTo(car.getPriceSell()) == -1
				&& car.getResellerPrice().compareTo(new BigDecimal(0)) == 1) {
			addData(car.getResellerPrice().multiply(new BigDecimal(1.19))
					.setScale(2, RoundingMode.HALF_UP).toString());
		} else {
			addData("");
		}
		// 24 Y reserviert
		addData("");
		// 25 Z Bemerkung Längenbeschränkung beachten 12.11.15 3000 Zeichen
		if(beschreibung.length() + Setup.getMobileCSVText().length() <=3000){
		addData(beschreibung + Setup.getMobileCSVText());
		} else{
			addData(beschreibung);
		}

	}

	private void aa_az(Vehicle car) {

		// 26 AA Bild ID
		addData("" + car.getVehicleNo());
		// 27 AB Metallic EVA AP und Ap
		addData(isin("AP") || isin("Ap") ? "1" : "0");
		// 28 AC Währung nur EUR
		addData("EUR");
		// 29 MWSTSatz
		addData(car.getBusinessType().equals(new BigDecimal(0)) ? "19" : "0");
		// 30 AE Garantie
		addData("0");
		// 31 AF Leichtmetallfelgen Al und Al
		addData(isin("Al") || isin("Yl") ? "1" : "0");
		// 32 AG ESP Ao
		addData(isin("Ao") ? "1" : "0");
		// 33 AH ABS AA
		addData(isin("AA") ? "1" : "0");
		// 34 AI Anhängerkupplung
		addData(car.getTrailCoupl().toString());
		// 35 AJ reserviert
		addData("");
		// 36 AK Wegfahersperre AW
		addData(isin("AW") ? "1" : "0");
		// 37 AL Navigationssystem ah, AB, Cd
		addData(isin("ah") || isin("AB") || isin("Cd") ? "1" : "0");
		// 38 AM Schiebedach Am,AM,Af,C6
		addData(isin("Am") || isin("AM") || isin("Af") || isin("C6") ? "1"
				: "0");
		// 39 AN Znetralveriegelung AZ,AI
		addData(isin("AZ") || isin("AI") ? "1" : "0");
		// 40 AO Fesnterheber AE
		addData(isin("AE") ? "1" : "0");
		// 41 AP Allrad
		addData(car.getAllwheel().equals(new BigDecimal(0)) ? "1" : "0");
		// 42 AQ Tueren
		addData(car.getDoors().toString());
		// 43 Umweltplakette
		switch (car.getEmisBadge().intValue()) {
		case 1:
			addData("1");
			break;
		case 2:
			addData("4");
			break;
		case 3:
			addData("3");
			break;
		case 4:
			addData("2");
			break;
		default:
			addData("1");
			break;
		}
		// 44 Servolenkung Ax
		addData(isin("Ax") ? "1" : "0");
		// 45 Biodiesel
		addData("0");
		// 46 AU Scheckheftgepflegt
		addData(car.getCareStatus().toString());
		// 47 - 49 nur Motorräder
		addData("");
		addData("");
		addData("");
		// 50 AY Vorführwagen
		addData("0");
		// 51 nur Motorräder
		addData("");

	}

	private void ba_bz(Vehicle car) {
		// 52 BA ccm
		addData(car.getCapacity().toString());
		// 53 BB - 60 BI Nutzfahrzeuge
		addData(""); // 53
		addData(""); // 54
		addData(""); // 55
		addData(""); // 56
		addData(""); // 57
		addData(""); // 58
		addData(""); // 59
		addData(car.getCarSeats().toString()); // 60 Sitze!
		// BJ Schadstoffklasse
		switch (car.getEmisStandard().intValue()) {
		case 1:
			addData("1");
			break;
		case 2:
			addData("2");
			break;
		case 3:
			addData("3");
			break;
		case 4:
			addData("3");
			break;
		case 5:
			addData("4");
			break;
		case 6:
			addData("4");
			break;
		case 7:
			addData("5");
			break;
		case 8:
			addData("6");
			break;
		default:
			addData("");
			break;
		}
		// 62 BK Kabineneart Nutz
		addData("");
		// 63 BL Achsen Nutz
		addData("");
		// 64 BM Tempomat AT
		addData(isin("AT") ? "1" : "0");
		// 65 BN Standheizung AS
		addData(isin("AS") ? "1" : "0");
		// 66 BO - 72 BU Nutz
		addData(""); // 66
		addData(""); // 67
		addData(""); // 68
		addData(""); // 69
		addData(""); // 70
		addData(""); // 71
		addData(""); // 72
		// 73 BV Tv AK
		addData(isin("ak") || isin("Cc")? "1" : "0");
		// 74 BW - 77 BZ Nutz
		addData(""); // 74
		addData(""); // 75
		addData(""); // 76
		addData(""); // 77
	}

	private void ca_cz(Vehicle car) {
		// 78 CA - 92 CO Nutz.
		addData(""); // 78
		addData(""); // 79
		addData(""); // 80
		addData(""); // 81
		addData(""); // 82
		addData(isin("Bw") ? "1":"0"); // 83
		addData(""); // 84
		addData(""); // 85
		addData(""); // 86
		addData(""); // 87
		addData(""); // 88
		addData(""); // 89
		addData(isin("Nq") ? "1":"0"); // 90
		addData(""); // 91
		addData(""); // 92
		// 93 Händlerpreis
		if (car.getResellerPrice().compareTo(car.getPriceSell()) == -1
				&& car.getResellerPrice().compareTo(new BigDecimal(0)) == 1) {
			addData("1");
		} else {
			addData("0");
		}
		// 94 CQ reservirt
		addData("");
		// 95 envkv
		addData("0");
		// 96 CS Verbrauch innerorts
		addData(car.getConsumpCity().toString());
		// 97 CT Verbrauch auserorts
		addData(car.getConsumpRoad().toString());
		// 98 CU Verbrauch mix
		addData(car.getConsumpMix().toString());
		// 99 CV Verbrauch innerots
		addData(car.getEmissCo2Mix().toString());
		// 100 CW Xenon AO
		addData(isin("AO") ? "1" : "0");
		// 101 CX Sitzheizung Au
		addData(isin("Au") || isin("ar") || isin("aq") ? "1" : "0");
		// 102 CY Partikelfilter Bz
		addData(isin("Bz") ? "1" : "0");
		// 103 CZ Einparkhilfe ist erseztzt
		addData("");
	}

	private void da_ez(Vehicle car) {
		// 104 DA Schwacke Code
		addData("");
		// 105 DB Lieferdatum
		if (neuwagen.equals("1")) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
			addData(formatter.format(now.getTime()));
		} else {
			addData("");
		}
		// 106 DC Lieferfreist
		addData("");
		// 107 DD Überführungskosten
		addData("");
		// 108 DE HU / AU Neumachen
		if (car.getMainCheck() != null)
			addData(car.getMainCheck().equals("NEU") ? "1" : "0");
		else
			addData("0");
		// 109 DF Kraftstoff
		addData("" + kraftstoff(car.getMotorId().intValue()));
		// 110 DG GetriebeArt
		if (car.getAuto().toString().equals("0"))
			addData("1");
		if (car.getAuto().toString().equals("1"))
			addData("3");
		if (car.getAuto().toString().equals("2"))
			addData("2");
		// 111 DH Export
		addData("");
		// 112 DI Tagrszulassung
		addData("");
		// 113 DJ Blickfänger   - Brechnung von automatischen Schaltzyklen
		//Zwischen Start und Ende und mit  Bild!
		
		if((dayDiff(car.getDateCreated().getTime())>=Setup.getMobileBlickfStart()) && (dayDiff(car.getDateCreated().getTime()) <=Setup.getMobileBlickfEnde()) && (car.getVehiclesMms().size()>0) ){
				addData("1");
		} else {
			addData("0");
		}
			
		// 114 DK HSN
		addData(car.getHsn());
		// 115 DL TSN
		addData(car.getTsn());
		// 116 DM Seite 1  - Brechnung von automatischen Schaltzyklen
		if(dayDiff(car.getDateCreated().getTime())>=Setup.getMobileErsteSeiteStart() && dayDiff(car.getDateCreated().getTime()) <=Setup.getMobileErsteSeiteEnde() && car.getVehiclesMms().size()>0 ){
				addData("1");
			} else {
				addData("0");
			}
  
		// 117 DN reserviert
		addData("");
		// 118 DO reserviert
		addData("");
		// 119 DP E10
		addData("");
		// 120 DQ Qualitätssiegel
		addData("");
		// 121 DR Pflanzenöl
		addData("");
		// 122 SCR - 128 Straßenzulassung
		addData(""); // 122
		addData(""); // 123
		addData(""); // 124
		addData(""); // 125
		addData(""); // 126
		addData(""); // 127
		addData(""); // 128
		addData(isin("Cg") ? "1" : "0"); // 129
		addData(isin("Ch") ? "1" : "0"); // 130
		addData(isin("Cl") ? "1" : "0"); // 131
		addData(isin("Cm") ? "1" : "0"); // 132
		addData(isin("Cq") ? "1" : "0"); // 133
		addData(isin("Cn") ? "1" : "0"); // 134
		addData(isin("Cj") ? "1" : "0"); // 135
		addData(isin("Ci") ? "1" : "0"); // 136
		addData(isin("Ck") ? "1" : "0"); // 137
		addData("0"); // 138 Hagelschaden
		addData(""); // 139 Schlafplätze
		addData(""); // 140 Fahrzeugköänge
		addData(""); // 141 Fahrzeugbreite
		addData(""); // 142 Höhe
		addData(""); // 143 Laderaum Palette
		addData(""); // 144 Laderaum Volumen
		addData(""); // 145 Ladraum länge
		addData(""); // 146 Ladraum breite
		addData(""); // 147 Ladraum Höhe
		addData("0"); // 148 Anzeige erneuern
		addData(""); // 149 eff Jahreszins
		addData(""); // 150 moantliche Rate
		addData(""); // 151 laufzeit
		addData(""); // 152 Anzahlung
		addData(""); // 153 Schlussrate
		addData("0"); // 154 Fin Features
		// 155 EZ Interieurfarbe
		addData("5");
	}

	private void fa_fz(Vehicle car) {
		
		//	156	FA Interuiertype
		String iType = "6";
		if(isin("BV")) iType="5";
		if(isin("YL") || isin("AL")) iType ="1";
		if(isin("BU") || isin("Y3")) iType ="2";
		if(isin("BS")) iType="3";
		if(isin("BT")) iType ="4";
		addData(iType);
		
		//	157 FB Airbag
		iType = "";
		if(isin("af")) iType="5";
		if(isin("AY")) iType="4";
		if(isin("Ad")) iType="3";
		if(isin("Af")) iType="2";
		if(isin("Bv")) iType="3";
		addData(iType);
		//	158	FC	Vorbesitzer
		addData(car.getOwnerCount().toString());
		//	159	FFD	Topinserrat
		addData("0");
		//	160	Bruttokreditbetrag
		addData("");
		//	161	Abschlussgebühren
		addData("");
		//	162	Ratenabsicherung
		addData("");
		//	163	Nettokreditbetrag
		addData("");
		//	164	Anbieterbank
		addData("");
		//	165	Soll-Zinssatz
		addData("");
		//	166	Art des SollZinssatzes
		addData("");
		//	167 Landesversion
		addData(landeskennung);
		//	168		Videour
		addData("");
		//	169	Energiereffz
		addData(co2eff);
		//	170	envkv_benzin
		addData(kraftstoff(car.getMotorId().intValue()) == 1 ? "SUPER" : "");
		//	171	Seitenspiegel
		addData(isin("AR") || isin("ab") ? "1" : "0");
		//	172	Sporfahrwerk
		addData(isin("At") ? "1" : "0");
		//	173	Sporpaket
		addData("0");
		//	174	Bluetooth
		addData(isin("bf") ? "1" : "0");
		//	175	Bordcomputer
		addData(isin("Ab") ? "1" : "0");
		//	176	CD Spieler
		addData(isin("aw") ||isin("BM")||isin("Aq") ? "1" : "0");
		//	177	el Sitzeinstellung
		addData(isin("A9") ||isin("ag") ? "1" : "0");
		//	178	Head Up
		addData(isin("BQ") ? "1" : "0");
		//	179	Freisprech
		addData("0");
		//	180 MP3 
		addData("0");
		//	181 Multi Lenkraf
		addData(isin("A7") ? "1" : "0");
		//	182	Skisack
		addData(isin("A2") ? "1" : "0");
		//	183 Tuner oder Radio
		addData(isin("Ar") || isin("aw") || isin("Cd") ? "1" : "0");
		//	184 Sportsitze
		addData(isin("AU") ? "1" : "0");
		//	185	Panorama Dach
		addData(isin("C6") ? "1" : "0");
		//	186	Kindersizt 
		addData(isin("BR") ? "1" : "0");
		//	187	Kurvenlicht
		addData(isin("BE") ? "1" : "0");
		//	188 Lichtsensor
		addData(isin("Bk") ? "1" : "0");
		//	189	Nebelscheinwewefer
		addData(isin("AN") ? "1" : "0");
		//	190	Tagfahrlicht
		addData(isin("Bx") ? "1" : "0");
		//	191	Tranktionskontrolle
		addData(isin("Ae") || isin("Ao") ? "1" : "0");
		//	192	Start Stop
		addData(isin("BG") ? "1" : "0");
		//	193	Regensensor
		addData(isin("Bb") || isin("Bk") ? "1" : "0");
		//	194	nichtraucher
		addData("0");
		//	195	Dachreling
		addData(isin("AQ") ? "1" : "0");
		//	196	Unfall
		addData("0");
		//	197	Fahrtauglich
		addData("1");
		//	198	Produktionsdatum
		addData("");
		//	199 Einparkhilfe vorne
		addData(isin("A3") ? "1" : "0");
		//	200 Einparkhilfe hinten
		addData(isin("A3") ? "1" : "0");
		//	201 Einparkhilfe Kamera
		addData(isin("BK") || isin("BI") ? "1" : "0");
		//	202 Einparkhilfe selbslenk
		addData(isin("BF") ? "1" : "0");
		//	203	Topinserat
		addData("0");
		//	204 Rotstifft
		addData("0");
		//	205	ebay
		addData("0");
		//	206	Pluginhybrid
		addData("");
		//	207	Kombinierterstromverbrauch
		addData("");		
	}

	public String getCSV() {
		return csvLine;
	}

}
