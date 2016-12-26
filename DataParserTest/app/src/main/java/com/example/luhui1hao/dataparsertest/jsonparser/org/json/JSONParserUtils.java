package com.example.luhui1hao.dataparsertest.jsonparser.org.json;

import com.example.luhui1hao.dataparsertest.bean.Person;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 自带的JSON用到的主要类有
 * JSONObject:  Json对象，可以完成Json字符串与Java对象的相互转换(对顺序没要求的情况下)
 * JSONArray:   Json数组，可以完成Json字符串与Java集合或对象的相互转换
 * JSONStringer:Json文本构建类，这个类可以帮助快速和便捷的创建JSON文本，每个JSONStringer实体只能对应创建一个JSON文本
 * JSONTokener: Json解析类
 * JSONException:Json异常
 * <p>
 * JSONObject可以干JSONStringer和JSONTokener的事情。。。。。
 * <p>
 * 该类耦合度高，需要根据具体数据格式具体分析来写!!!
 */

public class JSONParserUtils {

    /**
     * 解析简单的JSON数组
     *
     * @param json
     */
    public static List<Person> parseEasyJson(String json) {
        //创建集合
        List<Person> persons = new ArrayList<>();
        try {
            //创建JSONArray
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                //根据i获取JSONObject
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                //根据JSONObject创建Person对象
                Person person = new Person();
                person.setId(jsonObject.getInt("id"));
                person.setName(jsonObject.getString("name"));
                person.setAge(jsonObject.getInt("age"));
                person.setNumber(jsonObject.getInt("number"));
                person.setPosition(jsonObject.getString("position"));
                //将Person对象加入集合
                persons.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return persons;
    }

    /**
     * 传入输入流解析JSON
     * @param is
     * @return
     * @throws IOException
     */
    public static List<Person> parseEasyJsonWithIs(InputStream is) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(is);
        int num = 0;
        StringBuilder sb = new StringBuilder();
        byte[] arr = new byte[1024];
        while((num = bis.read(arr)) != -1){
            sb.append(new String(arr, 0, num));
        }

        return parseEasyJson(sb.toString());
    }

    /**
     * 利用JSONTokener来解析
     * @return
     */
    public static List<Person> parseJSONWithTokener(InputStream is) throws IOException, JSONException {
        BufferedInputStream bis = new BufferedInputStream(is);
        int num = 0;
        StringBuilder sb = new StringBuilder();
        byte[] arr = new byte[1024];
        while((num = bis.read(arr)) != -1){
            sb.append(new String(arr, 0, num));
        }

        JSONTokener jsonTokener = new JSONTokener(sb.toString());
        JSONArray jsonArray = (JSONArray) jsonTokener.nextValue();
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            Person person = new Person();
            person.setId(jsonObject.getInt("id"));
            person.setName(jsonObject.getString("name"));
            person.setAge(jsonObject.getInt("age"));
            person.setNumber(jsonObject.getInt("number"));
            person.setPosition(jsonObject.getString("position"));
            persons.add(person);
        }

        return persons;
    }

    public static String generateEasyJson() {
        JSONArray jsonArray = new JSONArray();

        try {

            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("id", 1);
            jsonObject1.put("name", "LeBron James");
            jsonObject1.put("age", 31);
            jsonObject1.put("number", 23);
            jsonObject1.put("position", "Small Forward");
            jsonArray.put(jsonObject1);

            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("id", 2);
            jsonObject2.put("name", "Kyrie Irving");
            jsonObject2.put("age", 24);
            jsonObject2.put("number", 2);
            jsonObject2.put("position", "Point Guard");
            jsonArray.put(jsonObject2);

            JSONObject jsonObject3 = new JSONObject();
            jsonObject3.put("id", 3);
            jsonObject3.put("name", "Kevin Love");
            jsonObject3.put("age", 27);
            jsonObject3.put("number", 0);
            jsonObject3.put("position", "Power Forward");
            jsonArray.put(jsonObject3);

            JSONObject jsonObject4 = new JSONObject();
            jsonObject4.put("id", 4);
            jsonObject4.put("name", "J.R.Smith");
            jsonObject4.put("age", 30);
            jsonObject4.put("number", 5);
            jsonObject4.put("position", "Shooting Guard");
            jsonArray.put(jsonObject4);

            JSONObject jsonObject5 = new JSONObject();
            jsonObject5.put("id", 5);
            jsonObject5.put("name", "Tristan Thompson");
            jsonObject5.put("age", 25);
            jsonObject5.put("number", 13);
            jsonObject5.put("position", "Center");
            jsonArray.put(jsonObject5);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonArray.toString();
    }


}
