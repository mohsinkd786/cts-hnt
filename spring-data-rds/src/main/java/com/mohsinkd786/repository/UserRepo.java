package com.mohsinkd786.repository;

import com.mohsinkd786.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends CrudRepository<User,Integer> {
    void deleteByUserId(String userId);
    @Query("SELECT u FROM User u where u.salary > :sal")
    Iterable<User> getUsersBySalaryMoreThan(@Param("sal") double salary);
}


// raw low line template - CrudRepository
// more advanced - JpaRepository

