package com.tnd.businesschainsystem.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ResourceDTO {

    public static final int MATERIAL = 0;
    public static final int EQUIPMENT = 1;

    private int id;
    private String resourceID;
    private String name;
    private int count;
    private long price;
    private int status;
    private int branchId;
    private String branchName;
    private int type;

    public int getId() {
        return id;
    }

    public String getResourceID() {
        return resourceID;
    }

    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static String generateID(ResourceDTO resourceDTO){
        String rs = resourceDTO.getType()==MATERIAL?"MTL":"EQT";
        rs+= (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(new Date()).replace('/','0')
                .replace(':','0').replace(' ','0');
        return rs;
    }

    public void doMappingMaterial(Material material, MaterialBranch materialBranch, Branch branch) {

        this.id = material.getId();
        this.resourceID = material.getMaterialID();
        this.name = material.getName();
        this.count = materialBranch.getCount();
        this.price = material.getPrice();
        this.status = 1;
        this.branchId = branch.getId();
        this.branchName = branch.getName();
        this.type = MATERIAL;
    }

    public void doMappingEquipment(Equipment equipment, Branch branch) {

        this.id = equipment.getId();
        this.resourceID = equipment.getEquipmentID();
        this.name = equipment.getName();
        this.count = 1;
        this.price = equipment.getPrice();
        this.status = equipment.getStatus();
        this.branchId = branch.getId();
        this.branchName = branch.getName();
        this.type = EQUIPMENT;
    }
}
