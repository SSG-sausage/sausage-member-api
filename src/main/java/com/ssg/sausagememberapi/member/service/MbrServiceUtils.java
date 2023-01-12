package com.ssg.sausagememberapi.member.service;

import com.ssg.sausagememberapi.common.exception.ErrorCode;
import com.ssg.sausagememberapi.common.exception.NotFoundException;
import com.ssg.sausagememberapi.common.exception.UnAuthorizedException;
import com.ssg.sausagememberapi.member.dto.request.MbrLonginRequest;
import com.ssg.sausagememberapi.member.entity.Mbr;
import com.ssg.sausagememberapi.member.repository.MbrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MbrServiceUtils {

    private final MbrRepository mbrRepository;

    public Mbr findMbrById(Long mbrId) {
        return mbrRepository.findById(mbrId).orElseThrow(() -> {
            throw new NotFoundException(String.format("존재하지 않는 멤버 (%s) 입니다", mbrId),
                    ErrorCode.NOT_FOUND_USER_EXCEPTION);
        });
    }

    public Mbr findMbrByMbrLoginId(MbrLonginRequest request) {
        return mbrRepository.findMbrByMbrLoginId(request.getMbrLoginId())
                .orElseThrow(() -> {
                    throw new NotFoundException(String.format("존재하지 않는 멤버 로그인 ID (%s) 입니다", request.getMbrLoginId()),
                            ErrorCode.NOT_FOUND_USER_EXCEPTION);
                });
    }

    public void checkLoginPwd(Mbr mbr, MbrLonginRequest request) {

        if (!mbr.getMbrPwd().equals(request.getMbrPwd())) {
            throw new UnAuthorizedException(String.format("멤버 (%s) 비밀번호 불일치 로그인 실패입니다. ", request.getMbrLoginId()),
                    ErrorCode.UNAUTHORIZED_INVALID_PWD_EXCEPTION);
        }
    }
}
