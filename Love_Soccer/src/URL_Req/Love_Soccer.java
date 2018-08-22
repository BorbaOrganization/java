package URL_Req;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;




public class Love_Soccer extends JFrame {
	
	static class SportEvent{
		private String id, schedule, status;
		private boolean start_time_tbd;
		private Tournament_Round tournament_round;
		private Season season;
		private Tournament tournament;
		private Sport sport;
		private Category category;
		private Competitor competitorHome, competitorAway;

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * @return the schedule
		 */
		public String getSchedule() {
			return schedule;
		}
		/**
		 * @param schedule the schedule to set
		 */
		public void setSchedule(String schedule) {
			this.schedule = schedule;
		}
		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}
		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}
		/**
		 * @return the start_time_tbd
		 */
		public boolean isStart_time_tbd() {
			return start_time_tbd;
		}
		/**
		 * @param start_time_tbd the start_time_tbd to set
		 */
		public void setStart_time_tbd(boolean start_time_tbd) {
			this.start_time_tbd = start_time_tbd;
		}
		/**
		 * @return the tournament_round
		 */
		public Tournament_Round getTournament_round() {
			return tournament_round;
		}
		/**
		 * @param tournament_round the tournament_round to set
		 */
		public void setTournament_round(Tournament_Round tournament_round) {
			this.tournament_round = tournament_round;
		}
		/**
		 * @return the season
		 */
		public Season getSeason() {
			return season;
		}
		/**
		 * @param season the season to set
		 */
		public void setSeason(Season season) {
			this.season = season;
		}
		public void setSeason(JSONObject jsonObject) throws JSONException {
			// TODO Auto-generated method stub
			this.season.setId(jsonObject.getString("id"));
			this.season.setName(jsonObject.getString("name"));
			this.season.setStart_date(jsonObject.getString("start_date"));
			this.season.setEnd_date(jsonObject.getString("end_date"));
			this.season.setYear(jsonObject.getString("year"));
			this.season.setTournament_id(jsonObject.getString("tournament_id"));
		}
		
		public void setTournament(Tournament tournament) {
			this.tournament = tournament;
		}
		
		public void setTournament(JSONObject jsonObject) throws JSONException {
			// TODO Auto-generated method stub
			this.tournament.setId(jsonObject.getString("id"));
			this.tournament.setName(jsonObject.getString("name"));
			this.tournament.setSport(new Sport(jsonObject.getJSONObject("sport")));
			this.tournament.setCategory(new Category(jsonObject.getJSONObject("category")));
		}
		

		/**
		 * @return the sport
		 */
		public Sport getSport() {
			return sport;
		}
		/**
		 * @param sport the sport to set
		 */
		public void setSport(Sport sport) {
			this.sport = sport;
		}
		/**
		 * @return the category
		 */
		public Category getCategory() {
			return category;
		}
		/**
		 * @param category the category to set
		 */
		public void setCategory(Category category) {
			this.category = category;
		}
		/**
		 * @return the competitorHome
		 */
		public Competitor getCompetitorHome() {
			return competitorHome;
		}
		/**
		 * @param competitorHome the competitorHome to set
		 */
		public void setCompetitorHome(Competitor competitorHome) {
			this.competitorHome = competitorHome;
		}
		/**
		 * @return the competitorAway
		 */
		public Competitor getCompetitorAway() {
			return competitorAway;
		}
		/**
		 * @param competitorAway the competitorAway to set
		 */
		public void setCompetitorAway(JSONArray jsonArray) throws JSONException {
			this.competitorAway = new Competitor(jsonArray.getJSONObject(1));
		}
		/**
		 * @return the tournament
		 */
		public Tournament getTournament() {
			return tournament;
		}
		public void setCompetitorHome(JSONArray jsonArray) throws JSONException {
			// TODO Auto-generated method stub
			this.competitorHome=new Competitor(jsonArray.getJSONObject(0));
		}
		
	}
	
	static class Tournament_Round{
		private String type;
		private int number;
		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}
		/**
		 * @param type the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}
		/**
		 * @return the number
		 */
		public int getNumber() {
			return number;
		}
		/**
		 * @param number the number to set
		 */
		public void setNumber(int number) {
			this.number = number;
		}
		
		
	}
	
	static class Season{
		private String id, name, start_date, end_date, year, tournament_id;
		public Season(JSONObject jsonObject) throws JSONException {
			// TODO Auto-generated constructor stub
			this.id = jsonObject.getString("id");
			this.name = jsonObject.getString("name");
			this.start_date = jsonObject.getString("start_date");
			this.end_date = jsonObject.getString("end_date");
			this.year = jsonObject.getString("year");
			this.tournament_id = jsonObject.getString("tournament_id");
		}
		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the start_date
		 */
		public String getStart_date() {
			return start_date;
		}
		/**
		 * @param start_date the start_date to set
		 */
		public void setStart_date(String start_date) {
			this.start_date = start_date;
		}
		/**
		 * @return the end_date
		 */
		public String getEnd_date() {
			return end_date;
		}
		/**
		 * @param end_date the end_date to set
		 */
		public void setEnd_date(String end_date) {
			this.end_date = end_date;
		}
		/**
		 * @return the year
		 */
		public String getYear() {
			return year;
		}
		/**
		 * @param year the year to set
		 */
		public void setYear(String year) {
			this.year = year;
		}
		/**
		 * @return the tournament_id
		 */
		public String getTournament_id() {
			return tournament_id;
		}
		/**
		 * @param tournament_id the tournament_id to set
		 */
		public void setTournament_id(String tournament_id) {
			this.tournament_id = tournament_id;
		}

	}
	
	static class Tournament{
		private String id, name;
		private Sport sport;
		private Category category;
		
		public Tournament(JSONObject jsonObject) throws JSONException {
			// TODO Auto-generated constructor stub
			this.id = jsonObject.getString("id");
			this.name = jsonObject.getString("name");
			this.sport = new Sport(jsonObject.getJSONObject("sport"));
			this.category = new Category(jsonObject.getJSONObject("category"));
			
		}
		/**
		 * @return the sport
		 */
		public Sport getSport() {
			return sport;
		}
		/**
		 * @param sport the sport to set
		 */
		public void setSport(Sport sport) {
			this.sport = sport;
		}
		
		/**
		 * @return the category
		 */
		public Category getCategory() {
			return category;
		}
		/**
		 * @param category the category to set
		 */
		public void setCategory(Category category) {
			this.category = category;
		}
		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		
	}

	static class Sport{
		private String id, name;

		public Sport(JSONObject jsonObject) {
			// TODO Auto-generated constructor stub
		}

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	static class Category{
		private String id, name, country_code;

		public Category(JSONObject jsonObject) {
			// TODO Auto-generated constructor stub
		}

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the country_code
		 */
		public String getCountry_code() {
			return country_code;
		}

		/**
		 * @param country_code the country_code to set
		 */
		public void setCountry_code(String country_code) {
			this.country_code = country_code;
		}
		
	}
	
	static class Competitor{
		private String id, naCompme, country, country_code, abbreviation, qualifier;
		
		public Competitor(JSONObject jsonObject) throws JSONException {
			this.id = jsonObject.getString("id");
			this.abbreviation = jsonObject.getString("abbreviation");
		
		}

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the naCompme
		 */
		public String getNaCompme() {
			return naCompme;
		}

		/**
		 * @param naCompme the naCompme to set
		 */
		public void setNaCompme(String naCompme) {
			this.naCompme = naCompme;
		}

		/**
		 * @return the country
		 */
		public String getCountry() {
			return country;
		}

		/**
		 * @param country the country to set
		 */
		public void setCountry(String country) {
			this.country = country;
		}

		/**
		 * @return the country_code
		 */
		public String getCountry_code() {
			return country_code;
		}

		/**
		 * @param country_code the country_code to set
		 */
		public void setCountry_code(String country_code) {
			this.country_code = country_code;
		}

		/**
		 * @return the abbreviation
		 */
		public String getAbbreviation() {
			return abbreviation;
		}

		/**
		 * @param abbreviation the abbreviation to set
		 */
		public void setAbbreviation(String abbreviation) {
			this.abbreviation = abbreviation;
		}

		/**
		 * @return the qualifier
		 */
		public String getQualifier() {
			return qualifier;
		}

		/**
		 * @param qualifier the qualifier to set
		 */
		public void setQualifier(String qualifier) {
			this.qualifier = qualifier;
		}
		
				
	}
	
	

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnSearch;
	private JList list;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Love_Soccer frame = new Love_Soccer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void setupComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblTypeTheAbbreviation = new JLabel("Type the abbreviation of your soccer team:");
		
		btnSearch = new JButton("Search");
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTypeTheAbbreviation)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(274))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(147)
					.addComponent(btnSearch)
					.addContainerGap(175, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTypeTheAbbreviation)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnSearch)
					.addGap(4))
		);
		
		list = new JList();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Consolas", Font.PLAIN, 10));
		contentPane.setLayout(gl_contentPane);
		
	}
	
	
	/**
	 * Create the frame.
	 */
	public Love_Soccer() {
		setTitle("I Love Soccer");
		
		setupComponents();
		createEvents();

	}
	
	public void createEvents() {
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String soccerTeam = textField.getText().trim().toUpperCase();
				System.out.println(soccerTeam);
				String url = "https://api.sportradar.us/soccer-xt3/eu/en/tournaments/sr:tournament:17/schedule.json?api_key=edu7p4e3env43x6c57d7sfpq\r\n";
				try {		
					URL obj = new URL(url);
					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					
					int responseCode = con.getResponseCode();
					
					//System.out.println("\nSending 'GET' request to URL : " + url);
					//System.out.println("Response code : " + responseCode);
					BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();
					while((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
					//System.out.println(response.toString());

					JSONObject myResponse = new JSONObject(response.toString());
					JSONArray sportEvents = myResponse.getJSONArray("sport_events");
					
					System.out.println("generated_at "+myResponse.getString("generated_at"));
					System.out.println("schema "+myResponse.getString("schema"));		
					
					//System.out.println(myResponse);
					
					SportEvent[] sportEventarr = new SportEvent[sportEvents.length()]; 
					
					
					String lineOnList = "";
					DefaultListModel dlm =  new DefaultListModel();
					dlm.removeAllElements();
					for(int i = 0; i <sportEvents.length();i++) {
						sportEventarr[i] = new SportEvent();
						JSONObject sportEvent = sportEvents.getJSONObject(i);
						sportEventarr[i].setId(sportEvent.getString("id"));
						sportEventarr[i].setSchedule(sportEvent.getString("scheduled"));
						sportEventarr[i].setSeason(new Season(sportEvent.getJSONObject("season")));
						sportEventarr[i].setTournament(new Tournament(sportEvent.getJSONObject("tournament")));
						sportEventarr[i].setCompetitorHome( sportEvent.getJSONArray("competitors"));
						sportEventarr[i].setCompetitorAway( sportEvent.getJSONArray("competitors"));

						if(sportEventarr[i].getCompetitorHome().getAbbreviation().equalsIgnoreCase(soccerTeam) || sportEventarr[i].getCompetitorAway().getAbbreviation().equalsIgnoreCase(soccerTeam)) {

							System.out.println("Event ID : "+sportEventarr[i].getId()+"\n"+
									" Scheduled : "+sportEventarr[i].getSchedule()+"\n"+
									" Season Name : "+sportEventarr[i].getSeason().getName()+"\n"+
									" Season Start_date : "+sportEventarr[i].getSeason().getStart_date()+"\n"+
									" Season End_date : "+sportEventarr[i].getSeason().getEnd_date()+"\n"+
									" Season Competitor Home : "+sportEventarr[i].getCompetitorHome().getAbbreviation()+"\n"+
									" Season Competitor Away : "+sportEventarr[i].getCompetitorAway().getAbbreviation()+"\n"+"\n");
							
							lineOnList = "Event ID : "+sportEventarr[i].getId()+"\n";
							dlm.addElement(lineOnList);
							lineOnList = " Scheduled : "+sportEventarr[i].getSchedule()+"\n";
							dlm.addElement(lineOnList);
							lineOnList = " Season Name : "+sportEventarr[i].getSeason().getName()+"\n";
							dlm.addElement(lineOnList);
							lineOnList = " Season Start_date : "+sportEventarr[i].getSeason().getStart_date()+"\n";
							dlm.addElement(lineOnList);
							lineOnList = " Season End_date : "+sportEventarr[i].getSeason().getEnd_date()+"\n";
							dlm.addElement(lineOnList);
							lineOnList = " Season Competitor Home : "+sportEventarr[i].getCompetitorHome().getAbbreviation()+"\n";
							dlm.addElement(lineOnList);
							lineOnList = " Season Competitor Away : "+sportEventarr[i].getCompetitorAway().getAbbreviation()+"\n";
							dlm.addElement(lineOnList);
							lineOnList="\n";
							dlm.addElement(lineOnList);

						}
						list.setModel(dlm);
						
					}
				}catch (Exception e) {
					System.out.println(e);
				}
				
			}
		});
	}
}
