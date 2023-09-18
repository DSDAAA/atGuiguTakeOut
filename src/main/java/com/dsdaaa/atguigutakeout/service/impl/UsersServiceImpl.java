package com.dsdaaa.atguigutakeout.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dsdaaa.atguigutakeout.domain.Users;
import com.dsdaaa.atguigutakeout.mapper.UsersMapper;
import com.dsdaaa.atguigutakeout.service.UsersService;
import org.springframework.stereotype.Service;

/**
* @author 13180
* @description 针对表【users】的数据库操作Service实现
* @createDate 2023-09-18 14:43:13
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService {

}




