package com.example.registerform.util;

import com.example.registerform.entity.User;
import com.example.registerform.repository.IUserRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidation implements Validator {

    private final IUserRepository userRepository;

    public UserValidation(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        // validate số điện thoại
        if (!user.getPhoneNumber().matches("^(0|\\+84)(3[2-9]|5[689]|7[06-9]|8[1-5]|9[0-9])[0-9]{7}$")) {
            errors.rejectValue("phoneNumber", "phoneNumber.invalid", "Số điện thoại không hợp lệ");
        }

        if(userRepository.existsByFirstNameAndLastName(user.getFirstName(), user.getLastName())) {
            errors.rejectValue("firstName", "name.duplicate", "Họ và tên đã tồn tại");
        }

        if(user.getLastName().length() < 5 || user.getFirstName().length() < 5 || (user.getFirstName().length() + user.getLastName()).length() > 45) {
            errors.rejectValue("firstName", "name.empty", "Họ và tên phải lớn hơn 5 ký tự và nhỏ hơn 45 ký tự");
        }

        if (user.getFirstName().isEmpty() || user.getLastName().isEmpty()) {
            errors.rejectValue("firstName", "name.empty", "Họ và tên không được để trống");
        }

        if(user.getEmail().isEmpty()) {
            errors.rejectValue("email", "email.empty", "Email không được để trống");
        }

        if(user.getPhoneNumber().isEmpty()) {
            errors.rejectValue("phoneNumber", "phoneNumber.empty", "Số điện thoại không được để trống");
        }

        // validate tuổi
        if (user.getAge() < 18) {
            errors.rejectValue("age", "age.invalid", "Tuổi phải >= 18");
        }

        if(!user.getEmail().matches("^(.+)@(.+)$")) {
            errors.rejectValue("email", "email.invalid", "Email không hợp lệ");
        }
    }
}
