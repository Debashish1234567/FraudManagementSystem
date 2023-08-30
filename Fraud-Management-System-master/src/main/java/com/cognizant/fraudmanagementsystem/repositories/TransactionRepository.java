package com.cognizant.fraudmanagementsystem.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.cognizant.fraudmanagementsystem.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

class TransactionMapper implements RowMapper<Transaction> {

    @Override
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setId(rs.getInt("id"));
        transaction.setCardNo(rs.getLong("card_no"));
        transaction.setUserId(rs.getString("user_id"));
        transaction.setCardHolderName(rs.getString("card_holder_name"));
        transaction.setCardType(rs.getString("card_type"));
        transaction.setAccountNo(rs.getLong("account_no"));
        transaction.setExpiryDate(rs.getDate("expiry_date"));
        transaction.setTransactionDate(rs.getDate("transaction_date"));
        transaction.setTransactionDetails(rs.getString("transaction_details"));
        transaction.setRemarks(rs.getString("remarks"));
        transaction.setFraudLevel(rs.getString("fraud_level"));
        return transaction;
    }
    
}

@Repository
public class TransactionRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TransactionRepository(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    public List<Transaction> getAllTransactions() {
        return jdbcTemplate.query("select * from transactions", new TransactionMapper());
    }

    public void addTransaction(Transaction transaction) {
        jdbcTemplate.execute(
            "insert into transactions values("+
                transaction.getId() + "," + 
                transaction.getCardNo() + ",'" + 
                transaction.getUserId() + "','" +
                transaction.getCardHolderName() + "','" +
                transaction.getCardType() + "'," + 
                transaction.getAccountNo() + ",'" +
                new java.sql.Date(transaction.getExpiryDate().getTime()) + "','" + 
                new java.sql.Date(transaction.getTransactionDate().getTime()) + "','" + 
                transaction.getTransactionDetails() + "','" + 
                transaction.getRemarks() + "','" +
                transaction.getFraudLevel() + "')"
            );
    }

    public void delete(Transaction transaction) {
        jdbcTemplate.execute(
            "delete from transactions where id = " + transaction.getId()            
        );
    }
}
