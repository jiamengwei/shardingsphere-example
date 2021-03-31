package data.sharding.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author JiaMengwei
 * @since 2021-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer orderId;

    private Integer userId;

    private String name;


}
