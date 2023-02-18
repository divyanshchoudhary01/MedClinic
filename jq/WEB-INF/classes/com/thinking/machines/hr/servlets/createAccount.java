package com.thinking.machines.hr.servlets;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
public class createAccount extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String username=request.getParameter("username");
String password=request.getParameter("password");
AdministratorDTO administratorDTO=new AdministratorDTO();
administratorDTO.setUsername(username);
administratorDTO.setPassword(password);
AdministratorDAO administratorDAO=new AdministratorDAO();
int  success=0;
success=administratorDAO.createAccount(administratorDTO);
//let 1 be for succes
// 2 for username already exists
PrintWriter pw=response.getWriter();
if(success==2)
{
pw.print("2");
return ;
}
pw=response.getWriter();
pw.print("1");
}catch(Exception e)
{
System.out.println("***********8");
}
}
}