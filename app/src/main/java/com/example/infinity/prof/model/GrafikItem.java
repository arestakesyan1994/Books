package com.example.infinity.prof.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class GrafikItem{

	@SerializedName("group_id")
	@Expose
	private String groupId;

	@SerializedName("teacher_id")
	@Expose
	private String teacherId;

	@SerializedName("start")
	@Expose
	private String start;

	@SerializedName("active")
	@Expose
	private Object active;

	@SerializedName("end")
	@Expose
	private String end;

	@SerializedName("id")
	@Expose
	private int id;

	@SerializedName("day_id")
	@Expose
	private String dayId;

	@SerializedName("day")
	@Expose
	private String day;

	public GrafikItem() {
	}

	public GrafikItem(String groupId, String teacherId, String start,
					  Object active, String end, int id, String dayId, String day) {
		this.groupId = groupId;
		this.teacherId = teacherId;
		this.start = start;
		this.active = active;
		this.end = end;
		this.id = id;
		this.dayId = dayId;
		this.day = day;
	}

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