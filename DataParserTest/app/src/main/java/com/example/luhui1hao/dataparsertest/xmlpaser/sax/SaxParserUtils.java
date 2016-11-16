package com.example.luhui1hao.dataparsertest.xmlpaser.sax;

import android.util.Log;

import com.example.luhui1hao.dataparsertest.bean.Person;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by luhui on 2016/7/28.
 */
public class SaxParserUtils {
    //输入InputStream返回实体类列表
    public static List<Person> parseXmlBySax(InputStream inputStream)
            throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        //使用XMLReader的方式
//        XMLReader xmlReader = parser.getXMLReader();
//        MyHandler myHandler = new MyHandler();
//        xmlReader.setContentHandler(myHandler);
//        xmlReader.parse(new InputSource(inputStream));

        //直接使用SAXParser的方式
        MyHandler myHandler = new MyHandler();
        parser.parse(inputStream, myHandler);

        Log.i("SAX", "qqqqqqq");
        return myHandler.getPersons();
    }
}
