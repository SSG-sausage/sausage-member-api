package com.ssg.sausagememberapi.member.dto.response;

import com.ssg.sausagememberapi.member.entity.Mbr;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class MbrFindListResponse {

    private HashMap<Long, MbrInfo> mbrMap;

    public static MbrFindListResponse of(List<Mbr> mbrList) {

        return MbrFindListResponse
                .builder()
                .mbrMap((HashMap<Long, MbrInfo>) mbrList.stream().collect(Collectors.toMap(Mbr::getId, MbrInfo::of)))
                .build();

    }
}
