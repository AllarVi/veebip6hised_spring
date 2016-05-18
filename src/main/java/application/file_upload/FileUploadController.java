package application.file_upload;

import application.Application;
import application.BaseController;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@RestController
public class FileUploadController extends BaseController {

    @RequestMapping(value = "/api/fileUpload", method = RequestMethod.GET)
    public String provideUploadInfo(Model model) {
//        File rootFolder = new File(Application.ROOT);
//        List<String> fileNames = Arrays.stream(rootFolder.listFiles()).map(f -> f.getName()).collect(Collectors
//                .toList());
//
//        model.addAttribute("files", Arrays.stream(rootFolder.listFiles()).sorted(Comparator.comparingLong(f -> -1 * f
//                .lastModified())).map(f -> f.getName()).collect(Collectors.toList()));

        return "uploadForm";
    }

    @RequestMapping(value = "/api/fileUpload", method = RequestMethod.POST)
    public String uploadImage(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {

        if (name.contains("/")) {
            return "Folder separators not allowed";
        }
        if (name.contains("/")) {
            return "Relative pathnames not allowed";
        }

        if (!file.isEmpty()) {
            try {
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(Application.ROOT
                        + "/" + name)));
                FileCopyUtils.copy(file.getInputStream(), stream);
                stream.close();
                return "You successfully uploaded " + name + "!";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was " +
                    "empty";
        }
    }

}
