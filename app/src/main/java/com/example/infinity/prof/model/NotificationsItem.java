package com.example.infinity.prof.model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class NotificationsItem{

	@SerializedName("student_id")
	private String studentId;

	@SerializedName("id")
	private int id;

	@SerializedName("text")
	private String text;

	@SerializedName("when")
	private String when;

	@SerializedName("status")
	private String status;

	public void setStudentId(String studentId){
		this.studentId = studentId;
	}

	public String getStudentId(){
		return studentId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setWhen(String when){
		this.when = when;
	}

	public String getWhen(){
		return when;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"NotificationsItem{" + 
			"student_id = '" + studentId + '\'' + 
			",id = '" + id + '\'' + 
			",text = '" + text + '\'' + 
			",when = '" + when + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}