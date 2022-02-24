package reckless02.app.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reckless02.app.model.Pic;

@Repository
public interface PicRepository extends JpaRepository<Pic, Integer>{
	//Syntax error, insert "Dimensions" to complete ReferenceType
	//是泛型必须是类类型，而不能是基本类型（包括基本类型的数组）
}
