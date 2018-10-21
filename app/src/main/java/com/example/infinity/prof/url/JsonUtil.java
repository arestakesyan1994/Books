//package com.example.infinity.prof.url;
//
//import com.example.infinity.prof.model.GrafikItem;
//import com.example.infinity.prof.model.Group;
//import com.example.infinity.prof.model.StudentsItem;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class JsonUtil {
//    StudentsItem studentsItem =new StudentsItem();
//
//    public void toJSon() {
//
//        JSONObject json = new JSONObject();
//    }
//}
//    String id = mainObject.getString("id");
//                                String name = mainObject.getString("name");
////                                String surname = mainObject.getString("surname");
////                                String paymanagriAvart = mainObject.getString("paymanagri_avart");
////                                String groupId = mainObject.getString("group_id");
////                                String zexch = mainObject.getString("zexch");
////                                String gumar = mainObject.getString("gumar");
////                                String status = mainObject.getString("status");
////                                String email = mainObject.getString("email");
////                                String phoneNumber = mainObject.getString("phone_number");
////                                String date = mainObject.getString("date");
////                                String description = mainObject.getString("description");
////                                String paymanagriSkizb = mainObject.getString("paymanagri_skizb");
////                                String reason = mainObject.getString("reason");
////                                String kurs = mainObject.getString("kurs");
////                                String type = mainObject.getString("type");
////                                String avg = mainObject.getString("avg");
////                                String login = mainObject.getString("login");
////                                String password = mainObject.getString("password");
////                                String photo = mainObject.getString("photo");
////                                String showPhone = mainObject.getString("show_phone");
////                                String prefers = mainObject.getString("prefers");
////                                String currentPayment = mainObject.getString("current_payment");
////                                String online = mainObject.getString("online");
////                                String releaseDate = mainObject.getString("release_date");
////                                String artificialRate = mainObject.getString("artificial_rate");
////                                String lessonRate = mainObject.getString("lesson_rate");
////                                String codeLevel = mainObject.getString("code_level");
////                                String codeTaskLevel = mainObject.getString("code_task_level");
////                                String levelName = mainObject.getString("level_name");
////                                String score = mainObject.getString("score");
////                                String showTests = mainObject.getString("show_tests");
////                                String game = mainObject.getString("game");
////                                String examenAccess = mainObject.getString("examen_access");
////                                String sex = mainObject.getString("sex");
////                                String gameActivity = mainObject.getString("game_activity");
////                                String isPlayingGame = mainObject.getString("is_playing_game");
//////                                JSONObject jsonAPI = mainObject.getJSONObject("jsonapi");
////
////                                JSONArray notifications = (JSONArray) mainObject.get("notifications");
////
////                                for (int i = 0; i < notifications.length(); i++) {
////
////                                    JSONObject childObject = notifications.getJSONObject(i);
////                                    String notId = childObject.getString("id");
////                                    String notStudentId = childObject.getString("student_id");
////                                    String notText = childObject.getString("text");
////                                    String notStatus = childObject.getString("status");
////                                    String notWhen = childObject.getString("when");
////
////                                }
////
////                                JSONArray grafik = (JSONArray) mainObject.get("grafik");
////
////                                for (int i = 0; i < grafik.length(); i++) {
////
////                                    JSONObject childObject = grafik.getJSONObject(i);
////                                    String grId = childObject.getString("id");
////                                    String grGroupId = childObject.getString("group_id");
////                                    String grDayId = childObject.getString("day_id");
////                                    String grStatus = childObject.getString("status");
////                                    String grEnd = childObject.getString("end");
////                                    String grTeacherId = childObject.getString("teacher_id");
////                                    String grActive = childObject.getString("active");
////                                    String grDay = childObject.getString("day");
////
////                                }
////
////                                JSONObject group = mainObject.getJSONObject("group");
////                                String groupIdG = group.getString("id");
////                                String groupName = group.getString("name");
////                                String groupPartId = group.getString("part_id");
////                                String groupTeacherId = group.getString("teacher_id");
////                                String groupColor = group.getString("color");
////                                String groupLsaran_id = group.getString("lsaran_id");
////                                String groupLevel = group.getString("level");
////                                String groupActive= group.getString("active");
////                                String groupModuleId = group.getString("module_id");
////
////                                JSONArray students = (JSONArray) mainObject.get("students");
////
////                                for (int i = 0; i < students.length(); i++) {
////
////                                    JSONObject childObject = notifications.getJSONObject(i);
////                                    String idStudents = childObject.getString("id");
////                                    String nameStudents = childObject.getString("name");
////                                    String surnameStudents = childObject.getString("surname");
////                                    String paymanagriAvartStudents = childObject.getString("paymanagri_avart");
////                                    String groupIdStudents = childObject.getString("group_id");
////                                    String zexchStudents = childObject.getString("zexch");
////                                    String gumarStudents = childObject.getString("gumar");
////                                    String statusStudents = childObject.getString("status");
////                                    String emailStudents = childObject.getString("email");
////                                    String phoneNumberStudents = childObject.getString("phone_number");
////                                    String dateStudents = childObject.getString("date");
////                                    String descriptionStudents = childObject.getString("description");
////                                    String paymanagriSkizbStudents = childObject.getString("paymanagri_skizb");
////                                    String reasonStudents = childObject.getString("reason");
////                                    String kursStudents = childObject.getString("kurs");
////                                    String typeStudents = childObject.getString("type");
////                                    String avgStudents = childObject.getString("avg");
////                                    String loginStudents = childObject.getString("login");
////                                    String passwordStudents = childObject.getString("password");
////                                    String photoStudents = childObject.getString("photo");
////                                    String showPhoneStudents = childObject.getString("show_phone");
////                                    String prefersStudents = childObject.getString("prefers");
////                                    String currentPaymentStudents = childObject.getString("current_payment");
////                                    String onlineStudents = childObject.getString("online");
////                                    String releaseDateStudents = childObject.getString("release_date");
////                                    String artificialRateStudents = childObject.getString("artificial_rate");
////                                    String lessonRateStudents = childObject.getString("lesson_rate");
////                                    String codeLevelStudents = childObject.getString("code_level");
////                                    String codeTaskLevelStudents = childObject.getString("code_task_level");
////                                    String levelNameStudents = childObject.getString("level_name");
////                                    String scoreStudents = childObject.getString("score");
////                                    String showTestsStudents = childObject.getString("show_tests");
////                                    String gameStudents = childObject.getString("game");
////                                    String examenAccessStudents = childObject.getString("examen_access");
////                                    String sexStudents = childObject.getString("sex");
////                                    String gameActivityStudents = childObject.getString("game_activity");
////                                    String isPlayingGameStudents = childObject.getString("is_playing_game");
////
////                                }
////
////                                JSONObject teacher = mainObject.getJSONObject("teacher");
////                                String teacherId = group.getString("id");
////                                String teacherName = group.getString("name");
////                                String teacherSurname = group.getString("surname");
////                                String teacherPhone = group.getString("phone");
////                                String teacherPhoto = group.getString("photo");
////                                String teacherAbout = group.getString("about");
////                                String teacherRaiting = group.getString("raiting");
////                                String teacherAvgStud= group.getString("avg_stud");
////                                String teacherAvgListen= group.getString("avg_listen");
////                                String teacherAvgProject= group.getString("avg_project");
////                                String teacherAvgFlow= group.getString("avg_flow");
////                                String teacherLevel = group.getString("level");
////                                String teacherActive = group.getString("active");
////
////                                JSONArray modules = (JSONArray) mainObject.get("modules");
////
////                                for (int i = 0; i < modules.length(); i++) {
////
////                                    JSONObject childObject = notifications.getJSONObject(i);
////                                    String modId = childObject.getString("id");
////                                    String modName = childObject.getString("name");
////                                    String modKurs = childObject.getString("kurs");
////                                    String modLessonsCount = childObject.getString("lessons_count");
////                                    String modAbout = childObject.getString("about");
////
////                                }
//