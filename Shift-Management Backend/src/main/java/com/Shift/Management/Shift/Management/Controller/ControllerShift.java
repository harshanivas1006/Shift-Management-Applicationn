package com.Shift.Management.Shift.Management.Controller;

import com.Shift.Management.Shift.Management.Dto.DtoShift;
import com.Shift.Management.Shift.Management.Services.Shiftimplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shift")
public class ControllerShift {

    @Autowired
    private Shiftimplementation shiftimplementation;

    @PostMapping("/saveshift")
   public ResponseEntity<DtoShift> saveshift(@RequestBody DtoShift dtoShift){
        DtoShift dtoShift1=shiftimplementation.saveshift(dtoShift);
        return new ResponseEntity<>(dtoShift1,HttpStatus.CREATED);
    }
}
