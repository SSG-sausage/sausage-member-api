package com.ssg.sausagememberapi.member.repository;

import com.ssg.sausagememberapi.member.entity.Mbr;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MbrRepository extends JpaRepository<Mbr, Long> {

    Optional<Mbr> findMbrByMbrLoginId(String mbrLoginId);

}
