package com.example.infinity.prof.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class NotificationsItem{

	@SerializedName("student_id")
	@Expose
	private String studentId;

	@SerializedName("id")
	@Expose
	private int id;

	@SerializedName("text")
	@Expose
	private String text;

	@SerializedName("when")
	@Expose
	private String when;

	@SerializedName("status")
	@Expose
	private String status;

	public NotificationsItem() {
	}

	public NotificationsItem(String studentId, int id, String text, String when, String status) {
		this.studentId = studentId;
		this.id = id;
		this.text = text;
		this.when = when;
		this.status = status;
	}

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