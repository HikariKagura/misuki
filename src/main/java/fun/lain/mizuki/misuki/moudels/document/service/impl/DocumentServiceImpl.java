package fun.lain.mizuki.misuki.moudels.document.service.impl;

import fun.lain.mizuki.misuki.moudels.document.controller.DocumentUploadParam;
import fun.lain.mizuki.misuki.moudels.document.dao.DocumentDao;
import fun.lain.mizuki.misuki.moudels.document.entity.DocumentInfo;
import fun.lain.mizuki.misuki.moudels.document.service.DocumentService;

import javax.annotation.Resource;

public class DocumentServiceImpl implements DocumentService {

    @Resource
    DocumentDao documentDao;

    public boolean create(DocumentUploadParam param){
        DocumentInfo info = DocumentInfo.builder().article(param.getArticle()).type(param.getType()).length(param.getLength()).title(param.getTitle()).tags(param.getTags()).author(param.getAuthor()).introduce(param.getIntroduce()).build();
        int row = documentDao.insert(info);
        return row==1;
    }

}
