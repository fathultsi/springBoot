package com.bankSultra.finalproject.services;





import com.bankSultra.finalproject.model.Role;

import java.util.List;
import java.util.Optional;


public interface RoleService {

    List<Role> getAllBus();

    Role createBus(Role role);

    Boolean cekBusById(Long id);

    Optional<Role> findRoleById(Long id);
}
