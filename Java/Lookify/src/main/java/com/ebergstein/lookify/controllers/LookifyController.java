package com.ebergstein.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ebergstein.lookify.models.Song;
import com.ebergstein.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService lookifyService;
	
	public LookifyController(LookifyService lookifyService){
		this.lookifyService = lookifyService;
	}
	
	@RequestMapping("/")
    public String welcome() {
        return "index.jsp";
    }
	
    @RequestMapping("/dashboard")
    public String songs(Model model, @ModelAttribute("song") Song song) {
        List<Song> songs = lookifyService.allSongs();
        model.addAttribute("songs", songs);
        return "dashboard.jsp";
    }
    
    @RequestMapping("/songs/top")
    public String findTop10Songs(Model model, @ModelAttribute("song") Song song) {
    	List<Song> songs = lookifyService.findTop10ByOrderByRatingDesc();
    	model.addAttribute("songs", songs);
        return "topSongs.jsp";
    }
    
    @RequestMapping("/search")
    public String findSongsByArtist(Model model, @RequestParam(value="name") String artist) {
    	List<Song> songs = lookifyService.findSongsByArtist(artist);
    	model.addAttribute("songs", songs);
    	model.addAttribute("name", artist);
        return "Search.jsp";
    }
    
    @RequestMapping("/songs/{id}")
    public String findSongById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("song", lookifyService.findSongById(id));
        return "Song.jsp";
    }
    
    @RequestMapping("/songs/new")
    public String newBook(@ModelAttribute("song") Song song) {
        return "newSong.jsp";
    }
    
    @PostMapping("/songs/new")
    public String createSong(
            @Valid Song song,
            BindingResult result, 
            RedirectAttributes redirectAttributes,
            Model model) {
        if (result.hasErrors()) {
        	return "newSong.jsp";
        }else{
        	lookifyService.addSong(song);
            return "redirect:/dashboard";
        }
    }
    
    @RequestMapping("/songs/delete/{id}")
    public String destroySong(@PathVariable("id") Long id) {
        lookifyService.destroySong(id);
        return "redirect:/dashboard";
    }
}
