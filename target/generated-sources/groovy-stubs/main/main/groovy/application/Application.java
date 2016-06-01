package main.groovy.application;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;

@org.springframework.boot.autoconfigure.SpringBootApplication() public class Application
  extends org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration  implements
    groovy.lang.GroovyObject {
;
public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.Object invokeMethod(java.lang.String method, java.lang.Object arguments) { return null;}
public  java.lang.Object getProperty(java.lang.String property) { return null;}
public  void setProperty(java.lang.String property, java.lang.Object value) { }
public static  void main(java.lang.String... args) { }
@org.springframework.context.annotation.Bean() public  org.springframework.boot.CommandLineRunner user(main.groovy.application.dao.DocumentRepository documentRepository, main.groovy.application.dao.DocTypeRepository docTypeRepository, main.groovy.application.dao.DocSubjectRepository docSubjectRepository, main.groovy.application.dao.DocSubjectTypeRepository docSubjectTypeRepository, main.groovy.application.dao.UserAccountRepository userAccountRepository, main.groovy.application.dao.UserTypeRepository userTypeRepository) { return (org.springframework.boot.CommandLineRunner)null;}
}
