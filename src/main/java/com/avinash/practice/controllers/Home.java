package com.avinash.practice.controllers;

import com.avinash.practice.models.Entry;
import com.avinash.practice.mongoRepos.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Home {
    @Autowired
    PostRepo postRepo;
    @RequestMapping("/home")
    public String Homepage(){
        System.out.println("hello");
        return "home.jsp";
    }

    @GetMapping("/allEntries")
    public List<Entry> getAllEntries(){
        System.out.println("How");
        return postRepo.findAll();
    }

    @PostMapping("/addEntry")
    public Entry addEntry(@RequestBody Entry entry){
        return postRepo.save(entry);
    }

    @GetMapping("/findByTitle")
    public List<Entry> getItem(@RequestBody String title){
        return postRepo.findByTitle(title);
    }

    @DeleteMapping("/findAndDelete")
    public String deleteItem(@RequestBody String author){
        List<Entry> check = postRepo.findByAuthor(author);
        Entry del = check.get(0);
        postRepo.delete(del);
        return "Deleted Successfully";
    }

    @GetMapping("/search")
    public List<Entry> searchItem(@RequestBody Entry entry){
        return postRepo.search(entry.getAuthor(), entry.getPages());
    }
}
