package data.sharding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import data.sharding.entity.TOrder;
import data.sharding.mapper.TOrderMapper;
import data.sharding.service.ITOrderService;
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
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

}
