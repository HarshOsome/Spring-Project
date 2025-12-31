package com.example.UserMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UserMgmt.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>
{

}
