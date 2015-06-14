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

	public OffersDAO(){
		System.out.println("DOA loaded successfully.");
		
	}
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offers> getOffers() {

		return jdbc.query("select * from offers", new RowMapper<Offers>() {

			public Offers mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offers dbOfferResult = new Offers();

				dbOfferResult.setId(rs.getInt("id"));
				dbOfferResult.setName(rs.getString("name"));
				dbOfferResult.setText(rs.getString("text"));
				dbOfferResult.setEmail(rs.getString("email"));

				return dbOfferResult;
			}

		});

	}

	public Offers getOffer(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from offers where id=:id", params,
				new RowMapper<Offers>() {

					public Offers mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Offers dbOffersObjectResult = new Offers();

						dbOffersObjectResult.setId(rs.getInt("id"));
						dbOffersObjectResult.setName(rs.getString("name"));
						dbOffersObjectResult.setText(rs.getString("text"));
						dbOffersObjectResult.setEmail(rs.getString("email"));

						return dbOffersObjectResult;
					}

				});
	}

	public int delete(int id) {
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);
		return jdbc.update("delete from offers where id=:id", param);

	}

	public boolean createOffer(Offers createOffer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(
				createOffer);
		System.out.println("createOffer from OffersDAO class.");
		return jdbc
				.update("insert into offers(name, text, email) values (:name, :text, :email)",
						params) == 1;
	}

	public boolean updateOffer(Offers updateOffer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(
				updateOffer);

		return jdbc
				.update("update offers set name=:name, text=:text, email=:email where id=:id",
						params) == 1;
	}
	
	@Transactional
	public int[] createList(List<Offers> listOffers) {

		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(listOffers.toArray());

		return jdbc.batchUpdate("insert into offers (name, text, email) values (:name, :text, :email)",	params);
	}

}
