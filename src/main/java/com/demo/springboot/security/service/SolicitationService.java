package com.demo.springboot.security.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.demo.springboot.security.configuration.BDConnection;
import com.demo.springboot.security.model.Solicitation;

public class SolicitationService {
    Connection con;
    PreparedStatement pstm;
    
    public void Create(Solicitation soli) {
        con = new BDConnection().Connect();
        String sql =
          "INSERT INTO users (name, email, password, age, phone) VALUES (?,?,?,?,?)";
    
        PreparedStatement preparedStmt;
        try {
          preparedStmt = con.prepareStatement(sql);
        //   preparedStmt.setString(1, soli.getAdopter_id());
        //   preparedStmt.setString(2, user.getEmail());
        //   preparedStmt.setString(3, user.getPassword());
        //   preparedStmt.setInt(4, user.getAge());
        //   preparedStmt.setString(5, user.getPhone());
          preparedStmt.execute();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
}
