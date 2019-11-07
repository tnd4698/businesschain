package com.tnd.businesschainsystem.Service.Impl;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Message.Constants;
import com.tnd.businesschainsystem.Model.Account;
import com.tnd.businesschainsystem.Model.StudentClass;
import com.tnd.businesschainsystem.Model.Tuition;
import com.tnd.businesschainsystem.Model.TuitionDTO;
import com.tnd.businesschainsystem.Repository.AccountRepository;
import com.tnd.businesschainsystem.Repository.StudentClassRepository;
import com.tnd.businesschainsystem.Repository.TuitionRepository;
import com.tnd.businesschainsystem.Service.TuitionManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TuitionManagementServiceImpl implements TuitionManagementService {

    @Autowired
    private TuitionRepository tuitionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private StudentClassRepository studentClassRepository;

    @Override
    public ResponseDTO add(TuitionDTO tuitionDTO, String username) {

        try {
            Account acc = accountRepository.findByUsername(username);
            StudentClass studentClass = studentClassRepository.findByStudentId(tuitionDTO.getStudentId());
            if(studentClass == null || studentClass.getClasss() != tuitionDTO.getClassId())
                throw new Exception("Khong co lop hoc de dong hoc phi");
            if(studentClass.getStatusTuition()==1)
                throw new Exception("Hoc vien da dong hoc phi");

            Tuition tuition = new Tuition();
            tuition.setStudentClass(studentClass.getId());
            tuition.setCreatedBy(acc.getEmployee());
            tuition.setTotalMoney(tuitionDTO.getTotalMoney());
            tuition.setCreatedDate(new Date());
            tuitionRepository.save(tuition);

            studentClass.setStatusTuition(1);
            studentClassRepository.save(studentClass);

            return new ResponseDTO().success(Constants.DONE_ADDTUITION);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseDTO().fail(Constants.FAIL_ADDTUITION);
        }
    }
}
