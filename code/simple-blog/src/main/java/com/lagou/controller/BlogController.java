package com.lagou.controller;

import com.lagou.mapper.ArticleMapper;
import com.lagou.pojo.BlogArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * \* User: ZhuFangTao
 * \* Date: 2020/5/26 11:32 上午
 * \
 */
@Controller
public class BlogController {

    @Autowired
    private ArticleMapper articleMapper;

    @RequestMapping("/index")
    public String toLoginPage(Model model, HttpServletRequest request){
        int pageNum;
        int pageSize;
        try{
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        }catch (Exception e){
            pageNum = 0;
            pageSize = 2;
        }
        List<BlogArticle> articleList = articleMapper.findAll(PageRequest.of(pageNum,pageSize, Sort.by("id"))).getContent();
        model.addAttribute("articleList",articleList);
        return "/client/index";
    }

}