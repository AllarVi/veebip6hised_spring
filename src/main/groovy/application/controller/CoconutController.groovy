package main.groovy.application.controller

import main.groovy.application.coconut.Coconut
import main.groovy.application.coconut.Document
import main.groovy.application.dao.CoconutRepository
import main.groovy.application.dao.DocumentRepository
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
    public static final String VIEW_ERROR = "error_view"
    public static final String REDIRECT_COCONUTS = "redirect:/s"

    @Autowired
    CoconutRepository coconutRepository

    @Autowired
    DocumentRepository documentRepository

    private static final Logger logger = LoggerFactory.getLogger(CoconutController.class);

    @RequestMapping(value = "/s", method = RequestMethod.GET)
    String getAllCoconuts(Map<String, Object> model,
                          @RequestParam(value = "id", required = false) String id) {

        logger.info("getAllCoconuts() reached...")

        if (id != null) {
            Coconut coconut = coconutRepository.findOne(id as Integer);

            if (coconut == null) {
                logger.error("Kookost id-ga: ${id} ei leitud")
                return VIEW_ERROR
            }
            model.put("coconut", coconut);
        }

        model.put("coconuts", coconutRepository.findAll())

        model.put("document", new Document());

        ArrayList<Document> documents = documentRepository.findAll();
        model.put("documents", documents);

        for (Document document : documents) {
            logger.info("Document: " + document)
        }

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
        REDIRECT_COCONUTS
    }

    @RequestMapping(value = "/coconutservice/add", method = RequestMethod.POST)
    String addCoconut(@ModelAttribute("document") Document document) {
        logger.info("Document adding controller reached...")

        Document savedDocument = documentRepository.save(document);
        if (savedDocument != null) {
            return REDIRECT_COCONUTS;
        }

        return VIEW_ERROR;
    }
}
