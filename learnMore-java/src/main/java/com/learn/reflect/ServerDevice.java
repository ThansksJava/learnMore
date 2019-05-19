package com.learn.reflect;
/**
 * @Author fengjie
 * @Description 服务器设备
 * @Date Created in 2018/9/4
 * @Time 10:27
 */
public class ServerDevice {
    private String dataCenterId;
    private String dataCenterCode;
    private String dataCenterName;
    private String deployAreaId;
    private String deployAreaCode;
    private String deployAreaName;
    private String machineRoomId;
    private String machineRoomCode;
    private String machineRoomName;
    /**
     * 设备规格
     */
    private String deviceModel;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 设备类型
     */
    private String deviceType;
    /**
     * 总量（台、套）
     */
    private String deviceSum;
    /**
     * 服务器用途
     */
    private String serverUsage;
    /**
     * 序列号
     */
    private String deviceSn;
    /**
     * ipmi地址
     */
    private String ipmiIp;
    /**
     * 设备品牌
     */
    private String deviceBrand;
    /**
     * 规格型号
     */
    private String model;
    /**
     * cpu内存核数型号
     */
    private String cpu;
    private String cpuModel;
    private String memory;
    private String memoryModel;

    /**
     * 产权单位
     */
    private String customDepartment;
    /**
     * 产权项目
     */
    private String useDepartment;
    /**
     * 项目用户
     */
    private String projectName;
    /**
     * 供应商
     */
    private String supplierName;
    /**
     * 采购日期、采购合同编号
     */
    private String purchaseDate;
    private String purchaseDateBegin;
    private String purchaseDateEnd;
    private String purchaseContract;
    /**
     * 维保合同号、维保起始日期、维保终止日期
     */
    private String guarantContact;
    private String guarantDateS;
    private String guarantDateE;

    /**
     * 查询时间起始
     */
    private String searchTimeBegin;
    private String searchTimeEnd;

    public String getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(String dataCenterId) {
        this.dataCenterId = dataCenterId;
    }

    public String getDataCenterCode() {
        return dataCenterCode;
    }

    public void setDataCenterCode(String dataCenterCode) {
        this.dataCenterCode = dataCenterCode;
    }

    public String getDataCenterName() {
        return dataCenterName;
    }

    public void setDataCenterName(String dataCenterName) {
        this.dataCenterName = dataCenterName;
    }

    public String getDeployAreaId() {
        return deployAreaId;
    }

    public void setDeployAreaId(String deployAreaId) {
        this.deployAreaId = deployAreaId;
    }

    public String getDeployAreaCode() {
        return deployAreaCode;
    }

    public void setDeployAreaCode(String deployAreaCode) {
        this.deployAreaCode = deployAreaCode;
    }

    public String getDeployAreaName() {
        return deployAreaName;
    }

    public void setDeployAreaName(String deployAreaName) {
        this.deployAreaName = deployAreaName;
    }

    public String getMachineRoomId() {
        return machineRoomId;
    }

    public void setMachineRoomId(String machineRoomId) {
        this.machineRoomId = machineRoomId;
    }

    public String getMachineRoomCode() {
        return machineRoomCode;
    }

    public void setMachineRoomCode(String machineRoomCode) {
        this.machineRoomCode = machineRoomCode;
    }

    public String getMachineRoomName() {
        return machineRoomName;
    }

    public void setMachineRoomName(String machineRoomName) {
        this.machineRoomName = machineRoomName;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceSum() {
        return deviceSum;
    }

    public void setDeviceSum(String deviceSum) {
        this.deviceSum = deviceSum;
    }

    public String getServerUsage() {
        return serverUsage;
    }

    public void setServerUsage(String serverUsage) {
        this.serverUsage = serverUsage;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public String getIpmiIp() {
        return ipmiIp;
    }

    public void setIpmiIp(String ipmiIp) {
        this.ipmiIp = ipmiIp;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMemoryModel() {
        return memoryModel;
    }

    public void setMemoryModel(String memoryModel) {
        this.memoryModel = memoryModel;
    }

    public String getCustomDepartment() {
        return customDepartment;
    }

    public void setCustomDepartment(String customDepartment) {
        this.customDepartment = customDepartment;
    }

    public String getUseDepartment() {
        return useDepartment;
    }

    public void setUseDepartment(String useDepartment) {
        this.useDepartment = useDepartment;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseDateBegin() {
        return purchaseDateBegin;
    }

    public void setPurchaseDateBegin(String purchaseDateBegin) {
        this.purchaseDateBegin = purchaseDateBegin;
    }

    public String getPurchaseDateEnd() {
        return purchaseDateEnd;
    }

    public void setPurchaseDateEnd(String purchaseDateEnd) {
        this.purchaseDateEnd = purchaseDateEnd;
    }

    public String getPurchaseContract() {
        return purchaseContract;
    }

    public void setPurchaseContract(String purchaseContract) {
        this.purchaseContract = purchaseContract;
    }

    public String getGuarantContact() {
        return guarantContact;
    }

    public void setGuarantContact(String guarantContact) {
        this.guarantContact = guarantContact;
    }

    public String getGuarantDateS() {
        return guarantDateS;
    }

    public void setGuarantDateS(String guarantDateS) {
        this.guarantDateS = guarantDateS;
    }

    public String getGuarantDateE() {
        return guarantDateE;
    }

    public void setGuarantDateE(String guarantDateE) {
        this.guarantDateE = guarantDateE;
    }

    public String getSearchTimeBegin() {
        return searchTimeBegin;
    }

    public void setSearchTimeBegin(String searchTimeBegin) {
        this.searchTimeBegin = searchTimeBegin;
    }

    public String getSearchTimeEnd() {
        return searchTimeEnd;
    }

    public void setSearchTimeEnd(String searchTimeEnd) {
        this.searchTimeEnd = searchTimeEnd;
    }
}
