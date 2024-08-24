package net.storyshelf.ms_writer.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.storyshelf.ms_writer.entities.WishListItem;
import net.storyshelf.ms_writer.exceptions.NotFoundException;
import net.storyshelf.ms_writer.services.WishListService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping(WishListController.WISHLIST_ITEMS_URL)
public class WishListController {
    public static final String WISHLIST_ITEMS_URL = "/api/wishlist/items";
    private final WishListService wishListService;

    @GetMapping()
    public ResponseEntity<Iterable<WishListItem>> getAll() {
        return ResponseEntity.ok(wishListService.getWishListItems());
    }

    @PostMapping("/{bookId}")
    public ResponseEntity<WishListItem> create(@PathVariable String bookId) throws URISyntaxException {
        WishListItem wishListItem = wishListService.addBookToWishList(bookId);
        URI location = new URI(WISHLIST_ITEMS_URL + "/" + wishListItem.getId());
        return ResponseEntity.created(location).body(wishListItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WishListItem> getById(@PathVariable String id) {
        try {
            WishListItem item = wishListService.getById(id);
            // return ResponseEntity.ok(new HttpResponse<>(200, "Item found", item));
            return ResponseEntity.ok(item);
        }  catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            // return ResponseEntity.status(500).body(new HttpResponse<>(500, e.getMessage(), null));
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WishListItem> deleteById(@PathVariable String id) {
        try {
            WishListItem item = wishListService.deleteById(id);
            return ResponseEntity.ok(item);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
