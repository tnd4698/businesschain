package com.tnd.businesschainsystem.Service;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Model.Import;
import com.tnd.businesschainsystem.Model.ResourceDTO;
import com.tnd.businesschainsystem.Model.Shipway;

import java.util.List;

public interface ResourceManagementService {

    List<ResourceDTO> getResources(String branch, String type, String status);

    ResponseDTO updateResource(String resourceID, ResourceDTO resourceDTO);

    ResponseDTO addShipways(List<Shipway> shipways, String username);

    ResponseDTO addImport(List<Import> imports, String username);

    ResponseDTO addResource(ResourceDTO resourceDTO);
}
