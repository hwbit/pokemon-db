/*
 * COMP 3380 - Database Concepts and Usage
 * 
 * PROJECT:					Pokemon Database
 * 
 * GROUP 68 MEMBERS:		Alyssa Gregorash, Henry Wong, Luc Miron
 * 
 * DUE DATE:				November 22, 2022
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class PokemonInterface {

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {

        MyDatabase db = new MyDatabase();  
        runConsole(db);
        System.out.println("Exiting...");

        System.out.println("⢀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⣠⣤⣶⣶");
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⢰⣿⣿⣿⣿");
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣀⣀⣾⣿⣿⣿⣿");
        System.out.println("⣿⣿⣿⣿⣿⡏⠉⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿");
        System.out.println("⣿⣿⣿⣿⣿⣿⠀⠀⠀⠈⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉⠁⠀⣿");
        System.out.println("⣿⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠙⠿⠿⠿⠻⠿⠿⠟⠿⠛⠉⠀⠀⠀⠀⠀⣸⣿");
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿");
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣴⣿⣿⣿⣿");
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⢰⣹⡆⠀⠀⠀⠀⠀⠀⣭⣷⠀⠀⠀⠸⣿⣿⣿⣿");
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠈⠉⠀⠀⠤⠄⠀⠀⠀⠉⠁⠀⠀⠀⠀⢿⣿⣿⣿");
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⢾⣿⣷⠀⠀⠀⠀⡠⠤⢄⠀⠀⠀⠠⣿⣿⣷⠀⢸⣿⣿⣿");
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⡀⠉⠀⠀⠀⠀⠀⢄⠀⢀⠀⠀⠀⠀⠉⠉⠁⠀⠀⣿⣿⣿");
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿");
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿   ");        
	}

	public static void runConsole(MyDatabase db) {

		Scanner console = new Scanner(System.in);

		System.out.println("                                      ,'\\");
		System.out.println("        _.----.        ____         ,'  _\\   ___    ___     ____");
		System.out.println("    _,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.");
		System.out.println("    \\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |");
		System.out.println("     \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |");
		System.out.println("       \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |");
		System.out.println("        \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |");
		System.out.println("         \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |");
		System.out.println("          \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |");
		System.out.println("           \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |");
		System.out.println("            \\_.-'       |__|    `-._ |              '-.|     '-.| |   |");
		System.out.println("                                    `'                            '-._|");

		System.out.print("Welcome! Type h for help. ");
		System.out.print("db > ");
		String line = console.nextLine();
		String[] parts;
		String arg = "";

		while (line != null && !line.equals("q")) {
			parts = line.split("\\s+");
			if (line.indexOf(" ") > 0)
				arg = line.substring(line.indexOf(" ")).trim();

			if (parts[0].equals("h")){
				printHelp();
			}
			// search pokemon by name
			else if (parts[0].equals("search")) {
				if (parts.length >= 2)
					db.nameSearch(arg);
				else
					System.out.println("Require an argument for this command");
			}
			// lookup pokémon by dex#
			else if (parts[0].equals("lookup")) {
				try {
					if (parts.length >= 2)
						db.lookupByID(arg);
					else
						System.out.println("Require an argument for this command");
				} catch (Exception e) {
					System.out.println("id must be an integer");
				}
			}

			// look up all the stats by dex
			else if (parts[0].equals("stats")) {
				try {
					if (parts.length >= 2)
						db.lookupStatsByID(arg);
					else
						System.out.println("Require an argument for this command");
				} catch (Exception e) {
					System.out.println("id must be an integer");
				}
			}

			// lookup pokémon form by dex# and formID
			else if (parts[0].equals("form")) {
				try {
					if (parts.length >= 2)
						db.lookupForm(arg);
					else
						System.out.println("Require an argument for this command");
				} catch (Exception e) {
					System.out.println("dex#,formID must be a tuple of integers");
				}
			}

			// formtype <Pokedex#> Shows all forms and types for a Pokémon 
			// by Pokedex number(Base and all other forms)
			else if (parts[0].equals("formtype")) {
				try {
					if (parts.length >= 2)
						db.formType(arg);
					else
						System.out.println("Require an argument for this command");
				} catch (Exception e) {
					System.out.println("dex# must be an integer");
				}
			}			

			// lookup all pokemon between these two generations
			else if (parts[0].equals("gen")) {
				try {
					if (parts.length >= 2)
						db.getBetweenGens(arg);
					else
						System.out.println("Require an argument for this command");
				} catch (Exception e) {
					System.out.println("<gen#,gen#> must be a tuple of positive integers");
				}
			}

			// search for an item by name
			else if (parts[0].equals("item")) {
				if (parts.length >= 2)
					db.findItem(arg);
				else
					System.out.println("Require an argument for this command");
			}

			// search for an ability by name
			else if (parts[0].equals("abil")) {
				if (parts.length >= 2)
					db.findAbility(arg);
				else
					System.out.println("Require an argument for this command");
			}

			// search for a move by name
			else if (parts[0].equals("move")) {
				if (parts.length >= 2)
					db.findMove(arg);
				else
					System.out.println("Require an argument for this command");
			}

			// Return all pokémon of a given type
			else if (parts[0].equals("alltype")) {
				if (parts.length >= 2)
					db.findAllOfType(arg);
				else
					System.out.println("Require an argument for this command");
			}

			// Return all pokémon with a given ability
			else if (parts[0].equals("allabil")) {
				if (parts.length >= 2)
					db.findAllWAbility(arg);
				else
					System.out.println("Require an argument for this command");
			}

			// Return all pokémon from a given egg group
			else if (parts[0].equals("allegg")) {
				if (parts.length >= 2)
					db.allFromEgg(arg);
				else
					System.out.println("Require an argument for this command:\nUndiscovered,Monsters,Water1,Bug,Flying,Field,Fairy,Grass,Humanlike,Water2,Mineral,Amorphous,Water3,Ditto,Dragon");
			}

			// Show all Pokémon that can mega evolve
			else if (parts[0].equals("mega")) {
				db.findMega();
			}

			// Return all pokémon that evolve with a given item
			else if (parts[0].equals("evolves")) {
				if (parts.length >= 2)
					db.evolvesWith(arg);
				else
					System.out.println("Require an argument for this command");
			}
			
			// Show all types this Pokémon is immune to
			else if (parts[0].equals("immto")) {
				try {
					if (parts.length >= 2)
						db.immuneTo(arg);
					else
						System.out.println("Require an argument for this command");
				} catch (Exception e) {
					System.out.println("dex#,formID must be a tuple of integers");
				}
			}

			// Show all types this Pokémon is weak to
			else if (parts[0].equals("weakto")) {
				try {
					if (parts.length >= 2)
						db.weakTo(arg);
					else
						System.out.println("Require an argument for this command");
				} catch (Exception e) {
					System.out.println("dex#,formID must be a tuple of integers");
				}
			}
			// Show all types this Pokémon is resistant to
			else if (parts[0].equals("resisto")) {
				try {
					if (parts.length >= 2)
						db.resisTo(arg);
					else
						System.out.println("Require an argument for this command");
				} catch (Exception e) {
					System.out.println("dex#,formID must be a tuple of integers");
				}
			}
			// Given Pokémon's resitance/weakness to a move
			else if (parts[0].equals("pokemovetype")) {
				try {
					if (parts.length >= 2)
						db.pokeToMoveType(arg);
					else
						System.out.println("Require an argument for this command");
				} catch (Exception e) {
					System.out.println("Dex#,FormID#,moveType must be a tuple of int,int,String");
					System.out.println("Use command 'types' to get a listing of all types");
				}
			}
			// Given all Pokémon's evolution line
			else if (parts[0].equals("evoline")) {
				db.pokeEvoLine();
			}

			// Given Pokémon's evolution STAB moves(if any)
			else if (parts[0].equals("stab")) {
				try {
					if (parts.length >= 2)
						db.stabMove(arg);
					else
						System.out.println("Require an argument for this command");
				} catch (Exception e) {
					System.out.println("Dex#,FormID# must be a tuple of int,int");
				}
			}

			// infstatus - Show all the moves this pokemon can learn that inflict a status
			else if (parts[0].equals("infstatus")) {
				try {
					if (parts.length >= 2)
					db.inflictsStatus(arg);
					else
						System.out.println("Require an argument for this command");
				} catch (Exception e) {
					System.out.println("Dex#,FormID# must be a tuple of int,int");
				}
			}			
			// mi - Pokémon immune to the most moves
			else if (parts[0].equals("mi")) {
				db.mostImmun();
			}

			// mr - Pokémon resistant to the most moves
			else if (parts[0].equals("mr")) {
				db.mostResist();
			}

			// mw - Pokémon weakness to the most moves
			else if (parts[0].equals("mw")) {
				db.mostWeak();
			}

			// histats - show Pokémon with the highest combined starting stats
			else if (parts[0].equals("histats")) {
				db.hiStats();
			}

			// lostats - show Pokémon with the lowest combined starting stats
			else if (parts[0].equals("lostats")) {
				db.loStats();
			}

			else if (parts[0].equals("st")) {
				db.strongestType();
			}

			else if (parts[0].equals("si")) {
				try {
					if (parts.length >= 2)
					db.statusImmune(arg);
					else
						System.out.println("Require an argument for this command");
				} catch (Exception e) {
					System.out.println("Dex#,FormID# must be a tuple of positive int,int values");
				}
				
			}

			//print all pokemons
			else if (parts[0].equals("all")) {
				db.listAllPokemon();
			}

			//print all types
			else if (parts[0].equals("types")) {
				db.listAllTypes();
			}

			// given a type, finds pokemon that can learn moves of other types different from their own
			else if (parts[0].equals("othertype")) {
				if (parts.length >= 2)
					db.learnOtherType(arg);
				else
					System.out.println("Require an argument for this command");
			}

			else
				System.out.println("Read the help with h, or find help somewhere else.");

			System.out.print("db > ");
			line = console.nextLine();
		}

		console.close();
	}

	private static void printHelp() {
		System.out.println("Pokémon database");
		System.out.println("Commands:");
		System.out.println("h - Get help");
		System.out.println("search <name> - Search for a Pokémon by name");
		System.out.println("lookup <Pokedex#> - Search for a Pokémon by Pokedex number(Base and all other forms)");
		System.out.println("stats <id> - Show stats of a Pokemon by Pokedex number");
		System.out.println("form <Dex#,FormID#> - Shows name and description for a Pokémon form with Pokédex Number and Form ID");
		System.out.println("formtype <Pokedex#> - Shows all forms and types for a Pokémon by Pokedex number(Base and all other forms)");
		System.out.println("gen <gen#,gen#> - Search for all Pokémon between these generations(inclusive)");
		System.out.println("item <itemName> - Search for an item by name");
		System.out.println("abil <abilName> - Search for an ability by name");
		System.out.println("move <moveName> - Search for a move by name");
		System.out.println("alltype <type> - Show all Pokémon of a given type");
		System.out.println("othertype <typeName> - Given a type, shows Pokémons that can learn moves of other types");
		System.out.println("allabil <ability> - Show all Pokémon with a given ability");
		System.out.println("allegg <Egg Group> - Show all Pokémon in a given egg group");
		System.out.println("mega - Show all Pokémon that can mega evolve");
		System.out.println("evolves <item>  - Show the Pokémon that evolve with a given item");
		System.out.println("evoline - Show all Pokémon's evolution line");
		System.out.println("stab <Dex#,FormID#> - Given Pokémon's evolution STAB moves(if any)");
		System.out.println("infstatus <Dex#,FormID#> - Show all the moves this Pokémon can learn that inflict a status");
        System.out.println("immto <Dex#,FormID#> - Show all types this Pokémon is immune to");
		System.out.println("weakto <Dex#,FormID#> - Show all types this Pokémon is weak to");
		System.out.println("resisto <Dex#,FormID#> - Show all types this Pokémon is resistant to");
		System.out.println("pokemovetype <Dex#,FormID#,moveName> - Given Pokémon's resitance/weakness to a move type");
		System.out.println("mi - Pokémon immune to the most moves");
		System.out.println("mr - Pokémon resistant to the most moves");
		System.out.println("mw - Pokémon weakness to the most moves");
		System.out.println("histats - Show Pokémon with the highest combined starting stats");
		System.out.println("lostats - Show Pokémon with the lowest combined starting stats");
		System.out.println("st - Show Pokémon with the highest stats for each type");
		System.out.println("si <Dex#,FormID#> - Show Pokémon status immunities");
		System.out.println("all - List all the Pokémon");
		System.out.println("types - Show all the types (Applies to Pokémon and moves)");
		System.out.println("q - Exit the program");
		System.out.println("---- end help ----- ");
	}
}


class MyDatabase {
	private Connection connection;

	public MyDatabase() {
        Properties prop = new Properties();
        String fileName = "auth.cfg";
        try {
            FileInputStream configFile = new FileInputStream(fileName);
            prop.load(configFile);
            configFile.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find config file.");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("Error reading config file.");
            System.exit(1);
        }
        String username = (prop.getProperty("username"));
        String password = (prop.getProperty("password"));

        if (username == null || password == null){
            System.out.println("Username or password not provided.");
            System.exit(1);
        }

        String connectionUrl =
                "jdbc:sqlserver://uranium.cs.umanitoba.ca:1433;"
                + "database=cs3380;"
                + "user=" + username + ";"
                + "password="+ password +";"
                + "encrypt=false;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";

		try {
			// create a connection to the database
			connection = DriverManager.getConnection(connectionUrl);

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	public void nameSearch(String name) {
		try {
			String sql = "Select * from Pokemon " +
			"where upper(p_name) like upper(?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + name + "%");		
			ResultSet resultSet = statement.executeQuery();


			String f = "%-8s %-6s %-35s %s \n";
	
			System.out.println("Showing results for name: " + name);
			System.out.printf(f, "Pokedex", "Form", "Name", "Description");
			System.out.printf(f, "======", "====", "========", "========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("pokedex_number"),
									resultSet.getString("form_id"), 
									resultSet.getString("p_name"),
                                    resultSet.getString("p_description")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}

	}

	public void lookupByID(String id) throws NumberFormatException {
		int dex = Integer.parseInt(id);
		try {
			String sql = "Select * from Pokemon " +
			"where pokedex_number = ?;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, dex);		
			ResultSet resultSet = statement.executeQuery();


			String f = "%-8s %-6s %-35s %s \n";
	
			System.out.println("Showing results for Pokedex#: " + id);
			System.out.printf(f, "Pokedex", "Form", "Name", "Description");
			System.out.printf(f, "======", "====", "========", "========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("pokedex_number"),
									resultSet.getString("form_id"), 
									resultSet.getString("p_name"),
                                    resultSet.getString("p_description")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	public void lookupStatsByID(String id) throws NumberFormatException {
		int dex = Integer.parseInt(id);
		try {
			String sql = "Select * from Pokemon " +
			"where pokedex_number = ?;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, dex);		
			ResultSet resultSet = statement.executeQuery();


			String f = "%-8s %-6s %-35s %-6s %-6s %-6s %-6s %-6s %-6s\n";
	
			System.out.println("Showing results for Pokedex#: " + id);
			System.out.printf(f, "Pokedex", "Form", "Name", "HP", "ATK", "DEF", "SATK", "SDEF", "SPD");
			System.out.printf(f, "======", "====", "========", "====", "====", "====", "====", "====", "====");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("pokedex_number"),
									resultSet.getString("form_id"), 
									resultSet.getString("p_name"),
                                    resultSet.getString("p_hp"),
									resultSet.getString("p_atk"),
									resultSet.getString("p_def"),
									resultSet.getString("p_satk"),
									resultSet.getString("p_sdef"),
									resultSet.getString("p_sped")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// Lookup a form by pokedex number and formID number
	public void lookupForm(String idTuple) throws Exception{
		String[] id = idTuple.split(",");
		int dex, fid;
		if(id.length == 2){
			dex = Integer.parseInt(id[0]);
			fid = Integer.parseInt(id[1]);
		}else{
			throw new Exception();
		}
		try {
			String sql = "Select * from Pokemon " +
			"where pokedex_number = ? and form_id = ?;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, dex);
			statement.setInt(2, fid);
			ResultSet resultSet = statement.executeQuery();


			String f = "%-8s %-6s %-35s %s \n";
	
			System.out.println("Showing results for Pokedex#/formID: " + dex + "/" +fid);
			System.out.printf(f, "Pokedex", "Form", "Name", "Description");
			System.out.printf(f, "======", "====", "========", "========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("pokedex_number"),
									resultSet.getString("form_id"), 
									resultSet.getString("p_name"),
                                    resultSet.getString("p_description")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// Search for an item by name
	public void findItem(String name){
		try {
			String sql = "Select * from Item " +
			"where lower(i_name) like lower(?);";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + name + "%");
			ResultSet resultSet = statement.executeQuery();


			String f = "%-16s %s \n";
	
			System.out.println("Showing results for Item: " + name);
			System.out.printf(f, "Name", "Description");
			System.out.printf(f, "======", "========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("i_i_name"),
                                    resultSet.getString("i_description")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// search for an ability by name
	public void findAbility(String name){
		try {
			String sql = "Select * from Ability " +
			"where lower(a_name) like lower(?);";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + name + "%");
			ResultSet resultSet = statement.executeQuery();

			String f = "%-16s %s \n";
	
			System.out.println("Showing results for Ability: " + name);
			System.out.printf(f, "Name", "Description");
			System.out.printf(f, "======", "========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("a_i_name"),
                                    resultSet.getString("a_description")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// search for a move by name
	public void findMove(String name){
		try {
			String sql = "Select * from Move " +
			"where lower(m_i_name) like lower(?);";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + name + "%");
			ResultSet resultSet = statement.executeQuery();


			String f = "%-15s %-10s %-12s %-10s %-12s %s \n";
	
			System.out.println("Showing results for Move: " + name);
			System.out.printf(f, "Name", "Category","Powerpoints",
										"Accuracy", "Range", "Description");
			System.out.printf(f, "======", "=========", "===========", 
										"=========", "=========", "=============");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("m_name"),
									resultSet.getString("m_category"),
									resultSet.getString("m_power"),
									resultSet.getString("m_accuracy"),
									resultSet.getString("m_range"),
                                    resultSet.getString("m_description")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// search pokemons between generations, inclusive
	public void getBetweenGens(String gens) throws Exception {

		String[] gensArr = gens.split(",");
		int genA, genB;
		if(gensArr.length !=  2){
			throw new Exception();
		}else{
			genA = Integer.parseInt( gensArr[0].strip() );
			genB = Integer.parseInt( gensArr[1].strip() );
		}

		if (genA < 1 || genB < 1) {
			throw new Exception("Can only accept non negative integers.");
		}

		try {
			String sql = "Select p_name, pokedex_number, form_id, "+
			"p_generation from Pokemon "+
			"where Pokemon.p_generation between ? and ?;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, ""+Integer.min(genA, genB) );
			statement.setString(2, ""+Integer.max(genA, genB) );
			ResultSet resultSet = statement.executeQuery();


			String f = "%-35s %-8s %-8s %-10s \n";
	
			System.out.println("Showing Pokemon between generations "+genA+" and "+genB);
			System.out.printf(f, "Name", "Dex#","FormID","Generation");
			System.out.printf(f, "======", "========", "========", 
			"==========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("p_name"),
									resultSet.getString("pokedex_number"),
									resultSet.getString("form_id"),
									resultSet.getString("p_generation")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// find all pokemon of a certain type
	public void findAllOfType(String name){
		try {
			String sql = "select distinct Pokemon.p_name, Type.t_name from Pokemon " +
			"left join Pokemon_Type on Pokemon.pokedex_number=Pokemon_Type.pokedex_number " +
			"left join Type on Pokemon_Type.t_name=Type.t_name " +
			"where lower(Type.t_name) like lower(?) " +
			"order by Type.t_name;" ;

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + name + "%");
			ResultSet resultSet = statement.executeQuery();

			String f = "%-35s %s \n";
	
			System.out.println("Showing results for Pokemon of type: " + name);
			System.out.printf(f, "Name", "Type");
			System.out.printf(f, "=========", "===========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("p_name"),
									resultSet.getString("t_name")

                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
	
	// show all pokemon with a given ability
	public void findAllWAbility(String name){
		try {
			// String sql = "select distinct Pokemon.p_name , Type.t_name from Pokemon " +
			// "left join Pokemon_Type on Pokemon.pokedex_number=Pokemon_Type.pokedex_number " +
			// "left join Type on Pokemon_Type.t_name=Type.t_name " +
			// "where lower(Type.t_name) like lower(?) " +
			// "order by Type.t_name;" ;

			String sql="select Pokemon.p_name as name, pokemon.pokedex_number as dex, pokemon.form_id as form, ability.a_i_name as abil " +
			"from Pokemon join Pokemon_Ability on "+
			"pokemon.pokedex_number = pokemon_ability.pokedex_number and "+
			"pokemon.form_id = pokemon_ability.form_id "+
			"join ability on pokemon_ability.a_name = ability.a_name "+
			"where lower(ability.a_i_name) like lower(?) "+
			"order by abil, dex, form;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + name + "%");
			ResultSet resultSet = statement.executeQuery();

			String f = "%-8s %-6s %-35s %s \n";
	
			System.out.println("Showing all Pokemon with ability: " + name);
			System.out.printf(f, "Pokedex", "Form", "Name", "Ability");
			System.out.printf(f, "=======", "====","=========", "===========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("dex"),
									resultSet.getString("form"),
									resultSet.getString("name"),
									resultSet.getString("abil")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	//find all pokemon of a certain egg group
	public void allFromEgg(String name){
		try {
			String sql = "select eggGroup.e_name, pokemon.p_name from Pokemon "+
			"left join Pokemon_Egg on pokemon.pokedex_number=Pokemon_Egg.pokedex_number and pokemon.form_id=pokemon_egg.form_id "+
			"left join EggGroup on Pokemon_Egg.e_name=EggGroup.e_name "+
			"where lower(EggGroup.e_name) like ?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + name + "%");
			ResultSet resultSet = statement.executeQuery();
	
			String f = "%-12s %s \n";
	
			System.out.println("Showing Pokemons that belong to Egg group: " + name);
			System.out.printf(f, "Egg Group", "Pokemon");
			System.out.printf(f, "========", "========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("e_name"),
									resultSet.getString("p_name")
                                    );
			}
			
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
	
	// list all pokemon's evolution to mega form with the item associated to it
	public void findMega(){
		try {
			String sql = "select Pokemon.pokedex_number, Pokemon.p_name, Item.i_i_name from Pokemon " +
			"left join Pokemon_Item_Form_Change on Pokemon.pokedex_number=Pokemon_Item_Form_Change.pokedex_number " +
			"left join Item on Item.i_name=Pokemon_Item_Form_Change.i_name " +
			"where lower(Pokemon.p_name) like lower(\'Mega %\'); " ;

			PreparedStatement statement = connection.prepareStatement(sql);	
			ResultSet resultSet = statement.executeQuery();

			String f = "%-8s %-35s %s \n";
	
			System.out.println("Showing Mega form of the Pokemon and the item used");
			System.out.printf(f, "Pokedex", "Mega", "Item");
			System.out.printf(f, "======", "====", "========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("pokedex_number"),
									resultSet.getString("p_name"), 
									resultSet.getString("i_i_name") != null ? resultSet.getString("i_i_name") : "None"
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// returns all item names matching the name search, the pokemon they evolve and
	// the post evolution name
	public void evolvesWith(String itemName){
		try {
			String sql = "with preName as ( "+
				"Select Pokemon.p_name as preName, Item.i_i_name as itemName, "+
				"Pokemon_Item_Evolution.post_pokedex_number, Pokemon_Item_Evolution.post_f_id "+
				"from Pokemon_Item_Evolution join Pokemon on "+
				"Pokemon_Item_Evolution.pre_pokedex_number = Pokemon.pokedex_number and "+
				"Pokemon_Item_Evolution.pre_f_id = Pokemon.form_id "+
				"join Item on Pokemon_Item_Evolution.i_name = Item.i_name "+
			") "+
			"select preName, itemName, Pokemon.p_name as postName from preName "+
			"join Pokemon on preName.post_pokedex_number = Pokemon.pokedex_number and "+
			"preName.post_f_id = Pokemon.form_id "+
			"where lower(itemName) like lower( ? );";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + itemName + "%");
			ResultSet resultSet = statement.executeQuery();


			String f = "%-35s %-35s %-35s \n";
	
			System.out.println("Showing results for Evolves with Item: " + itemName);
			System.out.printf(f, "Pre Evo Name", "Item Name","Post Evo Name");
			System.out.printf(f, "=============", "=============", "=============");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("preName"),
									resultSet.getString("itemName"),
									resultSet.getString("postName")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// find the attack types a pokemon is immune to
	public void immuneTo(String idTuple) throws Exception{
		String[] id = idTuple.split(",");
		int dex, fid;
		if(id.length == 2){
			dex = Integer.parseInt(id[0]);
			fid = Integer.parseInt(id[1]);
		}else{
			throw new Exception();
		}
		
		try {
			String sql = "select distinct pokemon.p_name, Type_Immunity.immune_attacker from Pokemon " +
			"left join Pokemon_Type on pokemon.pokedex_number=pokemon_type.pokedex_number and pokemon.form_id=pokemon_type.form_id " +
			"left join Type on pokemon_type.t_name=type.t_name " +
			"left join Type_Immunity on type.t_name=Type_Immunity.immune_defender " +
			"where pokemon.pokedex_number = ? " +
			"and pokemon.form_id = ?;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, dex);
			statement.setInt(2, fid);
			ResultSet resultSet = statement.executeQuery();
	
			String f = "%-35s %s \n";
	
			System.out.println("Showing immune for id: " + idTuple);
			System.out.printf(f, "Name", "Immune to Type");
			System.out.printf(f, "========", "========");
			while (resultSet.next()) {
				System.out.printf(f,resultSet.getString("p_name"), 
									resultSet.getString("immune_attacker") != null ? resultSet.getString("immune_attacker") : "None"
                                    );
			}
			
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	//find all attack types the pokemon is weak to
	public void weakTo(String idTuple) throws Exception{
		String[] id = idTuple.split(",");
		int dex, fid;
		if(id.length == 2){
			dex = Integer.parseInt(id[0]);
			fid = Integer.parseInt(id[1]);
		}else{
			throw new Exception();
		}

		try {
			String sql = "select distinct pokemon.p_name, Type_Weakness.weakness_attacker from Pokemon " +
				"left join Pokemon_Type on pokemon.pokedex_number=pokemon_type.pokedex_number and pokemon.form_id=pokemon_type.form_id " +
				"left join Type on pokemon_type.t_name=type.t_name " +
				"left join Type_Weakness on type.t_name=Type_Weakness.weakness_defender " +
				"where pokemon.pokedex_number = ? " +
				"and pokemon.form_id = ? " +
				"EXCEPT "+
				"select distinct Pokemon.p_name, Type_Resist.resist_attacker from Pokemon "+
				"left join Pokemon_Type on pokemon.pokedex_number=pokemon_type.pokedex_number and pokemon.form_id=pokemon_type.form_id "+
				"left join Type on pokemon_type.t_name=type.t_name "+
				"left join Type_Resist on type.t_name=Type_Resist.resist_defender "+
				"where pokemon.pokedex_number = ? "+
				"and pokemon.form_id = ? "+
				"EXCEPT "+
				"select distinct pokemon.p_name, Type_Immunity.immune_attacker from Pokemon "+
				"left join Pokemon_Type on pokemon.pokedex_number=pokemon_type.pokedex_number and pokemon.form_id=pokemon_type.form_id "+
				"left join Type on pokemon_type.t_name=type.t_name "+
				"left join Type_Immunity on type.t_name=Type_Immunity.immune_defender "+
				"where pokemon.pokedex_number = ? "+
				"and pokemon.form_id = ?; ";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, dex);
			statement.setInt(2, fid);
			statement.setInt(3, dex);
			statement.setInt(4, fid);
			statement.setInt(5, dex);
			statement.setInt(6, fid);
			ResultSet resultSet = statement.executeQuery();
	
			String f = "%-35s %s \n";
	
			System.out.println("Showing weakness for id: " + idTuple);
			System.out.printf(f, "Name", "Weakness to Type");
			System.out.printf(f, "========", "========");
			while (resultSet.next()) {
				System.out.printf(f,resultSet.getString("p_name"), 
									resultSet.getString("weakness_attacker")
                                    );
			}
			
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// find all types a pokemon is resistant to
	public void resisTo(String idTuple) throws Exception {
		String[] id = idTuple.split(",");
		int dex, fid;
		if(id.length == 2){
			dex = Integer.parseInt(id[0]);
			fid = Integer.parseInt(id[1]);
		}else{
			throw new Exception();
		}

		try {

			String sql = "select distinct Pokemon.p_name, Type_Resist.resist_attacker from Pokemon "+
			"left join Pokemon_Type on pokemon.pokedex_number=pokemon_type.pokedex_number and pokemon.form_id=pokemon_type.form_id "+
			"left join Type on pokemon_type.t_name=type.t_name "+
			"left join Type_Resist on type.t_name=Type_Resist.resist_defender "+
			"where pokemon.pokedex_number = ? "+
			"and pokemon.form_id = ? "+
			"EXCEPT "+
			"select distinct pokemon.p_name, Type_Weakness.weakness_attacker from Pokemon "+
			"left join Pokemon_Type on pokemon.pokedex_number=pokemon_type.pokedex_number and pokemon.form_id=pokemon_type.form_id "+
			"left join Type on pokemon_type.t_name=type.t_name "+
			"left join Type_Weakness on type.t_name=Type_Weakness.weakness_defender "+
			"where pokemon.pokedex_number = ? "+
			"and pokemon.form_id = ? "+
			"EXCEPT "+
			"select distinct pokemon.p_name, Type_Immunity.immune_attacker from Pokemon "+
			"left join Pokemon_Type on pokemon.pokedex_number=pokemon_type.pokedex_number and pokemon.form_id=pokemon_type.form_id "+
			"left join Type on pokemon_type.t_name=type.t_name "+
			"left join Type_Immunity on type.t_name=Type_Immunity.immune_defender "+
			"where pokemon.pokedex_number = ? "+
			"and pokemon.form_id = ?;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, dex);
			statement.setInt(2, fid);
			statement.setInt(3, dex);
			statement.setInt(4, fid);
			statement.setInt(5, dex);
			statement.setInt(6, fid);
			ResultSet resultSet = statement.executeQuery();
	
			String f = "%-35s %s \n";
	
			System.out.println("Showing Resistance for id: " + idTuple);
			System.out.printf(f, "Name", "Resist to Type");
			System.out.printf(f, "========", "========");
			while (resultSet.next()) {
				System.out.printf(f,resultSet.getString("p_name"), 
									resultSet.getString("resist_attacker")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// get evolution line (for every pokemon) 
	// can change to be a given pokedex/form if needed 
	// what pokemon a pokemon evolves INTO 
	// includes branching evolutions and form-specific evolutions 
	// perhaps call recursively to get the whole line, or not 
	// select p_name,preE,Pokemon_Evolution.post_evo,evoName,pre_f_id from Pokemon_Evolution join (select pokedex_number,p_name,pre_evo as preE,form_id as preForm from Pokemon join Pokemon_Evolution on pokedex_number=pre_evo) first on Pokemon_Evolution.pre_evo = preE and Pokemon_Evolution.pre_f_id=preForm join (select pokedex_number,p_name as evoName,post_evo as postE,form_id as postForm from Pokemon join Pokemon_Evolution on pokedex_number=post_evo) second on Pokemon_Evolution.post_evo=postE and Pokemon_Evolution.post_f_id=postForm group by evoName order by preE, pre_f_id;
	public void pokeEvoLine(){
		try {
			String sql = "with preForms as ( "+
				"select Pokemon.p_name as preName, Pokemon_Evolution.pre_evo as preDex, "+
				"Pokemon_Evolution.pre_f_id as preForm, post_evo, post_f_id from  "+
				"Pokemon_Evolution join Pokemon on Pokemon_Evolution.pre_evo = Pokemon.pokedex_number "+
				"and Pokemon_Evolution.pre_f_id = Pokemon.form_id "+
				") "+
				"SELECT preName, preDex, preForm, Pokemon.p_name as postName, "+
				"post_evo as postDex, post_f_id as postForm FROM "+
				"preForms JOIN Pokemon on "+
				"preForms.post_evo = Pokemon.pokedex_number AND "+
				"preForms.post_f_id = Pokemon.form_id;";

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();


			String f = "%-35s %-10s %-10s %-35s %-10s %-10s \n";
	
			System.out.println("Showing results for Pokemon Evolution Lines: ");
			System.out.printf(f, "Name (PreEvo)", "Pre-Dex","Pre-Form",
										"Name (PostEvo)", "Post-Dex", "Post-Form");
			System.out.printf(f, "======", "=========", "===========", 
										"===========", "=======", "=======");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("preName"),
									resultSet.getString("preDex"),
									resultSet.getString("preForm"),
									resultSet.getString("postName"),
									resultSet.getString("postDex"),
									resultSet.getString("postForm")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	//Moves a Pokemon learns that match any of its type (these are known as STAB moves)
	public void stabMove(String idTuple) throws Exception {
		String[] id = idTuple.split(",");
		int dex, fid;
		if(id.length == 2){
			dex = Integer.parseInt(id[0]);
			fid = Integer.parseInt(id[1]);
		}else{
			throw new Exception();
		}

		try {
			String sql = "select Pokemon.pokedex_number,Pokemon.p_name,Pokemon.form_id as form, " + 
			"Pokemon_Type.t_name as pokeType, Move.m_name from Pokemon "+ 
			"left join Pokemon_Move on Pokemon.pokedex_number=Pokemon_Move.pokedex_number and Pokemon.form_id=Pokemon_Move.form_id " +
			"left join Pokemon_Type on Pokemon.pokedex_number=Pokemon_Type.pokedex_number and Pokemon.form_id=Pokemon_Move.form_id and Pokemon.form_id=Pokemon_Type.form_id " +
			"left join Move_Type on Move_Type.m_name=Pokemon_Move.m_name " +
			"left join Move on Pokemon_Move.m_name=Move.m_i_name " +
			"where Move_Type.t_name=Pokemon_Type.t_name and Pokemon.pokedex_number = ? and Pokemon.form_id=?; ";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, dex);
			statement.setInt(2, fid);
			ResultSet resultSet = statement.executeQuery();
	
			String f = "%-35s %-8s %s \n";
	
			System.out.println("Showing STAB results for Pokedex#,FormID#: " + idTuple);
			System.out.printf(f, "Name", "Type", "Move");
			System.out.printf(f, "========", "========", "========");
			while (resultSet.next()) {
				System.out.printf(f,resultSet.getString("p_name"),
									resultSet.getString("pokeType"),
									resultSet.getString("m_name")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// Show Pokémon immune to the most moves(top 10)
	public void mostImmun(){
		try {
			String sql = "with immunDefender as ( "+
				"select Pokemon.p_name as Name, Move_Type.m_name as immToMove, "+
				"Pokemon.pokedex_number as dex, Pokemon.form_id as form "+
				"from Pokemon " +
				"left join Pokemon_Type on Pokemon.pokedex_number = Pokemon_Type.pokedex_number and "+
				"Pokemon.form_id = Pokemon_Type.form_id "+
				"left join Type_Immunity on Type_Immunity.immune_defender = Pokemon_Type.t_name "+
				"left join Move_Type on Type_Immunity.immune_attacker = Move_Type.t_name "+
			") "+
			"select top 10 Name, dex, form, count(immToMove) as immCount from immunDefender "+
			"group by Name, dex, form order by immCount desc;";

			PreparedStatement statement = connection.prepareStatement(sql);	
			ResultSet resultSet = statement.executeQuery();


			String f = "%-8s %-6s %-35s %-14s \n";
	
			System.out.println("Showing the top 10 Pokemon immune to the most moves");
			System.out.printf(f, "Pokedex", "Form", "Name", "Immune count");
			System.out.printf(f, "======", "====", "========", "========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("dex"),
									resultSet.getString("form"), 
									resultSet.getString("Name"),
                                    resultSet.getString("immCount")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// Show Pokémon resistant to the most moves(top 10)
	public void mostResist(){
		try {
			String sql = "with resDefender as ( "+
				"select Pokemon.p_name as Name, Pokemon.pokedex_number as dex, "+ 
				"Pokemon.form_id as form, Move_Type.m_name as resToMove "+
				"from Pokemon left join Pokemon_Type on Pokemon.pokedex_number = Pokemon_Type.pokedex_number and "+
				"Pokemon.form_id = Pokemon_Type.form_id "+
				"left join Type_Resist on Type_Resist.resist_defender = Pokemon_Type.t_name "+
				"left join Move_Type on Type_Resist.resist_attacker = Move_Type.t_name "+
			") "+
			"select top 10 Name, dex, form, count(resToMove) as resCount from resDefender "+
			"group by Name, dex, form order by resCount desc";

			PreparedStatement statement = connection.prepareStatement(sql);	
			ResultSet resultSet = statement.executeQuery();


			String f = "%-8s %-6s %-35s %-14s \n";
	
			System.out.println("Showing the top 10 Pokemon resistance to the most moves");
			System.out.printf(f, "Pokedex", "Form", "Name", "Resist count");
			System.out.printf(f, "======", "====", "========", "========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("dex"),
									resultSet.getString("form"), 
									resultSet.getString("Name"),
                                    resultSet.getString("resCount")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// Show Pokémon weak to the most moves(top 10)
	public void mostWeak(){
		try {
			String sql = "with weakDefender as ( "+
				"select pokemon.p_name as Name, Pokemon.pokedex_number as dex, "+
				"Pokemon.form_id as form, Move_Type.m_name as weakToMove "+
				"from Pokemon left join Pokemon_Type on "+
				"Pokemon.pokedex_number = Pokemon_Type.pokedex_number and "+ 
				"Pokemon.form_id = Pokemon_Type.form_id "+
				"left join Type_Weakness on Type_Weakness.weakness_defender = Pokemon_Type.t_name "+
				"left join Move_Type on Type_Weakness.weakness_attacker = Move_Type.t_name "+
				") "+
				"select top 10 Name, dex, form, count(distinct weakToMove) as weakCount from weakDefender "+
				"group by Name, dex, form order by weakCount desc;";

			PreparedStatement statement = connection.prepareStatement(sql);	
			ResultSet resultSet = statement.executeQuery();


			String f = "%-8s %-6s %-35s %-14s \n";
	
			System.out.println("Showing the top 10 Pokemon weaknesses to the most moves");
			System.out.printf(f, "Pokedex", "Form", "Name", "Weak count");
			System.out.printf(f, "======", "====", "========", "========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("dex"),
									resultSet.getString("form"), 
									resultSet.getString("Name"),
                                    resultSet.getString("weakCount")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// get the 5 strongest pokemon by stats
	public void hiStats(){
		try {
			String sql = "select top 5 pokemon.p_name, p_hp+p_atk+p_def+p_sped+p_satk+p_sdef as stats from Pokemon " +
			"order by stats DESC; ";

			PreparedStatement statement = connection.prepareStatement(sql);	
			ResultSet resultSet = statement.executeQuery();

			String f = "%-35s %s \n";
	
			System.out.println("Showing Top 5 Pokemon with most stats");
			System.out.printf(f, "Name", "Combined Stats");
			System.out.printf(f, "========", "========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("p_name"),
									resultSet.getString("stats")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// get the lowest 5 pokemon by stats
	public void loStats(){
		try {
			String sql = "select top 5 pokemon.p_name, p_hp+p_atk+p_def+p_sped+p_satk+p_sdef as stats from Pokemon " +
			"order by stats;";

			PreparedStatement statement = connection.prepareStatement(sql);	
			ResultSet resultSet = statement.executeQuery();

			String f = "%-35s %s \n";
	
			System.out.println("Showing Top 5 Pokemon with least stats");
			System.out.printf(f, "Name", "Combined Stats");
			System.out.printf(f, "========", "========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("p_name"),
									resultSet.getString("stats")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	//all pokemons
	public void listAllPokemon() {
		try {
			String sql = "Select * from Pokemon;";

			PreparedStatement statement = connection.prepareStatement(sql);	
			ResultSet resultSet = statement.executeQuery();

			String f = "%-8s %-6s %-35s %s \n";
	
			System.out.println("Showing all Pokemon");
			System.out.printf(f, "Pokedex", "Form", "Name", "Description");
			System.out.printf(f, "======", "====", "========", "========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("pokedex_number"),
									resultSet.getString("form_id"), 
									resultSet.getString("p_name"),
                                    resultSet.getString("p_description")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	//list all types
	public void listAllTypes() {
		try {
			String sql = "Select * from Type;";

			PreparedStatement statement = connection.prepareStatement(sql);	
			ResultSet resultSet = statement.executeQuery();

			String f = "%s \n";
	
			System.out.println("Showing all Pokemon");
			System.out.printf(f, "Type");
			System.out.printf(f, "======");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("t_name"));
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	//list the strongest pokemon for each type
	public void strongestType() {
		try {
			String sql = "with cte1 as ( "+
				"select pokemon.p_name, type.t_name, (pokemon.p_hp+pokemon.p_atk+pokemon.p_def+pokemon.p_sped+pokemon.p_satk+pokemon.p_sdef) as stats from Pokemon " +
				"left join Pokemon_Type on pokemon.pokedex_number=pokemon_type.pokedex_number and pokemon.form_id=pokemon_type.form_id " +
				"left join Type on pokemon_type.t_name=type.t_name " +
				") " +
			"select p_name, t_name, stats " +
			"from cte1 " +
			"where p_name in ( " +
				"select top 1 cte2.p_name " +
				"from cte1 cte2 " +
				"where cte1.t_name=cte2.t_name " +
				"order by cte2.stats DESC "+
			");";

			PreparedStatement statement = connection.prepareStatement(sql);	
			ResultSet resultSet = statement.executeQuery();

			String f = "%-35s %-12s %s \n";

			System.out.println("Showing strongest Pokemon for each type");
			System.out.printf(f, "Name", "Type", "Combined Stats");
			System.out.printf(f, "======", "====", "========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("p_name"),
									resultSet.getString("t_name"), 
									resultSet.getString("stats")
									);
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	/*
	 * --Show a given pokemon and their forms and their type(s)
	 * search by pokedex#
	 */
	public void formType(String dexNum) throws Exception{
		int dex = Integer.parseInt(dexNum);
		try {
			String sql = "Select p_name, Pokemon.pokedex_number, "+
			"Pokemon.form_id, t_name from Pokemon "+
			"join Pokemon_Type on "+
			"Pokemon.pokedex_number=Pokemon_Type.pokedex_number "+
			"and Pokemon.form_id=Pokemon_Type.form_id "+
			"where Pokemon.pokedex_number=?;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, dex);		
			ResultSet resultSet = statement.executeQuery();


			String f = "%-8s %-6s %-35s %-15s \n";
	
			System.out.println("Showing results for Pokedex#: " +dex);
			System.out.printf(f, "Pokedex", "Form", "Name", "Type");
			System.out.printf(f, "======", "====", "========", "========");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("pokedex_number"),
									resultSet.getString("form_id"), 
									resultSet.getString("p_name"),
                                    resultSet.getString("t_name")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// list the status immunities for a pokemon
	public void statusImmune(String idTuple) throws Exception {
		String[] id = idTuple.split(",");

		int dex, fid;
		if(id.length == 2){
			dex = Integer.parseInt(id[0]);
			fid = Integer.parseInt(id[1]);
		}else{
			throw new Exception();
		}
		if (dex < 1 || fid < 0) {
			throw new Exception();
		}

		try {
			String sql = "select Pokemon.p_name, Pokemon_Type.t_name, Type_Status_Immunity.s_name " +
			"from Pokemon "+
			"left join Pokemon_Type on Pokemon.pokedex_number=Pokemon_Type.pokedex_number and Pokemon.form_id=Pokemon_Type.form_id " +
			"left join Type_Status_Immunity on Type_Status_Immunity.t_name=Pokemon_Type.t_name "+
			"where Pokemon.pokedex_number=? and Pokemon.form_id=?;" ;

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, dex);
			statement.setInt(2, fid);
			ResultSet resultSet = statement.executeQuery();
	
			String f = "%-35s %-10s \n";
	
			System.out.println("Showing status immunity for id: " + idTuple);
			System.out.printf(f, "Name",  "Immunity");
			System.out.printf(f, "========",  "========");
			while (resultSet.next()) {
				System.out.printf(f,resultSet.getString("p_name"),
				resultSet.getString("s_name") != null ? resultSet.getString("s_name") : "None" 
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	public void pokeToMoveType(String idMoveTuple) throws Exception {

		//split given tuple so we have the move type,
		//pokedex and form id
		
		//look for that move and store its type as a string
		//if the move doesn't exist, print error and return

		//check if the pokemon is immune to the move's type
		//if it is, damage multiplier is 0 and we're done

		String[] id = idMoveTuple.split(",");
		int dex, fid;
		String move = "";
		if(id.length == 3){
			dex = Integer.parseInt(id[0]);
			fid = Integer.parseInt(id[1]);
			move = id[2];
		}else{
			throw new Exception();
		}
		 
		try {
			String sql = 
			"select distinct pokemon.p_name, Type_Immunity.immune_attacker from Pokemon "
			+"left join Pokemon_Type on pokemon.pokedex_number=pokemon_type.pokedex_number and pokemon.form_id=pokemon_type.form_id "
			+"left join Type on pokemon_type.t_name=type.t_name "
			+"left join Type_Immunity on type.t_name=Type_Immunity.immune_defender "
			+"where pokemon.pokedex_number = ? "
			+"and pokemon.form_id = ? and lower(Type_Immunity.immune_attacker) like lower(?);";

			//sub those values and run
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, dex);
			statement.setInt(2, fid);
			statement.setString(3, "%"+move+"%");
			ResultSet resultSet = statement.executeQuery();

			//if this set returns empty, it's not immune.  Otherwise, its immune and we're done.
			if(resultSet.next()) {
				System.out.println(resultSet.getString("p_name") + " is immune to " + resultSet.getString("immune_attacker") + ".");
			} else {
				//it's not immune, check for weakness
				sql =
				"select distinct pokemon.p_name, Type_Weakness.weakness_attacker from Pokemon "
				+"left join Pokemon_Type on pokemon.pokedex_number=pokemon_type.pokedex_number and pokemon.form_id=pokemon_type.form_id "
				+"left join Type on pokemon_type.t_name=type.t_name "
				+"left join Type_Weakness on type.t_name=Type_Weakness.weakness_defender "
				+"where pokemon.pokedex_number = ? "
				+"and pokemon.form_id = ? and Type_Weakness.weakness_attacker=? "
				+"EXCEPT "
				+"select distinct Pokemon.p_name, Type_Resist.resist_attacker from Pokemon "
				+"left join Pokemon_Type on pokemon.pokedex_number=pokemon_type.pokedex_number and pokemon.form_id=pokemon_type.form_id "
				+"left join Type on pokemon_type.t_name=type.t_name "
				+"left join Type_Resist on type.t_name=Type_Resist.resist_defender "
				+"where pokemon.pokedex_number = ? "
				+"and pokemon.form_id = ? "
				+"EXCEPT "
				+"select distinct pokemon.p_name, Type_Immunity.immune_attacker from Pokemon "
				+"left join Pokemon_Type on pokemon.pokedex_number=pokemon_type.pokedex_number and pokemon.form_id=pokemon_type.form_id "
				+"left join Type on pokemon_type.t_name=type.t_name "
				+"left join Type_Immunity on type.t_name=Type_Immunity.immune_defender "
				+"where pokemon.pokedex_number = ? "
				+"and pokemon.form_id = ?;";

				//sub the values
				statement = connection.prepareStatement(sql);
				statement.setInt(1, dex);
				statement.setInt(2, fid);
				statement.setString(3, move);
				statement.setInt(4, dex);
				statement.setInt(5, fid);
				statement.setInt(6, dex);
				statement.setInt(7, fid);
				resultSet = statement.executeQuery();

				if(resultSet.next()){
					//it is weak, print that and be done
					System.out.println(resultSet.getString("p_name") + " is weak to " + resultSet.getString("weakness_attacker") +".");
				} else {//not weak
					//it's not immune, check for weakness
					sql =
					"select distinct Pokemon.p_name, Type_Resist.resist_attacker from Pokemon "
					+"left join Pokemon_Type on pokemon.pokedex_number=pokemon_type.pokedex_number and pokemon.form_id=pokemon_type.form_id "
					+"left join Type on pokemon_type.t_name=type.t_name "
					+"left join Type_Resist on type.t_name=Type_Resist.resist_defender "
					+"where pokemon.pokedex_number = ? "
					+"and pokemon.form_id = ? and Type_Resist.resist_attacker = ? "
					+"EXCEPT "
					+"select distinct pokemon.p_name, Type_Weakness.weakness_attacker from Pokemon "
					+"left join Pokemon_Type on pokemon.pokedex_number=pokemon_type.pokedex_number and pokemon.form_id=pokemon_type.form_id "
					+"left join Type on pokemon_type.t_name=type.t_name "
					+"left join Type_Weakness on type.t_name=Type_Weakness.weakness_defender "
					+"where pokemon.pokedex_number = ? "
					+"and pokemon.form_id = ? "
					+"EXCEPT "
					+"select distinct pokemon.p_name, Type_Immunity.immune_attacker from Pokemon "
					+"left join Pokemon_Type on pokemon.pokedex_number=pokemon_type.pokedex_number and pokemon.form_id=pokemon_type.form_id "
					+"left join Type on pokemon_type.t_name=type.t_name "
					+"left join Type_Immunity on type.t_name=Type_Immunity.immune_defender "
					+"where pokemon.pokedex_number = ? "
					+"and pokemon.form_id = ?;";

					statement = connection.prepareStatement(sql);
					statement.setInt(1, dex);
					statement.setInt(2, fid);
					statement.setString(3, move);
					statement.setInt(4, dex);
					statement.setInt(5, fid);
					statement.setInt(6, dex);
					statement.setInt(7, fid);
					resultSet = statement.executeQuery();

					//sub values and run
					if(resultSet.next()) {
						System.out.println(resultSet.getString("p_name") + " is resistant to " + resultSet.getString("resist_attacker") + ".");
					} else {
						//no special relation.  this pokemon is effected normally by the move
						sql = "Select * from Pokemon " +
						"where pokedex_number = ? and form_id = ?;";

						statement = connection.prepareStatement(sql);
						statement.setInt(1, dex);
						statement.setInt(2, fid);
						resultSet = statement.executeQuery();
						if(resultSet.next()) {
							System.out.println(resultSet.getString("p_name") + " is affected normally by " + move + ".");
						}
					}
				}
			}
			
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// show all the moves that this pokemon can learn that inflict a status
	public void inflictsStatus(String idTuple) throws Exception{
		String[] id = idTuple.split(",");
		int dex, fid;
		if(id.length == 2){
			dex = Integer.parseInt(id[0]);
			fid = Integer.parseInt(id[1]);
		}else{
			throw new Exception();
		}

		try {
			String sql = "select Pokemon.p_name as Name, Move.m_name as Move, Move_Status_Effects.s_name as Status "+
			"from Pokemon join Pokemon_Move on Pokemon.pokedex_number = Pokemon_Move.pokedex_number and "+
			"Pokemon.form_id = Pokemon_Move.form_id "+
			"join Move_Status_Effects on Pokemon_Move.m_name = Move_Status_Effects.m_name "+
			"join Move on Move.m_i_name = Move_Status_Effects.m_name "+
			"where Pokemon.pokedex_number = ? and Pokemon.form_id = ?;";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, dex);
			statement.setInt(2, fid);
			ResultSet resultSet = statement.executeQuery();
	
			String f = "%-35s %-20s %-20s \n";
	
			System.out.println("Showing Moves that inflict a status for id: " + idTuple);
			System.out.printf(f, "Name", "Move", "Status");
			System.out.printf(f, "==========", "==========", "==========");
			while (resultSet.next()) {
				System.out.printf(f,resultSet.getString("Name"), 
									resultSet.getString("Move"),
									resultSet.getString("Status")
                                    );
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}


	// 	--query for all pokemon of a type that learn moves of another given type
	// --all pokemon that learn  type of move
	//	INTERSECT
	// --all pokemon that are a given type
	public void learnOtherType(String type){
		try {
			String sql = "select DISTINCT Pokemon.p_name from Pokemon join Pokemon_Move on Pokemon.pokedex_number=Pokemon_Move.pokedex_number "+
			"and Pokemon.form_id=Pokemon_Move.form_id "+
			"join Move_Type on Pokemon_Move.m_name=Move_Type.m_name "+
			"where Move_Type.t_name like ? "+
			"INTERSECT "+
			"select DISTINCT Pokemon.p_name from Pokemon join Pokemon_Type on Pokemon.form_id=Pokemon_Type.form_id and Pokemon.pokedex_number=Pokemon_Type.pokedex_number "+
			"where Pokemon_type.t_name like ?;" ;

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + type + "%");
			statement.setString(2, "%" + type + "%");
			ResultSet resultSet = statement.executeQuery();


			String f = "%s \n";
	
			System.out.println("Showing results for Pokemons that can learn moves of types other than their own: " + type);
			System.out.printf(f, "Name");
			System.out.printf(f, "======");
			while (resultSet.next()) {
				System.out.printf(f, resultSet.getString("p_name"));
			}
			System.out.println("");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
}
