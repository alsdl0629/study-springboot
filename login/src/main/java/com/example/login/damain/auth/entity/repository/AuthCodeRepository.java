package com.example.login.damain.auth.entity.repository;

import com.example.login.damain.auth.entity.AuthCode;
import org.springframework.data.repository.CrudRepository;

public interface AuthCodeRepository extends CrudRepository<AuthCode, String> {
}
