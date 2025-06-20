package com.example.pasir_szymik_dawid.repository;

import com.example.pasir_szymik_dawid.model.Group;
import com.example.pasir_szymik_dawid.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findByMemberships_User(User user);
}
