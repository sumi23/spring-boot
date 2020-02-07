package com.example.demo.dto;
public class UpdateCustomerdto
{
  private  int id;
  private  int age;
  
  @Override
	public String toString() {
		return " [Id= " + id + " Age= " +age+"]";
	}
  public  int getId()
  {
	  return id;
  }
  public  int getAge()
  {
	  return age;
  }
  public void setId(int id)
  {
	  this.id=id;
  }
  public void setAge(int age)
  {
	  this.age=age;
  }
}