package com.example.springbatchdemo.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class BatchConfiguration extends DefaultBatchConfiguration {
    private final DataSource dataSource;

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }
}
