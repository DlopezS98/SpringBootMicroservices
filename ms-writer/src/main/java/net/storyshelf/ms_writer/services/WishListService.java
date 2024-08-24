package net.storyshelf.ms_writer.services;

import org.springframework.stereotype.Service;

import net.storyshelf.ms_writer.entities.WishListItem;
import net.storyshelf.ms_writer.exceptions.NotFoundException;
import net.storyshelf.ms_writer.repositories.WishListItemRepository;

@Service
public class WishListService {
    private final WishListItemRepository wishListItemRepository;

    public WishListService(WishListItemRepository wishListItemRepository) {
        this.wishListItemRepository = wishListItemRepository;
    }

    public WishListItem addBookToWishList(String bookId) {
        WishListItem wishListItem = new WishListItem();
        wishListItem.setBookId(bookId);
        return wishListItemRepository.save(wishListItem);
    }

    public Iterable<WishListItem> getWishListItems() {
        return wishListItemRepository.findAll();
    }

    public WishListItem getById(String id) {
        return wishListItemRepository.findById(id).orElseThrow(() -> new NotFoundException("Item not found"));
    }

    public WishListItem deleteById(String id) {
        WishListItem wishListItem = getById(id);
        wishListItemRepository.deleteById(id);
        return wishListItem;
    }
}
