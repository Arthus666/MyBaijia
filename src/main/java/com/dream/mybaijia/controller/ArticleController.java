package com.dream.mybaijia.controller;


import com.alibaba.fastjson.JSONObject;
import com.dream.mybaijia.entity.Article;
import com.dream.mybaijia.entity.JsonResult;
import com.dream.mybaijia.mapper.ArticleMapper;
import com.dream.mybaijia.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author arthus
 * @since 2022-06-02
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleServiceImpl articleService;

    @RequestMapping("/getArticles")
    public JsonResult<List<Article>> getArticles() {

        return new JsonResult<>(articleService.getArticles());
    }

    @RequestMapping("/addArticle")
    public JsonResult<String> addArticle(@RequestBody String jsonStr) {
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        String title = jsonObject.getString("title");
        String person = jsonObject.getString("person");
        String content = jsonObject.getString("content");

        articleService.save(new Article(0, title, person, content));

        return new JsonResult<>("1");
    }

    @RequestMapping("/deleteArticle")
    public JsonResult<String> deleteArticle(@RequestBody String jsonStr) {

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        String articleId = jsonObject.getString("articleId");

        int id = Integer.valueOf(articleId);

        articleService.removeById(id);

        return new JsonResult<>("1");
    }

    @RequestMapping("/updateArticle")
    public JsonResult<String> updateArticle(@RequestBody String jsonStr) {

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        String articleId = jsonObject.getString("id");
        String title = jsonObject.getString("title");
        String person = jsonObject.getString("person");
        String content = jsonObject.getString("content");

        int id = Integer.valueOf(articleId);

        articleService.updateById(new Article(id, title, person, content));

        return new JsonResult<>("1");
    }

}
