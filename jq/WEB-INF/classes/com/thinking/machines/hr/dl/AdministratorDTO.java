package com.thinking.machines.hr.dl;
import java.util.*;
import java.io.*;
public class AdministratorDTO implements java.io.Serializable,Comparable<AdministratorDTO>
{
private String username;
private String password;
public void setUsername(String username)
{
this.username=username;
}
public String getUsername()
{
return this.username;
}
public void setPassword(String password)
{
this.password=password;
}
public String getPassword()
{
return this.password;
}
public int compareTo(AdministratorDTO object)
{
return this.username.compareToIgnoreCase(object.getUsername());
}
public boolean equals(Object object)
{
if(!(object instanceof AdministratorDTO)) return false;
AdministratorDTO other=(AdministratorDTO)object;
int number=this.compareTo(other);
if(number==0)
{
return true;
}
else
{
return false;
}
}
public int hashCode()
{
return super.hashCode();
} 
}