package com.wms.service.impl;

import com.wms.entity.User;
import com.wms.mapper.UserMapper;
import com.wms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dengzhouming
 * @since 2023-09-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
