package com.lagou.mapper;

import com.lagou.pojo.BlogArticle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * \* User: ZhuFangTao
 * \* Date: 2020/5/26 10:43 上午
 * \
 */
public interface ArticleMapper extends JpaRepository<BlogArticle,Long> {


}