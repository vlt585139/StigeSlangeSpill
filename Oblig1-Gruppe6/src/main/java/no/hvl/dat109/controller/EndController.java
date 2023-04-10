package no.hvl.dat109.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import no.hvl.dat109.service.StartupUtility;

/**
 * Controller for end screen
 * 
 *
 */
@Controller
@RequestMapping("/gameover")
public class EndController {
	
	@Autowired
	private StartupUtility startupUtil;

	/**
	 * Method to show the end screen
	 * 
	 * Shows which player won the game
	 * 
	 * @param session - Current session
	 * 
	 * @return jsp view of end screen
	 */
	@GetMapping
	public String showEndScreen(HttpServletRequest request) {
		
		if (!startupUtil.gameIsActive(request.getSession())) {
			return "redirect:start";
		}
		
		return "endView";
	}

	/**
	 * Method to send you back to the start screen
	 * 
	 * @return redirect to StartController
	 */
	@PostMapping
	public String playAgain() {
		return "redirect:start";
	}

}
