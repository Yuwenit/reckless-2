package reckless02.app.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reckless02.app.model.Pic;
import reckless02.app.model.PicRepository;

@Service
public class AppServiceImpl implements AppService {
	
	PicRepository picRepository;
	
	@Autowired
	public AppServiceImpl(PicRepository thePicRepository) {
		picRepository = thePicRepository;
	}
	
	@Override
	public List<Pic> getAllPicList() {
		System.out.println("AppServiceImpl List findAll()");
		return picRepository.findAll();
	}

	@Override
	public void save(Pic thePicture) {
		picRepository.save(thePicture);
		System.out.println("AppServiceImpl save"+thePicture);
	}

	@Override
	public Pic findById(int theId) {
		Optional<Pic> result = picRepository.findById(theId);
		Pic thePicture = null;
		if(result.isPresent()) {
			thePicture=result.get();
		}else {
			throw new RuntimeException("No pic id:"+theId);
		}
		System.out.println("AppleServiceImpl findbyId:"+theId);
		return thePicture;
	}

	@Override
	public void deletebyId(int theId) {
		picRepository.deleteById(theId);
		System.out.println("AppleServiceImpl deletebyId:"+theId);
	}
	
	public Optional<Pic> findPicById(int id){
		System.out.println("AppServiceImpl Optional<Pic> findPicById"+id);
		return picRepository.findById(id);
	}
	
}
