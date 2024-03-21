package com.hotel.demo.persistence;

import com.hotel.demo.model.ClientPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPreferencesRepository extends JpaRepository<ClientPreferences, Long> {
}
