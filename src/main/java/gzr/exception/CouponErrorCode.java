package gzr.exception;

import lombok.AllArgsConstructor;

/**
 * 枚举类不可以继承，但是可以实现接口
 *
 * @author zengrong.gzr
 * @date 2017/12/25
 */
@AllArgsConstructor
public enum CouponErrorCode implements ErrorCode {
    PARAM_ERROR("PARAM_ERROR", "参数错误");

    private String code;

    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return message;
    }
}
