package com.example.infinity.prof.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Homework {

	@SerializedName("lessons")
	private List<LessonsItem> lessons;

	public void setLessons(List<LessonsItem> lessons){
		this.lessons = lessons;
	}

	public List<LessonsItem> getLessons(){
		return lessons;
	}

	@Override
 	public String toString(){
		return 
			"Homework{" + 
			"lessons = '" + lessons + '\'' + 
			"}";
		}
}