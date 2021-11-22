package com.revature.myrev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.myrev.service.ThreadService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ThreadController {

    @Autowired
    private ThreadService service;

    @GetMapping("/threads")
    public List<Thread> findAll() {
        return service.findAll();
    }

    @GetMapping("/threadsById")
    public Thread findById(@PathVariable int threadId) {
        return service.findById(threadId);
    }

    @PostMapping("/threads")
    public void save(@RequestBody Thread thread) {
        service.save(thread);
    }

    @PutMapping("/threads/{thread_id}")
    public void update(@PathVariable int threadId, @RequestBody Thread thread) {
        service.save(thread);
    }

    @DeleteMapping("/threads/{thread_id}")
    public void delete(@PathVariable int threadId) {
        service.deleteById(threadId);
    }

}