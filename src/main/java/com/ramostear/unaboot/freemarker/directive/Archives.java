package com.ramostear.unaboot.freemarker.directive;

import com.ramostear.unaboot.common.exception.UnaBootException;
import com.ramostear.unaboot.domain.valueobject.ArchiveVo;
import com.ramostear.unaboot.freemarker.AbstractUnaBootDirectiveModel;
import com.ramostear.unaboot.freemarker.DirectiveHandler;
import com.ramostear.unaboot.service.ArchiveService;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName Archives
 * @Description 文章归档指令
 * @Author 树下魅狐
 * @Date 2020/1/16 0016 22:06
 * @Version since UnaBoot-1.0
 **/
@Slf4j
@Service
public class Archives extends AbstractUnaBootDirectiveModel {

    @Autowired
    private ArchiveService archiveService;

    @Override
    public void execute(DirectiveHandler handler) throws UnaBootException, TemplateException, IOException {
        List<ArchiveVo> data = archiveService.archives();
        handler.put(MULTI,data).render();
    }
}
