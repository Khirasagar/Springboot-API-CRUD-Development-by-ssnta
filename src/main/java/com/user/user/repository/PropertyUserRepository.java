package com.user.user.repository;

import com.user.user.entity.PropertyUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyUserRepository extends JpaRepository<PropertyUserEntity, Long> {
}