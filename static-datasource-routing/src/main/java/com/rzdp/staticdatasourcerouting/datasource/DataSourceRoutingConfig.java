package com.rzdp.staticdatasourcerouting.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

public class DataSourceRoutingConfig extends AbstractRoutingDataSource {


    @Override
    protected Object determineCurrentLookupKey() {
        return BranchContextHolder.getBranchContext();
    }

    public void initializeDatasource(Map<Object, Object> dataSources) {
        this.setTargetDataSources(dataSources);
        this.setDefaultTargetDataSource(dataSources.get("bangkok"));
    }
}
