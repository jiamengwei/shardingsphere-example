package data.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import data.sharding.entity.TOrder;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author JiaMengwei
 * @since 2021-03-31
 */
public interface TOrderMapper extends BaseMapper<TOrder> {

    @Select("select * from t_order o inner join t_order_item oi on oi.order_id = o.order_id  where  o.order_id in (9, 10)")
    List<TOrder> queryOrderJoinItem();
}
