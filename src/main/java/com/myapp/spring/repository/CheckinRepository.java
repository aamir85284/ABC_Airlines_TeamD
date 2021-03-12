package com.myapp.spring.repository;

import com.myapp.spring.model.Checkin;

public interface CheckinRepository {

	Checkin findById(Integer id);

}
