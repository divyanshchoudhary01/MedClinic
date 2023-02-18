package com.thinking.machines.hr.dl;
import java.util.*;
import java.io.*;
import java.sql.*;
public class AdministratorDAO
{
public AdministratorDTO getByUsername(String username) throws DAOException
{
try
{
ResultSet resultSet;
PreparedStatement preparedStatement;
Connection connection;
connection=DAOConnection.getConnection();
AdministratorDTO administratorDTO=new AdministratorDTO();
preparedStatement=connection.prepareStatement("Select *  from administrator   where username=?");
preparedStatement.setString(1,username.trim());
resultSet=preparedStatement.executeQuery();
if(!(resultSet.next()))
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("UserName doesn't exist");
}
administratorDTO.setUsername(resultSet.getString("username"));
administratorDTO.setPassword(resultSet.getString("password"));
resultSet.close();
preparedStatement.close();
connection.close();
return administratorDTO;
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
}
public int createAccount(AdministratorDTO administratorDTO) throws DAOException
{
try
{
ResultSet resultSet;
PreparedStatement preparedStatement;
Connection connection;
connection=DAOConnection.getConnection();
preparedStatement=connection.prepareStatement("Select *  from administrator   where username=?");
preparedStatement.setString(1,administratorDTO.getUsername().trim());
resultSet=preparedStatement.executeQuery();
if(!(resultSet.next()))
{
//create account
preparedStatement=connection.prepareStatement("insert into administrator (username,password) values(?,?)");
preparedStatement.setString(1,administratorDTO.getUsername().trim());
preparedStatement.setString(2,administratorDTO.getPassword().trim());
preparedStatement.executeUpdate();
resultSet.close();
preparedStatement.close();
connection.close();
return 1;
}
//username already exists
resultSet.close();
preparedStatement.close();
connection.close();
return 2;
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
}


}