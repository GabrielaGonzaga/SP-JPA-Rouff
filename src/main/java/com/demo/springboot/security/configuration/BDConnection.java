package com.demo.springboot.security.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {

  public Connection Connect() {
    Connection conn = null;
    String localBD = "localhost";
    String usuario = "root";
    String senha = "senai";
    try {
      String url = "jdbc:mysql://" + localBD + ":3306/rouff";
      conn = DriverManager.getConnection(url, usuario, senha);
      System.out.println("conexão OK!");
    } catch (SQLException erro) {
      System.out.print(erro);
      throw new RuntimeException(
        "Ocorreu um problema na conexão com o BD",
        erro
      );
    }
    return conn;
  }

  public void Desconnect(Connection con) {
    try {
      if (con != null) {
        con.close();
        System.out.println("Fechamento OK");
      }
    } catch (SQLException e) {
      throw new RuntimeException(
        "Ocorreu um problema para encerrar a conexão com o BD.",
        e
      );
    }
  }
}
