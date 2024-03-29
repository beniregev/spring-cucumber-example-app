package com.beniregev.springcucumberexampleapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * SpringBoot {@link RestController}, very simple, nothing fancy.
 * @author Binyamin Regev
 * @since 1.8
 */
@RestController
@RequestMapping("/things")
public class BagController {

    private final Bag bag = new Bag();

    @GetMapping
    public Bag getBag() {
        return bag;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnything(@RequestBody String something) {
        bag.getThings().add(something);
    }

    @DeleteMapping
    public void removeEverything() {
        bag.getThings().clear();
    }
}
