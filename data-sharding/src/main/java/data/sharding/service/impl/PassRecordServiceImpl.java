package data.sharding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import data.sharding.entity.PassRecord;
import data.sharding.mapper.PassRecordMapper;
import data.sharding.service.IPassRecordService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JiaMengwei
 * @since 2021-04-06
 */
@Service
public class PassRecordServiceImpl extends ServiceImpl<PassRecordMapper, PassRecord> implements IPassRecordService {

}
