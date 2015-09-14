package com.best.btr.wanma.bas.action;

import com.best.btr.wanma.bas.entity.Project;
import com.best.btr.wanma.bas.service.ProjectService;
import com.best.btr.wanma.bas.so.ProjectSO;
import com.jinhe.tss.framework.persistence.pagequery.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Created by Hsian on 15/9/11.
 */
@Controller("ProjectAction")
@RequestMapping("/project")
public class ProjectAction {

    @Autowired
    private ProjectService service;

    /**
     * 获取所有的信息
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    public List<Project> getAllEntities() {
        return service.getAllEntities();
    }

    /**
     * 根据Id获取信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Project getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }

    /**
     * 更新信息，包括新增与修改。
     * 如果Id为空新增，否则修改。
     *
     * @param project 需要更新的
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Project save(Project project) {
        if (null == project.getId()) {
            service.create(project);
        } else {
            service.update(project);
        }
        return project;
    }

    /**
     * 删除信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Project delete(@PathVariable Long id) {
        return service.delete(id);
    }

    /**
     * 搜索信息
     * @param response
     * @param so
     * @param page
     * @return
     */
    @RequestMapping(value = "/{page}")
    @ResponseBody
    public List<?> search(HttpServletResponse response, ProjectSO so, @PathVariable int page) {
        so.getPage().setPageNum(page);
        PageInfo pageInfo = service.search(so);
        return pageInfo.getItems();
    }
}
