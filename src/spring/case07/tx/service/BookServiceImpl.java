package com.study.spring.case07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.spring.case07.tx.dao.BookDao;
import com.study.spring.case07.tx.exception.InsufficientAmount;
import com.study.spring.case07.tx.exception.InsufficientQuantity;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	@Transactional(
			propagation = Propagation.REQUIRES_NEW,
			rollbackFor = {InsufficientAmount.class, InsufficientQuantity.class} // 錢不夠不能交易
			//noRollbackFor = {InsufficientQuantity.class} // 庫存不夠，有庫存的先出，不收沒庫存的錢
	)
	@Override
	public void buyOne(Integer wid, Integer bid) throws InsufficientAmount, InsufficientQuantity {

		// 消耗一本庫存
		bookDao.updateStock(bid, 1);
		// 取得書籍價格
		Integer price = bookDao.getPrice(bid);
		// 減去錢包裡的金額
		bookDao.updateWallet(wid, price);
	}

	@Transactional(propagation = Propagation.REQUIRED,
			rollbackFor = {InsufficientAmount.class, InsufficientQuantity.class}
			)
	@Override
	public void buyMany(Integer wid, Integer... bids) throws InsufficientAmount, InsufficientQuantity {
		for (Integer bid : bids) {
			buyOne(wid, bid);
		}
	}
}