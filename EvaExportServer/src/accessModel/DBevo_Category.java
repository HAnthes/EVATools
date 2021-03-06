package accessModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.VehicleOptionCategory;

/**
 * Controller f�r die Kategorie n:m zuordunung.
 * @author anthes
 *
 */

public class DBevo_Category {

	private static java.util.logging.Logger jlogger = java.util.logging.Logger.getLogger(Class.class.getName());
	
	private final static String qinsert = "INSERT INTO evo_category (code, description, type) VALUES ( ? ,?, ?)";

	public static void insert(Connection cn, VehicleOptionCategory data) throws SQLException {
		jlogger.info("Einf�gen Datensatz");
		try (PreparedStatement pst = cn.prepareStatement(qinsert)) {

			pst.setString(1, data.getCode());
			pst.setString(2, data.getDescription());
			pst.setString(3, "" + data.getType());

			pst.executeUpdate();

		} catch (SQLException e) {
			jlogger.warning("Fehlert beim Einf�gen eines Datensatzes : " + e);
			throw e;
		}
	}

	public static void insert(Connection cn, List<VehicleOptionCategory> datas) throws SQLException {

		for (VehicleOptionCategory a : datas) {
			insert(cn, a);
		}

	}

}
