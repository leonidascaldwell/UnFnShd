package com.devyou.UnFnShd.Controllers;

import com.devyou.UnFnShd.Models.Post;
import com.devyou.UnFnShd.Repositories.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/")

    public String goHome(ModelMap modelMap){
        List<Post> posts = postRepository.findAll();
        modelMap.put("posts",posts);
        return "home";
    }

    @GetMapping
    @RequestMapping("/posts")
    public List<Post> getAll(){return postRepository.findAll();}

    @GetMapping
    @RequestMapping("{id}")
    public Post get(@PathVariable Long id){return postRepository.getOne(id);}

    @GetMapping
    @RequestMapping("/post/{id}")
    public String getPost(@PathVariable Long id, ModelMap modelMap){
        Post post = postRepository.getOne(id);
        modelMap.put("post",post);
        return "post_page";
    }
}
