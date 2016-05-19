package main.groovy.application.controller

import com.fasterxml.jackson.databind.ObjectMapper
import main.groovy.application.dao.CoconutRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CoconutRestController {

    @Autowired
    CoconutRepository coconutRepository

    @Autowired
    ObjectMapper objectMapper

    @RequestMapping(value = "/coconutservice", method = RequestMethod.GET, produces = "application/json")
    String getCoconut(@RequestParam("id") String id) {
        return objectMapper.writeValueAsString(coconutRepository.findOne(id as Integer))
    }
}
