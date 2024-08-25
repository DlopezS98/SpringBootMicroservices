package net.storyshelf.ms_writer.repositories;

import net.storyshelf.ms_writer.entities.WishListItem;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListItemRepository extends CrudRepository<WishListItem, String> {
    Optional<WishListItem> findByBookId(String bookId);
}
