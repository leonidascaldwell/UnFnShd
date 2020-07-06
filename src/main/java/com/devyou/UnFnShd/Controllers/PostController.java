package com.devyou.UnFnShd.Controllers;

import com.devyou.UnFnShd.Models.Post;
import com.devyou.UnFnShd.Repositories.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/")
    public String goHome(Model model, @RequestParam(defaultValue="0") int page){
        model.addAttribute("post", postRepository.findAll(PageRequest.of(page,4)));
        return "index";
    }

    @GetMapping
    public List<Post> getAll(){return postRepository.findAll();}

    @GetMapping
    @RequestMapping("{id}")
    public Post get(@PathVariable Long id){return postRepository.getOne(id);}

    @PostMapping
    public Post create(@RequestBody final Post post){return postRepository.saveAndFlush(post);}

    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //make sure to check for children records
        postRepository.deleteById(id);
    }

    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    public Post update(@PathVariable Long id, @RequestBody Post post){
        //Because this is a PUT, we expect all attributes to be passed i. A PATCH would only need what
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Post existingPost = postRepository.getOne(id);
        BeanUtils.copyProperties(post, existingPost, "post_id");
        return postRepository.saveAndFlush(existingPost);
    }
}
