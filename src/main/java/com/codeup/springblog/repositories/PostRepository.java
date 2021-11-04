package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PostRepository extends JpaRepository<Post, Long> {
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value="UPDATE posts SET title= :t, body = :b where id = :i")
	void updateTitleAndBody(@Param("t") String title, @Param("b") String body, @Param("i") long id);
}
