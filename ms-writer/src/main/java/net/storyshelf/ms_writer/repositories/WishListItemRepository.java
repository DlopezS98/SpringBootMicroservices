package net.storyshelf.ms_writer.repositories;

import net.storyshelf.ms_writer.entities.WishListItem;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListItemRepository extends JpaRepository<WishListItem, String> {
    Optional<WishListItem> findByBookId(String bookId);
}
