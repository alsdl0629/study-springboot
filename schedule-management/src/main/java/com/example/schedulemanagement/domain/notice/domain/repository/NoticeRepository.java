package com.example.schedulemanagement.domain.notice.domain.repository;

import com.example.schedulemanagement.domain.notice.domain.Notice;
import org.springframework.data.repository.CrudRepository;

public interface NoticeRepository extends CrudRepository<Notice, Integer> {
}
