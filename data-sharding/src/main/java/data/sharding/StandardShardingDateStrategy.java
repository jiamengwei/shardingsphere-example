package data.sharding;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * 按时间分表
 *
 */
@Slf4j
public class StandardShardingDateStrategy implements PreciseShardingAlgorithm {

    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        String logicTableName = preciseShardingValue.getLogicTableName();
        Comparable value = preciseShardingValue.getValue();
        LocalDateTime time = null;
        if ( value instanceof LocalDateTime){
            time = (LocalDateTime) value;
        }else{
            throw new IllegalStateException("checkTime  invalid");
        }
        String actualTableName = logicTableName+time.getMonthValue();
        log.info("列名：{}， 值：{}，分表结果：{}", preciseShardingValue.getColumnName(), value, actualTableName);
        return actualTableName;
    }
}
