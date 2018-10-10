package com.example.infinity.prof.model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ModulesItem{

	@SerializedName("name")
	private String name;

	@SerializedName("about")
	private String about;

	@SerializedName("kurs")
	private String kurs;

	@SerializedName("id")
	private int id;

	@SerializedName("lessons_count")
	private String lessonsCount;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAbout(String about){
		this.about = about;
	}

	public String getAbout(){
		return about;
	}

	public void setKurs(String kurs){
		this.kurs = kurs;
	}

	public String getKurs(){
		return kurs;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setLessonsCount(String lessonsCount){
		this.lessonsCount = lessonsCount;
	}

	public String getLessonsCount(){
		return lessonsCount;
	}

	@Override
 	public String toString(){
		return 
			"ModulesItem{" + 
			"name = '" + name + '\'' + 
			",about = '" + about + '\'' + 
			",kurs = '" + kurs + '\'' + 
			",id = '" + id + '\'' + 
			",lessons_count = '" + lessonsCount + '\'' + 
			"}";
		}
}