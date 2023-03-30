package com.datamanage.datamanage.dao;

/**
 * @author 贾佳
 * @date 2023/3/24 11:55
 */
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datamanage.datamanage.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User findByUsername(String username);

}
