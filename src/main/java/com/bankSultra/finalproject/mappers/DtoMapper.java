package com.bankSultra.finalproject.mappers;


import com.bankSultra.finalproject.dto.*;
import com.bankSultra.finalproject.model.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DtoMapper {

    public static AgencyDto agencyDtoMap(Agency agency) {

        AgencyDto agencyDto = new AgencyDto();
        agencyDto.setId(agency.getId());
        agencyDto.setCode(agency.getCode());
        agencyDto.setDetails(agency.getDetails());
        agencyDto.setName(agency.getName());
        agencyDto.setOwner(usetDtoMap(agency.getOwner()));
        agencyDto.setTrips(agency.getTrips());
        agencyDto.setBusList(agency.getBusList());
        if (agency.getOwner() != null){
            agencyDto.setOwner(usetDtoMap(agency.getOwner()));
        }
//        agencyDto.
        // Map other attributes
        return agencyDto;
    }
    public static TicketMapDto ticketToDto(Ticket ticket){
        TicketMapDto ticketMapDto = new TicketMapDto();
        ticketMapDto.setId(ticket.getId());
        ticketMapDto.setCancellable(ticket.getCancellable());
        ticketMapDto.setJourneyDate(ticket.getJourneyDate());
        ticketMapDto.setSeatNumber(ticket.getSeatNumber());

        if (ticket.getPassenger() != null){
            ticketMapDto.setPassenger(usetDtoMap(ticket.getPassenger()));
        }

        return ticketMapDto;
    }
    public static BusDto busToDto(Bus bus){
        BusDto busDto = new BusDto();
        busDto.setId(bus.getId());
        busDto.setCode(bus.getCode());
        busDto.setMake(bus.getMake());
        busDto.setCapacity(bus.getCapacity());
        if (bus.getAgency() != null){
            busDto.setAgency(agencyDtoMap(bus.getAgency()));
        }

        return busDto;
    }

    public static TripDto tripToDto(Trip trip){
        TripDto tripDto = new TripDto();
        tripDto.setId(trip.getId());
        tripDto.setFare(trip.getFare());
        tripDto.setJourneyTime(trip.getJourneyTime());

        if (trip.getDestStop() != null){
            tripDto.setDestStop(trip.getDestStop());
        }
        if (trip.getSourceStop() != null){
            tripDto.setSourceStop(trip.getSourceStop());
        }
        if (trip.getBus() != null){
            tripDto.setBus(busToDto(trip.getBus()));
        }
        if (trip.getAgency() != null){
            tripDto.setAgency(agencyDtoMap(trip.getAgency()));
        }


        return tripDto;
    }

    public static TripScheduleDto tripScheduleToDto(TripSchedule tripSchedule){
        TripScheduleDto tripScheduleDto = new TripScheduleDto();
        tripScheduleDto.setId(tripSchedule.getId());
        tripScheduleDto.setTripDate(tripSchedule.getTripDate());
        tripScheduleDto.setAvailableSeats(tripSchedule.getAvailableSeats());

        if (tripSchedule.getTripDetail() != null){
            tripScheduleDto.setTripDetail(tripToDto(tripSchedule.getTripDetail()));
        }
        if (tripSchedule.getTicketsSold() != null) {
            Set<Ticket> tickets = tripSchedule.getTicketsSold();
            Set<TicketMapDto> ticketDTOs = tickets.stream()
                    .map(a -> ticketToDto(a))
                    .collect(Collectors.toSet());
            tripScheduleDto.setTicketsSold(ticketDTOs);
        }

        if (tripSchedule.getTickets() != null) {
            List<Ticket> tickets = tripSchedule.getTickets();

            List<TicketMapDto> ticketMapDtoList = tickets.stream()
                    .filter(b-> b.getPassenger() == null)
                    .map(a -> ticketToDto(a))
                    .collect(Collectors.toList());
            tripScheduleDto.setTickets(ticketMapDtoList);
        }

        return  tripScheduleDto;

    }

    public static UserDto usetDtoMap(UserList userList){
        UserDto userDto = new UserDto();
        userDto.setEmail(userList.getEmail());
        userDto.setFirstName(userList.getFirstName());
        userDto.setLastName(userList.getLastName());
        userDto.setMobileNumber(userList.getMobileNumber());
        return userDto;
    }

    public static UserList userDtoToEntity(UserUpdateDto userUpdateDto){
        UserList userList = new UserList();
        userList.setId(userUpdateDto.getId());
        userList.setPassword(userUpdateDto.getPassword());
        userList.setEmail(userUpdateDto.getEmail());
        userList.setFirstName(userUpdateDto.getFirstName());
        userList.setLastName(userUpdateDto.getLastName());
        userList.setMobileNumber(userUpdateDto.getMobileNumber());
        userList.setRole(userUpdateDto.getRoles());
        return userList;
    }
    public static UserUpdateDto userEmtityToDto(UserList userList){
        UserUpdateDto userUpdateDto = new UserUpdateDto();
        userUpdateDto.setId(userList.getId());
        userUpdateDto.setPassword(userList.getPassword());
        userUpdateDto.setEmail(userList.getEmail());
        userUpdateDto.setFirstName(userList.getFirstName());
        userUpdateDto.setLastName(userList.getLastName());
        userUpdateDto.setMobileNumber(userList.getMobileNumber());
        userUpdateDto.setRoles(userList.getRole());
        return userUpdateDto;
    }



}
