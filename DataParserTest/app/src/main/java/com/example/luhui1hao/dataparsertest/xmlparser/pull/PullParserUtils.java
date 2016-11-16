package com.example.luhui1hao.dataparsertest.xmlparser.pull;


import android.util.Xml;

import com.example.luhui1hao.dataparsertest.bean.Person;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Android系统中和Pull方式相关的包为org.xmlpull.v1，
 * 在这个包中提供了Pull解析器的工厂类XmlPullParserFactory和Pull解析器XmlPullParser，
 * XmlPullParserFactory实例调用newPullParser方法创建XmlPullParser解析器实例，
 * 接着XmlPullParser实例就可以调用getEventType()和next()等方法依次主动提取事件，
 * 并根据提取的事件类型进行相应的逻辑处理。
 */
public class PullParserUtils {
    //返回一个保存着实体类的List集合
    public static List<Person> parseXmlByPull(InputStream inputStream) throws XmlPullParserException, IOException {
        List<Person> persons = new ArrayList<>();
        Person person = new Person();

        //1.创建XmlPullParserFactory解析工厂
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        //2.通过XmlPullParserFactory工厂类实例化一个XmlPullParser解析类
        XmlPullParser parser = factory.newPullParser();
        //3.根据制定的编码格式来解析xml文档
        parser.setInput(inputStream, "utf-8");

        //得到当前的事件类型
        int eventType = parser.getEventType();
        //只要没有解析到xml的文档结束，就一直解析
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                //解析到文档开始的时候
                case XmlPullParser.START_DOCUMENT:{
                    //做一些初始化操作
                    break;
                }
                //解析到xml标签的时候
                case XmlPullParser.START_TAG: {
                    if (parser.getName().equals("person")) {
                        person = new Person();
                        //得到person元素的第一个属性，也就是ID
                        person.setId(Integer.parseInt(parser.getAttributeValue(0)));
                    } else if (parser.getName().equals("name")) {
                        person.setName(parser.nextText());
                    } else if (parser.getName().equals("age")) {
                        person.setAge(Integer.parseInt(parser.nextText()));
                    } else if (parser.getName().equals("number")) {
                        person.setNumber(Integer.parseInt(parser.nextText()));
                    } else if (parser.getName().equals("position")) {
                        person.setPosition(parser.nextText());
                    }
                    break;
                }
                case XmlPullParser.END_TAG: {
                    if (parser.getName().equals("person")) {
                        persons.add(person);
                        person = null;
                    }
                    break;
                }
                case XmlPullParser.END_DOCUMENT: {
                    //做一些收尾工作
                    break;
                }
            }

            //通过next()方法触发下一个事件
            eventType = parser.next();
        }

        return persons;
    }

    /**
     * 使用PULL方式生成XML文件
     * @param list
     * @param os
     * @throws IOException
     */
    public static void generateXMLByPull(List<Person> list, OutputStream os) throws IOException {
        //1.创建XmlSerializer(XML序列化类)的实例
        XmlSerializer serializer = Xml.newSerializer();
        //2.为XmlSerializer设置输出流与编码格式
        serializer.setOutput(os, "UTF-8");
        //3.为XmlSerializer设置XML的编码格式
        serializer.startDocument("UTF-8", true);
        //4.设置根元素
        serializer.startTag(null, "persons");
        //5.遍历集合，一次写入标签与属性
        for (Person temp : list) {
            serializer.startTag(null, "person");
            serializer.attribute(null, "id", temp.getId() + "");

            serializer.startTag(null, "name");
            serializer.text(temp.getName());
            serializer.endTag(null, "name");

            serializer.startTag(null, "age");
            serializer.text(temp.getAge()+"");
            serializer.endTag(null, "age");

            serializer.startTag(null, "number");
            serializer.text(temp.getNumber()+"");
            serializer.endTag(null, "number");

            serializer.startTag(null, "position");
            serializer.text(temp.getPosition());
            serializer.endTag(null, "position");

            serializer.endTag(null, "person");
        }
        //6.设置根完结元素
        serializer.endTag(null, "persons");
        //7.结束文档编写
        serializer.endDocument();
        //8.调用flush()将内存中的数据写入文件中，关闭输出流
        os.flush();
        os.close();
    }
}
