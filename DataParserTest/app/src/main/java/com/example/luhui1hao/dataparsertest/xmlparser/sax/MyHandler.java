package com.example.luhui1hao.dataparsertest.xmlparser.sax;

import android.util.Log;

import com.example.luhui1hao.dataparsertest.bean.Person;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luhui on 2016/7/26.
 */
public class MyHandler extends DefaultHandler {

    private Person person = new Person();
    private List<Person> persons = new ArrayList<>();
    private String currentTag;
    private String currentValue;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        Log.i("SAX", "startDocument()");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        Log.i("SAX", "endDocument()");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        Log.i("SAX", "startElement()");
        Log.i("SAX", "localName=" + localName);
        Log.i("SAX", "qName=" + qName);
        currentTag = localName;
        Log.i("SAX", "currentTag="+currentTag);
        if (localName.equals("person")) {
            person = new Person();
            for (int i = 0; i < attributes.getLength(); i++) {
                if (attributes.getLocalName(i).equals("id")) {
                    person.setId(Integer.parseInt(attributes.getValue(i)));
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        Log.i("SAX", "endElement()");
        if(localName.equals("person")){
            persons.add(person);
            person = null;
        }
        currentTag = "";//这里千万不能为null;大坑啊
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        Log.i("SAX", "characters()");
        currentValue = new String(ch, start, length);
        if(currentValue != null && !currentValue.equals("") && !currentValue.equals("\n")){
            if(currentTag.equals("name")){
                person.setName(currentValue);
            }else if(currentTag.equals("age")){
                person.setAge(Integer.parseInt(currentValue));
            }else if(currentTag.equals("number")){
                person.setNumber(Integer.parseInt(currentValue));
            }else if(currentTag.equals("position")){
                person.setPosition(currentValue);
            }
        }
        currentValue = "";//这里千万不能为null;大坑啊
    }

    public List<Person> getPersons() {
        return persons;
    }
}
