package com.example.infinity.prof.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ModulesItem{

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("about")
	@Expose
	private String about;

	@SerializedName("kurs")
	@Expose
	private String kurs;

	@SerializedName("id")
	@Expose
	private int id;

	@SerializedName("lessons_count")
	@Expose
	private String lessonsCount;

	public ModulesItem() {
	}

	public ModulesItem(String name, String about, String kurs, int id, String lessonsCount) {
		this.name = name;
		this.about = about;
		this.kurs = kurs;
		this.id = id;
		this.lessonsCount = lessonsCount;
	}

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