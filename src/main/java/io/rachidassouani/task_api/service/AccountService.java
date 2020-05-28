package io.rachidassouani.task_api.service;

import io.rachidassouani.task_api.entity.AppRole;
import io.rachidassouani.task_api.entity.AppUser;

public interface AccountService {
    AppUser saveUser(AppUser appUser);
    AppRole saveRole(AppRole appRole);
    void addRoleToUser(String username, String roleName);
    AppUser findUserByUsername(String username);
}
