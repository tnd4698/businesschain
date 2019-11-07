package com.tnd.businesschainsystem.Service;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Model.ResourceDTO;

import java.util.List;

public interface ResourceManagementService {

    List<ResourceDTO> getResources(String branch, String type, String status);

    ResponseDTO updateResource(String resourceID, ResourceDTO resourceDTO);
}
