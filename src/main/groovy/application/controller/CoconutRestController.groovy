package main.groovy.application.controller

import main.groovy.application.dao.CoconutRepository
import main.groovy.application.dao.DocTypeRepository
import main.groovy.application.dao.DocSubjectRepository
import main.groovy.application.dao.DocSubjectTypeRepository
import main.groovy.application.model.Coconut
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CoconutRestController {

    @Autowired
    CoconutRepository coconutRepository

    @Autowired
    DocTypeRepository docTypeRepository

    @Autowired
    DocSubjectRepository docSubjectRepository

    @Autowired
    DocSubjectTypeRepository docSubjectTypeRepository

    private static final Logger logger = LoggerFactory.getLogger(CoconutController.class);

    @RequestMapping(value = "/coconutservice", method = RequestMethod.GET)
    Coconut getCoconut(@RequestParam("id") String id) {
        return coconutRepository.findOne(id as Integer)
    }

    @RequestMapping(value = "/documentservice/doctype", method = RequestMethod.GET)
    ResponseEntity<Object> getDocTypes() {
        return new ResponseEntity<>(docTypeRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/documentservice/docsubject", method = RequestMethod.GET)
    ResponseEntity<Object> getDocSubjects() {
        return new ResponseEntity<>(docSubjectRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/documentservice/docsubjecttype", method = RequestMethod.GET)
    ResponseEntity<Object> getDocSubjectTypes() {
        return new ResponseEntity<>(docSubjectTypeRepository.findAll(), HttpStatus.OK);
    }

}
