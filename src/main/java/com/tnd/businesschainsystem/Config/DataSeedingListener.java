package com.tnd.businesschainsystem.Config;

import com.tnd.businesschainsystem.Model.*;
import com.tnd.businesschainsystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private TimeworkRepository timeworkRepository;

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private MaterialBranchRepository materialBranchRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentClassRepository studentClassRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private ShiftRepository shiftRepository;

    @Autowired
    private PayrollRepository payrollRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(roleRepository.findById(1).isEmpty()) {

            // roles
            Role role_admin = new Role();
            role_admin.setRole("ADMIN");
            roleRepository.save(role_admin);

            Role role_staff = new Role();
            role_staff.setRole("STAFF");
            roleRepository.save(role_staff);

            Role role_teacher = new Role();
            role_teacher.setRole("TEACHER");
            roleRepository.save(role_teacher);

            Role role_manager = new Role();
            role_manager.setRole("MANAGER");
            roleRepository.save(role_manager);

            Role role_accountant = new Role();
            role_accountant.setRole("ACCOUNTANT");
            roleRepository.save(role_accountant);

            Role role_business = new Role();
            role_business.setRole("BUSINESS");
            roleRepository.save(role_business);

            // branch
            Branch origin = new Branch();
            origin.setName("origin");
            origin.setManager(1);
            origin.setOpenDate(new Date());
            branchRepository.save(origin);

            Branch sub = new Branch();
            sub.setName("sub");
            sub.setManager(2);
            sub.setOpenDate(new Date());
            branchRepository.save(sub);

            // rule branch origin
            Rule rule = new Rule();
            rule.setName("Cafe sữa");
            rule.setType(0);
            rule.setValue("10000");
            rule.setBranch(1);
            ruleRepository.save(rule);

            // employee admin
            Employee admin = new Employee();
            admin.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            admin.setName("Admin");
            admin.setBranch(1);
            admin.setStatus(1);
            admin.setSalary(10000000);
            employeeRepository.save(admin);

            EmployeeRole employeeRole = new EmployeeRole();
            employeeRole.setEmployee(admin.getId());
            employeeRole.setRole(role_admin.getId());
            employeeRoleRepository.save(employeeRole);

            Account acc = new Account();
            acc.setUsername("admin");
            acc.setPassword(passwordEncoder.encode("admin"));
            acc.setEmployee(admin.getId());
            acc.setStatus(1);
            accountRepository.save(acc);

            //employee manager
            Employee manager = new Employee();
            manager.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            manager.setName("Manager");
            manager.setBranch(2);
            manager.setStatus(1);
            manager.setSalary(1000000);
            employeeRepository.save(manager);

            EmployeeRole employeeRole1 = new EmployeeRole();
            employeeRole1.setEmployee(manager.getId());
            employeeRole1.setRole(role_manager.getId());
            employeeRoleRepository.save(employeeRole1);

            Account acc1 = new Account();
            acc1.setUsername("manager");
            acc1.setPassword(passwordEncoder.encode("manager"));
            acc1.setEmployee(manager.getId());
            acc1.setStatus(1);
            accountRepository.save(acc1);

            // teacher
            Employee teacher = new Employee();
            teacher.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            teacher.setName("teacher");
            teacher.setBranch(1);
            teacher.setStatus(1);
            teacher.setSalary(2000000);
            employeeRepository.save(teacher);

            EmployeeRole employeeRole2 = new EmployeeRole();
            employeeRole2.setEmployee(teacher.getId());
            employeeRole2.setRole(role_teacher.getId());
            employeeRoleRepository.save(employeeRole2);

            // timework
            Timework timework1 = new Timework();
            timework1.setDate("03/11/2019");
            timework1.setEmployee(admin.getId());
            timework1.setStatus(TimeworkDTO.ABSENT);
            timeworkRepository.save(timework1);

            Timework timework2 = new Timework();
            timework2.setDate("04/11/2019");
            timework2.setEmployee(admin.getId());
            timework2.setStatus(TimeworkDTO.ACTIVE);
            timeworkRepository.save(timework2);

            Timework timework3 = new Timework();
            timework3.setDate("04/11/2019");
            timework3.setEmployee(manager.getId());
            timework3.setStatus(TimeworkDTO.ABSENT);
            timeworkRepository.save(timework3);

            Timework timework4 = new Timework();
            timework4.setDate("04/11/2019");
            timework4.setEmployee(teacher.getId());
            timework4.setStatus(TimeworkDTO.ABSENT);
            timeworkRepository.save(timework4);

            // resources
            Material cafe = new Material();
            cafe.setName("NL_CAFE");
            cafe.setCount(100);
            cafe.setMaterialID("MTL324");
            materialRepository.save(cafe);

            MaterialBranch cafeBr1 = new MaterialBranch();
            cafeBr1.setBranch(origin.getId());
            cafeBr1.setCount(50);
            cafeBr1.setMaterial(cafe.getId());
            materialBranchRepository.save(cafeBr1);

            MaterialBranch cafeBr2 = new MaterialBranch();
            cafeBr2.setBranch(sub.getId());
            cafeBr2.setCount(50);
            cafeBr2.setMaterial(cafe.getId());
            materialBranchRepository.save(cafeBr2);

            Material milk = new Material();
            milk.setName("NL_MILK");
            milk.setCount(100);
            milk.setMaterialID("MTL234");
            materialRepository.save(milk);

            MaterialBranch milkBr1 = new MaterialBranch();
            milkBr1.setBranch(sub.getId());
            milkBr1.setCount(50);
            milkBr1.setMaterial(milk.getId());
            materialBranchRepository.save(milkBr1);

            MaterialBranch milkBr2 = new MaterialBranch();
            milkBr2.setBranch(origin.getId());
            milkBr2.setCount(50);
            milkBr2.setMaterial(milk.getId());
            materialBranchRepository.save(milkBr2);

            // equipment
            Equipment equipment1 = new Equipment();
            equipment1.setBranch(origin.getId());
            equipment1.setEquipmentID("EQT0001");
            equipment1.setName("equipment 1");
            equipment1.setStatus(1);
            equipmentRepository.save(equipment1);

            Equipment equipment2 = new Equipment();
            equipment2.setBranch(sub.getId());
            equipment2.setEquipmentID("EQT0002");
            equipment2.setName("equipment 2");
            equipment2.setStatus(0);
            equipmentRepository.save(equipment2);

            // student
            Student student1 = new Student();
            student1.generateID(((List<Student>)studentRepository.findAll()).size()+1);
            student1.setBranch(origin.getId());
            student1.setCardID("215438777");
            student1.setName("nguyen duy tan");
            student1.setStatus(1);
            studentRepository.save(student1);

            // shift
            Shift shift1 = new Shift();
            shift1.setDate("Thứ 2");
            shift1.setTime("Ca 1");
            shiftRepository.save(shift1);

            Shift shift2 = new Shift();
            shift2.setDate("Thứ 2");
            shift2.setTime("Ca 2");
            shiftRepository.save(shift2);

            Shift shift3 = new Shift();
            shift3.setDate("Thứ 3");
            shift3.setTime("Ca 1");
            shiftRepository.save(shift3);

            Shift shift4 = new Shift();
            shift4.setDate("Thứ 3");
            shift4.setTime("Ca 2");
            shiftRepository.save(shift4);

            Shift shift5 = new Shift();
            shift5.setDate("Thứ 4");
            shift5.setTime("Ca 1");
            shiftRepository.save(shift5);

            Shift shift6 = new Shift();
            shift6.setDate("Thứ 4");
            shift6.setTime("Ca 2");
            shiftRepository.save(shift6);

            Shift shift7 = new Shift();
            shift7.setDate("Thứ 5");
            shift7.setTime("Ca 1");
            shiftRepository.save(shift7);

            Shift shift8 = new Shift();
            shift8.setDate("Thứ 5");
            shift8.setTime("Ca 2");
            shiftRepository.save(shift8);

            Shift shift9 = new Shift();
            shift9.setDate("Thứ 6");
            shift9.setTime("Ca 1");
            shiftRepository.save(shift9);

            Shift shift10 = new Shift();
            shift10.setDate("Thứ 6");
            shift10.setTime("Ca 2");
            shiftRepository.save(shift10);

            Shift shift11 = new Shift();
            shift11.setDate("Thứ 7");
            shift11.setTime("Ca 1");
            shiftRepository.save(shift11);

            Shift shift12 = new Shift();
            shift12.setDate("Thứ 7");
            shift12.setTime("Ca 2");
            shiftRepository.save(shift12);

            Shift shift13 = new Shift();
            shift13.setDate("Chủ nhật");
            shift13.setTime("Ca 1");
            shiftRepository.save(shift13);

            Shift shift14 = new Shift();
            shift14.setDate("Chủ nhật");
            shift14.setTime("Ca 2");
            shiftRepository.save(shift14);

            // class
            Classs classs1 = new Classs();
            classs1.setBranch(origin.getId());
            classs1.generateID(((List<Classs>)classRepository.findAll()).size() + 1 );
            classs1.setFromDate("14/06/2019");
            classs1.setToDate("15/06/2019");
            classs1.setTeacher(teacher.getId());
            classRepository.save(classs1);

            StudentClass studentClass1 = new StudentClass();
            studentClass1.setStudent(student1.getId());
            studentClass1.setClasss(classs1.getId());
            studentClass1.setStatusTuition(0);
            studentClass1.setStatus(1);
            studentClassRepository.save(studentClass1);

            //payroll
//            Payroll payroll = new Payroll();
//            payroll.setCreatedBy(admin.getId());
//            payroll.setCreatedDate(new Date());
//            payroll.setAbsent(0);
//            payroll.setContentOther("");
//            payroll.setEmployee(manager.getId());
//            payroll.setMonth(11);
//            payroll.setYear(2019);
//            payroll.setOther(0);
//            payroll.setSalary(100000);
//            payroll.setTotalMoney(1000000);
//            payrollRepository.save(payroll);
        }
    }

}