package data.sharding;

import com.google.common.collect.Range;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class RangeShardingDateStrategy implements RangeShardingAlgorithm<Timestamp> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Timestamp> rangeShardingValue) {
        String logicTableName = rangeShardingValue.getLogicTableName();
        Range<Timestamp> valueRange = rangeShardingValue.getValueRange();
        Timestamp upperEndpoint = valueRange.upperEndpoint();
        Timestamp lowerEndpoint = valueRange.lowerEndpoint();
        int upperMonth = upperEndpoint.toLocalDateTime().getMonthValue();
        int lowerMonth = lowerEndpoint.toLocalDateTime().getMonthValue();
        List<String> actualTableList = IntStream.rangeClosed(lowerMonth, upperMonth).mapToObj(i-> logicTableName+i).collect(Collectors.toList());
        log.info("逻辑表：{}，范围分表结果：{}",logicTableName, actualTableList);
        return actualTableList;
    }
}
