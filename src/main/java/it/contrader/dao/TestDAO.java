package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Test;

public class TestDAO implements DAO<Test> {

	private final String QUERY_ALL = "SELECT * FROM test";
	private final String QUERY_CREATE = "INSERT INTO test (idUser, quest1, ans1, quest2, ans2, quest3, ans3, quest4, ans4, quest5, ans5) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM test WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE test SET idUser=?, quest1=?, ans1=?, quest2=?, ans2=? quest3=?, ans3=? quest4=?, ans4=? quest5=?, ans5=?  WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM test WHERE id=?";

	public TestDAO() {

	}

	public List<Test> getAll() {
		List<Test> testsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Test test;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int idUser = resultSet.getInt("idUser");
				String quest1 = resultSet.getString("quest1");
				String ans1 = resultSet.getString("ans1");
				String quest2 = resultSet.getString("quest2");
				String ans2 = resultSet.getString("ans2");
				String quest3 = resultSet.getString("quest3");
				String ans3 = resultSet.getString("ans3");
				String quest4 = resultSet.getString("quest4");
				String ans4 = resultSet.getString("ans4");
				String quest5 = resultSet.getString("quest5");
				String ans5 = resultSet.getString("ans5");

				
				test = new Test(id, idUser ,quest1, ans1, quest2, ans2, quest3, ans3, quest4, ans4, quest5, ans5);
				test.setId(id);
				testsList.add(test);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return testsList;
	}

	public boolean insert(Test testToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, testToInsert.getIdUser());
			preparedStatement.setString(2, testToInsert.getQuest1());
			preparedStatement.setString(3, testToInsert.getAns1());
			preparedStatement.setString(4, testToInsert.getQuest2());
			preparedStatement.setString(5, testToInsert.getAns2());
			preparedStatement.setString(6, testToInsert.getQuest3());
			preparedStatement.setString(7, testToInsert.getAns3());
			preparedStatement.setString(8, testToInsert.getQuest4());
			preparedStatement.setString(9, testToInsert.getAns4());
			preparedStatement.setString(10, testToInsert.getQuest5());
			preparedStatement.setString(11, testToInsert.getAns5());

	
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Test read(int testId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, testId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String quest1, ans1, quest2, ans2, quest3, ans3, quest4, ans4, quest5, ans5;
			int idUser;
			idUser = resultSet.getInt("idUser");
			quest1 = resultSet.getString("quest1");
			ans1 = resultSet.getString("ans1");
			quest2 = resultSet.getString("quest2");
			ans2 = resultSet.getString("ans2");
			quest3 = resultSet.getString("quest3");
			ans3 = resultSet.getString("ans3");
			quest4 = resultSet.getString("quest4");
			ans4 = resultSet.getString("ans4");
			quest5 = resultSet.getString("quest5");
			ans5 = resultSet.getString("ans5");
			
			Test test = new Test (idUser,quest1,ans1,quest2,ans2,quest3,ans3,quest4,ans4,quest5,ans5);
			test.setId(resultSet.getInt("id"));

			return test;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Test testToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (testToUpdate.getId() == 0)
			return false;

		Test testRead = read(testToUpdate.getId());
		if (!testRead.equals(testToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (testToUpdate.getIdUser() == 0) {
					testToUpdate.setIdUser(testRead.getIdUser());
				}

				if (testToUpdate.getQuest1() == null || testToUpdate.getQuest1().equals("")) {
					testToUpdate.setQuest1(testRead.getQuest1());
				}

				if (testToUpdate.getAns1() == null || testToUpdate.getAns1().equals("")) {
					testToUpdate.setAns1(testRead.getAns1());
				}
				if (testToUpdate.getQuest2() == null || testToUpdate.getQuest2().equals("")) {
					testToUpdate.setQuest2(testRead.getQuest2());
				}

				if (testToUpdate.getAns2() == null || testToUpdate.getAns2().equals("")) {
					testToUpdate.setAns2(testRead.getAns2());
				}
				if (testToUpdate.getQuest3() == null || testToUpdate.getQuest3().equals("")) {
					testToUpdate.setQuest3(testRead.getQuest3());
				}

				if (testToUpdate.getAns3() == null || testToUpdate.getAns3().equals("")) {
					testToUpdate.setAns3(testRead.getAns3());
				}
				if (testToUpdate.getQuest4() == null || testToUpdate.getQuest4().equals("")) {
					testToUpdate.setQuest4(testRead.getQuest4());
				}

				if (testToUpdate.getAns4() == null || testToUpdate.getAns4().equals("")) {
					testToUpdate.setAns4(testRead.getAns4());
				}
				if (testToUpdate.getQuest5() == null || testToUpdate.getQuest5().equals("")) {
					testToUpdate.setQuest5(testRead.getQuest5());
				}

				if (testToUpdate.getAns5() == null || testToUpdate.getAns5().equals("")) {
					testToUpdate.setAns5(testRead.getAns5());
				}

				// Update the test

				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, testToUpdate.getIdUser());
				preparedStatement.setString(2, testToUpdate.getQuest1());
				preparedStatement.setString(3, testToUpdate.getAns1());
				preparedStatement.setString(4, testToUpdate.getQuest2());
				preparedStatement.setString(5, testToUpdate.getAns2());
				preparedStatement.setString(6, testToUpdate.getQuest3());
				preparedStatement.setString(7, testToUpdate.getAns3());
				preparedStatement.setString(8, testToUpdate.getQuest4());
				preparedStatement.setString(9, testToUpdate.getAns4());
				preparedStatement.setString(10, testToUpdate.getQuest5());
				preparedStatement.setString(11, testToUpdate.getAns5());

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

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

}
