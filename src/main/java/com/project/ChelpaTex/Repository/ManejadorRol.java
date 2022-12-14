package com.project.ChelpaTex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ChelpaTex.Entity.Rol;


@Repository
public interface ManejadorRol extends JpaRepository<Rol, Long> {

}
