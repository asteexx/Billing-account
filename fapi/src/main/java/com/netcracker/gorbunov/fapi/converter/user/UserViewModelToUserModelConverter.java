package com.netcracker.gorbunov.fapi.converter.user;

import com.netcracker.gorbunov.fapi.beClasses.UserModel;
import com.netcracker.gorbunov.fapi.models.UserViewModel;
import org.springframework.core.convert.converter.Converter;
public class UserViewModelToUserModelConverter implements Converter<UserViewModel, UserModel> {

    @Override
    public UserModel convert(UserViewModel userViewModel) {
        UserModel userModel = new UserModel();
        userModel.setIdUser(userViewModel.getIdUser());
        userModel.setLogin(userViewModel.getLogin());
        userModel.setPassword(userViewModel.getPassword());
        userModel.seteMail(userViewModel.geteMail());
        userModel.setRole(UserModel.Role.valueOf(userViewModel.getRole().toUpperCase()));
        userModel.setIdCompany(userViewModel.getIdCompany());
        userModel.seteWalletsByIdUser(userViewModel.geteWalletsByIdUser());
        userModel.setFirstName(userViewModel.getFirstName());
        userModel.setLastName(userViewModel.getLastName());
        userModel.setPhoneNumber(userViewModel.getPhoneNumber());
        userModel.setAdress(userViewModel.getAdress());

        return userModel;
    }
}
