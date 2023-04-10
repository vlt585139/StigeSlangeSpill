package no.hvl.dat109.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import no.hvl.dat109.service.StartupUtility;

/**
 * 
 * Controller for the start page
 * 
 * Used to choose players and start the game
 *
 */
@Controller
@RequestMapping("/start")
public class StartController {

	@Autowired
	private StartupUtility startupUtil;

	/**
	 * Method that loads the start page
	 * 
	 * @return jsp view
	 */
	@GetMapping
	public String showStartPage() {
		return "startView";
	}

	/**
	 * Method that starts a new game session
	 * 
	 * Uses the input from jsp to select amount of players
	 * 
	 * @param numberOfPlayers - the number of players playing the game
	 * @param request         - HttpServletRequest used to start the new game
	 *                        session
	 * @return redirect to GameController
	 */
	@PostMapping
	public String loadNewGame(@RequestParam int numberOfPlayers, HttpServletRequest request) {

		startupUtil.createGameSession(request, numberOfPlayers);

		return "redirect:game";
	}

}
