package com.project.ChelpaTex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ChelpaTex.Entity.UsuarioRol;
import com.project.ChelpaTex.Entity.UsuarioRolPK;


@Repository
public interface ManejadorUsuarioRol extends JpaRepository<UsuarioRol, UsuarioRolPK> {

}
