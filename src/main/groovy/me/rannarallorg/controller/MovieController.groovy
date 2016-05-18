package main.groovy.me.rannarallorg.controller

import main.groovy.me.rannarallorg.dao.MovieRepository
import main.groovy.me.rannarallorg.movie.Movie
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import javax.validation.Valid

@Controller
class MovieController {

    @Autowired
    MovieRepository movieRepository

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @RequestMapping(value = "/s", method = RequestMethod.GET)
    String getMovies(Map<String, Object> model,
                     @RequestParam(value = "id", required = false) String id) {

        logger.info("Request received")

        if (id != null) {
            Movie movie = movieRepository.findOne(id as Integer);

            if (movie == null) {
                logger.error("Movie with id ${id} was not found")
                return "error_view"
            }
            model.put("movie", movie);
        }

        model.put("movies", movieRepository.findAll())
        "movies"
    }

    @RequestMapping(value = "/s", method = RequestMethod.POST)
    String saveMovie(@RequestParam("action") String action,
                     @Valid @ModelAttribute("movie") Movie movie,
                     BindingResult bindingResult,
                     Map<String, Object> model) {

        logger.info("Posting movie")

        if (bindingResult.hasErrors()) {
            logger.error("Errors exist")
            model.put("movie", movie)
            return "movies"
        }

        if ("save".equals(action)) {
            movieRepository.save(movie)
        }

        model.put("movies", movieRepository.findAll())
        "redirect:/s"
    }
}
