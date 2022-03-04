package reckless02.app.service;

import java.util.List;
import java.util.Optional;

import reckless02.app.model.Pic;

public interface AppService {

	List<Pic> getAllPicList();
	
	public void save(Pic thePicture);
	
	public Pic findById(int theId);

	public void deletebyId(int theId);
	
	public Optional<Pic> findPicById(int id);
}
