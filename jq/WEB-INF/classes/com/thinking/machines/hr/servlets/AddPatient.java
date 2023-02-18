package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.math.*;
import com.thinking.machines.hr.dl.*;
import java.text.*;
public class AddPatient extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String name=request.getParameter("name");
String gender=request.getParameter("gender");
java.util.Date date=new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("date"));
String panCardNumber=request.getParameter("panCardNumber");
String aadharCardNumber=request.getParameter("aadharCardNumber");
String isIndian=request.getParameter("isIndian");
String isInsured=request.getParameter("isInsured");
String doctorName=request.getParameter("doctorName");
String fatherName=request.getParameter("fatherName");
String MotherName=request.getParameter("MotherName");
String disease=request.getParameter("disease");
String time=request.getParameter("appointmentTime");






PatientDTO patientDTO=new PatientDTO();
if(isIndian.equalsIgnoreCase("2"))
{
patientDTO.setIsIndian(false);
}
else
{
patientDTO.setIsIndian(true);
}

if(isInsured.equalsIgnoreCase("2"))
{
patientDTO.setIsInsured(false);
}
else
{
patientDTO.setIsInsured(true);
}
if(gender.equalsIgnoreCase("1"))
{
patientDTO.setGender("M");
}
else
{
patientDTO.setGender("F");
}
patientDTO.setName(name);
patientDTO.setdoctorName(doctorName);
patientDTO.setFatherName(fatherName);
patientDTO.setMotherName(MotherName);
patientDTO.setDisease(disease);
patientDTO.setTime(time);
patientDTO.setDateOfBirth(date);
patientDTO.setPanNumber(panCardNumber);
patientDTO.setAadharCardNumber(aadharCardNumber);
PatientDAO patientDAO=new PatientDAO();
boolean panNumberExists=patientDAO.panCardNumberExists(panCardNumber);
boolean aadharCardNumberExists=patientDAO.aadharCardNumberExists(aadharCardNumber);
if(panNumberExists==true && aadharCardNumberExists==true)
{                         
throw new DAOException("PA");
}
if(panNumberExists==true)
{                         
throw new DAOException("PANNUMBEREXISTS");
}
if(aadharCardNumberExists==true)
{
throw new DAOException("AADHARCARDNUMBEREXISTS");
}
PrintWriter pw=response.getWriter();
patientDAO.add(patientDTO);
pw.print("1");
}catch(Exception e)
{
try
{
PrintWriter pw=response.getWriter();
System.out.println("Exceptionnnnnnnnnnnnnnnnnnnnnn ");
pw.print(e.getMessage());
}catch(Exception ee)
{
System.out.println("Exceptionnnnnnnnnnnnnnnnnnnnnn 234");
}
}
}
}