package com.example.infinity.prof.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Teacher{

	@SerializedName("raiting")
	@Expose
	private String raiting;

	@SerializedName("avg_flow")
	@Expose
	private String avgFlow;

	@SerializedName("avg_listen")
	@Expose
	private String avgListen;

	@SerializedName("level")
	@Expose
	private String level;

	@SerializedName("avg_project")
	@Expose
	private String avgProject;

	@SerializedName("about")
	@Expose
	private String about;

	@SerializedName("photo")
	@Expose
	private String photo;

	@SerializedName("active")
	@Expose
	private String active;

	@SerializedName("phone")
	@Expose
	private String phone;

	@SerializedName("surname")
	@Expose
	private String surname;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("avg_stud")
	@Expose
	private String avgStud;

	@SerializedName("id")
	@Expose
	private int id;

	public Teacher() {
	}

	public Teacher(String raiting, String avgFlow, String avgListen, String level, String avgProject, String about,
				   String photo, String active, String phone, String surname, String name, String avgStud, int id) {
		this.raiting = raiting;
		this.avgFlow = avgFlow;
		this.avgListen = avgListen;
		this.level = level;
		this.avgProject = avgProject;
		this.about = about;
		this.photo = photo;
		this.active = active;
		this.phone = phone;
		this.surname = surname;
		this.name = name;
		this.avgStud = avgStud;
		this.id = id;
	}

	public void setRaiting(String raiting){
		this.raiting = raiting;
	}

	public String getRaiting(){
		return raiting;
	}

	public void setAvgFlow(String avgFlow){
		this.avgFlow = avgFlow;
	}

	public String getAvgFlow(){
		return avgFlow;
	}

	public void setAvgListen(String avgListen){
		this.avgListen = avgListen;
	}

	public String getAvgListen(){
		return avgListen;
	}

	public void setLevel(String level){
		this.level = level;
	}

	public String getLevel(){
		return level;
	}

	public void setAvgProject(String avgProject){
		this.avgProject = avgProject;
	}

	public String getAvgProject(){
		return avgProject;
	}

	public void setAbout(String about){
		this.about = about;
	}

	public String getAbout(){
		return about;
	}

	public void setPhoto(String photo){
		this.photo = photo;
	}

	public String getPhoto(){
		return photo;
	}

	public void setActive(String active){
		this.active = active;
	}

	public String getActive(){
		return active;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setSurname(String surname){
		this.surname = surname;
	}

	public String getSurname(){
		return surname;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAvgStud(String avgStud){
		this.avgStud = avgStud;
	}

	public String getAvgStud(){
		return avgStud;
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
			"Teacher{" + 
			"raiting = '" + raiting + '\'' + 
			",avg_flow = '" + avgFlow + '\'' + 
			",avg_listen = '" + avgListen + '\'' + 
			",level = '" + level + '\'' + 
			",avg_project = '" + avgProject + '\'' + 
			",about = '" + about + '\'' + 
			",photo = '" + photo + '\'' + 
			",active = '" + active + '\'' + 
			",phone = '" + phone + '\'' + 
			",surname = '" + surname + '\'' + 
			",name = '" + name + '\'' + 
			",avg_stud = '" + avgStud + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}