package com.userpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userpost.model.Geo;

public interface GeoRepository extends JpaRepository<Geo, String> {

}
