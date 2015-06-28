package net.bozorgi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("OffersDAO")
public class OffersDAO {

	private NamedParameterJdbcTemplate jdbc;

	public OffersDAO() {
		System.out.println("DOA loaded successfully.");

	}

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public Offers getOffer(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from offers, users where offers.username = users.username and users.enabled = true", params,
				new OfferRowMapper());
		
	}

	public List<Offers> getOffers() {

		return jdbc.query("select * from offers, users where offers.username = users.username and users.enabled = true", 
				new OfferRowMapper());

	}

	public List<Offers> getOffers(String username) {

		return jdbc.query(
				"select * from offers, users where offers.username = users.username and users.enabled = true and offers.username = :username",
				new MapSqlParameterSource("username", username), new OfferRowMapper());

	}

	public boolean createOffer(Offers createOffer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(createOffer);

		System.out.println("createOffer from OffersDAO class.");
		return jdbc.update("insert into offers(username, text) values (:username, :text)", params) == 1;
	}

	public boolean updateOffer(Offers updateOffer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(updateOffer);

		return jdbc.update("update offers set text=:text where id=:id", params) == 1;
	}

	@Transactional
	public int[] createList(List<Offers> listOffers) {

		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(listOffers.toArray());

		return jdbc.batchUpdate("insert into offers(username, text) values (:username, :text)", params);
	}

	public int delete(int id) {
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);
		return jdbc.update("delete from offers where id=:id", param);

	}

}
