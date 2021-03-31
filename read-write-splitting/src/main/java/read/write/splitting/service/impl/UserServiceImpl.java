package read.write.splitting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import read.write.splitting.entity.User;
import read.write.splitting.mapper.UserMapper;
import read.write.splitting.service.IUserService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author JiaMengwei
 * @since 2021-03-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
