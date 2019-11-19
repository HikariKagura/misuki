package fun.lain.mizuki.misuki.moudels.document.controller;

import lombok.Data;

import java.io.File;
@Data
public class DocumentUploadParam {
    private String title;
    private String tags;
    private String author;
    private String introduce;
    private String article;
    private File[] cover;
    private File[] files;
    private String length;
    private String type;

}
