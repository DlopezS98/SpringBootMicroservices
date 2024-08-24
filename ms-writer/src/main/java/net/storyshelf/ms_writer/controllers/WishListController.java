package net.storyshelf.ms_writer.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.storyshelf.ms_writer.entities.WishListItem;
import net.storyshelf.ms_writer.services.WishListService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/wishlist/items")
public class WishListController {
    private final WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @GetMapping()
    public Iterable<WishListItem> getAll() {
        return wishListService.getWishListItems();
    }

    @PostMapping("/{bookId}")
    public WishListItem create(@PathVariable String bookId) {
        return wishListService.addBookToWishList(bookId);
    }

    @GetMapping("/{id}")
    public WishListItem getById(@PathVariable String id) {
        return wishListService.getById(id);
    }

    @DeleteMapping("/{id}")
    public WishListItem deleteById(@PathVariable String id) {
        return wishListService.deleteById(id);
    }
}
