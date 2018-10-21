package com.example.infinity.prof.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class StItem {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("surname")
    @Expose
    private String surname;

    @SerializedName("paymanagri_avart")
    @Expose
    private String paymanagriAvart;

    @SerializedName("group_id")
    @Expose
    private String groupId;

    @SerializedName("zexch")
    @Expose
    private String zexch;

    @SerializedName("gumar")
    @Expose
    private String gumar;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("paymanagri_skizb")
    @Expose
    private String paymanagriSkizb;

    @SerializedName("reason")
    @Expose
    private String reason;

    @SerializedName("kurs")
    @Expose
    private String kurs;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("avg")
    @Expose
    private String avg;

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("photo")
    @Expose
    private String photo;

    @SerializedName("show_phone")
    @Expose
    private String showPhone;

    @SerializedName("prefers")
    @Expose
    private String prefers;

    @SerializedName("current_payment")
    @Expose
    private String currentPayment;

    @SerializedName("online")
    @Expose
    private String online;

    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    @SerializedName("artificial_rate")
    @Expose
    private String artificialRate;

    @SerializedName("lesson_rate")
    @Expose
    private String lessonRate;

    @SerializedName("code_level")
    @Expose
    private String codeLevel;

    @SerializedName("code_task_level")
    @Expose
    private String codeTaskLevel;

    @SerializedName("level_name")
    @Expose
    private String levelName;

    @SerializedName("score")
    @Expose
    private String score;

    @SerializedName("show_tests")
    @Expose
    private String showTests;

    @SerializedName("game")
    @Expose
    private String game;

    @SerializedName("examen_access")
    @Expose
    private String examenAccess;

    @SerializedName("sex")
    @Expose
    private String sex;

    @SerializedName("game_activity")
    @Expose
    private String gameActivity;

    @SerializedName("is_playing_game")
    @Expose
    private String isPlayingGame;

    @SerializedName("notifications")
    @Expose
    private List<NotificationsItem> notifications;

    @SerializedName("grafik")
    @Expose
    private List<GrafikItem> grafik;

    @SerializedName("group")
    @Expose
    private List<Group> group;

    @SerializedName("teacher")
    @Expose
    private Teacher teacher;

    @SerializedName("modules")
    @Expose
    private List<ModulesItem> modules;

    public StItem() {
    }

    public StItem(int id, String name, String surname, String paymanagriAvart,
                  String groupId, String zexch, String gumar, String status, String email,
                  String phoneNumber, String date, String description, String paymanagriSkizb,
                  String reason, String kurs, String type, String avg, String login,
                  String password, String photo, String showPhone, String prefers,
                  String currentPayment, String online, String releaseDate,
                  String artificialRate, String lessonRate, String codeLevel,
                  String codeTaskLevel, String levelName, String score, String showTests,
                  String game, String examenAccess, String sex, String gameActivity,
                  String isPlayingGame, List<NotificationsItem> notifications, List<GrafikItem> grafik,
                  List<Group> group, Teacher teacher, List<ModulesItem> modules) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.paymanagriAvart = paymanagriAvart;
        this.groupId = groupId;
        this.zexch = zexch;
        this.gumar = gumar;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.description = description;
        this.paymanagriSkizb = paymanagriSkizb;
        this.reason = reason;
        this.kurs = kurs;
        this.type = type;
        this.avg = avg;
        this.login = login;
        this.password = password;
        this.photo = photo;
        this.showPhone = showPhone;
        this.prefers = prefers;
        this.currentPayment = currentPayment;
        this.online = online;
        this.releaseDate = releaseDate;
        this.artificialRate = artificialRate;
        this.lessonRate = lessonRate;
        this.codeLevel = codeLevel;
        this.codeTaskLevel = codeTaskLevel;
        this.levelName = levelName;
        this.score = score;
        this.showTests = showTests;
        this.game = game;
        this.examenAccess = examenAccess;
        this.sex = sex;
        this.gameActivity = gameActivity;
        this.isPlayingGame = isPlayingGame;
        this.notifications = notifications;
        this.grafik = grafik;
        this.group = group;
        this.teacher = teacher;
        this.modules = modules;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPaymanagriAvart() {
        return paymanagriAvart;
    }

    public void setPaymanagriAvart(String paymanagriAvart) {
        this.paymanagriAvart = paymanagriAvart;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getZexch() {
        return zexch;
    }

    public void setZexch(String zexch) {
        this.zexch = zexch;
    }

    public String getGumar() {
        return gumar;
    }

    public void setGumar(String gumar) {
        this.gumar = gumar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymanagriSkizb() {
        return paymanagriSkizb;
    }

    public void setPaymanagriSkizb(String paymanagriSkizb) {
        this.paymanagriSkizb = paymanagriSkizb;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getKurs() {
        return kurs;
    }

    public void setKurs(String kurs) {
        this.kurs = kurs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getShowPhone() {
        return showPhone;
    }

    public void setShowPhone(String showPhone) {
        this.showPhone = showPhone;
    }

    public String getPrefers() {
        return prefers;
    }

    public void setPrefers(String prefers) {
        this.prefers = prefers;
    }

    public String getCurrentPayment() {
        return currentPayment;
    }

    public void setCurrentPayment(String currentPayment) {
        this.currentPayment = currentPayment;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getArtificialRate() {
        return artificialRate;
    }

    public void setArtificialRate(String artificialRate) {
        this.artificialRate = artificialRate;
    }

    public String getLessonRate() {
        return lessonRate;
    }

    public void setLessonRate(String lessonRate) {
        this.lessonRate = lessonRate;
    }

    public String getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(String codeLevel) {
        this.codeLevel = codeLevel;
    }

    public String getCodeTaskLevel() {
        return codeTaskLevel;
    }

    public void setCodeTaskLevel(String codeTaskLevel) {
        this.codeTaskLevel = codeTaskLevel;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getShowTests() {
        return showTests;
    }

    public void setShowTests(String showTests) {
        this.showTests = showTests;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getExamenAccess() {
        return examenAccess;
    }

    public void setExamenAccess(String examenAccess) {
        this.examenAccess = examenAccess;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGameActivity() {
        return gameActivity;
    }

    public void setGameActivity(String gameActivity) {
        this.gameActivity = gameActivity;
    }

    public String getIsPlayingGame() {
        return isPlayingGame;
    }

    public void setIsPlayingGame(String isPlayingGame) {
        this.isPlayingGame = isPlayingGame;
    }

    public List<NotificationsItem> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationsItem> notifications) {
        this.notifications = notifications;
    }

    public List<GrafikItem> getGrafik() {
        return grafik;
    }

    public void setGrafik(List<GrafikItem> grafik) {
        this.grafik = grafik;
    }

    public List<Group> getGroup() {
        return group;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<ModulesItem> getModules() {
        return modules;
    }

    public void setModules(List<ModulesItem> modules) {
        this.modules = modules;
    }

}
