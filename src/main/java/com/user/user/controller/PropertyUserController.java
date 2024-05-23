package com.user.user.controller;
import com.user.user.Service.PropertyUser;
import com.user.user.dto.PropertyUserDto;
import com.user.user.entity.PropertyUserEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Rest Api class
@RequestMapping("/api/v1/propertyUser")
public class PropertyUserController {

    private PropertyUser pu;

    public PropertyUserController(PropertyUser pu) {
        this.pu = pu;
    }
    //http://localhost:8080/api/v1/propertyUser/addPropertyUser

    @PostMapping("/addPropertyUser")
    public ResponseEntity<?> addPropertyUser(
            @Valid @RequestBody PropertyUserDto dto,
            BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.OK);
        }
        PropertyUserDto propertyUserDto = pu.addPropertyUser(dto);
        return new ResponseEntity<>(propertyUserDto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePropertyUser(
            @RequestParam long propertyUserId) {
        pu.deletePropertyUser(propertyUserId);
        return new ResponseEntity<>("Record Deleted", HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/propertyUser/1
    @PutMapping("/{propertyUserId}")
    public ResponseEntity<PropertyUserEntity> updatePropertyUser(
            @PathVariable long propertyUserId,
            @RequestBody PropertyUserDto dto
    ) {
        PropertyUserEntity propertyUserEntity = pu.updatePropertyUser(propertyUserId, dto);
        return new ResponseEntity<>(propertyUserEntity, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PropertyUserEntity>> getPropertyUser() {
        List<PropertyUserEntity> propertyUserEntities = pu.getPropertyUsers();
        return new ResponseEntity<>(propertyUserEntities, HttpStatus.OK);
    }
   @GetMapping("/{getUserById}")
    public ResponseEntity<PropertyUserEntity>getPropertyById(@RequestParam long propertyUserId) {
       PropertyUserEntity propertyById = pu.getPropertyById(propertyUserId);
       return new ResponseEntity<>(propertyById, HttpStatus.OK);
    }
}

