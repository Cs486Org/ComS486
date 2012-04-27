package cs486.managers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import cs486.app.MainWindow;
import cs486.dataobjects.PlayerProfile;

public class BFManager {
	private static BFManager instance = null;
	private static MainWindow mainFrame;
	private static ArrayList<PlayerProfile> players;
	private int currentPlayer = 0;
	/* CHANGE THIS IF YOU AREN'T ON LINUX */
	private String fileName = "./players.xml";

	public static void main(String... args) {
		players = BFManager.getInstance().getPlayersFromFile();
		mainFrame = new MainWindow();
		

		mainFrame
				.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public ArrayList<PlayerProfile> getPlayers() {
		return players;
	}

	private ArrayList<PlayerProfile> getPlayersFromFile() {
		if (players != null)
			return players;

		// First create a new XMLInputFactory
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		// Setup a new eventReader
		InputStream in;

		players = new ArrayList<PlayerProfile>();

		try {
			in = new FileInputStream(fileName);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

			String name = "Newbie", phrase = "I'm new";
			int highscore = 0;

			
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
						if (event.isStartElement()) {
							if (event.asStartElement().getName().getLocalPart()
									.equals("Username")) {
								event = eventReader.nextEvent();
								name = event.asCharacters().getData();
								continue;
							}
							if (event.asStartElement().getName().getLocalPart()
									.equals("Catchphrase")) {
								event = eventReader.nextEvent();
								phrase = event.asCharacters().getData();
								continue;
							}
							if (event.asStartElement().getName().getLocalPart()
									.equals("Highscore")) {
								event = eventReader.nextEvent();
								highscore = Integer.valueOf(event.asCharacters().getData());
								continue;
							}
						}
					}
					// If we reach the end of an item element we add it to the
					// list
					if (event.isEndElement()) {
						EndElement endElement = event.asEndElement();
						if (endElement.getName().getLocalPart() == "Player") {
							players.add(new PlayerProfile(name, phrase,
									highscore));
						}
					}

				}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error processing XML file");
		}

		return players;
	}

	protected BFManager() {
		// NO INSTANTIATION!
	}

	public static BFManager getInstance() {
		if (instance == null) {
			instance = new BFManager();
		}
		return instance;
	}

	public void switchToGame(int id) {
		mainFrame.displayGame(id);
	}

	public void createNewProfile(String name, String phrase) {
		players.add(new PlayerProfile(name, phrase));
	}

	public void savePlayers() throws XMLStreamException, FileNotFoundException {
		// Create a XMLOutputFactory
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		// Create XMLEventWriter
		XMLEventWriter eventWriter = outputFactory
				.createXMLEventWriter(new FileOutputStream(fileName));
		// Create a EventFactory
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		// Create and write Start Tag
		StartDocument startDocument = eventFactory.createStartDocument();
		eventWriter.add(startDocument);

		// Create open tag
		StartElement bfPlayersStartElement = eventFactory.createStartElement(
				"", "", "BrainFlexPlayers");
		eventWriter.add(bfPlayersStartElement);
		eventWriter.add(end);

		for (PlayerProfile pp : players) {
			// Write the different nodes
			StartElement playerStartElement = eventFactory.createStartElement(
					"", "", "Player");
			eventWriter.add(playerStartElement);
			eventWriter.add(end);
			createNode(eventWriter, "Username", pp.getName());
			createNode(eventWriter, "Catchphrase", pp.getCatchphrase());
			createNode(eventWriter, "Highscore",
					String.valueOf(pp.getHighScore()));
			eventWriter.add(eventFactory.createEndElement("", "", "Player"));
			eventWriter.add(end);

		}
		eventWriter.add(eventFactory.createEndElement("", "",
				"BrainFlexPlayers"));
		eventWriter.add(end);
		eventWriter.add(eventFactory.createEndDocument());
		eventWriter.close();
	}

	private void createNode(XMLEventWriter eventWriter, String name,
			String value) throws XMLStreamException {

		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		// Create Start node
		StartElement sElement = eventFactory.createStartElement("", "", name);
		eventWriter.add(tab);
		eventWriter.add(sElement);
		// Create Content
		Characters characters = eventFactory.createCharacters(value);
		eventWriter.add(characters);
		// Create End node
		EndElement eElement = eventFactory.createEndElement("", "", name);
		eventWriter.add(eElement);
		eventWriter.add(end);

	}

	public void setCurrentProfile(int selectedIndex) {
		currentPlayer = selectedIndex;
		mainFrame.updateScorePanelWithNewProfile();
	}
	
	public PlayerProfile getCurrentProfile() {
		return players.get(currentPlayer);
	}

	public void newHighScore(int i) {
		
		mainFrame.alertScore(i - players.get(currentPlayer).getHighScore());
		players.get(currentPlayer).setHighScore(i);
	}

}
