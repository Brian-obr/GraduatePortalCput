package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private AddressRepository repository;

    @Override
    public Address create(Address address) {
        return repository.save(address);
    }

    @Override
    public Address read(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Address update(Address address) {
        if (repository.existsById(address.getAddressId())) {
            return repository.save(address);
        }
        return null;
    }
    @Override
    public List<Address> getAll() {
        return repository.findAll();
    }
}

