package com.example.infinity.prof.model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class HomeworksItem {

	@SerializedName("group_id")
	private String groupId;

	@SerializedName("id")
	private int id;

	@SerializedName("lesson_id")
	private String lessonId;

	@SerializedName("content")
	private String content;

	public void setGroupId(String groupId){
		this.groupId = groupId;
	}

	public String getGroupId(){
		return groupId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setLessonId(String lessonId){
		this.lessonId = lessonId;
	}

	public String getLessonId(){
		return lessonId;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"HomeworksItem{" + 
			"group_id = '" + groupId + '\'' + 
			",id = '" + id + '\'' + 
			",lesson_id = '" + lessonId + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}