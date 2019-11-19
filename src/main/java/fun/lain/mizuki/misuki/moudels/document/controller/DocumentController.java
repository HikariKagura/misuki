package fun.lain.mizuki.misuki.moudels.document.controller;


import fun.lain.mizuki.misuki.config.utils.Echo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doc")
public class DocumentController {

        @RequestMapping("/upload")
        public Echo upload(DocumentUploadParam param){

                return Echo.success();
        }

}
