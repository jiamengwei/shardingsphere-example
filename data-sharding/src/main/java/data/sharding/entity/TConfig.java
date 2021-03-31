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
public class TConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String value;


}
