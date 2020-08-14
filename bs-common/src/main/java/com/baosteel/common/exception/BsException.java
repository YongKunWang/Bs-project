package com.baosteel.common.exception;

import com.baosteel.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BsException extends RuntimeException {
    private ExceptionEnum exceptionEnum;
}
