package com.pettypal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pettypal.domain.Friendship;
import com.pettypal.domain.User;

@Repository
public interface FriendshipRepository extends CrudRepository<Friendship, Long> {

	@Query("SELECT f FROM friendship f WHERE f.firstUser=:userId OR f.secondUser =:userId)")
	public List<Friendship> findAllFriendsips(@Param("userId") long userId);
	
	@Query("SELECT f FROM friendship f WHERE (f.firstUser=:user1 AND f.secondUser =:user2) OR (f.firstUser=:user2 AND f.secondUser =:user1) )")
	public Friendship getRelationship(@Param("user1") long firstuserId, @Param("user2") long seconduserId);

}
