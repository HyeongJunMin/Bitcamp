package bit.com.a.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BitYoutubeDao;

@Repository
public class BitYoutubeDaoImpl implements BitYoutubeDao{
	@Autowired
	private SqlSession sqlSession;
}
