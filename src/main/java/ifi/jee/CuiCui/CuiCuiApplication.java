package ifi.jee.CuiCui;

import ifi.jee.CuiCui.metier.IUserMetier;
import ifi.jee.CuiCui.model.Hashtag;
import ifi.jee.CuiCui.model.Message;
import ifi.jee.CuiCui.model.User;
import ifi.jee.CuiCui.repository.HashtagRepository;
import ifi.jee.CuiCui.repository.MessageRepository;
import ifi.jee.CuiCui.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class CuiCuiApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private HashtagRepository hashtagRepository;

	@Autowired
	private IUserMetier userMetier;

	public static void main(String[] args) {
		SpringApplication.run(CuiCuiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Hashtag h1=hashtagRepository.save(new Hashtag("#cool"));
		Hashtag h2=hashtagRepository.save(new Hashtag("#weekend"));
		Hashtag h3=hashtagRepository.save(new Hashtag("#sleep"));

		User user2=userRepository.save(new User("marc","marc1","marc"));
		User user3=userRepository.save(new User("sonia","sonia","sonia"));
		User user1=userRepository.save(new User("ahmed","ahmed","ahmed",Arrays.asList(user3,user2),Arrays.asList(h1,h2)));

		Message m1=messageRepository.save(new Message(new Date(),"Coucou, quel journé agreable #cool @marc",user1));
		Message m2=messageRepository.save(new Message(new Date(),"La vie est belle",user1));
		Message m3=messageRepository.save(new Message(new Date(),"Aujourd'hui, je vais reviser sans musique :)",user1));
		Message m4=messageRepository.save(new Message(new Date(),"je me suis reveiller à 14h #sleep",user1));
		Message m5=messageRepository.save(new Message(new Date(),"Coucou @ahmed,tu viens jouer au foot #foot #weekend",user1));

		userMetier.creerUser("jack","jack","jack");
		userMetier.ajouterMessage(new Date(),"Allez la france,la coupe est à nous #foot #coupeDuMonde2018",user1);
		userMetier.listUsers(1,10);
		Page<Message> pageMessage=userMetier.listMessages(3,1,10);
		System.out.println("nbPage="+pageMessage.getSize());
	}
}
