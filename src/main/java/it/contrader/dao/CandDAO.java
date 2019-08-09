package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Cand;

/**
 * 
 * @author Pasquale
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class CandDAO implements DAO<Cand> {

	private final String QUERY_ALL = "SELECT * FROM cand";
	private final String QUERY_CREATE = "INSERT INTO cand (name, surname,age,experience, id_user) VALUES (?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM cand WHERE id_cand=?";
	private final String QUERY_UPDATE = "UPDATE cand SET name=?, surname=?, age=?, experience=?, id_user=? WHERE id_cand=?";
	private final String QUERY_DELETE = "DELETE FROM cand WHERE id_cand=?";

	public CandDAO() {

	}

	public List<Cand> getAll() {
		List<Cand> candsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Cand cand;
			while (resultSet.next()) {
				int id_cand = resultSet.getInt("id_cand");
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				int age = resultSet.getInt("age");
				String experience = resultSet.getString("experience");
				int id_user = resultSet.getInt("id_user");

				cand = new Cand( name, surname,age, experience,id_user);
				cand.setId_cand(id_cand);
				candsList.add(cand);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return candsList;
	}

	public boolean insert(Cand candToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, candToInsert.getName());
			preparedStatement.setString(2, candToInsert.getSurname());
			preparedStatement.setInt(3, candToInsert.getAge());
			preparedStatement.setString(4, candToInsert.getExperience());
			preparedStatement.setInt(5, candToInsert.getId_user());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Cand read(int id_cand) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id_cand);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, surname, experience;
			int age,id_user;

			name = resultSet.getString("name");
			surname = resultSet.getString("surname");
			age = resultSet.getInt("age");
			experience = resultSet.getString("experience");
			id_user = resultSet.getInt("id_user");
			Cand cand = new Cand(name,surname, age, experience,id_user);
			cand.setId_cand(resultSet.getInt("id_cand"));

			return cand;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Cand candToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (candToUpdate.getId_cand() == 0)
			return false;

		Cand candRead = read(candToUpdate.getId_cand());
		if (!candRead.equals(candToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (candToUpdate.getName() == null || candToUpdate.getName().equals("")) {
					candToUpdate.setName(candRead.getName());
				}

				if (candToUpdate.getSurname() == null || candToUpdate.getSurname().equals("")) {
					candToUpdate.setSurname(candRead.getSurname());
				}

				if (candToUpdate.getAge() == 0) {
					candToUpdate.setAge(candRead.getAge());
				}

				if (candToUpdate.getExperience() == null || candToUpdate.getExperience().equals("")) {
					candToUpdate.setExperience(candRead.getExperience());
				}
				if (candToUpdate.getId_user() == 0) {
					candToUpdate.setId_user(candRead.getId_user());
				}

				// Update the cand
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, candToUpdate.getName());
				preparedStatement.setString(2, candToUpdate.getSurname());
				preparedStatement.setInt(3, candToUpdate.getAge());
				preparedStatement.setString(4, candToUpdate.getExperience());
				preparedStatement.setInt(5, candToUpdate.getId_user());
				preparedStatement.setInt(6, candToUpdate.getId_cand());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id_cand) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id_cand);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}

