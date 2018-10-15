package com.example.infinity.prof.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Group{

	@SerializedName("lsaran_id")
	@Expose
	private Object lsaranId;

	@SerializedName("module_id")
	@Expose
	private String moduleId;

	@SerializedName("color")
	@Expose
	private String color;

	@SerializedName("level")
	@Expose
	private Object level;

	@SerializedName("teacher_id")
	@Expose
	private String teacherId;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("active")
	@Expose
	private String active;

	@SerializedName("students")
	@Expose
	private List<StudentsItem> students;

	@SerializedName("id")
	@Expose
	private int id;

	@SerializedName("part_id")
	@Expose
	private String partId;

	public Group() {
	}

	public Group(Object lsaranId, String moduleId, String color, Object level, String teacherId, String name,
				 String active, List<StudentsItem> students, int id, String partId) {
		this.lsaranId = lsaranId;
		this.moduleId = moduleId;
		this.color = color;
		this.level = level;
		this.teacherId = teacherId;
		this.name = name;
		this.active = active;
		this.students = students;
		this.id = id;
		this.partId = partId;
	}

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