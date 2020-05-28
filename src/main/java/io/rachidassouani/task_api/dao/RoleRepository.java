package io.rachidassouani.task_api.dao;

import io.rachidassouani.task_api.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
