package com.example.infinity.prof.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class LessonsItem {

	@SerializedName("lesson_content")
	private String lessonContent;

	@SerializedName("date")
	private String date;

	@SerializedName("homeworks")
	private List<HomeworksItem> homeworks;

	@SerializedName("module_id")
	private String moduleId;

	@SerializedName("lesson_name")
	private String lessonName;

	@SerializedName("comments")
	private List<CommentsItem> comments;

	@SerializedName("group_id")
	private String groupId;

	@SerializedName("id")
	private int id;

	public void setLessonContent(String lessonContent){
		this.lessonContent = lessonContent;
	}

	public String getLessonContent(){
		return lessonContent;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setHomeworks(List<HomeworksItem> homeworks){
		this.homeworks = homeworks;
	}

	public List<HomeworksItem> getHomeworks(){
		return homeworks;
	}

	public void setModuleId(String moduleId){
		this.moduleId = moduleId;
	}

	public String getModuleId(){
		return moduleId;
	}

	public void setLessonName(String lessonName){
		this.lessonName = lessonName;
	}

	public String getLessonName(){
		return lessonName;
	}

	public void setComments(List<CommentsItem> comments){
		this.comments = comments;
	}

	public List<CommentsItem> getComments(){
		return comments;
	}

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

	@Override
 	public String toString(){
		return 
			"LessonsItem{" + 
			"lesson_content = '" + lessonContent + '\'' + 
			",date = '" + date + '\'' + 
			",homeworks = '" + homeworks + '\'' + 
			",module_id = '" + moduleId + '\'' + 
			",lesson_name = '" + lessonName + '\'' + 
			",comments = '" + comments + '\'' + 
			",group_id = '" + groupId + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}