package main.groovy.me.rannarallorg.controller

import com.fasterxml.jackson.databind.ObjectMapper
import main.groovy.me.rannarallorg.dao.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MovieServiceController {

    @Autowired
    MovieRepository movieRepository

    @Autowired
    ObjectMapper objectMapper

    @RequestMapping(value = "/movieservice", method = RequestMethod.GET, produces = "application/json")
    String getMovieJson(@RequestParam("id") String id) {
        return objectMapper.writeValueAsString(movieRepository.findOne(id as Integer))
    }
}
