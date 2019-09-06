package bit.com.a.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BitYoutubeDao;
import bit.com.a.service.BitYoutubeService;

@Service
public class BitYoutubeServiceImpl implements BitYoutubeService{
	@Autowired
	private BitYoutubeDao bitYoutubeDao;
}
