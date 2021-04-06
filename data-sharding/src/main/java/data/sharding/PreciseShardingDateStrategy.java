package data.sharding;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * 按时间分表
 */
@Slf4j
public class PreciseShardingDateStrategy implements PreciseShardingAlgorithm<LocalDateTime> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<LocalDateTime> preciseShardingValue) {
        String logicTableName = preciseShardingValue.getLogicTableName();
        LocalDateTime time = preciseShardingValue.getValue();

        if (time == null) {
            throw new IllegalStateException("checkTime  invalid");
        }
        String actualTableName = logicTableName + time.getMonthValue();
        log.info("列名：{}， 值：{}，分表结果：{}", preciseShardingValue.getColumnName(), time, actualTableName);
        return actualTableName;
    }
}
