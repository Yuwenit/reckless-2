package reckless02.app.service;

import java.util.List;

import reckless02.app.model.Pic;

public interface AppService {

	List<Pic> getAllPicList();
	
	public void save(Pic thePicture);
	
	public Pic findById(int theId);
}
