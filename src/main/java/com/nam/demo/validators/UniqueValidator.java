//package com.nam.demo.validators;
//
//import com.nam.demo.exception.ResourceAlreadyExistsException;
//import com.nam.demo.model.User;
//import com.nam.demo.repository.UserRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//@Slf4j
//@Transactional(rollbackFor = Exception.class)
//public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
//        User user = userRepository.findByEmail(value);
//        if (user != null)
////            return false;
//            throw new ResourceAlreadyExistsException("Email has already been registered: " + value);
//        else
//            return true;
//    }
//}
