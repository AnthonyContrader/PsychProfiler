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
	private final String QUERY_CREATE = "INSERT INTO test (quest1, ans1, quest2, ans2, quest3, ans3, quest4, ans4, quest5, ans5, quest6, ans6, quest7, ans7, quest8, ans8, quest9, ans9, quest10, ans10) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM test WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE test SET quest1=?, ans1=?, quest2=?, ans2=? quest3=?, ans3=? quest4=?, ans4=? quest5=?, ans5=? quest6=?, ans6=? quest7=?, ans7=? quest8=?, ans8=? quest9=?, ans9=? quest10=?, ans10=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM cand WHERE id=?";

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
				int iduser = resultSet.getInt("iduser");
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
				String quest6 = resultSet.getString("quest6");
				String ans6 = resultSet.getString("ans6");
				String quest7 = resultSet.getString("quest7");
				String ans7 = resultSet.getString("ans7");
				String quest8 = resultSet.getString("quest8");
				String ans8 = resultSet.getString("ans8");
				String quest9 = resultSet.getString("quest9");
				String ans9 = resultSet.getString("ans9");
				String quest10 = resultSet.getString("quest10");
				String ans10 = resultSet.getString("ans10");
				
				test = new Test(quest1, ans1, quest2, ans2, quest3, ans3, quest4, ans4, quest5, ans5, quest6, ans6, quest7, ans7, quest8, ans8, quest9, ans9, quest10, ans10, id, iduser);
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
			preparedStatement.setString(1, testToInsert.getQuest1());
			preparedStatement.setString(2, testToInsert.getAns1());
			preparedStatement.setString(3, testToInsert.getQuest2());
			preparedStatement.setString(4, testToInsert.getAns2());
			preparedStatement.setString(5, testToInsert.getQuest3());
			preparedStatement.setString(6, testToInsert.getAns3());
			preparedStatement.setString(7, testToInsert.getQuest4());
			preparedStatement.setString(8, testToInsert.getAns4());
			preparedStatement.setString(9, testToInsert.getQuest5());
			preparedStatement.setString(10, testToInsert.getAns5());
			preparedStatement.setString(11, testToInsert.getQuest6());
			preparedStatement.setString(12, testToInsert.getAns6());
			preparedStatement.setString(13, testToInsert.getQuest7());
			preparedStatement.setString(14, testToInsert.getAns7());
			preparedStatement.setString(15, testToInsert.getQuest8());
			preparedStatement.setString(16, testToInsert.getAns8());
			preparedStatement.setString(17, testToInsert.getQuest9());
			preparedStatement.setString(18, testToInsert.getAns9());
			preparedStatement.setString(19, testToInsert.getQuest10());
			preparedStatement.setString(20, testToInsert.getAns10());
			preparedStatement.setInt(21, testToInsert.getIdUser());
			
	
			preparedStatement.setInt(3, testToInsert.getIdUser());
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
			String quest1, ans1, quest2, ans2, quest3, ans3, quest4, ans4, quest5, ans5, quest6, ans6, quest7, ans7, quest8, ans8, quest9, ans9, quest10, ans10;
			int iduser;

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
			quest6 = resultSet.getString("quest6");
			ans6 = resultSet.getString("ans6");
			quest7 = resultSet.getString("quest7");
			ans7 = resultSet.getString("ans7");
			quest8 = resultSet.getString("quest8");
			ans8 = resultSet.getString("ans8");
			quest9 = resultSet.getString("quest9");
			ans9 = resultSet.getString("ans9");
			quest10 = resultSet.getString("quest10");
			ans10 = resultSet.getString("ans10");
			iduser = resultSet.getInt("iduser");
			Test test = new Test(quest1, ans1, quest2, ans2, quest3, ans3, quest4, ans4, quest5, ans5, quest6, ans6, quest7, ans7, quest8, ans8, quest9, ans9, quest10, ans10, iduser);
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
				if (testToUpdate.getQuest6() == null || testToUpdate.getQuest6().equals("")) {
					testToUpdate.setQuest6(testRead.getQuest6());
				}

				if (testToUpdate.getAns6() == null || testToUpdate.getAns6().equals("")) {
					testToUpdate.setAns6(testRead.getAns6());
				}
				if (testToUpdate.getQuest7() == null || testToUpdate.getQuest7().equals("")) {
					testToUpdate.setQuest7(testRead.getQuest7());
				}

				if (testToUpdate.getAns7() == null || testToUpdate.getAns7().equals("")) {
					testToUpdate.setAns7(testRead.getAns7());
				}
				if (testToUpdate.getQuest8() == null || testToUpdate.getQuest8().equals("")) {
					testToUpdate.setQuest8(testRead.getQuest8());
				}

				if (testToUpdate.getAns8() == null || testToUpdate.getAns8().equals("")) {
					testToUpdate.setAns8(testRead.getAns8());
				}
				if (testToUpdate.getQuest9() == null || testToUpdate.getQuest9().equals("")) {
					testToUpdate.setQuest9(testRead.getQuest9());
				}

				if (testToUpdate.getAns9() == null || testToUpdate.getAns9().equals("")) {
					testToUpdate.setAns9(testRead.getAns9());
				}
				if (testToUpdate.getQuest10() == null || testToUpdate.getQuest10().equals("")) {
					testToUpdate.setQuest10(testRead.getQuest10());
				}

				if (testToUpdate.getAns10() == null || testToUpdate.getAns10().equals("")) {
					testToUpdate.setAns10(testRead.getAns10());
				}
				

				// Update the test
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, testToUpdate.getQuest1());
				preparedStatement.setString(2, testToUpdate.getAns1());
				preparedStatement.setString(3, testToUpdate.getQuest2());
				preparedStatement.setString(4, testToUpdate.getAns2());
				preparedStatement.setString(5, testToUpdate.getQuest3());
				preparedStatement.setString(6, testToUpdate.getAns3());
				preparedStatement.setString(7, testToUpdate.getQuest4());
				preparedStatement.setString(8, testToUpdate.getAns4());
				preparedStatement.setString(9, testToUpdate.getQuest5());
				preparedStatement.setString(10, testToUpdate.getAns5());
				preparedStatement.setString(11, testToUpdate.getQuest6());
				preparedStatement.setString(12, testToUpdate.getAns6());
				preparedStatement.setString(13, testToUpdate.getQuest7());
				preparedStatement.setString(14, testToUpdate.getAns7());
				preparedStatement.setString(15, testToUpdate.getQuest8());
				preparedStatement.setString(16, testToUpdate.getAns8());
				preparedStatement.setString(17, testToUpdate.getQuest9());
				preparedStatement.setString(18, testToUpdate.getAns9());
				preparedStatement.setString(19, testToUpdate.getQuest10());
				preparedStatement.setString(20, testToUpdate.getAns10());
				preparedStatement.setInt(21, testToUpdate.getIdUser());
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
