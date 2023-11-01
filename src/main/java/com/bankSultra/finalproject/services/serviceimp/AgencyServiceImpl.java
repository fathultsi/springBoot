package com.bankSultra.finalproject.services.serviceimp;


import com.bankSultra.finalproject.dto.AgencyDto;
import com.bankSultra.finalproject.dto.UserDto;
import com.bankSultra.finalproject.mappers.AgencyMapper;
import com.bankSultra.finalproject.model.UserList;
import com.bankSultra.finalproject.repository.AgencyRepository;
import com.bankSultra.finalproject.services.AgencyService;
import com.bankSultra.finalproject.model.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bankSultra.finalproject.mappers.DtoMapper.agencyDtoMap;


@Service
@Transactional
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;

//    @Autowired
//    public AgencyMapper agencyMapper;




    @Override
    public List<AgencyDto> getAllagency() {
      List<Agency> agencies = agencyRepository.findAll();
      return agencies.stream()
              .map(agency -> agencyDtoMap(agency))
              .collect(Collectors.toList());
//      return agencies.stream()
//              .map(agency -> AgencyMapper.INSTANCE.agencyToAgencyDto(agency))
//              .collect(Collectors.toList());
//        return AgencyMapper.INSTANCE.agencyToAgencyDto2(agencies);

    }




    private AgencyDto mapToDto(Agency agency) {

        AgencyDto agencyDto = new AgencyDto();
        agencyDto.setId(agency.getId());
        agencyDto.setCode(agency.getCode());
        agencyDto.setDetails(agency.getDetails());
        agencyDto.setName(agency.getName());
        agencyDto.setOwner(usetMapDto(agency.getOwner()));
        agencyDto.setTrips(agency.getTrips());
        agencyDto.setBusList(agency.getBusList());
//        agencyDto.
        // Map other attributes
        return agencyDto;
    }

    private UserDto usetMapDto(UserList userList){
        UserDto userDto = new UserDto();
        userDto.setEmail(userList.getEmail());
        userDto.setFirstName(userList.getFirstName());
        userDto.setLastName(userList.getLastName());
        userDto.setMobileNumber(userList.getMobileNumber());
        return userDto;
    }

    @Override
    public Boolean cekAgencyById(Long id) {
        return agencyRepository.existsById(id);
    }

    @Override
    public Optional<Agency> findById(Long id) {
        // TODO Auto-generated method stub
        return agencyRepository.findById(id);
    }

    @Override
    public Agency createAgency(Agency agency) {
        return agencyRepository.save(agency);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub

        agencyRepository.deleteById(id);
    }

//    @Autowired
//    public UserList createUserList(UserList userList){
//        return userListRepository.save(userList);
//    };
//    @Autowired
//    public UserList createUser2(UserList userList){
//            return userListRepository.getById(1);
//    }


}
