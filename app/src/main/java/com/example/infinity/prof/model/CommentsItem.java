package com.example.infinity.prof.model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class CommentsItem {

	@SerializedName("date")
	private String date;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("teacher_id")
	private Object teacherId;

	@SerializedName("comment")
	private String comment;

	@SerializedName("id")
	private int id;

	@SerializedName("type")
	private String type;

	@SerializedName("lesson_Id")
	private String lessonId;

	@SerializedName("status")
	private String status;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setTeacherId(Object teacherId){
		this.teacherId = teacherId;
	}

	public Object getTeacherId(){
		return teacherId;
	}

	public void setComment(String comment){
		this.comment = comment;
	}

	public String getComment(){
		return comment;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setLessonId(String lessonId){
		this.lessonId = lessonId;
	}

	public String getLessonId(){
		return lessonId;
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
			"CommentsItem{" + 
			"date = '" + date + '\'' + 
			",user_id = '" + userId + '\'' + 
			",teacher_id = '" + teacherId + '\'' + 
			",comment = '" + comment + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			",lesson_Id = '" + lessonId + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}