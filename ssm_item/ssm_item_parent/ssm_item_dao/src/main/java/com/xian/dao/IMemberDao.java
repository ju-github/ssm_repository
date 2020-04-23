package com.xian.dao;

import com.xian.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {
    @Select("select * from member where id=#{memberId}")
    public Member findById(String memberId);
}
