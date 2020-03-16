package jp.co.internous.ecsite.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.internous.ecsite.model.entity.Goods;
//@RepositoryしたものをindexControlの@Autowiredでインスタンス化する
@Repository
//JpaRepositoryでデータベース検索をしてそれを継承している
public interface GoodsRepository extends JpaRepository<Goods, Long> {

}

//JpaRepositoryを継承する事で、fineOne、findAll、save、deleteの4メソッドが使用

