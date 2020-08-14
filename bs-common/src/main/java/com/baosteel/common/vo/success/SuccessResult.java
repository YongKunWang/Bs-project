package com.baosteel.common.vo.success;

import com.baosteel.common.vo.Meta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccessResult <T> {
    private Meta meta;
    private T data;

}
