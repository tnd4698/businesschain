package com.tnd.businesschainsystem.Service;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Model.TuitionDTO;

public interface TuitionManagementService {

    ResponseDTO add(TuitionDTO tuitionDTO, String username);
}
