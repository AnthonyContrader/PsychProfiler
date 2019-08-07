package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Question;
import it.contrader.utils.ConnectionSingleton;

public class QuestionDAO implements DAO<Question> {

	private final String QUERY_ALL = "SELECT * FROM question";
	private final String QUERY_CREATE = "INSERT INTO question (quest,args,ans1,ans2,ans3,ans4) VALUES (?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM question WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE question SET args=?, quest=?, ans1=?, ans2=?, ans3=?, ans4=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM question WHERE id=?";

	public QuestionDAO() {

	}

	public List<Question> getAll() {
		List<Question> questionsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Question question;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String args = resultSet.getString("args");
				String quest = resultSet.getString("quest");
				String ans1 = resultSet.getString("ans1");
				String ans2 = resultSet.getString("ans2");
				String ans3 = resultSet.getString("ans3");
				String ans4 = resultSet.getString("ans4");
				question = new Question(args,quest,ans1,ans2,ans3,ans4);
			    question.setId(id);
				questionsList.add(question);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questionsList;
	}

	public boolean insert(Question questionToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, questionToInsert.getArgs());
			preparedStatement.setString(2, questionToInsert.getQuest());
			preparedStatement.setString(3, questionToInsert.getAns1());
            preparedStatement.setString(4, questionToInsert.getAns2());
            preparedStatement.setString(5, questionToInsert.getAns3());
			preparedStatement.setString(6, questionToInsert.getAns4());


			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Question read(int questionId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, questionId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String args, quest, ans1, ans2, ans3, ans4;

			args = resultSet.getString("args");
			quest = resultSet.getString("quest");
			ans1 = resultSet.getString("ans1");
			ans2 = resultSet.getString("ans2");
			ans3 = resultSet.getString("ans3");
			ans4 = resultSet.getString("ans4");

			Question question = new Question(args, quest, ans1, ans2, ans3, ans4);
			question.setId(resultSet.getInt("id"));

			return question;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Question questionToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (questionToUpdate.getId() == 0)
			return false;

		Question questionRead = read(questionToUpdate.getId());
		if (!questionRead.equals(questionToUpdate)) {
			try {
				// Fill the questionToUpdate object
				if (questionToUpdate.getArgs() == null || questionToUpdate.getArgs().equals("")) {
					questionToUpdate.setArgs(questionRead.getArgs());
				}
				if (questionToUpdate.getArgs() == null || questionToUpdate.getArgs().equals("")) {
					questionToUpdate.setQuest(questionRead.getQuest());
				}
				if (questionToUpdate.getArgs() == null || questionToUpdate.getArgs().equals("")) {
					questionToUpdate.setAns1(questionRead.getAns1());
				}
				if (questionToUpdate.getArgs() == null || questionToUpdate.getArgs().equals("")) {
					questionToUpdate.setAns2(questionRead.getAns2());
				}
				if (questionToUpdate.getArgs() == null || questionToUpdate.getArgs().equals("")) {
					questionToUpdate.setAns3(questionRead.getAns3());
				}
                if (questionToUpdate.getArgs() == null || questionToUpdate.getArgs().equals("")) {
					questionToUpdate.setAns4(questionRead.getAns4());
				}


				// Update the question
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, questionToUpdate.getArgs());
				preparedStatement.setString(2, questionToUpdate.getQuest());
				preparedStatement.setString(3, questionToUpdate.getAns1());
				preparedStatement.setString(4, questionToUpdate.getAns2());
				preparedStatement.setString(5, questionToUpdate.getAns3());
				preparedStatement.setString(6, questionToUpdate.getAns4());
                preparedStatement.setInt(7, questionToUpdate.getId());
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
