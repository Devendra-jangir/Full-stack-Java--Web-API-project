package com.engineeringproject.App.controller;

import com.engineeringproject.App.entity.Jounralentry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jounral")
public class AppEntryController {

    private Map<Long, Jounralentry>jounralentries = new HashMap<>();

    @GetMapping
    public List<Jounralentry> getAll(){
        return new ArrayList<>(jounralentries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody Jounralentry myEntry){

        jounralentries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public Jounralentry JounralentryById(@PathVariable Long myId){
        return jounralentries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public Jounralentry DeleteJounralentryById(@PathVariable Long myId){
        return jounralentries.remove(myId);
    }
    @PutMapping("id/{id}")re
    public Jounralentry updateJounralentryById(@PathVariable Long id,@RequestBody Jounralentry myEntry ){
        return jounralentries.put(id,myEntry);
    }
}
