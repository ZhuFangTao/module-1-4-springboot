package com.lagou.springboot04_thymeleaf;

import com.lagou.mapper.ArticleMapper;
import com.lagou.pojo.BlogArticle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@SpringBootTest
class Springboot04ThymeleafApplicationTests {


    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void testJpa(){
        Optional<BlogArticle> byId = articleMapper.findById(1l);
        System.out.printf(byId.get().toString());
    }

    @Test
    public void testJpaPage(){
        Page<BlogArticle> page = articleMapper.findAll( PageRequest.of(0,2, Sort.by(Sort.Direction.ASC,"id")));
        System.out.printf(page.getContent().toString());
    }


}
