package com.autumnli.security.resource.service.impl;

import com.autumnli.security.resource.domain.TbContent;
import com.autumnli.security.resource.mapper.TbContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.autumnli.security.resource.service.TbContentService;

import java.util.List;

@Service
public class TbContentServiceImpl implements TbContentService{

    @Autowired
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbContent> selectAll() {
        List<TbContent> tbContents = tbContentMapper.selectAll();
        return tbContents;
    }
}
