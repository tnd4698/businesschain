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
            role_manager.setRole("BRANCHMANAGER");
            roleRepository.save(role_manager);

            Role role_accountant = new Role();
            role_accountant.setRole("ACCOUNTANT");
            roleRepository.save(role_accountant);

            Role role_business = new Role();
            role_business.setRole("BUSINESSMANAGER");
            roleRepository.save(role_business);

            // branch
            Branch origin = new Branch();
            origin.setName("Cơ sở chính");
            origin.setManager(2);
            origin.setAddress("Tan Phu, HCM");
            origin.setStatus(1);
            origin.setOpenDate(new Date());
            branchRepository.save(origin);

            Branch br1 = new Branch();
            br1.setName("Cơ sở 1");
            br1.setManager(3);
            br1.setOpenDate(new Date());
            br1.setAddress("Tan Phu, HCM");
            br1.setStatus(1);
            branchRepository.save(br1);

            Branch br2 = new Branch();
            br2.setName("Cơ sở 2");
            br2.setManager(4);
            br2.setOpenDate(new Date());
            br2.setAddress("Tan Phu, HCM");
            br2.setStatus(1);
            branchRepository.save(br2);

            Branch br3 = new Branch();
            br3.setName("Cơ sở 3");
            br3.setManager(5);
            br3.setOpenDate(new Date());
            br3.setAddress("Tan Phu, HCM");
            br3.setStatus(1);
            branchRepository.save(br3);

            Branch br4 = new Branch();
            br4.setName("Cơ sở 4");
            br4.setManager(6);
            br4.setOpenDate(new Date());
            br4.setAddress("Tan Phu, HCM");
            br4.setStatus(1);
            branchRepository.save(br4);

            Branch br5 = new Branch();
            br5.setName("Cơ sở 5");
            br5.setManager(7);
            br5.setOpenDate(new Date());
            br5.setAddress("Tan Phu, HCM");
            br5.setStatus(1);
            branchRepository.save(br5);

            Branch br6 = new Branch();
            br6.setName("Cơ sở 6");
            br6.setManager(8);
            br6.setOpenDate(new Date());
            br6.setAddress("Tan Phu, HCM");
            br6.setStatus(1);
            branchRepository.save(br6);

            Branch br7 = new Branch();
            br7.setName("Cơ sở 7");
            br7.setManager(9);
            br7.setOpenDate(new Date());
            br7.setAddress("Tan Phu, HCM");
            br7.setStatus(1);
            branchRepository.save(br7);

            Branch br8 = new Branch();
            br8.setName("Cơ sở 8");
            br8.setManager(10);
            br8.setOpenDate(new Date());
            br8.setAddress("Tan Phu, HCM");
            br8.setStatus(1);
            branchRepository.save(br8);

            Branch br9 = new Branch();
            br9.setName("Cơ sở 9");
            br9.setManager(11);
            br9.setOpenDate(new Date());
            br9.setAddress("Tan Phu, HCM");
            br9.setStatus(1);
            branchRepository.save(br9);

            Branch br10 = new Branch();
            br10.setName("Cơ sở 10");
            br10.setManager(12);
            br10.setOpenDate(new Date());
            br10.setAddress("Tan Phu, HCM");
            br10.setStatus(1);
            branchRepository.save(br10);

            // rule br1
            Rule rule1 = new Rule();
            rule1.setName("CHOCOLATE");
            rule1.setType(Rule.MENU_ITEM);
            rule1.setValue("10000");
            rule1.setBranch(br1.getId());
            ruleRepository.save(rule1);

            Rule rule2 = new Rule();
            rule2.setName("ESPRESSO");
            rule2.setType(Rule.MENU_ITEM);
            rule2.setValue("10000");
            rule2.setBranch(br1.getId());
            ruleRepository.save(rule2);

            Rule rule3 = new Rule();
            rule3.setName("CAPPUCCINO");
            rule3.setType(Rule.MENU_ITEM);
            rule3.setValue("10000");
            rule3.setBranch(br1.getId());
            ruleRepository.save(rule3);

            Rule rule4 = new Rule();
            rule4.setName("MACCHIATO");
            rule4.setType(Rule.MENU_ITEM);
            rule4.setValue("10000");
            rule4.setBranch(br1.getId());
            ruleRepository.save(rule4);

            Rule rule5 = new Rule();
            rule5.setName("LATTE");
            rule5.setType(Rule.MENU_ITEM);
            rule5.setValue("10000");
            rule5.setBranch(br1.getId());
            ruleRepository.save(rule5);

            Rule rule6 = new Rule();
            rule6.setName("AMERICANO");
            rule6.setType(Rule.MENU_ITEM);
            rule6.setValue("10000");
            rule6.setBranch(br1.getId());
            ruleRepository.save(rule6);

            Rule rule7 = new Rule();
            rule7.setName("ARIGATO");
            rule7.setType(Rule.MENU_ITEM);
            rule7.setValue("10000");
            rule7.setBranch(br1.getId());
            ruleRepository.save(rule7);

            Rule rule8 = new Rule();
            rule8.setName("MOCHA");
            rule8.setType(Rule.MENU_ITEM);
            rule8.setValue("10000");
            rule8.setBranch(br1.getId());
            ruleRepository.save(rule8);

            Rule rule9 = new Rule();
            rule9.setName("FLAT_WHITE");
            rule9.setType(Rule.MENU_ITEM);
            rule9.setValue("10000");
            rule9.setBranch(br1.getId());
            ruleRepository.save(rule9);

            Rule rule10 = new Rule();
            rule10.setName("Số lượng nhân viên tối đa");
            rule10.setType(Rule.CONTRACT);
            rule10.setValue("5");
            rule10.setBranch(br1.getId());
            ruleRepository.save(rule10);

            // rule br2
            Rule rule11 = new Rule();
            rule11.setName("CHOCOLATE");
            rule11.setType(Rule.MENU_ITEM);
            rule11.setValue("10000");
            rule11.setBranch(br2.getId());
            ruleRepository.save(rule11);

            Rule rule12 = new Rule();
            rule12.setName("ESPRESSO");
            rule12.setType(Rule.MENU_ITEM);
            rule12.setValue("10000");
            rule12.setBranch(br2.getId());
            ruleRepository.save(rule12);

            Rule rule13 = new Rule();
            rule13.setName("CAPPUCCINO");
            rule13.setType(Rule.MENU_ITEM);
            rule13.setValue("10000");
            rule13.setBranch(br2.getId());
            ruleRepository.save(rule13);

            Rule rule14 = new Rule();
            rule14.setName("MACCHIATO");
            rule14.setType(Rule.MENU_ITEM);
            rule14.setValue("10000");
            rule14.setBranch(br2.getId());
            ruleRepository.save(rule14);

            Rule rule15 = new Rule();
            rule15.setName("LATTE");
            rule15.setType(Rule.MENU_ITEM);
            rule15.setValue("10000");
            rule15.setBranch(br2.getId());
            ruleRepository.save(rule15);

            Rule rule16 = new Rule();
            rule16.setName("AMERICANO");
            rule16.setType(Rule.MENU_ITEM);
            rule16.setValue("10000");
            rule16.setBranch(br2.getId());
            ruleRepository.save(rule16);

            Rule rule17 = new Rule();
            rule17.setName("ARIGATO");
            rule17.setType(Rule.MENU_ITEM);
            rule17.setValue("10000");
            rule17.setBranch(br2.getId());
            ruleRepository.save(rule17);

            Rule rule18 = new Rule();
            rule18.setName("MOCHA");
            rule18.setType(Rule.MENU_ITEM);
            rule18.setValue("10000");
            rule18.setBranch(br2.getId());
            ruleRepository.save(rule18);

            Rule rule19 = new Rule();
            rule19.setName("FLAT_WHITE");
            rule19.setType(Rule.MENU_ITEM);
            rule19.setValue("10000");
            rule19.setBranch(br2.getId());
            ruleRepository.save(rule19);

            Rule rule20 = new Rule();
            rule20.setName("Số lượng nhân viên tối đa");
            rule20.setType(Rule.CONTRACT);
            rule20.setValue("5");
            rule20.setBranch(br2.getId());
            ruleRepository.save(rule20);

            // rule br3
            Rule rule31 = new Rule();
            rule31.setName("CHOCOLATE");
            rule31.setType(Rule.MENU_ITEM);
            rule31.setValue("10000");
            rule31.setBranch(br3.getId());
            ruleRepository.save(rule31);

            Rule rule32 = new Rule();
            rule32.setName("ESPRESSO");
            rule32.setType(Rule.MENU_ITEM);
            rule32.setValue("10000");
            rule32.setBranch(br3.getId());
            ruleRepository.save(rule32);

            Rule rule33 = new Rule();
            rule33.setName("CAPPUCCINO");
            rule33.setType(Rule.MENU_ITEM);
            rule33.setValue("10000");
            rule33.setBranch(br3.getId());
            ruleRepository.save(rule33);

            Rule rule34 = new Rule();
            rule34.setName("MACCHIATO");
            rule34.setType(Rule.MENU_ITEM);
            rule34.setValue("10000");
            rule34.setBranch(br3.getId());
            ruleRepository.save(rule34);

            Rule rule35 = new Rule();
            rule35.setName("LATTE");
            rule35.setType(Rule.MENU_ITEM);
            rule35.setValue("10000");
            rule35.setBranch(br3.getId());
            ruleRepository.save(rule35);

            Rule rule36 = new Rule();
            rule36.setName("AMERICANO");
            rule36.setType(Rule.MENU_ITEM);
            rule36.setValue("10000");
            rule36.setBranch(br3.getId());
            ruleRepository.save(rule36);

            Rule rule37 = new Rule();
            rule37.setName("ARIGATO");
            rule37.setType(Rule.MENU_ITEM);
            rule37.setValue("10000");
            rule37.setBranch(br3.getId());
            ruleRepository.save(rule37);

            Rule rule38 = new Rule();
            rule38.setName("MOCHA");
            rule38.setType(Rule.MENU_ITEM);
            rule38.setValue("10000");
            rule38.setBranch(br3.getId());
            ruleRepository.save(rule38);

            Rule rule39 = new Rule();
            rule39.setName("FLAT_WHITE");
            rule39.setType(Rule.MENU_ITEM);
            rule39.setValue("10000");
            rule39.setBranch(br3.getId());
            ruleRepository.save(rule39);

            Rule rule40 = new Rule();
            rule40.setName("Số lượng nhân viên tối đa");
            rule40.setType(Rule.CONTRACT);
            rule40.setValue("5");
            rule40.setBranch(br3.getId());
            ruleRepository.save(rule40);

            // rule br4
            Rule rule51 = new Rule();
            rule51.setName("CHOCOLATE");
            rule51.setType(Rule.MENU_ITEM);
            rule51.setValue("10000");
            rule51.setBranch(br4.getId());
            ruleRepository.save(rule51);

            Rule rule52 = new Rule();
            rule52.setName("ESPRESSO");
            rule52.setType(Rule.MENU_ITEM);
            rule52.setValue("10000");
            rule52.setBranch(br4.getId());
            ruleRepository.save(rule52);

            Rule rule53 = new Rule();
            rule53.setName("CAPPUCCINO");
            rule53.setType(Rule.MENU_ITEM);
            rule53.setValue("10000");
            rule53.setBranch(br4.getId());
            ruleRepository.save(rule53);

            Rule rule54 = new Rule();
            rule54.setName("MACCHIATO");
            rule54.setType(Rule.MENU_ITEM);
            rule54.setValue("10000");
            rule54.setBranch(br4.getId());
            ruleRepository.save(rule54);

            Rule rule55 = new Rule();
            rule55.setName("LATTE");
            rule55.setType(Rule.MENU_ITEM);
            rule55.setValue("10000");
            rule55.setBranch(br4.getId());
            ruleRepository.save(rule55);

            Rule rule56 = new Rule();
            rule56.setName("AMERICANO");
            rule56.setType(Rule.MENU_ITEM);
            rule56.setValue("10000");
            rule56.setBranch(br4.getId());
            ruleRepository.save(rule56);

            Rule rule57 = new Rule();
            rule57.setName("ARIGATO");
            rule57.setType(Rule.MENU_ITEM);
            rule57.setValue("10000");
            rule57.setBranch(br4.getId());
            ruleRepository.save(rule57);

            Rule rule58 = new Rule();
            rule58.setName("MOCHA");
            rule58.setType(Rule.MENU_ITEM);
            rule58.setValue("10000");
            rule58.setBranch(br4.getId());
            ruleRepository.save(rule58);

            Rule rule59 = new Rule();
            rule59.setName("FLAT_WHITE");
            rule59.setType(Rule.MENU_ITEM);
            rule59.setValue("10000");
            rule59.setBranch(br4.getId());
            ruleRepository.save(rule59);

            Rule rule60 = new Rule();
            rule60.setName("Số lượng nhân viên tối đa");
            rule60.setType(Rule.CONTRACT);
            rule60.setValue("5");
            rule60.setBranch(br4.getId());
            ruleRepository.save(rule60);

            // rule br5
            Rule rule61 = new Rule();
            rule61.setName("CHOCOLATE");
            rule61.setType(Rule.MENU_ITEM);
            rule61.setValue("10000");
            rule61.setBranch(br5.getId());
            ruleRepository.save(rule61);

            Rule rule62 = new Rule();
            rule62.setName("ESPRESSO");
            rule62.setType(Rule.MENU_ITEM);
            rule62.setValue("10000");
            rule62.setBranch(br5.getId());
            ruleRepository.save(rule62);

            Rule rule63 = new Rule();
            rule63.setName("CAPPUCCINO");
            rule63.setType(Rule.MENU_ITEM);
            rule63.setValue("10000");
            rule63.setBranch(br5.getId());
            ruleRepository.save(rule63);

            Rule rule64 = new Rule();
            rule64.setName("MACCHIATO");
            rule64.setType(Rule.MENU_ITEM);
            rule64.setValue("10000");
            rule64.setBranch(br5.getId());
            ruleRepository.save(rule64);

            Rule rule65 = new Rule();
            rule65.setName("LATTE");
            rule65.setType(Rule.MENU_ITEM);
            rule65.setValue("10000");
            rule65.setBranch(br5.getId());
            ruleRepository.save(rule65);

            Rule rule66 = new Rule();
            rule66.setName("AMERICANO");
            rule66.setType(Rule.MENU_ITEM);
            rule66.setValue("10000");
            rule66.setBranch(br5.getId());
            ruleRepository.save(rule66);

            Rule rule67 = new Rule();
            rule67.setName("ARIGATO");
            rule67.setType(Rule.MENU_ITEM);
            rule67.setValue("10000");
            rule67.setBranch(br5.getId());
            ruleRepository.save(rule67);

            Rule rule68 = new Rule();
            rule68.setName("MOCHA");
            rule68.setType(Rule.MENU_ITEM);
            rule68.setValue("10000");
            rule68.setBranch(br5.getId());
            ruleRepository.save(rule68);

            Rule rule69 = new Rule();
            rule69.setName("FLAT_WHITE");
            rule69.setType(Rule.MENU_ITEM);
            rule69.setValue("10000");
            rule69.setBranch(br5.getId());
            ruleRepository.save(rule69);

            Rule rule70 = new Rule();
            rule70.setName("Số lượng nhân viên tối đa");
            rule70.setType(Rule.CONTRACT);
            rule70.setValue("5");
            rule70.setBranch(br5.getId());
            ruleRepository.save(rule70);

            // rule br6
            Rule rule71 = new Rule();
            rule71.setName("CHOCOLATE");
            rule71.setType(Rule.MENU_ITEM);
            rule71.setValue("10000");
            rule71.setBranch(br6.getId());
            ruleRepository.save(rule71);

            Rule rule72 = new Rule();
            rule72.setName("ESPRESSO");
            rule72.setType(Rule.MENU_ITEM);
            rule72.setValue("10000");
            rule72.setBranch(br6.getId());
            ruleRepository.save(rule72);

            Rule rule73 = new Rule();
            rule73.setName("CAPPUCCINO");
            rule73.setType(Rule.MENU_ITEM);
            rule73.setValue("10000");
            rule73.setBranch(br6.getId());
            ruleRepository.save(rule73);

            Rule rule74 = new Rule();
            rule74.setName("MACCHIATO");
            rule74.setType(Rule.MENU_ITEM);
            rule74.setValue("10000");
            rule74.setBranch(br6.getId());
            ruleRepository.save(rule74);

            Rule rule75 = new Rule();
            rule75.setName("LATTE");
            rule75.setType(Rule.MENU_ITEM);
            rule75.setValue("10000");
            rule75.setBranch(br6.getId());
            ruleRepository.save(rule75);

            Rule rule76 = new Rule();
            rule76.setName("AMERICANO");
            rule76.setType(Rule.MENU_ITEM);
            rule76.setValue("10000");
            rule76.setBranch(br6.getId());
            ruleRepository.save(rule76);

            Rule rule77 = new Rule();
            rule77.setName("ARIGATO");
            rule77.setType(Rule.MENU_ITEM);
            rule77.setValue("10000");
            rule77.setBranch(br6.getId());
            ruleRepository.save(rule77);

            Rule rule78 = new Rule();
            rule78.setName("MOCHA");
            rule78.setType(Rule.MENU_ITEM);
            rule78.setValue("10000");
            rule78.setBranch(br6.getId());
            ruleRepository.save(rule78);

            Rule rule79 = new Rule();
            rule79.setName("FLAT_WHITE");
            rule79.setType(Rule.MENU_ITEM);
            rule79.setValue("10000");
            rule79.setBranch(br6.getId());
            ruleRepository.save(rule79);

            Rule rule80 = new Rule();
            rule80.setName("Số lượng nhân viên tối đa");
            rule80.setType(Rule.CONTRACT);
            rule80.setValue("5");
            rule80.setBranch(br6.getId());
            ruleRepository.save(rule80);

            // rule br7
            Rule rule81 = new Rule();
            rule81.setName("CHOCOLATE");
            rule81.setType(Rule.MENU_ITEM);
            rule81.setValue("10000");
            rule81.setBranch(br7.getId());
            ruleRepository.save(rule81);

            Rule rule82 = new Rule();
            rule82.setName("ESPRESSO");
            rule82.setType(Rule.MENU_ITEM);
            rule82.setValue("10000");
            rule82.setBranch(br7.getId());
            ruleRepository.save(rule82);

            Rule rule83 = new Rule();
            rule83.setName("CAPPUCCINO");
            rule83.setType(Rule.MENU_ITEM);
            rule83.setValue("10000");
            rule83.setBranch(br7.getId());
            ruleRepository.save(rule83);

            Rule rule84 = new Rule();
            rule84.setName("MACCHIATO");
            rule84.setType(Rule.MENU_ITEM);
            rule84.setValue("10000");
            rule84.setBranch(br7.getId());
            ruleRepository.save(rule84);

            Rule rule85 = new Rule();
            rule85.setName("LATTE");
            rule85.setType(Rule.MENU_ITEM);
            rule85.setValue("10000");
            rule85.setBranch(br7.getId());
            ruleRepository.save(rule85);

            Rule rule86 = new Rule();
            rule86.setName("AMERICANO");
            rule86.setType(Rule.MENU_ITEM);
            rule86.setValue("10000");
            rule86.setBranch(br7.getId());
            ruleRepository.save(rule86);

            Rule rule87 = new Rule();
            rule87.setName("ARIGATO");
            rule87.setType(Rule.MENU_ITEM);
            rule87.setValue("10000");
            rule87.setBranch(br7.getId());
            ruleRepository.save(rule87);

            Rule rule88 = new Rule();
            rule88.setName("MOCHA");
            rule88.setType(Rule.MENU_ITEM);
            rule88.setValue("10000");
            rule88.setBranch(br7.getId());
            ruleRepository.save(rule88);

            Rule rule89 = new Rule();
            rule89.setName("FLAT_WHITE");
            rule89.setType(Rule.MENU_ITEM);
            rule89.setValue("10000");
            rule89.setBranch(br7.getId());
            ruleRepository.save(rule89);

            Rule rule90 = new Rule();
            rule90.setName("Số lượng nhân viên tối đa");
            rule90.setType(Rule.CONTRACT);
            rule90.setValue("5");
            rule90.setBranch(br7.getId());
            ruleRepository.save(rule90);

            // rule br8
            Rule rule91 = new Rule();
            rule91.setName("CHOCOLATE");
            rule91.setType(Rule.MENU_ITEM);
            rule91.setValue("10000");
            rule91.setBranch(br8.getId());
            ruleRepository.save(rule91);

            Rule rule92 = new Rule();
            rule92.setName("ESPRESSO");
            rule92.setType(Rule.MENU_ITEM);
            rule92.setValue("10000");
            rule92.setBranch(br8.getId());
            ruleRepository.save(rule92);

            Rule rule93 = new Rule();
            rule93.setName("CAPPUCCINO");
            rule93.setType(Rule.MENU_ITEM);
            rule93.setValue("10000");
            rule93.setBranch(br8.getId());
            ruleRepository.save(rule93);

            Rule rule94 = new Rule();
            rule94.setName("MACCHIATO");
            rule94.setType(Rule.MENU_ITEM);
            rule94.setValue("10000");
            rule94.setBranch(br8.getId());
            ruleRepository.save(rule94);

            Rule rule95 = new Rule();
            rule95.setName("LATTE");
            rule95.setType(Rule.MENU_ITEM);
            rule95.setValue("10000");
            rule95.setBranch(br8.getId());
            ruleRepository.save(rule95);

            Rule rule96 = new Rule();
            rule96.setName("AMERICANO");
            rule96.setType(Rule.MENU_ITEM);
            rule96.setValue("10000");
            rule96.setBranch(br8.getId());
            ruleRepository.save(rule96);

            Rule rule97 = new Rule();
            rule97.setName("ARIGATO");
            rule97.setType(Rule.MENU_ITEM);
            rule97.setValue("10000");
            rule97.setBranch(br8.getId());
            ruleRepository.save(rule97);

            Rule rule98 = new Rule();
            rule98.setName("MOCHA");
            rule98.setType(Rule.MENU_ITEM);
            rule98.setValue("10000");
            rule98.setBranch(br8.getId());
            ruleRepository.save(rule98);

            Rule rule99 = new Rule();
            rule99.setName("FLAT_WHITE");
            rule99.setType(Rule.MENU_ITEM);
            rule99.setValue("10000");
            rule99.setBranch(br8.getId());
            ruleRepository.save(rule99);

            Rule rule100 = new Rule();
            rule100.setName("Số lượng nhân viên tối đa");
            rule100.setType(Rule.CONTRACT);
            rule100.setValue("5");
            rule100.setBranch(br8.getId());
            ruleRepository.save(rule100);

            // rule br9
            Rule rule111 = new Rule();
            rule111.setName("CHOCOLATE");
            rule111.setType(Rule.MENU_ITEM);
            rule111.setValue("10000");
            rule111.setBranch(br9.getId());
            ruleRepository.save(rule111);

            Rule rule112 = new Rule();
            rule112.setName("ESPRESSO");
            rule112.setType(Rule.MENU_ITEM);
            rule112.setValue("10000");
            rule112.setBranch(br9.getId());
            ruleRepository.save(rule112);

            Rule rule113 = new Rule();
            rule113.setName("CAPPUCCINO");
            rule113.setType(Rule.MENU_ITEM);
            rule113.setValue("10000");
            rule113.setBranch(br9.getId());
            ruleRepository.save(rule113);

            Rule rule114 = new Rule();
            rule114.setName("MACCHIATO");
            rule114.setType(Rule.MENU_ITEM);
            rule114.setValue("10000");
            rule114.setBranch(br9.getId());
            ruleRepository.save(rule114);

            Rule rule115 = new Rule();
            rule115.setName("LATTE");
            rule115.setType(Rule.MENU_ITEM);
            rule115.setValue("10000");
            rule115.setBranch(br9.getId());
            ruleRepository.save(rule115);

            Rule rule116 = new Rule();
            rule116.setName("AMERICANO");
            rule116.setType(Rule.MENU_ITEM);
            rule116.setValue("10000");
            rule116.setBranch(br9.getId());
            ruleRepository.save(rule116);

            Rule rule117 = new Rule();
            rule117.setName("ARIGATO");
            rule117.setType(Rule.MENU_ITEM);
            rule117.setValue("10000");
            rule117.setBranch(br9.getId());
            ruleRepository.save(rule117);

            Rule rule118 = new Rule();
            rule118.setName("MOCHA");
            rule118.setType(Rule.MENU_ITEM);
            rule118.setValue("10000");
            rule118.setBranch(br9.getId());
            ruleRepository.save(rule118);

            Rule rule119 = new Rule();
            rule119.setName("FLAT_WHITE");
            rule119.setType(Rule.MENU_ITEM);
            rule119.setValue("10000");
            rule119.setBranch(br9.getId());
            ruleRepository.save(rule119);

            Rule rule120 = new Rule();
            rule120.setName("Số lượng nhân viên tối đa");
            rule120.setType(Rule.CONTRACT);
            rule120.setValue("5");
            rule120.setBranch(br9.getId());
            ruleRepository.save(rule120);

            // rule br10
            Rule rule131 = new Rule();
            rule131.setName("CHOCOLATE");
            rule131.setType(Rule.MENU_ITEM);
            rule131.setValue("10000");
            rule131.setBranch(br10.getId());
            ruleRepository.save(rule131);

            Rule rule132 = new Rule();
            rule132.setName("ESPRESSO");
            rule132.setType(Rule.MENU_ITEM);
            rule132.setValue("10000");
            rule132.setBranch(br10.getId());
            ruleRepository.save(rule132);

            Rule rule133 = new Rule();
            rule133.setName("CAPPUCCINO");
            rule133.setType(Rule.MENU_ITEM);
            rule133.setValue("10000");
            rule133.setBranch(br10.getId());
            ruleRepository.save(rule133);

            Rule rule134 = new Rule();
            rule134.setName("MACCHIATO");
            rule134.setType(Rule.MENU_ITEM);
            rule134.setValue("10000");
            rule134.setBranch(br10.getId());
            ruleRepository.save(rule134);

            Rule rule135 = new Rule();
            rule135.setName("LATTE");
            rule135.setType(Rule.MENU_ITEM);
            rule135.setValue("10000");
            rule135.setBranch(br10.getId());
            ruleRepository.save(rule135);

            Rule rule136 = new Rule();
            rule136.setName("AMERICANO");
            rule136.setType(Rule.MENU_ITEM);
            rule136.setValue("10000");
            rule136.setBranch(br10.getId());
            ruleRepository.save(rule136);

            Rule rule137 = new Rule();
            rule137.setName("ARIGATO");
            rule137.setType(Rule.MENU_ITEM);
            rule137.setValue("10000");
            rule137.setBranch(br10.getId());
            ruleRepository.save(rule137);

            Rule rule138 = new Rule();
            rule138.setName("MOCHA");
            rule138.setType(Rule.MENU_ITEM);
            rule138.setValue("10000");
            rule138.setBranch(br10.getId());
            ruleRepository.save(rule138);

            Rule rule139 = new Rule();
            rule139.setName("FLAT_WHITE");
            rule139.setType(Rule.MENU_ITEM);
            rule139.setValue("10000");
            rule139.setBranch(br10.getId());
            ruleRepository.save(rule139);

            Rule rule140 = new Rule();
            rule140.setName("Số lượng nhân viên tối đa");
            rule140.setType(Rule.CONTRACT);
            rule140.setValue("5");
            rule140.setBranch(br10.getId());
            ruleRepository.save(rule140);

            // employee admin
            Employee admin = new Employee();
            admin.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            admin.setName("Admin");
            admin.setBranch(origin.getId());
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

            //employee manager1
            Employee manager1 = new Employee();
            manager1.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            manager1.setName("Manager 1");
            manager1.setBranch(br1.getId());
            manager1.setStatus(1);
            manager1.setSalary(4000000);
            manager1.setAddress("Tan Binh, Ho Chi Minh, VN");
            manager1.setBirthDay("04/06/1998");
            manager1.setCardID("215438985");
            manager1.setEmail("tannguyenduy98@gmail.com");
            manager1.setGender(0);
            manager1.setPhoneNumber("0978301442");
            employeeRepository.save(manager1);

            EmployeeRole employeeRole1 = new EmployeeRole();
            employeeRole1.setEmployee(manager1.getId());
            employeeRole1.setRole(role_manager.getId());
            employeeRoleRepository.save(employeeRole1);

            Account acc1 = new Account();
            acc1.setUsername("manager1");
            acc1.setPassword(passwordEncoder.encode("manager1"));
            acc1.setEmployee(manager1.getId());
            acc1.setStatus(1);
            accountRepository.save(acc1);

            //employee manager2
            Employee manager2 = new Employee();
            manager2.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            manager2.setName("Manager 2");
            manager2.setBranch(br2.getId());
            manager2.setStatus(1);
            manager2.setSalary(4000000);
            manager2.setAddress("Tan Binh, Ho Chi Minh, VN");
            manager2.setBirthDay("04/06/1998");
            manager2.setCardID("215438985");
            manager2.setEmail("tannguyenduy98@gmail.com");
            manager2.setGender(0);
            manager2.setPhoneNumber("0978301442");
            employeeRepository.save(manager2);

            EmployeeRole employeeRole2 = new EmployeeRole();
            employeeRole2.setEmployee(manager2.getId());
            employeeRole2.setRole(role_manager.getId());
            employeeRoleRepository.save(employeeRole2);

            Account acc2 = new Account();
            acc2.setUsername("manager2");
            acc2.setPassword(passwordEncoder.encode("manager2"));
            acc2.setEmployee(manager2.getId());
            acc2.setStatus(1);
            accountRepository.save(acc2);

            //employee manager3
            Employee manager3 = new Employee();
            manager3.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            manager3.setName("Manager 3");
            manager3.setBranch(br3.getId());
            manager3.setStatus(1);
            manager3.setSalary(4000000);
            manager3.setAddress("Tan Binh, Ho Chi Minh, VN");
            manager3.setBirthDay("04/06/1998");
            manager3.setCardID("215438985");
            manager3.setEmail("tannguyenduy98@gmail.com");
            manager3.setGender(0);
            manager3.setPhoneNumber("0978301442");
            employeeRepository.save(manager3);

            EmployeeRole employeeRole3 = new EmployeeRole();
            employeeRole3.setEmployee(manager3.getId());
            employeeRole3.setRole(role_manager.getId());
            employeeRoleRepository.save(employeeRole3);

            Account acc3 = new Account();
            acc3.setUsername("manager3");
            acc3.setPassword(passwordEncoder.encode("manager3"));
            acc3.setEmployee(manager3.getId());
            acc3.setStatus(1);
            accountRepository.save(acc3);

            //employee manager4
            Employee manager4 = new Employee();
            manager4.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            manager4.setName("Manager 4");
            manager4.setBranch(br4.getId());
            manager4.setStatus(1);
            manager4.setSalary(4000000);
            manager4.setAddress("Tan Binh, Ho Chi Minh, VN");
            manager4.setBirthDay("04/06/1998");
            manager4.setCardID("215438985");
            manager4.setEmail("tannguyenduy98@gmail.com");
            manager4.setGender(0);
            manager4.setPhoneNumber("0978301442");
            employeeRepository.save(manager4);

            EmployeeRole employeeRole4 = new EmployeeRole();
            employeeRole4.setEmployee(manager4.getId());
            employeeRole4.setRole(role_manager.getId());
            employeeRoleRepository.save(employeeRole4);

            Account acc4 = new Account();
            acc4.setUsername("manager4");
            acc4.setPassword(passwordEncoder.encode("manager4"));
            acc4.setEmployee(manager4.getId());
            acc4.setStatus(1);
            accountRepository.save(acc4);

            //employee manager5
            Employee manager5 = new Employee();
            manager5.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            manager5.setName("Manager 5");
            manager5.setBranch(br5.getId());
            manager5.setStatus(1);
            manager5.setSalary(4000000);
            manager5.setAddress("Tan Binh, Ho Chi Minh, VN");
            manager5.setBirthDay("04/06/1998");
            manager5.setCardID("215438985");
            manager5.setEmail("tannguyenduy98@gmail.com");
            manager5.setGender(0);
            manager5.setPhoneNumber("0978301442");
            employeeRepository.save(manager5);

            EmployeeRole employeeRole5 = new EmployeeRole();
            employeeRole5.setEmployee(manager5.getId());
            employeeRole5.setRole(role_manager.getId());
            employeeRoleRepository.save(employeeRole5);

            Account acc5 = new Account();
            acc5.setUsername("manager5");
            acc5.setPassword(passwordEncoder.encode("manager5"));
            acc5.setEmployee(manager5.getId());
            acc5.setStatus(1);
            accountRepository.save(acc5);

            //employee manager6
            Employee manager6 = new Employee();
            manager6.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            manager6.setName("Manager 6");
            manager6.setBranch(br6.getId());
            manager6.setStatus(1);
            manager6.setSalary(4000000);
            manager6.setAddress("Tan Binh, Ho Chi Minh, VN");
            manager6.setBirthDay("04/06/1998");
            manager6.setCardID("215438985");
            manager6.setEmail("tannguyenduy98@gmail.com");
            manager6.setGender(0);
            manager6.setPhoneNumber("0978301442");
            employeeRepository.save(manager6);

            EmployeeRole employeeRole6 = new EmployeeRole();
            employeeRole6.setEmployee(manager6.getId());
            employeeRole6.setRole(role_manager.getId());
            employeeRoleRepository.save(employeeRole6);

            Account acc6 = new Account();
            acc6.setUsername("manager6");
            acc6.setPassword(passwordEncoder.encode("manager6"));
            acc6.setEmployee(manager6.getId());
            acc6.setStatus(1);
            accountRepository.save(acc6);

            //employee manager7
            Employee manager7 = new Employee();
            manager7.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            manager7.setName("Manager 7");
            manager7.setBranch(br7.getId());
            manager7.setStatus(1);
            manager7.setSalary(4000000);
            manager7.setAddress("Tan Binh, Ho Chi Minh, VN");
            manager7.setBirthDay("04/06/1998");
            manager7.setCardID("215438985");
            manager7.setEmail("tannguyenduy98@gmail.com");
            manager7.setGender(0);
            manager7.setPhoneNumber("0978301442");
            employeeRepository.save(manager7);

            EmployeeRole employeeRole7 = new EmployeeRole();
            employeeRole7.setEmployee(manager7.getId());
            employeeRole7.setRole(role_manager.getId());
            employeeRoleRepository.save(employeeRole7);

            Account acc7 = new Account();
            acc7.setUsername("manager7");
            acc7.setPassword(passwordEncoder.encode("manager7"));
            acc7.setEmployee(manager7.getId());
            acc7.setStatus(1);
            accountRepository.save(acc7);

            //employee manager8
            Employee manager8 = new Employee();
            manager8.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            manager8.setName("Manager 8");
            manager8.setBranch(br8.getId());
            manager8.setStatus(1);
            manager8.setSalary(4000000);
            manager8.setAddress("Tan Binh, Ho Chi Minh, VN");
            manager8.setBirthDay("04/06/1998");
            manager8.setCardID("215438985");
            manager8.setEmail("tannguyenduy98@gmail.com");
            manager8.setGender(0);
            manager8.setPhoneNumber("0978301442");
            employeeRepository.save(manager8);

            EmployeeRole employeeRole8 = new EmployeeRole();
            employeeRole8.setEmployee(manager8.getId());
            employeeRole8.setRole(role_manager.getId());
            employeeRoleRepository.save(employeeRole8);

            Account acc8 = new Account();
            acc8.setUsername("manager8");
            acc8.setPassword(passwordEncoder.encode("manager8"));
            acc8.setEmployee(manager8.getId());
            acc8.setStatus(1);
            accountRepository.save(acc8);

            //employee manager9
            Employee manager9 = new Employee();
            manager9.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            manager9.setName("Manager 9");
            manager9.setBranch(br9.getId());
            manager9.setStatus(1);
            manager9.setSalary(4000000);
            manager9.setAddress("Tan Binh, Ho Chi Minh, VN");
            manager9.setBirthDay("04/06/1998");
            manager9.setCardID("215438985");
            manager9.setEmail("tannguyenduy98@gmail.com");
            manager9.setGender(0);
            manager9.setPhoneNumber("0978301442");
            employeeRepository.save(manager9);

            EmployeeRole employeeRole9 = new EmployeeRole();
            employeeRole9.setEmployee(manager9.getId());
            employeeRole9.setRole(role_manager.getId());
            employeeRoleRepository.save(employeeRole9);

            Account acc9 = new Account();
            acc9.setUsername("manager9");
            acc9.setPassword(passwordEncoder.encode("manager9"));
            acc9.setEmployee(manager9.getId());
            acc9.setStatus(1);
            accountRepository.save(acc9);

            //employee manager10
            Employee manager10 = new Employee();
            manager10.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            manager10.setName("Manager 10");
            manager10.setBranch(br10.getId());
            manager10.setStatus(1);
            manager10.setSalary(4000000);
            manager10.setAddress("Tan Binh, Ho Chi Minh, VN");
            manager10.setBirthDay("04/06/1998");
            manager10.setCardID("215438985");
            manager10.setEmail("tannguyenduy98@gmail.com");
            manager10.setGender(0);
            manager10.setPhoneNumber("0978301442");
            employeeRepository.save(manager10);

            EmployeeRole employeeRole10 = new EmployeeRole();
            employeeRole10.setEmployee(manager10.getId());
            employeeRole10.setRole(role_manager.getId());
            employeeRoleRepository.save(employeeRole10);

            Account acc10 = new Account();
            acc10.setUsername("manager10");
            acc10.setPassword(passwordEncoder.encode("manager10"));
            acc10.setEmployee(manager10.getId());
            acc10.setStatus(1);
            accountRepository.save(acc10);

            //employee businessManager
            Employee business = new Employee();
            business.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            business.setName("BusinessManager");
            business.setBranch(origin.getId());
            business.setStatus(1);
            business.setSalary(1000000);
            business.setAddress("Tan Binh, Ho Chi Minh, VN");
            business.setBirthDay("04/06/1998");
            business.setCardID("215438985");
            business.setEmail("tannguyenduy98@gmail.com");
            business.setGender(0);
            business.setPhoneNumber("0978301442");
            employeeRepository.save(business);

            EmployeeRole employeeRolebusinessManager = new EmployeeRole();
            employeeRolebusinessManager.setEmployee(business.getId());
            employeeRolebusinessManager.setRole(role_business.getId());
            employeeRoleRepository.save(employeeRolebusinessManager);

            Account accOrigin = new Account();
            accOrigin.setUsername("business");
            accOrigin.setPassword(passwordEncoder.encode("business"));
            accOrigin.setEmployee(business.getId());
            accOrigin.setStatus(1);
            accountRepository.save(accOrigin);
            
            //employee accountant
            Employee accountant = new Employee();
            accountant.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            accountant.setName("accountant");
            accountant.setBranch(origin.getId());
            accountant.setStatus(1);
            accountant.setSalary(1000000);
            accountant.setAddress("Tan Binh, Ho Chi Minh, VN");
            accountant.setBirthDay("04/06/1998");
            accountant.setCardID("215438985");
            accountant.setEmail("tannguyenduy98@gmail.com");
            accountant.setGender(0);
            accountant.setPhoneNumber("0978301442");
            employeeRepository.save(accountant);

            EmployeeRole employeeRoleAccount = new EmployeeRole();
            employeeRoleAccount.setEmployee(accountant.getId());
            employeeRoleAccount.setRole(role_accountant.getId());
            employeeRoleRepository.save(employeeRoleAccount);

            Account accAccountant = new Account();
            accAccountant.setUsername("accountant");
            accAccountant.setPassword(passwordEncoder.encode("accountant"));
            accAccountant.setEmployee(accountant.getId());
            accAccountant.setStatus(1);
            accountRepository.save(accAccountant);


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

            //student
            Student student1 = new Student();
            student1.generateID(((List<Student>)studentRepository.findAll()).size()+1);
            student1.setName("Nguyen Van A");
            student1.setBranch(br1.getId());
            student1.setAddress("Tan Binh, Ho Chi Minh, VN");
            student1.setBirthDay("04/06/1998");
            student1.setCardID("215438985");
            student1.setEmail("tannguyenduy98@gmail.com");
            student1.setGender(0);
            student1.setStatus(1);
            student1.setPhoneNumber("0978301442");
            studentRepository.save(student1);

            // teacher
            Employee teacher1 = new Employee();
            teacher1.generateID(((List<Employee>)employeeRepository.findAll()).size()+1);
            teacher1.setName("Pham B B");
            teacher1.setBranch(br1.getId());
            teacher1.setStatus(1);
            teacher1.setSalary(4000000);
            teacher1.setAddress("Tan Binh, Ho Chi Minh, VN");
            teacher1.setBirthDay("04/06/1998");
            teacher1.setCardID("215438985");
            teacher1.setEmail("tannguyenduy98@gmail.com");
            teacher1.setGender(0);
            teacher1.setPhoneNumber("0978301442");
            employeeRepository.save(teacher1);

            EmployeeRole employeeRolet1 = new EmployeeRole();
            employeeRolet1.setEmployee(teacher1.getId());
            employeeRolet1.setRole(role_teacher.getId());
            employeeRoleRepository.save(employeeRolet1);

            // class
            Classs classs1 = new Classs();
            classs1.generateID(((List<Classs>)classRepository.findAll()).size()+1);
            classs1.setBranch(br1.getId());
            classs1.setFromDate("2019/01/22");
            classs1.setToDate("2019/02/22");
            classs1.setStatus(1);
            classs1.setTeacher(teacher1.getId());
            classRepository.save(classs1);

            //student class
            StudentClass studentClass1= new StudentClass();
            studentClass1.setClasss(classs1.getId());
            studentClass1.setStudent(student1.getId());
            studentClass1.setStatus(1);
            studentClass1.setStatusTuition(0);
            studentClassRepository.save(studentClass1);
        }
    }

}
