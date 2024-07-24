package org.abhishek.java.springmvcw2.services;

import org.abhishek.java.springmvcw2.dto.EmployeeDto;
import org.abhishek.java.springmvcw2.entity.EmployeeEntity;
import org.abhishek.java.springmvcw2.exceptions.ResourceNotFoundException;
import org.abhishek.java.springmvcw2.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

   private  final EmployeeRepository employeeRepository;

   private  final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDto getEmployeeById(Long empId) {
        EmployeeEntity employeeEntity = employeeRepository.findById(empId).orElse(null);
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    public List<EmployeeDto> findAll() {
                List<EmployeeEntity> employeeEntities =  employeeRepository.findAll();
             return    employeeEntities
                        .stream()
                        .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDto.class))
                        .toList();
    }

    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        // first convert dto to entity
          EmployeeEntity toSaveEntity =      modelMapper.map(employeeDto,EmployeeEntity.class);
         EmployeeEntity   employeeEntity =  employeeRepository.save(toSaveEntity);
          return modelMapper.map(employeeEntity,EmployeeDto.class);
    }

    public EmployeeDto updateEmployyeById(Long employeeId, EmployeeDto employeeDto ) {

        // as we geeting emplyooDto  first convert it into entity
         EmployeeEntity employeeEntity = modelMapper.map(employeeDto,EmployeeEntity.class);
         // now i will check if particular id is present or not then update else create with new user
         employeeEntity.setId(employeeId);
          EmployeeEntity employeeEntity1 = employeeRepository.save(employeeEntity);
          return modelMapper.map(employeeEntity1,EmployeeDto.class);

    }

    // method to check id exists or not
    public  void isExits(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if(!exists) throw new ResourceNotFoundException("Employee not found with id: "+employeeId);


    }
    public boolean deleteEmployeeById(Long employeeId) {
        isExits(employeeId);

        employeeRepository.deleteById(employeeId);
        return  true;
    }

    public EmployeeDto partiallyUpdate(Long employeeId, Map<String, Object> updates) {
        isExits(employeeId);
      EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();

      // we will use reflection where  can use keys which i wanted to update

        updates.forEach((field,value)->{
              Field filedToBeUpdate =  ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
              filedToBeUpdate.setAccessible(true);  //  as by default field are private so we need to make Accessible
             ReflectionUtils.setField(filedToBeUpdate,employeeEntity,value);
        });
       return  modelMapper.map( employeeRepository.save(employeeEntity),EmployeeDto.class);

    }
}








