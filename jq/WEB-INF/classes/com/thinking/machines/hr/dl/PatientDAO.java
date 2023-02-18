package com.thinking.machines.hr.dl;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.math.*;
public class PatientDAO
{
public List<PatientDTO> getAll() throws DAOException
{
try
{
List<PatientDTO> patientes=new LinkedList<>();
PatientDTO patientDTO;
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select * from patient");
ResultSet resultSet=preparedStatement.executeQuery();

while(resultSet.next())
{
String name,fatherName,motherName,panCardNumber,aadharCardNumber,
doctorName,disease,apTime,gender;
java.util.Date dateOfBirth;
boolean isIndian,isInsured;
name=resultSet.getString("name");
fatherName=resultSet.getString("fatherName");
motherName=resultSet.getString("motherName");
panCardNumber=resultSet.getString("panCardNumber");
aadharCardNumber=resultSet.getString("aadharCardNumber");
doctorName=resultSet.getString("doctorName");
disease=resultSet.getString("disease");
apTime=resultSet.getString("apTime");
gender=resultSet.getString("gender");
dateOfBirth=resultSet.getDate("dateOfBirth");
isIndian=resultSet.getBoolean("isIndian");
isInsured=resultSet.getBoolean("isInsured");
patientDTO=new PatientDTO();
patientDTO.setName(name);
patientDTO.setFatherName(fatherName);
patientDTO.setMotherName(motherName);
patientDTO.setdoctorName(doctorName);
patientDTO.setDisease(disease);
patientDTO.setTime(apTime);

patientDTO.setDateOfBirth(dateOfBirth);
patientDTO.setGender(gender);
patientDTO.setIsIndian(isIndian);
patientDTO.setIsInsured(isInsured);
patientDTO.setPanNumber(panCardNumber);
patientDTO.setAadharCardNumber(aadharCardNumber);
patientes.add(patientDTO);
}
resultSet.close();
preparedStatement.close();
connection.close();
return patientes;
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
}
public void delete(String aadharCardNumber) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("delete from patient where aadharCardNumber=?");
preparedStatement.setString(1,aadharCardNumber);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
}
public void add(PatientDTO patientDTO) throws DAOException
{
try
{
//before adding the new appointment ,check for the appointment time
//in the database
//if it exists throw the exception  time already taken
//there will be gap of 30 min between each qappointment
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select * from patient where apTime=?");
preparedStatement.setString(1, patientDTO.getTime());
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==true)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("2");
}






preparedStatement=connection.prepareStatement("insert into patient (name,fatherName,motherName,doctorName,disease,apTime,dateOfBirth,gender,isIndian,isInsured,panCardNumber,aadharCardNumber) values(?,?,?,?,?,?,?,?,?,?,?,?)");



preparedStatement.setString(1,patientDTO.getName().trim());
preparedStatement.setString(2,patientDTO.getFatherName());
preparedStatement.setString(3,patientDTO.getMotherName());
preparedStatement.setString(4,patientDTO.getdoctorName());
preparedStatement.setString(5,patientDTO.getDisease());
preparedStatement.setString(6, patientDTO.getTime());
preparedStatement.setDate(7,new java.sql.Date(patientDTO.getDateOfBirth().getYear(),patientDTO.getDateOfBirth().getMonth(),patientDTO.getDateOfBirth().getDay()));
preparedStatement.setString(8,patientDTO.getGender());
preparedStatement.setBoolean(9,patientDTO.getIsIndian());
preparedStatement.setBoolean(10,patientDTO.getIsInsured());
preparedStatement.setString(11,patientDTO.getPanNumber());
preparedStatement.setString(12,patientDTO.getAadharCardNumber());
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(Exception dao)
{
System.out.println("Exception getting generated ");
System.out.println(dao.getMessage());
throw new DAOException(dao.getMessage());
}
}
public boolean panCardNumberExists(String panNumber) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select * from patient where panCardNumber=?");
preparedStatement.setString(1,panNumber);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==true)
{
resultSet.close();
preparedStatement.close();
connection.close();
return true;
}
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return false;
}
public boolean aadharCardNumberExists(String aadharCardNumber) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select * from patient where aadharCardNumber=?");
preparedStatement.setString(1,aadharCardNumber.trim());
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==true)
{
resultSet.close();
preparedStatement.close();
connection.close();
return true;
}
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return false;
}
}