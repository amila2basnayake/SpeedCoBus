package com.abccompany.speedcobussystem.service;

import com.abccompany.speedcobussystem.model.Bus;
import com.abccompany.speedcobussystem.repository.BusRepository;
import com.abccompany.speedcobussystem.exception.BusException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BusService {

    public final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public Bus getBus(Long id)  {
        return busRepository.findById(id).orElseThrow(()-> new BusException(id));
    }

    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }
    public Bus removeBusById(Long busId)  {
        Bus bus = getBus(busId);
        busRepository.delete(bus);
        return bus;
    }

    public Bus removeBusByCode(String code) {
        Bus bus = findBusByCode(code);
        busRepository.delete(bus);
        return bus;
    }

    public Bus findBusByCode(String code) {
        return busRepository.findBusByCode(code);
    }
}
