package accessModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Controllerkalsse für Access DB zugriff
 * @author anthes
 * 
 * Einfügen von Cars
 *
 */

public class DBCar {

/**
 * Access Modell für den JDBC zugriff über UACCESS - Webiimport-	
 * Umstellung auf CSV angedacht. Import duch Classic ASP fehlt
 */
	
	private static java.util.logging.Logger jlogger  = java.util.logging.Logger.getLogger(Class.class.getName());
	
	private static String qdelete = "delete * from holderbaum_web_v2";

	private static String inserCarTable = "INSERT INTO  holderbaum_web_v2 ("
			+ "ser_id, auf_nr, aufbau, hersteller, modell, leistung, tuv, au, ez, tacho, preis, gesch_art, treibstoff, automatic, lack, klima, be, met, mws, esp,"
			+ "abs, ahk, leder, weg, nav, schieb, zentr, elfenster, tueren, hubraum, modellbezeichung, emiss_co2_mix, consump_mix, consump_road, consump_city, allwheel, motor_id, date_created, hsn, tsn,"
			+ "garantie, care_status, was_commercial_use, euromobil, emis_badge, emis_standard, chassisno, reseller, owner_count, car_seats, color_generic, hints, category, veh_type, neuwagen, landeskennung, co2eff)";
			
	private static String qInserQuery = inserCarTable+" Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static int insert(Connection cn, DTOCar car) throws Exception {
		
		jlogger.info("Insert Car : UCanAccess");
		int x = 0;
		try (PreparedStatement pst = cn.prepareStatement(qInserQuery)) {
			pst.setLong(1, car.getSer_id());
			pst.setString(2, car.getAuf_nr());
			pst.setString(3, car.getAufbau());
			pst.setString(4, car.getHersteller());
			pst.setString(5, car.getModell());
		
			pst.setBigDecimal(6, car.getLeistung());
			pst.setString(7, car.getTuv());
			pst.setString(8, car.getAu());
			pst.setDate( 9, new java.sql.Date(car.getEz().getTime()));
			pst.setBigDecimal(10, car.getTacho());
			
			pst.setBigDecimal(11, car.getPreis());
			pst.setBigDecimal(12,car.getGesch_art());
			pst.setBigDecimal(13, car.getTreibstoff());
			pst.setBigDecimal(14, car.getAutomatic());
			pst.setString(15,car.getLack());
			
			pst.setBigDecimal(16, car.getKlima());
			pst.setString(17,car.getBe());
			pst.setBigDecimal(18, car.getMet());
			pst.setBigDecimal(19, car.getMws());
			pst.setBigDecimal(20, car.getEsp());
			pst.setBigDecimal(21, car.getAsp());
			pst.setBigDecimal(22, car.getAhk());
			pst.setBigDecimal(23, car.getLeder());
			pst.setBigDecimal(24, car.getWeg());
			pst.setBigDecimal(25, car.getNav());
			
			pst.setBigDecimal(26, car.getSchieb());
			pst.setBigDecimal(27, car.getZentr());
			pst.setBigDecimal(28, car.getElfenster());
			pst.setBigDecimal(29, car.getTueren());
			pst.setBigDecimal(30, car.getHubraum());
			
			pst.setString(31,car.getModellbezeichnung());
			pst.setBigDecimal(32, car.getEmiss_co2_mix());
			pst.setBigDecimal(33, car.getConsump_mix());
			pst.setBigDecimal(34, car.getConsump_road());
			pst.setBigDecimal(35, car.getConsump_city());
			
			pst.setBigDecimal(36, car.getAllwheel());
			pst.setBigDecimal(37, car.getMotor_id());
			pst.setDate(38, new java.sql.Date(car.getDate_created().getTime()));
			pst.setString(39,car.getHsn());
			pst.setString(40,car.getTsn());
			
			pst.setBigDecimal(41, car.getGarantie());
			pst.setBigDecimal(42, car.getCare_status());
			pst.setBigDecimal(43, car.getWas_commerical_use());
			pst.setBigDecimal(44, car.getEuromobil());
			pst.setBigDecimal(45, car.getEmis_badge());
			
			pst.setBigDecimal(46, car.getEmis_standard());
			pst.setString(47, car.getChassisno());
			pst.setBigDecimal(48, car.getReseller());
			pst.setBigDecimal(49, car.getOwner_count());
			pst.setBigDecimal(50, car.getCar_seats());
			
			pst.setString(51, car.getColor_generic());
			pst.setString(52, car.getHints());
			pst.setString(53, car.getCategory());
			pst.setBigDecimal(54, car.getVeh_type());
			pst.setBigDecimal(55, car.getNeuwagen());
			
			pst.setString(56, car.getLandeskennung());
			pst.setString(57, car.getCo2eff());
			
			x = pst.executeUpdate();
			
			
			
		} catch (Exception e) {
			jlogger.warning("Fehlert beim Einfügen eines Datensatzes : " + e);
			throw e;
		}

		return x;

	}
	
	
	public static int insert(Connection cn, List<DTOCar> cars) throws Exception {
		
		jlogger.info("Insert Cars : UCanAccess");
		int x = 0;
		try (PreparedStatement pst = cn.prepareStatement(qInserQuery)) {
			for(DTOCar car : cars){
			pst.setLong(1, car.getSer_id());
			pst.setString(2, car.getAuf_nr());
			pst.setString(3, car.getAufbau());
			pst.setString(4, car.getHersteller());
			pst.setString(5, car.getModell());
		
			pst.setBigDecimal(6, car.getLeistung());
			pst.setString(7, car.getTuv());
			pst.setString(8, car.getAu());
			pst.setDate( 9, new java.sql.Date(car.getEz().getTime()));
			pst.setBigDecimal(10, car.getTacho());
			
			pst.setBigDecimal(11, car.getPreis());
			pst.setBigDecimal(12,car.getGesch_art());
			pst.setBigDecimal(13, car.getTreibstoff());
			pst.setBigDecimal(14, car.getAutomatic());
			pst.setString(15,car.getLack());
			
			pst.setBigDecimal(16, car.getKlima());
			pst.setString(17,car.getBe());
			pst.setBigDecimal(18, car.getMet());
			pst.setBigDecimal(19, car.getMws());
			pst.setBigDecimal(20, car.getEsp());
			pst.setBigDecimal(21, car.getAsp());
			pst.setBigDecimal(22, car.getAhk());
			pst.setBigDecimal(23, car.getLeder());
			pst.setBigDecimal(24, car.getWeg());
			pst.setBigDecimal(25, car.getNav());
			
			pst.setBigDecimal(26, car.getSchieb());
			pst.setBigDecimal(27, car.getZentr());
			pst.setBigDecimal(28, car.getElfenster());
			pst.setBigDecimal(29, car.getTueren());
			pst.setBigDecimal(30, car.getHubraum());
			
			pst.setString(31,car.getModellbezeichnung());
			pst.setBigDecimal(32, car.getEmiss_co2_mix());
			pst.setBigDecimal(33, car.getConsump_mix());
			pst.setBigDecimal(34, car.getConsump_road());
			pst.setBigDecimal(35, car.getConsump_city());
			
			pst.setBigDecimal(36, car.getAllwheel());
			pst.setBigDecimal(37, car.getMotor_id());
			pst.setDate(38, new java.sql.Date(car.getDate_created().getTime()));
			pst.setString(39,car.getHsn());
			pst.setString(40,car.getTsn());
			
			pst.setBigDecimal(41, car.getGarantie());
			pst.setBigDecimal(42, car.getCare_status());
			pst.setBigDecimal(43, car.getWas_commerical_use());
			pst.setBigDecimal(44, car.getEuromobil());
			pst.setBigDecimal(45, car.getEmis_badge());
			
			pst.setBigDecimal(46, car.getEmis_standard());
			pst.setString(47, car.getChassisno());
			pst.setBigDecimal(48, car.getReseller());
			pst.setBigDecimal(49, car.getOwner_count());
			pst.setBigDecimal(50, car.getCar_seats());
			
			pst.setString(51, car.getColor_generic());
			pst.setString(52, car.getHints());
			pst.setString(53, car.getCategory());
			pst.setBigDecimal(54, car.getVeh_type());
			pst.setBigDecimal(55, car.getNeuwagen());
			
			pst.setString(56, car.getLandeskennung());
			pst.setString(57, car.getCo2eff());
			
			x = pst.executeUpdate();
			jlogger.info("Feinfügen eines Datensatzes : " + car.getChassisno());
			
			}
		} catch (Exception e) {
			jlogger.warning("Fehler beim Einfügen eines Datensatzes : " + e);
			throw e;
		}

		return x;

	}
	//TODO wird nie genutzt.
	public static int deleteAll(Connection cn) throws SQLException {
		int x = 0;
		try (PreparedStatement pstmt = cn.prepareStatement(qdelete)) {

			x = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}

		return x;
	}

}
