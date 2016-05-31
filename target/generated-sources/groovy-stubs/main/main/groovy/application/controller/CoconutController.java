package main.groovy.application.controller;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;

@org.springframework.stereotype.Controller() public class CoconutController
  extends java.lang.Object  implements
    groovy.lang.GroovyObject {
;
public static final java.lang.String ACTION_SAVE = "save";
public static final java.lang.String VIEW_COCONUTS = "coconuts";
public static final java.lang.String VIEW_ERROR = "error_view";
public static final java.lang.String REDIRECT_COCONUTS = "redirect:/s";
public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.Object invokeMethod(java.lang.String method, java.lang.Object arguments) { return null;}
public  java.lang.Object getProperty(java.lang.String property) { return null;}
public  void setProperty(java.lang.String property, java.lang.Object value) { }
public  main.groovy.application.dao.CoconutRepository getCoconutRepository() { return (main.groovy.application.dao.CoconutRepository)null;}
public  void setCoconutRepository(main.groovy.application.dao.CoconutRepository value) { }
public  main.groovy.application.dao.DocumentRepository getDocumentRepository() { return (main.groovy.application.dao.DocumentRepository)null;}
public  void setDocumentRepository(main.groovy.application.dao.DocumentRepository value) { }
@org.springframework.web.bind.annotation.RequestMapping(method=org.springframework.web.bind.annotation.RequestMethod.GET, value="/edit") public  java.lang.String getAllDocuments(java.util.Map<java.lang.String, java.lang.Object> model, @org.springframework.web.bind.annotation.RequestParam(value="id", required=false) java.lang.String id) { return (java.lang.String)null;}
@org.springframework.web.bind.annotation.RequestMapping(method=org.springframework.web.bind.annotation.RequestMethod.GET, value="/s") public  java.lang.String createNewDoc() { return (java.lang.String)null;}
@org.springframework.web.bind.annotation.RequestMapping(value="/delete") public  java.lang.String deleteDocument(@org.springframework.web.bind.annotation.RequestParam(value="id", required=false) java.lang.String id) { return (java.lang.String)null;}
@org.springframework.web.bind.annotation.RequestMapping(method=org.springframework.web.bind.annotation.RequestMethod.POST, value="/s") public  java.lang.String updateCoconuts(@org.springframework.web.bind.annotation.RequestParam(value="action") java.lang.String action, @javax.validation.Valid() @org.springframework.web.bind.annotation.ModelAttribute(value="model") main.groovy.application.model.Document document, org.springframework.validation.BindingResult bindingResult, java.util.Map<java.lang.String, java.lang.Object> model) { return (java.lang.String)null;}
@org.springframework.web.bind.annotation.RequestMapping(method=org.springframework.web.bind.annotation.RequestMethod.POST, value="/coconutservice/add") public  java.lang.String addCoconut(@org.springframework.web.bind.annotation.ModelAttribute(value="document") main.groovy.application.model.Document document) { return (java.lang.String)null;}
}
