package com.bankSultra.finalproject.services.serviceimp;



import com.bankSultra.finalproject.model.Role;
import com.bankSultra.finalproject.repository.RoleRepository;
import com.bankSultra.finalproject.services.BusService;
import com.bankSultra.finalproject.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> getAllBus() {
        return null;
    }

    @Override
    public Role createBus(Role role) {
        return null;
    }

    @Override
    public Boolean cekBusById(Long id) {
        return null;
    }

    @Override
    public Optional<Role> findRoleById(Long id) {
        return roleRepository.findById(id);
    }
}
