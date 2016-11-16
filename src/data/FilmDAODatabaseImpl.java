package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FilmDAODatabaseImpl implements FilmDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";

	public FilmDAODatabaseImpl() throws ClassNotFoundException {
		try{
		Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException cnfe) {
			System.err.println(cnfe);
		}
	}

	@Override
	public List<String> getFilmByID(int id) {
		List<String> film = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, "root", "root");
			Statement stmt = conn.createStatement();
			String sql = "select title, description from film where id = " + id;
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				film.add(rs.getString(1));
				film.add(rs.getString(2));
			}
			rs.close();
			stmt.close();
			conn.close();
			
			System.out.println(film);
			
		} catch (SQLException sqle) {
			System.err.println(sqle);
		}
		return film;
	}

}
