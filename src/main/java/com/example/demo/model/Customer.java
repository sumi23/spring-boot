package com.example.demo.model;
public class Customer
{
  private  int id;
  private  String name;
  private  int age;
  
  @Override
	public String toString() {
		return " [Id= " + id + " Name= " + name+ " Age= " +age+"]";
	}
  public  int getId()
  {
	  return id;
  }
  public  String getName()
  {
	  return name;
  }
  public  int getAge()
  {
	  return age;
  }
  public void setId(int id)
  {
	  this.id=id;
  }
  public void setName(String name)
  {
	  this.name=name;
  }
  public void setAge(int age)
  {
	  this.age=age;
  }
}