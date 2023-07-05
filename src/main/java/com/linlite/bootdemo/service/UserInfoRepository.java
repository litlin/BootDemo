package com.linlite.bootdemo.service;

import com.linlite.bootdemo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    @Query(value = "select u from UserInfo u where u.name =?1")
    UserInfo selectByName(String str);
}
