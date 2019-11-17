package fun.lain.mizuki.misuki.moudels.document.controller;


import fun.lain.mizuki.misuki.config.utils.Echo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/doc")
public class DocumentController {

        @RequestMapping("/upload")
        public Echo upload(@RequestBody DocumentUploadParam param){

                return Echo.success();
        }

}
