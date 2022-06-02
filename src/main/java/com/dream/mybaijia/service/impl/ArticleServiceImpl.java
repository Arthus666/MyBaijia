package com.dream.mybaijia.service.impl;

import com.dream.mybaijia.entity.Article;
import com.dream.mybaijia.mapper.ArticleMapper;
import com.dream.mybaijia.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author arthus
 * @since 2022-06-02
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
