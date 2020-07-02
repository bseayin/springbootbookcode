package com.xsz.dto;

import com.xsz.entity.Template;
import lombok.Data;

@Data
public class TemplateDTO extends Template {

    private String statusMsg;
    private String TypeMsg;


}
