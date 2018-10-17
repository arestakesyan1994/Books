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
//
//    public static String toJSon() {
//        StudentsItem studentsItem = null;
//        GrafikItem grafikItem;
//        Group group;
//        try {
//
//            // Here we convert Java Object to JSON
//            JSONObject jsonObj = new JSONObject();
//            // Set the first name/pair
//            jsonObj.put("name", studentsItem.getName());
//            jsonObj.put("surname", studentsItem.getSurname());
//            jsonObj.put("id", studentsItem.getId());
//            jsonObj.put("photo", studentsItem.getPhoto());
//            jsonObj.put("phone_number", studentsItem.getPhoneNumber());
//            jsonObj.put("date", studentsItem.getDate());
//            jsonObj.put("reason", studentsItem.getReason());
//            jsonObj.put("status", studentsItem.getStatus());
//            jsonObj.put("game", studentsItem.getGame());
//            jsonObj.put("show_phone", studentsItem.getShowPhone());
//            jsonObj.put("examen_access", studentsItem.getExamenAccess());
//            jsonObj.put("description", studentsItem.getDescription());
//            jsonObj.put("type",studentsItem.getType());
//            jsonObj.put("login", studentsItem.getLogin());
//            jsonObj.put("is_playing_game", studentsItem.getIsPlayingGame());
//            jsonObj.put("score", studentsItem.getScore());
//            jsonObj.put("gumar",studentsItem.getGumar());
//            jsonObj.put("password", studentsItem.getPassword());
//            jsonObj.put("paymanagri_skizb", studentsItem.getPaymanagriSkizb());
//            jsonObj.put("avg", studentsItem.getAvg());
//            jsonObj.put("lesson_rate", studentsItem.getLessonRate());
//            jsonObj.put("kurs",studentsItem.getKurs());
//            jsonObj.put("email", studentsItem.getEmail());
//            jsonObj.put("code_task_level", studentsItem.getCodeTaskLevel());
//            jsonObj.put("prefers", studentsItem.getPrefers());
//            jsonObj.put("current_payment", studentsItem.getCurrentPayment());
//            jsonObj.put("sex", studentsItem.getSex());
//            jsonObj.put("code_level", studentsItem.getCodeLevel());
//            jsonObj.put("artificial_rate", studentsItem.getArtificialRate());
//            jsonObj.put("game_activity", studentsItem.getGameActivity());
//            jsonObj.put("level_name", studentsItem.getLevelName());
//            jsonObj.put("zexch", studentsItem.getZexch());
//            jsonObj.put("group_id",studentsItem.getGroupId());
//            jsonObj.put("release_date", studentsItem.getReleaseDate());
//            jsonObj.put("online", studentsItem.getOnline());
//            jsonObj.put("paymanagri_avart", studentsItem.getOnline());
//            jsonObj.put("show_tests", studentsItem.getShowTests());
//
//
//            JSONArray jsonArr1 = new JSONArray();
//            for (GrafikItem pn : studentsItem ) {
//
//
//            }
////            JSONObject pnObj = new JSONObject();
////            pnObj.put("num", pn.getNumber());
////            pnObj.put("type", pn.getType());
////            jsonArr.put(pnObj);
////        }
//
//
//
//            // we need another object to store the address
////        JSONObject jsonAdd = new JSONObject();
////        jsonAdd.put("address", person.getAddress().getAddress());
////        jsonAdd.put("city", person.getAddress().getCity());
////        jsonAdd.put("state", person.getAddress().getState());
////
////        // We add the object to the main object
////        jsonObj.put("address", jsonAdd);
////
////        // and finally we add the phone number
////        // In this case we need a json array to hold the java list
////        JSONArray jsonArr = new JSONArray();
////
////        for (PhoneNumber pn : person.getPhoneList() ) {
////            JSONObject pnObj = new JSONObject();
////            pnObj.put("num", pn.getNumber());
////            pnObj.put("type", pn.getType());
////            jsonArr.put(pnObj);
////        }
//
////        jsonObj.put("phoneNumber", jsonArr);
//
//            return jsonObj.toString();
//
//        } catch (JSONException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//
//    }
//}