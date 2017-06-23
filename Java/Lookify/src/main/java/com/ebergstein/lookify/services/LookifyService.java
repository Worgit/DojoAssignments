package com.ebergstein.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ebergstein.lookify.models.Song;
import com.ebergstein.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private LookifyRepository lookifyRepository;
	
	public LookifyService (LookifyRepository lookifyRepository){
		this.lookifyRepository = lookifyRepository;
	}
	
	public List<Song> allSongs(){
		return (List<Song>) lookifyRepository.findAll();
	}
	
	public List<Song> findSongsByArtist(String artist){
		return (List<Song>) lookifyRepository.findByArtist(artist);
	}
	
	public List<Song> findTop10ByOrderByRatingDesc(){
		return (List<Song>) lookifyRepository.findTop10ByOrderByRatingDesc();
	}
	
	public Song findSongById(Long id){
		return (Song) lookifyRepository.findOne(id);
	}
	
	public void addSong(Song song){
		lookifyRepository.save(song);
	}
	
	public void destroySong(Long id){
		lookifyRepository.delete(id);
	}
}
