package com.example.LoginRegisterEmail.services;

import com.example.LoginRegisterEmail.dto.LocationDto;
import com.example.LoginRegisterEmail.entities.Location;
import com.example.LoginRegisterEmail.repoistory.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public LocationDto createLocation(LocationDto locationDto) {
        Location location = new Location();
        location.setCity(locationDto.getCity());
        location.setLongitude(locationDto.getLongitude());
        location.setLatitude(locationDto.getLatitude());
        Location savedLocation = locationRepository.save(location);
        return mapToDto(savedLocation);
    }

    public LocationDto getLocationById(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Location not found with id: " + id));
        return mapToDto(location);
    }

    public List<LocationDto> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public LocationDto updateLocation(Long id, LocationDto locationDto) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Location not found with id: " + id));
        location.setCity(locationDto.getCity());
        location.setLongitude(locationDto.getLongitude());
        location.setLatitude(locationDto.getLatitude());
        Location updatedLocation = locationRepository.save(location);
        return mapToDto(updatedLocation);
    }

    public boolean deleteLocation(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Location not found with id: " + id));
        locationRepository.delete(location);
        return true;
    }

    private LocationDto mapToDto(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setId(location.getId());
        locationDto.setCity(location.getCity());
        locationDto.setLongitude(location.getLongitude());
        locationDto.setLatitude(location.getLatitude());
        return locationDto;
    }
}
