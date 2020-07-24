package com.autumnli.security.resource.controller;

import com.autumnli.security.resource.domain.TbContent;
import com.autumnli.security.resource.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;

    @GetMapping("/")
    public List<TbContent> selectAll(){
        List<TbContent> tbContents = tbContentService.selectAll();
        return tbContents;
    }
}
