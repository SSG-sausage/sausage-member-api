package com.ssg.sausagememberapi.common.exception;

import static com.ssg.sausagememberapi.common.exception.ErrorStatusCode.BAD_GATEWAY;
import static com.ssg.sausagememberapi.common.exception.ErrorStatusCode.BAD_REQUEST;
import static com.ssg.sausagememberapi.common.exception.ErrorStatusCode.CONFLICT;
import static com.ssg.sausagememberapi.common.exception.ErrorStatusCode.FORBIDDEN;
import static com.ssg.sausagememberapi.common.exception.ErrorStatusCode.INTERNAL_SERVER;
import static com.ssg.sausagememberapi.common.exception.ErrorStatusCode.NOT_FOUND;
import static com.ssg.sausagememberapi.common.exception.ErrorStatusCode.SERVICE_UNAVAILABLE;
import static com.ssg.sausagememberapi.common.exception.ErrorStatusCode.UNAUTHORIZED;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

    /**
     * 400 Bad Request
     */
    VALIDATION_EXCEPTION(BAD_REQUEST, "잘못된 요청입니다."),
    VALIDATION_ENUM_VALUE_EXCEPTION(BAD_REQUEST, "잘못된 Enum 값 입니다."),
    VALIDATION_REQUEST_MISSING_EXCEPTION(BAD_REQUEST, "필수적인 요청 값이 입력되지 않았습니다."),
    VALIDATION_WRONG_TYPE_EXCEPTION(BAD_REQUEST, "잘못된 타입이 입력되었습니다."),

    /**
     * 401 UnAuthorized
     */
    UNAUTHORIZED_EXCEPTION(UNAUTHORIZED, "토큰이 만료되었습니다. 다시 로그인 해주세요."),
    UNAUTHORIZED_INVALID_PWD_EXCEPTION(UNAUTHORIZED, "비밀번호 오류입니다."),

    /**
     * 403 Forbidden
     */
    FORBIDDEN_EXCEPTION(FORBIDDEN, "허용하지 않는 요청입니다."),

    /**
     * 404 Not Found
     */
    NOT_FOUND_EXCEPTION(NOT_FOUND, "존재하지 않습니다."),
    NOT_FOUND_USER_EXCEPTION(NOT_FOUND, "탈퇴했거나 존재하지 않는 유저입니다."),

    /**
     * 409 Conflict
     */
    CONFLICT_EXCEPTION(CONFLICT, "이미 존재합니다."),

    /**
     * 500 Internal Server Exception
     */
    INTERNAL_SERVER_EXCEPTION(INTERNAL_SERVER, "예상치 못한 서버 에러가 발생하였습니다."),

    /**
     * 502 Bad Gateway
     */
    BAD_GATEWAY_EXCEPTION(BAD_GATEWAY, "일시적인 에러가 발생하였습니다.\n잠시 후 다시 시도해주세요!"),

    /**
     * 503 Service UnAvailable
     */
    SERVICE_UNAVAILABLE_EXCEPTION(SERVICE_UNAVAILABLE, "현재 점검 중입니다.\n잠시 후 다시 시도해주세요!"),
    ;

    private final ErrorStatusCode statusCode;
    private final String message;

    public int getStatus() {
        return statusCode.getStatus();
    }
}
