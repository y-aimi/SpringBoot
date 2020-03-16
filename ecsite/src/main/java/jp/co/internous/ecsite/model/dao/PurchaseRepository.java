package jp.co.internous.ecsite.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.internous.ecsite.model.entity.Purchase;
//今回は別にいらない
//@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
	//最後の取引の時間を取得し、IdがpurchaseのIDと一致しているかの確認をしている
	//@Query+nativeQuery=trueでSQL文がそのまま使えるようになる。SELECT MAX(created_at)で最後の取引時刻を取得。

	@Query(value="SELECT * FROM purchase p WHERE created_at = (SELECT MAX(created_at) FROM purchase p WHERE p.user_id = :userId)",
			nativeQuery=true)
	List<Purchase> findHistory(@Param("userId") long userId);
	
	//now()で現在時刻(created_at)を登録している。
	@Query(value="INSERT INTO purchase (user_id, goods_id, goods_name,item_count,total,created_at)" +
				"VALUES (?1,?2,?3,?4,?5,now())",nativeQuery=true)
	@Transactional
	//@Modifyingは更新するメソッドに付けておかないとエラーになる。
	@Modifying
	void persist(@Param("userId") long userId,
				 @Param("goodsId") long productId,
				 @Param("goodsName") String goodsName,
				 @Param("itemCount") long itemCount,
				 @Param("total") long total);
	
	
}
