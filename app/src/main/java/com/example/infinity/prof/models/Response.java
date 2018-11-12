package com.example.infinity.prof.models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@SerializedName("module_id")
	private String moduleId;

	@SerializedName("author")
	private String author;

	@SerializedName("harc")
	private String harc;

	@SerializedName("id")
	private int id;

	@SerializedName("patasxan")
	private String patasxan;

	public void setModuleId(String moduleId){
		this.moduleId = moduleId;
	}

	public String getModuleId(){
		return moduleId;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setHarc(String harc){
		this.harc = harc;
	}

	public String getHarc(){
		return harc;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPatasxan(String patasxan){
		this.patasxan = patasxan;
	}

	public String getPatasxan(){
		return patasxan;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"module_id = '" + moduleId + '\'' + 
			",author = '" + author + '\'' + 
			",harc = '" + harc + '\'' + 
			",id = '" + id + '\'' + 
			",patasxan = '" + patasxan + '\'' + 
			"}";
		}
}