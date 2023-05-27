package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	@Transactional
	  List<Player> deleteById(String userId);

}