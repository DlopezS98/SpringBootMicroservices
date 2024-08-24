package net.storyshelf.ms_writer.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/wishlist/items")
public class WishListController {
    @PostMapping("/{bookId}")
    public String create(@PathVariable String bookId) {
        return bookId;
    }
}
