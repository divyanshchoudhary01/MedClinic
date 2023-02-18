package com.thinking.machines.hr.dl;
import java.sql.*;
public class DAOConnection 
{
private DAOConnection(){}
static public Connection getConnection() throws DAOException
{
try
{
Connection connection;
Statement statement;
Class.forName("com.mysql.cj.jdbc.Driver");
connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/tmdb","tmdbuser","tmdbuser");
return connection;
}catch(Exception e)
{
System.out.println(e.getMessage());
throw new DAOException(e.getMessage());
}
}
}
