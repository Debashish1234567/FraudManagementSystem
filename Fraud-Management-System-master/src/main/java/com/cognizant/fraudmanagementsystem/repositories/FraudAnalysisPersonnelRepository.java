package com.cognizant.fraudmanagementsystem.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.cognizant.fraudmanagementsystem.model.FraudAnalysisPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

class FraudAnalysisPersonnelMapper implements RowMapper<FraudAnalysisPersonnel> {

    @Override
    public FraudAnalysisPersonnel mapRow(ResultSet rs, int rowNum) throws SQLException {
        FraudAnalysisPersonnel fraudAnalysisPersonnel = new FraudAnalysisPersonnel();
        fraudAnalysisPersonnel.setId(rs.getString("id"));
        fraudAnalysisPersonnel.setFirstName(rs.getString("first_name"));
        fraudAnalysisPersonnel.setLastName(rs.getString("last_name"));
        fraudAnalysisPersonnel.setDob(rs.getDate("dob"));
        fraudAnalysisPersonnel.setGender(rs.getString("gender"));
        fraudAnalysisPersonnel.setContactNo(rs.getString("contact_no"));
        fraudAnalysisPersonnel.setEmail(rs.getString("email"));
        fraudAnalysisPersonnel.setPassword(rs.getString("password"));
        fraudAnalysisPersonnel.setIsAuthorized(rs.getInt("is_authorized"));
        fraudAnalysisPersonnel.setFirstAnswer(rs.getString("first_answer"));
        fraudAnalysisPersonnel.setSecondAnswer(rs.getString("second_answer"));
        fraudAnalysisPersonnel.setThirdAnswer(rs.getString("third_answer"));
        return fraudAnalysisPersonnel;
    }
    
}

@Repository
public class FraudAnalysisPersonnelRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FraudAnalysisPersonnelRepository(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    public List<FraudAnalysisPersonnel> getAllFraudAnalysisPersonnels() {
        return jdbcTemplate.query("select * from fraud_analysis_personnels", new FraudAnalysisPersonnelMapper());
    }

    public FraudAnalysisPersonnel getFraudAnalysisPersonnelById(String id) {
        return jdbcTemplate.query(
            "select * from fraud_analysis_personnels where id = " + id,
            new FraudAnalysisPersonnelMapper()).get(0);
    }

    public void addFraudAnalysisPersonnel(FraudAnalysisPersonnel fraudAnalysisPersonnel) {
        jdbcTemplate.execute(
            "insert into fraud_analysis_personnels values('"+
                fraudAnalysisPersonnel.getId() + "','" + 
                fraudAnalysisPersonnel.getFirstName() + "','" +
                fraudAnalysisPersonnel.getLastName() + "','" + 
                new java.sql.Date(fraudAnalysisPersonnel.getDob().getTime()) + "','" + 
                fraudAnalysisPersonnel.getGender() + "','" + 
                fraudAnalysisPersonnel.getContactNo() + "','" +
                fraudAnalysisPersonnel.getEmail() + "','" + 
                fraudAnalysisPersonnel.getPassword() + "'," + 
                fraudAnalysisPersonnel.getIsAuthorized() + ",'" + 
                fraudAnalysisPersonnel.getFirstAnswer() + "','" + 
                fraudAnalysisPersonnel.getSecondAnswer() + "','" + 
                fraudAnalysisPersonnel.getThirdAnswer() + "')"
            );
    }

    public void delete(String id) {
        jdbcTemplate.execute("delete from fraud_analysis_personnels where id = '" + id + "'");
    }

    public void updateAuthorization(String id, int newAuthorizationValue) {
        jdbcTemplate.execute("update fraud_analysis_personnels set is_authorized = " + newAuthorizationValue + " where id = '" + id + "'");
    }

    public void updatePassword(String id, String newPassword) {
        jdbcTemplate.execute("update fraud_analysis_personnels set password = '" + newPassword + "' where id = '" + id + "'");
    }
}