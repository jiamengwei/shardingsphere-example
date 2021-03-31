package sharding.jdbc.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import sharding.jdbc.example.entity.User;
import sharding.jdbc.example.mapper.UserMapper;
import sharding.jdbc.example.service.IUserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JiaMengwei
 * @since 2021-03-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
