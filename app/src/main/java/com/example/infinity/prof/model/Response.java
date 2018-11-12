package com.example.infinity.prof.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response {

	@SerializedName("date")
	@Expose
	private String date;

	@SerializedName("reason")
	@Expose
	private String reason;

	@SerializedName("game")
	@Expose
	private String game;

	@SerializedName("grafik")
	@Expose
	private List<GrafikItem> grafik;

	@SerializedName("show_phone")
	@Expose
	private String showPhone;

	@SerializedName("examen_access")
	@Expose
	private String examenAccess;

	@SerializedName("description")
	@Expose
	private String description;

	@SerializedName("type")
	@Expose
	private Object type;

	@SerializedName("login")
	@Expose
	private String login;

	@SerializedName("is_playing_game")
	@Expose
	private String isPlayingGame;

	@SerializedName("score")
	@Expose
	private String score;

	@SerializedName("gumar")
	@Expose
	private Object gumar;

	@SerializedName("password")
	@Expose
	private String password;

	@SerializedName("paymanagri_skizb")
	@Expose
	private String paymanagriSkizb;

	@SerializedName("avg")
	@Expose
	private String avg;

	@SerializedName("teacher")
	@Expose
	private Teacher teacher;

	@SerializedName("lesson_rate")
	@Expose
	private String lessonRate;

	@SerializedName("surname")
	@Expose
	private String surname;

	@SerializedName("kurs")
	@Expose
	private Object kurs;

	@SerializedName("id")
	@Expose
	private int id;

	@SerializedName("email")
	@Expose
	private String email;

	@SerializedName("group")
	@Expose
	private Group group;

	@SerializedName("code_task_level")
	@Expose
	private String codeTaskLevel;

	@SerializedName("prefers")
	@Expose
	private String prefers;

	@SerializedName("current_payment")
	@Expose
	private String currentPayment;

	@SerializedName("sex")
	@Expose
	private String sex;

	@SerializedName("photo")
	@Expose
	private String photo;

	@SerializedName("code_level")
	@Expose
	private String codeLevel;

	@SerializedName("artificial_rate")
	@Expose
	private String artificialRate;

	@SerializedName("game_activity")
	@Expose
	private String gameActivity;

	@SerializedName("modules")
	@Expose
	private List<ModulesItem> modules;

	@SerializedName("level_name")
	@Expose
	private String levelName;

	@SerializedName("zexch")
	@Expose
	private Object zexch;

	@SerializedName("group_id")
	@Expose
	private String groupId;

	@SerializedName("release_date")
	@Expose
	private Object releaseDate;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("online")
	@Expose
	private String online;

	@SerializedName("phone_number")
	@Expose
	private String phoneNumber;

	@SerializedName("paymanagri_avart")
	@Expose
	private String paymanagriAvart;

	@SerializedName("show_tests")
	@Expose
	private String showTests;

	@SerializedName("notifications")
	@Expose
	private List<NotificationsItem> notifications;

	@SerializedName("status")
	@Expose
	private String status;

	public Response() {
	}

	public Response(String date, String reason, String game, List<GrafikItem> grafik, String showPhone, String examenAccess,
                    String description, Object type, String login, String isPlayingGame, String score,
                    Object gumar, String password, String paymanagriSkizb, String avg, Teacher teacher, String lessonRate,
                    String surname, Object kurs, int id, String email, Group group, String codeTaskLevel,
                    String prefers, String currentPayment, String sex, String photo, String codeLevel, String artificialRate,
                    String gameActivity, List<ModulesItem> modules, String levelName, Object zexch, String groupId,
                    Object releaseDate, String name, String online, String phoneNumber, String paymanagriAvart,
                    String showTests, List<NotificationsItem> notifications, String status) {
		this.date = date;
		this.reason = reason;
		this.game = game;
		this.grafik = grafik;
		this.showPhone = showPhone;
		this.examenAccess = examenAccess;
		this.description = description;
		this.type = type;
		this.login = login;
		this.isPlayingGame = isPlayingGame;
		this.score = score;
		this.gumar = gumar;
		this.password = password;
		this.paymanagriSkizb = paymanagriSkizb;
		this.avg = avg;
		this.teacher = teacher;
		this.lessonRate = lessonRate;
		this.surname = surname;
		this.kurs = kurs;
		this.id = id;
		this.email = email;
		this.group = group;
		this.codeTaskLevel = codeTaskLevel;
		this.prefers = prefers;
		this.currentPayment = currentPayment;
		this.sex = sex;
		this.photo = photo;
		this.codeLevel = codeLevel;
		this.artificialRate = artificialRate;
		this.gameActivity = gameActivity;
		this.modules = modules;
		this.levelName = levelName;
		this.zexch = zexch;
		this.groupId = groupId;
		this.releaseDate = releaseDate;
		this.name = name;
		this.online = online;
		this.phoneNumber = phoneNumber;
		this.paymanagriAvart = paymanagriAvart;
		this.showTests = showTests;
		this.notifications = notifications;
		this.status = status;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setReason(String reason){
		this.reason = reason;
	}

	public String getReason(){
		return reason;
	}

	public void setGame(String game){
		this.game = game;
	}

	public String getGame(){
		return game;
	}

	public void setGrafik(List<GrafikItem> grafik){
		this.grafik = grafik;
	}

	public List<GrafikItem> getGrafik(){
		return grafik;
	}

	public void setShowPhone(String showPhone){
		this.showPhone = showPhone;
	}

	public String getShowPhone(){
		return showPhone;
	}

	public void setExamenAccess(String examenAccess){
		this.examenAccess = examenAccess;
	}

	public String getExamenAccess(){
		return examenAccess;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setType(Object type){
		this.type = type;
	}

	public Object getType(){
		return type;
	}

	public void setLogin(String login){
		this.login = login;
	}

	public String getLogin(){
		return login;
	}

	public void setIsPlayingGame(String isPlayingGame){
		this.isPlayingGame = isPlayingGame;
	}

	public String getIsPlayingGame(){
		return isPlayingGame;
	}

	public void setScore(String score){
		this.score = score;
	}

	public String getScore(){
		return score;
	}

	public void setGumar(Object gumar){
		this.gumar = gumar;
	}

	public Object getGumar(){
		return gumar;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setPaymanagriSkizb(String paymanagriSkizb){
		this.paymanagriSkizb = paymanagriSkizb;
	}

	public String getPaymanagriSkizb(){
		return paymanagriSkizb;
	}

	public void setAvg(String avg){
		this.avg = avg;
	}

	public String getAvg(){
		return avg;
	}

	public void setTeacher(Teacher teacher){
		this.teacher = teacher;
	}

	public Teacher getTeacher(){
		return teacher;
	}

	public void setLessonRate(String lessonRate){
		this.lessonRate = lessonRate;
	}

	public String getLessonRate(){
		return lessonRate;
	}

	public void setSurname(String surname){
		this.surname = surname;
	}

	public String getSurname(){
		return surname;
	}

	public void setKurs(Object kurs){
		this.kurs = kurs;
	}

	public Object getKurs(){
		return kurs;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setGroup(Group group){
		this.group = group;
	}

	public Group getGroup(){
		return group;
	}

	public void setCodeTaskLevel(String codeTaskLevel){
		this.codeTaskLevel = codeTaskLevel;
	}

	public String getCodeTaskLevel(){
		return codeTaskLevel;
	}

	public void setPrefers(String prefers){
		this.prefers = prefers;
	}

	public String getPrefers(){
		return prefers;
	}

	public void setCurrentPayment(String currentPayment){
		this.currentPayment = currentPayment;
	}

	public String getCurrentPayment(){
		return currentPayment;
	}

	public void setSex(String sex){
		this.sex = sex;
	}

	public String getSex(){
		return sex;
	}

	public void setPhoto(String photo){
		this.photo = photo;
	}

	public String getPhoto(){
		return photo;
	}

	public void setCodeLevel(String codeLevel){
		this.codeLevel = codeLevel;
	}

	public String getCodeLevel(){
		return codeLevel;
	}

	public void setArtificialRate(String artificialRate){
		this.artificialRate = artificialRate;
	}

	public String getArtificialRate(){
		return artificialRate;
	}

	public void setGameActivity(String gameActivity){
		this.gameActivity = gameActivity;
	}

	public String getGameActivity(){
		return gameActivity;
	}

	public void setModules(List<ModulesItem> modules){
		this.modules = modules;
	}

	public List<ModulesItem> getModules(){
		return modules;
	}

	public void setLevelName(String levelName){
		this.levelName = levelName;
	}

	public String getLevelName(){
		return levelName;
	}

	public void setZexch(Object zexch){
		this.zexch = zexch;
	}

	public Object getZexch(){
		return zexch;
	}

	public void setGroupId(String groupId){
		this.groupId = groupId;
	}

	public String getGroupId(){
		return groupId;
	}

	public void setReleaseDate(Object releaseDate){
		this.releaseDate = releaseDate;
	}

	public Object getReleaseDate(){
		return releaseDate;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setOnline(String online){
		this.online = online;
	}

	public String getOnline(){
		return online;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setPaymanagriAvart(String paymanagriAvart){
		this.paymanagriAvart = paymanagriAvart;
	}

	public String getPaymanagriAvart(){
		return paymanagriAvart;
	}

	public void setShowTests(String showTests){
		this.showTests = showTests;
	}

	public String getShowTests(){
		return showTests;
	}

	public void setNotifications(List<NotificationsItem> notifications){
		this.notifications = notifications;
	}

	public List<NotificationsItem> getNotifications(){
		return notifications;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"date = '" + date + '\'' + 
			",reason = '" + reason + '\'' + 
			",game = '" + game + '\'' + 
			",grafik = '" + grafik + '\'' + 
			",show_phone = '" + showPhone + '\'' + 
			",examen_access = '" + examenAccess + '\'' + 
			",description = '" + description + '\'' + 
			",type = '" + type + '\'' + 
			",login = '" + login + '\'' + 
			",is_playing_game = '" + isPlayingGame + '\'' + 
			",score = '" + score + '\'' + 
			",gumar = '" + gumar + '\'' + 
			",password = '" + password + '\'' + 
			",paymanagri_skizb = '" + paymanagriSkizb + '\'' + 
			",avg = '" + avg + '\'' + 
			",teacher = '" + teacher + '\'' + 
			",lesson_rate = '" + lessonRate + '\'' + 
			",surname = '" + surname + '\'' + 
			",kurs = '" + kurs + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",group = '" + group + '\'' + 
			",code_task_level = '" + codeTaskLevel + '\'' + 
			",prefers = '" + prefers + '\'' + 
			",current_payment = '" + currentPayment + '\'' + 
			",sex = '" + sex + '\'' + 
			",photo = '" + photo + '\'' + 
			",code_level = '" + codeLevel + '\'' + 
			",artificial_rate = '" + artificialRate + '\'' + 
			",game_activity = '" + gameActivity + '\'' + 
			",modules = '" + modules + '\'' + 
			",level_name = '" + levelName + '\'' + 
			",zexch = '" + zexch + '\'' + 
			",group_id = '" + groupId + '\'' + 
			",release_date = '" + releaseDate + '\'' + 
			",name = '" + name + '\'' + 
			",online = '" + online + '\'' + 
			",phone_number = '" + phoneNumber + '\'' + 
			",paymanagri_avart = '" + paymanagriAvart + '\'' + 
			",show_tests = '" + showTests + '\'' + 
			",notifications = '" + notifications + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}