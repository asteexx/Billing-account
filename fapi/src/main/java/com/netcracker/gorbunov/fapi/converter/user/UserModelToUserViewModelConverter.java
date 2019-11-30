package com.netcracker.gorbunov.fapi.converter.user;

import com.netcracker.gorbunov.fapi.beClasses.UserModel;
import com.netcracker.gorbunov.fapi.models.UserViewModel;
import org.springframework.core.convert.converter.Converter;

public class UserModelToUserViewModelConverter implements Converter<UserModel, UserViewModel> {
    @Override
    public UserViewModel convert(UserModel userModel) {
        UserViewModel userViewModel = new UserViewModel();
        userViewModel.setIdUser(userModel.getIdUser());
        userViewModel.setLogin(userModel.getLogin());
        userViewModel.setPassword(userModel.getPassword());
        userViewModel.seteMail(userModel.geteMail());
        userViewModel.setRole(userModel.getRole().getValue());
        userViewModel.setIdCompany(userModel.getIdCompany());
        userViewModel.seteWalletsByIdUser(userModel.geteWalletsByIdUser());
        userViewModel.setFirstName(userModel.getFirstName());
        userViewModel.setLastName(userModel.getLastName());
        userViewModel.setPhoneNumber(userModel.getPhoneNumber());
        userViewModel.setAdress(userModel.getAdress());

        return userViewModel;
    }
}
