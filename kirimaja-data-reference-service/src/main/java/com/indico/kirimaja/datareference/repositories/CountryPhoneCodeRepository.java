package com.indico.kirimaja.datareference.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indico.kirimaja.datareference.entity.CountryPhoneCode;

@Repository
public interface CountryPhoneCodeRepository extends JpaRepository<CountryPhoneCode, String> {

	CountryPhoneCode getByCountryCode(String countryCode);

}
