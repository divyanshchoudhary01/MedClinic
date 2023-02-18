package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import javax.servlet.http.*;
public class patient extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
List<PatientDTO> pt=new PatientDAO().getAll();
int i=0;
for(PatientDTO patientDTO:pt)
{
i++;
pw.println(patientDTO.getName());
pw.println(",");
pw.println(patientDTO.getFatherName());
pw.println(",");
pw.println(patientDTO.getMotherName());
pw.println(",");
pw.println(patientDTO.getdoctorName());
pw.println(",");
pw.println(patientDTO.getDisease());
pw.println(",");
pw.println(patientDTO.getTime());
pw.println(",");
pw.println(patientDTO.getDateOfBirth());
pw.println(",");
pw.println(patientDTO.getGender());
pw.println(",");
pw.println(patientDTO.getIsIndian());
pw.println(",");
pw.println(patientDTO.getIsInsured());
pw.println(",");
pw.println(patientDTO.getPanNumber());
pw.println(",");
pw.println(patientDTO.getAadharCardNumber());
if(i<pt.size()) pw.print(",");
}
}catch(Exception e)
{
System.out.println(e.getMessage());
}
}
}