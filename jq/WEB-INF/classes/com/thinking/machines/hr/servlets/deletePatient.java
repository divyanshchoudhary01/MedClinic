package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.math.*;
import com.thinking.machines.hr.dl.*;
import java.text.*;
public class deletePatient extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String aadharCardNumber=request.getParameter("aadharCardNumber");
PrintWriter pw=response.getWriter();
PatientDAO patientDAO=new PatientDAO();
boolean ans=patientDAO.aadharCardNumberExists(aadharCardNumber);
if(ans==false)
{
pw.print("Aadhar Card Number doesn't exists");
return;
}
patientDAO.delete(aadharCardNumber);
pw.print("1");
}catch(Exception e)
{
try
{
PrintWriter pw=response.getWriter();
pw.print(e.getMessage());
}catch(Exception ee)
{
}
}
}
}