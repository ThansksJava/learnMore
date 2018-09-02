package com.cnpc.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/9/2
 * @Time 19:30
 */
@Getter
@Setter
public class VMCpu {
    private String vmName;
    private String ipAddress;
    private String vcName;
    private String dataSource;
    private double usedCpuMhz;
    private double cpuTotalMhz;
    private double cpuUtilization;
}
