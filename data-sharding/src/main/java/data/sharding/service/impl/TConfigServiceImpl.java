package data.sharding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import data.sharding.entity.TConfig;
import data.sharding.mapper.TConfigMapper;
import data.sharding.service.ITConfigService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JiaMengwei
 * @since 2021-03-31
 */
@Service
public class TConfigServiceImpl extends ServiceImpl<TConfigMapper, TConfig> implements ITConfigService {

}
