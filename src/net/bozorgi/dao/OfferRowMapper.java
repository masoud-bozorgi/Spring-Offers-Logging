package net.bozorgi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OfferRowMapper implements RowMapper<Offers> {

	@Override
	public Offers mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setAuthority(rs.getString("authority"));
		user.setEmail(rs.getString("email"));
		user.setEnabled(true);
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));
		
		
		Offers dbOfferResult = new Offers();
		dbOfferResult.setId(rs.getInt("id"));
		dbOfferResult.setText(rs.getString("text"));
		
		dbOfferResult.setUser(user);
		
		return dbOfferResult;
	}

}
