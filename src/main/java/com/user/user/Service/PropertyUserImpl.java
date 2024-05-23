package com.user.user.Service;
import com.user.user.dto.PropertyUserDto;
import com.user.user.entity.PropertyUserEntity;
import com.user.user.exception.ResourceNotFoundException;
import com.user.user.repository.PropertyUserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyUserImpl implements PropertyUser{

    private PropertyUserRepository propertyUserRepository ;

    public PropertyUserImpl(PropertyUserRepository propertyUserRepository) {
        this.propertyUserRepository = propertyUserRepository;
    }

    @Override
    public PropertyUserDto addPropertyUser(PropertyUserDto dto) {
        PropertyUserEntity entity=new PropertyUserEntity();
        entity.setName(dto.getName());
        entity.setMobile(dto.getMobile());
        entity.setEmailId(dto.getEmailId());
        PropertyUserEntity savedPropertyUser = propertyUserRepository.save(entity);
       PropertyUserDto puo=new PropertyUserDto();
          puo.setId(savedPropertyUser.getId());
          puo.setName(savedPropertyUser.getName());
          puo.setMobile(savedPropertyUser.getMobile());
          puo.setEmailId(savedPropertyUser.getEmailId());
          puo.setDate(new Date() );
          return puo;
    }

    @Override
    public void deletePropertyUser(long propertyUserId) {
        propertyUserRepository.deleteById(propertyUserId);
    }

    @Override
    public PropertyUserEntity updatePropertyUser(
            long propertyUserId,
           PropertyUserDto dto) {
        Optional<PropertyUserEntity> byId = propertyUserRepository.findById(propertyUserId);
        PropertyUserEntity propertyUserEntity = byId.get();
        propertyUserEntity.setName(dto.getName());
        propertyUserEntity.setMobile(dto.getMobile());
        propertyUserEntity.setEmailId(dto.getEmailId());
        return propertyUserRepository.save(propertyUserEntity);
    }

    @Override
    public List<PropertyUserEntity> getPropertyUsers() {
      return propertyUserRepository.findAll();
    }

    @Override
    public PropertyUserEntity getPropertyById(long propertyUserId) {
        PropertyUserEntity propertyUserEntity = propertyUserRepository.findById(propertyUserId).orElseThrow(
                ()->new ResourceNotFoundException("User Not Found with id: "+propertyUserId)
        );
        return propertyUserEntity;

    }
}
