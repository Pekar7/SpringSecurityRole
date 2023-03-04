package com.example.springsecurity.controller;

import com.example.springsecurity.model.Developer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/developers")
public class Controller {

    private List<Developer> developers = Stream.of(
            new Developer(1L, "Karen", "Petrosian"),
            new Developer(2L, "Karolina", "Petrosian"),
            new Developer(3L, "Levon", "Karoian")
    ).toList();

    @GetMapping("")
    public List<Developer> helloAll() {
        return developers;
    }

    @GetMapping("/{id}")
    public Developer helloAdmin(@PathVariable Long id) {
        return developers.stream().filter(dev->dev.getId().equals(id)).findFirst().orElse(null);
    }

}
