package com.Shift.Management.Shift.Management.Repository;

import com.Shift.Management.Shift.Management.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
