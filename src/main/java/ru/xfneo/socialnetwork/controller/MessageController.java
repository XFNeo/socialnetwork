package ru.xfneo.socialnetwork.controller;

import org.springframework.web.bind.annotation.*;
import ru.xfneo.socialnetwork.exception.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {
    private int count = 4;

    private List<Map<String,String>> messages = new ArrayList<Map<String, String>>(){{
       add(new HashMap<String, String>(){{put("id", "1"); put("text", "Message1");}});
       add(new HashMap<String, String>(){{put("id", "2"); put("text", "Message2");}});
       add(new HashMap<String, String>(){{put("id", "3"); put("text", "Message3");}});
    }};

    private Map<String, String> getMessage(String id) {
        return messages.stream()
                .filter(m -> m.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @GetMapping
    public List<Map<String, String>> list(){
        return messages;
    }

    @GetMapping("{id}")
    public Map<String, String> get(@PathVariable String id){
        return getMessage(id);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> message){
        message.put("id", String.valueOf(count++));
        messages.add(message);
        return message;
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message){
        Map<String, String> messageFormDb = getMessage(id);
        messageFormDb.putAll(message);
        messageFormDb.put("id", id);
        return messageFormDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Map<String, String> message = getMessage(id);
        messages.remove(message);
    }

}