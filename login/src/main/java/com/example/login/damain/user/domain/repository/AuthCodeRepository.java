package com.example.login.damain.user.domain.repository;

import com.example.login.damain.user.domain.AuthCode;
import org.springframework.data.repository.CrudRepository;

public interface AuthCodeRepository extends CrudRepository<AuthCode, String> {
}
