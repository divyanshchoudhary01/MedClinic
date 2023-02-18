package com.thinking.machines.hr.servlets;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.thinking.machines.hr.dl.*;
public class Login extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
System.out.println("Login method got called ");
String username=request.getParameter("username");
String password=request.getParameter("password");
System.out.println("Username value is  "+username);
System.out.println("password value is  "+password);
AdministratorDAO administratorDAO=new AdministratorDAO();
AdministratorDTO administratorDTO=administratorDAO.getByUsername(username);
if(administratorDTO==null)
{
throw new DAOException("InvalidUP");
}
if(!(username.equalsIgnoreCase(administratorDTO.getUsername())))
{
throw new DAOException("Invalid Username");
}
if(!(password.equalsIgnoreCase(administratorDTO.getPassword())))
{
throw new DAOException("Invalid Password");
}
PrintWriter pw=response.getWriter();
pw.print("1");
}catch(Exception e)
{
try
{
PrintWriter pw=response.getWriter();
pw.print(e.getMessage());
}catch(Exception ee)
{
System.out.println(ee.getMessage());
}
}
}
}