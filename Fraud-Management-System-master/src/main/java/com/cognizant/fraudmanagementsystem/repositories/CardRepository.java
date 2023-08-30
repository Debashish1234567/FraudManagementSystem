package com.cognizant.fraudmanagementsystem.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.cognizant.fraudmanagementsystem.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

class CardMapper implements RowMapper<Card> {

    @Override
    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
        Card card = new Card();
        card.setId(rs.getInt("id"));
        card.setCardNo(rs.getLong("card_no"));
        card.setUserId(rs.getString("user_id"));
        card.setCardHolderName(rs.getString("card_holder_name"));
        card.setCardType(rs.getString("card_type"));
        card.setAccountNo(rs.getLong("account_no"));
        card.setExpiryDate(rs.getDate("expiry_date"));
        card.setTransactionDate(rs.getDate("transaction_date"));
        card.setTransactionDetails(rs.getString("transaction_details"));
        card.setRemarks(rs.getString("remarks"));
        card.setFraudLevel(rs.getString("fraud_level"));
        return card;
    }
    
}

@Repository
public class CardRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CardRepository(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    public List<Card> getAllCards() {
        return jdbcTemplate.query("select * from cards", new CardMapper());
    }

    public void addCard(Card card) {
        jdbcTemplate.update(
            "insert into cards (" +
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
                card.getCardNo(),
                card.getUserId(),
                card.getCardHolderName(),
                card.getCardType(), 
                card.getAccountNo(),
                new java.sql.Date(card.getExpiryDate().getTime()),
                new java.sql.Date(card.getTransactionDate().getTime()),
                card.getTransactionDetails(),
                card.getRemarks(),
                card.getFraudLevel()
            );
    }

    public void delete(Card card) {
        jdbcTemplate.execute(
            "delete from cards where id = " + card.getId()            
        );
    }
}
