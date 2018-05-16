package com.facishare.common.unittest.fcp.arg;

import io.protostuff.Tag;
import lombok.Data;

/**
 * Created by wujp@fxiaoke.com on 16/8/24.
 */
@Data
public class FindDataArg {
    @Tag(1)
    private String dataId;
}
