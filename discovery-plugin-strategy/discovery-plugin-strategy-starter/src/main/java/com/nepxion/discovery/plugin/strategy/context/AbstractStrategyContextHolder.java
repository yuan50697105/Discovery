package com.nepxion.discovery.plugin.strategy.context;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.nepxion.discovery.common.constant.DiscoveryConstant;
import com.nepxion.discovery.plugin.framework.adapter.PluginAdapter;
import com.nepxion.discovery.plugin.framework.context.PluginContextHolder;
import com.nepxion.discovery.plugin.strategy.monitor.StrategyMonitorContext;
import com.nepxion.discovery.plugin.strategy.wrapper.StrategyWrapper;

public abstract class AbstractStrategyContextHolder implements PluginContextHolder, StrategyContextHolder {
    @Autowired
    protected PluginAdapter pluginAdapter;

    @Autowired
    protected StrategyWrapper strategyWrapper;

    @Autowired(required = false)
    protected StrategyMonitorContext strategyMonitorContext;

    @Override
    public String getContext(String name) {
        return getHeader(name);
    }

    @Override
    public String getContextRouteVersion() {
        String versionValue = getContext(DiscoveryConstant.N_D_VERSION);
        if (StringUtils.isEmpty(versionValue)) {
            versionValue = getRouteVersion();
        }

        return versionValue;
    }

    @Override
    public String getContextRouteRegion() {
        String regionValue = getContext(DiscoveryConstant.N_D_REGION);
        if (StringUtils.isEmpty(regionValue)) {
            regionValue = getRouteRegion();
        }

        return regionValue;
    }

    @Override
    public String getContextRouteEnvironment() {
        String environmentValue = getContext(DiscoveryConstant.N_D_ENVIRONMENT);
        if (StringUtils.isEmpty(environmentValue)) {
            environmentValue = getRouteEnvironment();
        }

        return environmentValue;
    }

    @Override
    public String getContextRouteAddress() {
        String addressValue = getContext(DiscoveryConstant.N_D_ADDRESS);
        if (StringUtils.isEmpty(addressValue)) {
            addressValue = getRouteAddress();
        }

        return addressValue;
    }

    @Override
    public String getContextRouteVersionWeight() {
        String versionWeightValue = getContext(DiscoveryConstant.N_D_VERSION_WEIGHT);
        if (StringUtils.isEmpty(versionWeightValue)) {
            versionWeightValue = getRouteVersionWeight();
        }

        return versionWeightValue;
    }

    @Override
    public String getContextRouteRegionWeight() {
        String regionWeightValue = getContext(DiscoveryConstant.N_D_REGION_WEIGHT);
        if (StringUtils.isEmpty(regionWeightValue)) {
            regionWeightValue = getRouteRegionWeight();
        }

        return regionWeightValue;
    }

    @Override
    public String getContextRouteIdBlacklist() {
        String idBlacklistValue = getContext(DiscoveryConstant.N_D_ID_BLACKLIST);
        if (StringUtils.isEmpty(idBlacklistValue)) {
            idBlacklistValue = getRouteIdBlacklist();
        }

        return idBlacklistValue;
    }

    @Override
    public String getContextRouteAddressBlacklist() {
        String addressBlacklistValue = getContext(DiscoveryConstant.N_D_ADDRESS_BLACKLIST);
        if (StringUtils.isEmpty(addressBlacklistValue)) {
            addressBlacklistValue = getRouteAddressBlacklist();
        }

        return addressBlacklistValue;
    }

    @Override
    public String getRouteVersion() {
        return strategyWrapper.getRouteVersion();
    }

    @Override
    public String getRouteRegion() {
        return strategyWrapper.getRouteRegion();
    }

    @Override
    public String getRouteEnvironment() {
        return null;
    }

    @Override
    public String getRouteAddress() {
        return strategyWrapper.getRouteAddress();
    }

    @Override
    public String getRouteVersionWeight() {
        return strategyWrapper.getRouteVersionWeight();
    }

    @Override
    public String getRouteRegionWeight() {
        return strategyWrapper.getRouteRegionWeight();
    }

    @Override
    public String getRouteIdBlacklist() {
        return strategyWrapper.getRouteIdBlacklist();
    }

    @Override
    public String getRouteAddressBlacklist() {
        return strategyWrapper.getRouteAddressBlacklist();
    }

    @Override
    public String getTraceId() {
        if (strategyMonitorContext != null) {
            return strategyMonitorContext.getTraceId();
        }

        return null;
    }

    @Override
    public String getSpanId() {
        if (strategyMonitorContext != null) {
            return strategyMonitorContext.getSpanId();
        }

        return null;
    }

    public PluginAdapter getPluginAdapter() {
        return pluginAdapter;
    }

    public StrategyWrapper getStrategyWrapper() {
        return strategyWrapper;
    }
}