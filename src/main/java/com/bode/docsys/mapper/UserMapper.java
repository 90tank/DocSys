package com.bode.docsys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bode.docsys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("UserMapper")
public interface UserMapper extends BaseMapper<User> {
}
