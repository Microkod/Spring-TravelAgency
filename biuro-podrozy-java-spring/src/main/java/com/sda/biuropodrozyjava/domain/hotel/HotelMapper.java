package com.sda.biuropodrozyjava.domain.hotel;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelMapper {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    HotelDTO toDTO(Hotel hotel);

    Hotel toEntity(HotelDTO hotelDTO);

}
