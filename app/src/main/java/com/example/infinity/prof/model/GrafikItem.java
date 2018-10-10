package com.example.infinity.prof.model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class GrafikItem{

	@SerializedName("group_id")
	private String groupId;

	@SerializedName("teacher_id")
	private String teacherId;

	@SerializedName("start")
	private String start;

	@SerializedName("active")
	private Object active;

	@SerializedName("end")
	private String end;

	@SerializedName("id")
	private int id;

	@SerializedName("day_id")
	private String dayId;

	@SerializedName("day")
	private String day;

	public void setGroupId(String groupId){
		this.groupId = groupId;
	}

	public String getGroupId(){
		return groupId;
	}

	public void setTeacherId(String teacherId){
		this.teacherId = teacherId;
	}

	public String getTeacherId(){
		return teacherId;
	}

	public void setStart(String start){
		this.start = start;
	}

	public String getStart(){
		return start;
	}

	public void setActive(Object active){
		this.active = active;
	}

	public Object getActive(){
		return active;
	}

	public void setEnd(String end){
		this.end = end;
	}

	public String getEnd(){
		return end;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setDayId(String dayId){
		this.dayId = dayId;
	}

	public String getDayId(){
		return dayId;
	}

	public void setDay(String day){
		this.day = day;
	}

	public String getDay(){
		return day;
	}

	@Override
 	public String toString(){
		return 
			"GrafikItem{" + 
			"group_id = '" + groupId + '\'' + 
			",teacher_id = '" + teacherId + '\'' + 
			",start = '" + start + '\'' + 
			",active = '" + active + '\'' + 
			",end = '" + end + '\'' + 
			",id = '" + id + '\'' + 
			",day_id = '" + dayId + '\'' + 
			",day = '" + day + '\'' + 
			"}";
		}
}