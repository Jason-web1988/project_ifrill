package project_ifrill.mapper;

import java.util.ArrayList;

import project_ifrill.dto.Address;

public interface AddressMapper {
    ArrayList<Address> selectAddressByDong(String dong);
}
