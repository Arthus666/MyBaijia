package com.dream.mybaijia.service;

import com.dream.mybaijia.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author arthus
 * @since 2022-06-02
 */
public interface IArticleService extends IService<Article> {

    List<Article> getArticles();

}
