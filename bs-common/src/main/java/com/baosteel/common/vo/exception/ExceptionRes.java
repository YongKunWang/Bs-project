package com.baosteel.common.vo.exception;

import com.baosteel.common.vo.Meta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionRes {
    private Meta meta;
    private String data;
}

