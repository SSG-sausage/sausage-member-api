package com.ssg.sausagememberapi.member.service;

import com.ssg.sausagememberapi.member.dto.request.MbrLonginRequest;
import com.ssg.sausagememberapi.member.dto.response.MbrFindResponse;
import com.ssg.sausagememberapi.member.dto.response.MbrLoginResponse;
import com.ssg.sausagememberapi.member.entity.Mbr;
import com.ssg.sausagememberapi.member.repository.MbrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MbrService {

    private final MbrRepository mbrRepository;

    private final MbrServiceUtils mbrServiceUtils;

    public MbrFindResponse findMbrById(Long memberId) {

        Mbr mbr = mbrServiceUtils.findMbrById(memberId);

        return MbrFindResponse.of(mbr);
    }

    public MbrLoginResponse login(MbrLonginRequest request) {

        Mbr mbr = mbrServiceUtils.findMbrByMbrLoginId(request);

        mbrServiceUtils.checkLoginPwd(mbr, request);

        return MbrLoginResponse.of(mbr);
    }
}
