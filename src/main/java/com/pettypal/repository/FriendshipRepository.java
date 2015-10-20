package com.pettypal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pettypal.domain.Friendship;
import com.pettypal.domain.User;

@Repository
public interface FriendshipRepository extends CrudRepository<Friendship, Long> {

	@Query("SELECT f FROM friendship f WHERE f.firstUser=:userId OR f.secondUser =:userId)")
	public List<Friendship> findAllFriendsips(long userId);

}
