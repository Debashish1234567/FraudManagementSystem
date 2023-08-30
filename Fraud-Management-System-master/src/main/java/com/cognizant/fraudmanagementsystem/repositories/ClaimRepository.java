package com.cognizant.fraudmanagementsystem.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.cognizant.fraudmanagementsystem.model.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

class ClaimMapper implements RowMapper<Claim> {

    @Override
    public Claim mapRow(ResultSet rs, int rowNum) throws SQLException {
        Claim claim = new Claim();
        claim.setId(rs.getInt("id"));
        claim.setCardNo(rs.getLong("card_no"));
        claim.setUserId(rs.getString("user_id"));
        claim.setCardHolderName(rs.getString("card_holder_name"));
        claim.setCardType(rs.getString("card_type"));
        claim.setAccountNo(rs.getLong("account_no"));
        claim.setExpiryDate(rs.getDate("expiry_date"));
        claim.setTransactionDate(rs.getDate("transaction_date"));
        claim.setTransactionDetails(rs.getString("transaction_details"));
        claim.setRemarks(rs.getString("remarks"));
        claim.setFraudLevel(rs.getString("fraud_level"));
        return claim;
    }
    
}

@Repository
public class ClaimRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ClaimRepository(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    public List<Claim> getAllClaims() {
        return jdbcTemplate.query("select * from claims", new ClaimMapper());
    }

    public void addClaim(Claim claim) {
        jdbcTemplate.update(
            "insert into claims (" +
                "card_no, " + 
                "user_id, " + 
                "card_holder_name, " + 
                "card_type, " +
                "account_no, " + 
                "expiry_date, " + 
                "transaction_date, " + 
                "transaction_details, " +
                "remarks, " +
                "fraud_level) " +
                "values (?,?,?,?,?,?,?,?,?,?)",
                claim.getCardNo(),
                claim.getUserId(),
                claim.getCardHolderName(),
                claim.getCardType(), 
                claim.getAccountNo(),
                new java.sql.Date(claim.getExpiryDate().getTime()),
                new java.sql.Date(claim.getTransactionDate().getTime()),
                claim.getTransactionDetails(),
                claim.getRemarks(),
                claim.getFraudLevel()
            );
    }

    public void delete(Claim claim) {
        jdbcTemplate.execute(
            "delete from claims where id = " + claim.getId()            
        );
    }
}
