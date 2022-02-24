package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import vo.PotentialLead;

@Service
public class HomePageDAO {
	private JdbcTemplate jdbcTemplate;

	// Spring is smart enough to know so it doesn't have to use Autowire if a
	// Constructor exists.
	public HomePageDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Map<String, Object>> getListofAllPLsJDBC() {
		return jdbcTemplate.queryForList("SELECT * from POTENTIAL_LEADS");
	}

	public List<PotentialLead> getListofAllPLsRowMapper() {

		return jdbcTemplate.query("SELECT * from POTENTIAL_LEADS", new RowMapper<PotentialLead>() {

			@Override
			public PotentialLead mapRow(ResultSet rs, int rowNumber) throws SQLException {
				PotentialLead pl = new PotentialLead();
				pl.setId(rs.getString("ID"));
				pl.setCompany(rs.getString("COMPANY"));
				return pl;
			}
		});

	}
}
