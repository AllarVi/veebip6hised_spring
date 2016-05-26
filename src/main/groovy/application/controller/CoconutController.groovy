package main.groovy.application.controller

import main.groovy.application.coconut.Coconut
import main.groovy.application.dao.CoconutRepository
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
class CoconutController {

    public static final String ACTION_SAVE = "save"
    public static final String VIEW_COCONUTS = "coconuts"
    public static final String VIEW_EORROR = "error_view"

    @Autowired
    CoconutRepository coconutRepository

    private static final Logger logger = LoggerFactory.getLogger(CoconutController.class);

    @RequestMapping(value = "/s", method = RequestMethod.GET)
    String getAllCoconuts(Map<String, Object> model,
                          @RequestParam(value = "id", required = false) String id) {

        logger.info("getAllCoconuts() reached...")

        if (id != null) {
            Coconut coconut = coconutRepository.findOne(id as Integer);

            if (coconut == null) {
                logger.error("Kookost id-ga: ${id} ei leitud")
                return VIEW_EORROR
            }
            model.put("coconut", coconut);
        }

        model.put(VIEW_COCONUTS, coconutRepository.findAll())
        return VIEW_COCONUTS
    }

    @RequestMapping(value = "/s", method = RequestMethod.POST)
    String updateCoconuts(@RequestParam("action") String action,
                          @Valid @ModelAttribute("coconut") Coconut coconut,
                          BindingResult bindingResult,
                          Map<String, Object> model) {

        logger.info("Updating coconut...")

        if (bindingResult.hasErrors()) {
            logger.error("Errors!")
            model.put("coconut", coconut)
            return VIEW_COCONUTS
        }

        if (ACTION_SAVE.equals(action)) {
            coconutRepository.save(coconut)
        }

        model.put(VIEW_COCONUTS, coconutRepository.findAll())
        "redirect:/s"
    }
}
