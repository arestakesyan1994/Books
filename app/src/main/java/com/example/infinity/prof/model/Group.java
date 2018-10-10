package com.example.infinity.prof.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Group{

	@SerializedName("lsaran_id")
	private Object lsaranId;

	@SerializedName("module_id")
	private String moduleId;

	@SerializedName("color")
	private String color;

	@SerializedName("level")
	private Object level;

	@SerializedName("teacher_id")
	private String teacherId;

	@SerializedName("name")
	private String name;

	@SerializedName("active")
	private String active;

	@SerializedName("students")
	private List<StudentsItem> students;

	@SerializedName("id")
	private int id;

	@SerializedName("part_id")
	private String partId;

	public void setLsaranId(Object lsaranId){
		this.lsaranId = lsaranId;
	}

	public Object getLsaranId(){
		return lsaranId;
	}

	public void setModuleId(String moduleId){
		this.moduleId = moduleId;
	}

	public String getModuleId(){
		return moduleId;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setLevel(Object level){
		this.level = level;
	}

	public Object getLevel(){
		return level;
	}

	public void setTeacherId(String teacherId){
		this.teacherId = teacherId;
	}

	public String getTeacherId(){
		return teacherId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setActive(String active){
		this.active = active;
	}

	public String getActive(){
		return active;
	}

	public void setStudents(List<StudentsItem> students){
		this.students = students;
	}

	public List<StudentsItem> getStudents(){
		return students;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPartId(String partId){
		this.partId = partId;
	}

	public String getPartId(){
		return partId;
	}

	@Override
 	public String toString(){
		return 
			"Group{" + 
			"lsaran_id = '" + lsaranId + '\'' + 
			",module_id = '" + moduleId + '\'' + 
			",color = '" + color + '\'' + 
			",level = '" + level + '\'' + 
			",teacher_id = '" + teacherId + '\'' + 
			",name = '" + name + '\'' + 
			",active = '" + active + '\'' + 
			",students = '" + students + '\'' + 
			",id = '" + id + '\'' + 
			",part_id = '" + partId + '\'' + 
			"}";
		}
}