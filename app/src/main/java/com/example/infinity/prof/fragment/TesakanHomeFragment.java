package com.example.infinity.prof.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.infinity.prof.R;
import com.example.infinity.prof.constants.NavigationDrawerConstants;
import com.example.infinity.prof.handler.ResponseHandler;
import com.example.infinity.prof.model.Responses;
import com.example.infinity.prof.url.ApiService;
import com.example.infinity.prof.url.UtilsApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.infinity.prof.fragment.TesakanFragment.KEY;

public class TesakanHomeFragment extends Fragment {
    String[] harcs = new String[]{};
    ListView harcerList;
    ApiService mApiService;

    public TesakanHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(NavigationDrawerConstants.TAG_TESAKAN);
    }
//
//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tesakanHome = inflater.inflate(R.layout.fragment_tesakan_home, container, false);
        mApiService = UtilsApi.getAPIService();

        mApiService.theory().enqueue(new Callback<List<Responses>>() {
            @Override
            public void onResponse(Call<List<Responses>> call, Response<List<Responses>> response) {
                System.out.println("hghgghghg");
                System.out.println(response.body());
                String data = "";
                String harcer = "";
                Bundle bundle = getArguments();
                if (bundle != null) {
                    String myInt = bundle.getString("Key", KEY);
                    System.out.println(myInt);
                    for (int i = 0; i < response.body().size(); i++) {
                        String id = String.valueOf(response.body().get(i).getId());
                        String harc = response.body().get(i).getHarc();
                        String patasxan = response.body().get(i).getPatasxan();
                        String moduleId = response.body().get(i).getModuleId();
                        String author = response.body().get(i).getAuthor();

//                        String p1 = patasxan.replaceAll("<br>","\n");
//                        String p2 =p1.replaceAll("<span style=\\\"font-size: 14px;\\\">"," ");
//                        String p3=p2.replaceAll("<strong>","");
//                        String p4=p3.replaceAll("</strong>","");
//                        String p5=p4.replaceAll("</span>","");
//                        String p6=p5.replaceAll("<p>","");
//                        String p7=p6.replaceAll("</p>","");
//                        String p8=p7.replaceAll("<ol>","");
//                        String p9=p8.replaceAll("<li dir=\\\"ltr\\\">","\n *");
//                        String p10=p9.replaceAll("</li>","");
//                        String p11=p10.replaceAll("</ol>","");
//                        String p12=p11.replaceAll("<ul>","");
//                        String p13=p12.replaceAll("&nbsp;"," ");
//                        String p14=p13.replaceAll("</ul>","");
//                        String p15=p14.replaceAll("<span style=\\\"font-size: 14px;\\\">","");
//                        String p16=p15.replaceAll("<li>","\n *");
//                        String p17=p16.replaceAll("<p dir=\\\"ltr\\\">"," ");
//                        String p18=p17.replaceAll("<p data-empty=\\\"true\\\">","");
//                        String p19=p18.replaceAll("<ol start=\\\"3\\\">","\n");
//                        String p54=p19.replaceAll("<td style=\\\"width: 51.6026%;\\\" class=\\\"fr-thick\\\">","");
//                        String p30=p54.replaceAll("<td class=\\\"fr-thick\\\" style=\\\"width: 51.6026%;\\\">"," ");
//                        String p31=p30.replaceAll("<td style=\\\"width: 48.0769%;\\\" class=\\\"fr-thick\\\">","   ");
//                        String p20=p31.replaceAll("(0%)","");
//                        String p21=p20.replaceAll("<tbody>","");
//                        String p22=p21.replaceAll("<tr>","");
//                        String p23=p22.replaceAll("<td class=\\\"\\\">","");
//                        String p24=p23.replaceAll("</td>","  ");
//                        String p25=p24.replaceAll("<td>","  ");
//                        String p26=p25.replaceAll("</tr>","\n");
//                        String p27=p26.replaceAll("</tbody>","");
//                        String p28=p27.replaceAll("</table>","");
//                        String p29=p28.replaceAll("(4%)","");
//                        String p32=p29.replaceAll("<h4>","");
//                        String p33=p32.replaceAll("</h4>","");
//                        String p34=p33.replaceAll("<span style=\\\"color: rgb(226, 80, 65);\\\">","\n ");
//                        String p35=p34.replaceAll("&gt;",">");
//                        String p36=p35.replaceAll("<h3>","");
//                        String p37=p36.replaceAll("</h3>","");
//                        String p38=p37.replaceAll("<span style=\\\"color: rgb(65, 168, 95);\\\">","\n");
//                        String p39=p38.replaceAll("<a href=\\\"https://www.youtube.com/\\\">","");
//                        String p40=p39.replaceAll("<a href=\\\"http://prntscr.com/kv1nop\\\">"," ");
//                        String p41=p40.replaceAll("<a href=\\\"http://prntscr.com/kv1pl0\\\">"," ");
//                        String p42=p41.replaceAll("<p dir=\\\"ltr\\\" style=\\\"margin-left: 20px;\\\">","\n");
//                        String p43=p42.replaceAll("<p dir=\\\"ltr\\\" style=\\\"margin-left: 80px;\\\">","\n");
//                        String p44=p43.replaceAll("<p dir=\\\"ltr\\\" style=\\\"margin-left: 120px;\\\">","\n");
//                        String p45=p44.replaceAll("<p dir=\\\"ltr\\\" style=\\\"margin-left: 100px;\\\">","\n");
//                        String p46=p45.replaceAll("&lt;","<");
//                        String p47=p46.replaceAll("<p dir=\\\"ltr\\\" style=\\\"margin-left: 60px;\\\">","\n");
//                        String p48=p47.replaceAll("<a href=\\\"https://fonts.google.com/\\\">","");
//                        String p49=p48.replaceAll("<p dir=\\\"ltr\\\" style=\\\"margin-left: 40px;\\\">","\n");
//                        String p50=p49.replaceAll("<table style=\\\"margin-right: calc","");
//                        String p51=p50.replaceAll("<table style=\\\"margin-right: calc","");
//                        String p52=p51.replaceAll("; width: 96%;\\\" class=\\\"\\\">","\n");
//                        String p53=p52.replaceAll("; width: 10;\\\">","\n");
//                        String p55=p53.replaceAll("<img src=\\\"/img/theory/one_to_many.jpg\\\" data-name=\\\"Image 2018-01-11 at 15:01:34.jpg\\\" data-type=\\\"image\\\" data-id=\\\"2\\\" style=\\\"width: 300px;\\\" class=\\\"fr-fic fr-dib fr-fil fr-draggable\\\"></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">","");

                        if (moduleId.equals(myInt)) {
                            harcer +="  "+ Html.fromHtml("<h1>"+harc+"</>")+ "\n" + "\n"+" " + Html.fromHtml(patasxan) + "\n" + "\n" +" "+ author + "\n" + "о";
                        }
//                        data += "Node" + i + " : \n id= " + id + " \n Harc= " + harc + " \n Patasxan= " + Html.fromHtml(patasxan) + " \n Modul Id" + moduleId + "\n Author" + author + "\n";
                    }
                }
                String[] h = harcer.split("о");
                harcs = h;
                ArrayAdapter<CharSequence> harc = new ArrayAdapter<CharSequence>(tesakanHome.getContext(), R.layout.row_items, h);
                harcerList = (ListView) tesakanHome.findViewById(R.id.harcerList);
                harcerList.setAdapter(harc);
                System.out.println(harcs);
            }

            @Override
            public void onFailure(Call<List<Responses>> call, Throwable t) {

            }
        });


//        String json = "[ { \"id\": 3, \"harc\": \"Տվյալների ի՞նչ տիպեր կան JS -ում\", \"patasxan\": \"<p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">\u200B<strong>JavaScript ծրագրավորման լեզվում առկա են տվյալների հետևյալ հիմնական տիպերը.</strong></span><br></p><ol><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Number</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">String</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Boolean</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Undefined</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Null</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Object</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Array</span></p></li></ol>\",\"module_id\": \"1\", \"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"}," +
//                "{ \"id\": 4,\"harc\": \"Որո՞նք են տվյալների ձևափոխման մեթոդները JS -ում\",\"patasxan\": \"<ul><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Y Տողային տիպից անցում ամբողջ թվային տիպ &nbsp; x = parseInt(y)</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Y Տողային տիպից անցում իրական թվային տիպ &nbsp; x = parseFloat(y)</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Y Տողային տիպից անցում ընդհանուր թվային տիպ &nbsp; x = Number(y)</span></p></li><li dir=\\\"ltr\\\"><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Թվային տիպից անցում տողային տիպ &nbsp;x = y.toString(); կամ x = y + “”;</span></p></li></ul>\",\"module_id\": \"2\",\"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"}," +
//                "{\"id\": 5,\"harc\": \"Ի՞նչ իմաստ ունի Undefined -ը JS -ում\",\"patasxan\": \"<p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Undefined -ը արժեք չունեցող կամ չհայտարարված փոփոխականի տիպն է: Օրինակ</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">var &nbsp;x;</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">console.log(x) // կտպի Undefined</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">console.log(y); // կտպի error, քանի որ չկա y փոփոխական</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">console.log(typeof y) &nbsp;կտպի undefined </span></p>\",\"module_id\": \"2\",\"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"},{ \"id\": 6,\"harc\": \"Լոկալ և գլոբալ փոփոխականներ\", \"patasxan\": \"<p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Լոկալ փոփոխականը ֆունկցիայի ներսում հայտարարված փոփոխականն է: Գլոբալ փոփոխականը ֆունկցիայից դուրս հայտարարված փոփոխականն է, որը տեսանելի կարող է լիենլ այդ namespace -ի մյուս ֆունկցիաներին:</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">EcmaScript6 -ում գոյություն ունեն բլոկային և ոչ բլոկային փոփոխականներ, օրինակ՝&nbsp;</span><span style=\\\"font-size: 14px;\\\"><br></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>if( 5 &gt; 4){</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>&nbsp; &nbsp;var x = 4;<br>}</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">console.log(x) //կտպի 4</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">var-ով հայտարարված փոփոխականները տեսանելի են բլոկից դուրս:</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>if( 5 &gt; 4){</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>&nbsp; &nbsp;let x = 4;<br>}</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log(x)</strong> // error</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Let -ով հայտարարված փոփոխականները տեսանելի են միայն բլոկի ներսում:</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Let -ի և var -ի մեկ այլ տարբերություն է այն, որ var -ի օգնությամբ հնարավոր է հայտարարել նույն անունը ունեցող երկու փոփոխական;&nbsp;</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">օրինակ՝ var x = 4; var x = 8; let -ի դեպքում դա կհանգեցնի Error -ի :</span></p>\",\n" +
//                "        \"module_id\": \"2\",\"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"},{ \"id\": 7, \"harc\": \"Բացատրել instanceof օպերատորի նշանակությունը\", \"patasxan\": \"<p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">JS -ի օբյեկտ կողմնորոշված կառուցվածքում բոլոր կլասները, այդ թվում String, Array, ժառանգվում են գլխավոր Object կլասից: &nbsp;Ենթադրենք ունենք հետևյալ կոդը</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>var x = [ 4, &nbsp;5, &nbsp;6 ];</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>var y = { x: 4, y: 6};</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log(typeof x)</strong>; // Object</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log(typeof y);</strong> //Object</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Երկու դեպքում էլ ստանում ենք նույն արդյունքը, սակայն x փոփոխականն իրականում զանգված է: instanceof օպերատորն օգնում է կոնկրետացնել տիպը.</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log(x instanceof Array</strong>) //true</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log(x instanceof Object)</strong> //true</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log( y instanceof Object</strong>) //true</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log(y instanceof Array)</strong> //false =&gt; քանի որ y -ը զանգված չէ</span></p>\",\n" +
//                "        \"module_id\": \"2\",\"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"},{\"id\": 8,\"harc\": \"Բացատրել in օպերատորի նշանակությունը\",\"patasxan\": \"<p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">In օպերատորը կարող է կիրառվել երկու նպատակով:</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Առաջինը ցիկլերում:</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Ենթադրենք<strong> var obj = {name: “Armen”, surname: “Davtyan”};</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>for(var key in obj){</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>&nbsp; &nbsp; &nbsp;console.log(key);</strong> //կտպի name,surname</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>&nbsp; &nbsp; &nbsp;console.log(obj[key]) </strong>// կտպի Armen, Davtyan</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>}</strong></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Երկրորդ դեպքում կարող ենք ստուգել՝ արդյո՞ք տվյալ օբյեկտում կա համապատասխան դաշտը</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Օրինակ&nbsp;</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>console.log(“name” in obj) //true</strong></span></p><p dir=\\\"ltr\\\"><strong><span style=\\\"font-size: 14px;\\\">if(“age” in obj){</span></strong></p><p><strong><span style=\\\"font-size: 14px;\\\">console.log(obj.age)</span></strong></p><p><span style=\\\"font-size: 14px;\\\"><strong>}</strong></span></p>\",\n" +
//                "        \"module_id\": \"2\",\"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"},{ \"id\": 9,\"harc\": \"Բացատրել eval ֆունկցիան\", \"patasxan\": \"<p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Eval ֆունկցիան կարողանում է վերածել string -ը տրամաբանական արտահայտության և հաշվել դրա արժեքը:</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Օրինակ՝ &nbsp;</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>var y = eval(“4+5”); </strong>//9</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>eval(\\\"4+Math.sqrt(49)\\\")</strong> // 11</span></p>\",\n" +
//                "        \"module_id\": \"2\", \"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"},{\"id\": 10, \"harc\": \"Ի՞նչ է տերնար օպերատորը\",\n" +
//                "        \"patasxan\": \"<p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Տերնար օպերատորը պայմանական օպերատորի կարճ գրելաձևն է</span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>( պայման ) ? true : false</strong></span><span style=\\\"font-size: 14px;\\\"><br></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Օրինակ՝&nbsp;</span><span style=\\\"font-size: 14px;\\\"><br></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>If(a &gt; b){</strong></span></p><p dir=\\\"ltr\\\"><strong><span style=\\\"font-size: 14px;\\\">&nbsp; &nbsp; max =a</span></strong></p><p dir=\\\"ltr\\\"><strong><span style=\\\"font-size: 14px;\\\">}</span></strong></p><p dir=\\\"ltr\\\"><strong><span style=\\\"font-size: 14px;\\\">else{</span></strong></p><p dir=\\\"ltr\\\"><strong><span style=\\\"font-size: 14px;\\\">&nbsp; &nbsp;max = b;</span></strong></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>}</strong></span><span style=\\\"font-size: 14px;\\\"><br></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\">Կարճ գրելաձևը կլինի</span><span style=\\\"font-size: 14px;\\\"><br></span></p><p dir=\\\"ltr\\\"><span style=\\\"font-size: 14px;\\\"><strong>var max = (a &gt; b ) ? a : b</strong></span></p>\",\n" +
//                "        \"module_id\": \"2\",\"author\": \"Ուսումնական կենտրոնի ղեկավար, Արմեն Մարջինյան\"}]";
//
//
//        String data="";
//        String harcer = "";
//        Bundle bundle = this.getArguments();
//        if (bundle != null) {
//            String myInt = bundle.getString("Key", KEY);
//            System.out.println(myInt);
//            try {
//                JSONArray jsonRootObject = new JSONArray(json);
//
//                for (int i = 0; i < jsonRootObject.length(); i++) {
//                    JSONObject jsonObject = jsonRootObject.getJSONObject(i);
//
//                    int id = Integer.parseInt(jsonObject.optString("id"));
//                    String harc = jsonObject.optString("harc");
//                    String patasxan = jsonObject.optString("patasxan");
//                    String moduleId = jsonObject.optString("module_id");
//                    String author = jsonObject.optString("author");
//
//                    String p1 = patasxan.replaceAll("<br>", "\n");
//                    String p2 = p1.replaceAll("</li>", "");
//                    String p3 = p2.replaceAll("<p dir=\"ltr\">", "\n");
//                    String p4 = p3.replaceAll("<span style=\"font-size: 14px;\">\u200B", "");
//                    String p5 = p4.replaceAll("<strong>", " ");
//                    String p6 = p5.replaceAll("</strong>", " ");
//                    String p7 = p6.replaceAll("</span>", "");
//                    String p8 = p7.replaceAll("</p>", "");
//                    String p9 = p8.replaceAll("<ol>", "");
//                    String p10 = p9.replaceAll("<li dir=\"ltr\">", "");
//                    String p11 = p10.replaceAll("</ol>", "");
//                    String p12 = p11.replaceAll("<ul>", "");
//                    String p13 = p12.replaceAll("</ul>", "");
//                    String p14 = p13.replaceAll("<span style=\"font-size: 14px;\">", "");
//                    String p15 = p14.replaceAll("&nbsp;", "");
//                    String p16 = p15.replaceAll("&gt;", ">");
//                    if (moduleId.equals(myInt)) {
//                        harcer += harc+ "\n"+"\n" + p16 +"\n" + "\n" + author + "\n"+ "%";
//                    }
//                    data += "Node" + i + " : \n id= " + id + " \n Harc= " + harc + " \n Patasxan= " + p16 + " \n Modul Id" + moduleId + "\n Author" + author + "\n";
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            String[] h=harcer.split("%");
//            harcs=h;
//            ArrayAdapter<CharSequence> harc = new ArrayAdapter<CharSequence>(tesakanHome.getContext(), R.layout.row_items, h);
//            harcerList = (ListView) tesakanHome.findViewById(R.id.harcerList);
//            harcerList.setAdapter(harc);
//            System.out.println(harcs);
//        }
        return tesakanHome;
    }


}
