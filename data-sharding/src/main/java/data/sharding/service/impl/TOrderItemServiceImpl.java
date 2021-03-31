package data.sharding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import data.sharding.entity.TOrderItem;
import data.sharding.mapper.TOrderItemMapper;
import data.sharding.service.ITOrderItemService;
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
public class TOrderItemServiceImpl extends ServiceImpl<TOrderItemMapper, TOrderItem> implements ITOrderItemService {

}
