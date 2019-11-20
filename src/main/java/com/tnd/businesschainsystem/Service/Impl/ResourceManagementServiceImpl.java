package com.tnd.businesschainsystem.Service.Impl;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Message.Constants;
import com.tnd.businesschainsystem.Model.*;
import com.tnd.businesschainsystem.Repository.*;
import com.tnd.businesschainsystem.Service.ResourceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ResourceManagementServiceImpl implements ResourceManagementService {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private MaterialBranchRepository materialBranchRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ShipwayRepository shipwayRepository;

    @Autowired
    private ImportRepository importRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<ResourceDTO> getResources(String branch, String type, String status) {

        List<ResourceDTO> list = new ArrayList<>();

        if(type.equals("null") || Integer.parseInt(type) == ResourceDTO.MATERIAL) {
            List<Material> materials = (List<Material>) materialRepository.findAll();
            for (Material material : materials) {

                List<MaterialBranch> materialBranches = materialBranchRepository.findByMaterialId(material.getId());
                for (int i = 0; i < materialBranches.size(); i++) {

                    if (!branch.equals("null") && materialBranches.get(i).getBranch() != Integer.parseInt(branch))
                        continue;

                    Branch br = branchRepository.findById(materialBranches.get(i).getBranch()).get();
                    ResourceDTO resourceDTO = new ResourceDTO();
                    resourceDTO.doMappingMaterial(material, materialBranches.get(i), br);

                    if(!status.equals("null") && resourceDTO.getStatus() != Integer.parseInt(status))
                        continue;

                    list.add(resourceDTO);
                }
            }
        }

        if(type.equals("null") || Integer.parseInt(type) == ResourceDTO.EQUIPMENT) {
            List<Equipment> equipments = (List<Equipment>) equipmentRepository.findAll();
            for (Equipment equipment : equipments) {

                Branch br = branchRepository.findById(equipment.getBranch()).get();

                if (!branch.equals("null") && br.getId() != Integer.parseInt(branch))
                    continue;

                ResourceDTO resourceDTO = new ResourceDTO();
                resourceDTO.doMappingEquipment(equipment, br);

                if(!status.equals("null") && resourceDTO.getStatus() != Integer.parseInt(status))
                    continue;

                list.add(resourceDTO);
            }
        }

        return list;
    }

    @Override
    public ResponseDTO updateResource(String resourceID, ResourceDTO resourceDTO) {

        try {
            if (resourceID.substring(0, 3).equals("MTL")) {
                Material material = materialRepository.findById(resourceDTO.getId()).get();
                MaterialBranch materialBranch = materialBranchRepository.findByMaterialIdAndBranchId(resourceDTO.getId(), resourceDTO.getBranchId());
                int d = resourceDTO.getCount() - materialBranch.getCount();
                materialBranch.setCount(resourceDTO.getCount());
                material.setCount(material.getCount() + d);
                materialRepository.save(material);
                materialBranchRepository.save(materialBranch);
            } else {
                Equipment equipment = equipmentRepository.findById(resourceDTO.getId()).get();
                equipment.setStatus(resourceDTO.getStatus());
                equipmentRepository.save(equipment);
            }
            return new ResponseDTO().success(Constants.DONE_UPDATERESOURCE);
        } catch (Exception e) {
            return new ResponseDTO().fail(Constants.FAIL_UPDATERESOURCE);
        }
    }

    @Override
    public ResponseDTO addShipways(List<Shipway> shipways, String username) {

        try {
            Account acc = accountRepository.findByUsername(username);
            shipways.stream().forEach(shipway -> {

                if(shipway.getResourceID().substring(0,3).equals("MTL")) {
                    Material material = materialRepository.findByMaterialID(shipway.getResourceID());
                    shipway.setPrice(material.getPrice());
                } else {
                    Equipment equipment = equipmentRepository.findByEquipmentID(shipway.getResourceID());
                    shipway.setPrice(equipment.getPrice());
                }
                shipway.generateId();
                shipway.setCreatedDate(new Date());
                shipway.setCreatedBy(acc.getEmployee());
                shipway.setPrice(shipway.getPrice());
                shipway.setTotalMoney(shipway.getPrice() * shipway.getCount());
            });

            shipwayRepository.saveAll(shipways);
            return new ResponseDTO().success(Constants.DONE_ADDSHIPWAY);
        } catch (Exception e) {
            return new ResponseDTO().fail(Constants.FAIL_ADDSHIPWAY);
        }
    }

    @Override
    public ResponseDTO addImport(List<Import> imports, String username) {

        try {
            Account acc = accountRepository.findByUsername(username);
            imports.stream().forEach(imp -> {
                imp.generateId();
                imp.setCreatedDate(new Date());
                imp.setCreatedBy(acc.getEmployee());
            });

            importRepository.saveAll(imports);
            return new ResponseDTO().success(Constants.DONE_ADDIMPORT);
        } catch (Exception e) {
            return new ResponseDTO().fail(Constants.FAIL_ADDIMPORT);
        }
    }

    @Override
    public ResponseDTO addResource(ResourceDTO resourceDTO) {

        try {
            if(resourceDTO.getType() == ResourceDTO.MATERIAL) {
                Material material = new Material();
                material.setMaterialID(ResourceDTO.generateID(resourceDTO));
                material.setCount(0);
                material.setName(resourceDTO.getName());
                materialRepository.save(material);
            } else {
                Equipment equipment = new Equipment();
                equipment.setEquipmentID(ResourceDTO.generateID(resourceDTO));
                equipment.setStatus(0);
                equipment.setName(resourceDTO.getName());
                equipment.setBranch(resourceDTO.getBranchId());
                equipmentRepository.save(equipment);
            }

            return new ResponseDTO().success(Constants.DONE_ADDRESOURCE);
        } catch (Exception e) {
            return new ResponseDTO().fail(Constants.FAIL_ADDRESOURCE);
        }
    }
}
