package com.Shift.Management.Shift.Management.Services;

import com.Shift.Management.Shift.Management.Dto.DtoShift;
import com.Shift.Management.Shift.Management.Entity.EntityShift;
import com.Shift.Management.Shift.Management.Repository.RepositoryShift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Shiftimplementation implements ServiceShift{

    @Autowired
    private RepositoryShift repositoryShift;

    @Override
    public DtoShift saveshift(DtoShift dtoShift) {

        EntityShift entityShift=new EntityShift(
                dtoShift.getId(),
                dtoShift.getStaffName(),
                dtoShift.getDate(),
                dtoShift.getTime()
        );
        EntityShift entityShift1=repositoryShift.save(entityShift);
        DtoShift dtoShift1=new DtoShift(
                entityShift1.getId(),
                entityShift1.getStaffName(),
                entityShift1.getDate(),
                entityShift1.getTime()
        );
        return dtoShift1;
    }
}
