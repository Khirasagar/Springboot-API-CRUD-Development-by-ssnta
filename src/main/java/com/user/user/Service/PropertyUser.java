package com.user.user.Service;

import com.user.user.dto.PropertyUserDto;
import com.user.user.entity.PropertyUserEntity;

import java.util.List;

public interface PropertyUser {
    public PropertyUserDto addPropertyUser(PropertyUserDto dto);
    void deletePropertyUser(long propertyUserId);
    PropertyUserEntity updatePropertyUser(long propertyUserId,PropertyUserDto dto);

    List<PropertyUserEntity> getPropertyUsers ();
    PropertyUserEntity getPropertyById(long propertyUserId);
}
