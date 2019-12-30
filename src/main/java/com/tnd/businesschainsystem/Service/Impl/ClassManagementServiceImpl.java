package com.tnd.businesschainsystem.Service.Impl;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Message.Constants;
import com.tnd.businesschainsystem.Model.*;
import com.tnd.businesschainsystem.Repository.*;
import com.tnd.businesschainsystem.Service.ClassManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassManagementServiceImpl implements ClassManagementService {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private StudentClassRepository studentClassRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ShiftRepository shiftRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<ClassDTO> getClasses(String branch, String status) {

        List<ClassDTO> list = new ArrayList<>();
        List<Classs> classes = (List<Classs>) classRepository.findAll();
        for(Classs classs : classes) {

            if(!branch.equals("null") && classs.getBranch() != Integer.parseInt(branch))
                continue;
            if(!status.equals("null") && classs.getStatus() != Integer.parseInt(status))
                continue;

            Employee teacher = employeeRepository.findById(classs.getTeacher()).get();
            Branch br = branchRepository.findById(classs.getBranch()).get();
            ClassDTO classDTO = new ClassDTO();

            List<StudentDTO> students = new ArrayList<>();
            List<StudentClass> studentClasses = studentClassRepository.findByClassId(classs.getId());
            for(StudentClass studentClass : studentClasses) {

                Student student = studentRepository.findById(studentClass.getStudent()).get();
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.doMappingStudent(student,studentClass,classs,br);
                students.add(studentDTO);
            }

            List<Schedule> scheduleList = scheduleRepository.findByClassId(classs.getId());
            List<Shift> shifts = new ArrayList<>();
            for(Schedule schedule : scheduleList) {
                shifts.add(shiftRepository.findById(schedule.getShift()).get());
            }

            classDTO.doMappingClass(classs,br,teacher,students,shifts);
            list.add(classDTO);
        }
        return  list;
    }

    @Override
    public ResponseDTO addClass(ClassDTO classDTO) {

        try{
            Classs classs = new Classs();
            classs.generateID(((List<Classs>)classRepository.findAll()).size()+1);
            classs.doMappingClassDTO(classDTO);
            classRepository.save(classs);

            for(StudentDTO studentDTO : classDTO.getStudents()) {
                StudentClass studentClass = new StudentClass();
                studentClass.setStudent(studentDTO.getId());
                studentClass.setClasss(classs.getId());
                studentClass.setStatusTuition(0);
                studentClass.setStatus(1);
                studentClassRepository.save(studentClass);

                Student s = studentRepository.findById(studentDTO.getId()).get();
                s.setStatus(1);
                studentRepository.save(s);
            }

            for(Shift shift : classDTO.getShifts()) {
                Schedule schedule = new Schedule();
                schedule.setClasss(classs.getId());
                schedule.setShift(shift.getId());
                scheduleRepository.save(schedule);
            }

            return new ResponseDTO().success(Constants.DONE_ADDCLASS);
        } catch (Exception e) {
            return new ResponseDTO().fail(Constants.FAIL_ADDCLASS);
        }
    }

    @Override
    public ResponseDTO updateClass(String classID, ClassDTO classDTO) {

        try{
            Classs classs = classRepository.findByClassID(classID);
            classs.doMappingClassDTO(classDTO);
            classRepository.save(classs);
            if(classs.getStatus()==1) {
                // update students in class
                for (int i = 0; i < classDTO.getStudents().size(); i++) {
                    Student student = studentRepository.findById(classDTO.getStudents().get(i).getId()).get();
                    student.setStatus(1);
                    studentRepository.save(student);
                }


                List<StudentClass> oldStudentClasses = studentClassRepository.findByClassId(classs.getId());
                for (int i = 0; i < oldStudentClasses.size(); i++)
                    for (int j = 0; j < classDTO.getStudents().size(); j++)
                        if (oldStudentClasses.get(i).getStudent() == classDTO.getStudents().get(j).getId()) {
                            oldStudentClasses.remove(i);
                            classDTO.getStudents().remove(j);
                            i--;
                            break;
                        }
                for (int i = 0; i < oldStudentClasses.size(); i++) {

                    oldStudentClasses.get(i).setStatus(0);
                    studentClassRepository.save(oldStudentClasses.get(i));

                    Student student = studentRepository.findById(oldStudentClasses.get(i).getStudent()).get();
                    student.setStatus(0);
                    studentRepository.save(student);
                }

                for (int i = 0; i < classDTO.getStudents().size(); i++) {
                    StudentClass studentClass = new StudentClass();
                    studentClass.setStudent(classDTO.getStudents().get(i).getId());
                    studentClass.setClasss(classs.getId());
                    studentClass.setStatusTuition(0);
                    studentClass.setStatus(1);
                    studentClassRepository.save(studentClass);

                    Student student = studentRepository.findById(classDTO.getStudents().get(i).getId()).get();
                    student.setStatus(1);
                    studentRepository.save(student);
                }

                // update schedule of class
                List<Schedule> oldSchedule = scheduleRepository.findByClassId(classs.getId());

                for (int i = 0; i < oldSchedule.size(); i++)
                    for (int j = 0; j < classDTO.getShifts().size(); j++) {

                        if (oldSchedule.get(i).getShift() == classDTO.getShifts().get(j).getId()) {
                            oldSchedule.remove(i);
                            classDTO.getShifts().remove(j);
                            i--;
                            break;
                        }
                    }
                scheduleRepository.deleteAll(oldSchedule);

                for (int i = 0; i < classDTO.getShifts().size(); i++) {
                    Schedule schedule = new Schedule();
                    schedule.setClasss(classs.getId());
                    schedule.setShift(classDTO.getShifts().get(i).getId());
                    scheduleRepository.save(schedule);
                }
            }
            else {
                List<StudentClass> oldStudentClasses = studentClassRepository.findByClassId(classs.getId());
                for (int i = 0; i < oldStudentClasses.size(); i++) {

                    Student student = studentRepository.findById(oldStudentClasses.get(i).getStudent()).get();
                    student.setStatus(0);
                    studentRepository.save(student);
                }

                List<Schedule> oldSchedule = scheduleRepository.findByClassId(classs.getId());

                for (int i = 0; i < oldSchedule.size(); i++)
                    for (int j = 0; j < classDTO.getShifts().size(); j++) {

                        if (oldSchedule.get(i).getShift() == classDTO.getShifts().get(j).getId()) {
                            oldSchedule.remove(i);
                            classDTO.getShifts().remove(j);
                            i--;
                            break;
                        }
                    }
                scheduleRepository.deleteAll(oldSchedule);

                for (int i = 0; i < classDTO.getShifts().size(); i++) {
                    Schedule schedule = new Schedule();
                    schedule.setClasss(classs.getId());
                    schedule.setShift(classDTO.getShifts().get(i).getId());
                    scheduleRepository.save(schedule);
                }
            }
            return new ResponseDTO().success(Constants.DONE_UPDATECLASS);
        } catch (Exception e) {
            return new ResponseDTO().fail(Constants.FAIL_UPDATECLASS);
        }
    }

    @Override
    public List<Shift> getShifts() {

        return (List<Shift>) shiftRepository.findAll();
    }

}
