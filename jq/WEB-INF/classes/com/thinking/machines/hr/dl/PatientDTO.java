package com.thinking.machines.hr.dl;
import java.util.*;
import java.math.*;
public class PatientDTO implements java.io.Serializable,Comparable<PatientDTO>
{
private String name;
private String fatherName;
private String MotherName;
private String doctorName;
private boolean isInsured;
private Date dateOfBirth;
private String panNumber;
private String aadharCardNumber;
private String gender;
private String time;
private boolean isIndian;
private String disease;
public PatientDTO()
{
this.name="";
this.dateOfBirth=null;
this.panNumber="";
this.aadharCardNumber="";
this.gender="";
this.isIndian=false;
this.fatherName="";
this.MotherName="";
this.isInsured=false;
this.doctorName="";
this.disease="";
this.time="";
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setDateOfBirth(java.util.Date dateOfBirth)
{
this.dateOfBirth=dateOfBirth;
}
public void setTime(String time)
{
this.time=time;
}
public String getTime()
{
return this.time;
}
public java.util.Date getDateOfBirth()
{
return this.dateOfBirth;
}
public void setPanNumber(String panNumber)
{
this.panNumber=panNumber;
}
public String getPanNumber()
{
return this.panNumber;
}
public void setAadharCardNumber(String aadharCardNumber)
{
this.aadharCardNumber=aadharCardNumber;
}
public String getAadharCardNumber()
{
return this.aadharCardNumber;
}
public void setGender(String gender)
{
this.gender=gender;
}
public String getGender()
{
return this.gender;
}
public void setIsIndian(boolean isIndian)
{
this.isIndian=isIndian;
}
public void setdoctorName(String doctorName)
{
this.doctorName=doctorName;
}
public String getdoctorName()
{
return this.doctorName;
}
public void setFatherName(String fatherName)
{
this.fatherName=fatherName;
}
public String getFatherName()
{
return this.fatherName;
}
public void setMotherName(String MotherName)
{
this.MotherName=MotherName;
}
public String getMotherName()
{
return this.MotherName;
}
public void setDisease(String disease)
{
this.disease=disease;
}
public String getDisease()
{
return this.disease;
}
public boolean getIsIndian()
{
return this.isIndian;
}
public void setIsInsured(boolean isInsured)
{
this.isInsured=isInsured;
}
public boolean getIsInsured()
{
return this.isInsured;
}
public int compareTo(PatientDTO object)
{
return this.aadharCardNumber.compareToIgnoreCase(object.aadharCardNumber);
}
public boolean equals(Object object)
{
if(!(object instanceof PatientDTO)) return false;
PatientDTO other=(PatientDTO)object;
return this.aadharCardNumber.equalsIgnoreCase(other.aadharCardNumber);
}
/*public int hashCode()
{
return id.hashCode();
}*/
}