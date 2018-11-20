//package com.example.infinity.prof.fragment;
//
//import android.app.Fragment;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.example.infinity.prof.R;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class DetailsFragment extends Fragment {
//    TextView name,location;
//    TextView textJson;
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.details_info, container, false);
//        name = (TextView)view.findViewById(R.id.Name);
//        location = (TextView)view.findViewById(R.id.Location);
//
//        textJson = (TextView)  view.findViewById(R.id.textJson);
//
//        String json = "[{\"id\": 3, \"harc\": \"Տվյալների ի՞նչ տիպեր կան JS -ում\", \"patasxan\": \"<p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">\u200B<strong>JavaScript ծրագրավորման լեզվում առկա են տվյալների հետևյալ հիմնական տիպերը.</strong></span><br></p><ol><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Number</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">String</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Boolean</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Undefined</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Null</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Object</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Array</span></p></li></ol>\",\"module_id\": \"2\", \"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"}," +
//                "{\"id\": 4,\"harc\": \"Որո՞նք են տվյալների ձևափոխման մեթոդները JS -ում\",\"patasxan\": \"<ul><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Y Տողային տիպից անցում ամբողջ թվային տիպ &nbsp; x = parseInt(y)</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Y Տողային տիպից անցում իրական թվային տիպ &nbsp; x = parseFloat(y)</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Y Տողային տիպից անցում ընդհանուր թվային տիպ &nbsp; x = Number(y)</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Թվային տիպից անցում տողային տիպ &nbsp;x = y.toString(); կամ x = y + “”;</span></p></li></ul>\",\"module_id\": \"2\",\"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"}," +
//                "{\"id\": 5,\"harc\": \"Ի՞նչ իմաստ ունի Undefined -ը JS -ում\",\"patasxan\": \"<p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Undefined -ը արժեք չունեցող կամ չհայտարարված փոփոխականի տիպն է: Օրինակ</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">var &nbsp;x;</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">console.log(x) // կտպի Undefined</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">console.log(y); // կտպի error, քանի որ չկա y փոփոխական</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">console.log(typeof y) &nbsp;կտպի undefined </span></p>\",\n\"module_id\": \"2\",\"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"}," +
//                "{\"id\": 6,\"harc\": \"Լոկալ և գլոբալ փոփոխականներ\", \"patasxan\": \"<p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Լոկալ փոփոխականը ֆունկցիայի ներսում հայտարարված փոփոխականն է: Գլոբալ փոփոխականը ֆունկցիայից դուրս հայտարարված փոփոխականն է, որը տեսանելի կարող է լիենլ այդ namespace -ի մյուս ֆունկցիաներին:</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">EcmaScript6 -ում գոյություն ունեն բլոկային և ոչ բլոկային փոփոխականներ, օրինակ՝&nbsp;</span><span style=\\\"font-size: 14px;\\\"><br></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>if( 5 &gt; 4){</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>&nbsp; &nbsp;var x = 4;<br>}</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">console.log(x) //կտպի 4</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">var-ով հայտարարված փոփոխականները տեսանելի են բլոկից դուրս:</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>if( 5 &gt; 4){</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>&nbsp; &nbsp;let x = 4;<br>}</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log(x)</strong> // error</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Let -ով հայտարարված փոփոխականները տեսանելի են միայն բլոկի ներսում:</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Let -ի և var -ի մեկ այլ տարբերություն է այն, որ var -ի օգնությամբ հնարավոր է հայտարարել նույն անունը ունեցող երկու փոփոխական;&nbsp;</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">օրինակ՝ var x = 4; var x = 8; let -ի դեպքում դա կհանգեցնի Error -ի :</span></p>\",\n\"module_id\": \"2\",\"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"}," +
//                "{\"id\": 7,\"harc\": \"Բացատրել instanceof օպերատորի նշանակությունը\", \"patasxan\": \"<p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">JS -ի օբյեկտ կողմնորոշված կառուցվածքում բոլոր կլասները, այդ թվում String, Array, ժառանգվում են գլխավոր Object կլասից: &nbsp;Ենթադրենք ունենք հետևյալ կոդը</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>var x = [ 4, &nbsp;5, &nbsp;6 ];</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>var y = { x: 4, y: 6};</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log(typeof x)</strong>; // Object</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log(typeof y);</strong> //Object</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Երկու դեպքում էլ ստանում ենք նույն արդյունքը, սակայն x փոփոխականն իրականում զանգված է: instanceof օպերատորն օգնում է կոնկրետացնել տիպը.</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log(x instanceof Array</strong>) //true</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log(x instanceof Object)</strong> //true</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log( y instanceof Object</strong>) //true</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log(y instanceof Array)</strong> //false =&gt; քանի որ y -ը զանգված չէ</span></p>\",\n\"module_id\": \"2\",\"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"}," +
//                "{\"id\": 8,\"harc\": \"Բացատրել in օպերատորի նշանակությունը\",\"patasxan\": \"<p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">In օպերատորը կարող է կիրառվել երկու նպատակով:</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Առաջինը ցիկլերում:</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Ենթադրենք<strong> var obj = {name: “Armen”, surname: “Davtyan”};</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>for(var key in obj){</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>&nbsp; &nbsp; &nbsp;console.log(key);</strong> //կտպի name,surname</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>&nbsp; &nbsp; &nbsp;console.log(obj[key]) </strong>// կտպի Armen, Davtyan</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>}</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Երկրորդ դեպքում կարող ենք ստուգել՝ արդյո՞ք տվյալ օբյեկտում կա համապատասխան դաշտը</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Օրինակ&nbsp;</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log(“name” in obj) //true</strong></span></p><p dir=\\\"ltr\\\"><strong><span style=\\\"font-size: 14px;\\\">if(“age” in obj){</span></strong></p><p><strong><span style=\\\"font-size: 14px;\\\">console.log(obj.age)</span></strong></p><p><span style=\\\"font-size: 14px;\\\"><strong>}</strong></span></p>\",\n\"module_id\": \"2\",\"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"}," +
//                "{\"id\": 9,\"harc\": \"Բացատրել eval ֆունկցիան\", \"patasxan\": \"<p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Eval ֆունկցիան կարողանում է վերածել string -ը տրամաբանական արտահայտության և հաշվել դրա արժեքը:</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Օրինակ՝ &nbsp;</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>var y = eval(“4+5”); </strong>//9</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>eval(\\\"4+Math.sqrt(49)\\\")</strong> // 11</span></p>\",\n\"module_id\": \"2\", \"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"}," +
//                "{\"id\": 10,\"harc\": \"Ի՞նչ է տերնար օպերատորը\",\n\"patasxan\": \"<p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Տերնար օպերատորը պայմանական օպերատորի կարճ գրելաձևն է</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>( պայման ) ? true : false</strong></span><span style=\\\"font-size: 14px;\\\"><br></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Օրինակ՝&nbsp;</span><span style=\\\"font-size: 14px;\\\"><br></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>If(a &gt; b){</strong></span></p><p dir=\\\"ltr\\\"><strong><span style=\\\"font-size: 14px;\\\">&nbsp; &nbsp; max =a</span></strong></p><p dir=\\\"ltr\\\"><strong><span style=\\\"font-size: 14px;\\\">}</span></strong></p><p dir=\\\"ltr\\\"><strong><span style=\\\"font-size: 14px;\\\">else{</span></strong></p><p dir=\\\"ltr\\\"><strong><span style=\\\"font-size: 14px;\\\">&nbsp; &nbsp;max = b;</span></strong></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>}</strong></span><span style=\\\"font-size: 14px;\\\"><br></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Կարճ գրելաձևը կլինի</span><span style=\\\"font-size: 14px;\\\"><br></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>var max = (a &gt; b ) ? a : b</strong></span></p>\",\n\"module_id\": \"2\",\"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"}]";
//
//
//        String data = "";
//        try {
//            JSONArray jsonRootObject = new JSONArray(json);
//
//            for(int i=0; i < jsonRootObject.length(); i++) {
//                JSONObject jsonObject = jsonRootObject.getJSONObject(i);
//
//                int id = Integer.parseInt(jsonObject.optString("id"));
//                String harc = jsonObject.optString("harc");
//                String patasxan = jsonObject.optString("patasxan");
//                String moduleId = jsonObject.optString("module_id");
//                String author = jsonObject.optString("author");
//
//                String p1 =patasxan.replaceAll("<br>","\n");
//                String p2 =p1.replaceAll("</li>","");
//                String p3 =p2.replaceAll("<p dir=\"ltr\">","\n");
//                String p4 =p3.replaceAll("<span style=\"font-size: 14px;\">\u200B","");
//                String p5 =p4.replaceAll("<strong>"," ");
//                String p6 =p5.replaceAll("</strong>"," ");
//                String p7 =p6.replaceAll("</span>","");
//                String p8 =p7.replaceAll("</p>","");
//                String p9 =p8.replaceAll("<ol>","");
//                String p10 =p9.replaceAll("<li dir=\"ltr\">","");
//                String p11 =p10.replaceAll("</ol>","");
//                String p12 =p11.replaceAll("<ul>","");
//                String p13 =p12.replaceAll("</ul>","");
//                String p14 =p13.replaceAll("<span style=\"font-size: 14px;\">","");
//                String p15 =p14.replaceAll("&nbsp;","");
//                String p16 =p15.replaceAll("&gt;",">");
//
//                    data += "Node" + i + " : \n id= " + id + " \n Harc= " + harc + " \n Patasxan= " + p16 + " \n Modul Id" + moduleId + "\n Author" + author + "\n";
//            }
//        } catch (JSONException e) {e.printStackTrace();}
//        System.out.println(data);
//        textJson.setText(data);
//        System.out.println();
//        return view;
//    }
//    public void change(String uname, String ulocation){
//        name.setText(uname);
//        location.setText(ulocation);
//    }
//}