package com.yhnet.crm.facebook.admin.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhnet.crm.facebook.admin.entity.Article;
import com.yhnet.crm.facebook.admin.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author pacey
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/admin/article")
public class ArticleController {


    @Autowired
    private IArticleService articleService;

    @GetMapping("/list")
    public R list(@RequestParam(value = "param",required = false) String param,
                  @RequestParam(value = "current", defaultValue = "1") Integer current,
                  @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
        Page<Article> page = new Page<>(current, pageSize);
        articleService.page(page,Wrappers.<Article>lambdaQuery().like(StringUtils.isNotBlank(param), Article::getTitle, param)
                .eq(Article::getStatus,1)
                .orderByDesc(Article::getCreateTime));
        return R.ok(page);
    }

    @GetMapping("/detail")
    public R detail(@RequestParam(value = "id",required = true) Integer id){
        Article article = articleService.getById(id);
        return R.ok(article);
    }

    @PostMapping("/saveOrUpdate")
    public R saveOrUpdate(@RequestBody Article article){
        if(article.getId() == null){
            article.setCreateTime(LocalDateTime.now());
        }
        boolean update = articleService.saveOrUpdate(article);
        if(update){
            return R.ok("");
        }
        return R.failed("操作失败");
    }
    @PostMapping("/del")
    public R del(@RequestParam(value = "id",required = true) Integer id){
        boolean update = articleService.updateById(new Article().setId(id).setStatus(0));
        if(update){
            return R.ok("");
        }
        return R.failed("操作失败");
    }

}

