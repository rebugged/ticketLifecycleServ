package com.ticketsystem.ticketLifecycleServ.repository;

import com.ticketsystem.ticketLifecycleServ.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {


    @Query(value = "select r.role_name from role r join user_role ur on r.role_id = ur.role_id where user_id = ?1", nativeQuery = true)
    List<String> getRolesOfUser(String username);

}
