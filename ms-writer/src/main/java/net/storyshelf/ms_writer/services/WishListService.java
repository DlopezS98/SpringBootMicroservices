package net.storyshelf.ms_writer.services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.storyshelf.ms_writer.dtos.BookDto;
import net.storyshelf.ms_writer.entities.WishListItem;
import net.storyshelf.ms_writer.exceptions.NotFoundException;
import net.storyshelf.ms_writer.repositories.WishListItemRepository;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final WishListItemRepository wishListItemRepository;
    private final BooksService booksService;

    public WishListItem addBookToWishList(String bookId) {
        BookDto bookDto = booksService.getById(bookId).orElseThrow(() -> new NotFoundException("Book not found"));
        WishListItem wishListItem = new WishListItem();
        wishListItem.setBookId(bookId);
        wishListItem.setBookTitle(bookDto.getTitle());
        wishListItem.setBookCoverUrl(bookDto.getCoverUrl());
        
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
