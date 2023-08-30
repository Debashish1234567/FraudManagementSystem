package com.cognizant.fraudmanagementsystem.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.cognizant.fraudmanagementsystem.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

class AdminMapper implements RowMapper<Admin> {

    @Override
    public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
        Admin admin = new Admin();
        admin.setId(rs.getString("id"));
        admin.setFirstName(rs.getString("first_name"));
        admin.setLastName(rs.getString("last_name"));
        admin.setDob(rs.getDate("dob"));
        admin.setGender(rs.getString("gender"));
        admin.setContactNo(rs.getString("contact_no"));
        admin.setEmail(rs.getString("email"));
        admin.setPassword(rs.getString("password"));
        admin.setFirstAnswer(rs.getString("first_answer"));
        admin.setSecondAnswer(rs.getString("second_answer"));
        admin.setThirdAnswer(rs.getString("third_answer"));
        return admin;
    }
    
}

@Repository
public class AdminRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminRepository(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    public List<Admin> getAllAdmins() {
        return jdbcTemplate.query("select * from admins", new AdminMapper());
    }

    public void addAdmin(Admin admin) {
        jdbcTemplate.execute(
            "insert into admins values('"+
                admin.getId() + "','" + 
                admin.getFirstName() + "','" +
                admin.getLastName() + "','" + 
                new java.sql.Date(admin.getDob().getTime()) + "','" + 
                admin.getGender() + "','" + 
                admin.getContactNo() + "','" +
                admin.getEmail() + "','" + 
                admin.getPassword() + "','" + 
                admin.getFirstAnswer() + "','" + 
                admin.getSecondAnswer() + "','" + 
                admin.getThirdAnswer() + "')"
            );
    }

    public void updatePassword(String id, String newPassword) {
        jdbcTemplate.execute("update admins set password = '" + newPassword + "' where id = '" + id + "'");
    }
}