package main.groovy.application.dao;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;

public interface CoconutRepository
  extends
    org.springframework.data.jpa.repository.JpaRepository<main.groovy.application.coconut.Coconut, java.lang.Integer> {
;
}
