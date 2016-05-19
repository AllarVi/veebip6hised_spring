package main.groovy.application.controller;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;

@org.springframework.web.bind.annotation.RestController() public class CoconutRestController
  extends java.lang.Object  implements
    groovy.lang.GroovyObject {
;
public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.Object invokeMethod(java.lang.String method, java.lang.Object arguments) { return null;}
public  java.lang.Object getProperty(java.lang.String property) { return null;}
public  void setProperty(java.lang.String property, java.lang.Object value) { }
public  main.groovy.application.dao.CoconutRepository getCoconutRepository() { return (main.groovy.application.dao.CoconutRepository)null;}
public  void setCoconutRepository(main.groovy.application.dao.CoconutRepository value) { }
public  com.fasterxml.jackson.databind.ObjectMapper getObjectMapper() { return (com.fasterxml.jackson.databind.ObjectMapper)null;}
public  void setObjectMapper(com.fasterxml.jackson.databind.ObjectMapper value) { }
@org.springframework.web.bind.annotation.RequestMapping(method=org.springframework.web.bind.annotation.RequestMethod.GET, produces="application/json", value="/coconutservice") public  java.lang.String getCoconut(@org.springframework.web.bind.annotation.RequestParam(value="id") java.lang.String id) { return (java.lang.String)null;}
}
