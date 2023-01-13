package com.ssg.sausagememberapi.member.dto.response;

import com.ssg.sausagememberapi.member.entity.Mbr;
import java.util.Collections;
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

    private List<MbrInfo> mbrList = Collections.emptyList();

    public static MbrFindListResponse of(List<Mbr> mbrList) {

        return MbrFindListResponse
                .builder()
                .mbrList(mbrList.stream().map(MbrInfo::of).collect(Collectors.toList()))
                .build();
    }
}
