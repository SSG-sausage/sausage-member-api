package com.ssg.sausagememberapi.member.service;

import com.ssg.sausagememberapi.member.dto.request.MbrLonginRequest;
import com.ssg.sausagememberapi.member.dto.response.MbrFindListResponse;
import com.ssg.sausagememberapi.member.dto.response.MbrFindResponse;
import com.ssg.sausagememberapi.member.dto.response.MbrLoginResponse;
import com.ssg.sausagememberapi.member.entity.Mbr;
import com.ssg.sausagememberapi.member.repository.MbrRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MbrService {

    private final MbrRepository mbrRepository;

    private final MbrUtilService mbrUtilService;

    public MbrFindResponse findMbr(Long mbrId) {

        Mbr mbr = mbrUtilService.findMbrById(mbrId);

        return MbrFindResponse.of(mbr);
    }

    public MbrFindListResponse findMbrList(List<Long> mbrIdList) {

        List<Mbr> mbrList = mbrRepository.findAllById(mbrIdList);

        return MbrFindListResponse.of(mbrList);
    }

    public MbrLoginResponse login(MbrLonginRequest request) {

        Mbr mbr = mbrUtilService.findMbrByMbrLoginId(request);

        mbrUtilService.checkLoginPwd(mbr, request);

        return MbrLoginResponse.of(mbr);
    }
}
