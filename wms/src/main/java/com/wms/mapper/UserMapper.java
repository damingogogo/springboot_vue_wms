package com.wms.mapper;

import com.wms.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dengzhouming
 * @since 2023-09-03
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
