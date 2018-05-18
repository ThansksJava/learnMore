package com.cnpc.sss.mybatis.model;

import java.io.Serializable;

public class RolePermission  implements Serializable {
    private String roleid;

    private String permissionid;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(String permissionid) {
        this.permissionid = permissionid == null ? null : permissionid.trim();
    }
}